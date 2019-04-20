package containers.starter;


import containers.Configurations;
import containers.services.Service;
import containers.services.ServiceData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Configurations.class);
        Service serviceImpl = (Service) applicationContext.getBean("serviceImpl");
        ServiceData serviceDataImpl = (ServiceData) applicationContext.getBean("serviceDataImpl");
        logger.info(serviceImpl.toString());
        logger.info(serviceImpl.define());
        logger.info(serviceDataImpl.toString());



    }
}
