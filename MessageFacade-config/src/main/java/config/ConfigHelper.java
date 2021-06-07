package config;

import generated.MessageFacadeConfig;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ConfigHelper {
    public static MessageFacadeConfig getConfig() throws JAXBException {
        File file = new File("AppConfiguration/MessageFacadeConfig.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(MessageFacadeConfig.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (MessageFacadeConfig) jaxbUnmarshaller.unmarshal(file);
    }
}
