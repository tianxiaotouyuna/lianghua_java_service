package io.renren.modules.lianghua.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-04-01
 */
@Data
public class PeriodOrdersExcel {
    @Excel(name = "")
    private Integer id;
    @Excel(name = "")
    private String instid;

}