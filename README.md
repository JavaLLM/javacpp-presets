# Java Binding for [LLaMA.cpp](https://github.com/ggerganov/llama.cpp)
![llama.cpp b1112](https://img.shields.io/badge/llama.cpp-%23b1187-informational)

## Introduction
This is the [javacpp](https://github.com/bytedeco/javacpp) preset, which provides a complete java API for the [LLaMA.cpp](https://github.com/ggerganov/llama.cpp) project. The main goal of LLaMA.cpp is to run LLMs (i.e., Large Language Models) on consumer-grade devices such as your Mac or PC.

> [!IMPORTANT]
> This project is still under active development, please do not use it directly in production. PRs are always welcome!

## Build Instructions
> [!IMPORTANT]
> Currently this binding only works on Mac with Apple Silicon,
> support for other major platforms (i.e., Linux, Windows etc.) is yet to come very soon!
> Please stay tuned.

In the project root, run the following commands to build and install the related jars to your local machine:
```shell
mvn clean install --projects .,llamacpp
mvn clean install -f platform --projects ../llamacpp/platform -Djavacpp.platform.host
```
Then, in order to use LLaMA APIs in your project, you should add the following dependencies in your `pom.xml`:
```xml
<dependencies>
    <dependency>
        <groupId>org.javallm</groupId>
        <artifactId>llamacpp</artifactId>
        <version>0.0.6-SNAPSHOT</version>
    </dependency>

    <dependency>
        <groupId>org.javallm</groupId>
        <artifactId>llamacpp-platform</artifactId>
        <version>0.0.6-SNAPSHOT</version>
    </dependency>
</dependencies>
```

## Acknowledgements
I really appreciate bytedeco for their awesome project [javacpp](https://github.com/bytedeco/javacpp). 🥳 JavaLLM is built upon on the giant javacpp's shoulder, please give them a generous star if you found JavaLLM useful!