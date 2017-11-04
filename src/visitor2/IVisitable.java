package visitor2;

@FunctionalInterface
public interface IVisitable {
	   void accept(IVisitor visitor);
	}
