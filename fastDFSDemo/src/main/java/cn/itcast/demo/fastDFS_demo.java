package cn.itcast.demo;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class fastDFS_demo {

	public static void main(String[] args) throws Exception, IOException, Exception {
		//1.加载配置文件
		ClientGlobal.init("E:\\pinyougou\\fastDFSDemo\\src\\main\\resources\\fdfs_client.conf");
		//2.创建一个TrackerClient对象
		TrackerClient trackerClient = new TrackerClient();
		//3.使用TrackerClient对象创建链接
		TrackerServer trackerServer = trackerClient.getConnection();
		//4.创建一个StorageServer的引用，值为null
		StorageServer storageServer =null;
		//5.创建一个StorageClient对象
		StorageClient storageClient = new StorageClient(trackerServer,storageServer);
		//6.使用storageClient对象上传图片
		String[] strings = storageClient.upload_file("E:\\Camera\\B612Kaji_20180812_144715_557.jpg", "jpg", null);
		//7.返回数组。饱饭数组和图片路径
		for (String string : strings) {
			System.out.println(string);
		}
	
	
	}

}
