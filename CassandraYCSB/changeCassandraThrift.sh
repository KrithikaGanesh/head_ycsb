export LIB_Cassandra=/root/Cassandra_Team/CassandraQoS/cassandra
export MAVEN_Cassandra=/root/.m2/repository/org/apache/cassandra/cassandra-thrift/1.2.9/
cd $LIB_Cassandra
ant jar 
cp -av build/apache-cassandra-thrift-2.0.16*.jar $MAVEN_Cassandra
cd $MAVEN_Cassandra
mv apache-cassandra-thrift-2.0.16*.jar cassandra-thrift-1.2.9.jar -v
