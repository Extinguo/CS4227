package interceptor;

/**
 * Created by viola on 2017/11/22.
 */
public interface I_Context {
    /**
     *
     * Allow a concrete interceptor access the description of player information
     */
    String getDescription();
}
