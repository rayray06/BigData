package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TFileInputExcelBeginJava
{
  protected static String nl;
  public static synchronized TFileInputExcelBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputExcelBeginJava result = new TFileInputExcelBeginJava();
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
  protected final String TEXT_18 = NL;
  protected final String TEXT_19 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_20 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_21 = ");";
  protected final String TEXT_22 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_23 = " = ";
  protected final String TEXT_24 = "; ";
  protected final String TEXT_25 = NL + "        String password_";
  protected final String TEXT_26 = " = decryptedPassword_";
  protected final String TEXT_27 = ";" + NL + "        if (password_";
  protected final String TEXT_28 = ".isEmpty()){" + NL + "            password_";
  protected final String TEXT_29 = " = null;" + NL + "        }";
  protected final String TEXT_30 = NL + "\t\t\t\t\tint dynamic_column_count_";
  protected final String TEXT_31 = "=1;" + NL + "\t\t\t\t\tif(isFirstCheckDyn_";
  protected final String TEXT_32 = "){// for the header line" + NL + "\t\t\t\t\t\tif(row_";
  protected final String TEXT_33 = "==null " + NL + "\t\t\t\t\t\t";
  protected final String TEXT_34 = NL + "\t\t\t\t\t\t\t|| row_";
  protected final String TEXT_35 = ".length == 0" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_36 = ".getLastCellNum() == 0" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_37 = ".size() == 0" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_38 = "){" + NL + "\t\t\t\t\t\t\t\tcontinue;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t\t\t\t\tint colsLen_";
  protected final String TEXT_40 = " = row_";
  protected final String TEXT_41 = ".length-start_column_";
  protected final String TEXT_42 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_43 = NL + "\t\t    \t\t\t\tint colsLen_";
  protected final String TEXT_44 = " =  row_";
  protected final String TEXT_45 = ".getLastCellNum()-start_column_";
  protected final String TEXT_46 = ";" + NL + "\t\t    \t\t\t";
  protected final String TEXT_47 = ".size()-start_column_";
  protected final String TEXT_48 = NL + "\t\t    \t\t\tdynamic_column_count_";
  protected final String TEXT_49 = " = colsLen_";
  protected final String TEXT_50 = "-";
  protected final String TEXT_51 = ";" + NL + "\t\t    \t\t\tfor (int i = ";
  protected final String TEXT_52 = "; i < colsLen_";
  protected final String TEXT_53 = "; i++) {" + NL + "\t\t\t\t\t    \troutines.system.DynamicMetadata dynamicMetadata_";
  protected final String TEXT_54 = " = new routines.system.DynamicMetadata();" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_55 = NL + "\t\t\t\t\t\t\t\tString content_";
  protected final String TEXT_56 = "[i].getContents();" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\t    \t\t\t\tString content_";
  protected final String TEXT_58 = ".getCell(i)==null?null:row_";
  protected final String TEXT_59 = ".getCell(i).toString();" + NL + "\t\t\t    \t\t\t";
  protected final String TEXT_60 = ".get(i);" + NL + "\t\t\t    \t\t\t";
  protected final String TEXT_61 = NL + "\t\t\t    \t\t\tif(content_";
  protected final String TEXT_62 = "!=null){" + NL + "\t\t\t\t\t    \t\tdynamicMetadata_";
  protected final String TEXT_63 = ".setName(content_";
  protected final String TEXT_64 = ".replaceAll(\"[ .-]+\", \"_\"));" + NL + "\t\t\t\t\t    \t}" + NL + "\t\t\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_65 = ".setDbName(dynamicMetadata_";
  protected final String TEXT_66 = ".getName());" + NL + "\t\t\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_67 = ".setType(\"id_String\");" + NL + "\t\t\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_68 = ".setDbType(\"VARCHAR\");" + NL + "\t\t\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_69 = ".setLength(100);" + NL + "\t\t\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_70 = ".setPrecision(0);" + NL + "\t\t\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_71 = ".setNullable(true);" + NL + "\t\t\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_72 = ".setKey(false);" + NL + "\t\t\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_73 = ".setSourceType(routines.system.DynamicMetadata.sourceTypes.excelFile);" + NL + "\t\t\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_74 = ".setColumnPosition(i);" + NL + "\t\t\t\t\t    \tdynamic_";
  protected final String TEXT_75 = ".metadatas.add(dynamicMetadata_";
  protected final String TEXT_76 = ");" + NL + "\t\t\t\t\t    }" + NL + "\t\t    \t\t\tisFirstCheckDyn_";
  protected final String TEXT_77 = " = false;" + NL + "\t\t    \t\t\t" + NL + "\t\t    \t\t\tcontinue;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tint tempRowLength_";
  protected final String TEXT_78 = "+dynamic_";
  protected final String TEXT_79 = ".getColumnCount()-1;" + NL + "\t\t\t\t";
  protected final String TEXT_80 = NL + "\t\t\t\t\tint tempRowLength_";
  protected final String TEXT_81 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_82 = NL + "\t\t\t\tint columnIndex_";
  protected final String TEXT_83 = " = 0;" + NL + "\t\t\t";
  protected final String TEXT_84 = NL + "\t\t\tboolean isFirstCheckDyn_";
  protected final String TEXT_85 = " = true;" + NL + "\t\t\troutines.system.Dynamic dynamic_";
  protected final String TEXT_86 = " = new routines.system.Dynamic();" + NL + "\t\t";
  protected final String TEXT_87 = NL + NL + "\t\t\tclass RegexUtil_";
  protected final String TEXT_88 = " {" + NL + "" + NL + "\t\t    \tpublic java.util.List<jxl.Sheet> getSheets(jxl.Workbook workbook, String oneSheetName, boolean useRegex) {" + NL + "" + NL + "\t\t\t        java.util.List<jxl.Sheet> list = new java.util.ArrayList<jxl.Sheet>();" + NL + "" + NL + "\t\t\t        if(useRegex){//this part process the regex issue" + NL + "" + NL + "\t\t\t\t        jxl.Sheet[] sheets = workbook.getSheets();" + NL + "\t\t\t\t        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(oneSheetName);" + NL + "\t\t\t\t        for (int i = 0; i < sheets.length; i++) {" + NL + "\t\t\t\t            String sheetName = sheets[i].getName();" + NL + "\t\t\t\t            java.util.regex.Matcher matcher = pattern.matcher(sheetName);" + NL + "\t\t\t\t            if (matcher.matches()) {" + NL + "\t\t\t\t            \tjxl.Sheet sheet = workbook.getSheet(sheetName);" + NL + "\t\t\t\t            \tif(sheet != null){" + NL + "\t\t\t\t                \tlist.add(sheet);" + NL + "\t\t\t\t                }" + NL + "\t\t\t\t            }" + NL + "\t\t\t\t        }" + NL + "" + NL + "\t\t\t        }else{" + NL + "\t\t\t        \tjxl.Sheet sheet = workbook.getSheet(oneSheetName);" + NL + "\t\t            \tif(sheet != null){" + NL + "\t\t                \tlist.add(sheet);" + NL + "\t\t                }" + NL + "" + NL + "\t\t\t        }" + NL + "" + NL + "\t\t\t        return list;" + NL + "\t\t\t    }" + NL + "" + NL + "\t\t\t    public java.util.List<jxl.Sheet> getSheets(jxl.Workbook workbook, int index, boolean useRegex) {" + NL + "\t\t\t    \tjava.util.List<jxl.Sheet> list =  new java.util.ArrayList<jxl.Sheet>();" + NL + "\t\t\t    \tjxl.Sheet sheet = workbook.getSheet(index);" + NL + "\t            \tif(sheet != null){" + NL + "\t                \tlist.add(sheet);" + NL + "\t                }" + NL + "\t\t\t    \treturn list;" + NL + "\t\t\t    }" + NL + "" + NL + "\t\t\t}" + NL + "" + NL + "" + NL + "\t\tRegexUtil_";
  protected final String TEXT_89 = " regexUtil_";
  protected final String TEXT_90 = " = new RegexUtil_";
  protected final String TEXT_91 = "();" + NL + "\t\tfinal jxl.WorkbookSettings workbookSettings_";
  protected final String TEXT_92 = " = new jxl.WorkbookSettings();" + NL + "\t\tworkbookSettings_";
  protected final String TEXT_93 = ".setDrawingsDisabled(true);";
  protected final String TEXT_94 = NL + "\t\tworkbookSettings_";
  protected final String TEXT_95 = ".setCellValidationDisabled(true);";
  protected final String TEXT_96 = ".setSuppressWarnings(true);";
  protected final String TEXT_97 = NL + "        workbookSettings_";
  protected final String TEXT_98 = ".setEncoding(";
  protected final String TEXT_99 = ");" + NL + "" + NL + "        Object source_";
  protected final String TEXT_100 = " =";
  protected final String TEXT_101 = ";" + NL + "        final jxl.Workbook workbook_";
  protected final String TEXT_102 = ";" + NL + "" + NL + "        java.io.InputStream toClose_";
  protected final String TEXT_103 = " = null;" + NL + "        java.io.BufferedInputStream buffIStream";
  protected final String TEXT_104 = " = null;" + NL + "        try {" + NL + "            if(source_";
  protected final String TEXT_105 = " instanceof java.io.InputStream){" + NL + "        \t\ttoClose_";
  protected final String TEXT_106 = " = (java.io.InputStream)source_";
  protected final String TEXT_107 = ";" + NL + "        \t\tbuffIStream";
  protected final String TEXT_108 = " = new java.io.BufferedInputStream(toClose_";
  protected final String TEXT_109 = ");" + NL + "        \t\tworkbook_";
  protected final String TEXT_110 = " = jxl.Workbook.getWorkbook(buffIStream";
  protected final String TEXT_111 = ", workbookSettings_";
  protected final String TEXT_112 = ");" + NL + "            }else if(source_";
  protected final String TEXT_113 = " instanceof String){" + NL + "        \t\ttoClose_";
  protected final String TEXT_114 = " = new java.io.FileInputStream(source_";
  protected final String TEXT_115 = ".toString());" + NL + "        \t\tbuffIStream";
  protected final String TEXT_116 = ");" + NL + "            }else{" + NL + "            \tworkbook_";
  protected final String TEXT_117 = " = null;" + NL + "            \tthrow new java.lang.Exception(\"The data source should be specified as Inputstream or File Path!\");" + NL + "            }" + NL + "        } finally {" + NL + "\t\t\ttry{" + NL + "\t\t\t   if(buffIStream";
  protected final String TEXT_118 = " != null){" + NL + "\t\t\t   \t  buffIStream";
  protected final String TEXT_119 = ".close();" + NL + "\t\t\t   }" + NL + "\t\t\t}catch(Exception e){" + NL + "\t\t\t}" + NL + "        }" + NL + "        try {";
  protected final String TEXT_120 = NL + "\t\tjava.util.List<jxl.Sheet> sheetList_";
  protected final String TEXT_121 = " = java.util.Arrays.<jxl.Sheet> asList(workbook_";
  protected final String TEXT_122 = ".getSheets());";
  protected final String TEXT_123 = " = new java.util.ArrayList<jxl.Sheet>();";
  protected final String TEXT_124 = NL + "        sheetList_";
  protected final String TEXT_125 = ".addAll(regexUtil_";
  protected final String TEXT_126 = ".getSheets(workbook_";
  protected final String TEXT_127 = ", ";
  protected final String TEXT_128 = "));";
  protected final String TEXT_129 = NL + "        if(sheetList_";
  protected final String TEXT_130 = ".size() <= 0){" + NL + "        \tthrow new RuntimeException(\"Special sheets not exist!\");" + NL + "        }" + NL + "" + NL + "        java.util.List<jxl.Sheet> sheet_FilterNullList_";
  protected final String TEXT_131 = " = new java.util.ArrayList<jxl.Sheet>();" + NL + "        for(jxl.Sheet sheet_FilterNull_";
  protected final String TEXT_132 = " : sheetList_";
  protected final String TEXT_133 = "){" + NL + "        \tif(sheet_FilterNull_";
  protected final String TEXT_134 = ".getRows()>0){" + NL + "        \t\tsheet_FilterNullList_";
  protected final String TEXT_135 = ".add(sheet_FilterNull_";
  protected final String TEXT_136 = ");" + NL + "        \t}" + NL + "        }" + NL + "\t\tsheetList_";
  protected final String TEXT_137 = " = sheet_FilterNullList_";
  protected final String TEXT_138 = ";" + NL + "\tif(sheetList_";
  protected final String TEXT_139 = ".size()>0){" + NL + "        int nb_line_";
  protected final String TEXT_140 = " = 0;" + NL + "" + NL + "        int begin_line_";
  protected final String TEXT_141 = "0";
  protected final String TEXT_142 = ";" + NL + "" + NL + "        int footer_input_";
  protected final String TEXT_143 = ";" + NL + "" + NL + "        int end_line_";
  protected final String TEXT_144 = "=0;" + NL + "        for(jxl.Sheet sheet_";
  protected final String TEXT_145 = ":sheetList_";
  protected final String TEXT_146 = "){" + NL + "        \tend_line_";
  protected final String TEXT_147 = "+=sheet_";
  protected final String TEXT_148 = ".getRows();" + NL + "        }" + NL + "        end_line_";
  protected final String TEXT_149 = " -= footer_input_";
  protected final String TEXT_150 = ";" + NL + "        int limit_";
  protected final String TEXT_151 = "-1";
  protected final String TEXT_152 = ";" + NL + "        int start_column_";
  protected final String TEXT_153 = ";" + NL + "        int end_column_";
  protected final String TEXT_154 = " = sheetList_";
  protected final String TEXT_155 = ".get(0).getColumns();";
  protected final String TEXT_156 = NL + "        Integer lastColumn_";
  protected final String TEXT_157 = ";" + NL + "        if(lastColumn_";
  protected final String TEXT_158 = "!=null){" + NL + "        \tend_column_";
  protected final String TEXT_159 = " = lastColumn_";
  protected final String TEXT_160 = ".intValue();" + NL + "        }";
  protected final String TEXT_161 = NL + "        jxl.Cell[] row_";
  protected final String TEXT_162 = " = null;" + NL + "        jxl.Sheet sheet_";
  protected final String TEXT_163 = ".get(0);" + NL + "        int rowCount_";
  protected final String TEXT_164 = " = 0;" + NL + "        int sheetIndex_";
  protected final String TEXT_165 = " = 0;" + NL + "        int currentRows_";
  protected final String TEXT_166 = ".get(0).getRows();" + NL + "" + NL + "        //for the number format" + NL + "        java.text.DecimalFormat df_";
  protected final String TEXT_167 = " = new java.text.DecimalFormat(\"#.####################################\");" + NL + "\t\tchar separatorChar_";
  protected final String TEXT_168 = " = df_";
  protected final String TEXT_169 = ".getDecimalFormatSymbols().getDecimalSeparator();" + NL + "\t\t";
  protected final String TEXT_170 = NL + "\t\t\tif(begin_line_";
  protected final String TEXT_171 = " > 0){" + NL + "\t\t\t\tbegin_line_";
  protected final String TEXT_172 = " = begin_line_";
  protected final String TEXT_173 = " - 1;" + NL + "\t\t\t}" + NL + "\t\t\tboolean isFirstRow_";
  protected final String TEXT_174 = "=true;" + NL + "\t\t";
  protected final String TEXT_175 = NL + "\t\t";
  protected final String TEXT_176 = NL + "\t\t" + NL + "        for(int i_";
  protected final String TEXT_177 = "; i_";
  protected final String TEXT_178 = " < end_line_";
  protected final String TEXT_179 = "++){" + NL + "" + NL + "        \tint emptyColumnCount_";
  protected final String TEXT_180 = " = 0;" + NL + "" + NL + "        \tif (limit_";
  protected final String TEXT_181 = " != -1 && nb_line_";
  protected final String TEXT_182 = " >= limit_";
  protected final String TEXT_183 = ") {" + NL + "        \t\tbreak;" + NL + "        \t}" + NL + "" + NL + "            while (i_";
  protected final String TEXT_184 = " >= rowCount_";
  protected final String TEXT_185 = " + currentRows_";
  protected final String TEXT_186 = ") {" + NL + "                rowCount_";
  protected final String TEXT_187 = " += currentRows_";
  protected final String TEXT_188 = ";" + NL + "                sheet_";
  protected final String TEXT_189 = ".get(++sheetIndex_";
  protected final String TEXT_190 = ");" + NL + "                currentRows_";
  protected final String TEXT_191 = " = sheet_";
  protected final String TEXT_192 = ".getRows();" + NL + "            }";
  protected final String TEXT_193 = NL + "            if (rowCount_";
  protected final String TEXT_194 = " <= i_";
  protected final String TEXT_195 = ") {" + NL + "                row_";
  protected final String TEXT_196 = ".getRow(i_";
  protected final String TEXT_197 = " - rowCount_";
  protected final String TEXT_198 = ");" + NL + "            }";
  protected final String TEXT_199 = " && i_";
  protected final String TEXT_200 = " >= (";
  protected final String TEXT_201 = "begin_line_";
  protected final String TEXT_202 = "isFirstRow_";
  protected final String TEXT_203 = "?begin_line_";
  protected final String TEXT_204 = ":(begin_line_";
  protected final String TEXT_205 = "+1)";
  protected final String TEXT_206 = ")" + NL + "            \t&& currentRows_";
  protected final String TEXT_207 = " - footer_input_";
  protected final String TEXT_208 = " > i_";
  protected final String TEXT_209 = ");" + NL + "            }else{" + NL + "            \tcontinue;" + NL + "            }";
  protected final String TEXT_210 = NL + "\t\t\tisFirstRow_";
  protected final String TEXT_211 = " = false;" + NL + "\t\t";
  protected final String TEXT_212 = NL + "        \tglobalMap.put(\"";
  protected final String TEXT_213 = "_CURRENT_SHEET\",sheet_";
  protected final String TEXT_214 = ".getName());";
  protected final String TEXT_215 = NL + "    \t\t";
  protected final String TEXT_216 = " = null;";
  protected final String TEXT_217 = NL + "//" + NL + "//end%>" + NL + "\t\t\t" + NL + "\t\t\tString[] temp_row_";
  protected final String TEXT_218 = " = new String[tempRowLength_";
  protected final String TEXT_219 = "];" + NL + "\t\t\tint actual_end_column_";
  protected final String TEXT_220 = " = end_column_";
  protected final String TEXT_221 = " >\trow_";
  protected final String TEXT_222 = ".length ? row_";
  protected final String TEXT_223 = ".length : end_column_";
  protected final String TEXT_224 = ";" + NL + "" + NL + "\t\t\t\tjava.util.TimeZone zone_";
  protected final String TEXT_225 = " = java.util.TimeZone.getTimeZone(\"GMT\");" + NL + "                java.text.SimpleDateFormat sdf_";
  protected final String TEXT_226 = " = new java.text.SimpleDateFormat(";
  protected final String TEXT_227 = ");" + NL + "                sdf_";
  protected final String TEXT_228 = ".setTimeZone(zone_";
  protected final String TEXT_229 = ");" + NL + "                " + NL + "" + NL + "\t\t\tfor(int i=0;i<tempRowLength_";
  protected final String TEXT_230 = ";i++){" + NL + "" + NL + "\t\t\t\tif(i + start_column_";
  protected final String TEXT_231 = " < actual_end_column_";
  protected final String TEXT_232 = "){" + NL + "" + NL + "\t\t\t\t  jxl.Cell cell_";
  protected final String TEXT_233 = "[i + start_column_";
  protected final String TEXT_234 = "];";
  protected final String TEXT_235 = NL + "                        if (jxl.CellType.NUMBER == cell_";
  protected final String TEXT_236 = ".getType()||jxl.CellType.NUMBER_FORMULA == cell_";
  protected final String TEXT_237 = ".getType()){" + NL + "                            double doubleCell_";
  protected final String TEXT_238 = " = ((jxl.NumberCell)cell_";
  protected final String TEXT_239 = ").getValue();" + NL + "                            temp_row_";
  protected final String TEXT_240 = "[i] = String.valueOf(doubleCell_";
  protected final String TEXT_241 = ");" + NL + "                            if(temp_row_";
  protected final String TEXT_242 = "[i]!=null) {" + NL + "                                temp_row_";
  protected final String TEXT_243 = "[i] = df_";
  protected final String TEXT_244 = ".format(doubleCell_";
  protected final String TEXT_245 = ");" + NL + "                            }" + NL + "                    \t} else if(jxl.CellType.DATE== cell_";
  protected final String TEXT_246 = ".getType()||jxl.CellType.DATE_FORMULA== cell_";
  protected final String TEXT_247 = ".getType()){" + NL + "" + NL + "\t                            \t\t  \tjxl.DateCell dc_";
  protected final String TEXT_248 = " = (jxl.DateCell)cell_";
  protected final String TEXT_249 = ";" + NL + "                            \t\t\t\tjava.util.Date date_";
  protected final String TEXT_250 = " = dc_";
  protected final String TEXT_251 = ".getDate();" + NL + "                        \t\t\t\t\ttemp_row_";
  protected final String TEXT_252 = "[i] = sdf_";
  protected final String TEXT_253 = ".format(date_";
  protected final String TEXT_254 = ");" + NL + "                        \t\t\t\t\t" + NL + "                        } else{" + NL + "                            temp_row_";
  protected final String TEXT_255 = "[i] = cell_";
  protected final String TEXT_256 = ".getContents();" + NL + "                        }";
  protected final String TEXT_257 = NL + "                        temp_row_";
  protected final String TEXT_258 = ".getContents();";
  protected final String TEXT_259 = NL + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\ttemp_row_";
  protected final String TEXT_260 = "[i]=\"\";" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tboolean whetherReject_";
  protected final String TEXT_261 = " = false;" + NL + "\t\t\t";
  protected final String TEXT_262 = " = new ";
  protected final String TEXT_263 = "Struct();" + NL + "\t\t\tint curColNum_";
  protected final String TEXT_264 = " = -1;" + NL + "\t\t\tString curColName_";
  protected final String TEXT_265 = " = \"\";" + NL + "\t\t\ttry {";
  protected final String TEXT_266 = NL + "\t\t\t\t\t\t\tcolumnIndex_";
  protected final String TEXT_267 = "+dynamic_column_count_";
  protected final String TEXT_268 = NL + "\t\t\tif( temp_row_";
  protected final String TEXT_269 = "[columnIndex_";
  protected final String TEXT_270 = "]";
  protected final String TEXT_271 = ".length() > 0) {";
  protected final String TEXT_272 = NL + "\t\t\t\tcurColNum_";
  protected final String TEXT_273 = "=columnIndex_";
  protected final String TEXT_274 = " + start_column_";
  protected final String TEXT_275 = " + 1;" + NL + "\t\t\t\tcurColName_";
  protected final String TEXT_276 = " = \"";
  protected final String TEXT_277 = "\";";
  protected final String TEXT_278 = NL + "\t\t\t";
  protected final String TEXT_279 = ".";
  protected final String TEXT_280 = " = temp_row_";
  protected final String TEXT_281 = ";";
  protected final String TEXT_282 = NL + "\t\t\tif(";
  protected final String TEXT_283 = "<actual_end_column_";
  protected final String TEXT_284 = "){" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\tjava.util.Date dateGMT_";
  protected final String TEXT_285 = " = ((jxl.DateCell)row_";
  protected final String TEXT_286 = "]).getDate();" + NL + "\t\t\t\t\t";
  protected final String TEXT_287 = " = new java.util.Date(dateGMT_";
  protected final String TEXT_288 = ".getTime() - java.util.TimeZone.getDefault().getOffset(dateGMT_";
  protected final String TEXT_289 = ".getTime()));" + NL + "\t\t\t\t}catch(java.lang.Exception e){" + NL + "\t\t\t\t\t";
  protected final String TEXT_290 = NL + "\t\t\t\t\tthrow new RuntimeException(\"The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_291 = "+1)+ \" and ColumnNum. \" + curColNum_";
  protected final String TEXT_292 = " + \" )\");" + NL + "\t\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_293 = " = ParserUtils.parseTo_";
  protected final String TEXT_294 = "(ParserUtils.parseTo_Number(temp_row_";
  protected final String TEXT_295 = ".getBytes(";
  protected final String TEXT_296 = ");" + NL + "\t";
  protected final String TEXT_297 = NL + "\t\t\t\tdynamic_";
  protected final String TEXT_298 = ".clearColumnValues();" + NL + "\t\t\t\tint fieldCount_";
  protected final String TEXT_299 = ".length;" + NL + "\t\t\t\tdynamic_column_count_";
  protected final String TEXT_300 = " = dynamic_";
  protected final String TEXT_301 = ".getColumnCount();" + NL + "\t\t\t\tfor (int i = 0; i < dynamic_column_count_";
  protected final String TEXT_302 = " ; i++) {" + NL + "\t\t\t\t\tif ((";
  protected final String TEXT_303 = "+i) <= fieldCount_";
  protected final String TEXT_304 = "){" + NL + "\t\t\t\t\t\tif(temp_row_";
  protected final String TEXT_305 = "[";
  protected final String TEXT_306 = "+i]";
  protected final String TEXT_307 = ".length() < 1){" + NL + "\t\t\t\t\t\t\temptyColumnCount_";
  protected final String TEXT_308 = "++;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tdynamic_";
  protected final String TEXT_309 = ".addColumnValue(temp_row_";
  protected final String TEXT_310 = ");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\telse{" + NL + "\t\t\t\t\t\tdynamic_";
  protected final String TEXT_311 = ".addColumnValue(\"\");" + NL + "\t\t\t\t\t\temptyColumnCount_";
  protected final String TEXT_312 = "++;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_313 = " =dynamic_";
  protected final String TEXT_314 = ";" + NL + "\t\t\t";
  protected final String TEXT_315 = "(temp_row_";
  protected final String TEXT_316 = NL + "\t\t\t}else {";
  protected final String TEXT_317 = NL + "\t\t\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_318 = "' in '";
  protected final String TEXT_319 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_320 = NL + "\t\t\t\t";
  protected final String TEXT_321 = ";" + NL + "\t\t\t\temptyColumnCount_";
  protected final String TEXT_322 = "++;";
  protected final String TEXT_323 = NL + "\t\t}";
  protected final String TEXT_324 = " ";
  protected final String TEXT_325 = " = null; ";
  protected final String TEXT_326 = NL;
  protected final String TEXT_327 = NL + "        if(emptyColumnCount_";
  protected final String TEXT_328 = " >= ";
  protected final String TEXT_329 = "){" + NL + "        \tbreak; //if meet the empty row, there will break the iterate." + NL + "        }";
  protected final String TEXT_330 = NL + "\t\t\tnb_line_";
  protected final String TEXT_331 = "++;" + NL + "\t\t\t";
  protected final String TEXT_332 = NL + "    } catch (java.lang.Exception e) {" + NL + "        whetherReject_";
  protected final String TEXT_333 = " = true;";
  protected final String TEXT_334 = NL + "            throw(e);";
  protected final String TEXT_335 = NL + "                    ";
  protected final String TEXT_336 = "Struct();";
  protected final String TEXT_337 = NL + "                ";
  protected final String TEXT_338 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_339 = "+ \" column: \" + curColName_";
  protected final String TEXT_340 = " + \" (No. \" + curColNum_";
  protected final String TEXT_341 = " + \")\";";
  protected final String TEXT_342 = NL + "                System.err.println(e.getMessage());";
  protected final String TEXT_343 = NL + "            \t";
  protected final String TEXT_344 = NL + "    }" + NL + "" + NL + "\t\t\t\t\t";
  protected final String TEXT_345 = "if(!whetherReject_";
  protected final String TEXT_346 = ") { ";
  protected final String TEXT_347 = NL + "             if(";
  protected final String TEXT_348 = " == null){" + NL + "            \t ";
  protected final String TEXT_349 = "Struct();" + NL + "             }";
  protected final String TEXT_350 = NL + "\t    \t ";
  protected final String TEXT_351 = " } ";
  protected final String TEXT_352 = NL + "\t\t\tclass RegexUtil_";
  protected final String TEXT_353 = " {" + NL + "" + NL + "\t\t    \tpublic java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> getSheets(org.apache.poi.xssf.usermodel.XSSFWorkbook workbook, String oneSheetName, boolean useRegex) {" + NL + "" + NL + "\t\t\t        java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> list = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();" + NL + "" + NL + "\t\t\t        if(useRegex){//this part process the regex issue" + NL + "" + NL + "\t\t\t\t        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(oneSheetName);" + NL + "\t\t\t\t        for (org.apache.poi.ss.usermodel.Sheet sheet : workbook) {" + NL + "\t\t\t\t            String sheetName = sheet.getSheetName();" + NL + "\t\t\t\t            java.util.regex.Matcher matcher = pattern.matcher(sheetName);" + NL + "\t\t\t\t            if (matcher.matches()) {" + NL + "\t\t\t\t            \tif(sheet != null){" + NL + "\t\t\t\t                \tlist.add((org.apache.poi.xssf.usermodel.XSSFSheet) sheet);" + NL + "\t\t\t\t                }" + NL + "\t\t\t\t            }" + NL + "\t\t\t\t        }" + NL + "" + NL + "\t\t\t        }else{" + NL + "\t\t\t        \torg.apache.poi.xssf.usermodel.XSSFSheet sheet = (org.apache.poi.xssf.usermodel.XSSFSheet) workbook.getSheet(oneSheetName);" + NL + "\t\t            \tif(sheet != null){" + NL + "\t\t                \tlist.add(sheet);" + NL + "\t\t                }" + NL + "" + NL + "\t\t\t        }" + NL + "" + NL + "\t\t\t        return list;" + NL + "\t\t\t    }" + NL + "" + NL + "\t\t\t    public java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> getSheets(org.apache.poi.xssf.usermodel.XSSFWorkbook workbook, int index, boolean useRegex) {" + NL + "\t\t\t    \tjava.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> list =  new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();" + NL + "\t\t\t    \torg.apache.poi.xssf.usermodel.XSSFSheet sheet = (org.apache.poi.xssf.usermodel.XSSFSheet) workbook.getSheetAt(index);" + NL + "\t            \tif(sheet != null){" + NL + "\t                \tlist.add(sheet);" + NL + "\t                }" + NL + "\t\t\t    \treturn list;" + NL + "\t\t\t    }" + NL + "" + NL + "\t\t\t}" + NL + "\t\tRegexUtil_";
  protected final String TEXT_354 = "();" + NL + "" + NL + "\t\tObject source_";
  protected final String TEXT_355 = ";" + NL + "\t\torg.apache.poi.xssf.usermodel.XSSFWorkbook workbook_";
  protected final String TEXT_356 = " = null;" + NL + "" + NL + "\t\tif(source_";
  protected final String TEXT_357 = " instanceof String){" + NL + "\t\t\tworkbook_";
  protected final String TEXT_358 = " = (org.apache.poi.xssf.usermodel.XSSFWorkbook) org.apache.poi.ss.usermodel.WorkbookFactory.create(new java.io.File((String)source_";
  protected final String TEXT_359 = "), password_";
  protected final String TEXT_360 = ");" + NL + "\t\t} else if(source_";
  protected final String TEXT_361 = " instanceof java.io.InputStream) {" + NL + "     \t\tworkbook_";
  protected final String TEXT_362 = " = (org.apache.poi.xssf.usermodel.XSSFWorkbook) org.apache.poi.ss.usermodel.WorkbookFactory.create((java.io.InputStream)source_";
  protected final String TEXT_363 = ", password_";
  protected final String TEXT_364 = ");" + NL + "\t\t} else{" + NL + "\t\t\tworkbook_";
  protected final String TEXT_365 = " = null;" + NL + "\t\t\tthrow new java.lang.Exception(\"The data source should be specified as Inputstream or File Path!\");" + NL + "\t\t}" + NL + "\t\ttry {" + NL;
  protected final String TEXT_366 = NL + "    \tjava.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_";
  protected final String TEXT_367 = " = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();" + NL + "    \tfor(org.apache.poi.ss.usermodel.Sheet sheet_";
  protected final String TEXT_368 = " : workbook_";
  protected final String TEXT_369 = "){" + NL + "   \t\t\tsheetList_";
  protected final String TEXT_370 = ".add((org.apache.poi.xssf.usermodel.XSSFSheet) sheet_";
  protected final String TEXT_371 = ");" + NL + "    \t}";
  protected final String TEXT_372 = NL + "\t\tjava.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_";
  protected final String TEXT_373 = " = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();";
  protected final String TEXT_374 = NL + "    \tif(sheetList_";
  protected final String TEXT_375 = ".size() <= 0){" + NL + "            throw new RuntimeException(\"Special sheets not exist!\");" + NL + "        }" + NL + "" + NL + "\t\tjava.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_FilterNull_";
  protected final String TEXT_376 = " = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();" + NL + "\t\tfor (org.apache.poi.xssf.usermodel.XSSFSheet sheet_FilterNull_";
  protected final String TEXT_377 = ") {" + NL + "\t\t\tif(sheet_FilterNull_";
  protected final String TEXT_378 = "!=null && sheetList_FilterNull_";
  protected final String TEXT_379 = ".iterator()!=null && sheet_FilterNull_";
  protected final String TEXT_380 = ".iterator().hasNext()){" + NL + "\t\t\t\tsheetList_FilterNull_";
  protected final String TEXT_381 = ");" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tsheetList_";
  protected final String TEXT_382 = " = sheetList_FilterNull_";
  protected final String TEXT_383 = ".size()>0){" + NL + "\t\tint nb_line_";
  protected final String TEXT_384 = "=0;" + NL + "        for(org.apache.poi.xssf.usermodel.XSSFSheet sheet_";
  protected final String TEXT_385 = "){" + NL + "\t\t\tend_line_";
  protected final String TEXT_386 = "+=(sheet_";
  protected final String TEXT_387 = ".getLastRowNum()+1);" + NL + "        }" + NL + "        end_line_";
  protected final String TEXT_388 = " = -1;";
  protected final String TEXT_389 = NL + NL + "        org.apache.poi.xssf.usermodel.XSSFRow row_";
  protected final String TEXT_390 = " = null;" + NL + "        org.apache.poi.xssf.usermodel.XSSFSheet sheet_";
  protected final String TEXT_391 = " = (sheetList_";
  protected final String TEXT_392 = ".get(0).getLastRowNum()+1);" + NL + "" + NL + "\t\t//for the number format" + NL + "        java.text.DecimalFormat df_";
  protected final String TEXT_393 = " = new java.text.DecimalFormat(\"#.####################################\");" + NL + "        char decimalChar_";
  protected final String TEXT_394 = ".getDecimalFormatSymbols().getDecimalSeparator();";
  protected final String TEXT_395 = NL + "        for(int i_";
  protected final String TEXT_396 = " = (sheet_";
  protected final String TEXT_397 = ".getLastRowNum()+1);" + NL + "            }" + NL + "            globalMap.put(\"";
  protected final String TEXT_398 = ".getSheetName());";
  protected final String TEXT_399 = NL + "\t\t    ";
  protected final String TEXT_400 = NL + "\t\t\tString[] temp_row_";
  protected final String TEXT_401 = NL + "\t\t\t\tList<Boolean> datelist_";
  protected final String TEXT_402 = " = new java.util.ArrayList<Boolean>();" + NL + "\t\t\t\tList<String> patternlist_";
  protected final String TEXT_403 = " = new java.util.ArrayList<String>();";
  protected final String TEXT_404 = NL + "\t\t\t\t\t\t\tdatelist_";
  protected final String TEXT_405 = ".add(";
  protected final String TEXT_406 = ");" + NL + "\t\t\t\t\t\t\tpatternlist_";
  protected final String TEXT_407 = NL + "\t\t\tint excel_end_column_";
  protected final String TEXT_408 = ";" + NL + "\t\t\tif(row_";
  protected final String TEXT_409 = "==null){" + NL + "\t\t\t\texcel_end_column_";
  protected final String TEXT_410 = "=0;" + NL + "\t\t\t}else{" + NL + "\t\t\t\texcel_end_column_";
  protected final String TEXT_411 = "=row_";
  protected final String TEXT_412 = ".getLastCellNum();" + NL + "\t\t\t}" + NL + "\t\t\tint actual_end_column_";
  protected final String TEXT_413 = ";" + NL + "\t\t\tif(end_column_";
  protected final String TEXT_414 = " == -1){" + NL + "\t\t\t\tactual_end_column_";
  protected final String TEXT_415 = " = excel_end_column_";
  protected final String TEXT_416 = ";" + NL + "\t\t\t}" + NL + "\t\t\telse{" + NL + "\t\t\t\tactual_end_column_";
  protected final String TEXT_417 = " >\texcel_end_column_";
  protected final String TEXT_418 = " ? excel_end_column_";
  protected final String TEXT_419 = " : end_column_";
  protected final String TEXT_420 = ";" + NL + "\t\t\t}" + NL + "\t\t\torg.apache.poi.ss.formula.eval.NumberEval ne_";
  protected final String TEXT_421 = " = null;" + NL + "\t\t\tfor(int i=0;i<tempRowLength_";
  protected final String TEXT_422 = ";i++){" + NL + "\t\t\t\tif(i + start_column_";
  protected final String TEXT_423 = "){" + NL + "\t\t\t\t\torg.apache.poi.ss.usermodel.Cell cell_";
  protected final String TEXT_424 = ".getCell(i + start_column_";
  protected final String TEXT_425 = ");" + NL + "\t\t\t\t\tif(cell_";
  protected final String TEXT_426 = "!=null){" + NL + "\t\t\t\t\tswitch (cell_";
  protected final String TEXT_427 = ".getCellType()) {" + NL + "                        case STRING:" + NL + "                            temp_row_";
  protected final String TEXT_428 = ".getRichStringCellValue().getString();" + NL + "                            break;" + NL + "                        case NUMERIC:" + NL + "                            if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell_";
  protected final String TEXT_429 = ")) {";
  protected final String TEXT_430 = NL + "\t                            \tif(i>=";
  protected final String TEXT_431 = " && i<(";
  protected final String TEXT_432 = " + dynamic_";
  protected final String TEXT_433 = ".getColumnCount())){" + NL + "\t                            \t\ttemp_row_";
  protected final String TEXT_434 = "[i] = FormatterUtils.format_Date(cell_";
  protected final String TEXT_435 = ".getDateCellValue(),";
  protected final String TEXT_436 = ");" + NL + "\t                            \t}else{";
  protected final String TEXT_437 = NL + "\t\t\t\t\t\t\t\t\tint dateColIndex_";
  protected final String TEXT_438 = " = i;";
  protected final String TEXT_439 = NL + "\t\t\t\t\t\t\t\t\t\tif(i>";
  protected final String TEXT_440 = "){" + NL + "\t\t\t\t\t\t\t\t\t\t\tdateColIndex_";
  protected final String TEXT_441 = " = i-dynamic_";
  protected final String TEXT_442 = ".getColumnCount()+1;" + NL + "\t\t\t\t\t\t\t\t\t\t}";
  protected final String TEXT_443 = NL + "                    \t        \tif(datelist_";
  protected final String TEXT_444 = ".get(dateColIndex_";
  protected final String TEXT_445 = ")){" + NL + "                        \t        \ttemp_row_";
  protected final String TEXT_446 = ".getDateCellValue(),patternlist_";
  protected final String TEXT_447 = "));" + NL + "                            \t   \t} else{" + NL + "                                \t\ttemp_row_";
  protected final String TEXT_448 = ".getDateCellValue().toString();" + NL + "                                \t}";
  protected final String TEXT_449 = NL + "\t\t\t\t\t\t\t\t\ttemp_row_";
  protected final String TEXT_450 = "[i] =cell_";
  protected final String TEXT_451 = ".getDateCellValue().toString();";
  protected final String TEXT_452 = NL + "                            \t\t}";
  protected final String TEXT_453 = NL + "                            } else {" + NL + "                                temp_row_";
  protected final String TEXT_454 = ".format(cell_";
  protected final String TEXT_455 = ".getNumericCellValue());" + NL + "                            }" + NL + "                            break;" + NL + "                        case BOOLEAN:" + NL + "                            temp_row_";
  protected final String TEXT_456 = "[i] =String.valueOf(cell_";
  protected final String TEXT_457 = ".getBooleanCellValue());" + NL + "                            break;" + NL + "                        case FORMULA:" + NL + "        \t\t\t\t\tswitch (cell_";
  protected final String TEXT_458 = ".getCachedFormulaResultType()) {" + NL + "                                case STRING:" + NL + "                                    temp_row_";
  protected final String TEXT_459 = ".getRichStringCellValue().getString();" + NL + "                                    break;" + NL + "                                case NUMERIC:" + NL + "                                    if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell_";
  protected final String TEXT_460 = NL + "\t\t\t                            \tif(i>=";
  protected final String TEXT_461 = ".getColumnCount())){" + NL + "\t\t\t                            \t\ttemp_row_";
  protected final String TEXT_462 = ");" + NL + "\t\t\t                            \t}else{";
  protected final String TEXT_463 = NL + "\t\t\t\t\t\t\t\t\t\t\tint dateColIndex_";
  protected final String TEXT_464 = NL + "\t\t\t\t\t\t\t\t\t\t\t\tif(i>";
  protected final String TEXT_465 = "){" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tdateColIndex_";
  protected final String TEXT_466 = ".getColumnCount()+1;" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}";
  protected final String TEXT_467 = NL + "                    \t        \t\t\tif(datelist_";
  protected final String TEXT_468 = ")){" + NL + "                        \t        \t\t\ttemp_row_";
  protected final String TEXT_469 = "));" + NL + "                            \t   \t\t\t} else{" + NL + "                                \t\t\t\ttemp_row_";
  protected final String TEXT_470 = ".getDateCellValue().toString();" + NL + "                                \t\t\t}";
  protected final String TEXT_471 = NL + "\t\t\t\t\t\t\t\t\t\t\ttemp_row_";
  protected final String TEXT_472 = NL + "                            \t\t\t\t}";
  protected final String TEXT_473 = NL + "                                    } else {" + NL + "\t                                    ne_";
  protected final String TEXT_474 = " = new org.apache.poi.ss.formula.eval.NumberEval(cell_";
  protected final String TEXT_475 = ".getNumericCellValue());" + NL + "\t\t\t\t\t\t\t\t\t\ttemp_row_";
  protected final String TEXT_476 = "[i] = ne_";
  protected final String TEXT_477 = ".getStringValue();" + NL + "                                    }" + NL + "                                    break;" + NL + "                                case BOOLEAN:" + NL + "                                    temp_row_";
  protected final String TEXT_478 = ".getBooleanCellValue());" + NL + "                                    break;" + NL + "                                default:" + NL + "                            \t\ttemp_row_";
  protected final String TEXT_479 = "[i] = \"\";" + NL + "                            }" + NL + "                            break;" + NL + "                        default:" + NL + "                            temp_row_";
  protected final String TEXT_480 = "[i] = \"\";" + NL + "                        }" + NL + "                \t}" + NL + "                \telse{" + NL + "                \t\ttemp_row_";
  protected final String TEXT_481 = "[i]=\"\";" + NL + "                \t}" + NL + "" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\ttemp_row_";
  protected final String TEXT_482 = "[i]=\"\";" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tboolean whetherReject_";
  protected final String TEXT_483 = " = \"\";" + NL + "\t\t\ttry{";
  protected final String TEXT_484 = "\";" + NL;
  protected final String TEXT_485 = NL + "\t\t\t\tif(";
  protected final String TEXT_486 = "){" + NL + "\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\tif(row_";
  protected final String TEXT_487 = ".getCell(columnIndex_";
  protected final String TEXT_488 = "+ start_column_";
  protected final String TEXT_489 = ").getCellType() == org.apache.poi.ss.usermodel.CellType.NUMERIC && org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(row_";
  protected final String TEXT_490 = "))){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_491 = ").getDateCellValue();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\telse{" + NL + "                            java.util.Date tempDate_";
  protected final String TEXT_492 = " = ParserUtils.parseTo_Date(temp_row_";
  protected final String TEXT_493 = ");" + NL + "                            if(tempDate_";
  protected final String TEXT_494 = ".after((new SimpleDateFormat(\"yyyy/MM/dd hh:mm:ss.SSS\")).parse(\"9999/12/31 23:59:59.999\"))||tempDate_";
  protected final String TEXT_495 = ".before((new SimpleDateFormat(\"yyyy/MM/dd\")).parse(\"1900/01/01\"))){" + NL + "                                throw new RuntimeException(\"The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_496 = " + \" )\");" + NL + "                            }else{";
  protected final String TEXT_497 = NL + "                                ";
  protected final String TEXT_498 = " = tempDate_";
  protected final String TEXT_499 = ";" + NL + "                            }" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}catch(java.lang.Exception e){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_500 = NL + "\t\t\t\t\t\tthrow new RuntimeException(\"The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_501 = " + \" )\");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL;
  protected final String TEXT_502 = ", null, '.'==decimalChar_";
  protected final String TEXT_503 = " ? null : decimalChar_";
  protected final String TEXT_504 = NL + "\t\t\t\t\t\t\tdynamic_";
  protected final String TEXT_505 = ".clearColumnValues();" + NL + "\t\t\t\t\t\t\tint fieldCount_";
  protected final String TEXT_506 = " = 0;" + NL + "\t\t\t\t\t\t\tif(row_";
  protected final String TEXT_507 = "!=null){" + NL + "\t\t\t\t\t\t\t\tfieldCount_";
  protected final String TEXT_508 = ".getLastCellNum()-row_";
  protected final String TEXT_509 = ".getFirstCellNum()+1;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tdynamic_column_count_";
  protected final String TEXT_510 = ".getColumnCount();" + NL + "\t\t\t\t\t\t\tfor (int i = 0; i < dynamic_column_count_";
  protected final String TEXT_511 = " ; i++) {" + NL + "\t\t\t\t\t\t\t\tif ((";
  protected final String TEXT_512 = "){" + NL + "\t\t\t\t\t\t\t\t\tif(temp_row_";
  protected final String TEXT_513 = ".length() < 1){" + NL + "\t\t\t\t\t\t\t\t\t\temptyColumnCount_";
  protected final String TEXT_514 = "++;" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\tdynamic_";
  protected final String TEXT_515 = ");" + NL + "\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\tdynamic_";
  protected final String TEXT_516 = ".addColumnValue(\"\");" + NL + "\t\t\t\t\t\t\t\t\temptyColumnCount_";
  protected final String TEXT_517 = "++;" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_518 = NL + "\t\t\t}else{";
  protected final String TEXT_519 = NL + "\t\t\t\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_520 = NL + "\t\t\t}";
  protected final String TEXT_521 = NL + "\t\t\t\tnb_line_";
  protected final String TEXT_522 = "++;" + NL + "\t\t\t\t";
  protected final String TEXT_523 = NL + "\t\t\t}catch(java.lang.Exception e){" + NL + "\t\t\twhetherReject_";
  protected final String TEXT_524 = NL + "\t            throw(e);";
  protected final String TEXT_525 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_526 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_527 = NL + "\t\t\t\t\t";
  protected final String TEXT_528 = " + \")\";" + NL + "\t\t\t\t\t";
  protected final String TEXT_529 = NL + "\t\t\t\t\t System.err.println(e.getMessage());" + NL + "\t\t\t\t\t ";
  protected final String TEXT_530 = NL + "\t\t\t}" + NL + NL;
  protected final String TEXT_531 = NL + "\t\tObject source_";
  protected final String TEXT_532 = ";" + NL + "\t\tcom.talend.excel.xssf.event.ExcelReader excelReader_";
  protected final String TEXT_533 = " instanceof java.io.InputStream || source_";
  protected final String TEXT_534 = " instanceof String){" + NL + "\t\t\texcelReader_";
  protected final String TEXT_535 = " = new com.talend.excel.xssf.event.ExcelReader();" + NL + "\t\t\texcelReader_";
  protected final String TEXT_536 = ".setIncludePhoneticRuns(";
  protected final String TEXT_537 = ");" + NL + "\t\t}else{" + NL + "\t\t\tthrow new java.lang.Exception(\"The data source should be specified as Inputstream or File Path!\");" + NL + "\t\t}" + NL + "" + NL + "\t\ttry {";
  protected final String TEXT_538 = NL + "\t\texcelReader_";
  protected final String TEXT_539 = ".addSheetName(\".*\",true);";
  protected final String TEXT_540 = ".addSheetName(";
  protected final String TEXT_541 = NL + "\t\tint start_column_";
  protected final String TEXT_542 = ";" + NL + "\t\tint end_column_";
  protected final String TEXT_543 = ";" + NL + "\t\tif(start_column_";
  protected final String TEXT_544 = " >=0) {//follow start column" + NL + "\t\t\t";
  protected final String TEXT_545 = NL + "\t\t\t\t\tend_column_";
  protected final String TEXT_546 = " = 16384;" + NL + "\t\t\t\t";
  protected final String TEXT_547 = "-1;" + NL + "\t\t\t\t";
  protected final String TEXT_548 = NL + "\t\t\t\tend_column_";
  protected final String TEXT_549 = " = start_column_";
  protected final String TEXT_550 = " + ";
  protected final String TEXT_551 = " - 1;" + NL + "\t\t\t";
  protected final String TEXT_552 = NL + "\t\t} else if(end_column_";
  protected final String TEXT_553 = " >= 0) {//follow end column" + NL + "\t\t\tstart_column_";
  protected final String TEXT_554 = " - ";
  protected final String TEXT_555 = " + 1;" + NL + "\t\t}" + NL + "" + NL + "\t\tif(end_column_";
  protected final String TEXT_556 = "<0 || start_column_";
  protected final String TEXT_557 = "<0) {" + NL + "\t\t\tthrow new RuntimeException(\"Error start column and end column.\");" + NL + "\t\t}" + NL + "\t\tint actual_end_column_";
  protected final String TEXT_558 = " ;" + NL + "" + NL + "\t\tint header_";
  protected final String TEXT_559 = ";" + NL + "\t\tint limit_";
  protected final String TEXT_560 = ";" + NL + "" + NL + "\t\tint nb_line_";
  protected final String TEXT_561 = " = 0;" + NL + "" + NL + "\t\t//for the number format" + NL + "        java.text.DecimalFormat df_";
  protected final String TEXT_562 = ".getDecimalFormatSymbols().getDecimalSeparator();" + NL + "" + NL + "\t\tif(source_";
  protected final String TEXT_563 = ".parse((String)source_";
  protected final String TEXT_564 = ",";
  protected final String TEXT_565 = " instanceof java.io.InputStream) {" + NL + "\t\t\texcelReader_";
  protected final String TEXT_566 = ".parse((java.io.InputStream)source_";
  protected final String TEXT_567 = ");" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_568 = NL + "\t\t\tif(header_";
  protected final String TEXT_569 = " > 0){" + NL + "\t\t\t\theader_";
  protected final String TEXT_570 = " = header_";
  protected final String TEXT_571 = " - 1;" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_572 = NL + NL + NL + "\t\twhile((header_";
  protected final String TEXT_573 = "--)>0 && excelReader_";
  protected final String TEXT_574 = ".hasNext()) {//skip the header" + NL + "\t\t\texcelReader_";
  protected final String TEXT_575 = ".next();" + NL + "\t\t}" + NL + "" + NL + "\t\t";
  protected final String TEXT_576 = NL + "\t\twhile(excelReader_";
  protected final String TEXT_577 = ".hasNext()) {" + NL + "\t\t\tint emptyColumnCount_";
  protected final String TEXT_578 = " = 0;" + NL + "" + NL + "\t\t\tif (limit_";
  protected final String TEXT_579 = ") {" + NL + "\t\t\t\texcelReader_";
  protected final String TEXT_580 = ".stopRead();" + NL + "        \t\tbreak;" + NL + "        \t}" + NL + "" + NL + "        \tjava.util.List<String> row_";
  protected final String TEXT_581 = " = excelReader_";
  protected final String TEXT_582 = ".next();";
  protected final String TEXT_583 = NL + "\t\t\t\t\t" + NL + "\t\tString[] temp_row_";
  protected final String TEXT_584 = "];" + NL + "\t\t";
  protected final String TEXT_585 = NL + "\t\t\tactual_end_column_";
  protected final String TEXT_586 = ".getColumnCount()-1;" + NL + "\t\t";
  protected final String TEXT_587 = NL + "\t\tfor(int i_";
  protected final String TEXT_588 = "=0;i_";
  protected final String TEXT_589 = " < tempRowLength_";
  protected final String TEXT_590 = ";i_";
  protected final String TEXT_591 = "++){" + NL + "\t\t\tint current_";
  protected final String TEXT_592 = " = i_";
  protected final String TEXT_593 = ";" + NL + "\t\t\tif(current_";
  protected final String TEXT_594 = " <= actual_end_column_";
  protected final String TEXT_595 = "){" + NL + "\t\t\t\tif(current_";
  protected final String TEXT_596 = " < row_";
  protected final String TEXT_597 = ".size()){" + NL + "\t\t\t\t\tString column_";
  protected final String TEXT_598 = ".get(current_";
  protected final String TEXT_599 = ");" + NL + "\t\t\t\t\tif(column_";
  protected final String TEXT_600 = "!=null) {" + NL + "\t\t\t\t\t\ttemp_row_";
  protected final String TEXT_601 = "[i_";
  protected final String TEXT_602 = "] = column_";
  protected final String TEXT_603 = ";" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\ttemp_row_";
  protected final String TEXT_604 = "]=\"\";" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\ttemp_row_";
  protected final String TEXT_605 = "]=\"\";" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\ttemp_row_";
  protected final String TEXT_606 = "]=\"\";" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\tboolean whetherReject_";
  protected final String TEXT_607 = "Struct();" + NL + "\t\tint curColNum_";
  protected final String TEXT_608 = " = -1;" + NL + "\t\tString curColName_";
  protected final String TEXT_609 = " = \"\";" + NL + "" + NL + "\t\ttry{";
  protected final String TEXT_610 = NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\t";
  protected final String TEXT_611 = ");" + NL + "\t\t\t\t}catch(java.lang.Exception e){" + NL + "\t\t\t\t\t";
  protected final String TEXT_612 = " + \" )\");" + NL + "\t\t\t\t}" + NL;
  protected final String TEXT_613 = ".size();" + NL + "\t\t\t\t\t\t\tdynamic_column_count_";
  protected final String TEXT_614 = ");" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\telse{" + NL + "\t\t\t\t\t\t\t\t\tdynamic_";
  protected final String TEXT_615 = NL + "\t\t} catch(java.lang.Exception e) {" + NL + "\t\t\twhetherReject_";
  protected final String TEXT_616 = NL + "\t\t\t}" + NL;
  protected final String TEXT_617 = NL + "        \t\t";
  protected final String TEXT_618 = NL + "                     if(";
  protected final String TEXT_619 = " == null){" + NL + "                    \t ";
  protected final String TEXT_620 = "Struct();" + NL + "                     }";
  protected final String TEXT_621 = NL + "        \t    \t ";

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
	
    stringBuffer.append(TEXT_18);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
final String cid = node.getUniqueName();
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
		final boolean version07 = ("true").equals(ElementParameterParser.getValue(node,"__VERSION_2007__"));

		String fileName = ElementParameterParser.getValue(node,"__FILENAME__");

    	String header = ElementParameterParser.getValue(node, "__HEADER__");
    	String limit = ElementParameterParser.getValue(node, "__LIMIT__");
    	String footer = ElementParameterParser.getValue(node, "__FOOTER__");
    	String firstColumn = ElementParameterParser.getValue(node, "__FIRST_COLUMN__");
    	String lastColumn = ElementParameterParser.getValue(node, "__LAST_COLUMN__");
    	String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
		boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;
		String encoding = ElementParameterParser.getValue(node,"__ENCODING__");

		String allSheets = ElementParameterParser.getValue(node, "__ALL_SHEETS__");
		boolean isAllSheets = (allSheets!=null&&!("").equals(allSheets))?("true").equals(allSheets):false;
		List<Map<String, String>> sheetNameList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SHEETLIST__");

		String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
		boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
		String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
		String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);

		boolean affect = ("true").equals(ElementParameterParser.getValue(node,"__AFFECT_EACH_SHEET__"));
		boolean stopOnEmptyRow = ("true").equals(ElementParameterParser.getValue(node,"__STOPREAD_ON_EMPTYROW__"));

		List<Map<String, String>> trimSelects = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIMSELECT__");
		String isTrimAllStr = ElementParameterParser.getValue(node,"__TRIMALL__");
		boolean isTrimAll = (isTrimAllStr!=null&&!("").equals(isTrimAllStr))?("true").equals(isTrimAllStr):true;

		String mode = ElementParameterParser.getValue(node,"__GENERATION_MODE__");
		final boolean eventMode = "EVENT_MODE".equals(mode);

        if (version07) {
            String passwordFieldName = "__PASSWORD__";
        
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_21);
    } else {
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_24);
    }
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    
        }

		boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
		
		int dynamic_index = -1;
		boolean hasDynamic = false;
		List<IMetadataColumn> columnList = metadata.getListColumns();
		String datePattern = "\"dd-MM-yyyy\"";
		for(int i=0; columnList!=null && i< columnList.size(); i++) {
	        if(columnList.get(i).getTalendType().equals("id_Dynamic")){
	            dynamic_index = i+1;
	            hasDynamic = true;
	            datePattern= columnList.get(i).getPattern();
	            break;
	        }
		}
		
		class GenerateCodeUtil{
			public void generateCode(int dynamic_index,int colLen,boolean hasDynamic){
				if(hasDynamic){
				
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_33);
    if(!version07){
    stringBuffer.append(TEXT_34);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_35);
    }else if(!eventMode){
    stringBuffer.append(TEXT_34);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_36);
    }else{
    stringBuffer.append(TEXT_34);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_37);
    }
    stringBuffer.append(TEXT_38);
    
						if(!version07){
						
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    
						}else if(!eventMode){
						
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_46);
    
		    			}else{
		    			
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_46);
    
		    			}
		    			
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(colLen-1);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(dynamic_index-1);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(colLen-dynamic_index);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    
							if(!version07){
							
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_56);
    
							}else if(!eventMode){
							
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_59);
    
			    			}else{
			    			
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_60);
    
			    			}
			    			
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(colLen);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    
				}else{
				
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(colLen);
    stringBuffer.append(TEXT_81);
    
				}
				
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    
			}
		}
		GenerateCodeUtil generateCodeUtil = new GenerateCodeUtil();
		if(hasDynamic){
			
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    
		}
		/* -------------------------- */
		if(!version07){//version judgement
			boolean bReadRealValue = ("true").equals(ElementParameterParser.getValue(node, "__READ_REAL_VALUE__"));
			boolean notNeedValidateOnCell = !("false").equals(ElementParameterParser.getValue(node,"__NOVALIDATE_ON_CELL__"));//make wizard work
			boolean suppressWarn = !("false").equals(ElementParameterParser.getValue(node,"__SUPPRESS_WARN__"));//make wizard work

    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_93);
    
		if(notNeedValidateOnCell==true){

    stringBuffer.append(TEXT_94);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_95);
    
		}
		if(suppressWarn ==true){

    stringBuffer.append(TEXT_94);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_96);
    
		}

    stringBuffer.append(TEXT_97);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_119);
    
		if(isAllSheets){

    stringBuffer.append(TEXT_120);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_122);
    
		}else{

    stringBuffer.append(TEXT_120);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_123);
    
			for(Map<String, String> tmp:sheetNameList){

    stringBuffer.append(TEXT_124);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(tmp.get("SHEETNAME"));
    stringBuffer.append(TEXT_127);
    stringBuffer.append((tmp.get("USE_REGEX")!=null&&!"".equals(tmp.get("USE_REGEX")))?"true".equals(tmp.get("USE_REGEX")):false);
    stringBuffer.append(TEXT_128);
    
			}
		}

    stringBuffer.append(TEXT_129);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_23);
    if(("").equals(header.trim())){
    stringBuffer.append(TEXT_141);
    }else{
    stringBuffer.append( header );
    }
    stringBuffer.append(TEXT_142);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_23);
    if(("").equals(footer.trim())){
    stringBuffer.append(TEXT_141);
    }else{
    stringBuffer.append(footer);
    }
    stringBuffer.append(TEXT_143);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_23);
    if(("").equals(limit.trim())){
    stringBuffer.append(TEXT_151);
    }else{
    stringBuffer.append(limit);
    }
    stringBuffer.append(TEXT_152);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_23);
    if(("").equals(firstColumn.trim())){
    stringBuffer.append(TEXT_141);
    }else{
    stringBuffer.append(firstColumn);
    stringBuffer.append(TEXT_151);
    }
    stringBuffer.append(TEXT_153);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_155);
    if(lastColumn!=null && !("").equals(lastColumn.trim())){
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(lastColumn);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    }
    stringBuffer.append(TEXT_161);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    
		if(hasDynamic){
		
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    
		}
		
    stringBuffer.append(TEXT_175);
    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_176);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_178);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_184);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_192);
    
	if(!affect){

    stringBuffer.append(TEXT_193);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_198);
    
	}else{

    stringBuffer.append(TEXT_193);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_200);
    if(!hasDynamic){
    stringBuffer.append(TEXT_201);
    stringBuffer.append( cid );
    }else{
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_205);
    }
    stringBuffer.append(TEXT_206);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_208);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_209);
    
    }
    	if(hasDynamic){

    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    
		}
		
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_214);
    
