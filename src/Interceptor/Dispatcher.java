package Interceptor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by viola on 2017/10/20.
 */
public class Dispatcher{

    private List<Interceptor> interceptors;

    private Dispatcher()
    {
        interceptors = new ArrayList<>();
    }

    public void register(Interceptor interceptor){
        interceptors.add(interceptor);
    }

    public void remove(Interceptor interceptor){
        interceptors.remove(interceptor);
    }

    public void dispatchClientRequestInterceptorEatBeansLogging(PlayerInfoContext context) throws IOException {
        for(int index = 0; index < interceptors.size(); index++)
        {
            ConcreteInterceptor i = (ConcreteInterceptor)interceptors.get(index);
            i.onEatBeans(context);
        }
    }
}
