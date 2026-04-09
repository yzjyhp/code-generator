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


import com.yzjyhp.generator.config.converts.GeneratorStringUtils;

/**
 * <p>
 * 跟包相关的配置项
 *
 * @author YangHu, tangguo, hubin
 * @since 2016-08-30
 */
public class PackageConfig {

    /**
     * 父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
     */
    private String parent = "com.yzjyhp";

    /**
     * 父包模块名。
     */
    private String moduleName = null;

    /**
     * Entity包名
     */
    private String entity = "entity";
    /**
     * vo包名
     */
    private String vo = "vo";
    /**
     * Service包名
     */
    private String service = "service";

    /**
     * Service Impl包名
     */
    private String serviceImpl = "service.impl";
    /**
     * Mapper包名
     */
    private String mapper = "mapper";

    /**
     * Mapper XML包名(废弃，使用GlobalConfig的outputXmlDir输出xml到指定位置)
     */
    @Deprecated
    private String xml = "mapper.xml";

    /**
     * Controller包名
     */
    private String controller = "controller";

    /**
     * vo包名
     */
    private String client = "client";

    public String getParent() {
        if (GeneratorStringUtils.isNotEmpty(moduleName)) {
            return parent + "." + moduleName;
        }
        return parent;
    }

    public PackageConfig setParent(String parent) {
        this.parent = parent;
        return this;
    }

    public String getModuleName() {
        return moduleName;
    }

    public PackageConfig setModuleName(String moduleName) {
        this.moduleName = moduleName;
        return this;
    }

    public String getEntity() {
        return entity;
    }

    public PackageConfig setEntity(String entity) {
        this.entity = entity;
        return this;
    }

    public String getVo() {
        return vo;
    }

    public void setVo(String vo) {
        this.vo = vo;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getService() {
        return service;
    }

    public PackageConfig setService(String service) {
        this.service = service;
        return this;
    }

    public String getServiceImpl() {
        return serviceImpl;
    }

    public PackageConfig setServiceImpl(String serviceImpl) {
        this.serviceImpl = serviceImpl;
        return this;
    }

    public String getMapper() {
        return mapper;
    }

    public PackageConfig setMapper(String mapper) {
        this.mapper = mapper;
        return this;
    }

    public String getXml() {
        return xml;
    }

    public PackageConfig setXml(String xml) {
        this.xml = xml;
        return this;
    }

    public String getController() {
        if (GeneratorStringUtils.isEmpty(controller)) {
            return "web";
        }
        return controller;
    }

    public PackageConfig setController(String controller) {
        this.controller = controller;
        return this;
    }

}
