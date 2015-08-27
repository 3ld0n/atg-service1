export JAVA_HOME=/home/david/jdk1.8.0_45
export PATH=$JAVA_HOME/bin:$PATH
export CLASSPATH=target/*:WebContent/WEB-INF
echo $CLASSPATH
java atg.src.AtgService1Controller
