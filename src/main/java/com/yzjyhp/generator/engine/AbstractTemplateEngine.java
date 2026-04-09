/**
 * Copyright (c) 2011-2020, hubin (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.yzjyhp.generator.engine;

import com.yzjyhp.generator.config.ConstVal;
import com.yzjyhp.generator.config.FileOutConfig;
import com.yzjyhp.generator.config.GlobalConfig;
import com.yzjyhp.generator.config.TemplateConfig;
import com.yzjyhp.generator.config.builder.ConfigBuilder;
import com.yzjyhp.generator.config.converts.GeneratorStringUtils;
import com.yzjyhp.generator.config.po.TableField;
import com.yzjyhp.generator.config.po.TableInfo;
import com.yzjyhp.generator.config.rules.NamingStrategy;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * 模板引擎抽象类
 * </p>
 *
 * @author hubin
 * @since 2018-01-10
 */
public abstract class AbstractTemplateEngine {

    protected static final Logger logger = LoggerFactory.getLogger(AbstractTemplateEngine.class);
    /**
     * 配置信息
     */
    private ConfigBuilder configBuilder;


    /**
     * <p>
     * 模板引擎初始化
     * </p>
     */
    public AbstractTemplateEngine init(ConfigBuilder configBuilder) {
        this.configBuilder = configBuilder;
        return this;
    }


