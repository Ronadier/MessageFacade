package impl;

import service.Message;
import service.MessageFacadeService;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.List;

@WebService(
        name = "MessageFacadeService",
        endpointInterface = "service.MessageFacadeService",
        targetNamespace = "http://service/")
@Stateless
public class FacadeBean  implements MessageFacadeService{
    @Override
    public List<Message> getMessagesBySender(String sender) {
        return new SoapSendRequest().getMessagesBySender(sender);
    }
    @Override
    public List<Message> getMessagesByDate(XMLGregorianCalendar sendTime) {
        return new SoapSendRequest().getMessagesByDate(sendTime);
    }
    @Override
    public String deleteMessage(Message message) {
        return RestClient.deleteMessage(message);
    }
    @Override
    public String addMessage(Message message) {
        return RestClient.addMessage(message);
    }
}
