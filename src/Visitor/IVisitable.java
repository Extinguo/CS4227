package Visitor;

import Visitor.IVisitor;

public interface IVisitable {
	   void accept(IVisitor visitor);
	}
