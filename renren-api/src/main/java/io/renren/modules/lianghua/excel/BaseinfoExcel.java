package io.renren.modules.lianghua.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-03-21
 */
@Data
public class BaseinfoExcel {
    @Excel(name = "")
    private String lastOrderInst;
    @Excel(name = "")
    private String lastGridInst;
    @Excel(name = "")
    private Integer id;
    @Excel(name = "")
    private String accountName;

}