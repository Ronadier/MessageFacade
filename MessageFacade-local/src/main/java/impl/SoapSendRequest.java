package impl;

import service.*;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class SoapSendRequest {
        URL url;
        {
            try {
                url = new URL(config.ConfigHelper.getConfig().getEndpointSOAP() + "?WSDL");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }


        QName qname = new QName("http://service/", "MessagesBeanService");

        Service service = Service.create(url, qname);

        MessageManagerService messageManagerService = service.getPort(MessageManagerService.class);

    public List<Message> getMessagesBySender (String sender) {
        return messageManagerService.getMessagesBySender(sender);
    }

    public List<Message> getMessagesByDate (XMLGregorianCalendar sendTime) {
        return messageManagerService.getMessagesByDate(sendTime);
    }
}
