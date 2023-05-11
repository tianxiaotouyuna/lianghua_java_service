package io.renren.modules.lianghua.controller;

import io.renren.common.utils.Result;
import io.renren.modules.lianghua.dto.PeriodDTO;
import io.renren.modules.lianghua.entity.PeriodEntity;
import io.renren.modules.lianghua.service.BaseinfoService;
import io.renren.modules.lianghua.service.PeriodOrdersService;
import io.renren.modules.lianghua.service.PeriodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;


/**
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-03-21
 */
@RestController
@RequestMapping("lianghua/period")
@Api(tags = "")
public class PeriodController {
    @Autowired
    private PeriodService periodService;
    @Autowired
    private PeriodOrdersService periodOrdersService;
    @Autowired
    private BaseinfoService baseinfoService;


    @PostMapping("insertLongtou")
    @ApiOperation("添加新龙头")
    public Result insertLongtou(@RequestBody Map<String, String> params) {

        List<PeriodEntity> result = periodService.queryAll(params.get("account"));

        if (result.size() > 0) {
            PeriodEntity entity = result.get(0);
            Long endTime = Long.valueOf(entity.getSub2EndTime());
            long nowTime = System.currentTimeMillis();
            if (nowTime < endTime) return new Result().error(1, "第二utc操作周期，时间没结束，\n不算新周期");
            else
                periodService.deleteAll();
            periodService.insertLongtou(params);
            return new Result();
        } else
            periodService.insertLongtou(params);
        return new Result();
    }

    @PostMapping("updatePeriod")
    @ApiOperation("更新龙头")
    public Result updatePeriod(@RequestBody Map<String, String> params) throws InvocationTargetException, IllegalAccessException {

        List<PeriodEntity> result = periodService.queryAll(params.get("account"));
        PeriodEntity entity = result.get(0);
        //根据当前时间戳，计算所属utc周期
        long timestamp = System.currentTimeMillis();
        if (timestamp < Long.valueOf(entity.getSub1Time())) {
            entity.setOrderCounts(entity.getOrderCounts() + 1);
        } else if (timestamp > Long.valueOf(entity.getSub1Time()) && timestamp < Long.valueOf(entity.getSub2Time())) {
            entity.setSub1OrderCounts(entity.getSub1OrderCounts() + 1);
        } else {
            entity.setSub2OrderCounts(entity.getSub2OrderCounts() + 1);
        }
        if (params.get("balance").equals(("-1"))==false)entity.setBalance(params.get("balance"));
        PeriodDTO dto = new PeriodDTO();
        BeanUtils.copyProperties(dto, entity);
        periodService.update(dto);
        return new Result();
    }

    @GetMapping("checkCanPlace")
    @ApiOperation("查询是否可以下单")
    public Result checkCanPlace(String account) {
//        account=main,优化金融模型
//        account=sub1,优化数学模型，不用在这里，进行金融经验的，加强处理
        List<PeriodEntity> result = periodService.queryAll(account);
        if (result.size() > 0) {
            PeriodEntity entity = result.get(0);
            //如果周期，3个utc操作时间已过，
            long timestamp = System.currentTimeMillis();
            if (timestamp > Long.valueOf(entity.getSub2EndTime())) {
                Result r = new Result();
                r.setData(result);
                r.error(2, "上一个大周期：时间已过！");
                return r;
            }
            int utc_period_counts = 0;

            if (timestamp < Long.valueOf(entity.getSub1Time())) {
                utc_period_counts = entity.getOrderCounts();
            } else if (timestamp > Long.valueOf(entity.getSub1Time()) && timestamp < Long.valueOf(entity.getSub1EndTime())) {
                utc_period_counts = entity.getSub1OrderCounts();
            } else if (timestamp > Long.valueOf(entity.getSub2Time()) && timestamp < Long.valueOf(entity.getSub2EndTime())) {
                utc_period_counts = entity.getSub2OrderCounts();
            }
//                if (utc_period_counts == 0) {
//                    periodOrdersService.deleteByAccount(account);
//                    baseinfoService.deleteByAccount(account);
//                }
            return new Result().ok(result);

        } else return new Result().error(1, "没有大周期");
    }

    @PostMapping("riskFalsePeriod")
    @ApiOperation("风控莫个账号，周期")
    public Result riskFalsePeriod(@RequestBody Map<String, String> params) {
        periodService.deleteByAccount(params.get("account"));
        return new Result().ok("删除成功");
    }
}

