package movestrategy2;

public interface Command {
    void execute();
    void undo();
}