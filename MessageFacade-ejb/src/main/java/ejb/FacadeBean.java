package ejb;

import impl.SoapSendRequest;
import service.Message;
import service.MessageFacadeService;
import client.RestClient;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.List;


@Stateless
@LocalBean
public class FacadeBean  implements MessageFacadeService{

    @Inject
    RestClient rest;

    @Inject
    SoapSendRequest soap;


    @Override
    public List<Message> getMessagesBySender(String sender) {
        return soap.getMessagesBySender(sender);
    }
    @Override
    public List<Message> getMessagesByDate(XMLGregorianCalendar sendTime) {
        return soap.getMessagesByDate(sendTime);
    }
    @Override
    public String deleteMessage(Message message) {
        if (message.getId() == null) {
            return "ERROR. \n Не заполнено поле id.";
        }
        return rest.deleteMessage(message);
    }
    @Override
    public String addMessage(Message message) {
        if (message.getSender().equals("") || message.getSender() == null) {
            return "ERROR \n Не заполнено поле sender.";
        } else if (message.getId() == null) {
            return "ERROR. \n Не заполнено поле id.";
        } else if (message.getContent().equals("") || message.getContent() == null) {
            return "ERROR. \n Не заполнено поле content.";
        } else if (message.getSendTime() == null) {
            return "ERROR. \n Не заполнено поле sendTime.";
        }
        return rest.addMessage(message);
    }
}
