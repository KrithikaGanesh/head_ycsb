python2.7 ./bin/ycsb run cassandra-10 -threads 5 -p hosts=10.10.1.69 -p fieldcount=20 -p operationcount=2000 -p recordcount=10 -P workloads/workloadc -s > try | tee runlog
