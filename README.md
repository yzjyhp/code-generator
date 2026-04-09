自动生成代码
======================

## 声明
该项目来源于MyBatis-Plus的代码生成项目[mybatis-plus-generator](https://github.com/baomidou/mybatis-plus/tree/3.0/mybatis-plus-generator)进行改造

## 维护者
yzjyhp

## 生成平台风格代码
会生成信息： <br/>
1.对应的controller、service、serviceImpl、entity、Mapper、xml <br/>
2.会初始化生成如下方法： <br/>
addOrUpdate: 添加或者更新 <br/>
delEntityById: 删除某条数据 <br/>
getEntityById: 通过主键ID查询某条数据 <br/>
searchList: 列表查询 <br/>


## 版本解释

### v1.0版本
设置MyBatisPlus的版本具体入参如下： <br/>
MyBatisPlus的版本为2.X设置如下 <br/>
.myBatisPlusVersion(2) <br/>

MyBatisPlus的版本为3.X设置如下<br/>
.myBatisPlusVersion(3) <br/>

### 项目引用如下

```java
    <dependency>
        <groupId>com.yzjyhp</groupId>
        <artifactId>code-generator</artifactId>
        <version>1.0.0-SNAPSHOT</version>
        <scope>test</scope>
    </dependency>

```

[可执行测试代码demo](/src/test/java/com/qizhidao/common/generator/QzdAutoGeneratorTest.java)
<br/>
### 可配置字段解释
outputDir：生成文件的输出目录JAVA类地址（磁盘路径：D:/wzqzd-sms-server/src/main/java） <br/>
outputXmlDir：XML生成文件的输出目录（XML文档生成地址）<br/>
outputClientDir：Client生成文件的输出目录（@FeignClient类生成地址）,当这个为空的时候controller不会加实现类<br/>
applicationName：项目名称（@FeignClient类上应用名称）<br/>
author：开发人员（类注释上面开发人员名称）<br/>
myBatisPlusVersion: MyBatisPlus的版本(当前只支持2或者3)<br/>

### 备注
具体信息，请执行下面的main进行详情查看<br/>

```java
/**
 * 生产代码demo
 *
 * @param args
 */
public static void main(String[] args) {
    new QzdAutoGenerator.Builder()
            //生成文件的输出目录JAVA类地址（磁盘路径：/my-project/my-project-server/src/main/java）
            .outputDir("/my-project/my-project-server/src/main/java")
            //XML生成文件的输出目录（XML文档生成地址）
            .outputXmlDir("/my-project/my-project-server/src/main/resources")
            //Client生成文件的输出目录（@FeignClient类生成地址）
            .outputClientDir("/my-project/my-project-api/src/main/java")
            //项目名称（@FeignClient类上应用名称）
            .applicationName("my-project")
            //开发人员（类注释上面开发人员名称）
            .author("yuan")
            //是否覆盖已有文件（true:覆盖旧文件）
            .fileOverride(true)
            //开启 baseColumnList（XML类的通用属性--通用查询结果列）
            .baseColumnList(true)
            //开启 BaseResultMap（XML类的通用属性--通用BaseResultMap结果列）
            .baseResultMap(true)
            .myBatisPlusVersion(2)
            //MYSQL地址
            .url("jdbc:mysql://127.0.0.1.net:3306/my_db?useUnicode=true&characterEncoding=UTF8&useSSL=false&allowMultiQueries=true&serverTimezone=GMT%2b8:00").username(
                    "root").password("123456")
            //父包名
            .parent("com.yzjyhp").moduleName("demo")
            .include(
                    "t_chain_product"

            ).tablePrefix("t_").build().init().execute();
}

```
