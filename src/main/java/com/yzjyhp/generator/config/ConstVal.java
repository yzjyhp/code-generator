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

import java.nio.charset.StandardCharsets;

/**
 * 定义常量
 *
 * @author YangHu, tangguo
 * @since 2016/8/31
 */
public class ConstVal {

    public static final String APPLICATIONNAME = "ApplicationName";
    public static final String MODULENAME = "ModuleName";

    public static final String ENTITY = "Entity";
    public static final String MODEL = "Model";
    public static final String PARAMS = "Params";
    public static final String ADD_PARAMS = "AddOrUpdate";
    public static final String DETAIL = "DetailModel";
    public static final String CLIENT = "Client";
    public static final String SERIVCE = "Service";
    public static final String SERVICEIMPL = "ServiceImpl";
    public static final String MAPPER = "Mapper";
    public static final String XML = "Xml";
    public static final String CONTROLLER = "Controller";

    public static final String ENTITY_PATH = "entity_path";
    public static final String ENTITY_MODEL_PATH = "entity_model_path";
    public static final String PARAMS_MODEL_PATH = "params_model_path";
    public static final String ADD_PARAMS_MODEL_PATH = "add_params_model_path";
    public static final String DETAIL_MODEL_PATH = "detail_model_path";
    public static final String CLIENT_PATH = "client_path";
    public static final String SERIVCE_PATH = "serivce_path";
    public static final String SERVICEIMPL_PATH = "serviceimpl_path";
    public static final String MAPPER_PATH = "mapper_path";
    public static final String XML_PATH = "xml_path";
    public static final String CONTROLLER_PATH = "controller_path";

    public static final String JAVA_TMPDIR = "java.io.tmpdir";
    public static final String UTF8 = StandardCharsets.UTF_8.name();
    public static final String UNDERLINE = "_";

    public static final String JAVA_SUFFIX = ".java";
    public static final String XML_SUFFIX = ".xml";

    public static final String TEMPLATE_ENTITY_JAVA = "/templates/ftl/entity.java";
    public static final String TEMPLATE_ENTITY_MODEL = "/templates/ftl/model.java";
    public static final String TEMPLATE_PARAMS_MODEL = "/templates/ftl/params.java";
    public static final String TEMPLATE_ADDPARAMS_MODEL = "/templates/ftl/addParams.java";
    public static final String TEMPLATE_DETAIL_MODEL = "/templates/ftl/detail.java";
    public static final String TEMPLATE_CLIENT = "/templates/ftl/client.java";
    public static final String TEMPLATE_MAPPER = "/templates/ftl/mapper.java";
    public static final String TEMPLATE_XML = "/templates/ftl/mapper.xml";
    public static final String TEMPLATE_SERVICE = "/templates/ftl/service.java";
    public static final String TEMPLATE_SERVICEIMPL = "/templates/ftl/serviceImpl.java";
    public static final String TEMPLATE_CONTROLLER = "/templates/ftl/controller.java";

}
