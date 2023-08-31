# JavaLLM C++ Presets

## LLaMA.cpp (Currently only works on Mac)
### Build Instructions
In the project root, run the following commands to build and install related Jars to your local machine:
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