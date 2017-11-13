package interceptor;

import java.io.IOException;


@FunctionalInterface
public interface Interceptor {
    public void onEatBeans(PlayerInfoContext context) throws IOException;
}
