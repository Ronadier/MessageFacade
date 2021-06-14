package impl;

import service.*;


import javax.xml.bind.JAXBException;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class SoapSendRequest {

    private static final String CONNECT_TIMEOUT = "com.sun.xml.internal.ws.connect.timeout";
    private static final String REQUEST_TIMEOUT = "com.sun.xml.internal.ws.request.timeout";
    private static Integer connectTimeout;
    private static Integer requestTimeout;
    private static URL url;

    static {
        try {
            connectTimeout = config.ConfigHelper.getConfig().getConnectionTimeout();
            requestTimeout = config.ConfigHelper.getConfig().getRequestTimeout();
            url = new URL(config.ConfigHelper.getConfig().getEndpointSOAP() + "?WSDL");
        } catch (MalformedURLException | JAXBException e) {
            e.printStackTrace();
        }
    }


    private static QName qname = new QName("http://service/", "MessageManagerImplService");


    private static Service service = Service.create(url, qname);

    private static MessageManagerService messageManagerService = service.getPort(MessageManagerService.class);

    public static List<Message> getMessagesBySender(String sender) {
        Map<String, Object> requestContext = ((BindingProvider) messageManagerService).getRequestContext();
        requestContext.put(REQUEST_TIMEOUT, requestTimeout);
        requestContext.put(CONNECT_TIMEOUT, connectTimeout);
        return messageManagerService.getMessagesBySender(sender);
    }

    public static List<Message> getMessagesByDate(XMLGregorianCalendar sendTime) {
        Map<String, Object> requestContext = ((BindingProvider) messageManagerService).getRequestContext();
        requestContext.put(REQUEST_TIMEOUT,requestTimeout);
        requestContext.put(CONNECT_TIMEOUT,connectTimeout);
        return messageManagerService.getMessagesByDate(sendTime);
    }
}
