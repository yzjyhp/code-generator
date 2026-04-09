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
package com.yzjyhp.generator;

import com.yzjyhp.generator.config.DataSourceConfig;
import com.yzjyhp.generator.config.GlobalConfig;
import com.yzjyhp.generator.config.MyBatisPlusPackageVal;
import com.yzjyhp.generator.config.PackageConfig;
import com.yzjyhp.generator.config.StrategyConfig;
import com.yzjyhp.generator.config.converts.GeneratorStringUtils;
import com.yzjyhp.generator.config.rules.DbType;
import com.yzjyhp.generator.config.rules.NamingStrategy;
import com.yzjyhp.generator.engine.FreemarkerTemplateEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 自动生产文件-定制简化版本
 *
 * @author YangHu, tangguo, hubin
 * @since 2016-08-30
 */

public class QzdAutoGenerator {
    private static final Logger logger = LoggerFactory.getLogger(QzdAutoGenerator.class);

    /******通用配置信息************/
    /**
     * 生成文件的输出目录JAVA类地址
     */
    private String outputDir;

    /**
     * XML生成文件的输出目录（XML文档生成地址）
     */
    private String outputXmlDir;

    /**
     * Client生成文件的输出目录（@FeignClient类生成地址,为空不生成FeignClient）
     */
    private String outputClientDir;
    /**
     * 项目名称（@FeignClient类上应用名称）
     */
    private String applicationName;
    /**
     * 开发人员（类注释上面开发人员名称）
     */
    private String author;

    /**
     * 是否覆盖已有文件（true:覆盖旧文件）
     */
    private boolean fileOverride = false;
    /**
     * 开启 baseColumnList（XML类的通用属性--通用查询结果列）
     */
    private boolean baseColumnList = false;

    /**
     * 开启 BaseResultMap（XML类的通用属性--通用BaseResultMap结果列）
     */
    private boolean baseResultMap = true;

    /******MYSQL数据库信息************/
    /**
     * 驱动连接的URL（MYSQL地址）
     */
    private String url;

    /**
     * 数据库连接用户名（MYSQL账号）
     */
    private String username;
    /**
     * 数据库连接密码（MYSQL密码）
     */
    private String password;

    /******生成包信息************/
    /**
     * 父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
     */
    private String parent = "com.yzjyhp";

    /**
     * 父包模块名。
     */
    private String moduleName = null;

    /**
     * MyBatisPlus的版本。
     */
    private int myBatisPlusVersion = 2;

    /******需要生成代码的表信息信息************/
    /**
     * 需要包含的表名（与exclude二选一配置）
     */
    private String[] include = null;

    /**
     * 需要排除的表名
     */
    private String[] exclude = null;
    /**
     * 表前缀
     */
    private String[] tablePrefix;

    // 构造器尽量缩小范围
    private QzdAutoGenerator() {
    }

