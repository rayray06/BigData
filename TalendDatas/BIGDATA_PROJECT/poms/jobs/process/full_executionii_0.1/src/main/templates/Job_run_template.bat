%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository="%cd%/../lib" -Xms256M -Xmx1024M -Dfile.encoding=UTF-8 -cp .;../lib/routines.jar;../lib/log4j-slf4j-impl-2.12.1.jar;../lib/log4j-api-2.12.1.jar;../lib/log4j-core-2.12.1.jar;../lib/log4j-1.2-api-2.12.1.jar;../lib/commons-collections-3.2.2.jar;../lib/commons-lang-2.6.jar;../lib/commons-collections-3.2.2.jar;../lib/commons-lang-2.6.jar;../lib/commons-collections-3.2.2.jar;../lib/commons-lang-2.6.jar;../lib/geronimo-stax-api_1.0_spec-1.0.1.jar;../lib/commons-collections-3.2.2.jar;../lib/datanucleus-api-jdo-3.2.6.jar;../lib/libfb303-0.9.3.jar;../lib/httpclient-4.5.2.jar;../lib/hadoop-yarn-api-2.6.0-cdh5.12.1.jar;../lib/httpclient-4.5.2.jar;../lib/httpclient-4.5.2.jar;../lib/curator-client-2.6.0.jar;../lib/servlet-api-2.5.jar;../lib/servlet-api-2.5.jar;../lib/servlet-api-2.5.jar;../lib/derby-10.11.1.1.jar;../lib/advancedPersistentLookupLib-1.2.jar;../lib/jackson-module-paranamer-2.6.7.jar;../lib/htrace-core-3.2.0-incubating.jar;../lib/poi-ooxml-4.1.0-20190523141255_modified_talend.jar;../lib/hadoop-mapreduce-client-jobclient-2.6.0-cdh5.12.1.jar;../lib/commons-codec-1.9.jar;../lib/commons-codec-1.9.jar;../lib/commons-codec-1.9.jar;../lib/poi-scratchpad-4.1.0-20190523141255_modified_talend.jar;../lib/hadoop-auth-2.6.0-cdh5.12.1.jar;../lib/hadoop-auth-2.6.0-cdh5.12.1.jar;../lib/hadoop-mapreduce-client-core-2.6.0-cdh5.12.1.jar;../lib/hadoop-auth-2.6.0-cdh5.12.1.jar;../lib/hadoop-hdfs-2.6.0-cdh5.12.1.jar;../lib/hadoop-hdfs-2.6.0-cdh5.12.1.jar;../lib/jackson-databind-2.6.7.1.jar;../lib/hadoop-hdfs-2.6.0-cdh5.12.1.jar;../lib/jackson-mapper-asl-1.9.14-TALEND.jar;../lib/jackson-mapper-asl-1.9.14-TALEND.jar;../lib/jackson-mapper-asl-1.9.14-TALEND.jar;../lib/commons-logging-1.2.jar;../lib/commons-logging-1.2.jar;../lib/commons-logging-1.2.jar;../lib/simpleexcel-2.2-20190722.jar;../lib/commons-configuration-1.6.jar;../lib/commons-configuration-1.6.jar;../lib/commons-configuration-1.6.jar;../lib/antlr-runtime-3.4.jar;../lib/hive-jdbc-1.1.0-cdh5.12.1.jar;../lib/jackson-core-2.6.7.jar;../lib/jboss-serialization.jar;../lib/hive-metastore-1.1.0-cdh5.12.1.jar;../lib/hadoop-mapreduce-client-common-2.6.0-cdh5.12.1.jar;../lib/hadoop-common-2.6.0-cdh5.12.1.jar;../lib/hadoop-common-2.6.0-cdh5.12.1.jar;../lib/hadoop-common-2.6.0-cdh5.12.1.jar;../lib/poi-4.1.0-20190523141255_modified_talend.jar;../lib/curator-framework-2.6.0.jar;../lib/libthrift-0.9.2.jar;../lib/crypto-utils.jar;../lib/guava-12.0.1.jar;../lib/guava-12.0.1.jar;../lib/guava-12.0.1.jar;../lib/commons-compress-1.19.jar;../lib/httpcore-4.4.4.jar;../lib/httpcore-4.4.4.jar;../lib/httpcore-4.4.4.jar;../lib/jersey-core-1.9.jar;../lib/jersey-core-1.9.jar;../lib/jersey-core-1.9.jar;../lib/postgresql-42.2.9.jar;../lib/slf4j-api-1.7.25.jar;../lib/jackson-annotations-2.6.7.jar;../lib/hadoop-yarn-server-web-proxy-2.6.0-cdh5.12.1.jar;../lib/xmlbeans-3.1.0.jar;../lib/avro-1.7.6-cdh5.12.1.jar;../lib/avro-1.7.6-cdh5.12.1.jar;../lib/jersey-client-1.9.jar;../lib/avro-1.7.6-cdh5.12.1.jar;../lib/hadoop-yarn-common-2.6.0-cdh5.12.1.jar;../lib/commons-collections4-4.1.jar;../lib/datanucleus-core-3.2.10.jar;../lib/commons-cli-1.2.jar;../lib/commons-cli-1.2.jar;../lib/hadoop-yarn-client-2.6.0-cdh5.12.1.jar;../lib/commons-cli-1.2.jar;../lib/jdo-api-3.0.1.jar;../lib/hive-exec-1.1.0-cdh5.12.1.jar;../lib/talendcsv.jar;../lib/commons-httpclient-3.0.1.jar;../lib/hive-service-1.1.0-cdh5.12.1.jar;../lib/jackson-xc-1.9.13.jar;../lib/datanucleus-rdbms-3.2.9.jar;../lib/poi-ooxml-schemas-4.1.0-20190523141255_modified_talend.jar;../lib/commons-math3-3.6.1.jar;../lib/commons-io-2.4.jar;../lib/commons-net-2.2.jar;../lib/joda-time-2.9.3.jar;../lib/dom4j-2.1.1.jar;../lib/htrace-core4-4.0.1-incubating.jar;../lib/htrace-core4-4.0.1-incubating.jar;../lib/htrace-core4-4.0.1-incubating.jar;../lib/jackson-core-asl-1.9.14-TALEND.jar;../lib/jackson-core-asl-1.9.14-TALEND.jar;../lib/jackson-core-asl-1.9.14-TALEND.jar;../lib/trove.jar;../lib/zookeeper-3.4.5-cdh5.12.1.jar;../lib/talend_file_enhanced_20070724.jar;../lib/jackson-jaxrs-1.9.13.jar;../lib/protobuf-java-2.5.0.jar;../lib/protobuf-java-2.5.0.jar;../lib/protobuf-java-2.5.0.jar;full_executionii_0_1.jar;staging_visite_0_1.jar;prof_extrac_0_1.jar;diag_extrac_0_1.jar;dim_diagnostic_0_1.jar;stage_rdv_0_1.jar;consu_extrac_0_1.jar;region_extrac_0_1.jar;esatis_e_0_1.jar;stage_hosco_0_1.jar;stage_death_0_1.jar;fact_satisfaction_0_1.jar;dim_prof_0_1.jar;dim_etablissement_0_1.jar;patient_extrac_0_1.jar;dim_rdv_0_1.jar;visite_0_1.jar;dim_patient_0_1.jar;dim_region_0_1.jar;fact_hosco_0_1.jar;rdv_extrac_0_1.jar;extract_visite_0_1.jar;stage_patient_0_1.jar;dim_death_0_1.jar;death_fetch_0_1.jar;etab_extrac_0_1.jar;stage_sati_0_1.jar;hosconew_0_1.jar;hospitalisation_0_1.jar; bigdata_project.full_executionii_0_1.Full_ExecutionII  %*