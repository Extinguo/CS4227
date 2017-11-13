package gameobjects;


@FunctionalInterface
public interface DelegatorWithReturn {
    
    /**
     *     
     * This method just executes something. It is used for delegation in the Adapter
     * @param args Some Arguments that might be needed for the following course of action
     * @return Not known until implemented
     */
    public Object execute(Object... args);
}
