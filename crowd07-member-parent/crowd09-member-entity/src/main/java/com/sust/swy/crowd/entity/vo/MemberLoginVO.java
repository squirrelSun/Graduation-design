package com.sust.swy.crowd.entity.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberLoginVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String username;

	private String email;

	private Integer authstatus;

}