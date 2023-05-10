package io.renren.modules.lianghua.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.Date;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-03-21
 */
@Data
@TableName("period")
public class PeriodEntity {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
	private String longtouInstid;
    /**
     * 
     */
	private Date beginTime;
    /**
     * 
     */
	private String timeZone;
    /**
     *
     */
    private Integer orderCounts;
    /**
     *
     */
    private String sub1Time;
    /**
     *
     */
    private String sub2Time;
    /**
     *
     */
    private String subEndTime;
    /**
     *
     */
    private String sub1EndTime;
    /**
     *
     */
    private String sub2EndTime;
    /**
     *
     */
    private Date endTime;
    /**
     *
     */
    private Integer sub1OrderCounts;
    /**
     *
     */
    private Integer sub2OrderCounts;
    private String account;
    /**
     *
     */
    private String balance;
}