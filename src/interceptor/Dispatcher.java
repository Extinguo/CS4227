package interceptor;

import java.io.IOException;
import java.util.ArrayList;


public class Dispatcher{

    private ArrayList<Interceptor> interceptorList;
    private static Dispatcher firstInstance = null;

    private Dispatcher()
    {
        interceptorList = new ArrayList<>();
    }

    public static Dispatcher getInstance()
    {
        if(firstInstance == null)
        {
            firstInstance = new Dispatcher();
        }
        return firstInstance;
    }

    public void register(Interceptor interceptor){
        interceptorList.add(interceptor);
    }

    public void remove(Interceptor interceptor){
        interceptorList.remove(interceptor);
    }

    public void dispatchClientRequestInterceptorEatBeansLogging(PlayerInfoContext context) throws IOException {
        ArrayList<Interceptor> interceptors;
        synchronized (this)
        {
            interceptors = interceptorList;
        }

        for(int index = 0; index < interceptors.size(); index++)
        {
            ConcreteInterceptor i = (ConcreteInterceptor)interceptors.get(index);
            i.onEatBeans(context);
        }
    }
}
