package io.renren.modules.lianghua.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-03-21
 */
@Data
@TableName("baseinfo")
public class BaseinfoEntity {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
	private String lastOrderInst;
    /**
     * 
     */
	private String lastGridInst;
    /**
     * 
     */
    private Integer originCount;
    private String account;

    private String lastFirstInst;

}