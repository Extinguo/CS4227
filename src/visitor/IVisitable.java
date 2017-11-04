package visitor;

@FunctionalInterface
public interface IVisitable {
	   void accept(IVisitor visitor);
	}
