package impl;


import service.Message;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;

public class SoapClient {
    public static List<Message> getMessagesBySender (String sender) {
        List<Message> res = new ArrayList<>();
        res.add(new Message());
        return res;
    }

    public static List<Message> getMessagesByDate (XMLGregorianCalendar sendTime) {
        List<Message> res = new ArrayList<>();
        res.add(new Message());
        return res;
    }
}