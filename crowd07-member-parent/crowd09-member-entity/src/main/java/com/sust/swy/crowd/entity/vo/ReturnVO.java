package com.sust.swy.crowd.entity.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReturnVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer type;

	private Integer supportmoney;

	private String content;

	private Integer count;

	private Integer signalpurchase;

	private Integer purchase;

	private Integer freight;

	private Integer invoice;

	private Integer returndate;

	private String describPicPath;

}