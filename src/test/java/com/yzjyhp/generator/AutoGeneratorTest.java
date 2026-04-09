package com.yzjyhp.generator;

/**
 * Description: 测试生产代码
 * Date: 2022/6/17 21:12
 *
 * @version 1.0.0
 * @author: yzjyhp
 */
public class AutoGeneratorTest {

    /**
     * 生产代码demo
     *
     * @param args
     */
    public static void main(String[] args) {
        new OutAutoGenerator.Builder()
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
                .url("jdbc:mysql://127.0.0.1:3306/my_db").username(
                        "root").password("123456")
                //父包名
                .parent("com.yzjyhp").moduleName("demo")
                .include(
                        "t_chain_product"

                ).tablePrefix("t_").build().init().execute();
    }
}
