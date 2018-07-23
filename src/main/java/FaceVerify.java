package main.java;

import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class FaceVerify 
{
	
	{
       HttpClient httpclient = HttpClients.createDefault();

       try
       {
          // URIBuilder builder = new URIBuilder("https://westcentralus.api.cognitive.microsoft.com/face/v1.0/verify");
           URIBuilder builder = new 
           	URIBuilder("https://westcentralus.api.cognitive.microsoft.com/face/v1.0/verify");

//        	private static final String builder =
//        	       "https://westcentralus.api.cognitive.microsoft.com/face/v1.0/detect";

           URI uri = builder.build();
           HttpPost request = new HttpPost(uri);
           request.setHeader("Content-Type", "application/json");
           request.setHeader("Ocp-Apim-Subscription-Key", "08211ca72ce541ec99500ec06af30f6d");


           // Request body
           StringEntity reqEntity = 
           	new StringEntity("{faceId1: 'e87e06ed-7340-4fd6-b5a0-9d92c8534ee2', faceId2: '83461eac-e7d2-402b-8689-fccf643c846f' }");
           request.setEntity(reqEntity);

           HttpResponse response = httpclient.execute(request);
           HttpEntity entity = response.getEntity();

           if (entity != null) 
           {
               System.out.println(EntityUtils.toString(entity));
           }
       }
       catch (Exception e)
       {
           System.out.println(e.getMessage());
       }
}
}