$fileDir = Split-Path -Parent $MyInvocation.MyCommand.Path
cd $fileDir
java '-Dtalend.component.manager.m2.repository=%cd%/../lib' '-Xms256M' '-Xmx1024M' '-Dfile.encoding=UTF-8' -cp '.;../lib/routines.jar;../lib/log4j-slf4j-impl-2.12.1.jar;../lib/log4j-api-2.12.1.jar;../lib/log4j-core-2.12.1.jar;../lib/log4j-1.2-api-2.12.1.jar;../lib/commons-collections-3.2.2.jar;../lib/commons-lang-2.6.jar;../lib/httpcore-4.4.4.jar;../lib/commons-codec-1.9.jar;../lib/hadoop-auth-2.6.0-cdh5.12.1.jar;../lib/jersey-core-1.9.jar;../lib/hadoop-hdfs-2.6.0-cdh5.12.1.jar;../lib/postgresql-42.2.9.jar;../lib/jackson-mapper-asl-1.9.14-TALEND.jar;../lib/commons-logging-1.2.jar;../lib/slf4j-api-1.7.25.jar;../lib/httpclient-4.5.2.jar;../lib/avro-1.7.6-cdh5.12.1.jar;../lib/commons-configuration-1.6.jar;../lib/servlet-api-2.5.jar;../lib/commons-cli-1.2.jar;../lib/hadoop-common-2.6.0-cdh5.12.1.jar;../lib/dom4j-2.1.1.jar;../lib/htrace-core4-4.0.1-incubating.jar;../lib/jackson-core-asl-1.9.14-TALEND.jar;../lib/crypto-utils.jar;../lib/guava-12.0.1.jar;../lib/protobuf-java-2.5.0.jar;patient_extrac_0_1.jar;' bigdata_project.patient_extrac_0_1.Patient_Extrac  $args