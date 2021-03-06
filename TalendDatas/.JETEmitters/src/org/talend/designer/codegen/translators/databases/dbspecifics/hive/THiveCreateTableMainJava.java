package org.talend.designer.codegen.translators.databases.dbspecifics.hive;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.MappingTypeRetriever;
import org.talend.core.model.metadata.MetadataTalendType;
import org.talend.designer.runprocess.ProcessorException;
import org.talend.designer.runprocess.ProcessorUtilities;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class THiveCreateTableMainJava
{
  protected static String nl;
  public static synchronized THiveCreateTableMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THiveCreateTableMainJava result = new THiveCreateTableMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tlog.debug(\"";
  protected final String TEXT_2 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_4 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_5 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_6 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_7 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_8 = " - Written records count: \" + nb_line_";
  protected final String TEXT_9 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_10 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_11 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_12 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_13 = " - Writing the record \" + nb_line_";
  protected final String TEXT_14 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_15 = " - Processing the record \" + nb_line_";
  protected final String TEXT_16 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_17 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_18 = NL + "\t\t\t\tif(conn_";
  protected final String TEXT_19 = " != null) {" + NL + "\t\t\t\t\tif(conn_";
  protected final String TEXT_20 = ".getMetaData() != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_22 = " - Uses an existing connection ";
  protected final String TEXT_23 = ".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_25 = " - Uses an existing connection with username '\" + conn_";
  protected final String TEXT_26 = ".getMetaData().getUserName() + \"'. Connection URL: \" + conn_";
  protected final String TEXT_27 = ".getMetaData().getURL() + \".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_28 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_29 = NL + "\t\t\tconn_";
  protected final String TEXT_30 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_31 = ", dbUser_";
  protected final String TEXT_32 = ", dbPwd_";
  protected final String TEXT_33 = ");" + NL + "\t\t\t";
  protected final String TEXT_34 = ".rollback();" + NL + "\t\t\t";
  protected final String TEXT_35 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_36 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_37 = NL + "\t\t\tif(\"com.mysql.cj.jdbc.Driver\".equals((String)globalMap.get(\"driverClass_";
  protected final String TEXT_38 = "\"))" + NL + "\t\t\t    && routines.system.BundleUtils.inOSGi()) {" + NL + "\t\t\t        Class.forName(\"com.mysql.cj.jdbc.AbandonedConnectionCleanupThread\")." + NL + "\t\t\t            getMethod(\"checkedShutdown\").invoke(null, (Object[]) null);" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t\tconn_";
  protected final String TEXT_40 = ".setAutoCommit(";
  protected final String TEXT_41 = NL + "\t\t\t\tlog.";
  protected final String TEXT_42 = "(\"";
  protected final String TEXT_43 = " - \" + ";
  protected final String TEXT_44 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_45 = NL + "\t    \t\tlog.";
  protected final String TEXT_46 = "\");" + NL + "\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\t\tpstmt_";
  protected final String TEXT_48 = ".executeBatch();" + NL + "\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\t\tint countSum_";
  protected final String TEXT_50 = " = 0;" + NL + "\t\t\t\tfor(int countEach_";
  protected final String TEXT_51 = ": pstmt_";
  protected final String TEXT_52 = ".executeBatch()) {" + NL + "\t\t\t\t\tcountSum_";
  protected final String TEXT_53 = " += (countEach_";
  protected final String TEXT_54 = " < 0 ? 0 : ";
  protected final String TEXT_55 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_56 = NL;
  protected final String TEXT_57 = NL + "\tjava.io.File localPigLatin_";
  protected final String TEXT_58 = " = new java.io.File(projectName + \"_\" + jobName + \"_\" + Thread.currentThread().getId() +\".hive\");" + NL + "\tjava.io.FileWriter fw_";
  protected final String TEXT_59 = " = new java.io.FileWriter(localPigLatin_";
  protected final String TEXT_60 = ".getAbsoluteFile());" + NL + "\tjava.io.BufferedWriter bw_";
  protected final String TEXT_61 = " = new java.io.BufferedWriter(fw_";
  protected final String TEXT_62 = ");" + NL + "\tjava.lang.StringBuilder libjars_";
  protected final String TEXT_63 = " = new StringBuilder();";
  protected final String TEXT_64 = " " + NL + "\t\t\tfinal String hdInsightPassword_";
  protected final String TEXT_65 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_66 = ");";
  protected final String TEXT_67 = NL + "\t\t\tfinal String hdInsightPassword_";
  protected final String TEXT_68 = " = ";
  protected final String TEXT_69 = "; ";
  protected final String TEXT_70 = " " + NL + "\t\t\tfinal String wasbPassword_";
  protected final String TEXT_71 = NL + "\t\t\tfinal String wasbPassword_";
  protected final String TEXT_72 = NL + "\t\torg.talend.bigdata.launcher.fs.FileSystem azureFs_";
  protected final String TEXT_73 = " = new org.talend.bigdata.launcher.fs.AzureFileSystem(\"DefaultEndpointsProtocol=https;\"" + NL + "\t\t\t+ \"AccountName=\"" + NL + "\t\t\t+ ";
  protected final String TEXT_74 = NL + "\t\t\t+ \";\"" + NL + "\t\t\t+ \"AccountKey=\" + wasbPassword_";
  protected final String TEXT_75 = ", ";
  protected final String TEXT_76 = ");" + NL + "\t\t\t\t" + NL + "\t\torg.talend.bigdata.launcher.webhcat.WebHCatJob instance_";
  protected final String TEXT_77 = " = new org.talend.bigdata.launcher.webhcat.QueryJob(azureFs_";
  protected final String TEXT_78 = ", org.talend.bigdata.launcher.utils.JobType.HIVE);" + NL + "\t\t\t\t\t\t" + NL + "\t\tinstance_";
  protected final String TEXT_79 = ".setCredentials(new org.talend.bigdata.launcher.security.HDInsightCredentials(";
  protected final String TEXT_80 = ", hdInsightPassword_";
  protected final String TEXT_81 = "));" + NL + "\t\tinstance_";
  protected final String TEXT_82 = ".setUsername(";
  protected final String TEXT_83 = ");" + NL + "\t\tinstance_";
  protected final String TEXT_84 = ".setWebhcatEndpoint(\"https\", ";
  protected final String TEXT_85 = " + \":\" + ";
  protected final String TEXT_86 = ".setStatusFolder(org.talend.bigdata.launcher.utils.Utils.removeFirstSlash(";
  protected final String TEXT_87 = ".setRemoteFolder(org.talend.bigdata.launcher.utils.Utils.removeFirstSlash(";
  protected final String TEXT_88 = "));";
  protected final String TEXT_89 = NL + "\t\torg.talend.bigdata.launcher.webhcat.WebHCatJob instance_";
  protected final String TEXT_90 = " = (org.talend.bigdata.launcher.webhcat.WebHCatJob) globalMap.get(\"conn_";
  protected final String TEXT_91 = "\");" + NL + "\t\t" + NL + "\t\torg.talend.bigdata.launcher.fs.FileSystem azureFs_";
  protected final String TEXT_92 = " = instance_";
  protected final String TEXT_93 = ".getFileSystem();\t\t" + NL + "\t\t" + NL + "\t\tjava.util.List<String> connectionCommandList_";
  protected final String TEXT_94 = " = (java.util.List<String>)globalMap.get(\"commandList_";
  protected final String TEXT_95 = "\");" + NL + "\t\tfor(String command : connectionCommandList_";
  protected final String TEXT_96 = ") {" + NL + "\t\t\tbw_";
  protected final String TEXT_97 = ".write(command);" + NL + "\t\t}";
  protected final String TEXT_98 = NL + "\t((org.talend.bigdata.launcher.webhcat.QueryJob)instance_";
  protected final String TEXT_99 = ").setFileToExecute(projectName + \"_\" + jobName + \"_\" + Thread.currentThread().getId() +\".hive\");" + NL + "\tString wasbPath_";
  protected final String TEXT_100 = " = azureFs_";
  protected final String TEXT_101 = ".getFileSystemPrefix() + \"/\"\t+ instance_";
  protected final String TEXT_102 = ".getRemoteFolder()\t+ \"/libjars/\";";
  protected final String TEXT_103 = NL + "                bw_";
  protected final String TEXT_104 = ".write(\"SET mapreduce.map.memory.mb=\" + ";
  protected final String TEXT_105 = " + \";\");" + NL + "                bw_";
  protected final String TEXT_106 = ".write(\"SET mapreduce.reduce.memory.mb=\" + ";
  protected final String TEXT_107 = ".write(\"SET yarn.app.mapreduce.am.resource.mb=\" + ";
  protected final String TEXT_108 = " + \";\");";
  protected final String TEXT_109 = NL + "                    bw_";
  protected final String TEXT_110 = ".write(\"SET \"+";
  protected final String TEXT_111 = "+\"=\"+";
  protected final String TEXT_112 = NL + "            String dbname_";
  protected final String TEXT_113 = ";" + NL + "            if(dbname_";
  protected final String TEXT_114 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_115 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_116 = ".trim())) {" + NL + "                bw_";
  protected final String TEXT_117 = ".write(\"use \" + dbname_";
  protected final String TEXT_118 = " + \";\");" + NL + "            }";
  protected final String TEXT_119 = NL + "\tjava.lang.StringBuilder libjars_";
  protected final String TEXT_120 = " = new StringBuilder();" + NL + "\tString stagingBucketPath_";
  protected final String TEXT_121 = " = \"\";";
  protected final String TEXT_122 = NL + "        java.util.List<String> connectionCommandList_";
  protected final String TEXT_123 = " = new java.util.ArrayList<String>();  ";
  protected final String TEXT_124 = NL + "            connectionCommandList_";
  protected final String TEXT_125 = ".add(\"SET mapreduce.map.memory.mb=\" + ";
  protected final String TEXT_126 = " + \";\");" + NL + "            connectionCommandList_";
  protected final String TEXT_127 = ".add(\"SET mapreduce.reduce.memory.mb=\" + ";
  protected final String TEXT_128 = ".add(\"SET yarn.app.mapreduce.am.resource.mb=\" + ";
  protected final String TEXT_129 = NL + "                connectionCommandList_";
  protected final String TEXT_130 = ".add(\"SET \"+";
  protected final String TEXT_131 = NL + NL + "        String dbname_";
  protected final String TEXT_132 = ";" + NL + "        if(dbname_";
  protected final String TEXT_133 = ".trim())) {" + NL + "            connectionCommandList_";
  protected final String TEXT_134 = ".add(\"use \" + dbname_";
  protected final String TEXT_135 = " + \";\");" + NL + "        }" + NL + "        " + NL + "        stagingBucketPath_";
  protected final String TEXT_136 = ";" + NL + "" + NL + "        org.talend.bigdata.launcher.google.dataproc.DataprocHiveJob instance_";
  protected final String TEXT_137 = " =" + NL + "            new org.talend.bigdata.launcher.google.dataproc.DataprocHiveJob.Builder()" + NL + "            .withTalendJobName(projectName + \"_\" + jobName + \"_\" + jobVersion.replace(\".\",\"_\") + \"_\" + pid)" + NL + "            .withClusterName(";
  protected final String TEXT_138 = ")" + NL + "            .withRegion(";
  protected final String TEXT_139 = ")" + NL + "            .withProjectId(";
  protected final String TEXT_140 = ")" + NL + "            .withJarsBucket(";
  protected final String TEXT_141 = ")";
  protected final String TEXT_142 = NL + "                .withServiceAccountCredentialsPath(";
  protected final String TEXT_143 = NL + NL + "            .withInitialisationQueries(connectionCommandList_";
  protected final String TEXT_144 = ")" + NL + "            .build();";
  protected final String TEXT_145 = NL + "            for (String command: connectionCommandList_";
  protected final String TEXT_146 = " ) {" + NL + "                log.debug(\"Initialization command from ";
  protected final String TEXT_147 = ": \" + command);" + NL + "            }";
  protected final String TEXT_148 = NL + "        org.talend.bigdata.launcher.google.dataproc.DataprocHiveJob instance_";
  protected final String TEXT_149 = " = (org.talend.bigdata.launcher.google.dataproc.DataprocHiveJob) globalMap.get(\"conn_";
  protected final String TEXT_150 = "\");" + NL + "        stagingBucketPath_";
  protected final String TEXT_151 = " = (String) globalMap.get(\"stagingBucket_";
  protected final String TEXT_152 = "\");" + NL + "        instance_";
  protected final String TEXT_153 = ".clearQueriesCache();" + NL + "        instance_";
  protected final String TEXT_154 = ".clearLibJars();";
  protected final String TEXT_155 = NL + "\t\t";
  protected final String TEXT_156 = " + \";\");" + NL + "        }" + NL + "" + NL + "\t \tString api_token_";
  protected final String TEXT_157 = ");" + NL + "\t" + NL + "\t\torg.talend.bigdata.launcher.qubole.QuboleHiveClient instance_";
  protected final String TEXT_158 = " =" + NL + "\t\t\tnew org.talend.bigdata.launcher.qubole.QuboleHiveClient.Builder()" + NL + "\t\t\t\t.setApiKey(api_token_";
  protected final String TEXT_159 = ")" + NL + "\t\t\t\t";
  protected final String TEXT_160 = " .setApiEndpoint(";
  protected final String TEXT_161 = ") ";
  protected final String TEXT_162 = NL + "\t\t\t\t.build();" + NL + "        ";
  protected final String TEXT_163 = NL + "        org.talend.bigdata.launcher.qubole.QuboleHiveClient instance_";
  protected final String TEXT_164 = " = (org.talend.bigdata.launcher.qubole.QuboleHiveClient) globalMap.get(\"conn_";
  protected final String TEXT_165 = "\");" + NL + "        java.util.List<String> connectionCommandList_";
  protected final String TEXT_166 = " = null;" + NL + "        if (globalMap.containsKey(\"conn_init_statements_";
  protected final String TEXT_167 = "\")) {" + NL + "        \tconnectionCommandList_";
  protected final String TEXT_168 = " = (java.util.List<String>) globalMap.get(\"conn_init_statements_";
  protected final String TEXT_169 = "\");" + NL + "        \tglobalMap.remove(\"conn_init_statements_";
  protected final String TEXT_170 = "\");" + NL + "        }";
  protected final String TEXT_171 = NL + "    \t";
  protected final String TEXT_172 = NL;
  protected final String TEXT_173 = NL + NL + "java.sql.Connection conn_";
  protected final String TEXT_174 = " = null;";
  protected final String TEXT_175 = NL + "\t\tSystem.setProperty(\"java.io.tmpdir\", ";
  protected final String TEXT_176 = NL + "\tglobalMap.put(\"current_client_path_separator\", System.getProperty(\"path.separator\"));" + NL + "\tSystem.setProperty(\"path.separator\", ";
  protected final String TEXT_177 = NL + "\t\tconn_";
  protected final String TEXT_178 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_179 = "\");" + NL + "" + NL + "\t\tString dbname_";
  protected final String TEXT_180 = " = (String)globalMap.get(\"";
  protected final String TEXT_181 = "\");" + NL + "    \tif(dbname_";
  protected final String TEXT_182 = ".trim())) {" + NL + "        \tjava.sql.Statement goToDatabase_";
  protected final String TEXT_183 = " = conn_";
  protected final String TEXT_184 = ".createStatement();" + NL + "        \tgoToDatabase_";
  protected final String TEXT_185 = ".execute(\"use \" + dbname_";
  protected final String TEXT_186 = ");" + NL + "        \tgoToDatabase_";
  protected final String TEXT_187 = ".close();" + NL + "    \t}" + NL + "" + NL + "    \tString dbUser_";
  protected final String TEXT_188 = "\");" + NL + "" + NL + "    \tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_189 = "\", System.getProperty(\"HADOOP_USER_NAME\"));" + NL + "\t\tif(dbUser_";
  protected final String TEXT_190 = "!=null && !\"\".equals(dbUser_";
  protected final String TEXT_191 = ".trim())) {" + NL + "\t\t\tSystem.setProperty(\"HADOOP_USER_NAME\",dbUser_";
  protected final String TEXT_192 = ");" + NL + "\t\t\t//make relative file path work for hive" + NL + "\t\t\tglobalMap.put(\"current_client_user_name\", System.getProperty(\"user.name\"));" + NL + "\t\t\tSystem.setProperty(\"user.name\",dbUser_";
  protected final String TEXT_193 = ");" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_194 = NL + "\t\t\tif(true) {" + NL + "\t\t\t\tthrow new java.lang.Exception(\"The distribution ";
  protected final String TEXT_195 = " does not support this version of Hive . Please check your component configuration.\");" + NL + "\t\t\t}";
  protected final String TEXT_196 = " does not support this connection mode . Please check your component configuration.\");" + NL + "\t\t\t}";
  protected final String TEXT_197 = NL + "\t\t\tif(true) {" + NL + "\t\t\t\tthrow new java.lang.Exception(\"The Hive version and the connection mode are not compatible together. Please check your component configuration.\");" + NL + "\t\t\t}";
  protected final String TEXT_198 = NL + "\t\t\t\tSystem.setProperty(";
  protected final String TEXT_199 = " ,";
  protected final String TEXT_200 = NL + "\t\t\tSystem.setProperty(\"hive.metastore.sasl.enabled\", \"true\");" + NL + "\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionDriverName\", ";
  protected final String TEXT_201 = ");" + NL + "\t\t\t";
  protected final String TEXT_202 = NL + "\t\t\t\tSystem.setProperty(\"hive.security.authorization.enabled\", \"false\");" + NL + "\t\t\t\t";
  protected final String TEXT_203 = NL + "\t\t\t\tSystem.setProperty(\"hive.security.authorization.enabled\", \"true\");" + NL + "\t\t\t\t";
  protected final String TEXT_204 = NL + "\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionURL\", ";
  protected final String TEXT_205 = ");" + NL + "\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionUserName\", ";
  protected final String TEXT_206 = ");" + NL + "" + NL + "    \t\t";
  protected final String TEXT_207 = NL + NL + "    \t\t";
  protected final String TEXT_208 = NL + "        \tString decryptedMetastorePassword_";
  protected final String TEXT_209 = ");" + NL + "   \t\t \t";
  protected final String TEXT_210 = ";" + NL + "\t\t\t";
  protected final String TEXT_211 = NL + NL + "\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionPassword\", decryptedMetastorePassword_";
  protected final String TEXT_212 = ");" + NL + "\t\t\tSystem.setProperty(\"hive.metastore.kerberos.principal\", ";
  protected final String TEXT_213 = NL + "\t\t\t\tSystem.setProperty(\"hive.server2.authentication.kerberos.principal\", ";
  protected final String TEXT_214 = ");" + NL + "\t\t\t\tSystem.setProperty(\"hive.server2.authentication.kerberos.keytab\", ";
  protected final String TEXT_215 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_216 = NL + "\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_217 = NL + "\t\t\tSystem.setProperty(\"mapred.job.tracker\", ";
  protected final String TEXT_218 = NL + "\t\t\tSystem.setProperty(\"";
  protected final String TEXT_219 = "\", ";
  protected final String TEXT_220 = NL + "\t\tString dbUser_";
  protected final String TEXT_221 = ";" + NL + "" + NL + "\t\t";
  protected final String TEXT_222 = NL + NL + "\t\t";
  protected final String TEXT_223 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_224 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_225 = NL + NL + "\t\tString dbPwd_";
  protected final String TEXT_226 = " = decryptedPassword_";
  protected final String TEXT_227 = ";" + NL;
  protected final String TEXT_228 = NL + "            String username_";
  protected final String TEXT_229 = ";" + NL + "            if(username_";
  protected final String TEXT_230 = "!=null && !\"\".equals(username_";
  protected final String TEXT_231 = ".trim())) {" + NL + "                System.setProperty(\"HADOOP_USER_NAME\",username_";
  protected final String TEXT_232 = ");" + NL + "            }";
  protected final String TEXT_233 = NL + "        globalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_234 = "\", System.getProperty(\"HADOOP_USER_NAME\"));";
  protected final String TEXT_235 = NL + "\t\t\tSystem.setProperty(\"hive.metastore.local\", \"false\");" + NL + "\t\t\tSystem.setProperty(\"hive.metastore.uris\", \"thrift://\" + ";
  protected final String TEXT_236 = ");" + NL + "\t\t\tSystem.setProperty(\"hive.metastore.execute.setugi\", \"true\");" + NL + "\t\t\tString url_";
  protected final String TEXT_237 = " = \"jdbc:";
  protected final String TEXT_238 = "://\";";
  protected final String TEXT_239 = NL + "\t\t\t\tif(dbUser_";
  protected final String TEXT_240 = ".trim())) {" + NL + "\t\t\t\t\tSystem.setProperty(\"HADOOP_USER_NAME\",dbUser_";
  protected final String TEXT_241 = ");" + NL + "\t\t\t\t\t//make relative file path work for hive" + NL + "\t\t\t\t\tglobalMap.put(\"current_client_user_name\", System.getProperty(\"user.name\"));" + NL + "\t\t\t\t\tSystem.setProperty(\"user.name\",dbUser_";
  protected final String TEXT_242 = ");" + NL + "\t\t\t\t}";
  protected final String TEXT_243 = NL + "                        System.setProperty(\"pname\", \"MapRLogin\");" + NL + "                        System.setProperty(\"https.protocols\", \"TLSv1.2\");" + NL + "                        System.setProperty(\"mapr.home.dir\", ";
  protected final String TEXT_244 = ");" + NL + "                        System.setProperty(\"hadoop.login\", ";
  protected final String TEXT_245 = NL + "\t\t\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_246 = NL + "\t\t\t\t\t\t\t\tString decryptedSslStorePassword_";
  protected final String TEXT_247 = ";";
  protected final String TEXT_248 = NL + "\t\t\t\t\t\t\tString url_";
  protected final String TEXT_249 = "://\" + ";
  protected final String TEXT_250 = " + \"/\" + ";
  protected final String TEXT_251 = " + \";principal=\" + ";
  protected final String TEXT_252 = "+\";ssl=true\" +\";sslTrustStore=\" + ";
  protected final String TEXT_253 = " + \";trustStorePassword=\" + decryptedSslStorePassword_";
  protected final String TEXT_254 = "+\";sasl.qop=auth-conf\";";
  protected final String TEXT_255 = NL + "\t\t\t\t\t\tString url_";
  protected final String TEXT_256 = NL + "                        com.mapr.login.client.MapRLoginHttpsClient maprLogin_";
  protected final String TEXT_257 = " = new com.mapr.login.client.MapRLoginHttpsClient();" + NL + "                        maprLogin_";
  protected final String TEXT_258 = ".getMapRCredentialsViaKerberos(";
  protected final String TEXT_259 = ");" + NL + "                        com.mapr.login.client.MapRLoginHttpsClient maprLogin_";
  protected final String TEXT_260 = " = new com.mapr.login.client.MapRLoginHttpsClient();";
  protected final String TEXT_261 = NL + "                            System.setProperty(\"hadoop.login\", ";
  protected final String TEXT_262 = NL + "                            maprLogin_";
  protected final String TEXT_263 = ".setCheckUGI(false);";
  protected final String TEXT_264 = NL + "                            String decryptedMaprPassword_";
  protected final String TEXT_265 = NL + "                \t\t\t\tmaprLogin_";
  protected final String TEXT_266 = ".getMapRCredentialsViaPassword(";
  protected final String TEXT_267 = ", decryptedMaprPassword_";
  protected final String TEXT_268 = ", \"\");" + NL + "                \t\t\t\t";
  protected final String TEXT_269 = ");" + NL + "                \t\t\t\t";
  protected final String TEXT_270 = NL + "\t\t\t\t\t\t\tString decryptedSslStorePassword_";
  protected final String TEXT_271 = "+ \";ssl=true\" +\";sslTrustStore=\" + ";
  protected final String TEXT_272 = NL + "\t\t\t\tString additionalJdbcSettings_";
  protected final String TEXT_273 = ";" + NL + "\t\t\t\tif(!\"\".equals(additionalJdbcSettings_";
  protected final String TEXT_274 = ".trim())) {" + NL + "\t\t\t\t\tif(!additionalJdbcSettings_";
  protected final String TEXT_275 = ".startsWith(\";\")) {" + NL + "\t\t\t\t\t\tadditionalJdbcSettings_";
  protected final String TEXT_276 = " = \";\" + additionalJdbcSettings_";
  protected final String TEXT_277 = ";" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\turl_";
  protected final String TEXT_278 = " += additionalJdbcSettings_";
  protected final String TEXT_279 = ";" + NL + "\t\t\t\t}";
  protected final String TEXT_280 = NL + "\t\tString driverClass_";
  protected final String TEXT_281 = " = \"";
  protected final String TEXT_282 = "\";" + NL + "\t\tjava.lang.Class.forName(driverClass_";
  protected final String TEXT_283 = ");" + NL + "\t\t";
  protected final String TEXT_284 = NL + "\t\t";
  protected final String TEXT_285 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_286 = " - Connection attempt to '\" + url_";
  protected final String TEXT_287 = " + \"' with the username '\" + dbUser_";
  protected final String TEXT_288 = " + \"'.\");" + NL + "\t\t";
  protected final String TEXT_289 = NL + "\t\t\tconn_";
  protected final String TEXT_290 = " - Connection to '\" + url_";
  protected final String TEXT_291 = " + \"' has succeeded.\");" + NL + "\t\t";
  protected final String TEXT_292 = NL + NL + "\t\tjava.sql.Statement init_";
  protected final String TEXT_293 = ".createStatement();";
  protected final String TEXT_294 = NL + "        \tinit_";
  protected final String TEXT_295 = ".execute(\"SET mapred.job.map.memory.mb=\" + ";
  protected final String TEXT_296 = ");" + NL + "\t    \tinit_";
  protected final String TEXT_297 = ".execute(\"SET mapred.job.reduce.memory.mb=\" + ";
  protected final String TEXT_298 = NL + "\t\tinit_";
  protected final String TEXT_299 = ".execute(\"SET dfs.namenode.kerberos.principal=\" + ";
  protected final String TEXT_300 = NL + "\t\t\tinit_";
  protected final String TEXT_301 = ".execute(\"SET mapreduce.jobtracker.kerberos.principal=\" + ";
  protected final String TEXT_302 = ".execute(\"SET yarn.resourcemanager.principal=\" + ";
  protected final String TEXT_303 = NL + "        \t\tinit_";
  protected final String TEXT_304 = ".execute(\"SET mapreduce.framework.name=yarn\");" + NL + "        \t\tinit_";
  protected final String TEXT_305 = ".execute(\"SET yarn.resourcemanager.address=\" + ";
  protected final String TEXT_306 = NL + "\t\t\t\tinit_";
  protected final String TEXT_307 = ".execute(\"SET mapreduce.jobhistory.address=\" + ";
  protected final String TEXT_308 = ");" + NL + "    \t\t\t";
  protected final String TEXT_309 = ".execute(\"SET yarn.resourcemanager.scheduler.address=\" + ";
  protected final String TEXT_310 = NL + "                init_";
  protected final String TEXT_311 = ".execute(\"SET dfs.client.use.datanode.hostname=true\");";
  protected final String TEXT_312 = ".execute(\"SET fs.default.name=\" + ";
  protected final String TEXT_313 = NL + "\t\t\t\t\tinit_";
  protected final String TEXT_314 = ".execute(\"SET mapreduce.app-submission.cross-platform=true\");";
  protected final String TEXT_315 = ".execute(\"SET mapreduce.job.map.output.collector.class=org.apache.hadoop.mapred.MapRFsOutputBuffer\");" + NL + "\t\t\t\t\tinit_";
  protected final String TEXT_316 = ".execute(\"SET mapreduce.job.reduce.shuffle.consumer.plugin.class=org.apache.hadoop.mapreduce.task.reduce.DirectShuffle\");";
  protected final String TEXT_317 = ".execute(\"SET mapreduce.application.classpath=";
  protected final String TEXT_318 = "\");";
  protected final String TEXT_319 = ".execute(\"SET yarn.application.classpath=";
  protected final String TEXT_320 = NL + "    \t\t\tinit_";
  protected final String TEXT_321 = ".execute(\"SET mapreduce.map.memory.mb=\" + ";
  protected final String TEXT_322 = ");" + NL + "    \t\t\tinit_";
  protected final String TEXT_323 = ".execute(\"SET mapreduce.reduce.memory.mb=\" + ";
  protected final String TEXT_324 = ".execute(\"SET yarn.app.mapreduce.am.resource.mb=\" + ";
  protected final String TEXT_325 = ".execute(\"SET \"+";
  protected final String TEXT_326 = NL + "        \t";
  protected final String TEXT_327 = NL + "    \t\tinit_";
  protected final String TEXT_328 = ".execute(\"SET hive.execution.engine=tez\");";
  protected final String TEXT_329 = NL + "                        System.err.println(\"Please set the path of Tez lib in 'Tez lib path'!\");";
  protected final String TEXT_330 = NL + "        String username_";
  protected final String TEXT_331 = " = (";
  protected final String TEXT_332 = " != null && !\"\".equals(";
  protected final String TEXT_333 = ")) ? ";
  protected final String TEXT_334 = " : System.getProperty(\"user.name\");;" + NL + "        org.apache.hadoop.fs.FileSystem fs_";
  protected final String TEXT_335 = NL + "        org.apache.hadoop.conf.Configuration conf_";
  protected final String TEXT_336 = " = new org.apache.hadoop.conf.Configuration(); " + NL + "        conf_";
  protected final String TEXT_337 = ".set(\"";
  protected final String TEXT_338 = ");" + NL + "        ";
  protected final String TEXT_339 = NL + "            conf_";
  protected final String TEXT_340 = ".set(\"dfs.client.use.datanode.hostname\", \"true\");";
  protected final String TEXT_341 = NL + "        \t\tconf_";
  protected final String TEXT_342 = ".set(";
  protected final String TEXT_343 = ");" + NL + "        \t";
  protected final String TEXT_344 = NL + "            username_";
  protected final String TEXT_345 = " = null;" + NL + "    \t\tconf_";
  protected final String TEXT_346 = ".set(\"dfs.namenode.kerberos.principal\", ";
  protected final String TEXT_347 = ");" + NL + "    \t\t";
  protected final String TEXT_348 = NL + "    \t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_349 = NL + "\t\t\tconf_";
  protected final String TEXT_350 = ".set(\"hadoop.job.ugi\",username_";
  protected final String TEXT_351 = "+\",\"+username_";
  protected final String TEXT_352 = ");" + NL + "        \tfs_";
  protected final String TEXT_353 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_354 = NL + "        \t" + NL + "        \tif(username_";
  protected final String TEXT_355 = " == null || \"\".equals(username_";
  protected final String TEXT_356 = ")){" + NL + "        \t\tfs_";
  protected final String TEXT_357 = ");" + NL + "        \t}else{" + NL + "        \t\tfs_";
  protected final String TEXT_358 = " = org.apache.hadoop.fs.FileSystem.get(new java.net.URI(conf_";
  protected final String TEXT_359 = ".get(\"";
  protected final String TEXT_360 = "\")),conf_";
  protected final String TEXT_361 = ",username_";
  protected final String TEXT_362 = ");" + NL + "        \t}\t";
  protected final String TEXT_363 = NL + "                    String hdfsUserName_";
  protected final String TEXT_364 = " : System.getProperty(\"user.name\");" + NL + "                    String tezLibPath_";
  protected final String TEXT_365 = " = \"/tmp/\" + hdfsUserName_";
  protected final String TEXT_366 = " + \"/talend_tez_libs/";
  protected final String TEXT_367 = "\";";
  protected final String TEXT_368 = NL + "                    String tezLibPath_";
  protected final String TEXT_369 = NL + "                fs_";
  protected final String TEXT_370 = ".mkdirs(new org.apache.hadoop.fs.Path(tezLibPath_";
  protected final String TEXT_371 = NL + "                String[] classPaths_";
  protected final String TEXT_372 = " = System.getProperty(\"java.class.path\").split(";
  protected final String TEXT_373 = "String.valueOf(globalMap.get(\"current_client_path_separator\"))";
  protected final String TEXT_374 = "System.getProperty(\"path.separator\")";
  protected final String TEXT_375 = ");" + NL + "                String tezLibLocalPath_";
  protected final String TEXT_376 = " = null;" + NL + "                for(String classPath_";
  protected final String TEXT_377 = " : classPaths_";
  protected final String TEXT_378 = "){";
  protected final String TEXT_379 = NL + "                        if(classPath_";
  protected final String TEXT_380 = ".endsWith(\"";
  protected final String TEXT_381 = "\")){" + NL + "                            org.apache.hadoop.fs.Path tezJarPath_";
  protected final String TEXT_382 = " = new org.apache.hadoop.fs.Path(tezLibPath_";
  protected final String TEXT_383 = " + \"/";
  protected final String TEXT_384 = "\");" + NL + "                            if(!fs_";
  protected final String TEXT_385 = ".exists(tezJarPath_";
  protected final String TEXT_386 = ")){" + NL + "                                fs_";
  protected final String TEXT_387 = ".copyFromLocalFile(false, false, new org.apache.hadoop.fs.Path(classPath_";
  protected final String TEXT_388 = "), tezJarPath_";
  protected final String TEXT_389 = ");" + NL + "                            }" + NL + "                        }";
  protected final String TEXT_390 = NL + "                }";
  protected final String TEXT_391 = NL + "                String tezLibPath_";
  protected final String TEXT_392 = NL + "\t\t\tStringBuilder script_";
  protected final String TEXT_393 = " = new StringBuilder();" + NL + "\t\t\tString[] tezLibPaths_";
  protected final String TEXT_394 = " = tezLibPath_";
  protected final String TEXT_395 = ".split(\",\");" + NL + "\t\t\tscript_";
  protected final String TEXT_396 = ".append(\"SET tez.lib.uris=\");" + NL + "\t\t\tint tezLibPathCount_";
  protected final String TEXT_397 = " = 1;" + NL + "\t\t\tfor(String tezLibPathKey_";
  protected final String TEXT_398 = " : tezLibPaths_";
  protected final String TEXT_399 = "){" + NL + "\t\t\t\t script_";
  protected final String TEXT_400 = ".append(";
  protected final String TEXT_401 = " + \"/\" + tezLibPathKey_";
  protected final String TEXT_402 = ");" + NL + "\t\t\t\t if(tezLibPathCount_";
  protected final String TEXT_403 = " < tezLibPaths_";
  protected final String TEXT_404 = ".length){" + NL + "\t\t\t\t \tscript_";
  protected final String TEXT_405 = ".append(\",\");" + NL + "\t\t\t\t }" + NL + "\t\t\t\t tezLibPathCount_";
  protected final String TEXT_406 = "++;" + NL + "\t\t\t}" + NL + "\t\t\tinit_";
  protected final String TEXT_407 = ".execute(script_";
  protected final String TEXT_408 = ".toString());" + NL + "\t\t";
  protected final String TEXT_409 = NL + "            \t";
  protected final String TEXT_410 = ".close();" + NL + "" + NL + "    \tString dbname_";
  protected final String TEXT_411 = ";" + NL + "    \tif(dbname_";
  protected final String TEXT_412 = ".close();" + NL + "    \t}" + NL + "" + NL + "\t\t";
  protected final String TEXT_413 = NL + "    \t\tjava.sql.Statement statement_";
  protected final String TEXT_414 = ".createStatement();" + NL + "    \t\t";
  protected final String TEXT_415 = NL + "    \t\t\tstatement_";
  protected final String TEXT_416 = ".execute(\"SET hbase.zookeeper.quorum=\"+";
  protected final String TEXT_417 = NL + NL + "        \t";
  protected final String TEXT_418 = NL + "        \t\tstatement_";
  protected final String TEXT_419 = ".execute(\"SET hbase.zookeeper.property.clientPort=\"+";
  protected final String TEXT_420 = NL + NL + "\t\t\t";
  protected final String TEXT_421 = NL + "\t\t\t\tstatement_";
  protected final String TEXT_422 = ".execute(\"SET zookeeper.znode.parent=\"+";
  protected final String TEXT_423 = ".execute(\"SET hbase.security.authentication=kerberos\");" + NL + "\t\t\t\tstatement_";
  protected final String TEXT_424 = ".execute(\"SET hbase.rpc.engine=org.apache.hadoop.hbase.ipc.SecureRpcEngine\");" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_425 = NL + "\t\t\t\t\tstatement_";
  protected final String TEXT_426 = ".execute(\"SET hbase.master.kerberos.principal=\"+";
  protected final String TEXT_427 = NL + "\t\t\t\t";
  protected final String TEXT_428 = ".execute(\"SET hbase.regionserver.kerberos.principal=\"+";
  protected final String TEXT_429 = NL + "\t\t\t";
  protected final String TEXT_430 = ".execute(\"add jar \"+";
  protected final String TEXT_431 = NL + "    \t\tstatement_";
  protected final String TEXT_432 = ".close();";
  protected final String TEXT_433 = NL + "        if(true) {" + NL + "            throw new java.lang.UnsupportedOperationException(\"Parquet is only supported if the distribution uses embedded Hive version 0.10 or later.\");" + NL + "        }";
  protected final String TEXT_434 = NL + "            routines.system.GetJarsToRegister getJarsToRegister_";
  protected final String TEXT_435 = " = new routines.system.GetJarsToRegister();";
  protected final String TEXT_436 = NL + "\tclass GetHiveJarsToRegister_";
  protected final String TEXT_437 = " extends routines.system.GetJarsToRegister {" + NL + "\t\t" + NL + "\t\tprivate String uploadJarToHDFS(String jar) throws Exception {" + NL + "\t\t\t";
  protected final String TEXT_438 = NL + "\t\t\t" + NL + "\t\t\tString pathUsername_";
  protected final String TEXT_439 = " = username_";
  protected final String TEXT_440 = " == null ? org.apache.hadoop.security.UserGroupInformation.getLoginUser().getShortUserName() : username_";
  protected final String TEXT_441 = ";" + NL + "\t\t\tfs_";
  protected final String TEXT_442 = ".mkdirs(new org.apache.hadoop.fs.Path(\"/user/\" + pathUsername_";
  protected final String TEXT_443 = " + \"/tmp\"), new org.apache.hadoop.fs.permission.FsPermission(org.apache.hadoop.fs.permission.FsAction.ALL, org.apache.hadoop.fs.permission.FsAction.ALL, org.apache.hadoop.fs.permission.FsAction.ALL));" + NL + "\t\t\tfs_";
  protected final String TEXT_444 = ".copyFromLocalFile(false, true, new org.apache.hadoop.fs.Path(jar), new org.apache.hadoop.fs.Path(\"/user/\" + pathUsername_";
  protected final String TEXT_445 = " + \"/tmp\"));" + NL + "\t\t\treturn ";
  protected final String TEXT_446 = " + \"/user/\" + pathUsername_";
  protected final String TEXT_447 = " + \"/tmp/\" + new java.io.File(jar).getName();" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tpublic String replaceJarPaths(String originalClassPathLine) throws Exception {" + NL + "\t\t\tString classPathLine = super.replaceJarPaths(originalClassPathLine);" + NL + "\t\t\tString hdfsPath = uploadJarToHDFS(classPathLine);" + NL + "\t\t\treturn hdfsPath;" + NL + "\t\t}" + NL + "\t}" + NL + "                GetHiveJarsToRegister_";
  protected final String TEXT_448 = " getJarsToRegister_";
  protected final String TEXT_449 = " = new GetHiveJarsToRegister_";
  protected final String TEXT_450 = "();";
  protected final String TEXT_451 = NL + "            java.sql.Statement addJar_";
  protected final String TEXT_452 = NL + "                            addJar_";
  protected final String TEXT_453 = ".createStatement();" + NL + "                            try {" + NL + "                                addJar_";
  protected final String TEXT_454 = ".execute(\"add jar \" + getJarsToRegister_";
  protected final String TEXT_455 = ".replaceJarPaths(\"";
  protected final String TEXT_456 = "\"));" + NL + "                            } catch (Exception e) {" + NL + "                                e.printStackTrace();" + NL + "                            } finally {" + NL + "                                addJar_";
  protected final String TEXT_457 = ".close();" + NL + "                            }";
  protected final String TEXT_458 = NL + "                                bw_";
  protected final String TEXT_459 = ".write(\"ADD JAR \" + wasbPath_";
  protected final String TEXT_460 = " + new java.io.File(getJarsToRegister_";
  protected final String TEXT_461 = "\")).getName() + \";\");" + NL + "                                libjars_";
  protected final String TEXT_462 = ".append(getJarsToRegister_";
  protected final String TEXT_463 = "\") + \",\");";
  protected final String TEXT_464 = NL + "                                // Qubole hive 1.2 supports parquet by default.";
  protected final String TEXT_465 = NL + "                                    log.debug(\"Query for ";
  protected final String TEXT_466 = ": \" + \"ADD JAR \" + stagingBucketPath_";
  protected final String TEXT_467 = "\")).getName() + \";\");";
  protected final String TEXT_468 = NL + "                                instance_";
  protected final String TEXT_469 = ".addQuery(\"ADD JAR \" + stagingBucketPath_";
  protected final String TEXT_470 = NL + "    java.sql.Statement stmt_";
  protected final String TEXT_471 = NL + "    String query_";
  protected final String TEXT_472 = " = \"\";" + NL + "    String tableName_";
  protected final String TEXT_473 = NL + "    String likeTableName_";
  protected final String TEXT_474 = NL + "        String location_";
  protected final String TEXT_475 = NL + "    String querySQL_";
  protected final String TEXT_476 = NL + "            try {" + NL + "\t\t\t\t";
  protected final String TEXT_477 = NL + NL + "java.text.DateFormat dateStrFormat_";
  protected final String TEXT_478 = " = new java.text.SimpleDateFormat(\"yyyyMMddHHmmss\");" + NL + "final String queryIdentifier_";
  protected final String TEXT_479 = " = projectName + \"_\" + jobName + \"_\" + jobVersion.replace(\".\", \"_\") + \"_";
  protected final String TEXT_480 = "_\" + dateStrFormat_";
  protected final String TEXT_481 = ".format(new Date(startTime));" + NL + "// For MapReduce Mode" + NL + "stmt_";
  protected final String TEXT_482 = ".execute(\"set mapred.job.name=\" + queryIdentifier_";
  protected final String TEXT_483 = NL + "    // For Tez Mode" + NL + "    stmt_";
  protected final String TEXT_484 = ".execute(\"set hive.query.name=\" + queryIdentifier_";
  protected final String TEXT_485 = NL + "                stmt_";
  protected final String TEXT_486 = ".execute(querySQL_";
  protected final String TEXT_487 = ");" + NL + "            } catch(java.sql.SQLException e_";
  protected final String TEXT_488 = ") {";
  protected final String TEXT_489 = NL + "                    throw(e_";
  protected final String TEXT_490 = NL + "                    System.err.println(e_";
  protected final String TEXT_491 = ".getMessage());";
  protected final String TEXT_492 = NL + "            }" + NL + "            stmt_";
  protected final String TEXT_493 = ".close();" + NL + "            globalMap.put(\"";
  protected final String TEXT_494 = "_QUERY\", querySQL_";
  protected final String TEXT_495 = ");" + NL + "        " + NL + "            String currentClientPathSeparator_";
  protected final String TEXT_496 = " = (String)globalMap.get(\"current_client_path_separator\");" + NL + "            if(currentClientPathSeparator_";
  protected final String TEXT_497 = "!=null) {" + NL + "                System.setProperty(\"path.separator\", currentClientPathSeparator_";
  protected final String TEXT_498 = ");" + NL + "                globalMap.put(\"current_client_path_separator\", null);" + NL + "            }";
  protected final String TEXT_499 = NL + "                conn_";
  protected final String TEXT_500 = ".write(querySQL_";
  protected final String TEXT_501 = " + \";\");" + NL + "                globalMap.put(\"";
  protected final String TEXT_502 = ");" + NL + "    " + NL + "                bw_";
  protected final String TEXT_503 = ".close();" + NL + "    " + NL + "                if(libjars_";
  protected final String TEXT_504 = ".length() > 0) {" + NL + "                    instance_";
  protected final String TEXT_505 = ".setLibJars(libjars_";
  protected final String TEXT_506 = ".toString().substring(0, libjars_";
  protected final String TEXT_507 = ".length()-1));" + NL + "                }" + NL + "                instance_";
  protected final String TEXT_508 = ".callWS(instance_";
  protected final String TEXT_509 = ".sendFiles());" + NL + "                int exitCode_";
  protected final String TEXT_510 = ".execute();" + NL + "                if(exitCode_";
  protected final String TEXT_511 = " > 0) {" + NL;
  protected final String TEXT_512 = NL + "                        throw new Exception(\"The Hive job failed. Please read the logs for more details\");";
  protected final String TEXT_513 = NL + "                        System.err.println(\"The Hive job failed. Please read the logs for more details\");";
  protected final String TEXT_514 = NL + "                            log.error(\"";
  protected final String TEXT_515 = " - The Hive job failed. Please read the logs for more details\");";
  protected final String TEXT_516 = NL + "                }";
  protected final String TEXT_517 = NL + "            \t\tlog.info(\"";
  protected final String TEXT_518 = " - start executing query:  \" + querySQL_";
  protected final String TEXT_519 = ".replace(\"';'\", \"'\\\\;'\") + \";\");" + NL + "            \t";
  protected final String TEXT_520 = NL + "            \t\tString execution_result_";
  protected final String TEXT_521 = ".replace(\"';'\", \"'\\\\;'\") + \";\", ";
  protected final String TEXT_522 = ").getResults();" + NL + "            \t";
  protected final String TEXT_523 = NL + "\t\t\t\t\tString execution_result_";
  protected final String TEXT_524 = ".replace(\"';'\", \"'\\\\;'\") + \";\").getResults();";
  protected final String TEXT_525 = NL + "                    log.debug(\"Query for ";
  protected final String TEXT_526 = ": \" + querySQL_";
  protected final String TEXT_527 = ".replace(\"';'\", \"'\\\\;'\") + \";\");";
  protected final String TEXT_528 = NL + "                instance_";
  protected final String TEXT_529 = ".addQuery(querySQL_";
  protected final String TEXT_530 = ".replace(\"';'\", \"'\\\\;'\") + \";\");" + NL + "                if(libjars_";
  protected final String TEXT_531 = ".addLibJars(libjars_";
  protected final String TEXT_532 = ".length()-1));" + NL + "                }" + NL + "                int exitCode_";
  protected final String TEXT_533 = ".executeJob();" + NL + "                System.out.println(instance_";
  protected final String TEXT_534 = ".getJobLog());" + NL + "                if(exitCode_";
  protected final String TEXT_535 = NL + "\t\t\t\t\tString comment_";
  protected final String TEXT_536 = "_";
  protected final String TEXT_537 = NL + "\t\t\t\t\tString key_";
  protected final String TEXT_538 = ";" + NL + "\t\t\t\t\tString value_";
  protected final String TEXT_539 = NL + "    String tableComment_";
  protected final String TEXT_540 = NL + "    String clustededOrSkewed_";
  protected final String TEXT_541 = NL + "            String fieldChar_";
  protected final String TEXT_542 = NL + "                String escapeChar_";
  protected final String TEXT_543 = NL + "            String collectionChar_";
  protected final String TEXT_544 = NL + "            String mapChar_";
  protected final String TEXT_545 = NL + "            String lineChar_";
  protected final String TEXT_546 = NL + "        String serdeName_";
  protected final String TEXT_547 = NL + "        String inputClass_";
  protected final String TEXT_548 = ";" + NL + "        String outputClass_";
  protected final String TEXT_549 = NL + "    String storageClass_";
  protected final String TEXT_550 = NL + "            String decryptedS3Password_";
  protected final String TEXT_551 = " = \"s3n://\" + ";
  protected final String TEXT_552 = " +\":\" + decryptedS3Password_";
  protected final String TEXT_553 = " + \"@\" + ";
  protected final String TEXT_554 = NL + "    String location_";
  protected final String TEXT_555 = NL + "    String select_";
  protected final String TEXT_556 = NL + "String querySQL_";
  protected final String TEXT_557 = NL + "\t\ttry {" + NL + "\t\t\t";
  protected final String TEXT_558 = NL + "\t\t    stmt_";
  protected final String TEXT_559 = ");" + NL + "\t\t} catch(java.sql.SQLException e_";
  protected final String TEXT_560 = NL + "        \t\tthrow(e_";
  protected final String TEXT_561 = NL + "        \t\tSystem.err.println(e_";
  protected final String TEXT_562 = NL + "        }" + NL + "\t\tstmt_";
  protected final String TEXT_563 = ".close();" + NL + "\t\t";
  protected final String TEXT_564 = NL + "\t\t    conn_";
  protected final String TEXT_565 = NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_566 = ");" + NL + "\t\t" + NL + "\t\tString currentClientPathSeparator_";
  protected final String TEXT_567 = " = (String)globalMap.get(\"current_client_path_separator\");" + NL + "\t\tif(currentClientPathSeparator_";
  protected final String TEXT_568 = "!=null) {" + NL + "\t\t    System.setProperty(\"path.separator\", currentClientPathSeparator_";
  protected final String TEXT_569 = ");" + NL + "\t\t    globalMap.put(\"current_client_path_separator\", null);" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tString currentClientUsername_";
  protected final String TEXT_570 = " = (String)globalMap.get(\"current_client_user_name\");" + NL + "\t\tif(currentClientUsername_";
  protected final String TEXT_571 = "!=null) {" + NL + "\t\t    System.setProperty(\"user.name\", currentClientUsername_";
  protected final String TEXT_572 = ");" + NL + "\t\t    globalMap.put(\"current_client_user_name\", null);" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tString originalHadoopUsername_";
  protected final String TEXT_573 = " = (String)globalMap.get(\"HADOOP_USER_NAME_";
  protected final String TEXT_574 = "\");" + NL + "\t\tif(originalHadoopUsername_";
  protected final String TEXT_575 = "!=null) {" + NL + "\t\t    System.setProperty(\"HADOOP_USER_NAME\", originalHadoopUsername_";
  protected final String TEXT_576 = ");" + NL + "\t\t    globalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_577 = "\", null);" + NL + "\t\t} else {" + NL + "\t\t    System.clearProperty(\"HADOOP_USER_NAME\");" + NL + "\t\t}";
  protected final String TEXT_578 = NL + "            bw_";
  protected final String TEXT_579 = " + \";\");" + NL + "            globalMap.put(\"";
  protected final String TEXT_580 = ");" + NL + "    " + NL + "            bw_";
  protected final String TEXT_581 = ".close();" + NL + "    " + NL + "            if(libjars_";
  protected final String TEXT_582 = ".length() > 0) {" + NL + "                instance_";
  protected final String TEXT_583 = ".length()-1));" + NL + "            }" + NL + "            instance_";
  protected final String TEXT_584 = ".sendFiles());" + NL + "            int exitCode_";
  protected final String TEXT_585 = ".execute();" + NL + "            if(exitCode_";
  protected final String TEXT_586 = " > 0) {" + NL + "    ";
  protected final String TEXT_587 = NL + "                    throw new Exception(\"The Hive job failed. Please read the logs for more details\");";
  protected final String TEXT_588 = NL + "                    System.err.println(\"The Hive job failed. Please read the logs for more details\");";
  protected final String TEXT_589 = NL + "                        log.error(\"";
  protected final String TEXT_590 = NL + "            }";
  protected final String TEXT_591 = NL + "        \tString queries_";
  protected final String TEXT_592 = " = \"\";" + NL + "        \tif (connectionCommandList_";
  protected final String TEXT_593 = " != null) {" + NL + "        \t\tfor (String command : connectionCommandList_";
  protected final String TEXT_594 = ") {" + NL + "        \t\t\tqueries_";
  protected final String TEXT_595 = " += command;" + NL + "        \t\t\t";
  protected final String TEXT_596 = NL + "        \t\t\t\tlog.info(\"";
  protected final String TEXT_597 = " - query added: \" + command);" + NL + "        \t\t\t";
  protected final String TEXT_598 = NL + "        \t\t}" + NL + "        \t}" + NL + "\t\t    queries_";
  protected final String TEXT_599 = " = queries_";
  protected final String TEXT_600 = " + querySQL_";
  protected final String TEXT_601 = ".replace(\"';'\", \"'\\\\;'\") + \";\";" + NL + "" + NL + "\t\t    org.talend.bigdata.launcher.qubole.QuboleHiveClient.Job job_";
  protected final String TEXT_602 = " =" + NL + "\t\t    \tnew org.talend.bigdata.launcher.qubole.QuboleHiveClient.Job(queries_";
  protected final String TEXT_603 = ");" + NL + "\t\t\tjob_";
  protected final String TEXT_604 = ".setJobName(\"";
  protected final String TEXT_605 = "\");" + NL + "\t\t\tjob_";
  protected final String TEXT_606 = ".setUserAgent(routines.system.Constant.getUserAgent(\"";
  protected final String TEXT_607 = "\"));" + NL + "        \t";
  protected final String TEXT_608 = NL + "\t\t\tjob_";
  protected final String TEXT_609 = ".setClusterLabel(";
  protected final String TEXT_610 = NL + "\t\t\tString execution_result_";
  protected final String TEXT_611 = ".execute(job_";
  protected final String TEXT_612 = NL + "                log.debug(\"Query for ";
  protected final String TEXT_613 = NL + "            instance_";
  protected final String TEXT_614 = ".replace(\"';'\", \"'\\\\;'\") + \";\");" + NL + "            globalMap.put(\"";
  protected final String TEXT_615 = ");" + NL + "            int exitCode_";
  protected final String TEXT_616 = ".executeJob();" + NL + "            System.out.println(instance_";
  protected final String TEXT_617 = ".getJobLog());" + NL + "            if(exitCode_";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		String label = null;
 		
 		public DefaultLog4jFileUtil(){
 		}
 		public DefaultLog4jFileUtil(INode node) {
 			this.node = node;
 			this.cid = node.getUniqueName();
 			this.label = cid;
			this.isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 		}
 		
 		public void setCid(String cid) {
 			this.cid = cid;
 		}
 		
		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_1);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_2);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_12);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    
	class DefaultLog4jCodeGenerateUtil extends DefaultLog4jFileUtil{

 		String connection = "";
 		boolean hasInit = false;
 		String dataAction ;
 		String dataOperationPrefix;
		String useBatchSize;
		String batchSize;
		String dbSchema;
 		boolean logCommitCounter = false;

		public DefaultLog4jCodeGenerateUtil(){
		}

		public DefaultLog4jCodeGenerateUtil(INode node) {
			super(node);
	    	init();
		}

	    public void beforeComponentProcess(INode node){
	    	this.node = node;
	    	init();
	    }

		private void init() {
			if(hasInit){
				return;
			}
 			this.cid = node.getUniqueName();
			this.isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
			String useConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
			if(useConn == null || "".equals(useConn) || "true".equals(useConn)){
				connection = ElementParameterParser.getValue(node,"__CONNECTION__");
				if(!"".equals(connection)){
					connection = "'" + connection+"' ";
				}
			}
			//for output
			dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
			if(dataAction != null && !("").equals(dataAction)){
				logCommitCounter=true;
			}
			useBatchSize = ElementParameterParser.getValue(node, "__USE_BATCH_SIZE__");
			batchSize =ElementParameterParser.getValue(node, "__BATCH_SIZE__");
			hasInit = true;
		}

		public void debugDriverClassName() {
			logInfo(node,"debug",cid+" - Driver ClassName: \"+driverClass_"+cid+"+\".");
		}

		public void debugConnectionParams(INode node) {
			beforeComponentProcess(node);
			debugDriverClassName();
		}

		public void useExistConnection(INode node){
			beforeComponentProcess(node);
			if(isLog4jEnabled) {
			
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    if (cid.contains("tImpala") || cid.contains("tHive")) {
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_23);
    } else {
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    }
    stringBuffer.append(TEXT_28);
    
			}
		}

		public void connect(INode node){
			beforeComponentProcess(node);
			connect();
		}

		public void connect(){
			connect_begin();
			
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
			connect_end();
		}
		
		public void connect_begin(){
			logInfo(node,"debug",cid+" - Connection attempt to '\" + url_"+cid+" + \"' with the username '\" + dbUser_"+cid+" + \"'.");
		}

		public void connect_begin_noUser(){
			logInfo(node,"debug",cid+" - Connection attempt to '\" + url_"+cid+" + \"'.");
		}

		public void connect_end(){
			logInfo(node,"debug",cid+" - Connection to '\" + url_"+cid+" + \"' has succeeded.");
		}

		public void rollback(INode node){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Connection "+connection+"starting to rollback.");
			
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
			logInfo(node,"debug",cid+" - Connection "+connection+"rollback has succeeded.");
		}

		public void commit(INode node){
			beforeComponentProcess(node);
			commit();
		}

		private void commit(){
			commit_begin();
			
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
			commit_end();
		}

		private void commit_begin(){
			if(logCommitCounter){
				logInfo(node,"debug",cid+" - Connection "+connection+"starting to commit \" + commitCounter_"+cid+"+ \" records.");
			}else{
				logInfo(node,"debug",cid+" - Connection "+connection+"starting to commit.");
			}
		}
		private void commit_end(){
			logInfo(node,"debug",cid+" - Connection "+connection+"commit has succeeded.");
		}

		public void close(INode node){
			beforeComponentProcess(node);
			close();
		}

		private void close(){
			close_begin();
			
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
     /* TESB-24900 - graceful shutdown for MYSQL connection */ 
    stringBuffer.append(TEXT_37);
    stringBuffer.append((connection!=null)?connection.replaceAll("'","").trim():"");
    stringBuffer.append(TEXT_38);
    
			close_end();
		}

		public void close_begin(){
			logInfo(node,"debug",cid+" - Closing the connection "+connection+"to the database.");
		}
		public void close_end(){
			logInfo(node,"debug",cid+" - Connection "+connection+"to the database closed.");
		}

		public void autoCommit(INode node,boolean autoCommit){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Connection is set auto commit to '"+autoCommit+"'.");
			
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(autoCommit);
    stringBuffer.append(TEXT_33);
    
		}

		public void query(INode node){
			beforeComponentProcess(node);
			//for input
	 		String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
			dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);
			logInfo(node,"debug",cid+" - Executing the query: '\" + "+dbquery +" + \"'.");
		}

		public void retrieveRecordsCount(INode node){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Retrieved records count: \"+nb_line_"+cid+" + \" .");
		}

		public void logError(INode node,String logLevel,String exception){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_41);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(exception);
    stringBuffer.append(TEXT_44);
    
			}
	    }

	    public void logError(INode node,String logLevel){
	    	logError(node,logLevel,"e");
	    }
	    
	    public void logInfo(INode node,String logLevel,String message){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_45);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_46);
    
			}
	    }
		/**
		*batchType :
		*			1: do not get return value of executeBatch();
		*			2: get return value of executeBatch();
		*
		*/
		public void executeBatch(INode node,int batchType){
			beforeComponentProcess(node);
			boolean logBatch = ("true").equals(useBatchSize) && !("").equals(batchSize) && !("0").equals(batchSize);
			if(logBatch){
				logInfo(node,"debug",cid+" - Executing the "+dataAction+" batch.");
			}
			if(batchType==1){
			
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    
			}else if(batchType==2){
				boolean isMysqlBatchInsert = false;
				if ((node.getUniqueName().contains("tMysqlOutput")||node.getUniqueName().contains("tAmazonMysqlOutput")) && ("INSERT").equals(dataAction)) {
					isMysqlBatchInsert = true;
				}
			
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(isMysqlBatchInsert? "1" : "countEach_"+cid );
    stringBuffer.append(TEXT_55);
    
			}
			if(logBatch){
				logInfo(node,"debug",cid+" - The "+dataAction+" batch execution has succeeded.");
			}
		}
	}

	DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();

    stringBuffer.append(TEXT_56);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    final String cid = node.getUniqueName();
    String processId = node.getProcess().getId();

    String dbhost = ElementParameterParser.getValue(node, "__HOST__");
    String dbport = ElementParameterParser.getValue(node, "__PORT__");
    String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
    String dbuser= ElementParameterParser.getValue(node, "__USER__");


    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
    String theDistribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
    String theVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");

	final String studioVersion = org.talend.commons.utils.VersionUtils.getDisplayVersion();

	String quboleClusterLabel = null;
	String quboleEndpoint = null;
	String encryptedToken = null;
    if("true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"))) {
		// using connection
        String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
        for (INode pNode : node.getProcess().getNodesOfType("tHiveConnection")) {
            if(connection!=null && connection.equals(pNode.getUniqueName())) {
                theDistribution = ElementParameterParser.getValue(pNode, "__DISTRIBUTION__");
                theVersion = ElementParameterParser.getValue(pNode, "__HIVE_VERSION__");
				if (ElementParameterParser.getBooleanValue(pNode, "__QUBOLE_CLUSTER__")) {
					quboleClusterLabel = ElementParameterParser.getValue(pNode, "__QUBOLE_CLUSTER_LABEL__");
				}
            }
        }
    } else {
	    // without connection
	    encryptedToken = ElementParameterParser.getEncryptedValue(node, "__QUBOLE_API_TOKEN__");
		if (ElementParameterParser.getBooleanValue(node, "__QUBOLE_ENDPOINT__")) {
			quboleEndpoint = ElementParameterParser.getValue(node, "__QUBOLE_ENDPOINT_URL__");
		}
		if (ElementParameterParser.getBooleanValue(node, "__QUBOLE_CLUSTER__")) {
			quboleClusterLabel = ElementParameterParser.getValue(node, "__QUBOLE_CLUSTER_LABEL__");
		}
	}


    org.talend.hadoop.distribution.component.HiveComponent hiveDistrib = null;
    try {
        hiveDistrib = (org.talend.hadoop.distribution.component.HiveComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(theDistribution, theVersion);
    } catch (java.lang.Exception e) {
        e.printStackTrace();
        return "";
    }
    boolean isCustom = hiveDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;
    
    if(hiveDistrib.isExecutedThroughWebHCat()) {

    
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");

    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    
	if("false".equals(useExistingConn)) {
		String passwordFieldName = "__HDINSIGHT_PASSWORD__";
		if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_66);
    
		} else {

    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_69);
    
		}
			
		passwordFieldName = "__WASB_PASSWORD__";
		if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_66);
    
		} else {

    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_69);
    
		}

    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_USERNAME__"));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_CONTAINER__"));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(ElementParameterParser.getValue(node, "__HDINSIGHT_USERNAME__"));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_USERNAME__"));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_HOST__"));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_PORT__"));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(ElementParameterParser.getValue(node, "__STATUSDIR__"));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(ElementParameterParser.getValue(node, "__REMOTE_FOLDER__"));
    stringBuffer.append(TEXT_88);
    
	} else {
		String azureConnection = ElementParameterParser.getValue(node,"__CONNECTION__");

    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(azureConnection);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(azureConnection);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    
	}

    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    
        if("false".equals(useExistingConn)) { // This variable is declared and initialized in the GetAzureConnection.javajet
            boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
            if(setMemory) {
                String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
                String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
                String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_108);
    
            }

            List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
            if(advProps!=null) {
                for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_111);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_108);
    
                }
            }

    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    
        }
    } else if (hiveDistrib.isGoogleDataprocDistribution()) {

    
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");

    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    
	if("false".equals(useExistingConn)) {

    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    
        boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
        if(setMemory) {
            String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
            String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
            String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_108);
    
        }

        List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
        if(advProps!=null) {
            for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_111);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_108);
    
            }
        }

    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GOOGLE_JARS_BUCKET__"));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GOOGLE_CLUSTER_ID__"));
    stringBuffer.append(TEXT_138);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GOOGLE_REGION__"));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GOOGLE_PROJECT_ID__"));
    stringBuffer.append(TEXT_140);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GOOGLE_JARS_BUCKET__"));
    stringBuffer.append(TEXT_141);
    
            if(ElementParameterParser.getBooleanValue(node, "__DEFINE_PATH_TO_GOOGLE_CREDENTIALS__")) {

    stringBuffer.append(TEXT_142);
    stringBuffer.append(ElementParameterParser.getValue(node, "__PATH_TO_GOOGLE_CREDENTIALS__"));
    stringBuffer.append(TEXT_141);
                  
            }

    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    
        if(isLog4jEnabled) {

    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    
        }
	} else {
		String dataprocConnection = ElementParameterParser.getValue(node,"__CONNECTION__");

    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(dataprocConnection);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(dataprocConnection);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    
	}

    
    } else if (hiveDistrib.isQuboleDistribution()) { // get qubole connection

    stringBuffer.append(TEXT_155);
    
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");

    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    
	if("false".equals(useExistingConn)) {

    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    
        boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
        if(setMemory) {
            String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
            String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
            String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_108);
    
        }

        List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
        if(advProps!=null) {
            for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_111);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_108);
    
            }
        }

    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(encryptedToken);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
     if (quboleEndpoint != null) {
    stringBuffer.append(TEXT_160);
    stringBuffer.append(quboleEndpoint);
    stringBuffer.append(TEXT_161);
    } 
    stringBuffer.append(TEXT_162);
    
        if(isLog4jEnabled) {

    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    
        }
	} else {
		String quboleConnection = ElementParameterParser.getValue(node,"__CONNECTION__");

    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(quboleConnection);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(quboleConnection);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(quboleConnection);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(quboleConnection);
    stringBuffer.append(TEXT_170);
    
	}

    
    } else { // normal mode

    stringBuffer.append(TEXT_171);
    stringBuffer.append(TEXT_172);
     // Connect to Hive Server 2 using JDBC 
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    
	boolean setTempPath = "true".equals(ElementParameterParser.getValue(node, "__SET_TEMP_PATH__"));
	if(setTempPath) {
		String tempPath = ElementParameterParser.getValue(node, "__TEMP_PATH__");

    stringBuffer.append(TEXT_175);
    stringBuffer.append(tempPath);
    stringBuffer.append(TEXT_66);
    
	}

	String yarnClasspathSeparator = ElementParameterParser.getValue(node, "__CLASSPATH_SEPARATOR__");

    stringBuffer.append(TEXT_176);
    stringBuffer.append(yarnClasspathSeparator);
    stringBuffer.append(TEXT_66);
    

	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	if(("true").equals(useExistingConn)) {
		String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
		String conn = "conn_" + connection;
		String db = "db_" + connection;
		String dbUser = "dbUser_" + connection;
		
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(db);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(dbUser);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    
	} else {
		String javaDbDriver = "org.apache.hadoop.hive.jdbc.HiveDriver";
		String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
		String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
		String fsDefalutName = "fs.default.name";
		String hiveServer = ElementParameterParser.getValue(node, "__HIVE_SERVER__");

		boolean setMapredJT = "true".equals(ElementParameterParser.getValue(node, "__SET_MAPRED_JT__"));
		boolean setNamenode = "true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"));
		List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");

    	String storeByHBase = ElementParameterParser.getValue(node, "__STORE_BY_HBASE__");
    	String zookeeperQuorumForHBase = ElementParameterParser.getValue(node, "__ZOOKEEPER_QUORUM__");
    	String zookeeperClientPortForHBase = ElementParameterParser.getValue(node, "__ZOOKEEPER_CLIENT_PORT__");

    	boolean setZNodeParent = "true".equals(ElementParameterParser.getValue(node, "__SET_ZNODE_PARENT__"));
		String zNodeParent = ElementParameterParser.getValue(node, "__ZNODE_PARENT__");

		String hbaseMasterPrincipal = ElementParameterParser.getValue(node, "__HBASE_MASTER_PRINCIPAL__");
		String hbaseRegionServerPrincipal = ElementParameterParser.getValue(node, "__HBASE_REGIONSERVER_PRINCIPAL__");

    	String defineRegisterJar = ElementParameterParser.getValue(node, "__DEFINE_REGISTER_JAR__");
    	List<Map<String, String>> registerJarForHBase = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__REGISTER_JAR__");

		boolean useYarn = "true".equals(ElementParameterParser.getValue(node, "__USE_YARN__"));

		boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
		boolean securityIsEnabled = useKrb && (isCustom || (hiveDistrib.doSupportKerberos() && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer))));
		boolean securedStandaloneHive2 = securityIsEnabled && "HIVE2".equalsIgnoreCase(hiveServer) && "STANDALONE".equalsIgnoreCase(connectionMode);
		boolean securedEmbedded = securityIsEnabled && "EMBEDDED".equalsIgnoreCase(connectionMode);
		boolean securedEmbeddedHive2 = securedEmbedded && "HIVE2".equalsIgnoreCase(hiveServer);

		String hivePrincipal = ElementParameterParser.getValue(node, "__HIVE_PRINCIPAL__");
		boolean useSsl = "true".equals(ElementParameterParser.getValue(node, "__USE_SSL__"));
		String sslTrustStore = ElementParameterParser.getValue(node, "__SSL_TRUST_STORE__");
		String sslStorepasswordFieldName = "__SSL_TRUST_STORE_PASSWORD__";

        boolean useMapRTicket = ElementParameterParser.getBooleanValue(node, "__USE_MAPRTICKET__");
        String mapRTicketUsername = ElementParameterParser.getValue(node, "__MAPRTICKET_USERNAME__");
        String mapRTicketCluster = ElementParameterParser.getValue(node, "__MAPRTICKET_CLUSTER__");
        String mapRTicketDuration = ElementParameterParser.getValue(node, "__MAPRTICKET_DURATION__");

        boolean setMapRHomeDir = ElementParameterParser.getBooleanValue(node, "__SET_MAPR_HOME_DIR__");
        String mapRHomeDir = ElementParameterParser.getValue(node, "__MAPR_HOME_DIR__");

        boolean setMapRHadoopLogin = ElementParameterParser.getBooleanValue(node, "__SET_HADOOP_LOGIN__");
        String mapRHadoopLogin = ElementParameterParser.getValue(node, "__HADOOP_LOGIN__");

        String passwordFieldName = "";

		if(hiveServer!=null && !"".equals(hiveServer.trim()) && (isCustom || hiveDistrib.doSupportHive2())) {
			hiveServer = hiveServer.toLowerCase();
			if ("hive2".equals(hiveServer)) {
				javaDbDriver = "org.apache.hive.jdbc.HiveDriver";
			}
		} else {
			hiveServer = "hive";
		}

		if(("hive".equals(hiveServer) && !hiveDistrib.doSupportHive1()) || ("hive2".equals(hiveServer) && !hiveDistrib.doSupportHive2())) {

    stringBuffer.append(TEXT_194);
    stringBuffer.append(hiveDistrib.getVersion());
    stringBuffer.append(TEXT_195);
    
		}

		if(("STANDALONE".equals(connectionMode) && !hiveDistrib.doSupportStandaloneMode()) || ("EMBEDDED".equals(connectionMode) && !hiveDistrib.doSupportEmbeddedMode())) {

    stringBuffer.append(TEXT_194);
    stringBuffer.append(hiveDistrib.getVersion());
    stringBuffer.append(TEXT_196);
    
		}

		if("STANDALONE".equals(connectionMode) && "hive".equals(hiveServer) && !hiveDistrib.doSupportHive1Standalone()) {

    stringBuffer.append(TEXT_197);
    
		}

		if(hadoopProps.size() > 0){
			for(Map<String, String> item : hadoopProps){

    stringBuffer.append(TEXT_198);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_66);
    
			}
		}

		if(securedEmbedded) {
			String metastoreUrl = ElementParameterParser.getValue(node, "__METASTORE_JDBC_URL__");
			String driverClass = ElementParameterParser.getValue(node, "__METASTORE_CLASSNAME__");
			String metastoreUsername = ElementParameterParser.getValue(node, "__METASTORE_USERNAME__");
			boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
			String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
			String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");

    stringBuffer.append(TEXT_200);
    stringBuffer.append(driverClass);
    stringBuffer.append(TEXT_201);
    if(securedEmbeddedHive2){
				// Disable authorization when using local HiveServer2 in secure mode
				
    stringBuffer.append(TEXT_202);
    
			}else{
				
    stringBuffer.append(TEXT_203);
    
			}
			
    stringBuffer.append(TEXT_204);
    stringBuffer.append(metastoreUrl);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(metastoreUsername);
    stringBuffer.append(TEXT_206);
    
    		passwordFieldName = "__METASTORE_PASSWORD__";
    		
    stringBuffer.append(TEXT_207);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_209);
    } else {
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_210);
    }
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_201);
    
			if(securedEmbeddedHive2){
				
    stringBuffer.append(TEXT_213);
    stringBuffer.append(ElementParameterParser.getValue(node, "__HIVESERVER2_LOCAL_PRINCIPAL__"));
    stringBuffer.append(TEXT_214);
    stringBuffer.append(ElementParameterParser.getValue(node, "__HIVESERVER2_LOCAL_KEYTAB__"));
    stringBuffer.append(TEXT_215);
    
			}
			
    stringBuffer.append(TEXT_172);
    
			if(useKeytab) {

    stringBuffer.append(TEXT_216);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_66);
    
			}
		}

		if(((isCustom && !useYarn) || (!isCustom && hiveDistrib.isHadoop1())) && setMapredJT) {
			String mapredJT = ElementParameterParser.getValue(node, "__MAPRED_JT__");

    stringBuffer.append(TEXT_217);
    stringBuffer.append(mapredJT);
    stringBuffer.append(TEXT_66);
    
		}

		if(setNamenode) {
			String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");

    stringBuffer.append(TEXT_218);
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_66);
    
		}

    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_221);
    
		passwordFieldName = "__PASS__";
		
    stringBuffer.append(TEXT_222);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_66);
    } else {
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_69);
    }
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    
        boolean setHadoopUser = "true".equals(ElementParameterParser.getValue(node, "__SET_HADOOP_USER__"));
        if (setHadoopUser) {
            String hadoopUser = ElementParameterParser.getValue(node, "__HADOOP_USER__");
            
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(hadoopUser);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_232);
    
        }
        
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    
		if("EMBEDDED".equals(connectionMode) && (isCustom || hiveDistrib.doSupportEmbeddedMode())) {

    stringBuffer.append(TEXT_235);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_238);
    
			if(isCustom || (!isCustom && hiveDistrib.doSupportImpersonation())) {

    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_242);
    
			}
		} else if("STANDALONE".equals(connectionMode) && (isCustom || hiveDistrib.doSupportStandaloneMode())) {
				if(securedStandaloneHive2) {
					// using keytab with HiveServer2 in standalone mode
					boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
					String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
					String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
                    
					if ((isCustom || hiveDistrib.doSupportMapRTicket()) && useMapRTicket) {
                        
    stringBuffer.append(TEXT_243);
    stringBuffer.append(setMapRHomeDir ? mapRHomeDir : "\"/opt/mapr\"" );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(setMapRHadoopLogin ? mapRHadoopLogin : "\"kerberos\"");
    stringBuffer.append(TEXT_66);
    
                    }
					if(useKeytab) {

    stringBuffer.append(TEXT_245);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_66);
    
					}
					// Using SSL in Secure Mode
					if(useSsl && hiveDistrib.doSupportSSL()){
						// Does the distrib support SSL + KERBEROS
						if(hiveDistrib.doSupportSSLwithKerberos()){
							if (ElementParameterParser.canEncrypt(node, sslStorepasswordFieldName)) {

    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, sslStorepasswordFieldName));
    stringBuffer.append(TEXT_66);
    
							}else{

    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append( ElementParameterParser.getValue(node, sslStorepasswordFieldName));
    stringBuffer.append(TEXT_247);
    
							}

    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(sslTrustStore);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    
						// Does the distrib support only SASL-QOP + KERBEROS
						} else {
						

    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_254);
    
						}
					}else{

    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_247);
    
					}
					if ((isCustom || hiveDistrib.doSupportMapRTicket()) && useMapRTicket) {
                        
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(mapRTicketCluster);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(mapRTicketDuration);
    stringBuffer.append(TEXT_66);
    
                    }
				} else {
                    // Mapr ticket
				    if ((isCustom || hiveDistrib.doSupportMapRTicket()) && useMapRTicket) {
                        passwordFieldName = "__MAPRTICKET_PASSWORD__";
                        
    stringBuffer.append(TEXT_243);
    stringBuffer.append(setMapRHomeDir ? mapRHomeDir : "\"/opt/mapr\"" );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    
                        if (setMapRHadoopLogin) {
                            
    stringBuffer.append(TEXT_261);
    stringBuffer.append(mapRHadoopLogin);
    stringBuffer.append(TEXT_66);
    
                        } else {
                            
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    
                        }
                        if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_66);
    } else {
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_247);
    }
                        	if(hiveDistrib.doSupportMaprTicketV52API()){
                				
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(mapRTicketCluster);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(mapRTicketUsername);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(mapRTicketDuration);
    stringBuffer.append(TEXT_268);
    
                			} else {
                				
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(mapRTicketCluster);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(mapRTicketUsername);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(mapRTicketDuration);
    stringBuffer.append(TEXT_269);
    
                			}
                    }

                    // Using SSL in non Secure Mode
					if(useSsl && hiveDistrib.doSupportSSL()){
						if (ElementParameterParser.canEncrypt(node, sslStorepasswordFieldName)) {

    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, sslStorepasswordFieldName));
    stringBuffer.append(TEXT_66);
    
						}else{

    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append( ElementParameterParser.getValue(node, sslStorepasswordFieldName));
    stringBuffer.append(TEXT_247);
    
						}

    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(sslTrustStore);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    
					}else{

    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_247);
    
					}
				}
				String additionalJdbcSettings = ElementParameterParser.getValue(node, "__HIVE_ADDITIONAL_JDBC__");

    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(additionalJdbcSettings);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    
			}

    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(javaDbDriver );
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    
	   		log4jCodeGenerateUtil.debugConnectionParams(node);
		
    stringBuffer.append(TEXT_284);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    }
    
		if(securedStandaloneHive2) {

    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    
		} else {

    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    
		}

    stringBuffer.append(TEXT_284);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_291);
    }
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    
    	if(!isCustom && ("HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion))) {
        	String mapMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_MAP_MEMORY_MB__");
       		String reduceMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_REDUCE_MEMORY_MB__");

    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_66);
    
	}

	boolean isKerberosAvailableHadoop2 = !isCustom && hiveDistrib.isHadoop2() && hiveDistrib.doSupportKerberos();
	boolean isHadoop2 = !isCustom && hiveDistrib.isHadoop2();
	boolean isKerberosAvailableHadoop1 = !isCustom && hiveDistrib.isHadoop1() && hiveDistrib.doSupportKerberos();

	if(securedEmbedded) {
		String namenodePrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");

    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(namenodePrincipal);
    stringBuffer.append(TEXT_66);
    
		if(isKerberosAvailableHadoop1 || (isCustom && !useYarn)) {
			String jobtrackerPrincipal = ElementParameterParser.getValue(node, "__JOBTRACKER_PRINCIPAL__");

    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(jobtrackerPrincipal);
    stringBuffer.append(TEXT_66);
    
		}
		if(isKerberosAvailableHadoop2 || (isCustom && useYarn)) {
			String resourceManagerPrincipal = ElementParameterParser.getValue(node, "__RESOURCEMANAGER_PRINCIPAL__");

    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(resourceManagerPrincipal);
    stringBuffer.append(TEXT_66);
    
		}

	}

    	boolean setResourceManager = "true".equals(ElementParameterParser.getValue(node, "__SET_RESOURCE_MANAGER__"));

    	if((isCustom && useYarn) || (!isCustom && isHadoop2)) {
    		if(setResourceManager) {
    			String resourceManager = ElementParameterParser.getValue(node, "__RESOURCE_MANAGER__");

    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(resourceManager);
    stringBuffer.append(TEXT_66);
    
			}

			boolean setJobHistoryAddress = "true".equals(ElementParameterParser.getValue(node, "__SET_JOBHISTORY_ADDRESS__"));
			if(setJobHistoryAddress) {
				String jobHistoryAddress = ElementParameterParser.getValue(node,"__JOBHISTORY_ADDRESS__");
    			
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(jobHistoryAddress);
    stringBuffer.append(TEXT_308);
    
			}

    		boolean setSchedulerAddress = "true".equals(ElementParameterParser.getValue(node, "__SET_SCHEDULER_ADDRESS__"));
    		if(setSchedulerAddress) {
    			String schedulerAddress = ElementParameterParser.getValue(node,"__RESOURCEMANAGER_SCHEDULER_ADDRESS__");

    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(schedulerAddress);
    stringBuffer.append(TEXT_66);
    
			}

            if ("true".equals(ElementParameterParser.getValue(node, "__USE_DATANODE_HOSTNAME__"))) {
                
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    
            }

    		if("true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"))) {
    			String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");

    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_66);
    
			}

			if("EMBEDDED".equals(connectionMode) && (isCustom || hiveDistrib.doSupportEmbeddedMode())) {
				boolean crossPlatformSubmission = "true".equals(ElementParameterParser.getValue(node, "__CROSS_PLATFORM_SUBMISSION__"));
				if((isCustom && useYarn && crossPlatformSubmission) || (!isCustom && hiveDistrib.doSupportCrossPlatformSubmission())) {

    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    
				}

				if("MAPR410".equals(hiveVersion)){

    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_316);
    
				}

				if(hiveDistrib.doSupportCustomMRApplicationCP()){

    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(hiveDistrib.getCustomMRApplicationCP());
    stringBuffer.append(TEXT_318);
    
				}


    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(hiveDistrib.getYarnApplicationClasspath());
    stringBuffer.append(TEXT_318);
    
			}

    		boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
    		if(setMemory) {
    			String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
    			String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
    			String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_66);
    
			}
		}

		List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
		if(advProps!=null) {
			for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_111);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_66);
    
			}
		}

    stringBuffer.append(TEXT_222);
    
		if(("false").equals(useExistingConn)){
		
    stringBuffer.append(TEXT_326);
    stringBuffer.append(TEXT_172);
    
class PrepareTez{
	public void invoke(INode node, String cid){
        String hiveDistribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
        String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");

        org.talend.hadoop.distribution.component.HiveComponent hiveDistrib = null;
        try {
            hiveDistrib = (org.talend.hadoop.distribution.component.HiveComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(hiveDistribution, hiveVersion);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }

        boolean isCustom = hiveDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;

        boolean changePathSeparator = !hiveDistrib.isExecutedThroughWebHCat();

        String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
        List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
        String dbuser = ElementParameterParser.getValue(node, "__USER__");
        
        boolean useTez = "tez".equals(ElementParameterParser.getValue(node, "__EXECUTION_ENGINE__"));
    	boolean supportTez = (isCustom || hiveDistrib.doSupportTezForHive()) && "EMBEDDED".equals(connectionMode);
    	if(supportTez && useTez){
    	
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    
            if(advProps != null){
                for(Map<String, String> item : advProps){
                    if("\"tez.lib.uris\"".equals(item.get("PROPERTY"))){
                    
    stringBuffer.append(TEXT_329);
      
                    }
                }
            }
            boolean installTez = "INSTALL".equals(ElementParameterParser.getValue(node, "__TEZ_LIB__"));
            if(installTez){
                //prepare the folder
                
    stringBuffer.append(TEXT_172);
    
class GetFileSystem{
	public void invoke(INode node, String cid){
        String fsDefaultName = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");
        List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");
        String user = null;
        
        String fsDefaultNameKey = "fs.default.name";
        
        String distribution = null;
        String hadoopVersion = null;
        boolean isCustom = false;

        String dbuser = ElementParameterParser.getValue(node, "__USER__");
        
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    
        distribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
        hadoopVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
        boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
        String kerberosPrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");
        boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
        String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
        String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
        boolean mrUseDatanodeHostname = "true".equals(ElementParameterParser.getValue(node, "__USE_DATANODE_HOSTNAME__"));

        org.talend.hadoop.distribution.component.HDFSComponent hdfsDistrib = null;
        try {
            hdfsDistrib = (org.talend.hadoop.distribution.component.HDFSComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(distribution, hadoopVersion);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }

        isCustom = hdfsDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;
        
        
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(fsDefaultNameKey);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_338);
    
        if(mrUseDatanodeHostname && (isCustom || hdfsDistrib.doSupportUseDatanodeHostname())){
        
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    
        }
        if(hadoopProps!=null && hadoopProps.size() > 0){
        	for(Map<String, String> item : hadoopProps){
        	
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_343);
     
    		}
    	}
        	
    	if((hdfsDistrib.doSupportKerberos() && useKrb && !isCustom) || (isCustom && useKrb)){
    	
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(kerberosPrincipal);
    stringBuffer.append(TEXT_347);
    
    		if(useKeytab){
    		
    stringBuffer.append(TEXT_348);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_347);
    
    		}
    	}
    	
    	if(hdfsDistrib.doSupportGroup()){
    		
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    
        }else{
        
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(fsDefaultNameKey);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    
        }
    }
}

      
                (new GetFileSystem()).invoke(node, cid);
                String tezLibFolder = ElementParameterParser.getValue(node, "__TEZ_LIB_FOLDER__");
                boolean useDefaultTezLibFolder = "\"/tmp/{USERNAME}/talend_tez_libs/{custom|HIVE_VERSION}\"".equals(tezLibFolder);
                if(useDefaultTezLibFolder){
                
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(isCustom?"custom":hiveVersion);
    stringBuffer.append(TEXT_367);
    
                }else{
                
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(tezLibFolder);
    stringBuffer.append(TEXT_247);
    
                }
                
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    
                List<String> tezLibJarsName = new java.util.ArrayList<String>();
                if(isCustom){
                    List<Map<String,String>> tezLibJarsNameValue = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__TEZ_LIB_NAME__");
                    for(Map<String, String> tezLibJarsNameV : tezLibJarsNameValue){
                        tezLibJarsName.add(tezLibJarsNameV.get("JAR_NAME"));
                    }
                }else{
                    String tezLibJarsNameValue = ElementParameterParser.getValue(node, "__TEZ_JARS_NAME__");
                    if(tezLibJarsNameValue != null && !"".equals(tezLibJarsNameValue)){
                        tezLibJarsName = java.util.Arrays.asList(tezLibJarsNameValue.split(","));
                    }
                }
                
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    if(changePathSeparator){
    stringBuffer.append(TEXT_373);
    }else{
    stringBuffer.append(TEXT_374);
    }
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    
                    for(String jarName : tezLibJarsName){
                    
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(jarName);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(jarName);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_389);
    
                    }
                    
    stringBuffer.append(TEXT_390);
    
            }else{
            
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(ElementParameterParser.getValue(node, "__TEZ_LIB_PATH__"));
    stringBuffer.append(TEXT_247);
    
            }
            //define the location of tez lib    
            
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__"));
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_408);
    
    	}
    }
}

    stringBuffer.append(TEXT_409);
    
            	(new PrepareTez()).invoke(node, cid);
        }
    	
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    if("true".equalsIgnoreCase(storeByHBase) && (isCustom || hiveDistrib.doSupportHBaseForHive())) {
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_414);
    if(zookeeperQuorumForHBase!=null && !"".equals(zookeeperQuorumForHBase) && !"\"\"".equals(zookeeperQuorumForHBase)) {
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(zookeeperQuorumForHBase);
    stringBuffer.append(TEXT_347);
    }
    stringBuffer.append(TEXT_417);
    if(zookeeperClientPortForHBase!=null && !"".equals(zookeeperClientPortForHBase) && !"\"\"".equals(zookeeperClientPortForHBase)) {
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(zookeeperClientPortForHBase);
    stringBuffer.append(TEXT_343);
    }
    stringBuffer.append(TEXT_420);
    if(setZNodeParent && zNodeParent!=null && !"".equals(zNodeParent) && !"\"\"".equals(zNodeParent)) {
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(zNodeParent);
    stringBuffer.append(TEXT_201);
    }
    stringBuffer.append(TEXT_420);
    if(useKrb){
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    if(hbaseMasterPrincipal!=null && !"".equals(hbaseMasterPrincipal) && !"\"\"".equals(hbaseMasterPrincipal)){
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(hbaseMasterPrincipal);
    stringBuffer.append(TEXT_215);
    }
    stringBuffer.append(TEXT_427);
    if(hbaseRegionServerPrincipal!=null && !"".equals(hbaseRegionServerPrincipal) && !"\"\"".equals(hbaseRegionServerPrincipal)){
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(hbaseRegionServerPrincipal);
    stringBuffer.append(TEXT_215);
    }
    stringBuffer.append(TEXT_429);
    }
    stringBuffer.append(TEXT_417);
    if("true".equalsIgnoreCase(defineRegisterJar) && registerJarForHBase!=null && registerJarForHBase.size()>0) {
        		for(Map<String, String> jar : registerJarForHBase){
        			String path = jar.get("JAR_PATH");
        			if(path == null || "".equals(path) || "\"\"".equals(path)) {
        				continue;
        			}
        	
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_347);
    
    			}
    		}

    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    
	  	}
	}

    
    }

    String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
    String tableName = ElementParameterParser.getValue(node, "__TABLE__");
    String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
    boolean external = "true".equals(ElementParameterParser.getValue(node, "__CREATE_EXTERNAL__"));
    String tableAction = ElementParameterParser.getValue(node,"__TABLEACTION__");
    boolean createIfNotExist = "CREATE_IF_NOT_EXIST".equals(tableAction);
    boolean setPartitioned = "true".equals(ElementParameterParser.getValue(node, "__SET_PARTITIONS__"));
    boolean setClustered = false;
    boolean setSkewed = false;

    boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));

    String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
    boolean setFsDefaultName = "true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"));
    String fsDefaultName = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");
    INode connectionInformationNode = node;

    if(useExistingConnection && !hiveDistrib.useCloudLauncher()) {
        connectionMode = "";
        setFsDefaultName = false;
        fsDefaultName = "";
        dbuser = "";
        String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
        for (INode pNode : node.getProcess().getNodesOfType("tHiveConnection")) {
            if(connection!=null && connection.equals(pNode.getUniqueName())) {
                connectionMode = ElementParameterParser.getValue(pNode, "__CONNECTION_MODE__");
                setFsDefaultName = "true".equals(ElementParameterParser.getValue(pNode, "__SET_FS_DEFAULT_NAME__"));
                fsDefaultName = ElementParameterParser.getValue(pNode, "__FS_DEFAULT_NAME__");
                dbuser = ElementParameterParser.getValue(pNode, "__USER__");
                connectionInformationNode = pNode;
                break;
            }
        }
    }

    boolean setLocation = "true".equals(ElementParameterParser.getValue(node, "__SET_FILE_LOCATION__"));
    String location = ElementParameterParser.getValue(node, "__FILE_LOCATION__");
    boolean isS3Location = "true".equals(ElementParameterParser.getValue(node, "__S3_LOCATION__"));

    String storedFormat = ElementParameterParser.getValue(node, "__STORAGE_FORMAT__");

    List<Map<String, String>> serdeProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SERDE_PROPERTIES__");

    List<Map<String, String>> tableProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TABLE_PROPERTIES__");

    boolean setDelimitedRowFormat = "true".equals(ElementParameterParser.getValue(node, "__SET_ROW_FORMAT__"));
    boolean setSerdeRowFormat = "true".equals(ElementParameterParser.getValue(node, "__SET_SERDE_ROW_FORMAT__"));

    boolean setRowFormat = (setDelimitedRowFormat || setSerdeRowFormat) && !"STORAGE".equals(storedFormat);

    boolean storeAsAvro = "AVRO".equals(storedFormat);
    boolean storeAsParquet = "PARQUET".equals(storedFormat);

    boolean isParquetSupported = isCustom || hiveDistrib.doSupportParquetFormat();
    if(storeAsParquet && !isParquetSupported) {

    stringBuffer.append(TEXT_433);
    
    }

    // Register jars to handle the parquet format.

    boolean generateAddJarCodeForAll = true;
    java.util.List<String> jarsToRegister = null;
    java.util.List<String> jars = null;

    jarsToRegister = new java.util.ArrayList();

    if(true || generateAddJarCodeForAll) {
        String[] commandLine = new String[] {"<command>"};
        try {
            commandLine = ProcessorUtilities.getCommandLine("win32",true, processId, "",org.talend.designer.runprocess.IProcessor.NO_STATISTICS,org.talend.designer.runprocess.IProcessor.NO_TRACES, new String[]{});
        } catch (ProcessorException e) {
            e.printStackTrace();
        }

        jarsToRegister.add("parquet-hive-bundle");
        //jarsToRegister.add("parquet-hadoop-bundle");
        jarsToRegister.add("snappy-java");


        for (int j = 0; j < commandLine.length; j++) {
            if(commandLine[j].contains("jar")) {
                jars = java.util.Arrays.asList(commandLine[j].split(";"));
                break;
            }
        }
    }

    jarsToRegister.add("hive-hbase-handler");
    if(jarsToRegister!=null && jars!=null) {
        if("EMBEDDED".equalsIgnoreCase(connectionMode) || hiveDistrib.useCloudLauncher()) {

    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_435);
    
        } else {
            generateAddJarCodeForAll = false;
            if(setFsDefaultName) {
                generateAddJarCodeForAll = true;

    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_437);
    stringBuffer.append(TEXT_172);
    
class GetFileSystem{
	public void invoke(INode node, String cid){
        String fsDefaultName = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");
        List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");
        String user = null;
        
        String fsDefaultNameKey = "fs.default.name";
        
        String distribution = null;
        String hadoopVersion = null;
        boolean isCustom = false;

        String dbuser = ElementParameterParser.getValue(node, "__USER__");
        
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    
        distribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
        hadoopVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
        boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
        String kerberosPrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");
        boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
        String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
        String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
        boolean mrUseDatanodeHostname = "true".equals(ElementParameterParser.getValue(node, "__USE_DATANODE_HOSTNAME__"));

        org.talend.hadoop.distribution.component.HDFSComponent hdfsDistrib = null;
        try {
            hdfsDistrib = (org.talend.hadoop.distribution.component.HDFSComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(distribution, hadoopVersion);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }

        isCustom = hdfsDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;
        
        
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(fsDefaultNameKey);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_338);
    
        if(mrUseDatanodeHostname && (isCustom || hdfsDistrib.doSupportUseDatanodeHostname())){
        
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    
        }
        if(hadoopProps!=null && hadoopProps.size() > 0){
        	for(Map<String, String> item : hadoopProps){
        	
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_343);
     
    		}
    	}
        	
    	if((hdfsDistrib.doSupportKerberos() && useKrb && !isCustom) || (isCustom && useKrb)){
    	
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(kerberosPrincipal);
    stringBuffer.append(TEXT_347);
    
    		if(useKeytab){
    		
    stringBuffer.append(TEXT_348);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_347);
    
    		}
    	}
    	
    	if(hdfsDistrib.doSupportGroup()){
    		
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    
        }else{
        
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(fsDefaultNameKey);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    
        }
    }
}

    stringBuffer.append(TEXT_429);
    
			(new GetFileSystem()).invoke(connectionInformationNode, cid);
			
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_450);
    
            }
        }

        if(generateAddJarCodeForAll) {
            if(!hiveDistrib.useCloudLauncher()) { // Then we create a SQL statement to add the jars.

    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    
            }
            for(int i=0; i<jarsToRegister.size(); i++) {
                String jarToRegister = jarsToRegister.get(i);
                for(int j=0; j<jars.size(); j++) {
                    if(jars.get(j).contains(jarToRegister)) {
                        if(!hiveDistrib.useCloudLauncher()) { // Then we use the created SQL statement to add the jars.

    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_455);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_457);
    
                        } else { // cloud distribution
                            if(hiveDistrib.isExecutedThroughWebHCat()) {

    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_455);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_455);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_463);
    
                            } else if (hiveDistrib.isQuboleDistribution()) {

    stringBuffer.append(TEXT_464);
    
                            } else { // dataproc
                                if(isLog4jEnabled) {

    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_455);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_467);
    
                                }

    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_455);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_455);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_463);
    
                            }
                        }
                    }
                }
            }
        }
    }

    // End of parquet format handling.
    if(!hiveDistrib.useCloudLauncher()) {

    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_293);
    
    }

    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_247);
    
