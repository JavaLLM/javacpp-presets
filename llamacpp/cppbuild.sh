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

#cp -r ~/Downloads/llama.cpp-master-8207214 .
cd llama.cpp-$VERSION

# build library
echo "Building LLaMA.cpp library..."

make -j8 ggml.o llama.o ggml-alloc.o k_quants.o
ar src libggml.a ggml.o k_quants.o ggml-alloc.o
ar src libllama.a ggml.o k_quants.o ggml-alloc.o llama.o

# copy lib and header files
cp libggml.a libllama.a ../lib
cp ggml.h llama.h ggml-alloc.h ../include

# k_quants.h cannot be properly handled, disable this feature temporally
sed 's/ restrict / /g' k_quants.h > k_quants-modified.h
cp k_quants-modified.h ../include/k_quants.h