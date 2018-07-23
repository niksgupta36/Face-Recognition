package main.java;

import java.io.File;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FaceDetect detect = new FaceDetect();
		File file = new File("/Users/nikhil.gupta/Desktop/wishes-monitor.jpg");
		
		System.out.println(detect.getFaceId(file));
		
	}

}
