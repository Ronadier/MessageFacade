package impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import generated.MessageFacadeConfig;
import service.Message;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class RestClient {
//    static final String endpoint = new MessageFacadeConfig().getEndpointREST();
    static final String endpoint = "http://192.168.70.181:7086/MessageManager-rest/resources/message";

    public static String deleteMessage(Message message) {
        return "SUCCESS";
    }

    public static String addMessage(Message message)  {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(endpoint);
        post.setHeader("Content-Type", "application/json");
        Gson gson = new GsonBuilder().create();
        try {
            post.setEntity(new StringEntity(gson.toJson(message)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            return EntityUtils.toString(httpClient.execute(post).getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Fail";
    }
}
