package main.java;

import java.io.File;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;



public class FaceDetect	
{

 

public String getFaceId(File file) {
	// TODO Auto-generated method stub
//	private final String imageWithFaces = file;
	
	CloseableHttpClient httpclient = HttpClients.createDefault();

    try
    {
        URIBuilder uriBuilder = new URIBuilder("https://westcentralus.api.cognitive.microsoft.com/face/v1.0/detect");

        uriBuilder.setParameter("returnFaceId", "true");
//        uriBuilder.setParameter("returnFaceLandmarks", "false");
//        uriBuilder.setParameter("returnFaceAttributes", "age");

        URI uri = uriBuilder.build();
        HttpPost request = new HttpPost(uri);

        // Request headers. Replace the example key below with your valid subscription key.
        request.setHeader("Content-Type", "application/octet-stream");
        request.setHeader("Ocp-Apim-Subscription-Key", "08211ca72ce541ec99500ec06af30f6d");



        // Request body


       // File file = new File("/Users/nikhil.gupta/Desktop/wishes-monitor.jpg");

        FileEntity reqEntity = new FileEntity(file, ContentType.APPLICATION_OCTET_STREAM);
        request.setEntity(reqEntity);

        HttpResponse response = httpclient.execute(request);
        HttpEntity entity = response.getEntity();
        System.out.println(response.getStatusLine());

        if (entity != null)
        {
            // Format and display the JSON response.
            System.out.println("REST Response:\n");

            String jsonString = EntityUtils.toString(entity).trim();
            if (jsonString.charAt(0) == '[') {
                JSONArray jsonArray = new JSONArray(jsonString);
              //  System.out.println(jsonArray.toString(2));
                JSONObject obj=(JSONObject) jsonArray.get(0);
                return (String) obj.get("faceId");
            }
            else if (jsonString.charAt(0) == '{') {
                JSONObject jsonObject = new JSONObject(jsonString);
             //   System.out.println(jsonObject.toString(2));
              
                return (String) jsonObject.get("faceId");
            } }}
    catch (Exception e)
    {
        System.out.println(e.getMessage());
    }
    return null;
}
}