package com.sust.swy.crowd.entity.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberLauchInfoVO  implements Serializable {
	
	private static final long serialVersionUID = 1L;	

	private String descriptionSimple;
	
	private String descriptionDetail;
	
	private String phoneNum;
	
	private String serviceNum;

}