List<IMetadataColumn> listColumn = null;
List<IMetadataTable> metadatas = node.getMetadataList();
if(metadatas != null && metadatas.size() > 0) {
    IMetadataTable metadata = metadatas.get(0);
    listColumn = metadata.getListColumns();
}

StringBuilder createTableSQL = new StringBuilder();

createTableSQL.append("CREATE ");
createTableSQL.append(external || isS3Location ?"EXTERNAL":"");
createTableSQL.append(" TABLE ");
createTableSQL.append(createIfNotExist?"IF NOT EXISTS":"");
createTableSQL.append(" \" + ");
createTableSQL.append("tableName_");
createTableSQL.append(cid);
createTableSQL.append(" + \"");

boolean likeTable = "true".equals(ElementParameterParser.getValue(node, "__LIKE_TABLE__"));
if(likeTable) {
    String likeTableName = ElementParameterParser.getValue(node, "__LIKE_TABLE_NAME__");

    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(likeTableName);
    stringBuffer.append(TEXT_247);
    
    createTableSQL.append(" LIKE ");
    createTableSQL.append("\" + ");
    createTableSQL.append("likeTableName_");
    createTableSQL.append(cid);
    createTableSQL.append(" + \"");

    if(setLocation) {

    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(location);
    stringBuffer.append(TEXT_247);
    
        createTableSQL.append(" LOCATION '");
        createTableSQL.append("\" + ");
        createTableSQL.append("location_");
        createTableSQL.append(cid);
        createTableSQL.append(" + \"'");
    }

    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_281);
    stringBuffer.append(createTableSQL.toString());
    stringBuffer.append(TEXT_367);
    
        if(!hiveDistrib.useCloudLauncher()) {

    stringBuffer.append(TEXT_476);
    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_482);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
     