    /**
     * <p>
     * 输出 java xml 文件
     * </p>
     */
    public AbstractTemplateEngine batchOutput() {
        try {
            List<TableInfo> tableInfoList = this.getConfigBuilder().getTableInfoList();
            for (TableInfo tableInfo : tableInfoList) {
                Map<String, Object> objectMap = this.getObjectMap(tableInfo);
                Map<String, String> pathInfo = this.getConfigBuilder().getPathInfo();
                TemplateConfig template = this.getConfigBuilder().getTemplate();
                // Mp.java
                String entityName = tableInfo.getEntityName();
                if (null != entityName) {
                    String entityFile = String.format((pathInfo.get(ConstVal.ENTITY_PATH) + File.separator + "%s" + this.suffixJavaOrKt()), entityName);
                    if (this.isCreate(entityFile)) {
                        this.writer(objectMap, this.templateFilePath(template.getEntity()), entityFile);
                    }
                }
                // MpMapper.java
                if (null != tableInfo.getMapperName()) {
                    String mapperFile = String.format((pathInfo.get(ConstVal.MAPPER_PATH) + File.separator + tableInfo.getMapperName() + this.suffixJavaOrKt()), entityName);
                    if (this.isCreate(mapperFile)) {
                        this.writer(objectMap, this.templateFilePath(template.getMapper()), mapperFile);
                    }
                }
                // MpMapper.xml
                if (null != tableInfo.getXmlName()) {
                    String xmlFile = String.format((pathInfo.get(ConstVal.XML_PATH) + File.separator + tableInfo.getXmlName() + ConstVal.XML_SUFFIX), entityName);
                    if (this.isCreate(xmlFile)) {
                        this.writer(objectMap, this.templateFilePath(template.getXml()), xmlFile);
                    }
                }
                // IMpService.java
                if (null != tableInfo.getServiceName()) {
                    String serviceFile = String.format((pathInfo.get(ConstVal.SERIVCE_PATH) + File.separator + tableInfo.getServiceName() + this.suffixJavaOrKt()), entityName);
                    if (this.isCreate(serviceFile)) {
                        this.writer(objectMap, this.templateFilePath(template.getService()), serviceFile);
                    }
                }
                // MpServiceImpl.java
                if (null != tableInfo.getServiceImplName()) {
                    String implFile = String.format((pathInfo.get(ConstVal.SERVICEIMPL_PATH) + File.separator + tableInfo.getServiceImplName() + this.suffixJavaOrKt()), entityName);
                    if (this.isCreate(implFile)) {
                        this.writer(objectMap, this.templateFilePath(template.getServiceImpl()), implFile);
                    }
                }
                // MpController.java
                if (null != tableInfo.getControllerName()) {
                    String controllerFile = String.format((pathInfo.get(ConstVal.CONTROLLER_PATH) + File.separator + tableInfo.getControllerName() + this.suffixJavaOrKt()), entityName);
                    if (this.isCreate(controllerFile)) {
                        this.writer(objectMap, this.templateFilePath(template.getController()), controllerFile);
                    }
                }
                // Model.java
                String entityModel = tableInfo.getEntityModel();
                if (null != entityModel) {
                    String entityFile = String.format((pathInfo.get(ConstVal.ENTITY_MODEL_PATH) + File.separator + "%s" + this.suffixJavaOrKt()), entityModel);
                    if (this.isCreate(entityFile)) {
                        this.writer(objectMap, this.templateFilePath(template.getEntityModel()), entityFile);
                    }
                }
                // Params.java
                String paramsModel = tableInfo.getParamsModel();
                if (null != paramsModel) {
                    String entityFile = String.format((pathInfo.get(ConstVal.PARAMS_MODEL_PATH) + File.separator + "%s" + this.suffixJavaOrKt()), paramsModel);
                    if (this.isCreate(entityFile)) {
                        this.writer(objectMap, this.templateFilePath(template.getParamsModel()), entityFile);
                    }
                }
                // AddParams.java
                String addParamsModel = tableInfo.getAddParamsModel();
                if (null != addParamsModel) {
                    //备注使用
                    String entityFile = String.format((pathInfo.get(ConstVal.ADD_PARAMS_MODEL_PATH) + File.separator + "%s" + this.suffixJavaOrKt()), addParamsModel);
                    if (this.isCreate(entityFile)) {
                        this.writer(objectMap, this.templateFilePath(template.getAddParamsModel()), entityFile);
                    }
                }
                // Detail.java
                String detailModel = tableInfo.getDetailModel();
                if (null != detailModel) {
                    String entityFile = String.format((pathInfo.get(ConstVal.DETAIL_MODEL_PATH) + File.separator + "%s" + this.suffixJavaOrKt()), detailModel);
                    if (this.isCreate(entityFile)) {
                        this.writer(objectMap, this.templateFilePath(template.getDetailModel()), entityFile);
                    }
                }
                // client.java
                String client = tableInfo.getClient();
                if (null != client) {
                    String path = pathInfo.get(ConstVal.CLIENT_PATH);
                    if (GeneratorStringUtils.isNotEmpty(path)) {
                        String entityFile = String.format((path + File.separator + "%s" + this.suffixJavaOrKt()), client);
                        if (this.isCreate(entityFile)) {
                            this.writer(objectMap, this.templateFilePath(template.getClient()), entityFile);
                        }
                    }
                }
                // 自定义内容
                if (null != this.getConfigBuilder().getInjectionConfig()) {
                    List<FileOutConfig> focList = this.getConfigBuilder().getInjectionConfig().getFileOutConfigList();
                    if (focList != null && !focList.isEmpty()) {
                        for (FileOutConfig foc : focList) {
                            if (this.isCreate(foc.outputFile(tableInfo))) {
                                this.writer(objectMap, foc.getTemplatePath(), foc.outputFile(tableInfo));
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.error("无法创建文件，请检查配置信息！", e);
        }
        return this;
    }


    /**
     * <p>
     * 将模板转化成为文件
     * </p>
     *
     * @param objectMap    渲染对象 MAP 信息
     * @param templatePath 模板文件
     * @param outputFile   文件生成的目录
     */
    public abstract void writer(Map<String, Object> objectMap, String templatePath, String outputFile) throws Exception;

    /**
     * <p>
     * 处理输出目录
     * </p>
     */
    public AbstractTemplateEngine mkdirs() {
        Map<String, String> pathInfo = this.getConfigBuilder().getPathInfo();
        for (Map.Entry<String, String> entry : pathInfo.entrySet()) {
            File dir = new File(entry.getValue());
            if (!dir.exists()) {
                boolean result = dir.mkdirs();
                if (result) {
                    logger.debug("创建目录： [" + entry.getValue() + "]");
                }
            }
        }
        return this;
    }


    /**
     * <p>
     * 打开输出目录
     * </p>
     */
    public void open() {
        if (this.getConfigBuilder().getGlobalConfig().isOpen()) {
            try {
                String osName = System.getProperty("os.name");
                if (osName != null) {
                    if (osName.contains("Mac")) {
                        Runtime.getRuntime().exec("open " + this.getConfigBuilder().getGlobalConfig().getOutputDir());
                    } else if (osName.contains("Windows")) {
                        Runtime.getRuntime().exec("cmd /c start " + this.getConfigBuilder().getGlobalConfig().getOutputDir());
                    } else {
                        logger.debug("文件输出目录:" + this.getConfigBuilder().getGlobalConfig().getOutputDir());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * <p>
     * 渲染对象 MAP 信息
     * </p>
     *
     * @param tableInfo 表信息对象
     * @return
     */
    public Map<String, Object> getObjectMap(TableInfo tableInfo) {
        Map<String, Object> objectMap = new HashMap<>();
        ConfigBuilder config = this.getConfigBuilder();
        if (config.getStrategyConfig().isControllerMappingHyphenStyle()) {
            objectMap.put("controllerMappingHyphenStyle", config.getStrategyConfig().isControllerMappingHyphenStyle());
            objectMap.put("controllerMappingHyphen", GeneratorStringUtils.camelToHyphen(tableInfo.getEntityPath()));
        }
        String controllerMappingPath = tableInfo.getName().replace("_", "/");
        objectMap.put("controllerMappingPath", controllerMappingPath);
        objectMap.put("restControllerStyle", config.getStrategyConfig().isRestControllerStyle());
        objectMap.put("package", config.getPackageInfo());
        GlobalConfig globalConfig = config.getGlobalConfig();
        objectMap.put("author", globalConfig.getAuthor());
        objectMap.put("idType", globalConfig.getIdType() == null ? null : globalConfig.getIdType().toString());
        objectMap.put("logicDeleteFieldName", config.getStrategyConfig().getLogicDeleteFieldName());
        objectMap.put("versionFieldName", config.getStrategyConfig().getVersionFieldName());
        objectMap.put("activeRecord", globalConfig.isActiveRecord());
        objectMap.put("kotlin", globalConfig.isKotlin());
        String outputClientDir=globalConfig.getOutputClientDir();
        if(StringUtils.isNotEmpty(outputClientDir)){
            objectMap.put("client", true);
        }else {
            objectMap.put("client", false);
        }

        objectMap.put("date", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        objectMap.put("table", tableInfo);
        objectMap.put("enableCache", globalConfig.isEnableCache());
        objectMap.put("baseResultMap", globalConfig.isBaseResultMap());
        objectMap.put("baseColumnList", globalConfig.isBaseColumnList());
        objectMap.put("entity", tableInfo.getEntityName());
        objectMap.put("entityModel", tableInfo.getEntityModel());
        objectMap.put("paramsModel", tableInfo.getParamsModel());
        objectMap.put("addParamsModel", tableInfo.getAddParamsModel());
        objectMap.put("detailModel", tableInfo.getDetailModel());
        List<String> paramsSql = new ArrayList<>();
        List<TableField> fields = tableInfo.getFields();
        String keyFlagGet = "";
        String keyFlagType = "";
        if (fields != null && !fields.isEmpty()) {
            String sql = "<if test=\"params.%s != null and params.%s != ''\">\n" +
                    "               and %s=#{params.%s}\n" +
                    "         </if>";
            String sql2 = "<if test=\"params.%s != null\">\n" +
                    "               and %s=#{params.%s}\n" +
                    "         </if>";
            for (TableField tableField : fields) {
                //主键查询舍弃
                if (tableField.isKeyFlag()) {
                    //获取主键的方法
                    keyFlagGet = "params.get" + NamingStrategy.capitalFirst(tableField.getPropertyName()) + "();";
                    keyFlagType = tableField.getPropertyType();
                    continue;
                }
                String name = tableField.getName();
                String propertyName = tableField.getPropertyName();
                String s = "";
                //文本类型
                if (tableField.getType().contains("varchar")
                        || tableField.getType().contains("text")
                        || tableField.getType().contains("blob")
                        || tableField.getType().contains("char")
                ) {
                    s = String.format(sql, propertyName, propertyName, name, propertyName);
                } else {
                    s = String.format(sql2, propertyName, name, propertyName);
                }
                paramsSql.add(s);
            }
        }
        objectMap.put("keyFlagType", keyFlagType);
        objectMap.put("keyFlagGet", keyFlagGet);
        objectMap.put("paramsSql", paramsSql);
        //生成serviceName的小写
        String serviceName = tableInfo.getServiceName();
        if (GeneratorStringUtils.isNotEmpty(serviceName)) {
            objectMap.put("serviceNameLower", NamingStrategy.capitalFirstLower(serviceName));
        }

        objectMap.put("entityColumnConstant", config.getStrategyConfig().isEntityColumnConstant());
        objectMap.put("entityBuilderModel", config.getStrategyConfig().isEntityBuilderModel());
        objectMap.put("entityLombokModel", config.getStrategyConfig().isEntityLombokModel());
        objectMap.put("entityBooleanColumnRemoveIsPrefix", config.getStrategyConfig().isEntityBooleanColumnRemoveIsPrefix());
        objectMap.put("superEntityClass", this.getSuperClassName(config.getSuperEntityClass()));
        objectMap.put("superMapperClassPackage", config.getSuperMapperClass());
        objectMap.put("superMapperClass", this.getSuperClassName(config.getSuperMapperClass()));
        objectMap.put("mapperClassPackage", config.getMapperClassPackage());
        objectMap.put("serviceClassPackage", config.getServiceClassPackage());
        objectMap.put("serviceImplClassPackage", config.getServiceImplClassPackage());
        objectMap.put("superServiceClassPackage", config.getSuperServiceClass());
        objectMap.put("superServiceClass", this.getSuperClassName(config.getSuperServiceClass()));
        objectMap.put("superServiceImplClassPackage", config.getSuperServiceImplClass());
        objectMap.put("superServiceImplClass", this.getSuperClassName(config.getSuperServiceImplClass()));
        objectMap.put("superControllerClassPackage", config.getSuperControllerClass());
        objectMap.put("superControllerClass", this.getSuperClassName(config.getSuperControllerClass()));
        return objectMap;
    }


    /**
     * 获取类名
     *
     * @param classPath
     * @return
     */
    private String getSuperClassName(String classPath) {
        if (GeneratorStringUtils.isEmpty(classPath)) {
            return null;
        }
        return classPath.substring(classPath.lastIndexOf(".") + 1);
    }


    /**
     * <p>
     * 模板真实文件路径
     * </p>
     *
     * @param filePath 文件路径
     * @return
     */
    public abstract String templateFilePath(String filePath);


    /**
     * 检测文件是否存在
     *
     * @return 是否
     */
    protected boolean isCreate(String filePath) {
        File file = new File(filePath);
        return !file.exists() || this.getConfigBuilder().getGlobalConfig().isFileOverride();
    }


    /**
     * 文件后缀
     */
    protected String suffixJavaOrKt() {
        return ConstVal.JAVA_SUFFIX;
    }


    public ConfigBuilder getConfigBuilder() {
        return configBuilder;
    }

    public AbstractTemplateEngine setConfigBuilder(ConfigBuilder configBuilder) {
        this.configBuilder = configBuilder;
        return this;
    }
}
