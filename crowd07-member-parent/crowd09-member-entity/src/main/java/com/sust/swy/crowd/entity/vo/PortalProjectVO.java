package com.sust.swy.crowd.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PortalProjectVO {

	private Integer projectId;

	private String projectName;

	private String headerPicturePath;

	private Integer money;
	
	private Integer follower;

	private String deployDate;

	private Integer percentage;

	private Integer supporter;

}