if(hiveDistrib.doSupportTezForHive()) {

    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    
}

    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_488);
    if(("true").equals(dieOnError)) {
    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    }else {
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_491);
    }
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_498);
    
            if(!("true").equals(useExistingConn)) {

    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_432);
    
            }
        } else { // cloud distribution
            if(hiveDistrib.isExecutedThroughWebHCat()) {

    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_510);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_511);
    
                    if(("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_512);
    
                    } else {

    stringBuffer.append(TEXT_513);
    
                        if(isLog4jEnabled) {

    stringBuffer.append(TEXT_514);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_515);
    
                        }
                    }

    stringBuffer.append(TEXT_516);
    
            } else if (hiveDistrib.isQuboleDistribution()) {
            
    
            	if (isLog4jEnabled) {
            	
    stringBuffer.append(TEXT_517);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_519);
    
            	}
            	if (quboleClusterLabel != null) {
            	
    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_521);
    stringBuffer.append(quboleClusterLabel);
    stringBuffer.append(TEXT_522);
    
            	} else {

    stringBuffer.append(TEXT_523);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_524);
    
				}
            } else { // dataproc
                if(isLog4jEnabled) {

    stringBuffer.append(TEXT_525);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_527);
    
                }

    stringBuffer.append(TEXT_528);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_529);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_530);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_531);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_534);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_511);
    
                    if(("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_512);
    
                    } else {

    stringBuffer.append(TEXT_513);
    
                        if(isLog4jEnabled) {

    stringBuffer.append(TEXT_514);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_515);
    
                        }
                    }

    stringBuffer.append(TEXT_516);
    
            }
        }
    return stringBuffer.toString();
}

