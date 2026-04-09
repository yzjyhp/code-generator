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
package com.yzjyhp.generator.config;

import com.yzjyhp.generator.config.rules.IdType;

/**
 * <p>
 * 全局配置
 * </p>
 *
 * @author hubin
 * @since 2016-12-02
 */
public class GlobalConfig {

    /**
     * 生成文件的输出目录【默认 D 盘根目录】
     */
    private String outputDir = "D://";

    /**
     * XML生成文件的输出目录【默认 D 盘根目录】
     */
    private String outputXmlDir = "D://";

    /**
     * Client生成文件的输出目录【为空不生成】
     */
    private String outputClientDir;

    /**
     * 项目名称
     */
    private String applicationName;
    /**
     * 是否覆盖已有文件
     */
    private boolean fileOverride = false;

    /**
     * 是否打开输出目录
     */
    private boolean open = true;

    /**
     * 是否在xml中添加二级缓存配置
     */
    private boolean enableCache = true;

    /**
     * 开发人员
     */
    private String author;

    /**
     * 开启 Kotlin 模式
     */
    private boolean kotlin = false;

    /**
     * 开启 ActiveRecord 模式
     */
    private boolean activeRecord = false;

    /**
     * 开启 BaseResultMap
     */
    private boolean baseResultMap = true;

    /**
     * 开启 baseColumnList
     */
    private boolean baseColumnList = false;
    /**
     * 各层文件名称方式，例如： %Action 生成 UserAction
     */
    private String mapperName;
    private String xmlName;
    private String serviceName;
    private String serviceImplName;
    private String controllerName;
    /**
     * 指定生成的主键的ID类型
     */
    private IdType idType;
    /**
     * MyBatisPlus的版本。
     */
    private int myBatisPlusVersion = 2;


    public GlobalConfig setIdType(IdType idType) {
        this.idType = idType;
        return this;
    }

    public IdType getIdType() {
        return idType;
    }

    public String getOutputDir() {
        return outputDir;
    }

    public GlobalConfig setOutputDir(String outputDir) {
        this.outputDir = outputDir;
        return this;
    }

    public String getOutputXmlDir() {
        return outputXmlDir;
    }

    public GlobalConfig setOutputXmlDir(String outputXmlDir) {
        this.outputXmlDir = outputXmlDir;
        return this;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public int getMyBatisPlusVersion() {
        return myBatisPlusVersion;
    }

    public void setMyBatisPlusVersion(int myBatisPlusVersion) {
        this.myBatisPlusVersion = myBatisPlusVersion;
    }

    public boolean isFileOverride() {
        return fileOverride;
    }

    public GlobalConfig setFileOverride(boolean fileOverride) {
        this.fileOverride = fileOverride;
        return this;
    }

    public boolean isOpen() {
        return open;
    }

    public GlobalConfig setOpen(boolean open) {
        this.open = open;
        return this;
    }

    public boolean isEnableCache() {
        return enableCache;
    }

    public GlobalConfig setEnableCache(boolean enableCache) {
        this.enableCache = enableCache;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public GlobalConfig setAuthor(String author) {
        this.author = author;
        return this;
    }

    public boolean isKotlin() {
        return kotlin;
    }


    public boolean isActiveRecord() {
        return activeRecord;
    }

    public GlobalConfig setActiveRecord(boolean activeRecord) {
        this.activeRecord = activeRecord;
        return this;
    }

    public boolean isBaseResultMap() {
        return baseResultMap;
    }

    public GlobalConfig setBaseResultMap(boolean baseResultMap) {
        this.baseResultMap = baseResultMap;
        return this;
    }

    public boolean isBaseColumnList() {
        return baseColumnList;
    }

    public GlobalConfig setBaseColumnList(boolean baseColumnList) {
        this.baseColumnList = baseColumnList;
        return this;
    }

    public String getMapperName() {
        return mapperName;
    }

    public GlobalConfig setMapperName(String mapperName) {
        this.mapperName = mapperName;
        return this;
    }

    public String getXmlName() {
        return xmlName;
    }

    public GlobalConfig setXmlName(String xmlName) {
        this.xmlName = xmlName;
        return this;
    }

    public String getOutputClientDir() {
        return outputClientDir;
    }

    public void setOutputClientDir(String outputClientDir) {
        this.outputClientDir = outputClientDir;
    }

    public String getServiceName() {
        return serviceName;
    }

    public GlobalConfig setServiceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    public String getServiceImplName() {
        return serviceImplName;
    }

    public GlobalConfig setServiceImplName(String serviceImplName) {
        this.serviceImplName = serviceImplName;
        return this;
    }

    public String getControllerName() {
        return controllerName;
    }

    public GlobalConfig setControllerName(String controllerName) {
        this.controllerName = controllerName;
        return this;
    }
}