//begin
//
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();

    String rejectConnName = "";
    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
    if(rejectConns != null && rejectConns.size() > 0) {
        IConnection rejectConn = rejectConns.get(0);
        rejectConnName = rejectConn.getName();
    }
    List<IMetadataColumn> rejectColumnList = null;
    IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
    if(metadataTable != null) {
        rejectColumnList = metadataTable.getListColumns();
    }

    	if (conns!=null) {
    		if (conns.size()>0) {
    			for (int i=0;i<conns.size();i++) {
    				IConnection connTemp = conns.get(i);
    				if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_215);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_216);
    
    				}
    			}
    		}
    	}

		String firstConnName = "";
		if (conns!=null) {
			if (conns.size()>0) {
				IConnection conn = conns.get(0);
				firstConnName = conn.getName();
				List<IMetadataColumn> listColumns = metadata.getListColumns();
				int size = listColumns.size();
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				 	generateCodeUtil.generateCode(dynamic_index,size,hasDynamic);
					
    stringBuffer.append(TEXT_217);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_220);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_221);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_223);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_224);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_225);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(datePattern);
    stringBuffer.append(TEXT_227);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_228);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_231);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_233);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_234);
    
                    if(bReadRealValue){

    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_250);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_251);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_252);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_253);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_254);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    
                    }else{

    stringBuffer.append(TEXT_257);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    
                    }

    stringBuffer.append(TEXT_259);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_262);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_265);
    
