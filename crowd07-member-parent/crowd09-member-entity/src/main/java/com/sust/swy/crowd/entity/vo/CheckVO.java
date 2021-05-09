package com.sust.swy.crowd.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CheckVO {

	private String realName;

	private String cardNum;

	private String phoneNum;

	private String photoWithHandPath;

	private String photoOnPath;

	private String photoOffPath;

	private String code;

}
