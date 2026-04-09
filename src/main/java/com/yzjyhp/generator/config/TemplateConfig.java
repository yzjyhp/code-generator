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

/**
 * <p>
 * 模板路径配置项
 * </p>
 *
 * @author tzg hubin
 * @since 2017-06-17
 */
public class TemplateConfig {

    private String entity = ConstVal.TEMPLATE_ENTITY_JAVA;
    private String entityModel = ConstVal.TEMPLATE_ENTITY_MODEL;
    private String paramsModel = ConstVal.TEMPLATE_PARAMS_MODEL;
    private String addParamsModel = ConstVal.TEMPLATE_ADDPARAMS_MODEL;
    private String detailModel = ConstVal.TEMPLATE_DETAIL_MODEL;
    private String client = ConstVal.TEMPLATE_CLIENT;

    private String service = ConstVal.TEMPLATE_SERVICE;

    private String serviceImpl = ConstVal.TEMPLATE_SERVICEIMPL;

    private String mapper = ConstVal.TEMPLATE_MAPPER;

    private String xml = ConstVal.TEMPLATE_XML;

    private String controller = ConstVal.TEMPLATE_CONTROLLER;

    public String getEntity() {
        return entity;
    }

    public TemplateConfig setEntity(String entity) {
        this.entity = entity;
        return this;
    }

    public String getService() {
        return service;
    }

    public TemplateConfig setService(String service) {
        this.service = service;
        return this;
    }

    public String getServiceImpl() {
        return serviceImpl;
    }

    public TemplateConfig setServiceImpl(String serviceImpl) {
        this.serviceImpl = serviceImpl;
        return this;
    }

    public String getEntityModel() {
        return entityModel;
    }

    public void setEntityModel(String entityModel) {
        this.entityModel = entityModel;
    }

    public String getParamsModel() {
        return paramsModel;
    }

    public void setParamsModel(String paramsModel) {
        this.paramsModel = paramsModel;
    }

    public String getAddParamsModel() {
        return addParamsModel;
    }

    public void setAddParamsModel(String addParamsModel) {
        this.addParamsModel = addParamsModel;
    }

    public String getDetailModel() {
        return detailModel;
    }

    public void setDetailModel(String detailModel) {
        this.detailModel = detailModel;
    }

    public String getMapper() {
        return mapper;
    }

    public TemplateConfig setMapper(String mapper) {
        this.mapper = mapper;
        return this;
    }

    public String getXml() {
        return xml;
    }

    public TemplateConfig setXml(String xml) {
        this.xml = xml;
        return this;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getController() {
        return controller;
    }

    public TemplateConfig setController(String controller) {
        this.controller = controller;
        return this;
    }

}
