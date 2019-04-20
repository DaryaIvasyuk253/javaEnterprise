package containers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("serviceImpl")
public class ServiceImpl implements Service {
    @Autowired
    @Qualifier("serviceDataImpl")
    private ServiceData serviceData;

    @Override
    public String toString() {
        return "ServiceImpl is running...";
    }

    @Override
    public String define() {
        return "ServiceImpl{" +
                "serviceData= " + serviceData.toString() + "}";
    }
}
