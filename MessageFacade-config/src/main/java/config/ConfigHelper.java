package config;

import generated.MessageFacadeConfig;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;

@XmlRootElement(name="config")
public class ConfigHelper {
    public static MessageFacadeConfig getConfig() throws JAXBException {
        File file = new File("AppConfiguration/MessageFacadeConfig.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(MessageFacadeConfig.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (MessageFacadeConfig) jaxbUnmarshaller.unmarshal(file);
    }
}
