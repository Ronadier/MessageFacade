package client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import config.ConfigHelper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import service.Message;


import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class RestClient {
    private static String endpoint;
    private static final HttpClient httpClient = HttpClientBuilder.create().build();

    static {
        try {
            endpoint = ConfigHelper.getConfig().getEndpointREST();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static String deleteMessage(Message message) {
        HttpDelete delete = new HttpDelete(endpoint + "/" + message.getId());

        try {
            HttpResponse response = httpClient.execute(delete);
            return EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    public static String addMessage(Message message)  {
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
