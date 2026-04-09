package ${package.Client};

import ${package.Params}.${paramsModel};
import ${package.Model}.${entityModel};
import ${package.Model}.${detailModel};
import ${package.Model}.${addParamsModel};
import org.springframework.cloud.openfeign.FeignClient;
import com.qizhidao.common.base.response.ResponseString;
import com.qizhidao.common.base.response.ResponseSingleObjectModel;
import com.qizhidao.common.base.response.ResponsePageModel;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * ${table.comment}
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@FeignClient(name = "${package.ApplicationName}", path = "/${controllerMappingPath}/")
public interface ${table.client} {

    /**
    * ${table.comment}添加或者更新
    * @param params
    * @return
    */
    @RequestMapping(value = "/addOrUpdate", method = RequestMethod.POST)
    ResponseString addOrUpdate(@RequestBody ${addParamsModel} params);

    /**
    * ${table.comment}-查询某条数据
    * @param id
    * @return
    */
    @RequestMapping(value = "/getEntityById", method = RequestMethod.POST)
    ResponseSingleObjectModel<${detailModel}> getEntityById(@RequestParam("id") ${keyFlagType} id);

    /**
    * ${table.comment}-删除某条数据
    * @param id
    * @return
    */
    @ApiOperation(value = "${table.comment}删除某条数据", notes = "${table.comment}删除某条数据")
    @RequestMapping(value = "/delEntityById", method = RequestMethod.POST)
    ResponseString delEntityById(@RequestParam("id") ${keyFlagType} id);

    /**
    * ${table.comment}列表查询
    * @param params
    * @return
    */
    @RequestMapping(value = "/searchList", method = RequestMethod.POST)
    ResponsePageModel<${entityModel}> searchList(@RequestBody ${paramsModel} params);
}