//start
//
					for (int i=0; i<size; i++) {
						IMetadataColumn column = listColumns.get(i);
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
						if(metadata.isDynamicSchema()){
						
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
						}else{
						
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_42);
    
						}
//
//end
		if(!column.getTalendType().equals("id_Dynamic")){

    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_271);
    
		}

    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_277);
    
//start
//

						if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
//
//end
    stringBuffer.append(TEXT_278);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_281);
    
//start
			} else if(javaType == JavaTypesManager.DATE) {
//
//end
    stringBuffer.append(TEXT_282);
    stringBuffer.append( i);
    stringBuffer.append(TEXT_283);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_285);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_286);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_289);
     // for bug TDI-19404 
    stringBuffer.append(TEXT_290);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_292);
    
//start
			}else if(advancedSeparator && JavaTypesManager.isNumberType(javaType)) {

    stringBuffer.append(TEXT_175);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_293);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_127);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_127);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_128);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY) {
	
    stringBuffer.append(TEXT_278);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_295);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_296);
    
			}else if(column.getTalendType().equals("id_Dynamic")){
				dynamic_index = i;
			
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_304);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_305);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_306);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_307);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_309);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_305);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_306);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_311);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_312);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_314);
    
			} else {
//
//end
    stringBuffer.append(TEXT_278);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_293);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_21);
    
