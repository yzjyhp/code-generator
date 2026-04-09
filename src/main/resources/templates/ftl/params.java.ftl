package ${package.Model};

<#list table.importModelPackages as pkg>
import ${pkg};
</#list>
<#if entityLombokModel>
import lombok.Data;
</#if>
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * <p>
 * ${table.comment}
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if entityLombokModel>
@Data
</#if>
@ApiModel(value = "${paramsModel}", description = "${table.comment}详情对象")
public class ${paramsModel} {

<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>
<#if field.comment!?length gt 0>
    @ApiModelProperty("${field.comment}")
</#if>
    private ${field.propertyType} ${field.propertyName};
</#list>

    @ApiModelProperty(value = "页码")
    private Integer current = 1;
    @ApiModelProperty(value = "每页数量")
    private Integer pageSize = 10;

}
