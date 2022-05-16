package org.talend.designer.codegen.translators.file.hadoop;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.Map;
import java.util.List;

public class THDFSInputBeginJava
{
  protected static String nl;
  public static synchronized THDFSInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THDFSInputBeginJava result = new THDFSInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t\t";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_4 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_5 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_6 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_7 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_8 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_9 = " - Written records count: \" + nb_line_";
  protected final String TEXT_10 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_11 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_12 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_13 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_14 = " - Writing the record \" + nb_line_";
  protected final String TEXT_15 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_16 = " - Processing the record \" + nb_line_";
  protected final String TEXT_17 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_18 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_19 = NL;
  protected final String TEXT_20 = NL + "String username_";
  protected final String TEXT_21 = " = \"\";" + NL + "org.apache.hadoop.fs.FileSystem fs_";
  protected final String TEXT_22 = " = null;";
  protected final String TEXT_23 = NL + "\torg.apache.hadoop.conf.Configuration conf_";
  protected final String TEXT_24 = " = new org.apache.hadoop.conf.Configuration();" + NL + "\t" + NL + "\t";
  protected final String TEXT_25 = NL + "\t\tconf_";
  protected final String TEXT_26 = ".set(\"";
  protected final String TEXT_27 = "\", ";
  protected final String TEXT_28 = ");" + NL + "\t\tconf_";
  protected final String TEXT_29 = ".set(\"dfs.adls.oauth2.access.token.provider.type\", \"ClientCredential\");" + NL + "\t\tconf_";
  protected final String TEXT_30 = ".set(\"fs.adl.impl\", \"org.apache.hadoop.fs.adl.AdlFileSystem\");" + NL + "\t\tconf_";
  protected final String TEXT_31 = ".set(\"fs.AbstractFileSystem.adl.impl\", \"org.apache.hadoop.fs.adl.Adl\");" + NL + "\t\tconf_";
  protected final String TEXT_32 = ".set(\"dfs.adls.oauth2.client.id\", ";
  protected final String TEXT_33 = ".set(\"dfs.adls.oauth2.credential\", ";
  protected final String TEXT_34 = ".set(\"dfs.adls.oauth2.refresh.url\", ";
  protected final String TEXT_35 = ");" + NL + "\t";
  protected final String TEXT_36 = NL + "\t        conf_";
  protected final String TEXT_37 = ".set(\"dfs.client.use.datanode.hostname\", \"true\");" + NL + "\t        ";
  protected final String TEXT_38 = NL + "\t\t\t\tconf_";
  protected final String TEXT_39 = ".set(";
  protected final String TEXT_40 = " ,";
  protected final String TEXT_41 = ");" + NL + "\t\t\t";
  protected final String TEXT_42 = NL + "\t            System.setProperty(\"pname\", \"MapRLogin\");" + NL + "\t            System.setProperty(\"https.protocols\", \"TLSv1.2\");" + NL + "\t            System.setProperty(\"mapr.home.dir\", ";
  protected final String TEXT_43 = ");" + NL + "\t            com.mapr.login.client.MapRLoginHttpsClient maprLogin_";
  protected final String TEXT_44 = " = new com.mapr.login.client.MapRLoginHttpsClient();" + NL + "\t            ";
  protected final String TEXT_45 = NL + "\t                System.setProperty(\"hadoop.login\", ";
  protected final String TEXT_46 = ");" + NL + "\t                ";
  protected final String TEXT_47 = NL + "\t                maprLogin_";
  protected final String TEXT_48 = ".setCheckUGI(false);" + NL + "\t                ";
  protected final String TEXT_49 = NL + "\t            ";
  protected final String TEXT_50 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_51 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_52 = ");";
  protected final String TEXT_53 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_54 = " = ";
  protected final String TEXT_55 = "; ";
  protected final String TEXT_56 = NL + "\t" + NL + "\t            ";
  protected final String TEXT_57 = NL + "\t            \tmaprLogin_";
  protected final String TEXT_58 = ".getMapRCredentialsViaPassword(";
  protected final String TEXT_59 = ", ";
  protected final String TEXT_60 = ", decryptedPassword_";
  protected final String TEXT_61 = ", \"\");" + NL + "\t            \t";
  protected final String TEXT_62 = ");" + NL + "\t            \t";
  protected final String TEXT_63 = ");" + NL + "\t            System.setProperty(\"hadoop.login\", ";
  protected final String TEXT_64 = ");" + NL + "\t            ";
  protected final String TEXT_65 = NL + "\t\t\tconf_";
  protected final String TEXT_66 = ".set(\"dfs.namenode.kerberos.principal\", ";
  protected final String TEXT_67 = NL + "\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_68 = NL + "\t            com.mapr.login.client.MapRLoginHttpsClient maprLogin_";
  protected final String TEXT_69 = " = new com.mapr.login.client.MapRLoginHttpsClient();" + NL + "\t            maprLogin_";
  protected final String TEXT_70 = ".getMapRCredentialsViaKerberos(";
  protected final String TEXT_71 = NL + "       org.apache.hadoop.security.UserGroupInformation.setConfiguration(conf_";
  protected final String TEXT_72 = NL + "    \tconf_";
  protected final String TEXT_73 = ".set(\"hadoop.job.ugi\",";
  protected final String TEXT_74 = "+\",\"+";
  protected final String TEXT_75 = ");" + NL + "    \tfs_";
  protected final String TEXT_76 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_77 = NL + "\t\tusername_";
  protected final String TEXT_78 = ";" + NL + "\t\tif(username_";
  protected final String TEXT_79 = " == null || \"\".equals(username_";
  protected final String TEXT_80 = ")){" + NL + "\t\t\tfs_";
  protected final String TEXT_81 = ");" + NL + "\t\t}else{" + NL + "\t\t\tSystem.setProperty(\"HADOOP_USER_NAME\", username_";
  protected final String TEXT_82 = ");" + NL + "\t\t\tfs_";
  protected final String TEXT_83 = " = org.apache.hadoop.fs.FileSystem.get(new java.net.URI(conf_";
  protected final String TEXT_84 = ".get(\"";
  protected final String TEXT_85 = "\")),conf_";
  protected final String TEXT_86 = ",username_";
  protected final String TEXT_87 = ");" + NL + "\t\t}\t" + NL + "\t";
  protected final String TEXT_88 = " = (org.apache.hadoop.conf.Configuration)globalMap.get(\"conn_";
  protected final String TEXT_89 = "\");" + NL + "\t";
  protected final String TEXT_90 = NL + "\t\t    \tfs_";
  protected final String TEXT_91 = NL + "\t\t\t\t\t\tconf_";
  protected final String TEXT_92 = "\t\t\t\t\t" + NL + "\t\t\t\t\tusername_";
  protected final String TEXT_93 = ";";
  protected final String TEXT_94 = NL + "\t\t\t\t\tif(!org.apache.hadoop.security.UserGroupInformation.isSecurityEnabled()) {" + NL + "\t\t\t\t\t\tusername_";
  protected final String TEXT_95 = " = conf_";
  protected final String TEXT_96 = ".get(\"talend.hadoop.user.name\", \"\");" + NL + "\t\t\t\t\t}";
  protected final String TEXT_97 = NL + "\t\t\t\tif(username_";
  protected final String TEXT_98 = ")){" + NL + "\t\t\t\t\tfs_";
  protected final String TEXT_99 = ");" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\tSystem.setProperty(\"HADOOP_USER_NAME\", username_";
  protected final String TEXT_100 = ");" + NL + "\t\t\t\t\tfs_";
  protected final String TEXT_101 = ");" + NL + "\t\t\t\t}\t\t\t  \t\t" + NL + "\t\t  \t";
  protected final String TEXT_102 = NL + "\t\torg.apache.hadoop.fs.Path rootPath_";
  protected final String TEXT_103 = " = new org.apache.hadoop.fs.Path(";
  protected final String TEXT_104 = ");" + NL + "\t\torg.apache.hadoop.fs.FileStatus rootStatu_";
  protected final String TEXT_105 = " = fs_";
  protected final String TEXT_106 = ".getFileStatus(rootPath_";
  protected final String TEXT_107 = ");" + NL + "\t\tfinal java.util.List<org.apache.hadoop.fs.FileStatus> status_";
  protected final String TEXT_108 = " = new java.util.ArrayList<org.apache.hadoop.fs.FileStatus>();" + NL + "\t\tif(rootStatu_";
  protected final String TEXT_109 = ".isDir()) {" + NL + "        \tfinal org.apache.hadoop.fs.FileSystem filesystem_";
  protected final String TEXT_110 = ";" + NL + "        \tfilesystem_";
  protected final String TEXT_111 = ".listStatus(rootPath_";
  protected final String TEXT_112 = ",new org.apache.hadoop.fs.PathFilter() {" + NL + "        \t" + NL + "        \t\tpublic boolean accept(org.apache.hadoop.fs.Path path) {" + NL + "        \t\t\ttry {" + NL + "        \t\t\t\torg.apache.hadoop.fs.FileStatus statu = filesystem_";
  protected final String TEXT_113 = ".getFileStatus(path);" + NL + "        \t\t\t\tString name = path.getName();" + NL + "        \t\t\t\tif(statu.isDir()) {" + NL + "        \t\t\t\t\t";
  protected final String TEXT_114 = NL + "        \t\t\t\t\tfilesystem_";
  protected final String TEXT_115 = ".listStatus(path, this);" + NL + "        \t\t\t\t\t";
  protected final String TEXT_116 = NL + "        \t\t\t\t} else if (name.startsWith(\".\") || name.startsWith(\"_\")) {" + NL + "        \t\t\t\t} else {" + NL + "        \t\t\t\t\tstatus_";
  protected final String TEXT_117 = ".add(statu);" + NL + "        \t\t\t\t}" + NL + "        \t\t\t} catch (java.io.FileNotFoundException e) {" + NL + "        \t\t\t\te.printStackTrace();" + NL + "        \t\t\t\t" + NL + "        \t\t\t\t";
  protected final String TEXT_118 = NL + "       \t\t\t\t\tlog.error(\"";
  protected final String TEXT_119 = " - \" + e.getMessage());" + NL + "        \t\t\t\t";
  protected final String TEXT_120 = NL + "        \t\t\t} catch (java.io.IOException e) {" + NL + "        \t\t\t\te.printStackTrace();" + NL + "        \t\t\t\t" + NL + "    \t\t\t\t\t";
  protected final String TEXT_121 = NL + "        \t\t\t}" + NL + "        \t\t\treturn false;" + NL + "        \t\t}" + NL + "        " + NL + "        \t});\t\t\t" + NL + "\t\t} else {" + NL + "\t\t\tstatus_";
  protected final String TEXT_122 = ".add(rootStatu_";
  protected final String TEXT_123 = ");" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_124 = NL + "\t\tint nb_line_";
  protected final String TEXT_125 = " = 0;" + NL + "\t\t" + NL + "\t\tfor(org.apache.hadoop.fs.FileStatus statu_";
  protected final String TEXT_126 = " : status_";
  protected final String TEXT_127 = ") {" + NL + "\t\t\torg.apache.hadoop.fs.Path path_";
  protected final String TEXT_128 = " = statu_";
  protected final String TEXT_129 = ".getPath();";
  protected final String TEXT_130 = NL + "\t\torg.apache.hadoop.fs.FSDataInputStream fsDataInputStream_";
  protected final String TEXT_131 = ".open(path_";
  protected final String TEXT_132 = NL + "\t\torg.talend.fileprocess.FileInputDelimited fid_";
  protected final String TEXT_133 = " = new org.talend.fileprocess.FileInputDelimited(fsDataInputStream_";
  protected final String TEXT_134 = ",  ";
  protected final String TEXT_135 = ",";
  protected final String TEXT_136 = ",false,";
  protected final String TEXT_137 = ",0,-1,-1, false);";
  protected final String TEXT_138 = NL + "\t\t\t\torg.apache.hadoop.io.compress.GzipCodec codec_";
  protected final String TEXT_139 = " = new org.apache.hadoop.io.compress.GzipCodec();" + NL + "\t\t\t\tcodec_";
  protected final String TEXT_140 = ".setConf(conf_";
  protected final String TEXT_141 = ");\t\t\t\t";
  protected final String TEXT_142 = NL + "\t\t\t\torg.apache.hadoop.io.compress.CompressionCodec codec_";
  protected final String TEXT_143 = " = org.apache.hadoop.util.ReflectionUtils.newInstance(org.apache.hadoop.io.compress.BZip2Codec.class, conf_";
  protected final String TEXT_144 = NL + "\t\t\torg.apache.hadoop.io.compress.CompressionInputStream in";
  protected final String TEXT_145 = " = codec_";
  protected final String TEXT_146 = ".createInputStream(fsDataInputStream_";
  protected final String TEXT_147 = ");" + NL + "\t\t\torg.talend.fileprocess.FileInputDelimited fid_";
  protected final String TEXT_148 = " = new org.talend.fileprocess.FileInputDelimited(in";
  protected final String TEXT_149 = NL + "\t\twhile (fid_";
  protected final String TEXT_150 = ".nextRecord()) {";
  protected final String TEXT_151 = NL + "\t\t\t";
  protected final String TEXT_152 = NL + "\t\t\t" + NL + "\t\torg.apache.hadoop.io.SequenceFile.Reader reader_";
  protected final String TEXT_153 = " = new org.apache.hadoop.io.SequenceFile.Reader(fs_";
  protected final String TEXT_154 = ", path_";
  protected final String TEXT_155 = ",  conf_";
  protected final String TEXT_156 = ");" + NL + "\t\t";
  protected final String TEXT_157 = " key_";
  protected final String TEXT_158 = " = (";
  protected final String TEXT_159 = ") reader_";
  protected final String TEXT_160 = ".getKeyClass().newInstance();" + NL + "\t\t";
  protected final String TEXT_161 = " value_";
  protected final String TEXT_162 = ".getValueClass().newInstance();" + NL + "\t\twhile (reader_";
  protected final String TEXT_163 = ".next(key_";
  protected final String TEXT_164 = ", value_";
  protected final String TEXT_165 = ")) {";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    
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
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_13);
    
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
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    stringBuffer.append(TEXT_19);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String fsDefaultName = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");
boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");
String user = null;

String fsDefalutName = "fs.default.name";

String distribution = null;
String hadoopVersion = null;
boolean isCustom = false;
org.talend.hadoop.distribution.component.HDFSComponent hdfsDistrib = null;

boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

log4jFileUtil.componentStartInfo(node);


    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
if(!useExistingConnection) { // if we don't use an existing connection, we create a new hadoop configuration
	distribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
	hadoopVersion = ElementParameterParser.getValue(node, "__DB_VERSION__");
	
	boolean useSchemeADLS = "ADLS".equals(ElementParameterParser.getValue(node, "__SCHEME__"));
	String adlsFSDefaultName = ElementParameterParser.getValue(node, "__ADLS_FS_DEFAULT_NAME__");

	boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
	String kerberosPrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");
	boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
	String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
	String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
    boolean mrUseDatanodeHostname = "true".equals(ElementParameterParser.getValue(node, "__USE_DATANODE_HOSTNAME__"));
    
    boolean useMapRTicket = ElementParameterParser.getBooleanValue(node, "__USE_MAPRTICKET__");
    String mapRTicketCluster = ElementParameterParser.getValue(node, "__MAPRTICKET_CLUSTER__");
    String mapRTicketDuration = ElementParameterParser.getValue(node, "__MAPRTICKET_DURATION__");

    boolean setMapRHomeDir = ElementParameterParser.getBooleanValue(node, "__SET_MAPR_HOME_DIR__");
    String mapRHomeDir = ElementParameterParser.getValue(node, "__MAPR_HOME_DIR__");

    boolean setMapRHadoopLogin = ElementParameterParser.getBooleanValue(node, "__SET_HADOOP_LOGIN__");
    String mapRHadoopLogin = ElementParameterParser.getValue(node, "__HADOOP_LOGIN__");
    
    String adlsClientID = ElementParameterParser.getValue(node, "__ADLS_CLIENT_ID__");
    String adlsAuthTokenEndpoint = ElementParameterParser.getEncryptedValue(node, "__ADLS_AUTH_TOKEN_ENDPOINT__");
    adlsAuthTokenEndpoint = "routines.system.PasswordEncryptUtil.decryptPassword(" + adlsAuthTokenEndpoint + ")";
    String adlsClientKey = ElementParameterParser.getEncryptedValue(node, "__ADLS_CLIENT_KEY__");
    adlsClientKey = "routines.system.PasswordEncryptUtil.decryptPassword(" + adlsClientKey + ")";
    
	try {
		hdfsDistrib = (org.talend.hadoop.distribution.component.HDFSComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(distribution, hadoopVersion);
	} catch (java.lang.Exception e) {
		e.printStackTrace();
		return "";
	}
    isCustom = hdfsDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;

	String auth = ElementParameterParser.getValue(node, "__AUTHENTICATION_MODE__");
	
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
	if(useSchemeADLS) {
	
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(adlsFSDefaultName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(adlsClientID);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(adlsClientKey);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(adlsAuthTokenEndpoint);
    stringBuffer.append(TEXT_35);
    
	} else {
	
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_35);
    
		if (hdfsDistrib.doSupportUseDatanodeHostname() && mrUseDatanodeHostname) {
	        
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
	    }
		if(hadoopProps!=null && hadoopProps.size() > 0){
			for(Map<String, String> item : hadoopProps){
			
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_41);
     
			}
		}
		
		if(!((!isCustom && hdfsDistrib.doSupportKerberos() && useKrb) || (isCustom && "KRB".equals(auth)))) {
			user = ElementParameterParser.getValue(node, "__USERNAME__");
			if ((isCustom || hdfsDistrib.doSupportMapRTicket()) && useMapRTicket) {
	            String passwordFieldName = "__MAPRTICKET_PASSWORD__";
	            
    stringBuffer.append(TEXT_42);
    stringBuffer.append(setMapRHomeDir ? mapRHomeDir : "\"/opt/mapr\"" );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
	            if (setMapRHadoopLogin) {
	                
    stringBuffer.append(TEXT_45);
    stringBuffer.append(mapRHadoopLogin);
    stringBuffer.append(TEXT_46);
    
	            } else {
	                
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
	            }
	            
    stringBuffer.append(TEXT_49);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_52);
    } else {
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_55);
    }
    stringBuffer.append(TEXT_56);
    
	            if(hdfsDistrib.doSupportMaprTicketV52API()){
					
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(mapRTicketCluster);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(mapRTicketDuration);
    stringBuffer.append(TEXT_61);
    
	            }else{
	            	
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(mapRTicketCluster);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(mapRTicketDuration);
    stringBuffer.append(TEXT_62);
    
	            }
	        }
		} else {
		    if ((isCustom || hdfsDistrib.doSupportMapRTicket()) && useMapRTicket) {
	            
    stringBuffer.append(TEXT_42);
    stringBuffer.append(setMapRHomeDir ? mapRHomeDir : "\"/opt/mapr\"" );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(setMapRHadoopLogin ? mapRHadoopLogin : "\"kerberos\"");
    stringBuffer.append(TEXT_64);
    
	        }
	
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(kerberosPrincipal);
    stringBuffer.append(TEXT_35);
    
			if(useKeytab) {
	
    stringBuffer.append(TEXT_67);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_35);
    
			}
	        if ((isCustom || hdfsDistrib.doSupportMapRTicket()) && useMapRTicket) {
	            
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(mapRTicketCluster);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(mapRTicketDuration);
    stringBuffer.append(TEXT_64);
    
	        }
		}
	}


    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
	
	if((!isCustom && hdfsDistrib.doSupportGroup()) || (isCustom && "UGI".equals(auth))){
		String group = ElementParameterParser.getValue(node, "__GROUP__");
	
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(group);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
	}else{
	
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    
	}
	
} else { // We re use the existing connection, coming from the component learned.
	String connectionSid = ElementParameterParser.getValue(node, "__CONNECTION__");
	
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(connectionSid);
    stringBuffer.append(TEXT_89);
    
	List<? extends INode> nodes = node.getProcess().getGeneratingNodes();
    for(INode targetNode : nodes){
		if (targetNode.getUniqueName().equals(connectionSid)) {
        	distribution = ElementParameterParser.getValue(targetNode, "__DISTRIBUTION__");
        	hadoopVersion = ElementParameterParser.getValue(targetNode, "__DB_VERSION__"); 

    		boolean useKrb = "true".equals(ElementParameterParser.getValue(targetNode, "__USE_KRB__"));
    		String kerberosPrincipal = ElementParameterParser.getValue(targetNode, "__NAMENODE_PRINCIPAL__");

			try {
				hdfsDistrib = (org.talend.hadoop.distribution.component.HDFSComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(distribution, hadoopVersion);
			} catch (java.lang.Exception e) {
				e.printStackTrace();
				return "";
			}
    		isCustom = hdfsDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;

    		String auth = ElementParameterParser.getValue(targetNode, "__AUTHENTICATION_MODE__");
		
	      	if((!isCustom && hdfsDistrib.doSupportGroup()) || (isCustom && "UGI".equals(auth))){
		    
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    
		  	}else{
		  		boolean configureFromClassPath = "true".equals(ElementParameterParser.getValue(targetNode, "__CONFIGURATIONS_FROM_CLASSPATH__"));
		  		if(!configureFromClassPath) {
					if(!((!isCustom && hdfsDistrib.doSupportKerberos() && useKrb) || (isCustom && "KRB".equals(auth)))) {
						user = ElementParameterParser.getValue(targetNode, "__USERNAME__");
					} else {

    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(kerberosPrincipal);
    stringBuffer.append(TEXT_52);
    
					}

    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_93);
    
				} else {
					// If the configuration is inspected from the classpath

    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    				
				}
			  	
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    
		  	}
	      	break;
	    }
    }
}

    stringBuffer.append(TEXT_2);
    
    	IMetadataTable metadata = null;
    	List<IMetadataTable> metadatas = node.getMetadataList();
    	if((metadatas==null) || (metadatas.size() == 0) || ((metadata = metadatas.get(0)) == null)) {
    		return stringBuffer.toString();
    	}
    	
		String mapredJobTracker = ElementParameterParser.getValue(node, "__MAPRED_JOB_TRACKER__");
    	String fileName = ElementParameterParser.getValue(node, "__FILENAME__");
    	boolean incldSubdir = ("true").equals(ElementParameterParser.getValue(node, "__INCLUDSUBDIR__"));
    	
    	String fileAction = ElementParameterParser.getValue(node, "__FILE_ACTION__");
    	
    	String rowSeparator = ElementParameterParser.getValue(node, "__ROWSEPARATOR__");
    	String fieldSeparator = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
    	boolean customEncoding="true".equals( ElementParameterParser.getValue(node,"__CUSTOM_ENCODING__"));
    	String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
    	
    	String typeFile = ElementParameterParser.getValue(node,"__TYPEFILE__");
    	
    	boolean uncompress = "true".equals(ElementParameterParser.getValue(node, "__UNCOMPRESS__"));
    	String compression = ElementParameterParser.getValue(node, "__COMPRESSION__");
    	
    	String header = ElementParameterParser.getValue(node, "__HEADER__");
    	if(("").equals(header)){
    		header="0";
    	}

    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    if(incldSubdir) {
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    }
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    }
    stringBuffer.append(TEXT_120);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    }
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    
		log4jFileUtil.startRetriveDataInfo();

    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    
		if (typeFile.equals("TEXT")) {

    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
			if(!uncompress) {

    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append((customEncoding?encoding:null) );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(fieldSeparator );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(header);
    stringBuffer.append(TEXT_137);
    
			} else {
				if("GZIP".equals(compression)) {

    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    
				} else if("BZIP2".equals(compression)) {

    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
				}

    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append((customEncoding?encoding:null) );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(fieldSeparator );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(header);
    stringBuffer.append(TEXT_137);
    
			}

    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    
		} else {
			String keyColumn = ElementParameterParser.getValue(node,"__KEYCOLUMN__");
			String valueColumn = ElementParameterParser.getValue(node,"__VALUECOLUMN__");
			
			List<IMetadataColumn> listColumns = metadata.getListColumns();
			String talendKeyClass = "";
			String talendValueClass = "";
			for (IMetadataColumn column : listColumns) {
				if (column.getLabel().equals(keyColumn)) {
					talendKeyClass = column.getTalendType();
				}
				if (column.getLabel().equals(valueColumn)) {
					talendValueClass = column.getTalendType();
				}
			}

    stringBuffer.append(TEXT_151);
    
    String keyClass="org.apache.hadoop.io.Text";
    if (talendKeyClass.equals("id_Boolean")) keyClass="org.apache.hadoop.io.BooleanWritable";
    if (talendKeyClass.equals("id_Byte")) keyClass="org.apache.hadoop.io.ByteWritable";
    if (talendKeyClass.equals("id_byte[]")) keyClass="org.apache.hadoop.io.BytesWritable";
    if (talendKeyClass.equals("id_Double")) keyClass="org.apache.hadoop.io.DoubleWritable";
    if (talendKeyClass.equals("id_Float")) keyClass="org.apache.hadoop.io.FloatWritable";
    if (talendKeyClass.equals("id_Integer")) keyClass="org.apache.hadoop.io.IntWritable";
    if (talendKeyClass.equals("id_Long")) keyClass="org.apache.hadoop.io.LongWritable";
    if (talendKeyClass.equals("id_String")) keyClass="org.apache.hadoop.io.Text";
    if (talendKeyClass.equals("id_Short")) {
    	if(isCustom || hdfsDistrib.doSupportSequenceFileShortType()) {
    		keyClass="org.apache.hadoop.io.ShortWritable";
    	} else {
    		keyClass="org.apache.hadoop.io.IntWritable";
    	}
    }
    
    String valueClass="org.apache.hadoop.io.Text";
    if (talendValueClass.equals("id_Boolean")) valueClass="org.apache.hadoop.io.BooleanWritable";
    if (talendValueClass.equals("id_Byte")) valueClass="org.apache.hadoop.io.ByteWritable";
    if (talendValueClass.equals("id_byte[]")) valueClass="org.apache.hadoop.io.BytesWritable";
    if (talendValueClass.equals("id_Double")) valueClass="org.apache.hadoop.io.DoubleWritable";
    if (talendValueClass.equals("id_Float")) valueClass="org.apache.hadoop.io.FloatWritable";
    if (talendValueClass.equals("id_Integer")) valueClass="org.apache.hadoop.io.IntWritable";
    if (talendValueClass.equals("id_Long")) valueClass="org.apache.hadoop.io.LongWritable";
    if (talendValueClass.equals("id_String")) valueClass="org.apache.hadoop.io.Text";
    if (talendValueClass.equals("id_Short")) {
    	if(isCustom || hdfsDistrib.doSupportSequenceFileShortType()) {
    		valueClass="org.apache.hadoop.io.ShortWritable";
    	} else {
    		valueClass="org.apache.hadoop.io.IntWritable";
    	}
    }

    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(keyClass);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(keyClass);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(valueClass);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(valueClass);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    
		}

    return stringBuffer.toString();
  }
}
