package impl;

import generated.MessageFacadeConfig;
import service.Message;

public class RestClient {
    String endpoint = new MessageFacadeConfig().getEndpointREST();

    public static String deleteMessage(Message message) {
        return "SUCCESS";
    }

    public static String addMessage(Message message) {

        return "SUCCESS";
    }
}
