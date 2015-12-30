export LIBTHRIFT=/root/ApacheThrift2/thrift/lib/java
export MAVENTHRIFT=/root/.m2/repository/org/apache/thrift/libthrift/0.7.0/
echo $LIBTHRIFT
cd $LIBTHRIFT
ant
cp -av build/libthrift-1.0.0.jar $MAVENTHRIFT
cd $MAVENTHRIFT
mv libthrift-1.0.0.jar libthrift-0.7.0.jar -v

