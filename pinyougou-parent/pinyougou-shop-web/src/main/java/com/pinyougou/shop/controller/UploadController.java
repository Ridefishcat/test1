package com.pinyougou.shop.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import entity.Result;
import util.FastDFSClient;




@RestController
public class UploadController {
	//获取到application.properties中FILE_SERVER_URL的值
	@Value("${FILE_SERVER_URL}")
	private String file_service_url;
	
	@RequestMapping("/upload")
	public Result upload(MultipartFile file) {
		String originalFilename = file.getOriginalFilename();//获取整个文件名
		String extName = originalFilename.substring(originalFilename.lastIndexOf(".")+1);//获取扩展名
		try {
			//创建一个fastDFS客户端
			FastDFSClient fastDFSClient = new FastDFSClient("classpath:config/fdfs_client.conf");
			String path = fastDFSClient.uploadFile(file.getBytes(), extName);
			String url = file_service_url+path;
			return new Result(true, url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Result(false, "上传失败");
		}
	}
}
