package movestrategy;

public interface Command {
    void execute();
    void undo();
}