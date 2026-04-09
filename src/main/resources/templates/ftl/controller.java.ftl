package ${package.Controller};

import ${package.Client}.${table.client};
import ${package.Service}.${table.serviceName};
import ${package.Params}.${paramsModel};
import ${package.Model}.${entityModel};
import ${package.Model}.${detailModel};
import ${package.Model}.${addParamsModel};
import com.qizhidao.common.base.response.ResponseSingleObjectModel;
import com.qizhidao.common.base.response.ResponseString;
import io.swagger.annotations.Api;
import com.alibaba.fastjson.JSON;
import com.qizhidao.common.base.controller.BaseController;
import com.qizhidao.common.base.response.ResponsePageModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * ${table.comment} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@RestController
@RequestMapping("/${controllerMappingPath}/")
@Api(value = "/${controllerMappingPath}/", description = "${table.comment}", tags = {"${table.capitalFirstName}"})
public class ${table.controllerName} extends BaseController  implements ${table.client}{

    @Autowired
    private ${table.serviceName} ${serviceNameLower};

    /**
    * ${table.comment}添加或者更新
    * @param params
    * @return
    */
    @Override
    @ApiOperation(value = "${table.comment}添加或者更新", notes = "${table.comment}添加或者更新")
    @RequestMapping(value = "/addOrUpdate", method = RequestMethod.POST)
    public ResponseString addOrUpdate(@RequestBody ${addParamsModel} params) {
        logger.info("/${controllerMappingPath}/addOrUpdate params:{}", JSON.toJSONString(params));
        return ${serviceNameLower}.addOrUpdate(params);
    }

    /**
    * ${table.comment}-查询某条数据
    * @param id
    * @return
    */
    @Override
    @ApiOperation(value = "${table.comment}查询某条数据", notes = "${table.comment}查询某条数据")
    @RequestMapping(value = "/getEntityById", method = RequestMethod.POST)
    public ResponseSingleObjectModel<${detailModel}> getEntityById(@RequestParam("id") ${keyFlagType} id){
        logger.info("/${controllerMappingPath}/getEntityById id:{}", id);
        return ${serviceNameLower}.getEntityById(id);
    }

    /**
    * ${table.comment}-删除某条数据
    * @param id
    * @return
    */
    @Override
    @ApiOperation(value = "${table.comment}删除某条数据", notes = "${table.comment}删除某条数据")
    @RequestMapping(value = "/delEntityById", method = RequestMethod.POST)
    public ResponseString delEntityById(@RequestParam("id") ${keyFlagType} id){
        logger.info("/${controllerMappingPath}/delEntityById id:{}", id);
        return ${serviceNameLower}.delEntityById(id);
    }


    /**
    * ${table.comment}列表查询
    * @param params
    * @return
    */
    @Override
    @ApiOperation(value = "${table.comment}列表查询", notes = "${table.comment}列表查询")
    @RequestMapping(value = "/searchList", method = RequestMethod.POST)
    public ResponsePageModel<${entityModel}> searchList(@RequestBody ${paramsModel} params) {
        logger.info("/${controllerMappingPath}/searchList params:{}", JSON.toJSONString(params));
        return ${serviceNameLower}.searchList(params);
    }

}
