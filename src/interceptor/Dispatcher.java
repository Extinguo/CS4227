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

    /**
     *
     * register an interceptor into the dispatcher
     * @param interceptor a interceptor which will be added into the dispatcher
     */
    public void register(Interceptor interceptor){
        interceptorList.add(interceptor);
    }

    /**
     *
     * unregister an interceptor into the dispatcher
     * @param interceptor a interceptor which will be removed into the dispatcher
     */
    public void remove(Interceptor interceptor){
        interceptorList.remove(interceptor);
    }

    /**
     *
     * Dispatcher registered concrete interceptor callbacks when EatBeansLogging events occur
     * @param context a concrete context object provide method to access the framework's internal state
     */
    public void dispatchClientRequestInterceptorEatBeansLogging(I_Context context) throws IOException {
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