boolean asSelect = "true".equals(ElementParameterParser.getValue(node, "__AS_SELECT__"));

if(!storeAsAvro && !asSelect) {
    createTableSQL.append("(");
}

final MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever("hive_id");

    
	class Util {
		int index = 0;
		java.util.Map<String,String> hiveTypeToAvroType = null;
		String appendKeyValue = null;
	
		void generateColumnsSQL(List<IMetadataColumn> listColumn,StringBuilder createTableSQL) {
			index++;
			int count = 0;
			String ending = ",";
			for(IMetadataColumn metadataColumn : listColumn) {
				createTableSQL.append(metadataColumn.getOriginalDbColumnName());
				createTableSQL.append(" ");
            
				String hiveType = null;
				if(metadataColumn.getType() == null || metadataColumn.getType().trim().length() == 0) {
					hiveType = mappingType.getDefaultSelectedDbType(metadataColumn.getTalendType());
				} else {
					// Replace VARCHAR2 with VARCHAR since Hive can only handle the latter
					hiveType = "VARCHAR2".equals(metadataColumn.getType()) ? "VARCHAR" : metadataColumn.getType();
				}
        		createTableSQL.append(hiveType);
        		if(metadataColumn.getLength() != null && metadataColumn.getPrecision() != null && "DECIMAL".equals(hiveType)) {
        			createTableSQL.append("(" + metadataColumn.getLength() + ", " + metadataColumn.getPrecision() + ")");
        		} else if(metadataColumn.getLength() != null && "VARCHAR".equals(hiveType)) {
        			createTableSQL.append("(" + metadataColumn.getLength() + ")");
        		}
        	
	        	String comment = metadataColumn.getComment();
	        	if(comment!=null && !"".equals(comment) && !"\"\"".equals(comment)) {
	        	
	        		if(!comment.trim().startsWith("\"") && !comment.trim().endsWith("\"")) {
	        			comment = "\"" + comment + "\"";
	        		}

    stringBuffer.append(TEXT_535);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_536);
    stringBuffer.append(count);
    stringBuffer.append(TEXT_536);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(comment);
    stringBuffer.append(TEXT_247);
    
	        		createTableSQL.append(" COMMENT '");
		    		createTableSQL.append("\" + ");
	    			createTableSQL.append("comment_");
	    			createTableSQL.append(index);
	    			createTableSQL.append("_");
	    			createTableSQL.append(count);
	    			createTableSQL.append("_");
	    			createTableSQL.append(cid);
	        		createTableSQL.append(" + \"'");
        		}
            
            if(count == listColumn.size() - 1) {
                ending = "";
            }
            createTableSQL.append(ending);
            count++;
			}
		}
	
		void generateAvroSchema(List<IMetadataColumn> listColumn,StringBuilder schemaBuilder, String quote) {
			String nullablePrefix = "[ " + quote + "null" + quote + ", ";
			String nullablePostfix = "]";

			if(hiveTypeToAvroType == null) {
				hiveTypeToAvroType = new java.util.HashMap<String,String>();
				hiveTypeToAvroType.put("SMALLINT","int");
				hiveTypeToAvroType.put("FLOAT","float");
				hiveTypeToAvroType.put("DOUBLE","double");
				hiveTypeToAvroType.put("BIGINT","long");
				hiveTypeToAvroType.put("INT","int");
				hiveTypeToAvroType.put("TINYINT","int");
				hiveTypeToAvroType.put("STRING","string");
				hiveTypeToAvroType.put("BOOLEAN","boolean");
				hiveTypeToAvroType.put("STRUCT","record");
				hiveTypeToAvroType.put("MAP","map");
				hiveTypeToAvroType.put("ARRAY","list");
				hiveTypeToAvroType.put("TIMESTAMP","long");
			}
		
			index++;
		
			int count = 0;
			String ending = ",";
			for(IMetadataColumn metadataColumn : listColumn) {
        		schemaBuilder.append("{");
        	
        		schemaBuilder.append(quote).append("name").append(quote);
            schemaBuilder.append(" : ");
            schemaBuilder.append(quote).append(metadataColumn.getOriginalDbColumnName()).append(quote);
            
            schemaBuilder.append(", ");
            
            String hiveType = null;
            if(metadataColumn.getType() == null || metadataColumn.getType().trim().length() == 0) {
                hiveType = mappingType.getDefaultSelectedDbType(metadataColumn.getTalendType());
            } else {
                hiveType = metadataColumn.getType();
            }
            
            String avroType = hiveTypeToAvroType.get(hiveType);
            
            schemaBuilder.append(quote).append("type").append(quote);
            schemaBuilder.append(" : ");
             
            if (metadataColumn.isNullable()) {
            	schemaBuilder.append(nullablePrefix);
            }

       		schemaBuilder.append(quote).append(avroType).append(quote);
        	
            if (metadataColumn.isNullable()) {
            	schemaBuilder.append(nullablePostfix);
            }

        		String comment = metadataColumn.getComment();
        		if(comment!=null && !"".equals(comment) && !"\"\"".equals(comment)) {
        		
        			if(!comment.trim().startsWith("\"") && !comment.trim().endsWith("\"")) {
	        			comment = "\"" + comment + "\"";
	        		}
        			schemaBuilder.append(", ");

    stringBuffer.append(TEXT_535);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_536);
    stringBuffer.append(count);
    stringBuffer.append(TEXT_536);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(comment);
    stringBuffer.append(TEXT_247);
    
	        		schemaBuilder.append(quote).append("doc").append(quote);
	        		schemaBuilder.append(" : ");
	        		schemaBuilder.append(quote);
	        		
		    		schemaBuilder.append("\" + ");
	    			schemaBuilder.append("comment_");
	    			schemaBuilder.append(index);
	    			schemaBuilder.append("_");
	    			schemaBuilder.append(count);
	    			schemaBuilder.append("_");
	    			schemaBuilder.append(cid);
	        		schemaBuilder.append(" + \"");
	        		
	        		schemaBuilder.append(quote);
        		}
            
            schemaBuilder.append("}");
            
            if(count == listColumn.size() - 1) {
                ending = "";
            }
            schemaBuilder.append(ending);
            count++;
			}
		}
	
		void generatePros(String prefix, List<Map<String, String>> pros, StringBuilder createTableSQL) {
			index++;
			
			int count = 0;
			String ending = ",";
			if(pros.size() > 0){
				createTableSQL.append(prefix);
				createTableSQL.append("(");
				for(Map<String, String> item : pros){

    stringBuffer.append(TEXT_537);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_536);
    stringBuffer.append(count);
    stringBuffer.append(TEXT_536);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_538);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_536);
    stringBuffer.append(count);
    stringBuffer.append(TEXT_536);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_247);
    
		    		createTableSQL.append("'\" + ");
	    			createTableSQL.append("key_");
	    			createTableSQL.append(index);
	    			createTableSQL.append("_");
	    			createTableSQL.append(count);
	    			createTableSQL.append("_");
	    			createTableSQL.append(cid);
	        		createTableSQL.append(" + \"'");
	        		
	        		createTableSQL.append(" = ");
	        		
	        		createTableSQL.append("'\" + ");
	    			createTableSQL.append("value_");
	    			createTableSQL.append(index);
	    			createTableSQL.append("_");
	    			createTableSQL.append(count);
	    			createTableSQL.append("_");
	    			createTableSQL.append(cid);
	        		createTableSQL.append(" + \"'");
        		
        			if(count == pros.size() - 1) {
            		ending = "";
        			}
            	
	            createTableSQL.append(ending);
            	count++;
				}
			
				if(appendKeyValue!=null) {
					createTableSQL.append(",");
					createTableSQL.append(appendKeyValue);
					appendKeyValue = null;
				}
			
				createTableSQL.append(")");
			} else if(appendKeyValue!=null) {
				createTableSQL.append(prefix);
				createTableSQL.append("(");
				createTableSQL.append(appendKeyValue);
				createTableSQL.append(")");
				appendKeyValue = null;
			}
		}
	
		void appendKeyValue(String appendKeyValue) {
			this.appendKeyValue = appendKeyValue;
		}
	}

    

