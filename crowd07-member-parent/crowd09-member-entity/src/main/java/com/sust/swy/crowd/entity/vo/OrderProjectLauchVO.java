package com.sust.swy.crowd.entity.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderProjectLauchVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer orderId;

	private Integer projectId;

	private String projectName;

	private String projectDescription;

	private String percentage;

	private Integer day;

	private Integer status;
	
	private String deploydate;
	
	private Integer lastday;

	private Integer freight;

	private String orderNum;

	private String payOrderNum;
	
	private Double orderAmount;

	private String invoiceTitle;

	private String orderRemark;

	private String receiveName;

	private String phoneNum;

	private String address;

}
