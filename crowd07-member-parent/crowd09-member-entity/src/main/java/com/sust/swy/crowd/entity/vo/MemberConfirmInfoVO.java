package com.sust.swy.crowd.entity.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberConfirmInfoVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String paynum;

	private String cardnum;
	
}