Util util = new Util();

if(!storeAsAvro && !asSelect) {
    util.generateColumnsSQL(listColumn,createTableSQL);
    createTableSQL.append(")");
}

String tableComment = ElementParameterParser.getValue(node, "__TABLE_COMMENT__");
if(tableComment!=null && !"".equals(tableComment) && !"\"\"".equals(tableComment)) {

    stringBuffer.append(TEXT_539);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(tableComment);
    stringBuffer.append(TEXT_247);
    
    createTableSQL.append(" COMMENT '");
    createTableSQL.append("\" + ");
    createTableSQL.append("tableComment_");
    createTableSQL.append(cid);
    createTableSQL.append(" + \"'");
}

if(setPartitioned) {
    if ((metadatas!=null)&&(metadatas.size()>0)) {
        IMetadataTable metadata = metadatas.get(1);
        if (metadata!=null) {
            List<IMetadataColumn> columnList = metadata.getListColumns();
            if(columnList != null && columnList.size() > 0) {
                createTableSQL.append(" PARTITIONED BY (");
                util.generateColumnsSQL(columnList,createTableSQL);
                createTableSQL.append(")");
            }
        }
    }
}

boolean clustededOrSkewed = "true".equals(ElementParameterParser.getValue(node, "__SET_CLUSTERED_BY_AND_SKEWED_BY__"));
if(clustededOrSkewed) {
    String ddl = ElementParameterParser.getValue(node, "__CLUSTERED_BY_AND_SKEWED_BY__");
    ddl = ddl.replaceAll("\n"," ");
    ddl = ddl.replaceAll("\r"," ");

    stringBuffer.append(TEXT_540);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(ddl);
    stringBuffer.append(TEXT_247);
    
    createTableSQL.append(" \" + ");
    createTableSQL.append("clustededOrSkewed_");
    createTableSQL.append(cid);
    createTableSQL.append(" + \"");
}

