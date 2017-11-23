package interceptor;

import java.io.IOException;


@FunctionalInterface
public interface Interceptor {
    /**
     *
     * Implements a specific Out-of-band service: Record the action of the player eating beans
     * @param context a concrete context object provide method to access the framework's internal state
     */
    void onEatBeans(I_Context context) throws IOException;
}
