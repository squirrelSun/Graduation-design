package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2021000117646921";

	// 商户私钥，您的PKCS8格式RSA2私钥
	public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCLBKkxQBFnOms8uam4KP0IqqtfKX+EdVp7qIfjYTYBBAc/BWCkHiTSHBSwoBu54a2JLNQou0AF9DZ1zgKnem4zOvK8Ok6WxLLm50NmtNsDdAlaD3xdPI8Avhhj/qvZQrZAziBLNaMvrR/HLOALpaPyyqI+kxHhpwj3fmJ7xepI9EIV+24cKFppyugQj8Ug30JbThu7YEQOLujJ1DjUA2rR+7fWfQluiM2I9kADzKJv++6A2dsREza7kzJa2VN6fDDSjXqxlOcwpo2c7C6PGuUtUM38QbcjwFcDRbzqyfyVm/StpTxpCjDsirABtn6GK65UhGIxaiUuc5uZwAjJw8s7AgMBAAECggEANYU62iIvUQ21oXBdPfBR0ldamM1yMX24syjkAA856lQxsfqRBT4xsM5szL8nTX3sAIbIu1GzyVcG7H2+mdnRuVl1gC/2d6cMtUbNtSnls8Olog2aNI8PAxssarruUDuVzQdOeYYR6FX/iP/m1bUUlHGc2vhmBvj2w8ndgodktmb4kMTjBs4LGcCZXPRnPuZmZ8ZtuoKI3DKVhAxA7z0tcaJKFIvaSuedE1Nioy/JdzXYX8i/G66xB9J5FWdZHdSw6IbURWYlq0RSNB+wFSgZoBEUE6rmhry5zyYoNE9008as9tAvBu4BYSk+N5tgWVLibk2qjkYpRbX6LxkxwVAOYQKBgQDZ69jW7fm5PhWmcMeDAULSo6mxGKGPOKcPKNs+SqGsLSvX/OkytAE00XcsfQoW2vEmXuridZTkvat6TXNofktXaBeTc2qi59mu+vIIsFmDXoZD53oqXT+4ixSz7SggHXHvOPE/u599NYSpPCJVsw8UD5mlt5xsbo1zpS7JXNzfkQKBgQCjT0k9W9mGF6wX1hZcsYSJ9CqTRaaDk6geOzfa6nrzgfZcrk3uybBqRJNHH9o1turTRuKIbRYm0xAFU9GgDaJZDa+Yz10jq43Gh+cCkBHDSo7gw13AxLlphHqfTXyXt08t9GmTeEU6kSlcq+R/d22IFdErSzHRq4sLOGvxBSswCwKBgBvrByCh5DhDJ+rmz+iMpM7vgLHbgfcjPuPGTDAyx3uTXeaR1B5WyUDHBQmCC2TaL8LGrjjM74JOekV03rAoXeaYw0x0oNi180FjjNZoIU+fMHxKj3AV+i/eQYy7eUSEATCwjtenZctYq+IyfgOUqP3c8cY1O6j4kM6b/t51MybBAoGAbG5mWKE1qrzo/OKe8mjDcb12z1X9m3tcssXq7iWmASyXYS4yfIvZ4JUrnJvfjK6o+CMmoiKcBKc7Ce5/Tt/+nVZi8vksBFURy3HMxnzV7m8AsufExgtYeGEH8eHHCg0iO4b+2nWOsbZUWj2fd6raRPMHcNF6gJZ/ubF6qgseg8UCgYB4T1sBX9SvYBUL+E4IBklzM20U1Ru7LJdQxGvJiS4Kc+p1Z6HVhieKDk2NLvv6/GMEq3Xs28XbE3KnwsT0UAXOJNdbrR6A9DIm1WHkeNghrR9lToSdeGPbWfVVebOqB+r2IipQE3lU+vEqiw7d3YNVG4Zx/avIo7BPIYp/5Qn7eA==";

	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
	public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmFz8V/HmdZtI6NyeXM35GmuL5UMFFek45mE8F9GEChAbExFcMOxepOursIHd7dGAJFR6HDXblPJHmAMCK2akWhxW7sNXhisIWXKp2gF9f3F0rVSn+ylvlot0gx6IbkZVB1rNnEEyub4+xinxuij5+tUu6wtyfWfzpEiu9keS0b4oFp2bldjct0VHWfGr0bUQR/lTbQcdENpjGEIj3N0aN98rpvD7mIf77Xy7JCMzE1W+JDqGyF5Vye4UYlweoI0S5ciIoq12XCgo3i/i6bMjDiVHDGDDeZUZGekVPGPbg2uPexroztonoNi52vuedl6mNhABmtBCrAIePOP3UL7D6wIDAQAB";

	// 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://55hat6.natappfree.cc/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://55hat6.natappfree.cc/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";

	// 字符编码格式
	public static String charset = "utf-8";

	// 支付宝网关（正式环境）
	// public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";

	// 支付宝网关（沙箱环境）
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

	public static String log_path = "E:\\";

//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

	/**
	 * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
	 * 
	 * @param sWord 要写入日志里的文本内容
	 */
	public static void logResult(String sWord) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
			writer.write(sWord);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