//start
//
						}
//
//end
		if(!column.getTalendType().equals("id_Dynamic")){

    stringBuffer.append(TEXT_316);
    
//start
//
						String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
						if(defaultValue == null) {
//
//end
    stringBuffer.append(TEXT_317);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_318);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_319);
    
//start
//
						} else {
//
//end
    stringBuffer.append(TEXT_320);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_321);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_322);
    
//start
//
						}
//
//end
    stringBuffer.append(TEXT_323);
    
//start
//
		}
					}
    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_324);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_325);
    }
    stringBuffer.append(TEXT_326);
    
	if(stopOnEmptyRow){

    stringBuffer.append(TEXT_327);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_328);
    stringBuffer.append(size );
    if(hasDynamic){
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    }
    stringBuffer.append(TEXT_329);
    
	}

    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    log4jFileUtil.debugRetriveData(node);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    
        if (dieOnError) {
            
    stringBuffer.append(TEXT_334);
    
        } else {
            if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

                
    stringBuffer.append(TEXT_335);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_262);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_336);
    
                for(IMetadataColumn column : metadata.getListColumns()) {
                    
    stringBuffer.append(TEXT_335);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_281);
    
                }
                
    stringBuffer.append(TEXT_337);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_341);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_216);
    
            } else if(("").equals(rejectConnName)){
                
    stringBuffer.append(TEXT_342);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_216);
    
            } else if(rejectConnName.equals(firstConnName)){
    stringBuffer.append(TEXT_343);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_341);
    }
        }
        
    stringBuffer.append(TEXT_344);
    
				}
			}
		if (conns.size()>0) {
			boolean isFirstEnter = true;
			for (int i=0;i<conns.size();i++) {
				IConnection conn = conns.get(i);
				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

    stringBuffer.append(TEXT_175);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_347);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_348);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_262);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_349);
    
			    	 for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_350);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_281);
    
				 	}
				}
			}

    stringBuffer.append(TEXT_175);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_351);
     } 
    
		}
		}

    
		} else if(!eventMode) {//version judgement /***excel 2007 xlsx and usermodel mode*****/

    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    
		if(isAllSheets){

    stringBuffer.append(TEXT_366);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_371);
    
		}else{

    stringBuffer.append(TEXT_372);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_373);
    
			for(Map<String, String> tmp:sheetNameList){

    stringBuffer.append(TEXT_124);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(tmp.get("SHEETNAME"));
    stringBuffer.append(TEXT_127);
    stringBuffer.append((tmp.get("USE_REGEX")!=null&&!"".equals(tmp.get("USE_REGEX")))?"true".equals(tmp.get("USE_REGEX")):false);
    stringBuffer.append(TEXT_128);
    
			}
		}

    stringBuffer.append(TEXT_374);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_383);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_23);
    if(("").equals(header.trim())){
    stringBuffer.append(TEXT_141);
    }else{
    stringBuffer.append( header );
    }
    stringBuffer.append(TEXT_142);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_23);
    if(("").equals(footer.trim())){
    stringBuffer.append(TEXT_141);
    }else{
    stringBuffer.append(footer);
    }
    stringBuffer.append(TEXT_143);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_385);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_23);
    if(("").equals(limit.trim())){
    stringBuffer.append(TEXT_151);
    }else{
    stringBuffer.append(limit);
    }
    stringBuffer.append(TEXT_152);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_23);
    if(("").equals(firstColumn.trim())){
    stringBuffer.append(TEXT_141);
    }else{
    stringBuffer.append(firstColumn);
    stringBuffer.append(TEXT_151);
    }
    stringBuffer.append(TEXT_153);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_388);
    if(lastColumn!=null && !("").equals(lastColumn.trim())){
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(lastColumn);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    }
    stringBuffer.append(TEXT_389);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_390);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_391);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_394);
    
		if(hasDynamic){
		
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    
		}
		
    stringBuffer.append(TEXT_175);
    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_395);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_178);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_184);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_396);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_398);
    
	if(!affect){

    stringBuffer.append(TEXT_193);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_198);
    
	}else{

    stringBuffer.append(TEXT_193);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_200);
    if(!hasDynamic){
    stringBuffer.append(TEXT_201);
    stringBuffer.append( cid );
    }else{
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_205);
    }
    stringBuffer.append(TEXT_206);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_208);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_209);
    
    }
    	if(hasDynamic){
	
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    
		}
		List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		String rejectConnName = "";
		List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
		if(rejectConns != null && rejectConns.size() > 0) {
			IConnection rejectConn = rejectConns.get(0);
			rejectConnName = rejectConn.getName();
		}
		List<IMetadataColumn> rejectColumnList = null;
		IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
		if(metadataTable != null) {
			 rejectColumnList = metadataTable.getListColumns();
		}
		if (conns!=null) {
			if (conns.size()>0) {
		    	for (int i=0;i<conns.size();i++) {
		    		IConnection connTemp = conns.get(i);
		    		if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_399);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_216);
    
		    		}
		    	}
		    }
		}
		List<Map<String, String>> dateSelect = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__DATESELECT__");
		boolean converDatetoString = ("true").equals(ElementParameterParser.getValue(node, "__CONVERTDATETOSTRING__"));
		String firstConnName = "";
		if (conns!=null) {//3
			if (conns.size()>0) {//4
				IConnection conn = conns.get(0);
				firstConnName = conn.getName();
				List<IMetadataColumn> listColumns = metadata.getListColumns();
				int size = listColumns.size();
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//5
					generateCodeUtil.generateCode(dynamic_index,size,hasDynamic);
					
    stringBuffer.append(TEXT_400);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    
			if(converDatetoString){

    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_403);
    
				for(IMetadataColumn column:listColumns){
					for(Map<String, String> line:dateSelect){// search in the date table
						String columnName = line.get("SCHEMA_COLUMN");
						if(column.getLabel().equals(columnName)){

    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(line.get("CONVERTDATE"));
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(line.get("PATTERN"));
    stringBuffer.append(TEXT_21);
    
						}
					}
				}
			}

    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_408);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_411);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_412);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_414);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_416);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_220);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_419);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_422);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_231);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_424);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_427);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    
                            	if(hasDynamic){

    stringBuffer.append(TEXT_430);
    stringBuffer.append(dynamic_index-1);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(dynamic_index-1);
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_433);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(datePattern);
    stringBuffer.append(TEXT_436);
    
		                     	}
								if(converDatetoString){

    stringBuffer.append(TEXT_437);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_438);
    
									if(hasDynamic){

    stringBuffer.append(TEXT_439);
    stringBuffer.append(dynamic_index-1);
    stringBuffer.append(TEXT_440);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_442);
    
									}

    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_445);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_447);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_448);
    
								}else{

    stringBuffer.append(TEXT_449);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_451);
    
								}
                            	if(hasDynamic){

    stringBuffer.append(TEXT_452);
    
                            	}

    stringBuffer.append(TEXT_453);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_455);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_458);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    
                            			if(hasDynamic){

    stringBuffer.append(TEXT_460);
    stringBuffer.append(dynamic_index-1);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(dynamic_index-1);
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_461);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(datePattern);
    stringBuffer.append(TEXT_462);
    
		                     			}
										if(converDatetoString){

    stringBuffer.append(TEXT_463);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_438);
    
											if(hasDynamic){

    stringBuffer.append(TEXT_464);
    stringBuffer.append(dynamic_index-1);
    stringBuffer.append(TEXT_465);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_466);
    
											}

    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_468);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_469);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_470);
    
										}else{

    stringBuffer.append(TEXT_471);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_451);
    
										}
                            			if(hasDynamic){

    stringBuffer.append(TEXT_472);
    
										}

    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_475);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_477);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_478);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_479);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_481);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_482);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_483);
    
					for (int i=0; i<size; i++) {//5
						IMetadataColumn column = listColumns.get(i);
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
						if(metadata.isDynamicSchema()){
						
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
						}else{
						
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_42);
    
						}
		if(!column.getTalendType().equals("id_Dynamic")){

    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_271);
    
		}

    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_484);
    
						if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_320);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_281);
    
						} else if(javaType == JavaTypesManager.DATE) {

    stringBuffer.append(TEXT_485);
    stringBuffer.append( i);
    stringBuffer.append(TEXT_283);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_486);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_488);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_489);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_488);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_490);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_40);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_488);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_491);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_127);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_495);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_496);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_499);
     // for bug TDI-19404 
    stringBuffer.append(TEXT_500);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_501);
    
						}else if(JavaTypesManager.isNumberType(javaType)) {
							if(advancedSeparator) {

    stringBuffer.append(TEXT_320);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_293);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_127);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_127);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_128);
    
							} else {

    stringBuffer.append(TEXT_320);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_293);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    
							}
						} else if(javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(TEXT_320);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_295);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_21);
    
						}else if(column.getTalendType().equals("id_Dynamic")){
							dynamic_index = i;
							
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_506);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_508);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_510);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_511);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_512);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_305);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_306);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_513);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_514);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_309);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_305);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_306);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_516);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_517);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    
						} else {

    stringBuffer.append(TEXT_320);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_293);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_21);
    
						}
		if(!column.getTalendType().equals("id_Dynamic")){

    stringBuffer.append(TEXT_518);
    
						String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
						if(defaultValue == null) {

    stringBuffer.append(TEXT_519);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_318);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_319);
    
						} else {

    stringBuffer.append(TEXT_320);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_321);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_322);
    
						}

    stringBuffer.append(TEXT_520);
    
		}
					}

    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_324);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_325);
    }
    stringBuffer.append(TEXT_326);
    
	if(stopOnEmptyRow){

    stringBuffer.append(TEXT_327);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_328);
    stringBuffer.append(size );
    if(hasDynamic){
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    }
    stringBuffer.append(TEXT_329);
    
	}

    stringBuffer.append(TEXT_521);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_522);
    log4jFileUtil.debugRetriveData(node);
    stringBuffer.append(TEXT_523);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    
		        if (dieOnError) {

    stringBuffer.append(TEXT_524);
    
		        }
		        else{
					if(isLog4jEnabled){
    stringBuffer.append(TEXT_525);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_526);
    }
					if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {//15

    stringBuffer.append(TEXT_527);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_262);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_336);
    
						for(IMetadataColumn column : metadata.getListColumns()) {//16

    stringBuffer.append(TEXT_527);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_281);
    
					    }//16

    stringBuffer.append(TEXT_527);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_528);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_216);
    
					} else if(("").equals(rejectConnName)){

    stringBuffer.append(TEXT_529);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_216);
    
					} else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_527);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_341);
    
					}//15
				}

    stringBuffer.append(TEXT_530);
    
				}
			}
		if (conns.size()>0) {
			boolean isFirstEnter = true;
			for (int i=0;i<conns.size();i++) {
				IConnection conn = conns.get(i);
				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

    stringBuffer.append(TEXT_175);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_347);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_348);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_262);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_349);
    
			    	 for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_350);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_281);
    
				 	}
				}
			}

    stringBuffer.append(TEXT_175);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_351);
     } 
    
		}
		}

    
		} else {//version judgement /***excel 2007 xlsx and event mode*****/
		    boolean includePhoneticRuns = "true".equals(ElementParameterParser.getValue(node,"__INCLUDE_PHONETICRUNS__"));

    stringBuffer.append(TEXT_531);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_534);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_536);
    stringBuffer.append(includePhoneticRuns);
    stringBuffer.append(TEXT_537);
    
			if(isAllSheets){

    stringBuffer.append(TEXT_538);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_539);
    
			} else {
				for(Map<String, String> tmp:sheetNameList){

    stringBuffer.append(TEXT_538);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_540);
    stringBuffer.append(tmp.get("SHEETNAME"));
    stringBuffer.append(TEXT_127);
    stringBuffer.append((tmp.get("USE_REGEX")!=null&&!"".equals(tmp.get("USE_REGEX")))?"true".equals(tmp.get("USE_REGEX")):false);
    stringBuffer.append(TEXT_21);
    
				}
			}

    stringBuffer.append(TEXT_541);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_23);
    if(("").equals(firstColumn.trim())){
    stringBuffer.append(TEXT_141);
    }else{
    stringBuffer.append(firstColumn);
    stringBuffer.append(TEXT_151);
    }
    stringBuffer.append(TEXT_542);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_23);
    if(("").equals(lastColumn.trim())){
    stringBuffer.append(TEXT_151);
    }else{
    stringBuffer.append(lastColumn);
    stringBuffer.append(TEXT_151);
    }
    stringBuffer.append(TEXT_543);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_544);
    
			if(hasDynamic){
				if(("").equals(lastColumn.trim())){
				
    stringBuffer.append(TEXT_545);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_546);
    
				}else{
				
    stringBuffer.append(TEXT_545);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(lastColumn);
    stringBuffer.append(TEXT_547);
    
				}
			}else{
			
    stringBuffer.append(TEXT_548);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_549);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_550);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_551);
    
			}
			
    stringBuffer.append(TEXT_552);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_553);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_220);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_554);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_555);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_556);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_557);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_220);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_558);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    if(("").equals(header.trim())){
    stringBuffer.append(TEXT_141);
    }else{
    stringBuffer.append(header);
    }
    stringBuffer.append(TEXT_559);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    if(("").equals(limit.trim())){
    stringBuffer.append(TEXT_151);
    }else{
    stringBuffer.append(limit);
    }
    stringBuffer.append(TEXT_560);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_562);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_534);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_563);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_564);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_565);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_566);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_564);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_567);
    
		if(hasDynamic){
		
    stringBuffer.append(TEXT_568);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_570);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_571);
    
		}
		
    stringBuffer.append(TEXT_572);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_574);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_575);
    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_576);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_577);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_578);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_579);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_580);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_581);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_582);
    
			List< ? extends IConnection> conns = node.getOutgoingSortedConnections();

			String rejectConnName = "";
			List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
    		if(rejectConns != null && rejectConns.size() > 0) {
    			IConnection rejectConn = rejectConns.get(0);
    			rejectConnName = rejectConn.getName();
    		}
    		List<IMetadataColumn> rejectColumnList = null;
    		IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
    		if(metadataTable != null) {
    			 rejectColumnList = metadataTable.getListColumns();
    		}

    		if (conns!=null) {
    			if (conns.size()>0) {
    		    	for (int i=0;i<conns.size();i++) {
    		    		IConnection connTemp = conns.get(i);
    		    		if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_175);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_216);
    
    		    		}
    		    	}
    		    }
			}

			String firstConnName = "";
			if (conns!=null) {//TD1024
				if (conns.size()>0) {//TD528
					IConnection conn = conns.get(0);
    				firstConnName = conn.getName();
    				List<IMetadataColumn> listColumns = metadata.getListColumns();
    				int size = listColumns.size();
    				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//TD256
						generateCodeUtil.generateCode(dynamic_index,size,hasDynamic);
						
    stringBuffer.append(TEXT_583);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_584);
    
		if(hasDynamic && ("").equals(lastColumn.trim())){
		
    stringBuffer.append(TEXT_585);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_220);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_586);
    
		}
		
    stringBuffer.append(TEXT_587);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_588);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_589);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_590);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_591);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_592);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_593);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_594);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_595);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_596);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_597);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_598);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_599);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_600);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_601);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_602);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_603);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_601);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_604);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_601);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_605);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_601);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_606);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_607);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_608);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_609);
    
                		for (int i=0; i<size; i++) {//TD128
						IMetadataColumn column = listColumns.get(i);
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
						if(metadata.isDynamicSchema()){
						
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
						}else{
						
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_42);
    
						}
		if(!column.getTalendType().equals("id_Dynamic")){

    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_271);
    
		}

    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_484);
    
						if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_320);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_281);
    
						} else if(javaType == JavaTypesManager.DATE) {

    stringBuffer.append(TEXT_610);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_127);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_611);
     // for bug TDI-19404 
    stringBuffer.append(TEXT_290);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_612);
    
						}else if(JavaTypesManager.isNumberType(javaType)) {
							if(advancedSeparator) {

    stringBuffer.append(TEXT_320);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_293);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_127);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_127);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_128);
    
							} else {

    stringBuffer.append(TEXT_320);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_293);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    
							}
						} else if(javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(TEXT_320);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_295);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_21);
    
						}else if(column.getTalendType().equals("id_Dynamic")){
							dynamic_index = i;
			
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_613);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_510);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_511);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_512);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_305);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_306);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_513);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_514);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_309);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_305);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_306);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_614);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_516);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_517);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    
						} else {

    stringBuffer.append(TEXT_320);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_293);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_21);
    
						}
		if(!column.getTalendType().equals("id_Dynamic")){

    stringBuffer.append(TEXT_518);
    
						String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
						if(defaultValue == null) {

    stringBuffer.append(TEXT_519);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_318);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_319);
    
						} else {

    stringBuffer.append(TEXT_320);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_321);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_322);
    
						}

    stringBuffer.append(TEXT_520);
    
		}
					}//TD128

    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_324);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_325);
    }
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    log4jFileUtil.debugRetriveData(node);
    stringBuffer.append(TEXT_615);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    
		        if (dieOnError) {

    stringBuffer.append(TEXT_524);
    
		        }
		        else{
					if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {//15

    stringBuffer.append(TEXT_527);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_262);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_336);
    
						for(IMetadataColumn column : metadata.getListColumns()) {//16

    stringBuffer.append(TEXT_527);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_281);
    
					    }//16

    stringBuffer.append(TEXT_527);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_528);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_216);
    
					} else if(("").equals(rejectConnName)){

    stringBuffer.append(TEXT_529);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_216);
    
					} else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_527);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_341);
    
					}//15
				}

    stringBuffer.append(TEXT_616);
    
    				}//TD256
				}//TD528

        		if (conns.size()>0) {//TD64
        			boolean isFirstEnter = true;
        			for (int i=0;i<conns.size();i++) {
        				IConnection conn = conns.get(i);
        				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

    stringBuffer.append(TEXT_617);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_618);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_619);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_262);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_620);
    
        			    	 for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_621);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_281);
    
        				 	}
        				}
        			}

    stringBuffer.append(TEXT_617);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_351);
     } 
    
        		}//TD64

			}//TD1024

    stringBuffer.append(TEXT_326);
    
		}//end version judgement

    stringBuffer.append(TEXT_326);
    
	}
}
//
//end
    stringBuffer.append(TEXT_326);
    stringBuffer.append(TEXT_326);
    return stringBuffer.toString();
  }
}
