package ${package.Mapper};

import ${package.Entity}.${entity};
import ${package.Params}.${paramsModel};
import ${superMapperClassPackage};
import org.springframework.stereotype.Repository;
<#list mapperClassPackage as pkg>
import ${pkg};
</#list>

import java.util.List;

/**
 * <p>
 * ${table.comment} Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Repository
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {

  /**
  * ${table.comment}列表查询
  * @param params
  * @return
  */
  List<${entity}> searchList(@Param("page") Page page, @Param("params") ${paramsModel} params);

 }
