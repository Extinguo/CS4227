package interceptor;


import java.io.IOException;


public class ConcreteInterceptor implements Interceptor{
    Logger logger = new Logger();
    /**
     *
     * implement out-of-band service that process onEatBeans event
     * @param context a concrete context object provide method to access the framework's internal state
     */
    @Override
    public void onEatBeans(I_Context context) throws IOException {

        logger.logEatBeans(context);

    }
}
