#  mvn clean install --projects ..llamacpp
#  mvn clean install -f platform --projects ../llamacpp/platform -Djavacpp.platform.host

#!/bin/bash
# This file is meant to be included by the parent cppbuild.sh script
if [[ -z "$PLATFORM" ]]; then
    pushd ..
    bash cppbuild.sh "$@" llamacpp
    popd
    exit
fi

mkdir -p $PLATFORM
cd $PLATFORM
INSTALL_PATH=`pwd`
mkdir -p include lib bin

# fetch llama.cpp source code
echo "Downloading files from LLaMA.cpp..."
download https://github.com/ggerganov/llama.cpp/archive/refs/tags/$VERSION.zip llama.cpp-$VERSION.zip
echo "Decompressing archives..."

if [ -d "llama.cpp-$VERSION" ]; then
  echo "Zip file exist, skipped..."
else
  unzip llama.cpp-$VERSION.zip
fi

#cp -r ~/Downloads/llama.cpp-$VERSION .
cd llama.cpp-$VERSION

# apply patch
echo "Patching ggml-metal.m..."
cp ../../../misc/patch/ggml-metal-patched.m ggml-metal.m

# build library
echo "Building LLaMA.cpp library..."

mkdir -p build
cd build
cmake .. -DBUILD_SHARED_LIBS=ON -DLLAMA_METAL=ON -DCMAKE_INSTALL_PREFIX=$INSTALL_PATH
make -j8
make install
cd ..

cp ggml.h ggml-alloc.h ggml-metal.h ../include
cp llama.h ../include

# k_quants.h cannot be properly handled, disable this feature temporally
sed 's/ restrict / /g' k_quants.h > k_quants-modified.h
cp k_quants-modified.h ../include/k_quants.h