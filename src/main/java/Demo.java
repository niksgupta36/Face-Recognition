package main.java;

import java.io.File;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FaceDetect detect = new FaceDetect();
		File file1 = new File("/Users/nikhil.gupta/Desktop/20171223_221208.jpg");
		
		String s1 = detect.getFaceId(file1);
		
		File file2 = new File("/Users/nikhil.gupta/Desktop/20171223_221208.jpg");
		String s2 = detect.getFaceId(file2);
		
		
		FaceVerify verify = new FaceVerify();
		
		boolean b = verify.getVerify(s1,s2);
		System.out.println(b);
		
	}

}
