#!/bin/sh
cd `dirname $0`
ROOT_PATH=`pwd`
java -Dtalend.component.manager.m2.repository=$ROOT_PATH/../lib -Xms256M -Xmx1024M -Dfile.encoding=UTF-8 -cp .:$ROOT_PATH:$ROOT_PATH/../lib/routines.jar:$ROOT_PATH/../lib/log4j-slf4j-impl-2.12.1.jar:$ROOT_PATH/../lib/log4j-api-2.12.1.jar:$ROOT_PATH/../lib/log4j-core-2.12.1.jar:$ROOT_PATH/../lib/log4j-1.2-api-2.12.1.jar:$ROOT_PATH/../lib/commons-collections-3.2.2.jar:$ROOT_PATH/../lib/commons-lang-2.6.jar:$ROOT_PATH/../lib/datanucleus-api-jdo-3.2.6.jar:$ROOT_PATH/../lib/httpcore-4.4.4.jar:$ROOT_PATH/../lib/libfb303-0.9.3.jar:$ROOT_PATH/../lib/jersey-core-1.9.jar:$ROOT_PATH/../lib/slf4j-api-1.7.25.jar:$ROOT_PATH/../lib/hadoop-yarn-api-2.6.0-cdh5.12.1.jar:$ROOT_PATH/../lib/httpclient-4.5.2.jar:$ROOT_PATH/../lib/curator-client-2.6.0.jar:$ROOT_PATH/../lib/jackson-annotations-2.6.7.jar:$ROOT_PATH/../lib/hadoop-yarn-server-web-proxy-2.6.0-cdh5.12.1.jar:$ROOT_PATH/../lib/avro-1.7.6-cdh5.12.1.jar:$ROOT_PATH/../lib/jersey-client-1.9.jar:$ROOT_PATH/../lib/hadoop-yarn-common-2.6.0-cdh5.12.1.jar:$ROOT_PATH/../lib/datanucleus-core-3.2.10.jar:$ROOT_PATH/../lib/servlet-api-2.5.jar:$ROOT_PATH/../lib/derby-10.11.1.1.jar:$ROOT_PATH/../lib/commons-cli-1.2.jar:$ROOT_PATH/../lib/hadoop-yarn-client-2.6.0-cdh5.12.1.jar:$ROOT_PATH/../lib/jdo-api-3.0.1.jar:$ROOT_PATH/../lib/hive-exec-1.1.0-cdh5.12.1.jar:$ROOT_PATH/../lib/jackson-module-paranamer-2.6.7.jar:$ROOT_PATH/../lib/commons-httpclient-3.0.1.jar:$ROOT_PATH/../lib/htrace-core-3.2.0-incubating.jar:$ROOT_PATH/../lib/hive-service-1.1.0-cdh5.12.1.jar:$ROOT_PATH/../lib/hadoop-mapreduce-client-jobclient-2.6.0-cdh5.12.1.jar:$ROOT_PATH/../lib/jackson-xc-1.9.13.jar:$ROOT_PATH/../lib/commons-codec-1.9.jar:$ROOT_PATH/../lib/datanucleus-rdbms-3.2.9.jar:$ROOT_PATH/../lib/hadoop-auth-2.6.0-cdh5.12.1.jar:$ROOT_PATH/../lib/hadoop-mapreduce-client-core-2.6.0-cdh5.12.1.jar:$ROOT_PATH/../lib/hadoop-hdfs-2.6.0-cdh5.12.1.jar:$ROOT_PATH/../lib/jackson-databind-2.6.7.1.jar:$ROOT_PATH/../lib/jackson-mapper-asl-1.9.14-TALEND.jar:$ROOT_PATH/../lib/commons-logging-1.2.jar:$ROOT_PATH/../lib/commons-configuration-1.6.jar:$ROOT_PATH/../lib/antlr-runtime-3.4.jar:$ROOT_PATH/../lib/commons-io-2.4.jar:$ROOT_PATH/../lib/commons-net-2.2.jar:$ROOT_PATH/../lib/hive-jdbc-1.1.0-cdh5.12.1.jar:$ROOT_PATH/../lib/jackson-core-2.6.7.jar:$ROOT_PATH/../lib/hive-metastore-1.1.0-cdh5.12.1.jar:$ROOT_PATH/../lib/hadoop-mapreduce-client-common-2.6.0-cdh5.12.1.jar:$ROOT_PATH/../lib/hadoop-common-2.6.0-cdh5.12.1.jar:$ROOT_PATH/../lib/joda-time-2.9.3.jar:$ROOT_PATH/../lib/dom4j-2.1.1.jar:$ROOT_PATH/../lib/curator-framework-2.6.0.jar:$ROOT_PATH/../lib/htrace-core4-4.0.1-incubating.jar:$ROOT_PATH/../lib/jackson-core-asl-1.9.14-TALEND.jar:$ROOT_PATH/../lib/libthrift-0.9.2.jar:$ROOT_PATH/../lib/zookeeper-3.4.5-cdh5.12.1.jar:$ROOT_PATH/../lib/crypto-utils.jar:$ROOT_PATH/../lib/jackson-jaxrs-1.9.13.jar:$ROOT_PATH/../lib/guava-12.0.1.jar:$ROOT_PATH/../lib/protobuf-java-2.5.0.jar:$ROOT_PATH/dim_diagnostic_0_1.jar: bigdata_project.dim_diagnostic_0_1.Dim_Diagnostic  "$@"