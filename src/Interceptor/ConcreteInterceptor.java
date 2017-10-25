package Interceptor;


import java.io.IOException;

/**
 * Created by viola on 2017/10/20.
 */
public class ConcreteInterceptor implements Interceptor{
    Logger logger = new Logger();

    @Override
    public void onEatBeans(PlayerInfoContext context) throws IOException {

        logger.logEatBeans(context);

    }
}
