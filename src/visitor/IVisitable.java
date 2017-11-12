package visitor;

/**
*
* @author Yann Mace
*/



@FunctionalInterface
public interface IVisitable {
	
	/**
     * Use to resolve the Double dispatch Pattern to access to the visitable class
     * @param visitor The visitor Interface
     */
	   void accept(IVisitor visitor);
}
