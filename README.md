### Add monitoring without modifying the application

Seamless integration of [Stagemonitor](http://www.stagemonitor.org/) monitoring tool with [Spring Boot](https://projects.spring.io/spring-boot/) application. 

> Useful if you don't want to require the developers to integrate Stagemonitor into the application.

Get all required Stagemonitor [dependencies](https://github.com/felixbarny/stagemonitor-get-all-libs.git):

```bash
git clone https://github.com/felixbarny/stagemonitor-get-all-libs.git
cd stagemonitor-get-all-libs
./gradlew copyLibs -PstagemonitorVersion=[VERSION]
#replace [VERSION] with the version you want to use
```

Create configuration file `stagemonitor.properties` or use the other available [configuration options](https://github.com/stagemonitor/stagemonitor/wiki/Configuration-Options).

Put all the dependencies with configuration and integration jar on the classpath *(-cp)* or update application's jar:

```bash
jar uf0P application.jar -C /path-to-dependencies-and-configuration/ ./
```

> Note: double check that dependencies are placed to `/lib` folder for Spring Boot version <= 1.3 and `/BOOT-INF/lib` for Spring Boot version >= 1.4

Run the application as usual.