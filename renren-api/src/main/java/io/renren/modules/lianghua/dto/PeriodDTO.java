package io.renren.modules.lianghua.dto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-03-21
 */
@Data
@ApiModel(value = "")
public class PeriodDTO implements Serializable {
	private Integer id;
	@ApiModelProperty(value = "")
	@NotBlank(message="龙头ID不能为空")
	private String longtouInstid;

	@ApiModelProperty(value = "")
	@NotBlank(message="出现时间不能为空")
	private Date beginTime;

	@ApiModelProperty(value = "0:龙头还强势，买龙二阶段1:龙头没了，买龙一阶段")
	private String timeZone;

	@ApiModelProperty(value = "")
	@NotBlank(message="时区不能为空")
	private Integer orderCounts;
	@ApiModelProperty(value = "")
	@NotBlank(message="时区不能为空")
	private String sub1Time;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private String sub2Time;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private String sub1EndTime;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private String subEndTime;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private String sub2EndTime;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private Date endTime;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private Integer sub1OrderCounts;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private Integer sub2OrderCounts;
	@ApiModelProperty(value = "")
	private String account;
	@ApiModelProperty(value = "")
	private String balance;


}