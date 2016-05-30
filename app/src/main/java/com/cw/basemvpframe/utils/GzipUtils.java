package com.cw.basemvpframe.utils;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * 对资产目录下的数据文件进行压缩/解压
 */
public class GzipUtils {
	/***
	 * 方法 压缩
	 * 
	 * @param src 未压缩
	 * @param target 压缩包
	 * @throws Exception
	 */
	public static void zip(String src, String target) throws Exception {
		// 创建输入流
		InputStream is = new FileInputStream(src);
		File targFile=new File(target);
		if(!targFile.exists())
		{
			targFile.createNewFile();
		}
		// 创建Gzip输出流
		OutputStream os = new GZIPOutputStream(new FileOutputStream(target));
		copyData(is, os);
	}

	/*** 方法 复制文件内容
	@param is
	@param os
	@throws IOException
	*/
	public static void copyData(InputStream is, OutputStream os) throws IOException {
		// 使用缓冲
		byte[] buffer = new byte[1024 * 10];
		int len = 0;
		while ((len = is.read(buffer)) != -1) {
			os.write(buffer, 0, len);
		}
		os.flush();
		closeSafe(os);
		closeSafe(is);
	}
	
	/*** 方法
	@param srcInput
	@param target
	@throws Exception
	*/
	public static void unzip(GZIPInputStream srcInput,String target) throws Exception
	{
		File targFile=new File(target);
		if(!targFile.exists())
		{
			targFile.createNewFile();
		}
		//保存成未压缩
		OutputStream os=new FileOutputStream(target);
		copyData(srcInput, os);
    }
	/*** 方法
	@param src 压缩包
	@param target 解压文件
	@throws Exception
	*/
	public static void unzip(String src,String target) throws Exception
	{
		
	   //读入压缩包 GZIPInputStream解压流
		InputStream is=new GZIPInputStream(new FileInputStream(src));
		File targFile=new File(target);
		if(!targFile.exists())
		{
			targFile.createNewFile();
		}
		//保存成未压缩
		OutputStream os=new FileOutputStream(target);
		copyData(is, os);
	}

	private static void closeSafe(Closeable os) {
		try {
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
