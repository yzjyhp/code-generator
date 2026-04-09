package ${package.Service};

import ${package.Entity}.${entity};
import ${package.Params}.${paramsModel};
import ${package.Model}.${entityModel};
import ${package.Model}.${detailModel};
import ${package.Model}.${addParamsModel};
import ${superServiceClassPackage};
<#list serviceClassPackage as pkg>
    import ${pkg};
</#list>
import com.yzjyhp.common.base.response.ResponseSingleObjectModel;
import com.yzjyhp.common.base.response.ResponsePageModel;
import com.yzjyhp.common.base.response.ResponseString;

/**
 * <p>
 * ${table.comment} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

    /**
    * ${table.comment}添加或者更新
    * @param params
    * @return
    */
    ResponseString addOrUpdate(${addParamsModel} params);


    /**
    * ${table.comment}-查询某条数据
    * @param id
    * @return
    */
    ResponseSingleObjectModel<${detailModel}> getEntityById(${keyFlagType} id);

    /**
    * ${table.comment}-删除某条数据
    * @param id
    * @return
    */
    ResponseString delEntityById(${keyFlagType} id);


    /**
    * ${table.comment}列表查询
    * @param params
    * @return
    */
    ResponsePageModel<${entityModel}> searchList(${paramsModel} params);

}
