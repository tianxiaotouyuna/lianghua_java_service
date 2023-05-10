package io.renren.modules.lianghua.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-03-21
 */
@Data
public class PeriodExcel {
    @Excel(name = "")
    private Integer id;
    @Excel(name = "")
    private String longtouInstid;
    @Excel(name = "")
    private Date beginTime;
    @Excel(name = "0:龙头还强势，买龙二阶段1:龙头没了，买龙一阶段")
    private Integer stage;
    @Excel(name = "")
    private String timeZone;

}