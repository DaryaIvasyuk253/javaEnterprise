package containers.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("serviceDataImpl")
@Qualifier("serviceDataImpl")
@Scope("prototype")
public class ServiceDataImpl implements ServiceData {

    @Override
    public String toString() {
        return "ServiceDataImpl is running...";
    }
}
