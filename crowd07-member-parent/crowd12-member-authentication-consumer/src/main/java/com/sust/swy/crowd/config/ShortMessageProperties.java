package com.sust.swy.crowd.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix = "short.message")
public class ShortMessageProperties {

	private String host;
	private String path;
	private String method;
	private String appcode;
	private String sign;
	private String skin;

}
