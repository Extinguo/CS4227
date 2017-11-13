package interceptor;


import java.io.IOException;


public class ConcreteInterceptor implements Interceptor{
    Logger logger = new Logger();

    @Override
    public void onEatBeans(PlayerInfoContext context) throws IOException {

        logger.logEatBeans(context);

    }
}
