package org.talend.designer.codegen.translators.system;

import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.runprocess.ProcessorUtilities;
import org.talend.designer.runprocess.ProcessorException;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.IContextParameter;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.BlockCode;
import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class TRunJobMainJava
{
  protected static String nl;
  public static synchronized TRunJobMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRunJobMainJava result = new TRunJobMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tjava.util.List<String> paraList_";
  protected final String TEXT_2 = " = new java.util.ArrayList<String>();" + NL + "\t";
  protected final String TEXT_3 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_4 = ".";
  protected final String TEXT_5 = " = ";
  protected final String TEXT_6 = ";" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_7 = NL + "\t\tif(childJob_commandLine_Mapper_";
  protected final String TEXT_8 = ".get(";
  protected final String TEXT_9 = ")==null){" + NL + "\t\t\tthrow new RuntimeException(\"The child job named \"+";
  protected final String TEXT_10 = "+\" is not in the job list.\");" + NL + "\t\t}" + NL + "\t\tparaList_";
  protected final String TEXT_11 = ".addAll(childJob_commandLine_Mapper_";
  protected final String TEXT_12 = "));" + NL + "\t";
  protected final String TEXT_13 = NL + "\t        \t\t\tparaList_";
  protected final String TEXT_14 = ".add(";
  protected final String TEXT_15 = ");" + NL + "\t      \t\t\t";
  protected final String TEXT_16 = ".add(\"";
  protected final String TEXT_17 = "\");" + NL + "\t      \t\t\t";
  protected final String TEXT_18 = NL + "\t\t\tString osName_";
  protected final String TEXT_19 = " = System.getProperty(\"os.name\");" + NL + "\t\t\tif (osName_";
  protected final String TEXT_20 = " != null && osName_";
  protected final String TEXT_21 = ".toLowerCase().startsWith(\"win\")){" + NL + "\t      \t\t";
  protected final String TEXT_22 = NL + "\t\t      \t\t\tparaList_";
  protected final String TEXT_23 = "\");" + NL + "\t\t      \t\t";
  protected final String TEXT_24 = NL + "\t\t\t\t\t\t\t\tjvm_argument_helper_";
  protected final String TEXT_25 = ".addArgumentsTo(paraList_";
  protected final String TEXT_26 = ", dealChildJobLibrary_";
  protected final String TEXT_27 = ".replaceJarPathsFromCrcMap(";
  protected final String TEXT_28 = "));" + NL + "\t\t      \t\t\t\t";
  protected final String TEXT_29 = NL + "\t\t      \t\t\t\t\tjvm_argument_helper_";
  protected final String TEXT_30 = ", ";
  protected final String TEXT_31 = ");" + NL + "\t\t      \t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t        \t\t\t\tjvm_argument_helper_";
  protected final String TEXT_33 = ".replaceJarPathsFromCrcMap(\"";
  protected final String TEXT_34 = "\"));" + NL + "\t\t      \t\t\t\t";
  protected final String TEXT_35 = ", \"";
  protected final String TEXT_36 = "\");" + NL + "\t\t      \t\t\t\t";
  protected final String TEXT_37 = NL + "\t\t\t} else {" + NL + "\t      \t\t";
  protected final String TEXT_38 = NL + "\t\t\t\t\t\tparaList_";
  protected final String TEXT_39 = ").replace(\"$ROOT_PATH\",System.getProperty(\"user.dir\")));" + NL + "\t\t      \t\t\t\t";
  protected final String TEXT_40 = ".replace(\"$ROOT_PATH\",System.getProperty(\"user.dir\")));" + NL + "\t\t     \t \t\t\t";
  protected final String TEXT_41 = NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_42 = NL + "\t\t\tjvm_argument_helper_";
  protected final String TEXT_43 = ".reset();" + NL + "\t\t\t";
  protected final String TEXT_44 = NL + "\t\t\t" + NL + "\t  \t";
  protected final String TEXT_45 = NL + "\t\t\tif(!\"\".equals(log4jLevel)){" + NL + "\t\t\t\tparaList_";
  protected final String TEXT_46 = ".add(\"--log4jLevel=\"+log4jLevel);" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_47 = NL + "\t\tif(enableLogStash){" + NL + "\t\t\tparaList_";
  protected final String TEXT_48 = ".add(\"--monitoring=\"+enableLogStash);" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_49 = NL + "\t//for feature:10589" + NL + "\t";
  protected final String TEXT_50 = NL + "\t\tparaList_";
  protected final String TEXT_51 = ".add(\"--stat_port=\" + null);" + NL + "\t";
  protected final String TEXT_52 = ".add(\"--stat_port=\" + portStats);" + NL + "\t";
  protected final String TEXT_53 = NL + NL + "\tif(resuming_logs_dir_path != null){" + NL + "\t\tparaList_";
  protected final String TEXT_54 = ".add(\"--resuming_logs_dir_path=\" + resuming_logs_dir_path);" + NL + "\t}" + NL + "\tString childResumePath_";
  protected final String TEXT_55 = " = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);" + NL + "\tString tRunJobName_";
  protected final String TEXT_56 = " = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);" + NL + "\tif(\"";
  protected final String TEXT_57 = "\".equals(tRunJobName_";
  protected final String TEXT_58 = ") && childResumePath_";
  protected final String TEXT_59 = " != null){" + NL + "\t\tparaList_";
  protected final String TEXT_60 = ".add(\"--resuming_checkpoint_path=\" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));" + NL + "\t}" + NL + "\tparaList_";
  protected final String TEXT_61 = ".add(\"--parent_part_launcher=JOB:\" + jobName + \"/NODE:";
  protected final String TEXT_62 = "\");" + NL + "\t" + NL + "\tjava.util.Map<String, Object> parentContextMap_";
  protected final String TEXT_63 = " = new java.util.HashMap<String, Object>();" + NL + "" + NL + "\t";
  protected final String TEXT_64 = " " + NL + "\tjava.util.List<String> paraListForLog_";
  protected final String TEXT_65 = " = new java.util.ArrayList<String>();" + NL + "\tparaListForLog_";
  protected final String TEXT_66 = ".addAll(paraList_";
  protected final String TEXT_67 = ");" + NL + "\tList<String> parametersToEncrypt_";
  protected final String TEXT_68 = NL + "\t\t\tparametersToEncrypt_";
  protected final String TEXT_69 = " .add(\"";
  protected final String TEXT_70 = "\");" + NL + "\t\t\t";
  protected final String TEXT_71 = NL + "\t\t";
  protected final String TEXT_72 = ".synchronizeContext();";
  protected final String TEXT_73 = NL + "            class ContextProcessor_";
  protected final String TEXT_74 = " {" + NL + "                    private void transmitContext_0() {";
  protected final String TEXT_75 = NL + "                        }" + NL + "" + NL + "                        private void transmitContext_";
  protected final String TEXT_76 = "() {";
  protected final String TEXT_77 = NL + "                    parentContextMap_";
  protected final String TEXT_78 = ".put(\"";
  protected final String TEXT_79 = "\", ";
  protected final String TEXT_80 = ");" + NL + "                    paraList_";
  protected final String TEXT_81 = ".add(\"--context_type \" + \"";
  protected final String TEXT_82 = "\" + \"=\" + \"";
  protected final String TEXT_83 = "\");";
  protected final String TEXT_84 = NL + "                        }" + NL + "                    public void transmitAllContext() {";
  protected final String TEXT_85 = NL + "                        transmitContext_";
  protected final String TEXT_86 = "();";
  protected final String TEXT_87 = NL + "                    }" + NL + "            }" + NL + "            new ContextProcessor_";
  protected final String TEXT_88 = "().transmitAllContext();";
  protected final String TEXT_89 = NL + "\t\tjava.util.Enumeration<?> propertyNames_";
  protected final String TEXT_90 = ".propertyNames();" + NL + "\t\twhile (propertyNames_";
  protected final String TEXT_91 = ".hasMoreElements()) {" + NL + "\t\t\tString key_";
  protected final String TEXT_92 = " = (String) propertyNames_";
  protected final String TEXT_93 = ".nextElement();" + NL + "\t\t\tObject value_";
  protected final String TEXT_94 = " = (Object) ";
  protected final String TEXT_95 = ".get(key_";
  protected final String TEXT_96 = ");" + NL + "\t\t\tif(value_";
  protected final String TEXT_97 = "!=null) {  " + NL + "\t\t\t\tparaList_";
  protected final String TEXT_98 = ".add(\"--context_param \" + key_";
  protected final String TEXT_99 = " + \"=\" + value_";
  protected final String TEXT_100 = ");" + NL + "\t\t\t} else {" + NL + "\t\t\t\tparaList_";
  protected final String TEXT_101 = " + \"=\" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_102 = NL + "\t\t\tif(parametersToEncrypt_";
  protected final String TEXT_103 = " .contains(key_";
  protected final String TEXT_104 = ") && value_";
  protected final String TEXT_105 = " != null) {" + NL + "\t\t\t\tparaListForLog_";
  protected final String TEXT_106 = " + \"=\" + routines.system.PasswordEncryptUtil.encryptPassword(String.valueOf(value_";
  protected final String TEXT_107 = ")));" + NL + "\t\t\t} else {" + NL + "\t\t\t\tparaListForLog_";
  protected final String TEXT_108 = ");" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_109 = NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_110 = NL + NL + "\tObject obj_";
  protected final String TEXT_111 = " = null;" + NL + "" + NL + "\t";
  protected final String TEXT_112 = NL + "\t\tobj_";
  protected final String TEXT_113 = ";" + NL + "\t\tif(obj_";
  protected final String TEXT_114 = "!=null) {" + NL + "\t\t\tparaList_";
  protected final String TEXT_115 = ".add(\"--context_param ";
  protected final String TEXT_116 = "=\" + RuntimeUtils.tRunJobConvertContext(obj_";
  protected final String TEXT_117 = "));" + NL + "\t\t} else {" + NL + "\t\t\tparaList_";
  protected final String TEXT_118 = "=\" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_119 = NL + "\t\tif(parametersToEncrypt_";
  protected final String TEXT_120 = " .contains(\"";
  protected final String TEXT_121 = "\") && obj_";
  protected final String TEXT_122 = " != null) {" + NL + "\t\t\tparaListForLog_";
  protected final String TEXT_123 = "=\" + routines.system.PasswordEncryptUtil.encryptPassword(String.valueOf(RuntimeUtils.tRunJobConvertContext(obj_";
  protected final String TEXT_124 = "))));" + NL + "\t\t} else {" + NL + "\t\t\tparaListForLog_";
  protected final String TEXT_125 = "));" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_126 = NL + "\t\tparentContextMap_";
  protected final String TEXT_127 = "\", obj_";
  protected final String TEXT_128 = ");" + NL + "\t";
  protected final String TEXT_129 = NL + "\t";
  protected final String TEXT_130 = NL + "\t\tSystem.out.println(\"";
  protected final String TEXT_131 = " in ";
  protected final String TEXT_132 = " call ";
  protected final String TEXT_133 = "\"+";
  protected final String TEXT_134 = "+\"";
  protected final String TEXT_135 = " with:\\n\\n\" + paraListForLog_";
  protected final String TEXT_136 = " + \"\\n\");" + NL + "\t";
  protected final String TEXT_137 = " childJob_";
  protected final String TEXT_138 = " = new ";
  protected final String TEXT_139 = NL + "        if (childJob_";
  protected final String TEXT_140 = " instanceof routines.system.api.TalendESBJob) {" + NL + "            ((routines.system.api.TalendESBJob)childJob_";
  protected final String TEXT_141 = ").setEndpointRegistry(registry);" + NL + "        }" + NL;
  protected final String TEXT_142 = NL + "\t    // pass DataSources" + NL + "\t    java.util.Map<String, routines.system.TalendDataSource> talendDataSources_";
  protected final String TEXT_143 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap" + NL + "\t            .get(KEY_DB_DATASOURCES);" + NL + "\t    if (null != talendDataSources_";
  protected final String TEXT_144 = ") {" + NL + "\t        java.util.Map<String, javax.sql.DataSource> dataSources_";
  protected final String TEXT_145 = " = new java.util.HashMap<String, javax.sql.DataSource>();" + NL + "\t        for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry_";
  protected final String TEXT_146 = " : talendDataSources_";
  protected final String TEXT_147 = NL + "\t\t\t        .entrySet()) {" + NL + "\t            dataSources_";
  protected final String TEXT_148 = ".put(talendDataSourceEntry_";
  protected final String TEXT_149 = ".getKey()," + NL + "\t                    talendDataSourceEntry_";
  protected final String TEXT_150 = ".getValue().getRawDataSource());" + NL + "\t        }" + NL + "\t        childJob_";
  protected final String TEXT_151 = ".setDataSources(dataSources_";
  protected final String TEXT_152 = ");" + NL + "\t    }" + NL + "\t\t";
  protected final String TEXT_153 = "  " + NL + "\t\t\tchildJob_";
  protected final String TEXT_154 = ".parentContextMap = parentContextMap_";
  protected final String TEXT_155 = ";" + NL + "\t\t";
  protected final String TEXT_156 = "  " + NL + "\t\t";
  protected final String TEXT_157 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_158 = " - The child job '";
  protected final String TEXT_159 = "' starts on the version '";
  protected final String TEXT_160 = "' with the context '";
  protected final String TEXT_161 = "'.\");" + NL + "\t\t";
  protected final String TEXT_162 = NL + "\t\tString[][] childReturn_";
  protected final String TEXT_163 = " = childJob_";
  protected final String TEXT_164 = ".runJob((String[]) paraList_";
  protected final String TEXT_165 = ".toArray(new String[paraList_";
  protected final String TEXT_166 = ".size()]));" + NL + "\t\t";
  protected final String TEXT_167 = "' is done.\");" + NL + "\t\t";
  protected final String TEXT_168 = NL + "            if(childJob_";
  protected final String TEXT_169 = ".getErrorCode() == null){" + NL + "                globalMap.put(\"";
  protected final String TEXT_170 = "_CHILD_RETURN_CODE\", childJob_";
  protected final String TEXT_171 = ".getStatus() != null && (\"failure\").equals(childJob_";
  protected final String TEXT_172 = ".getStatus()) ? 1 : 0);" + NL + "            }else{" + NL + "                globalMap.put(\"";
  protected final String TEXT_173 = ".getErrorCode());" + NL + "            }" + NL + "            if (childJob_";
  protected final String TEXT_174 = ".getExceptionStackTrace() != null) {" + NL + "                globalMap.put(\"";
  protected final String TEXT_175 = "_CHILD_EXCEPTION_STACKTRACE\", childJob_";
  protected final String TEXT_176 = ".getExceptionStackTrace());" + NL + "            }";
  protected final String TEXT_177 = NL + "                    ((java.util.Map)threadLocal.get()).put(\"errorCode\", childJob_";
  protected final String TEXT_178 = ".getErrorCode());";
  protected final String TEXT_179 = NL + "                    errorCode = childJob_";
  protected final String TEXT_180 = ".getErrorCode();";
  protected final String TEXT_181 = NL + "                if (childJob_";
  protected final String TEXT_182 = ".getErrorCode() != null || (\"failure\").equals(childJob_";
  protected final String TEXT_183 = ".getStatus())) {" + NL + "                    java.lang.Exception ce_";
  protected final String TEXT_184 = ".getException();" + NL + "                    throw new RuntimeException(\"Child job running failed.\\n\" + ((ce_";
  protected final String TEXT_185 = "!=null) ? (ce_";
  protected final String TEXT_186 = ".getClass().getName() + \": \" + ce_";
  protected final String TEXT_187 = ".getMessage()) : \"\"));" + NL + "                }";
  protected final String TEXT_188 = NL + "\t\t\tfor (String[] item_";
  protected final String TEXT_189 = " : childReturn_";
  protected final String TEXT_190 = ") { " + NL + "\t\t\t\tif(childJob_";
  protected final String TEXT_191 = ".hastBufferOutputComponent() || ";
  protected final String TEXT_192 = "){" + NL + "\t\t\t    \t";
  protected final String TEXT_193 = "\t\t" + NL + "\t\t\t\t\t\tif(";
  protected final String TEXT_194 = " < item_";
  protected final String TEXT_195 = ".length){\t\t\t\t" + NL + "\t\t\t           \t\t";
  protected final String TEXT_196 = NL + "\t\t\t\t           \t\t";
  protected final String TEXT_197 = " = item_";
  protected final String TEXT_198 = "[";
  protected final String TEXT_199 = "];" + NL + "\t\t\t           \t\t";
  protected final String TEXT_200 = " = ParserUtils.parseTo_Date(item_";
  protected final String TEXT_201 = "], ";
  protected final String TEXT_202 = ");" + NL + "\t\t\t           \t\t";
  protected final String TEXT_203 = "\t\t\t\t\t\t\t" + NL + "\t\t\t           \t\t\t";
  protected final String TEXT_204 = "].getBytes();" + NL + "\t\t\t           \t\t";
  protected final String TEXT_205 = NL + "\t\t\t           \t\t\t";
  protected final String TEXT_206 = " = ParserUtils.parseTo_";
  protected final String TEXT_207 = "(item_";
  protected final String TEXT_208 = "], \",\");" + NL + "\t\t\t           \t\t";
  protected final String TEXT_209 = "]);" + NL + "\t\t\t           \t\t";
  protected final String TEXT_210 = NL + "\t\t           \t\t}else{" + NL + "\t\t\t           \t\t";
  protected final String TEXT_211 = ";" + NL + "\t\t           \t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_212 = NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_213 = NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_214 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_215 = NL + "\t\t\t\t}" + NL + "\t\t";
  protected final String TEXT_216 = NL + "\t\t\t\tclass ConsoleHelper_";
  protected final String TEXT_217 = " {" + NL + "\t\t\t\t\tprivate Thread getNormalThread(Process process) {" + NL + "\t\t\t\t\t\treturn new Thread() {" + NL + "\t\t\t\t\t\t\tpublic void run() {" + NL + "\t\t\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t\t\tjava.io.BufferedReader reader = new java.io.BufferedReader(" + NL + "\t\t\t\t\t\t\t\t\t\t\tnew java.io.InputStreamReader(" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tprocess.getInputStream()));" + NL + "\t\t\t\t\t\t\t\t\tString line = \"\";" + NL + "\t\t\t\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t\t\t\twhile ((line = reader.readLine()) != null) {" + NL + "\t\t\t\t\t\t\t\t\t\t\tSystem.out.println(line);" + NL + "\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t} finally {" + NL + "\t\t\t\t\t\t\t\t\t\treader.close();" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t} catch (java.io.IOException ioe) {" + NL + "\t\t\t\t\t\t            ";
  protected final String TEXT_218 = NL + "\t\t\t\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_219 = " - \" + ioe.getMessage());" + NL + "\t\t\t\t\t\t            ";
  protected final String TEXT_220 = NL + "\t\t\t\t\t\t\t\t\tioe.printStackTrace();" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t};" + NL + "\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\tprivate Thread getErrorThread(Process process, StringBuffer sb) {" + NL + "\t\t\t\t\t\treturn new Thread() {" + NL + "\t\t\t\t\t\t\tpublic void run() {" + NL + "\t\t\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t\t\tjava.io.BufferedReader reader = new java.io.BufferedReader(" + NL + "\t\t\t\t\t\t\t\t\t\t\tnew java.io.InputStreamReader(" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tprocess.getErrorStream()));" + NL + "\t\t\t\t\t\t\t\t\tString line = \"\";" + NL + "\t\t\t\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t\t\t\twhile ((line = reader.readLine()) != null) {" + NL + "\t\t\t\t\t\t\t\t\t\t\tsb.append(line)" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t.append(\"\\n\");" + NL + "\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t} finally {" + NL + "\t\t\t\t\t\t\t\t\t\treader.close();" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t} catch (java.io.IOException ioe) {" + NL + "\t\t\t\t\t\t            ";
  protected final String TEXT_221 = NL + "\t\t\t\t\t\t\t\t\tioe.printStackTrace();" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t};" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\tConsoleHelper_";
  protected final String TEXT_222 = " consoleHelper_";
  protected final String TEXT_223 = " = new ConsoleHelper_";
  protected final String TEXT_224 = "();" + NL + "" + NL + "\t\tRuntime runtime_";
  protected final String TEXT_225 = " = Runtime.getRuntime();" + NL + "\t\tProcess ps_";
  protected final String TEXT_226 = " = null;" + NL + "" + NL + "\t\t//0 indicates normal termination" + NL + "        int result_";
  protected final String TEXT_227 = ";" + NL + "        StringBuffer errorMsg_";
  protected final String TEXT_228 = " = new StringBuffer();" + NL + "        try {" + NL + "            ps_";
  protected final String TEXT_229 = " = runtime_";
  protected final String TEXT_230 = ".exec((String[])paraList_";
  protected final String TEXT_231 = ".size()]));" + NL + "" + NL + "            Thread normal_";
  protected final String TEXT_232 = " = consoleHelper_";
  protected final String TEXT_233 = ".getNormalThread(ps_";
  protected final String TEXT_234 = ");";
  protected final String TEXT_235 = NL + "                log.info(\"";
  protected final String TEXT_236 = "'.\");";
  protected final String TEXT_237 = NL + "            normal_";
  protected final String TEXT_238 = ".start();";
  protected final String TEXT_239 = "' is done.\");";
  protected final String TEXT_240 = NL + NL + "            Thread error_";
  protected final String TEXT_241 = ".getErrorThread(ps_";
  protected final String TEXT_242 = ", errorMsg_";
  protected final String TEXT_243 = ");" + NL + "            error_";
  protected final String TEXT_244 = ".start();" + NL + "" + NL + "            result_";
  protected final String TEXT_245 = " = ps_";
  protected final String TEXT_246 = ".waitFor();" + NL + "            normal_";
  protected final String TEXT_247 = ".join(10000);" + NL + "            error_";
  protected final String TEXT_248 = ".join(10000);" + NL + "        } catch (ThreadDeath tde) {";
  protected final String TEXT_249 = NL + "            \tlog.error(\"";
  protected final String TEXT_250 = " - thread was terminated.\");";
  protected final String TEXT_251 = NL + "            ps_";
  protected final String TEXT_252 = ".destroy();" + NL + "            throw tde;" + NL + "        }" + NL + "" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_253 = "_CHILD_RETURN_CODE\",result_";
  protected final String TEXT_254 = ");" + NL + "\t\tif(result_";
  protected final String TEXT_255 = " != 0){" + NL + "   \t\t\tglobalMap.put(\"";
  protected final String TEXT_256 = "_CHILD_EXCEPTION_STACKTRACE\",errorMsg_";
  protected final String TEXT_257 = ".toString());" + NL + "\t\t\t";
  protected final String TEXT_258 = "  " + NL + "\t    \t\tthrow new RuntimeException(\"Child job returns \" + result_";
  protected final String TEXT_259 = " + \". It doesn't terminate normally.\\n\" + errorMsg_";
  protected final String TEXT_260 = NL + "\t\t\t\t";
  protected final String TEXT_261 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_262 = " - Child job returns \" + result_";
  protected final String TEXT_263 = ".toString());" + NL + "\t\t\t\t";
  protected final String TEXT_264 = NL + "\t\t\t\tSystem.err.println(\"Child job returns \" + result_";
  protected final String TEXT_265 = NL + "  \t\t}" + NL + "" + NL + "\t\t";
  protected final String TEXT_266 = NL + "  \t\t\t\tSystem.err.println(\"when tRunJob runs in an independent process, it can't extract datas from tBufferOutput of child job.\"); " + NL + "\t\t\t";
  protected final String TEXT_267 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<IMetadataColumn> columns = null;
List<IMetadataTable> metadatas = node.getMetadataList();
if (metadatas != null && metadatas.size() > 0) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata != null) {
        columns = metadata.getListColumns();
    }
}
List< ? extends IConnection> outConns = node.getOutgoingSortedConnections();
  
//if tRunJob is the first node, it can get the return values of the child job.
//if tRunJob is middle node of the FLOW link, it will be data_auto_propagate=true 
List< ? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
boolean useIndependentProcess = "true".equals(ElementParameterParser.getValue(node, "__USE_INDEPENDENT_PROCESS__"));
boolean dieOnError = ("true").equals(ElementParameterParser.getValue(node, "__DIE_ON_CHILD_ERROR__"));  
boolean isRunInMultiThread = codeGenArgument.getIsRunInMultiThread();  
boolean transmitWholeContext = ("true").equals(ElementParameterParser.getValue(node, "__TRANSMIT_WHOLE_CONTEXT__"));  
boolean printParameter = ("true").equals(ElementParameterParser.getValue(node, "__PRINT_PARAMETER__")); 

boolean originalContext = ("true").equals(ElementParameterParser.getValue(node, "__TRANSMIT_ORIGINAL_CONTEXT__")); 

IProcess currentProcess = node.getProcess();
List<Map<String, String>> contextParams = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__CONTEXTPARAMS__");
String process = ElementParameterParser.getValue(node,"__PROCESS_TYPE_PROCESS__");
String context = ElementParameterParser.getValue(node,"__PROCESS_TYPE_CONTEXT__");
String version = ElementParameterParser.getValue(node,"__PROCESS_TYPE_VERSION__");
String[] codeOptions = new String[] {"\"--father_pid=\"+pid", "\"--root_pid=\"+rootPid", "\"--father_node="+ cid + "\""};
String[] commandLineWindows = new String[] {"<command>"};
String[] commandLineUnix = new String[] {"<command>"};
String[] commandLine = new String[] {"<command>"};
String childJob = ElementParameterParser.getValue(node,"__PROCESS__");

boolean isPropagateChildResult = ("true").equals(ElementParameterParser.getValue(node, "__PROPAGATE_CHILD_RESULT__"));

boolean useDynamicJob = ("true").equals(ElementParameterParser.getValue(node, "__USE_DYNAMIC_JOB__"));
String dynamicJobName = ElementParameterParser.getValue(node,"__CONTEXT_JOB__");
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
boolean propagateData = false;
Set<String> inputCols = new HashSet<String>();
String inputConnName = null;

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    
	//For TDI-28558

	List<IMetadataColumn> inputMetadataColumn = new java.util.ArrayList<IMetadataColumn>();
	List<IMetadataColumn> outputMetadataColumn = new java.util.ArrayList<IMetadataColumn>();
	if (node.getIncomingConnections()!=null) {
		for (IConnection incomingConn : node.getIncomingConnections()) {
			if (incomingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				inputConnName = incomingConn.getName();
				IMetadataTable inputMetadataTable = incomingConn.getMetadataTable();
				for (IMetadataColumn inputCol : inputMetadataTable.getListColumns()) {
					inputMetadataColumn.add(inputCol);
					inputCols.add(inputCol.getLabel());
				}
				break;
			}
		}
	}
	if(node.getOutgoingConnections()!=null) {
		for (IConnection outputConn : node.getOutgoingConnections()) {
			if (outputConn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)) {
				IMetadataTable outputMetadataTable = outputConn.getMetadataTable();
				for (IMetadataColumn outputCol : outputMetadataTable.getListColumns()) {
					outputMetadataColumn.add(outputCol);
				}
			}
		}
	}
	if(inputMetadataColumn!=null && outputMetadataColumn!=null){
		if(inputMetadataColumn.size() == outputMetadataColumn.size()){
			int size = inputMetadataColumn.size();
			for(int i = 0;i< size; i++){
				if(!inputMetadataColumn.get(i).getLabel().equals(outputMetadataColumn.get(i).getLabel()) ||
				   !inputMetadataColumn.get(i).getTalendType().equals(outputMetadataColumn.get(i).getTalendType())){
					propagateData = false;
					break;
				}else{
					propagateData = true;
				}
			}
		}
	}
	if(useDynamicJob || useIndependentProcess || !isPropagateChildResult){
		if (propagateData) {
			for (IConnection conn : node.getOutgoingConnections()) {
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)) {
					IMetadataTable outputMetadataTable = conn.getMetadataTable();
					if (outputMetadataTable!=null) {
						for (IMetadataColumn outputCol : outputMetadataTable.getListColumns()) { 
							if (inputCols.contains(outputCol.getLabel())) {
							
    stringBuffer.append(TEXT_3);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(inputConnName );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_6);
    
							}
						}
					}
					break;
				}
			}
		}
	}
	
	if(useDynamicJob){
		useIndependentProcess = true;
		
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_12);
    
	}else{
		boolean use_custom_jvm_setting = "true".equals(ElementParameterParser.getValue(node, "__USE_CUSTOM_JVM_SETTING__"));
		try {
			if(useIndependentProcess){
		    	commandLineWindows = ProcessorUtilities.getCommandLine("win32", false, true, process, context,org.talend.designer.runprocess.IProcessor.NO_STATISTICS,org.talend.designer.runprocess.IProcessor.NO_TRACES, use_custom_jvm_setting, codeOptions);
		    	// remove the 2 fist lines
		    	if (commandLineWindows.length > 0 && ProcessorUtilities.isExportConfig()){
		    		int tmpSize = commandLineWindows.length - 2;
		    		String[] tmp = new String[tmpSize];
		    		System.arraycopy(commandLineWindows, 2, tmp, 0, tmpSize);
		    		commandLineWindows = tmp;
	    		}
		    	commandLineUnix = ProcessorUtilities.getCommandLine("linux", false, true, process, context,org.talend.designer.runprocess.IProcessor.NO_STATISTICS,org.talend.designer.runprocess.IProcessor.NO_TRACES, use_custom_jvm_setting, codeOptions);
	    		// remove the 2 first lines
				if (commandLineUnix.length > 0 && ProcessorUtilities.isExportConfig()){
					int tmpSize = commandLineUnix.length - 2;
					String[] tmp = new String[tmpSize];
					System.arraycopy(commandLineUnix, 2, tmp, 0, tmpSize);
					commandLineUnix = tmp;
				}
			}else{
		    	commandLine = ProcessorUtilities.getMainCommand(process,version, context,org.talend.designer.runprocess.IProcessor.NO_STATISTICS,org.talend.designer.runprocess.IProcessor.NO_TRACES, codeOptions);  
			}
		} catch (ProcessorException e) {
		}


		if (!useIndependentProcess) {
			for (int i = 0; i < commandLine.length; i++) {
				if (i == 0){
					childJob = commandLine[0];
				} else if (i > 0){
					if (commandLine[i].indexOf("\"") >= 0){
	      			
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(commandLine[i] );
    stringBuffer.append(TEXT_15);
    }else{
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(commandLine[i] );
    stringBuffer.append(TEXT_17);
    }
	    		}
	  		}
		} else {
	  	
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    
				for (int i = 0; i < commandLineWindows.length; i++) {
					if (i == 0){
		     	 	
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(commandLineWindows[i]);
    stringBuffer.append(TEXT_23);
    
					} else if (i > 0){
		      			if (commandLineWindows[i].indexOf("\"") >= 0){
							if(commandLineWindows[i].indexOf(".jar")>=0){
		      				
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(commandLineWindows[i] );
    stringBuffer.append(TEXT_28);
    
							}else{
		      				
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(commandLineWindows[i] );
    stringBuffer.append(TEXT_31);
    
		          			}
		      			}else{
		          			if(commandLineWindows[i].indexOf(".jar")>=0){
              				
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(commandLineWindows[i] );
    stringBuffer.append(TEXT_34);
    
		          			}else{
              				
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(commandLineWindows[i] );
    stringBuffer.append(TEXT_36);
    
		          			}
		      			}	
		    		}
		  		}
		  		
    stringBuffer.append(TEXT_37);
    
				for (int i = 0; i < commandLineUnix.length; i++) {
					if (i == 0){
		      		
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(commandLineUnix[i]);
    stringBuffer.append(TEXT_23);
    
		    		} else if (i > 0){
		      			String param;
						if (commandLineUnix[i].indexOf("\"") >= 0){
							param = commandLineUnix[i];
						} else {
							param = "\""+commandLineUnix[i]+"\"";
						}
						if (param.contains("$ROOT_PATH")) {
							if(param.indexOf(".jar") >= 0){
		      				
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(param );
    stringBuffer.append(TEXT_39);
    }else{
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(param );
    stringBuffer.append(TEXT_40);
    
		      				}
		      			}else{
							if(param.indexOf(".jar") >= 0){
		      				
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(param );
    stringBuffer.append(TEXT_39);
    }else{
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(param );
    stringBuffer.append(TEXT_31);
    
		      				}
		      			}	
	    			}
		  		}
		  		
    stringBuffer.append(TEXT_41);
    
			if(use_custom_jvm_setting) {
			
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    }
    stringBuffer.append(TEXT_44);
    
		}
		if(isLog4jEnabled){//For TDI-27659
		
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    
		}
		
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    
	}
	
    stringBuffer.append(TEXT_49);
    if(useIndependentProcess){
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    }else{
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    }
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    
	Set<IConnection> iterateConnSet =  new HashSet<IConnection>();
	List<? extends IConnection> iterateConns = node.getIncomingConnections(EConnectionType.ITERATE);
	if(iterateConns != null)  { 
		iterateConnSet.addAll(iterateConns);
	}
	boolean parallelIterate = false;
	for (IConnection iterateConn : iterateConnSet) {
		parallelIterate = "true".equals(ElementParameterParser.getValue(iterateConn, "__ENABLE_PARALLEL__"));
	}
	if(printParameter) {
	
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    
		List<IContextParameter> params = currentProcess.getContextManager().getDefaultContext().getContextParameterList();
		for (IContextParameter ctxParam :params){
			if("id_Password".equals(ctxParam.getType())) {
			
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(ctxParam.getName() );
    stringBuffer.append(TEXT_70);
    
			}
		}
	}
	if(transmitWholeContext){//111111
	
    stringBuffer.append(TEXT_71);
     
		//bug21906
		String localContext = "context";
		if(parallelIterate) {
			localContext = "localContext";
		}
		
    stringBuffer.append(TEXT_71);
    stringBuffer.append(localContext);
    stringBuffer.append(TEXT_72);
    
		List<IContextParameter> params = currentProcess.getContextManager().getDefaultContext().getContextParameterList();
        /*Create local class to avoid 64kB method problem when huge amount of context variables declared*/
        if (!params.isEmpty()) {
            final int defaultInnerMethodLenght = 500;
            int lastMethodNumber = 0;

    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    
                for (int i = 1; i <= params.size(); i++) {
                    IContextParameter ctxParam = params.get(i-1);
                    String ctxParamName = ctxParam.getName();
                    String ctxParameterType = ctxParam.getType();
                    if (i % defaultInnerMethodLenght == 0) {
                    /* close previous method and declare new */
                        lastMethodNumber++;

    stringBuffer.append(TEXT_75);
    stringBuffer.append(lastMethodNumber);
    stringBuffer.append(TEXT_76);
    
                    } //endIf

    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(ctxParamName );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(localContext);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(ctxParamName );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(ctxParamName);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(ctxParam.getType());
    stringBuffer.append(TEXT_83);
    
                } //endFor

    /*close last method*/
    stringBuffer.append(TEXT_84);
    
                    for (int i = 0; i <=lastMethodNumber; i++) {

    stringBuffer.append(TEXT_85);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_86);
    
                    }

    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    
        }

    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(localContext);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(localContext);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    
			if(printParameter) {
			
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    
			}
			
    stringBuffer.append(TEXT_109);
    
	}//111111
	
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    
	for (int i=0; i<contextParams.size(); i++) {
		Map<String, String> contextParam = contextParams.get(i);
		String name = contextParam.get("PARAM_NAME_COLUMN");
		String value = contextParam.get("PARAM_VALUE_COLUMN");
		//bug22181
		if(parallelIterate && value!=null && value.contains("context.")) {
			value = value.replace("context.","localContext.");
		}
		
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(value );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(name );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(name );
    stringBuffer.append(TEXT_118);
     if(printParameter){ 
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(name );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(name );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(name );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
     } 
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(name );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    
	}
	
    stringBuffer.append(TEXT_129);
    if(printParameter){
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(currentProcess.getName() );
    stringBuffer.append(TEXT_132);
    if(!useDynamicJob){
    stringBuffer.append(childJob );
    }else{
    stringBuffer.append(TEXT_133);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_134);
    }
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
	if (!useIndependentProcess){//AAAAAAAAAAAA
	
    stringBuffer.append(TEXT_71);
    stringBuffer.append(childJob );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(childJob );
    stringBuffer.append(TEXT_86);
    
            if (ProcessorUtilities.isEsbJob(currentProcess)) {
        
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    
            }
        
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    if(originalContext){
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    }
    stringBuffer.append(TEXT_156);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    if(!useDynamicJob){
    stringBuffer.append(childJob );
    }else{
    stringBuffer.append(TEXT_133);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_134);
    }
    stringBuffer.append(TEXT_159);
    stringBuffer.append(version);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(context);
    stringBuffer.append(TEXT_161);
    }
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    if(!useDynamicJob){
    stringBuffer.append(childJob );
    }else{
    stringBuffer.append(TEXT_133);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_134);
    }
    stringBuffer.append(TEXT_167);
    }
    
		if (childJob != null) {

    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    
            if (dieOnError) {
                if (isRunInMultiThread){

    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    
                }else {

    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    
                }

    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    
            }
        }

		String firstConnName = null; 
		if(outConns != null && outConns.size() > 0) {
			for (IConnection conn : outConns) {
				if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)){
	      			firstConnName = conn.getName(); //get the first available flow link
	      			break;
	      		}
	    	}
		}
		boolean inConnNull = false;
		if(inConns == null || inConns.size() == 0) {
			inConnNull = true; 
		}
		if(firstConnName != null && (isPropagateChildResult || inConnNull)) {//b
			List<BlockCode> blockCodes = new java.util.ArrayList<BlockCode>(1);
			blockCodes.add(new BlockCode("C_01"));
			((org.talend.core.model.process.AbstractNode) node).setBlocksCodeToClose(blockCodes);
	    	
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(inConnNull);
    stringBuffer.append(TEXT_192);
    
					int columnSize = columns.size();
					for (int i = 0; i < columnSize; i++) {//a
						IMetadataColumn column = columns.get(i);
						String label = column.getLabel();
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
			        	
    stringBuffer.append(TEXT_193);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
    stringBuffer.append(TEXT_196);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_199);
    } else if(javaType == JavaTypesManager.DATE) {
    stringBuffer.append(TEXT_196);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_201);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_202);
    } else if(javaType == JavaTypesManager.BYTE_ARRAY){
    stringBuffer.append(TEXT_203);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_204);
    }else if(javaType == JavaTypesManager.LIST) {
    stringBuffer.append(TEXT_205);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_206);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_208);
    } else {
    stringBuffer.append(TEXT_205);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_206);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_209);
    }
    stringBuffer.append(TEXT_210);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_211);
    
					}//a
					if (inConnNull==false && propagateData) {//d
					
    stringBuffer.append(TEXT_212);
    
						for (IConnection conn : node.getOutgoingConnections()) {
							if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)) {
								IMetadataTable outputMetadataTable = conn.getMetadataTable();
								if (outputMetadataTable!=null) {
									for (IMetadataColumn outputCol : outputMetadataTable.getListColumns()) { 
										if (inputCols.contains(outputCol.getLabel())) {
										
    stringBuffer.append(TEXT_213);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(inputConnName );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_214);
    
										}
									}
								}
								break;
							}
						}
					}//d
					
    stringBuffer.append(TEXT_215);
    
		}//b  
	} else { //AAAAAAAAAAAA

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
	// use independent process to run subjob
	
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_217);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_219);
    }
    stringBuffer.append(TEXT_220);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_219);
    }
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    if(!useDynamicJob){
    stringBuffer.append(childJob );
    }else{
    stringBuffer.append(TEXT_133);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_134);
    }
    stringBuffer.append(TEXT_159);
    stringBuffer.append(version);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(context);
    stringBuffer.append(TEXT_236);
    }
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    if(!useDynamicJob){
    stringBuffer.append(childJob );
    }else{
    stringBuffer.append(TEXT_133);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_134);
    }
    stringBuffer.append(TEXT_239);
    }
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_248);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_250);
    }
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_257);
    if (dieOnError) { 
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_257);
    }else{
    stringBuffer.append(TEXT_260);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_263);
    }
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_257);
    }
    stringBuffer.append(TEXT_265);
    
		String firstConnName = null; 
		if(outConns != null && outConns.size() > 0) {
			for (IConnection conn : outConns) {
				if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
					firstConnName = conn.getName(); //get the first available flow link
					break;
				}
			}
		}
		if(firstConnName != null) {//b
	    	if(inConns == null || inConns.size() == 0){//c
			
    stringBuffer.append(TEXT_260);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_263);
    }
    stringBuffer.append(TEXT_266);
    
			}//c
		}//b  
	}//AAAAAAAAAAAA
	
    stringBuffer.append(TEXT_267);
    return stringBuffer.toString();
  }
}
