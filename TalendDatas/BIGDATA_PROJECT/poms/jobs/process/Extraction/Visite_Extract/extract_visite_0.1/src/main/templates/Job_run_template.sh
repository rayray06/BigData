#!/bin/sh
cd `dirname $0`
ROOT_PATH=`pwd`
java -Dtalend.component.manager.m2.repository=$ROOT_PATH/../lib -Xms256M -Xmx1024M -Dfile.encoding=UTF-8 -cp .:$ROOT_PATH:$ROOT_PATH/../lib/routines.jar:$ROOT_PATH/../lib/log4j-slf4j-impl-2.12.1.jar:$ROOT_PATH/../lib/log4j-api-2.12.1.jar:$ROOT_PATH/../lib/log4j-core-2.12.1.jar:$ROOT_PATH/../lib/log4j-1.2-api-2.12.1.jar:$ROOT_PATH/../lib/commons-collections-3.2.2.jar:$ROOT_PATH/../lib/commons-lang-2.6.jar:$ROOT_PATH/../lib/httpcore-4.4.4.jar:$ROOT_PATH/../lib/commons-codec-1.9.jar:$ROOT_PATH/../lib/hadoop-auth-2.6.0-cdh5.12.1.jar:$ROOT_PATH/../lib/jersey-core-1.9.jar:$ROOT_PATH/../lib/hadoop-hdfs-2.6.0-cdh5.12.1.jar:$ROOT_PATH/../lib/jackson-mapper-asl-1.9.14-TALEND.jar:$ROOT_PATH/../lib/commons-logging-1.2.jar:$ROOT_PATH/../lib/slf4j-api-1.7.25.jar:$ROOT_PATH/../lib/httpclient-4.5.2.jar:$ROOT_PATH/../lib/avro-1.7.6-cdh5.12.1.jar:$ROOT_PATH/../lib/commons-configuration-1.6.jar:$ROOT_PATH/../lib/servlet-api-2.5.jar:$ROOT_PATH/../lib/commons-cli-1.2.jar:$ROOT_PATH/../lib/hadoop-common-2.6.0-cdh5.12.1.jar:$ROOT_PATH/../lib/dom4j-2.1.1.jar:$ROOT_PATH/../lib/htrace-core4-4.0.1-incubating.jar:$ROOT_PATH/../lib/jackson-core-asl-1.9.14-TALEND.jar:$ROOT_PATH/../lib/talendcsv.jar:$ROOT_PATH/../lib/crypto-utils.jar:$ROOT_PATH/../lib/talend_file_enhanced_20070724.jar:$ROOT_PATH/../lib/guava-12.0.1.jar:$ROOT_PATH/../lib/protobuf-java-2.5.0.jar:$ROOT_PATH/extract_visite_0_1.jar: bigdata_project.extract_visite_0_1.Extract_Visite  --context=Default "$@"