package com.sust.swy.print.constant.util;

import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.comm.ResponseMessage;
import com.aliyun.oss.model.PutObjectResult;
import com.sust.swy.print.constant.PrintConstant;

public class PrintUtil {

	public static ResultEntity<String> uploadFileToOss(String endpoint, String accessKeyId, String accessKeySecret,
			InputStream inputStream, String bucketName, String bucketDomain, String originalName) {
		OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
		String folderName = new SimpleDateFormat("yyyyMMdd").format(new Date());
		String fileMainName = UUID.randomUUID().toString().replace("-", "");
		String extensionName = originalName.substring(originalName.lastIndexOf("."));
		String objectName = folderName + "/" + fileMainName + extensionName;
		try {
			PutObjectResult putObjectResult = ossClient.putObject(bucketName, objectName, inputStream);
			ResponseMessage responseMessage = putObjectResult.getResponse();
			if (responseMessage == null) {
				String ossFileAccessPath = bucketDomain + "/" + objectName;
				return ResultEntity.successWithData(ossFileAccessPath);
			} else {
				int statusCode = responseMessage.getStatusCode();
				String errorMessage = responseMessage.getErrorResponseAsString();
				return ResultEntity.failed("当前响应状态码=" + statusCode + " 错误消息=" + errorMessage);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResultEntity.failed(e.getMessage());
		} finally {
			if (ossClient != null) {
				ossClient.shutdown();
			}
		}
	}

	public static String md5(String source) {
		if (source == null || source.length() == 0)
			throw new RuntimeException(PrintConstant.MESSAGE_STRING_INVALIDATE);
		String algorithm = "md5";
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			byte[] input = source.getBytes();
			byte[] output = messageDigest.digest(input);
			int signum = 1;
			BigInteger bigInteger = new BigInteger(signum, output);
			int radix = 16;
			String encoded = bigInteger.toString(radix).toUpperCase();
			return encoded;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean judgeRequestType(HttpServletRequest request) {
		String acceptHeader = request.getHeader("Accept");
		String xRequestHeader = request.getHeader("X-Requested-With");
		return (acceptHeader != null && acceptHeader.contains("application/json"))
				|| (xRequestHeader != null && xRequestHeader.equals("XMLHttpRequest"));
	}

}
