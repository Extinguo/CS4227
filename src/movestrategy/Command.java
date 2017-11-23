package movestrategy;

public interface Command {

    /**
     * when the button pushed the operation execute
     */
    void execute();

    /**
     * when the button Released the operation undo
     */
    void undo();
}