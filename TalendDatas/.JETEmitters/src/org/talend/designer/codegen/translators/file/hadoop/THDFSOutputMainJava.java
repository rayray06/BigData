package org.talend.designer.codegen.translators.file.hadoop;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;

public class THDFSOutputMainJava
{
  protected static String nl;
  public static synchronized THDFSOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THDFSOutputMainJava result = new THDFSOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_3 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
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
  protected final String TEXT_18 = NL + "\t";
  protected final String TEXT_19 = NL + "\t\t\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\twriter_";
  protected final String TEXT_21 = ".append(new ";
  protected final String TEXT_22 = "(";
  protected final String TEXT_23 = ".";
  protected final String TEXT_24 = "),new ";
  protected final String TEXT_25 = "));" + NL + "\t\t\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\t\tStringBuilder sb_";
  protected final String TEXT_27 = " = new StringBuilder();" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_28 = NL + "\t\t\t\t\t\tString fieldSeparator_";
  protected final String TEXT_29 = " = ";
  protected final String TEXT_30 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_31 = NL + "\t\t\t\t\t\t\t\tassignValueUtil_";
  protected final String TEXT_32 = ".assignValue_";
  protected final String TEXT_33 = ", sb_";
  protected final String TEXT_34 = ", fieldSeparator_";
  protected final String TEXT_35 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_36 = NL + "\t\t\t\t\t\t\t\tif(";
  protected final String TEXT_37 = " != null) {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_38 = NL + "\t\t\t\t\t\t\t\t\tsb_";
  protected final String TEXT_39 = ".append(" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\t\t\t\t\t\t\t\t\tFormatterUtils.format_Date(";
  protected final String TEXT_41 = ", ";
  protected final String TEXT_42 = ")" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_44 = ".toPlainString()" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\t\t\t\t\t\t\t\t\tjava.nio.charset.Charset.forName(";
  protected final String TEXT_46 = ").decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_47 = ")).toString()" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\t\t\t\t\t\t\t);" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_51 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\tsb_";
  protected final String TEXT_52 = ".append(";
  protected final String TEXT_53 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_54 = "_list_";
  protected final String TEXT_55 = ".add(";
  protected final String TEXT_56 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\t\t\tsb_";
  protected final String TEXT_58 = NL + "\t\t\t\t\t\tout";
  protected final String TEXT_59 = ".write(sb_";
  protected final String TEXT_60 = ".toString());" + NL + "\t\t\t\t\t";
  protected final String TEXT_61 = ".toString().getBytes(";
  protected final String TEXT_62 = NL + "\t\t\t\tnb_line_";
  protected final String TEXT_63 = "++;" + NL + "\t\t\t\t";
  protected final String TEXT_64 = NL + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
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
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_3);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_2);
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
			
    stringBuffer.append(TEXT_2);
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
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    stringBuffer.append(TEXT_18);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String rowSeparator = ElementParameterParser.getValue(node, "__ROWSEPARATOR__");
	String fieldSeparator = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
	boolean customEncoding="true".equals( ElementParameterParser.getValue(node,"__CUSTOM_ENCODING__"));
	String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
	
	boolean compress = "true".equals(ElementParameterParser.getValue(node, "__COMPRESS__"));
	String compression = ElementParameterParser.getValue(node, "__COMPRESSION__");
	
	List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
	IConnection inConn = null;
	IMetadataTable metadata = null;
	
	if(inConns!=null && inConns.size()> 0) {
		inConn = inConns.get(0);
		metadata = inConn.getMetadataTable();
	}

String typeFile = ElementParameterParser.getValue(node,"__TYPEFILE__");

	if (metadata!=null) {
		List< ? extends IConnection> conns = node.getIncomingConnections();
		for (IConnection conn : conns) {
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				if (typeFile.equals("SEQUENCE")) {
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
					
					String hadoopVersion = null;
					String distribution = null;
					boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
					if(!useExistingConnection) {
						distribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
						hadoopVersion = ElementParameterParser.getValue(node, "__DB_VERSION__");
					} else {
						String connectionSid = ElementParameterParser.getValue(node, "__CONNECTION__");
						List<? extends INode> nodes = node.getProcess().getGeneratingNodes();
						for(INode targetNode : nodes){
    						if (targetNode.getUniqueName().equals(connectionSid)) {
    							hadoopVersion = ElementParameterParser.getValue(targetNode, "__DB_VERSION__"); 
    							distribution = ElementParameterParser.getValue(targetNode, "__DISTRIBUTION__");
    							break;
    						}
						}
					}
    				
					org.talend.hadoop.distribution.component.HDFSComponent hdfsDistrib = null;
					try {
						hdfsDistrib = (org.talend.hadoop.distribution.component.HDFSComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(distribution, hadoopVersion);
					} catch (java.lang.Exception e) {
						e.printStackTrace();
						return "";
					}
    				boolean isCustom = hdfsDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;
					
    stringBuffer.append(TEXT_19);
    
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

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(keyClass );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(keyColumn );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(valueClass );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(valueColumn );
    stringBuffer.append(TEXT_25);
    
				} else { // Text file format
					List<IMetadataColumn> columnList = metadata.getListColumns();
					int sizeColumns = columnList.size();
					
					//start to split assign value method to avoid too big method
					int schemaOptNum=100;
					String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
					if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
						schemaOptNum  = Integer.parseInt(schemaOptNumStr);
					}
	    			boolean isOptimizeCode = false;
					if(schemaOptNum < sizeColumns){
						isOptimizeCode = true;
					}
					
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    
					if(isOptimizeCode){
					
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_30);
    
					}
					for (int i = 0; i < sizeColumns; i++) {
						if(isOptimizeCode){
							if(i%schemaOptNum == 0){
							
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
     
							}
						}else{						
						
							IMetadataColumn column = columnList.get(i);
							JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
							boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
							if(!isPrimitive) {
							
    stringBuffer.append(TEXT_36);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_37);
    
							}
							
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    
										String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
										if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {
										
    stringBuffer.append(TEXT_40);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_41);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_42);
    	
										} else if(javaType == JavaTypesManager.BIGDECIMAL){
										
    stringBuffer.append(TEXT_43);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_44);
    
										} else if(javaType == JavaTypesManager.BYTE_ARRAY){
										
    stringBuffer.append(TEXT_45);
    stringBuffer.append((customEncoding?encoding:"utf8Charset"));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_47);
    
										} else {
										
    stringBuffer.append(TEXT_43);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_48);
    				
										}
										
    stringBuffer.append(TEXT_49);
    
							if(!isPrimitive) {
							
    stringBuffer.append(TEXT_50);
    
							}
							if(i != sizeColumns - 1) {
							
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_35);
    
							}
						}
					}
					if(node.isVirtualGenerateNode()){
						String origin = ElementParameterParser.getValue(node, "__DESTINATION__");
						String con_name = org.talend.core.model.utils.NodeUtil.getPrivateConnClassName(conn);
						
    stringBuffer.append(TEXT_53);
    stringBuffer.append(con_name);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(origin);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_56);
    
					}
					
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_56);
    
					if(!compress) {
					
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    
					} else {
					
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(customEncoding?encoding:"");
    stringBuffer.append(TEXT_25);
    
					}
				}
				
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    
				log4jFileUtil.debugWriteData(node);
			}
		}
	}

    stringBuffer.append(TEXT_64);
    return stringBuffer.toString();
  }
}
