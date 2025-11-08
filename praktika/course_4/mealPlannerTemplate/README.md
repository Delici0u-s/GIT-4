# How to compile<br>

First: 
* Move to the directory inwhich `pom.xml` is present (and stay there)

<br>

on first time compiling:
  * update source and target version in `pom.xml` to meet installed jdk version (groupId: `org.apache.maven.plugins`)
  * `mvn clean`

To compile:
  * `mvn package dependency:copy-dependencies -DoutputDirectory=target/dependency`

To run:
  * `java -cp "target/classes;target/dependency/*" hsd.inflab.smp.Main`