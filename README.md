# JavaLLM C++ Presets
![llama.cpp b1112](https://img.shields.io/badge/llama.cpp-%23b1112-informational)

## Java Binding for [LLaMA.cpp](https://github.com/ggerganov/llama.cpp)
### Build Instructions
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
        <version>0.0.4</version>
    </dependency>

    <dependency>
        <groupId>org.javallm</groupId>
        <artifactId>llamacpp-platform</artifactId>
        <version>0.0.4</version>
    </dependency>
</dependencies>
```