if(storeAsAvro || !hiveDistrib.doSupportStoreAsParquet() && storeAsParquet) {
    createTableSQL.append(" ROW FORMAT SERDE '" + (storeAsAvro?"org.apache.hadoop.hive.serde2.avro.AvroSerDe":"parquet.hive.serde.ParquetHiveSerDe") + "'");
    util.generatePros(" WITH SERDEPROPERTIES ", serdeProps, createTableSQL);
} else if(setRowFormat) {
    createTableSQL.append(" ROW FORMAT ");
    if(setDelimitedRowFormat) {
        createTableSQL.append("DELIMITED ");
        boolean setField = "true".equals(ElementParameterParser.getValue(node, "__SET_FIELD_TERMINATED_BY__"));
        if(setField) {
            String fieldChar = ElementParameterParser.getValue(node, "__FIELD_TERMINATED_BY__");

    stringBuffer.append(TEXT_541);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(fieldChar);
    stringBuffer.append(TEXT_247);
    
            createTableSQL.append(" FIELDS TERMINATED BY '");
            createTableSQL.append("\" + ");
            createTableSQL.append("fieldChar_");
            createTableSQL.append(cid);
            createTableSQL.append(" + \"'");

            boolean setEscape = "true".equals(ElementParameterParser.getValue(node, "__SET_FIELD_ESCAPE_BY__"));
            if(setEscape) {
                String escapeChar = ElementParameterParser.getValue(node, "__FIELD_ESCAPE_BY__");

    stringBuffer.append(TEXT_542);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(escapeChar);
    stringBuffer.append(TEXT_247);
    
                createTableSQL.append(" ESCAPED BY '");
                createTableSQL.append("\" + ");
                createTableSQL.append("escapeChar_");
                createTableSQL.append(cid);
                createTableSQL.append(" + \"'");
            }
        }

        boolean setCollection = "true".equals(ElementParameterParser.getValue(node, "__SET_COLLECTION_ITEM_TERMINATED_BY__"));
        if(setCollection) {
            String collectionChar = ElementParameterParser.getValue(node, "__COLLECTION_ITEM_TERMINATED_BY__");

    stringBuffer.append(TEXT_543);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(collectionChar);
    stringBuffer.append(TEXT_247);
    
            createTableSQL.append(" COLLECTION ITEMS TERMINATED BY '");
            createTableSQL.append("\" + ");
            createTableSQL.append("collectionChar_");
            createTableSQL.append(cid);
            createTableSQL.append(" + \"'");
        }

        boolean setMap = "true".equals(ElementParameterParser.getValue(node, "__SET_MAP_KEY_TERMINATED_BY__"));
        if(setMap) {
            String mapChar = ElementParameterParser.getValue(node, "__MAP_KEY_TERMINATED_BY__");

    stringBuffer.append(TEXT_544);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(mapChar);
    stringBuffer.append(TEXT_247);
    
            createTableSQL.append(" MAP KEYS TERMINATED BY '");
            createTableSQL.append("\" + ");
            createTableSQL.append("mapChar_");
            createTableSQL.append(cid);
            createTableSQL.append(" + \"'");
        }

        boolean setLine = "true".equals(ElementParameterParser.getValue(node, "__SET_LINES_TERMINATED_BY__"));
        if(setLine) {
            String lineChar = ElementParameterParser.getValue(node, "__LINES_TERMINATED_BY__");

    stringBuffer.append(TEXT_545);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(lineChar);
    stringBuffer.append(TEXT_247);
    
            createTableSQL.append(" LINES TERMINATED BY '");
            createTableSQL.append("\" + ");
            createTableSQL.append("lineChar_");
            createTableSQL.append(cid);
            createTableSQL.append(" + \"'");
        }
    } else {
        createTableSQL.append("SERDE \\\"");
        createTableSQL.append("\" + ");
        String serdeName = ElementParameterParser.getValue(node, "__SERDE_NAME__");

    stringBuffer.append(TEXT_546);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(serdeName);
    stringBuffer.append(TEXT_247);
    
        createTableSQL.append("serdeName_");
        createTableSQL.append(cid);
        createTableSQL.append(" + \"\\\"");

        util.generatePros(" WITH SERDEPROPERTIES ", serdeProps, createTableSQL);
    }
}

