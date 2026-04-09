package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${package.Params}.${paramsModel};
import ${package.Model}.${entityModel};
import ${package.Model}.${detailModel};
import ${package.Model}.${addParamsModel};
import ${superServiceImplClassPackage};
<#list serviceImplClassPackage as pkg>
import ${pkg};
</#list>
import com.alibaba.fastjson.JSON;
import com.yzjyhp.common.base.response.ResponseSingleObjectModel;
import com.yzjyhp.common.base.response.ResponseString;
import com.yzjyhp.common.base.response.ResponsePageModel;
import com.yzjyhp.common.utils.PageModelHelpUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
* <p>
* ${table.comment} 服务实现类
* </p>
*
* @author ${author}
* @since ${date}
*/
@Service
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
    * ${table.comment}添加或者更新
    * @param params
    * @return
    */
    @Override
    public ResponseString addOrUpdate(${addParamsModel} params){
        logger.info("addOrUpdate params:{}", JSON.toJSONString(params));
        if (params == null) {
            return ResponseString.error("入参不为空");
        }
        ${keyFlagType} id=${keyFlagGet}
        ${entity} entity = new ${entity}();
        BeanUtils.copyProperties(params, entity);
        ${entity} old = baseMapper.selectById(id);
        if (old == null) {
            if(insert(entity)){
                return ResponseString.success("新增数据成功");
            }else{
                return ResponseString.error("新增数据失败");
            }
        } else {
            BeanUtils.copyProperties(params, old);
            if(updateById(old)){
                return ResponseString.success("更新数据成功");
            }else{
                return ResponseString.error("更新数据失败");
            }
        }
    }


    /**
    * ${table.comment}-查询某条数据
    * @param id
    * @return
    */
    @Override
    public ResponseSingleObjectModel<${detailModel}> getEntityById(${keyFlagType} id){
        logger.info("getEntityById id:{}", id);
        if (id == null) {
            return ResponseSingleObjectModel.error("入参不为空");
        }
        ${entity} old = selectById(id);
        if (old == null) {
            return ResponseSingleObjectModel.error("找不到数据信息");
        }
        ${detailModel} model = new ${detailModel}();
        BeanUtils.copyProperties(old, model);
        return ResponseSingleObjectModel.success(model);
    }


    /**
    * ${table.comment}-删除某条数据
    * @param id
    * @return
    */
    @Override
    public ResponseString delEntityById(${keyFlagType} id){
        logger.info("delEntityById id:{}", id);
        if (id == null) {
            return ResponseString.error("入参不为空");
        }
        ${entity} old = selectById(id);
        if (old == null) {
            return ResponseString.error("找不到数据信息");
        }
        if(deleteById(id)){
            return ResponseString.success("删除数据成功");
        }else{
            return ResponseString.error("删除数据失败");
        }
    }

    /**
    * ${table.comment}列表查询
    * @param params
    * @return
    */
    @Override
    public ResponsePageModel<${entityModel}> searchList(${paramsModel} params) {
        logger.info("searchList params:{}", JSON.toJSONString(params));
        if (params == null) {
            return ResponsePageModel.error("入参不为空");
        }
        Integer current = params.getCurrent();
        Integer pageSize = params.getPageSize();
        if (current == null || current <= 0) {
            current = 1;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 10;
        }
        Page<${entity}> page = new Page<>(current, pageSize);
        List<${entity}> result = baseMapper.searchList(page, params);
        List<${entityModel}> models = new ArrayList<>();
        if (result != null && !result.isEmpty()) {
            ${entityModel} model = null;
            for (int kt = 0; kt < result.size(); kt++) {
                ${entity} entity = result.get(kt);
                if (entity != null) {
                    model = new ${entityModel}();
                    BeanUtils.copyProperties(entity, model);
                    models.add(model);
                }
            }
        }
        return ResponsePageModel.success(PageModelHelpUtil.builder(page, models));
    }
}
