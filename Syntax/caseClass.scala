package Syntax

/**
 * Created by juzhou on 3/20/2015.
 */
case class B()

/*
the output of compile case class B.
public class B implements scala.Product,scala.Serializable {
    public B copy();
    public java.lang.String productPrefix();
    public int productArity();
    public java.lang.Object productElement(int);
    public scala.collection.Iterator<java.lang.Object> productIterator();
    public boolean canEqual(java.lang.Object);
    public int hashCode();
    public java.lang.String toString();
    public boolean equals(java.lang.Object);
    public B();
}

public final class B$ extends scala.runtime.AbstractFunction0<B> implements scala.Serializable {
    public static final B$ MODULE$;
    public static {};
    public final java.lang.String toString();
    public B apply();
    public boolean unapply(B);
    public java.lang.Object apply();
}
 */
class caseClass {

}
