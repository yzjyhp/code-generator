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
@ApiModel(value = "${addParamsModel}", description = "${table.comment}详情对象")
public class ${addParamsModel} {

<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>
<#if field.comment!?length gt 0>
    @ApiModelProperty("${field.comment}")
</#if>
    private ${field.propertyType} ${field.propertyName};
</#list>

}
