package ws;

import ejb.FacadeBean;
import service.Message;
import service.MessageFacadeService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.List;

@WebService(
        name = "MessageFacadeService",
        endpointInterface = "service.MessageFacadeService",
        targetNamespace = "http://service/")
@Stateless
public class MessageFacadeImpl implements MessageFacadeService {

    @EJB
    FacadeBean bean;

    @Override
    public List<Message> getMessagesBySender(String sender) {
        return bean.getMessagesBySender(sender);
    }
    @Override
    public List<Message> getMessagesByDate(XMLGregorianCalendar sendTime) {
        return bean.getMessagesByDate(sendTime);
    }
    @Override
    public String deleteMessage(Message message) {
        return bean.deleteMessage(message);
    }
    @Override
    public String addMessage(Message message) {
        return bean.addMessage(message);
    }
}
