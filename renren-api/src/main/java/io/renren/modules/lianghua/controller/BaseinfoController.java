package io.renren.modules.lianghua.controller;

import io.renren.common.utils.Result;
import io.renren.modules.lianghua.dto.BaseinfoDTO;
import io.renren.modules.lianghua.dto.PeriodOrdersDTO;
import io.renren.modules.lianghua.entity.BaseinfoEntity;
import io.renren.modules.lianghua.entity.PeriodOrdersEntity;
import io.renren.modules.lianghua.service.BaseinfoService;
import io.renren.modules.lianghua.service.PeriodOrdersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;



/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-03-21
 */
@RestController
@RequestMapping("lianghua/baseinfo")
@Api(tags="获取交易的基本信息")
public class BaseinfoController {
    @Autowired
    private BaseinfoService baseinfoService;
    @Autowired
    private PeriodOrdersService periodOrdersService;

    @PostMapping("isPlacedInstId")
    @ApiOperation("查询最近一次的INSTID")
    public Result isPlacedInstId(@RequestBody Map<String,String> params){
        PeriodOrdersEntity entity= periodOrdersService.queryByInstId(params);
        if (entity!=null){
            Result r = new Result();
            r.setData(entity);
            r.error(1, "这个周期，此账号\n已经买过一次");
            return r;
        }
        else return new Result().ok("没有下过单，可下单");
    }
    @PostMapping("queryLastInstId")
    @ApiOperation("查询最近一次的INSTID")
    public Result queryLastInstId(@RequestBody Map<String,String> params){
        List<BaseinfoEntity> result=  baseinfoService.queryAll(params.get("account"));
        return new Result().ok(result);
    }
    @PostMapping("updateLastInstId")
    @ApiOperation("更新最近一次的INSTID")
    public Result updateLastInstId(@RequestBody Map<String,String> params){
        List<BaseinfoEntity> result=  baseinfoService.queryAll(params.get("account"));
        PeriodOrdersEntity entity_= periodOrdersService.queryByInstId(params);
        if (entity_==null){
            PeriodOrdersDTO dto=new PeriodOrdersDTO();
            dto.setInstId(params.get("instId"));
            dto.setAccount(params.get("account"));
            periodOrdersService.save(dto);
        }
//        第一次下单，执行插入操作
        if (result.size()==0){
            BaseinfoDTO dto=new BaseinfoDTO();
            dto.setLastOrderInst(params.get("instId"));
            dto.setAccount(params.get("account"));
            dto.setOriginCount(Integer.valueOf(params.get("originCount")));
            dto.setLastFirstInst(params.get("lastFirstInst"));
            baseinfoService.save(dto);
            return new Result().ok(params.get("instId")+"插入成功");
        }
        BaseinfoEntity entity=result.get(0);
        BaseinfoDTO dto=new BaseinfoDTO();
        dto.setId(entity.getId());
        dto.setLastGridInst(entity.getLastGridInst());
        dto.setLastOrderInst(params.get("instId"));
        dto.setAccount(entity.getAccount());
        dto.setOriginCount(entity.getOriginCount());
        if(params.get("lastFirstInst").equals("add_orders"))dto.setLastFirstInst(entity.getLastFirstInst());
        else dto.setLastFirstInst(params.get("lastFirstInst"));

        baseinfoService.update(dto);
        return new Result();
    }

}