    public String getOutputDir() {
        return outputDir;
    }

    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }

    public String getOutputXmlDir() {
        return outputXmlDir;
    }

    public void setOutputXmlDir(String outputXmlDir) {
        this.outputXmlDir = outputXmlDir;
    }

    public String getOutputClientDir() {
        return outputClientDir;
    }

    public void setOutputClientDir(String outputClientDir) {
        this.outputClientDir = outputClientDir;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isFileOverride() {
        return fileOverride;
    }

    public void setFileOverride(boolean fileOverride) {
        this.fileOverride = fileOverride;
    }

    public boolean isBaseColumnList() {
        return baseColumnList;
    }

    public void setBaseColumnList(boolean baseColumnList) {
        this.baseColumnList = baseColumnList;
    }

    public boolean isBaseResultMap() {
        return baseResultMap;
    }

    public void setBaseResultMap(boolean baseResultMap) {
        this.baseResultMap = baseResultMap;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public int getMyBatisPlusVersion() {
        return myBatisPlusVersion;
    }

    public void setMyBatisPlusVersion(int myBatisPlusVersion) {
        this.myBatisPlusVersion = myBatisPlusVersion;
    }

    public String[] getInclude() {
        return include;
    }

    public void setInclude(String[] include) {
        this.include = include;
    }

    public String[] getExclude() {
        return exclude;
    }

    public void setExclude(String[] exclude) {
        this.exclude = exclude;
    }

    public String[] getTablePrefix() {
        return tablePrefix;
    }

    public void setTablePrefix(String[] tablePrefix) {
        this.tablePrefix = tablePrefix;
    }

    private AutoGenerator mpg;

    /**
     * 初始化配置数据数据
     */
    public QzdAutoGenerator init() {
        //1、代码生成器
        mpg = new AutoGenerator();
        //2、全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setMyBatisPlusVersion(myBatisPlusVersion);
        MyBatisPlusPackageVal.setV3(myBatisPlusVersion == 3);
        String projectPath = System.getProperty("user.dir");
        //生成文件的输出目录(判断是否是磁盘路径)
        if (GeneratorStringUtils.isNotEmpty(outputDir) && outputDir.contains(":")) {
            gc.setOutputDir(outputDir);
        } else {
            gc.setOutputDir(projectPath + outputDir);
        }
        if (GeneratorStringUtils.isNotEmpty(outputXmlDir) && outputXmlDir.contains(":")) {
            gc.setOutputXmlDir(outputXmlDir);
        } else {
            gc.setOutputXmlDir(projectPath + outputXmlDir);
        }
        if (GeneratorStringUtils.isNotEmpty(outputClientDir)) {
            if (outputClientDir.contains(":")) {
                gc.setOutputClientDir(outputClientDir);
            } else {
                gc.setOutputClientDir(projectPath + outputClientDir);
            }
        }
        gc.setApplicationName(applicationName);
        //开发人
        gc.setAuthor(author);
        //是否打开输出目录
        gc.setOpen(false);
        //是否覆盖已有文件，默认false
        gc.setFileOverride(fileOverride);
        //mapper.xml中生成通用查询结果列
        gc.setBaseColumnList(baseColumnList);
        //mapper.xml中生成通用查询映射结果
        gc.setBaseResultMap(baseResultMap);
        //设置Controller、Mapper、mapper.xml等命名方式，使用默认即可。
        gc.setServiceName("%sService");
        mpg.setGlobalConfig(gc);

        //3、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(url);
        //数据库驱动
        dsc.setDriverName("com.mysql.jdbc.Driver");
        //数据库连接用户名
        dsc.setUsername(username);
        //数据库连接密码
        dsc.setPassword(password);
        //数据库类型是mysql
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        //4、包配置
        PackageConfig pc = new PackageConfig();
        //父包名 springboot.mybatisplus
        pc.setParent(parent);
        //父包模块名 springboot.mybatisplus.student
        pc.setModuleName(moduleName);
        mpg.setPackageInfo(pc);

        //5、策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setEntityBuilderModel(true);
        //数据库表映射到实体的命名策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperMapperClass(MyBatisPlusPackageVal.BaseMapper());
        strategy.setSuperServiceClass(MyBatisPlusPackageVal.IService());
        strategy.setSuperServiceImplClass(MyBatisPlusPackageVal.ServiceImpl());


        //需要包含的表名，允许正则表达式，要生成哪个表的，就改动下面这行，比如，这里生成student这个表的
        strategy.setInclude(include);
        strategy.setExclude(exclude);
        //表前缀
        strategy.setTablePrefix(tablePrefix);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        return this;
    }

    /**
     * 执行生成代码
     */
    public void execute() {
        //6、执行
        mpg.execute();
    }

    /**
     * 构建对象
     */
    public static class Builder {
        private QzdAutoGenerator target;

        public Builder() {
            target = new QzdAutoGenerator();
        }

        public Builder outputDir(String outputDir) {
            target.outputDir = outputDir;
            return this;
        }

        public Builder outputXmlDir(String outputXmlDir) {
            target.outputXmlDir = outputXmlDir;
            return this;
        }

        public Builder outputClientDir(String outputClientDir) {
            target.outputClientDir = outputClientDir;
            return this;
        }

        public Builder applicationName(String applicationName) {
            target.applicationName = applicationName;
            return this;
        }

        public Builder author(String author) {
            target.author = author;
            return this;
        }

        public Builder fileOverride(boolean fileOverride) {
            target.fileOverride = fileOverride;
            return this;
        }

        public Builder baseColumnList(boolean baseColumnList) {
            target.baseColumnList = baseColumnList;
            return this;
        }

        public Builder baseResultMap(boolean baseResultMap) {
            target.baseResultMap = baseResultMap;
            return this;
        }

        public Builder myBatisPlusVersion(int myBatisPlusVersion) {
            target.myBatisPlusVersion = myBatisPlusVersion;
            return this;
        }

        public Builder url(String url) {
            target.url = url;
            return this;
        }

        public Builder username(String username) {
            target.username = username;
            return this;
        }

        public Builder password(String password) {
            target.password = password;
            return this;
        }

        public Builder parent(String parent) {
            target.parent = parent;
            return this;
        }

        public Builder moduleName(String moduleName) {
            target.moduleName = moduleName;
            return this;
        }

        public Builder include(String... include) {
            target.include = include;
            return this;
        }

        public Builder exclude(String... exclude) {
            target.exclude = exclude;
            return this;
        }

        public Builder tablePrefix(String... tablePrefix) {
            target.tablePrefix = tablePrefix;
            return this;
        }

        public QzdAutoGenerator build() {
            return target;
        }
    }

}
