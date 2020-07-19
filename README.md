# org.seniorglez.karumiCodeTest
A simple javaFX app with a full logging system which mockes the network connections.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

As long the target of this project is only desktop runing on the jvm we only need to use maven to work with it. You can check how to intall maven on your OS directly on the [maven documentation](https://maven.apache.org/install.html).


### How to compile and run the project

To run a JavaFX projet like this with out the help of a build automation tool you will need to pass the module path and the modules that you are using as VM options. We are working with maven so the most convinient way to work with javaFX is through the javafx-maven-plugin which handles all these options for us. This also allows us to have a better integration with owrs IDEs.

You can compile the project using the maven compiler plugin:

```
mvn compile
```

Or the javafx-maven-plugin:


```
mvn javafx:compile
```

The compiling commands are optional because when you run the project through the javafx-maven-plugin it will compile the project before it try to run it.

To run the project on your local JVM:

```
mvn javafx:run
```

## Next steps
This project is configured based on my needs, if your want to go further with it let me give you some advices.

Of course all the plugins I used are fully configurable even if the default configuration is enough for what I have done here. So, I recomend you to read the plugins documentation if you are thinking about making somethink bigger.

### Native Images
A native image is a feature of GraalVM that allow you to compile java code to a standalone executable. With this tool you can make executables for Windows, Linux and MacOS and even for iOS and Android. To get this done on the easy way I recomend you to use [client-maven-plugin](https://github.com/gluonhq/client-maven-plugin). You can find all the information you need about the plugin on its repository but if you prefer to check a project that uses this plugin you can check [this project](https://github.com/seniorglez/calculatorFX) of mine.

### Modular Project

Java 9 introduces a new level of abstaction above packages: the JPMS, Java Platform Module System. Modules provides a strong encapsulation: the packages in a module are acessible to other modules only if the module explicitly exports them. Also is usefull because the new modular JRE allows you to build a custom jre with just the modules you are using to run your apps, this will allow you to save a lot of memory and is very usefull to create native installers for java applications. I recomend you to check [JPackage](https://openjdk.java.net/jeps/343). 

But if you just want to get an executable as long the project is modular you can use the javafx-maven-plugin to build a jlink too:

```
mvn javafx:jlink
```


## Built With

* [Maven](https://maven.apache.org/) - The build automation tool
* [OpenJavaFX](https://openjfx.io/) - An open source, next generation client application platform for desktop, mobile and embedded systems built on Java.
* [javafx-maven-plugin](https://github.com/openjfx/javafx-maven-plugin) - The javaFX plugin  which allows to compile and run javaFX 11 or higher projets.
* [jackson-databind](https://github.com/FasterXML/jackson-databind) - The json processor.
* [JUnit5](https://github.com/junit-team/junit5) - The popular unit testing library for the JVM platform.
* [TestFX](https://github.com/TestFX/TestFX) - A simple library for testing JavaFX apps with support for JUnit.
* [Mockito](https://github.com/mockito/mockito) - The popular mocking framework written in Java.

## Contributing

As long this is a personal test I am not acepting any pull request, I hope you understand. But, anyway you can still fork it. If you do, please let me know :stuck_out_tongue_winking_eye:.


## Authors

* **Diego Dominguez**   <a href="https://twitter.com/DGlez1111" target="_blank">
    <img alt="Twitter: DGlez1111" src="https://img.shields.io/twitter/follow/DGlez1111.svg?style=social" />
  </a>

## License

The MIT License (MIT)

Copyright (c) 2020 Diego Domínguez González

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
