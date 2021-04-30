package com.sust.swy.crowd.entity.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String orderNum;

	private String payOrderNum;

	private Double orderAmount;

	private Integer invoice;

	private String invoiceTitle;

	private String orderRemark;

	private String addressId;

	private OrderProjectVO orderProjectVO;

}
