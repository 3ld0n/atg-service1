export JAVA_HOME=/home/david/jdk1.8.0_45
export PATH=$JAVA_HOME/bin:$PATH
mvn clean dependency:copy-dependencies
mvn package
