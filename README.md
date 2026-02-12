# Docker CLI (GraalVM Native Image + Picocli)

A Docker-inspired CLI built with [picocli](https://picocli.info/) and [GraalVM Native Image](https://www.graalvm.org/latest/reference-manual/native-image/).

## Prerequisites

- [GraalVM JDK](https://www.graalvm.org/downloads/) (with `native-image` installed)
- Maven 3.6+

## Build

```bash
mvn -Pnative -DskipTests package
```

If your Maven uses a corporate Nexus that doesn't include GraalVM artifacts, use:

```bash
mvn -s settings-oss.xml -Pnative -DskipTests package
```

## Run

**Native executable** (after building with `-Pnative`):
```bash
./target/dockercli
./target/dockercli -h
./target/dockercli -V
```

**JAR** (requires picocli on classpath):
```bash
mvn package -DskipTests
java -cp "target/dockercli-1.0.0-SNAPSHOT.jar:$(mvn dependency:build-classpath -q -DincludeScope=compile -Dmdep.outputFile=/dev/stdout)" com.examples.graalvm.DockerCli -h
```

## Project Structure

```
src/main/java/com/examples/graalvm/
└── DockerCli.java          # Picocli @Command entry point

src/main/resources/META-INF/native-image/
└── com.examples/dockercli/
    └── reachability-metadata.json   # GraalVM reflection config for picocli
```