if (storeAsAvro || !hiveDistrib.doSupportStoreAsParquet() && storeAsParquet) {
    createTableSQL.append(" STORED AS INPUTFORMAT '" + (storeAsAvro?"org.apache.hadoop.hive.ql.io.avro.AvroContainerInputFormat":"parquet.hive.DeprecatedParquetInputFormat") + "'");
    createTableSQL.append(" OUTPUTFORMAT '" + (storeAsAvro?"org.apache.hadoop.hive.ql.io.avro.AvroContainerOutputFormat":"parquet.hive.DeprecatedParquetOutputFormat") + "'");
} else if(!"STORAGE".equals(storedFormat)) {
    createTableSQL.append(" STORED AS ");
    if("INPUTFORMAT_AND_OUTPUTFORMAT".equals(storedFormat)) {
        String inputClass = ElementParameterParser.getValue(node, "__INPUTFORMAT_CLASS__");
        String outputClass = ElementParameterParser.getValue(node, "__OUTPUTFORMAT_CLASS__");

    stringBuffer.append(TEXT_547);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(inputClass);
    stringBuffer.append(TEXT_548);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(outputClass);
    stringBuffer.append(TEXT_247);
    
        createTableSQL.append("INPUTFORMAT '");
        createTableSQL.append("\" + ");
        createTableSQL.append("inputClass_");
        createTableSQL.append(cid);
        createTableSQL.append(" + \"'");

        createTableSQL.append(" OUTPUTFORMAT '");
        createTableSQL.append("\" + ");
        createTableSQL.append("outputClass_");
        createTableSQL.append(cid);
        createTableSQL.append(" + \"'");
    } else {
        createTableSQL.append(storedFormat);
    }
} else {
    String storageClass = ElementParameterParser.getValue(node, "__STORAGE_CLASS__");

    stringBuffer.append(TEXT_549);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(storageClass);
    stringBuffer.append(TEXT_247);
    
    createTableSQL.append(" STORED BY '");
    createTableSQL.append("\" + ");
    createTableSQL.append("storageClass_");
    createTableSQL.append(cid);
    createTableSQL.append(" + \"'");

    util.generatePros(" WITH SERDEPROPERTIES ", serdeProps, createTableSQL);
}

