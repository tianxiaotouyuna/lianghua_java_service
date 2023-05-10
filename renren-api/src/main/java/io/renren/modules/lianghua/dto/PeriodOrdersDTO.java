package io.renren.modules.lianghua.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;


/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-04-01
 */
@Data
@ApiModel(value = "")
public class PeriodOrdersDTO implements Serializable {

	private Integer id;
	@ApiModelProperty(value = "")
	private String instId;
	@ApiModelProperty(value = "")
	private String account;


}