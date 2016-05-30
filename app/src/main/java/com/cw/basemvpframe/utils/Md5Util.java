package com.cw.basemvpframe.utils;

import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *使用md5算法将明文转密文
 */
public class Md5Util {
	
	/*** 方法 加密
	@param text
	@return
	*/
	public static String encode(String text)
	{
		String md5="";
		StringBuffer stringBuffer = new StringBuffer();
		//获取摘要器
		try {
			MessageDigest instance = MessageDigest.getInstance("MD5");
			//生成摘要结果
			byte[] digest = instance.digest(text.getBytes());//128bit==>16byte
			for(byte b:digest)
			{
				//去掉负号
				String hexEach = Integer.toHexString(b&0xFF);
				
				//填充0
				if(hexEach.length()==1)
				{
					stringBuffer.append("0").append(hexEach);
				}else
				{
					stringBuffer.append(hexEach);
				}
				
			}
			System.out.println(stringBuffer.toString());
			md5=stringBuffer.toString().toUpperCase();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return md5;
	}
	

	/***
	 * 方法 获取文件md5的操作完成
	 * @param sourceDir
	 * @return
	 * @throws Exception
	 */
	public static String getFildMd5(String sourceDir) throws Exception {
		// 获取摘要器
		MessageDigest instance = MessageDigest.getInstance("MD5");

		// 文件流
		FileInputStream fileInputStream = new FileInputStream(sourceDir);
		// 读取缓冲区 逐个摘要
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = fileInputStream.read(buffer)) != -1) {
			// 摘要
			instance.update(buffer, 0, len);
		}
		fileInputStream.close();

		// 组成特征值 的字节数组
		byte[] digest = instance.digest();

		StringBuffer stringBuffer = new StringBuffer();
		// 处理格式
		for (byte temp : digest) {
			// 负数转正数据
			String hexString = Integer.toHexString(temp & 0xFF);
			if (hexString.length() < 2) {
				stringBuffer.append("0").append(hexString);
			} else
			{
				stringBuffer.append(hexString);
			}
		}
		String md5 = stringBuffer.toString();
		return md5;
	}

}
