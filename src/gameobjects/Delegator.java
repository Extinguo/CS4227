package gameobjects;


@FunctionalInterface
public interface Delegator {
    
    /**
     * This method just executes something. It is used for delegation in the Adapter.
     * @param args Some Arguments that might be needed for the following course of action
     */
    public void execute(Object... args);
}