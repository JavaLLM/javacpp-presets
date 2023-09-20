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

mkdir -p "$PLATFORM"
cd "$PLATFORM"
INSTALL_PATH=$(pwd)
mkdir -p include lib bin

# fetch llama.cpp source code
SRC_DIR=llama.cpp-"$VERSION"

echo "Downloading files from LLaMA.cpp..."
download https://github.com/ggerganov/llama.cpp/archive/refs/tags/"$VERSION".zip "$SRC_DIR".zip
echo "Decompressing archives..."

if [ -d "$SRC_DIR" ]; then
  echo "Zip file exist, skipped..."
else
  unzip "$SRC_DIR".zip
fi

#cp -r ~/Downloads/llama.cpp-$VERSION .
cd "$SRC_DIR"

# copy header files to be parsed by javacpp
cp ggml.h llama.h ../include

# apply patch
echo "Patching ggml-metal.m..."
cp ../../../misc/patch/ggml-metal-patched.m ggml-metal.m

# build library
echo "Building LLaMA.cpp library..."

mkdir -p build && cd build

case $PLATFORM in
  windows-*)
    cmake .. -DBUILD_SHARED_LIBS=ON -DLLAMA_BUILD_EXAMPLES=OFF -DLLAMA_BUILD_TESTS=OFF -DLLAMA_AVX=ON -DLLAMA_AVX2=ON
    ;;
  linux-*)
    cmake .. -DBUILD_SHARED_LIBS=ON -DLLAMA_BUILD_EXAMPLES=OFF -DLLAMA_BUILD_TESTS=OFF -DLLAMA_AVX=ON -DLLAMA_AVX2=ON
    ;;
  macosx-*)
    cmake .. -DBUILD_SHARED_LIBS=ON -DLLAMA_METAL=ON -DLLAMA_BUILD_EXAMPLES=OFF -DLLAMA_BUILD_TESTS=OFF
    ;;
esac

cmake --build . --parallel 8 --config Release
cmake --install . --prefix="$INSTALL_PATH"

echo "Successfully built llama.cpp dynamic library"
