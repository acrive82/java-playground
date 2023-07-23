# Java Playground

## How to run

1. Install maven and java 20 (jdk)
2. Set JAVA_HOME to the jdk path (e.g. `export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64`)
3. Under web folder, execute `mvn spring-boot:run`

## Testing

1. HTTP file under web folder, for testing.

## Issue

| Issue                                                               | Solution                                                                 |
|---------------------------------------------------------------------|--------------------------------------------------------------------------|
| Fatal error compiling: error: invalid target release: 20 -> [Help 1 | Need to set JAVA_HOME. The env var JAVA_HOME should point to the jdk 20. |


