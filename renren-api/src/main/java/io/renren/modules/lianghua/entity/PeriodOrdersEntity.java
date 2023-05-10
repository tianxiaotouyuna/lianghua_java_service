package io.renren.modules.lianghua.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-04-01
 */
@Data
@TableName("period_order")
public class PeriodOrdersEntity {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 
     */
	private String instId;
    private String account;
}