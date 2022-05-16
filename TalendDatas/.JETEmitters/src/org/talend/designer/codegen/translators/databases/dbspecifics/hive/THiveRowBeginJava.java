package org.talend.designer.codegen.translators.databases.dbspecifics.hive;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.runprocess.ProcessorException;
import org.talend.designer.runprocess.ProcessorUtilities;
import java.util.List;
import java.util.Map;

public class THiveRowBeginJava
{
  protected static String nl;
  public static synchronized THiveRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THiveRowBeginJava result = new THiveRowBeginJava();
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
  protected final String TEXT_57 = NL + NL + "\t\t";
  protected final String TEXT_58 = NL + "\tjava.io.File localPigLatin_";
  protected final String TEXT_59 = " = new java.io.File(projectName + \"_\" + jobName + \"_\" + Thread.currentThread().getId() +\".hive\");" + NL + "\tjava.io.FileWriter fw_";
  protected final String TEXT_60 = " = new java.io.FileWriter(localPigLatin_";
  protected final String TEXT_61 = ".getAbsoluteFile());" + NL + "\tjava.io.BufferedWriter bw_";
  protected final String TEXT_62 = " = new java.io.BufferedWriter(fw_";
  protected final String TEXT_63 = ");" + NL + "\tjava.lang.StringBuilder libjars_";
  protected final String TEXT_64 = " = new StringBuilder();";
  protected final String TEXT_65 = " " + NL + "\t\t\tfinal String hdInsightPassword_";
  protected final String TEXT_66 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_67 = ");";
  protected final String TEXT_68 = NL + "\t\t\tfinal String hdInsightPassword_";
  protected final String TEXT_69 = " = ";
  protected final String TEXT_70 = "; ";
  protected final String TEXT_71 = " " + NL + "\t\t\tfinal String wasbPassword_";
  protected final String TEXT_72 = NL + "\t\t\tfinal String wasbPassword_";
  protected final String TEXT_73 = NL + "\t\torg.talend.bigdata.launcher.fs.FileSystem azureFs_";
  protected final String TEXT_74 = " = new org.talend.bigdata.launcher.fs.AzureFileSystem(\"DefaultEndpointsProtocol=https;\"" + NL + "\t\t\t+ \"AccountName=\"" + NL + "\t\t\t+ ";
  protected final String TEXT_75 = NL + "\t\t\t+ \";\"" + NL + "\t\t\t+ \"AccountKey=\" + wasbPassword_";
  protected final String TEXT_76 = ", ";
  protected final String TEXT_77 = ");" + NL + "\t\t\t\t" + NL + "\t\torg.talend.bigdata.launcher.webhcat.WebHCatJob instance_";
  protected final String TEXT_78 = " = new org.talend.bigdata.launcher.webhcat.QueryJob(azureFs_";
  protected final String TEXT_79 = ", org.talend.bigdata.launcher.utils.JobType.HIVE);" + NL + "\t\t\t\t\t\t" + NL + "\t\tinstance_";
  protected final String TEXT_80 = ".setCredentials(new org.talend.bigdata.launcher.security.HDInsightCredentials(";
  protected final String TEXT_81 = ", hdInsightPassword_";
  protected final String TEXT_82 = "));" + NL + "\t\tinstance_";
  protected final String TEXT_83 = ".setUsername(";
  protected final String TEXT_84 = ");" + NL + "\t\tinstance_";
  protected final String TEXT_85 = ".setWebhcatEndpoint(\"https\", ";
  protected final String TEXT_86 = " + \":\" + ";
  protected final String TEXT_87 = ".setStatusFolder(org.talend.bigdata.launcher.utils.Utils.removeFirstSlash(";
  protected final String TEXT_88 = ".setRemoteFolder(org.talend.bigdata.launcher.utils.Utils.removeFirstSlash(";
  protected final String TEXT_89 = "));";
  protected final String TEXT_90 = NL + "\t\torg.talend.bigdata.launcher.webhcat.WebHCatJob instance_";
  protected final String TEXT_91 = " = (org.talend.bigdata.launcher.webhcat.WebHCatJob) globalMap.get(\"conn_";
  protected final String TEXT_92 = "\");" + NL + "\t\t" + NL + "\t\torg.talend.bigdata.launcher.fs.FileSystem azureFs_";
  protected final String TEXT_93 = " = instance_";
  protected final String TEXT_94 = ".getFileSystem();\t\t" + NL + "\t\t" + NL + "\t\tjava.util.List<String> connectionCommandList_";
  protected final String TEXT_95 = " = (java.util.List<String>)globalMap.get(\"commandList_";
  protected final String TEXT_96 = "\");" + NL + "\t\tfor(String command : connectionCommandList_";
  protected final String TEXT_97 = ") {" + NL + "\t\t\tbw_";
  protected final String TEXT_98 = ".write(command);" + NL + "\t\t}";
  protected final String TEXT_99 = NL + "\t((org.talend.bigdata.launcher.webhcat.QueryJob)instance_";
  protected final String TEXT_100 = ").setFileToExecute(projectName + \"_\" + jobName + \"_\" + Thread.currentThread().getId() +\".hive\");" + NL + "\tString wasbPath_";
  protected final String TEXT_101 = " = azureFs_";
  protected final String TEXT_102 = ".getFileSystemPrefix() + \"/\"\t+ instance_";
  protected final String TEXT_103 = ".getRemoteFolder()\t+ \"/libjars/\";" + NL;
  protected final String TEXT_104 = NL + "\t\t\t\tbw_";
  protected final String TEXT_105 = ".write(\"SET mapreduce.map.memory.mb=\" + ";
  protected final String TEXT_106 = " + \";\");" + NL + "\t\t\t\tbw_";
  protected final String TEXT_107 = ".write(\"SET mapreduce.reduce.memory.mb=\" + ";
  protected final String TEXT_108 = ".write(\"SET yarn.app.mapreduce.am.resource.mb=\" + ";
  protected final String TEXT_109 = " + \";\");";
  protected final String TEXT_110 = NL + "\t\t\t\t\tbw_";
  protected final String TEXT_111 = ".write(\"SET \"+";
  protected final String TEXT_112 = "+\"=\"+";
  protected final String TEXT_113 = NL + "\t\t\tString dbname_";
  protected final String TEXT_114 = ";" + NL + "\t\t\tif(dbname_";
  protected final String TEXT_115 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_116 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_117 = ".trim())) {" + NL + "\t\t\t\tbw_";
  protected final String TEXT_118 = ".write(\"use \" + dbname_";
  protected final String TEXT_119 = " + \";\");" + NL + "\t\t\t}";
  protected final String TEXT_120 = NL + "\tjava.lang.StringBuilder libjars_";
  protected final String TEXT_121 = " = new StringBuilder();" + NL + "\tString stagingBucketPath_";
  protected final String TEXT_122 = " = \"\";";
  protected final String TEXT_123 = NL + "        java.util.List<String> connectionCommandList_";
  protected final String TEXT_124 = " = new java.util.ArrayList<String>();  ";
  protected final String TEXT_125 = NL + "            connectionCommandList_";
  protected final String TEXT_126 = ".add(\"SET mapreduce.map.memory.mb=\" + ";
  protected final String TEXT_127 = " + \";\");" + NL + "            connectionCommandList_";
  protected final String TEXT_128 = ".add(\"SET mapreduce.reduce.memory.mb=\" + ";
  protected final String TEXT_129 = ".add(\"SET yarn.app.mapreduce.am.resource.mb=\" + ";
  protected final String TEXT_130 = NL + "                connectionCommandList_";
  protected final String TEXT_131 = ".add(\"SET \"+";
  protected final String TEXT_132 = NL + NL + "        String dbname_";
  protected final String TEXT_133 = ";" + NL + "        if(dbname_";
  protected final String TEXT_134 = ".trim())) {" + NL + "            connectionCommandList_";
  protected final String TEXT_135 = ".add(\"use \" + dbname_";
  protected final String TEXT_136 = " + \";\");" + NL + "        }" + NL + "        " + NL + "        stagingBucketPath_";
  protected final String TEXT_137 = ";" + NL + "" + NL + "        org.talend.bigdata.launcher.google.dataproc.DataprocHiveJob instance_";
  protected final String TEXT_138 = " =" + NL + "            new org.talend.bigdata.launcher.google.dataproc.DataprocHiveJob.Builder()" + NL + "            .withTalendJobName(projectName + \"_\" + jobName + \"_\" + jobVersion.replace(\".\",\"_\") + \"_\" + pid)" + NL + "            .withClusterName(";
  protected final String TEXT_139 = ")" + NL + "            .withRegion(";
  protected final String TEXT_140 = ")" + NL + "            .withProjectId(";
  protected final String TEXT_141 = ")" + NL + "            .withJarsBucket(";
  protected final String TEXT_142 = ")";
  protected final String TEXT_143 = NL + "                .withServiceAccountCredentialsPath(";
  protected final String TEXT_144 = NL + NL + "            .withInitialisationQueries(connectionCommandList_";
  protected final String TEXT_145 = ")" + NL + "            .build();";
  protected final String TEXT_146 = NL + "            for (String command: connectionCommandList_";
  protected final String TEXT_147 = " ) {" + NL + "                log.debug(\"Initialization command from ";
  protected final String TEXT_148 = ": \" + command);" + NL + "            }";
  protected final String TEXT_149 = NL + "        org.talend.bigdata.launcher.google.dataproc.DataprocHiveJob instance_";
  protected final String TEXT_150 = " = (org.talend.bigdata.launcher.google.dataproc.DataprocHiveJob) globalMap.get(\"conn_";
  protected final String TEXT_151 = "\");" + NL + "        stagingBucketPath_";
  protected final String TEXT_152 = " = (String) globalMap.get(\"stagingBucket_";
  protected final String TEXT_153 = "\");" + NL + "        instance_";
  protected final String TEXT_154 = ".clearQueriesCache();" + NL + "        instance_";
  protected final String TEXT_155 = ".clearLibJars();";
  protected final String TEXT_156 = NL + "\t\t";
  protected final String TEXT_157 = " + \";\");" + NL + "        }" + NL + "" + NL + "\t \tString api_token_";
  protected final String TEXT_158 = ");" + NL + "\t" + NL + "\t\torg.talend.bigdata.launcher.qubole.QuboleHiveClient instance_";
  protected final String TEXT_159 = " =" + NL + "\t\t\tnew org.talend.bigdata.launcher.qubole.QuboleHiveClient.Builder()" + NL + "\t\t\t\t.setApiKey(api_token_";
  protected final String TEXT_160 = ")" + NL + "\t\t\t\t";
  protected final String TEXT_161 = " .setApiEndpoint(";
  protected final String TEXT_162 = ") ";
  protected final String TEXT_163 = NL + "\t\t\t\t.build();" + NL + "        ";
  protected final String TEXT_164 = NL + "        org.talend.bigdata.launcher.qubole.QuboleHiveClient instance_";
  protected final String TEXT_165 = " = (org.talend.bigdata.launcher.qubole.QuboleHiveClient) globalMap.get(\"conn_";
  protected final String TEXT_166 = "\");" + NL + "        java.util.List<String> connectionCommandList_";
  protected final String TEXT_167 = " = null;" + NL + "        if (globalMap.containsKey(\"conn_init_statements_";
  protected final String TEXT_168 = "\")) {" + NL + "        \tconnectionCommandList_";
  protected final String TEXT_169 = " = (java.util.List<String>) globalMap.get(\"conn_init_statements_";
  protected final String TEXT_170 = "\");" + NL + "        \tglobalMap.remove(\"conn_init_statements_";
  protected final String TEXT_171 = "\");" + NL + "        }";
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
  protected final String TEXT_222 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_223 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_224 = NL + NL + "\t\tString dbPwd_";
  protected final String TEXT_225 = " = decryptedPassword_";
  protected final String TEXT_226 = ";" + NL;
  protected final String TEXT_227 = NL + "            String username_";
  protected final String TEXT_228 = ";" + NL + "            if(username_";
  protected final String TEXT_229 = "!=null && !\"\".equals(username_";
  protected final String TEXT_230 = ".trim())) {" + NL + "                System.setProperty(\"HADOOP_USER_NAME\",username_";
  protected final String TEXT_231 = ");" + NL + "            }";
  protected final String TEXT_232 = NL + "        globalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_233 = "\", System.getProperty(\"HADOOP_USER_NAME\"));";
  protected final String TEXT_234 = NL + "\t\t\tSystem.setProperty(\"hive.metastore.local\", \"false\");" + NL + "\t\t\tSystem.setProperty(\"hive.metastore.uris\", \"thrift://\" + ";
  protected final String TEXT_235 = ");" + NL + "\t\t\tSystem.setProperty(\"hive.metastore.execute.setugi\", \"true\");" + NL + "\t\t\tString url_";
  protected final String TEXT_236 = " = \"jdbc:";
  protected final String TEXT_237 = "://\";";
  protected final String TEXT_238 = NL + "\t\t\t\tif(dbUser_";
  protected final String TEXT_239 = ".trim())) {" + NL + "\t\t\t\t\tSystem.setProperty(\"HADOOP_USER_NAME\",dbUser_";
  protected final String TEXT_240 = ");" + NL + "\t\t\t\t\t//make relative file path work for hive" + NL + "\t\t\t\t\tglobalMap.put(\"current_client_user_name\", System.getProperty(\"user.name\"));" + NL + "\t\t\t\t\tSystem.setProperty(\"user.name\",dbUser_";
  protected final String TEXT_241 = ");" + NL + "\t\t\t\t}";
  protected final String TEXT_242 = NL + "                        System.setProperty(\"pname\", \"MapRLogin\");" + NL + "                        System.setProperty(\"https.protocols\", \"TLSv1.2\");" + NL + "                        System.setProperty(\"mapr.home.dir\", ";
  protected final String TEXT_243 = ");" + NL + "                        System.setProperty(\"hadoop.login\", ";
  protected final String TEXT_244 = NL + "\t\t\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_245 = NL + "\t\t\t\t\t\t\t\tString decryptedSslStorePassword_";
  protected final String TEXT_246 = ";";
  protected final String TEXT_247 = NL + "\t\t\t\t\t\t\tString url_";
  protected final String TEXT_248 = "://\" + ";
  protected final String TEXT_249 = " + \"/\" + ";
  protected final String TEXT_250 = " + \";principal=\" + ";
  protected final String TEXT_251 = "+\";ssl=true\" +\";sslTrustStore=\" + ";
  protected final String TEXT_252 = " + \";trustStorePassword=\" + decryptedSslStorePassword_";
  protected final String TEXT_253 = "+\";sasl.qop=auth-conf\";";
  protected final String TEXT_254 = NL + "\t\t\t\t\t\tString url_";
  protected final String TEXT_255 = NL + "                        com.mapr.login.client.MapRLoginHttpsClient maprLogin_";
  protected final String TEXT_256 = " = new com.mapr.login.client.MapRLoginHttpsClient();" + NL + "                        maprLogin_";
  protected final String TEXT_257 = ".getMapRCredentialsViaKerberos(";
  protected final String TEXT_258 = ");" + NL + "                        com.mapr.login.client.MapRLoginHttpsClient maprLogin_";
  protected final String TEXT_259 = " = new com.mapr.login.client.MapRLoginHttpsClient();";
  protected final String TEXT_260 = NL + "                            System.setProperty(\"hadoop.login\", ";
  protected final String TEXT_261 = NL + "                            maprLogin_";
  protected final String TEXT_262 = ".setCheckUGI(false);";
  protected final String TEXT_263 = NL + "                            String decryptedMaprPassword_";
  protected final String TEXT_264 = NL + "                \t\t\t\tmaprLogin_";
  protected final String TEXT_265 = ".getMapRCredentialsViaPassword(";
  protected final String TEXT_266 = ", decryptedMaprPassword_";
  protected final String TEXT_267 = ", \"\");" + NL + "                \t\t\t\t";
  protected final String TEXT_268 = ");" + NL + "                \t\t\t\t";
  protected final String TEXT_269 = NL + "\t\t\t\t\t\t\tString decryptedSslStorePassword_";
  protected final String TEXT_270 = "+ \";ssl=true\" +\";sslTrustStore=\" + ";
  protected final String TEXT_271 = NL + "\t\t\t\tString additionalJdbcSettings_";
  protected final String TEXT_272 = ";" + NL + "\t\t\t\tif(!\"\".equals(additionalJdbcSettings_";
  protected final String TEXT_273 = ".trim())) {" + NL + "\t\t\t\t\tif(!additionalJdbcSettings_";
  protected final String TEXT_274 = ".startsWith(\";\")) {" + NL + "\t\t\t\t\t\tadditionalJdbcSettings_";
  protected final String TEXT_275 = " = \";\" + additionalJdbcSettings_";
  protected final String TEXT_276 = ";" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\turl_";
  protected final String TEXT_277 = " += additionalJdbcSettings_";
  protected final String TEXT_278 = ";" + NL + "\t\t\t\t}";
  protected final String TEXT_279 = NL + "\t\tString driverClass_";
  protected final String TEXT_280 = " = \"";
  protected final String TEXT_281 = "\";" + NL + "\t\tjava.lang.Class.forName(driverClass_";
  protected final String TEXT_282 = ");" + NL + "\t\t";
  protected final String TEXT_283 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_284 = " - Connection attempt to '\" + url_";
  protected final String TEXT_285 = " + \"' with the username '\" + dbUser_";
  protected final String TEXT_286 = " + \"'.\");" + NL + "\t\t";
  protected final String TEXT_287 = NL + "\t\t\tconn_";
  protected final String TEXT_288 = " - Connection to '\" + url_";
  protected final String TEXT_289 = " + \"' has succeeded.\");" + NL + "\t\t";
  protected final String TEXT_290 = NL + NL + "\t\tjava.sql.Statement init_";
  protected final String TEXT_291 = ".createStatement();";
  protected final String TEXT_292 = NL + "        \tinit_";
  protected final String TEXT_293 = ".execute(\"SET mapred.job.map.memory.mb=\" + ";
  protected final String TEXT_294 = ");" + NL + "\t    \tinit_";
  protected final String TEXT_295 = ".execute(\"SET mapred.job.reduce.memory.mb=\" + ";
  protected final String TEXT_296 = NL + "\t\tinit_";
  protected final String TEXT_297 = ".execute(\"SET dfs.namenode.kerberos.principal=\" + ";
  protected final String TEXT_298 = NL + "\t\t\tinit_";
  protected final String TEXT_299 = ".execute(\"SET mapreduce.jobtracker.kerberos.principal=\" + ";
  protected final String TEXT_300 = ".execute(\"SET yarn.resourcemanager.principal=\" + ";
  protected final String TEXT_301 = NL + "        \t\tinit_";
  protected final String TEXT_302 = ".execute(\"SET mapreduce.framework.name=yarn\");" + NL + "        \t\tinit_";
  protected final String TEXT_303 = ".execute(\"SET yarn.resourcemanager.address=\" + ";
  protected final String TEXT_304 = NL + "\t\t\t\tinit_";
  protected final String TEXT_305 = ".execute(\"SET mapreduce.jobhistory.address=\" + ";
  protected final String TEXT_306 = ");" + NL + "    \t\t\t";
  protected final String TEXT_307 = ".execute(\"SET yarn.resourcemanager.scheduler.address=\" + ";
  protected final String TEXT_308 = NL + "                init_";
  protected final String TEXT_309 = ".execute(\"SET dfs.client.use.datanode.hostname=true\");";
  protected final String TEXT_310 = ".execute(\"SET fs.default.name=\" + ";
  protected final String TEXT_311 = NL + "\t\t\t\t\tinit_";
  protected final String TEXT_312 = ".execute(\"SET mapreduce.app-submission.cross-platform=true\");";
  protected final String TEXT_313 = ".execute(\"SET mapreduce.job.map.output.collector.class=org.apache.hadoop.mapred.MapRFsOutputBuffer\");" + NL + "\t\t\t\t\tinit_";
  protected final String TEXT_314 = ".execute(\"SET mapreduce.job.reduce.shuffle.consumer.plugin.class=org.apache.hadoop.mapreduce.task.reduce.DirectShuffle\");";
  protected final String TEXT_315 = ".execute(\"SET mapreduce.application.classpath=";
  protected final String TEXT_316 = "\");";
  protected final String TEXT_317 = ".execute(\"SET yarn.application.classpath=";
  protected final String TEXT_318 = NL + "    \t\t\tinit_";
  protected final String TEXT_319 = ".execute(\"SET mapreduce.map.memory.mb=\" + ";
  protected final String TEXT_320 = ");" + NL + "    \t\t\tinit_";
  protected final String TEXT_321 = ".execute(\"SET mapreduce.reduce.memory.mb=\" + ";
  protected final String TEXT_322 = ".execute(\"SET yarn.app.mapreduce.am.resource.mb=\" + ";
  protected final String TEXT_323 = ".execute(\"SET \"+";
  protected final String TEXT_324 = NL + "        \t";
  protected final String TEXT_325 = NL + "    \t\tinit_";
  protected final String TEXT_326 = ".execute(\"SET hive.execution.engine=tez\");";
  protected final String TEXT_327 = NL + "                        System.err.println(\"Please set the path of Tez lib in 'Tez lib path'!\");";
  protected final String TEXT_328 = NL + "        String username_";
  protected final String TEXT_329 = " = (";
  protected final String TEXT_330 = " != null && !\"\".equals(";
  protected final String TEXT_331 = ")) ? ";
  protected final String TEXT_332 = " : System.getProperty(\"user.name\");;" + NL + "        org.apache.hadoop.fs.FileSystem fs_";
  protected final String TEXT_333 = NL + "        org.apache.hadoop.conf.Configuration conf_";
  protected final String TEXT_334 = " = new org.apache.hadoop.conf.Configuration(); " + NL + "        conf_";
  protected final String TEXT_335 = ".set(\"";
  protected final String TEXT_336 = ");" + NL + "        ";
  protected final String TEXT_337 = NL + "            conf_";
  protected final String TEXT_338 = ".set(\"dfs.client.use.datanode.hostname\", \"true\");";
  protected final String TEXT_339 = NL + "        \t\tconf_";
  protected final String TEXT_340 = ".set(";
  protected final String TEXT_341 = ");" + NL + "        \t";
  protected final String TEXT_342 = NL + "            username_";
  protected final String TEXT_343 = " = null;" + NL + "    \t\tconf_";
  protected final String TEXT_344 = ".set(\"dfs.namenode.kerberos.principal\", ";
  protected final String TEXT_345 = ");" + NL + "    \t\t";
  protected final String TEXT_346 = NL + "    \t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_347 = NL + "\t\t\tconf_";
  protected final String TEXT_348 = ".set(\"hadoop.job.ugi\",username_";
  protected final String TEXT_349 = "+\",\"+username_";
  protected final String TEXT_350 = ");" + NL + "        \tfs_";
  protected final String TEXT_351 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_352 = NL + "        \t" + NL + "        \tif(username_";
  protected final String TEXT_353 = " == null || \"\".equals(username_";
  protected final String TEXT_354 = ")){" + NL + "        \t\tfs_";
  protected final String TEXT_355 = ");" + NL + "        \t}else{" + NL + "        \t\tfs_";
  protected final String TEXT_356 = " = org.apache.hadoop.fs.FileSystem.get(new java.net.URI(conf_";
  protected final String TEXT_357 = ".get(\"";
  protected final String TEXT_358 = "\")),conf_";
  protected final String TEXT_359 = ",username_";
  protected final String TEXT_360 = ");" + NL + "        \t}\t";
  protected final String TEXT_361 = NL + "                    String hdfsUserName_";
  protected final String TEXT_362 = " : System.getProperty(\"user.name\");" + NL + "                    String tezLibPath_";
  protected final String TEXT_363 = " = \"/tmp/\" + hdfsUserName_";
  protected final String TEXT_364 = " + \"/talend_tez_libs/";
  protected final String TEXT_365 = "\";";
  protected final String TEXT_366 = NL + "                    String tezLibPath_";
  protected final String TEXT_367 = NL + "                fs_";
  protected final String TEXT_368 = ".mkdirs(new org.apache.hadoop.fs.Path(tezLibPath_";
  protected final String TEXT_369 = NL + "                String[] classPaths_";
  protected final String TEXT_370 = " = System.getProperty(\"java.class.path\").split(";
  protected final String TEXT_371 = "String.valueOf(globalMap.get(\"current_client_path_separator\"))";
  protected final String TEXT_372 = "System.getProperty(\"path.separator\")";
  protected final String TEXT_373 = ");" + NL + "                String tezLibLocalPath_";
  protected final String TEXT_374 = " = null;" + NL + "                for(String classPath_";
  protected final String TEXT_375 = " : classPaths_";
  protected final String TEXT_376 = "){";
  protected final String TEXT_377 = NL + "                        if(classPath_";
  protected final String TEXT_378 = ".endsWith(\"";
  protected final String TEXT_379 = "\")){" + NL + "                            org.apache.hadoop.fs.Path tezJarPath_";
  protected final String TEXT_380 = " = new org.apache.hadoop.fs.Path(tezLibPath_";
  protected final String TEXT_381 = " + \"/";
  protected final String TEXT_382 = "\");" + NL + "                            if(!fs_";
  protected final String TEXT_383 = ".exists(tezJarPath_";
  protected final String TEXT_384 = ")){" + NL + "                                fs_";
  protected final String TEXT_385 = ".copyFromLocalFile(false, false, new org.apache.hadoop.fs.Path(classPath_";
  protected final String TEXT_386 = "), tezJarPath_";
  protected final String TEXT_387 = ");" + NL + "                            }" + NL + "                        }";
  protected final String TEXT_388 = NL + "                }";
  protected final String TEXT_389 = NL + "                String tezLibPath_";
  protected final String TEXT_390 = NL + "\t\t\tStringBuilder script_";
  protected final String TEXT_391 = " = new StringBuilder();" + NL + "\t\t\tString[] tezLibPaths_";
  protected final String TEXT_392 = " = tezLibPath_";
  protected final String TEXT_393 = ".split(\",\");" + NL + "\t\t\tscript_";
  protected final String TEXT_394 = ".append(\"SET tez.lib.uris=\");" + NL + "\t\t\tint tezLibPathCount_";
  protected final String TEXT_395 = " = 1;" + NL + "\t\t\tfor(String tezLibPathKey_";
  protected final String TEXT_396 = " : tezLibPaths_";
  protected final String TEXT_397 = "){" + NL + "\t\t\t\t script_";
  protected final String TEXT_398 = ".append(";
  protected final String TEXT_399 = " + \"/\" + tezLibPathKey_";
  protected final String TEXT_400 = ");" + NL + "\t\t\t\t if(tezLibPathCount_";
  protected final String TEXT_401 = " < tezLibPaths_";
  protected final String TEXT_402 = ".length){" + NL + "\t\t\t\t \tscript_";
  protected final String TEXT_403 = ".append(\",\");" + NL + "\t\t\t\t }" + NL + "\t\t\t\t tezLibPathCount_";
  protected final String TEXT_404 = "++;" + NL + "\t\t\t}" + NL + "\t\t\tinit_";
  protected final String TEXT_405 = ".execute(script_";
  protected final String TEXT_406 = ".toString());" + NL + "\t\t";
  protected final String TEXT_407 = NL + "            \t";
  protected final String TEXT_408 = ".close();" + NL + "" + NL + "    \tString dbname_";
  protected final String TEXT_409 = ";" + NL + "    \tif(dbname_";
  protected final String TEXT_410 = ".close();" + NL + "    \t}" + NL + "" + NL + "\t\t";
  protected final String TEXT_411 = NL + "    \t\tjava.sql.Statement statement_";
  protected final String TEXT_412 = ".createStatement();" + NL + "    \t\t";
  protected final String TEXT_413 = NL + "    \t\t\tstatement_";
  protected final String TEXT_414 = ".execute(\"SET hbase.zookeeper.quorum=\"+";
  protected final String TEXT_415 = NL + NL + "        \t";
  protected final String TEXT_416 = NL + "        \t\tstatement_";
  protected final String TEXT_417 = ".execute(\"SET hbase.zookeeper.property.clientPort=\"+";
  protected final String TEXT_418 = NL + NL + "\t\t\t";
  protected final String TEXT_419 = NL + "\t\t\t\tstatement_";
  protected final String TEXT_420 = ".execute(\"SET zookeeper.znode.parent=\"+";
  protected final String TEXT_421 = ".execute(\"SET hbase.security.authentication=kerberos\");" + NL + "\t\t\t\tstatement_";
  protected final String TEXT_422 = ".execute(\"SET hbase.rpc.engine=org.apache.hadoop.hbase.ipc.SecureRpcEngine\");" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_423 = NL + "\t\t\t\t\tstatement_";
  protected final String TEXT_424 = ".execute(\"SET hbase.master.kerberos.principal=\"+";
  protected final String TEXT_425 = NL + "\t\t\t\t";
  protected final String TEXT_426 = ".execute(\"SET hbase.regionserver.kerberos.principal=\"+";
  protected final String TEXT_427 = NL + "\t\t\t";
  protected final String TEXT_428 = ".execute(\"add jar \"+";
  protected final String TEXT_429 = NL + "    \t\tstatement_";
  protected final String TEXT_430 = ".close();";
  protected final String TEXT_431 = NL + "\t\tthrow new java.lang.UnsupportedOperationException(\"Parquet is only supported if the distribution uses embedded Hive version 0.10 or later.\");";
  protected final String TEXT_432 = NL + "\t\t\troutines.system.GetJarsToRegister getJarsToRegister_";
  protected final String TEXT_433 = " = new routines.system.GetJarsToRegister();";
  protected final String TEXT_434 = NL + "\tclass GetHiveJarsToRegister_";
  protected final String TEXT_435 = " extends routines.system.GetJarsToRegister {" + NL + "\t\t" + NL + "\t\tprivate String uploadJarToHDFS(String jar) throws Exception {" + NL + "\t\t\t";
  protected final String TEXT_436 = NL + "\t\t\t" + NL + "\t\t\tString pathUsername_";
  protected final String TEXT_437 = " = username_";
  protected final String TEXT_438 = " == null ? org.apache.hadoop.security.UserGroupInformation.getLoginUser().getShortUserName() : username_";
  protected final String TEXT_439 = ";" + NL + "\t\t\tfs_";
  protected final String TEXT_440 = ".mkdirs(new org.apache.hadoop.fs.Path(\"/user/\" + pathUsername_";
  protected final String TEXT_441 = " + \"/tmp\"), new org.apache.hadoop.fs.permission.FsPermission(org.apache.hadoop.fs.permission.FsAction.ALL, org.apache.hadoop.fs.permission.FsAction.ALL, org.apache.hadoop.fs.permission.FsAction.ALL));" + NL + "\t\t\tfs_";
  protected final String TEXT_442 = ".copyFromLocalFile(false, true, new org.apache.hadoop.fs.Path(jar), new org.apache.hadoop.fs.Path(\"/user/\" + pathUsername_";
  protected final String TEXT_443 = " + \"/tmp\"));" + NL + "\t\t\treturn ";
  protected final String TEXT_444 = " + \"/user/\" + pathUsername_";
  protected final String TEXT_445 = " + \"/tmp/\" + new java.io.File(jar).getName();" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tpublic String replaceJarPaths(String originalClassPathLine) throws Exception {" + NL + "\t\t\tString classPathLine = super.replaceJarPaths(originalClassPathLine);" + NL + "\t\t\tString hdfsPath = uploadJarToHDFS(classPathLine);" + NL + "\t\t\treturn hdfsPath;" + NL + "\t\t}" + NL + "\t}" + NL + "\t\t\t\tGetHiveJarsToRegister_";
  protected final String TEXT_446 = " getJarsToRegister_";
  protected final String TEXT_447 = " = new GetHiveJarsToRegister_";
  protected final String TEXT_448 = "();";
  protected final String TEXT_449 = NL + "\t\t\tjava.sql.Statement addJar_";
  protected final String TEXT_450 = NL + "\t\t\t\t\t\t\taddJar_";
  protected final String TEXT_451 = ".createStatement();" + NL + "\t\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t\taddJar_";
  protected final String TEXT_452 = ".execute(\"add jar \" + getJarsToRegister_";
  protected final String TEXT_453 = ".replaceJarPaths(\"";
  protected final String TEXT_454 = "\").replace(\"maprfs\", \"hdfs\"));" + NL + "\t\t\t\t\t\t\t} catch (Exception e) {" + NL + "\t\t\t\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t\t\t\t} finally {" + NL + "\t\t\t\t\t\t\t\taddJar_";
  protected final String TEXT_455 = ".close();" + NL + "\t\t\t\t\t\t\t}";
  protected final String TEXT_456 = NL + "                                bw_";
  protected final String TEXT_457 = ".write(\"ADD JAR \" + wasbPath_";
  protected final String TEXT_458 = " + new java.io.File(getJarsToRegister_";
  protected final String TEXT_459 = "\")).getName() + \";\");" + NL + "                                libjars_";
  protected final String TEXT_460 = ".append(getJarsToRegister_";
  protected final String TEXT_461 = "\") + \",\");";
  protected final String TEXT_462 = NL + "                                // Qubole hive 2.1 supports parquet by default.";
  protected final String TEXT_463 = NL + "                                    log.debug(\"Query for ";
  protected final String TEXT_464 = ": \" + \"ADD JAR \" + stagingBucketPath_";
  protected final String TEXT_465 = "\")).getName() + \";\");";
  protected final String TEXT_466 = NL + "                                instance_";
  protected final String TEXT_467 = ".addQuery(\"ADD JAR \" + stagingBucketPath_";
  protected final String TEXT_468 = NL + "\t        if(conn_";
  protected final String TEXT_469 = ".getAutoCommit()) {" + NL + "\t            conn_";
  protected final String TEXT_470 = ".setAutoCommit(false);" + NL + "\t        }" + NL + "\t        int commitEvery_";
  protected final String TEXT_471 = ";" + NL + "\t        int commitCounter_";
  protected final String TEXT_472 = " = 0;" + NL + "\t        ";
  protected final String TEXT_473 = NL + "\t\t\tjava.sql.PreparedStatement pstmt_";
  protected final String TEXT_474 = ".prepareStatement(";
  protected final String TEXT_475 = NL + "\t\tjava.sql.Statement stmt_";
  protected final String TEXT_476 = ".createStatement();" + NL + "\t\t";
  protected final String TEXT_477 = NL + "\tString query_";
  protected final String TEXT_478 = " = \"\";" + NL + "\tboolean whetherReject_";
  protected final String TEXT_479 = " = false;";

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
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	String cid = node.getUniqueName();
	String processId = node.getProcess().getId();

	String dbhost = ElementParameterParser.getValue(node, "__HOST__");
	String dbport = ElementParameterParser.getValue(node, "__PORT__");
	String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
	String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
	String dbuser= ElementParameterParser.getValue(node, "__USER__");

	String commitEvery = "0";//ElementParameterParser.getValue(node, "__COMMIT_EVERY__");//hive jdbc not support setAutoCommit
	String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
	dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);
	boolean usePrepareStatement = "true".equals(ElementParameterParser.getValue(node,"__USE_PREPAREDSTATEMENT__"));

	boolean useParquet = "true".equals(ElementParameterParser.getValue(node,"__USE_PARQUET__"));

    String theDistribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
    String theVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");

	String quboleClusterLabel = null;
	String quboleEndpoint = null;
	String encryptedToken = null;
    if("true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"))) {
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
		// Distribution: WebHCat

    stringBuffer.append(TEXT_57);
    
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    
	if("false".equals(useExistingConn)) {
		String passwordFieldName = "__HDINSIGHT_PASSWORD__";
		if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_67);
    
		} else {

    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_70);
    
		}
			
		passwordFieldName = "__WASB_PASSWORD__";
		if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_67);
    
		} else {

    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_70);
    
		}

    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_USERNAME__"));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_CONTAINER__"));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(ElementParameterParser.getValue(node, "__HDINSIGHT_USERNAME__"));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_USERNAME__"));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_HOST__"));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_PORT__"));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(ElementParameterParser.getValue(node, "__STATUSDIR__"));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(ElementParameterParser.getValue(node, "__REMOTE_FOLDER__"));
    stringBuffer.append(TEXT_89);
    
	} else {
		String azureConnection = ElementParameterParser.getValue(node,"__CONNECTION__");

    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(azureConnection);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(azureConnection);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    
	}

    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    
		if("false".equals(useExistingConn)) { // This variable is declared and initialized in the GetAzureConnection.javajet
			boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
			if(setMemory) {
				String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
				String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
				String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_109);
    
			}

			List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
			if(advProps!=null) {
				for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_109);
    
				}
			}

    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    
		}
    } else if(hiveDistrib.isGoogleDataprocDistribution()) {
		// Distribution: Google Dataproc

    
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");

    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    
	if("false".equals(useExistingConn)) {

    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    
        boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
        if(setMemory) {
            String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
            String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
            String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_109);
    
        }

        List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
        if(advProps!=null) {
            for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_109);
    
            }
        }

    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GOOGLE_JARS_BUCKET__"));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GOOGLE_CLUSTER_ID__"));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GOOGLE_REGION__"));
    stringBuffer.append(TEXT_140);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GOOGLE_PROJECT_ID__"));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GOOGLE_JARS_BUCKET__"));
    stringBuffer.append(TEXT_142);
    
            if(ElementParameterParser.getBooleanValue(node, "__DEFINE_PATH_TO_GOOGLE_CREDENTIALS__")) {

    stringBuffer.append(TEXT_143);
    stringBuffer.append(ElementParameterParser.getValue(node, "__PATH_TO_GOOGLE_CREDENTIALS__"));
    stringBuffer.append(TEXT_142);
                  
            }

    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    
        if(isLog4jEnabled) {

    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    
        }
	} else {
		String dataprocConnection = ElementParameterParser.getValue(node,"__CONNECTION__");

    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(dataprocConnection);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(dataprocConnection);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    
	}

    
	} else if (hiveDistrib.isQuboleDistribution()) {  // get qubole connection
		// Distribution: Qubole

    stringBuffer.append(TEXT_156);
    
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");

    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    
	if("false".equals(useExistingConn)) {

    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    
        boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
        if(setMemory) {
            String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
            String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
            String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_109);
    
        }

        List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
        if(advProps!=null) {
            for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_109);
    
            }
        }

    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(encryptedToken);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
     if (quboleEndpoint != null) {
    stringBuffer.append(TEXT_161);
    stringBuffer.append(quboleEndpoint);
    stringBuffer.append(TEXT_162);
    } 
    stringBuffer.append(TEXT_163);
    
        if(isLog4jEnabled) {

    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    
        }
	} else {
		String quboleConnection = ElementParameterParser.getValue(node,"__CONNECTION__");

    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(quboleConnection);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(quboleConnection);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(quboleConnection);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(quboleConnection);
    stringBuffer.append(TEXT_171);
    
	}

    
	} else {
		// Distribution: other than WebHCat, Dataproc, Qubole

    stringBuffer.append(TEXT_156);
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
    stringBuffer.append(TEXT_67);
    
	}

	String yarnClasspathSeparator = ElementParameterParser.getValue(node, "__CLASSPATH_SEPARATOR__");

    stringBuffer.append(TEXT_176);
    stringBuffer.append(yarnClasspathSeparator);
    stringBuffer.append(TEXT_67);
    

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
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
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
    stringBuffer.append(TEXT_67);
    
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
    stringBuffer.append(TEXT_66);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_209);
    } else {
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
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
    stringBuffer.append(TEXT_76);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_67);
    
			}
		}

		if(((isCustom && !useYarn) || (!isCustom && hiveDistrib.isHadoop1())) && setMapredJT) {
			String mapredJT = ElementParameterParser.getValue(node, "__MAPRED_JT__");

    stringBuffer.append(TEXT_217);
    stringBuffer.append(mapredJT);
    stringBuffer.append(TEXT_67);
    
		}

		if(setNamenode) {
			String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");

    stringBuffer.append(TEXT_218);
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_67);
    
		}

    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_221);
    
		passwordFieldName = "__PASS__";
		
    stringBuffer.append(TEXT_57);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_67);
    } else {
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_70);
    }
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    
        boolean setHadoopUser = "true".equals(ElementParameterParser.getValue(node, "__SET_HADOOP_USER__"));
        if (setHadoopUser) {
            String hadoopUser = ElementParameterParser.getValue(node, "__HADOOP_USER__");
            
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(hadoopUser);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_231);
    
        }
        
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    
		if("EMBEDDED".equals(connectionMode) && (isCustom || hiveDistrib.doSupportEmbeddedMode())) {

    stringBuffer.append(TEXT_234);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_237);
    
			if(isCustom || (!isCustom && hiveDistrib.doSupportImpersonation())) {

    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_241);
    
			}
		} else if("STANDALONE".equals(connectionMode) && (isCustom || hiveDistrib.doSupportStandaloneMode())) {
				if(securedStandaloneHive2) {
					// using keytab with HiveServer2 in standalone mode
					boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
					String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
					String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
                    
					if ((isCustom || hiveDistrib.doSupportMapRTicket()) && useMapRTicket) {
                        
    stringBuffer.append(TEXT_242);
    stringBuffer.append(setMapRHomeDir ? mapRHomeDir : "\"/opt/mapr\"" );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(setMapRHadoopLogin ? mapRHadoopLogin : "\"kerberos\"");
    stringBuffer.append(TEXT_67);
    
                    }
					if(useKeytab) {

    stringBuffer.append(TEXT_244);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_67);
    
					}
					// Using SSL in Secure Mode
					if(useSsl && hiveDistrib.doSupportSSL()){
						// Does the distrib support SSL + KERBEROS
						if(hiveDistrib.doSupportSSLwithKerberos()){
							if (ElementParameterParser.canEncrypt(node, sslStorepasswordFieldName)) {

    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, sslStorepasswordFieldName));
    stringBuffer.append(TEXT_67);
    
							}else{

    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append( ElementParameterParser.getValue(node, sslStorepasswordFieldName));
    stringBuffer.append(TEXT_246);
    
							}

    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(sslTrustStore);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    
						// Does the distrib support only SASL-QOP + KERBEROS
						} else {
						

    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_253);
    
						}
					}else{

    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_246);
    
					}
					if ((isCustom || hiveDistrib.doSupportMapRTicket()) && useMapRTicket) {
                        
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(mapRTicketCluster);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(mapRTicketDuration);
    stringBuffer.append(TEXT_67);
    
                    }
				} else {
                    // Mapr ticket
				    if ((isCustom || hiveDistrib.doSupportMapRTicket()) && useMapRTicket) {
                        passwordFieldName = "__MAPRTICKET_PASSWORD__";
                        
    stringBuffer.append(TEXT_242);
    stringBuffer.append(setMapRHomeDir ? mapRHomeDir : "\"/opt/mapr\"" );
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    
                        if (setMapRHadoopLogin) {
                            
    stringBuffer.append(TEXT_260);
    stringBuffer.append(mapRHadoopLogin);
    stringBuffer.append(TEXT_67);
    
                        } else {
                            
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    
                        }
                        if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_67);
    } else {
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_246);
    }
                        	if(hiveDistrib.doSupportMaprTicketV52API()){
                				
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(mapRTicketCluster);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(mapRTicketUsername);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(mapRTicketDuration);
    stringBuffer.append(TEXT_267);
    
                			} else {
                				
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(mapRTicketCluster);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(mapRTicketUsername);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(mapRTicketDuration);
    stringBuffer.append(TEXT_268);
    
                			}
                    }

                    // Using SSL in non Secure Mode
					if(useSsl && hiveDistrib.doSupportSSL()){
						if (ElementParameterParser.canEncrypt(node, sslStorepasswordFieldName)) {

    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, sslStorepasswordFieldName));
    stringBuffer.append(TEXT_67);
    
						}else{

    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append( ElementParameterParser.getValue(node, sslStorepasswordFieldName));
    stringBuffer.append(TEXT_246);
    
						}

    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(sslTrustStore);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    
					}else{

    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_246);
    
					}
				}
				String additionalJdbcSettings = ElementParameterParser.getValue(node, "__HIVE_ADDITIONAL_JDBC__");

    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(additionalJdbcSettings);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
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
    
			}

    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(javaDbDriver );
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    
	   		log4jCodeGenerateUtil.debugConnectionParams(node);
		
    stringBuffer.append(TEXT_156);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    }
    
		if(securedStandaloneHive2) {

    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    
		} else {

    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    
		}

    stringBuffer.append(TEXT_156);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_289);
    }
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    
    	if(!isCustom && ("HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion))) {
        	String mapMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_MAP_MEMORY_MB__");
       		String reduceMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_REDUCE_MEMORY_MB__");

    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_67);
    
	}

	boolean isKerberosAvailableHadoop2 = !isCustom && hiveDistrib.isHadoop2() && hiveDistrib.doSupportKerberos();
	boolean isHadoop2 = !isCustom && hiveDistrib.isHadoop2();
	boolean isKerberosAvailableHadoop1 = !isCustom && hiveDistrib.isHadoop1() && hiveDistrib.doSupportKerberos();

	if(securedEmbedded) {
		String namenodePrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");

    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(namenodePrincipal);
    stringBuffer.append(TEXT_67);
    
		if(isKerberosAvailableHadoop1 || (isCustom && !useYarn)) {
			String jobtrackerPrincipal = ElementParameterParser.getValue(node, "__JOBTRACKER_PRINCIPAL__");

    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(jobtrackerPrincipal);
    stringBuffer.append(TEXT_67);
    
		}
		if(isKerberosAvailableHadoop2 || (isCustom && useYarn)) {
			String resourceManagerPrincipal = ElementParameterParser.getValue(node, "__RESOURCEMANAGER_PRINCIPAL__");

    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(resourceManagerPrincipal);
    stringBuffer.append(TEXT_67);
    
		}

	}

    	boolean setResourceManager = "true".equals(ElementParameterParser.getValue(node, "__SET_RESOURCE_MANAGER__"));

    	if((isCustom && useYarn) || (!isCustom && isHadoop2)) {
    		if(setResourceManager) {
    			String resourceManager = ElementParameterParser.getValue(node, "__RESOURCE_MANAGER__");

    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(resourceManager);
    stringBuffer.append(TEXT_67);
    
			}

			boolean setJobHistoryAddress = "true".equals(ElementParameterParser.getValue(node, "__SET_JOBHISTORY_ADDRESS__"));
			if(setJobHistoryAddress) {
				String jobHistoryAddress = ElementParameterParser.getValue(node,"__JOBHISTORY_ADDRESS__");
    			
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(jobHistoryAddress);
    stringBuffer.append(TEXT_306);
    
			}

    		boolean setSchedulerAddress = "true".equals(ElementParameterParser.getValue(node, "__SET_SCHEDULER_ADDRESS__"));
    		if(setSchedulerAddress) {
    			String schedulerAddress = ElementParameterParser.getValue(node,"__RESOURCEMANAGER_SCHEDULER_ADDRESS__");

    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(schedulerAddress);
    stringBuffer.append(TEXT_67);
    
			}

            if ("true".equals(ElementParameterParser.getValue(node, "__USE_DATANODE_HOSTNAME__"))) {
                
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    
            }

    		if("true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"))) {
    			String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");

    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_67);
    
			}

			if("EMBEDDED".equals(connectionMode) && (isCustom || hiveDistrib.doSupportEmbeddedMode())) {
				boolean crossPlatformSubmission = "true".equals(ElementParameterParser.getValue(node, "__CROSS_PLATFORM_SUBMISSION__"));
				if((isCustom && useYarn && crossPlatformSubmission) || (!isCustom && hiveDistrib.doSupportCrossPlatformSubmission())) {

    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    
				}

				if("MAPR410".equals(hiveVersion)){

    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    
				}

				if(hiveDistrib.doSupportCustomMRApplicationCP()){

    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(hiveDistrib.getCustomMRApplicationCP());
    stringBuffer.append(TEXT_316);
    
				}


    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(hiveDistrib.getYarnApplicationClasspath());
    stringBuffer.append(TEXT_316);
    
			}

    		boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
    		if(setMemory) {
    			String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
    			String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
    			String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_67);
    
			}
		}

		List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
		if(advProps!=null) {
			for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_67);
    
			}
		}

    stringBuffer.append(TEXT_57);
    
		if(("false").equals(useExistingConn)){
		
    stringBuffer.append(TEXT_324);
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
    	
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    
            if(advProps != null){
                for(Map<String, String> item : advProps){
                    if("\"tez.lib.uris\"".equals(item.get("PROPERTY"))){
                    
    stringBuffer.append(TEXT_327);
      
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
        
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_332);
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
        
        
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(fsDefaultNameKey);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_336);
    
        if(mrUseDatanodeHostname && (isCustom || hdfsDistrib.doSupportUseDatanodeHostname())){
        
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    
        }
        if(hadoopProps!=null && hadoopProps.size() > 0){
        	for(Map<String, String> item : hadoopProps){
        	
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_341);
     
    		}
    	}
        	
    	if((hdfsDistrib.doSupportKerberos() && useKrb && !isCustom) || (isCustom && useKrb)){
    	
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(kerberosPrincipal);
    stringBuffer.append(TEXT_345);
    
    		if(useKeytab){
    		
    stringBuffer.append(TEXT_346);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_345);
    
    		}
    	}
    	
    	if(hdfsDistrib.doSupportGroup()){
    		
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    
        }else{
        
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(fsDefaultNameKey);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    
        }
    }
}

      
                (new GetFileSystem()).invoke(node, cid);
                String tezLibFolder = ElementParameterParser.getValue(node, "__TEZ_LIB_FOLDER__");
                boolean useDefaultTezLibFolder = "\"/tmp/{USERNAME}/talend_tez_libs/{custom|HIVE_VERSION}\"".equals(tezLibFolder);
                if(useDefaultTezLibFolder){
                
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(isCustom?"custom":hiveVersion);
    stringBuffer.append(TEXT_365);
    
                }else{
                
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(tezLibFolder);
    stringBuffer.append(TEXT_246);
    
                }
                
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
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
                
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    if(changePathSeparator){
    stringBuffer.append(TEXT_371);
    }else{
    stringBuffer.append(TEXT_372);
    }
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    
                    for(String jarName : tezLibJarsName){
                    
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(jarName);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(jarName);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    
                    }
                    
    stringBuffer.append(TEXT_388);
    
            }else{
            
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(ElementParameterParser.getValue(node, "__TEZ_LIB_PATH__"));
    stringBuffer.append(TEXT_246);
    
            }
            //define the location of tez lib    
            
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
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
    stringBuffer.append(ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__"));
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid);
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
    
    	}
    }
}

    stringBuffer.append(TEXT_407);
    
            	(new PrepareTez()).invoke(node, cid);
        }
    	
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
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
    stringBuffer.append(TEXT_410);
    if("true".equalsIgnoreCase(storeByHBase) && (isCustom || hiveDistrib.doSupportHBaseForHive())) {
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    if(zookeeperQuorumForHBase!=null && !"".equals(zookeeperQuorumForHBase) && !"\"\"".equals(zookeeperQuorumForHBase)) {
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(zookeeperQuorumForHBase);
    stringBuffer.append(TEXT_345);
    }
    stringBuffer.append(TEXT_415);
    if(zookeeperClientPortForHBase!=null && !"".equals(zookeeperClientPortForHBase) && !"\"\"".equals(zookeeperClientPortForHBase)) {
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(zookeeperClientPortForHBase);
    stringBuffer.append(TEXT_341);
    }
    stringBuffer.append(TEXT_418);
    if(setZNodeParent && zNodeParent!=null && !"".equals(zNodeParent) && !"\"\"".equals(zNodeParent)) {
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(zNodeParent);
    stringBuffer.append(TEXT_201);
    }
    stringBuffer.append(TEXT_418);
    if(useKrb){
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_422);
    if(hbaseMasterPrincipal!=null && !"".equals(hbaseMasterPrincipal) && !"\"\"".equals(hbaseMasterPrincipal)){
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(hbaseMasterPrincipal);
    stringBuffer.append(TEXT_215);
    }
    stringBuffer.append(TEXT_425);
    if(hbaseRegionServerPrincipal!=null && !"".equals(hbaseRegionServerPrincipal) && !"\"\"".equals(hbaseRegionServerPrincipal)){
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(hbaseRegionServerPrincipal);
    stringBuffer.append(TEXT_215);
    }
    stringBuffer.append(TEXT_427);
    }
    stringBuffer.append(TEXT_415);
    if("true".equalsIgnoreCase(defineRegisterJar) && registerJarForHBase!=null && registerJarForHBase.size()>0) {
        		for(Map<String, String> jar : registerJarForHBase){
        			String path = jar.get("JAR_PATH");
        			if(path == null || "".equals(path) || "\"\"".equals(path)) {
        				continue;
        			}
        	
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_345);
    
    			}
    		}

    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    
	  	}
	}

    
	}

	String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
	boolean setFsDefaultName = "true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"));
	String fsDefaultName = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	INode connectionInformationNode = node;

	if("true".equals(useExistingConn) && !hiveDistrib.useCloudLauncher()) {
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

	boolean isParquetSupported = isCustom || hiveDistrib.doSupportParquetFormat();
	if(useParquet && !isParquetSupported) {

    stringBuffer.append(TEXT_431);
    
	}

	// Register jars to handle parquet format.

	java.util.List<String> jarsToRegister = null;
	java.util.List<String> jars = null;
	boolean generateAddJarCodeForAll = useParquet;
	if(generateAddJarCodeForAll) {
		String[] commandLine = new String[] {"<command>"};
		try {
			commandLine = ProcessorUtilities.getCommandLine("win32",true, processId, "",org.talend.designer.runprocess.IProcessor.NO_STATISTICS,org.talend.designer.runprocess.IProcessor.NO_TRACES, new String[]{});
		} catch (ProcessorException e) {
			e.printStackTrace();
		}

		jarsToRegister = new java.util.ArrayList();

		jarsToRegister.add("snappy-java");
		jarsToRegister.add("parquet-hive-bundle");

		for (int j = 0; j < commandLine.length; j++) {
			if(commandLine[j].contains("jar")) {
				jars = java.util.Arrays.asList(commandLine[j].split(";"));
				break;
			}
		}
	}

	if(jarsToRegister!=null && jars!=null) {
		if("EMBEDDED".equalsIgnoreCase(connectionMode) || hiveDistrib.useCloudLauncher()) {

    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_433);
    
		} else {
			generateAddJarCodeForAll = false;
			if(setFsDefaultName) {
				generateAddJarCodeForAll = true;

    stringBuffer.append(TEXT_425);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
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
        
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_332);
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
        
        
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(fsDefaultNameKey);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_336);
    
        if(mrUseDatanodeHostname && (isCustom || hdfsDistrib.doSupportUseDatanodeHostname())){
        
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    
        }
        if(hadoopProps!=null && hadoopProps.size() > 0){
        	for(Map<String, String> item : hadoopProps){
        	
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_341);
     
    		}
    	}
        	
    	if((hdfsDistrib.doSupportKerberos() && useKrb && !isCustom) || (isCustom && useKrb)){
    	
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(kerberosPrincipal);
    stringBuffer.append(TEXT_345);
    
    		if(useKeytab){
    		
    stringBuffer.append(TEXT_346);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_345);
    
    		}
    	}
    	
    	if(hdfsDistrib.doSupportGroup()){
    		
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    
        }else{
        
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(fsDefaultNameKey);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    
        }
    }
}

    stringBuffer.append(TEXT_427);
    
			(new GetFileSystem()).invoke(connectionInformationNode, cid);
			
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid);
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
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_448);
    
			}
		}

		if(generateAddJarCodeForAll) {

    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    
			for(int i=0; i<jarsToRegister.size(); i++) {
				String jarToRegister = jarsToRegister.get(i);
				for(int j=0; j<jars.size(); j++) {
					if(jars.get(j).contains(jarToRegister)) {
						if(!hiveDistrib.useCloudLauncher()) { // Then we use the created SQL statement to add the jars.

    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_453);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_455);
    
						} else { // cloud distribution
                            if(hiveDistrib.isExecutedThroughWebHCat()) {

    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_453);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_453);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_461);
    
                            } else if (hiveDistrib.isQuboleDistribution()) {

    stringBuffer.append(TEXT_462);
    
                            } else { // dataproc
                                if(isLog4jEnabled) {

    stringBuffer.append(TEXT_463);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_453);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_465);
    
                                }

    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_453);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_453);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_461);
    
                            }
                        }
					}
				}
			}
		}
	}

	// End of parquet format handling.

	if(!("true").equals(useExistingConn) && !hiveDistrib.useCloudLauncher()) {
	    if(!("").equals(commitEvery) && !("0").equals(commitEvery)) {
	        
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_472);
    
	    }
	}

	if(!hiveDistrib.useCloudLauncher()) {
		if (usePrepareStatement) {
		
    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_474);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_282);
    
		}
		
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_476);
    
	}

    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_479);
    return stringBuffer.toString();
  }
}