if(setLocation) {
    if (isS3Location) {
        String s3bucket = ElementParameterParser.getValue(node, "__S3_BUCKET__");
        String s3username = ElementParameterParser.getValue(node, "__S3_USERNAME__");

        String passwordFieldName = "__S3_PASSWORD__";
        // Get the decrypted password under the variable decryptedS3Password

        if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
            
    stringBuffer.append(TEXT_550);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_66);
    
        } else {
            
    stringBuffer.append(TEXT_550);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_247);
    
        }
        
    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_551);
    stringBuffer.append(s3username);
    stringBuffer.append(TEXT_552);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_553);
    stringBuffer.append(s3bucket);
    stringBuffer.append(TEXT_247);
    

    } else {

    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(location);
    stringBuffer.append(TEXT_247);
    
    }
    createTableSQL.append(" LOCATION '");
    createTableSQL.append("\" + ");
    createTableSQL.append("location_");
    createTableSQL.append(cid);
    createTableSQL.append(" + \"'");
}

if(storeAsAvro) {
    StringBuilder avroSchemaBuilder = new StringBuilder();
    String quote = "\\\"";
    avroSchemaBuilder.append("'avro.schema.literal'='{").append(quote).append("name").append(quote).append(" : ").append(quote).append("row").append(quote)
    .append(", ").append(quote).append("type").append(quote).append(" : ").append(quote).append("record").append(quote)
    .append(", ").append(quote).append("fields").append(quote).append(" : [");
    util.generateAvroSchema(listColumn, avroSchemaBuilder, quote);
    avroSchemaBuilder.append("] }'");

    util.appendKeyValue(avroSchemaBuilder.toString());
}

util.generatePros(" TBLPROPERTIES ", tableProps, createTableSQL);

if(asSelect) {
    String sql = ElementParameterParser.getValue(node, "__SELECT__");
    sql = sql.replaceAll("\n"," ");
    sql = sql.replaceAll("\r"," ");

    stringBuffer.append(TEXT_555);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(sql);
    stringBuffer.append(TEXT_247);
    
    createTableSQL.append(" AS ");
    createTableSQL.append("\" + ");
    createTableSQL.append("select_");
    createTableSQL.append(cid);
    createTableSQL.append(" + \"");
}

    stringBuffer.append(TEXT_556);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_281);
    stringBuffer.append(createTableSQL.toString());
    stringBuffer.append(TEXT_367);
    
    if(!hiveDistrib.useCloudLauncher()) {

    stringBuffer.append(TEXT_557);
    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_482);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
     
if(hiveDistrib.doSupportTezForHive()) {

    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    
}

    stringBuffer.append(TEXT_558);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_559);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_488);
    
            if(("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_560);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    
    		} else {

    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_491);
    
    		}

    stringBuffer.append(TEXT_562);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_563);
    if(!("true").equals(useExistingConn)) {
    stringBuffer.append(TEXT_564);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_563);
    }
    stringBuffer.append(TEXT_565);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_566);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_567);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_568);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_570);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_571);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_572);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_574);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_575);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_576);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_577);
    
    } else { // useCloudLauncher
        if(hiveDistrib.isExecutedThroughWebHCat()) {

    stringBuffer.append(TEXT_578);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_579);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_580);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_581);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_582);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_583);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_584);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_585);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_586);
    
                if(("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_587);
    
                } else {

    stringBuffer.append(TEXT_588);
    
                    if(isLog4jEnabled) {

    stringBuffer.append(TEXT_589);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_515);
    
                    }
                }

    stringBuffer.append(TEXT_590);
    
        } else if (hiveDistrib.isQuboleDistribution()) { // qubole execution
        
    stringBuffer.append(TEXT_591);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_592);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_593);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_594);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_595);
     if (isLog4jEnabled) { 
    stringBuffer.append(TEXT_596);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_597);
     } 
    stringBuffer.append(TEXT_598);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_599);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_600);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_601);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_602);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_603);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_604);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_605);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_606);
    stringBuffer.append(studioVersion);
    stringBuffer.append(TEXT_607);
     if (quboleClusterLabel != null) { 
    stringBuffer.append(TEXT_608);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_609);
    stringBuffer.append(quboleClusterLabel);
    stringBuffer.append(TEXT_33);
     } 
    stringBuffer.append(TEXT_610);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_611);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    
        } else { // Dataproc
            if(isLog4jEnabled) {

    stringBuffer.append(TEXT_612);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_527);
    
            }

    stringBuffer.append(TEXT_613);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_529);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_614);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_615);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_616);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_617);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_586);
    
                if(("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_587);
    
                } else {

    stringBuffer.append(TEXT_588);
    
                    if(isLog4jEnabled) {

    stringBuffer.append(TEXT_589);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_515);
    
                    }
                }

    stringBuffer.append(TEXT_590);
    
        } // else part of if(hiveDistrib.isExecutedThroughWebHCat()) 
    } // else port of useCloudLauncher

    return stringBuffer.toString();
  }
}
