package interceptor2;

import java.io.IOException;

/**
 * Created by viola on 2017/10/20.
 */

@FunctionalInterface
public interface Interceptor {
    public void onEatBeans(PlayerInfoContext context) throws IOException;
}
