package io.renren.modules.lianghua.dto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-03-21
 */
@Data
@ApiModel(value = "")
public class BaseinfoDTO implements Serializable {
	private Integer id;
	@ApiModelProperty(value = "")
	private String lastOrderInst;

	@ApiModelProperty(value = "")
	private String lastGridInst;
	@ApiModelProperty(value = "")
	private Integer originCount;
	@ApiModelProperty(value = "")
	private String account;

	@ApiModelProperty(value = "")
	private String lastFirstInst;


}