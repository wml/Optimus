package optimus.algebra;

import gnu.trove.iterator.TLongDoubleIterator;
import gnu.trove.map.hash.TLongDoubleHashMap;
import optimus.algebra.util.Algebra;
import java.util.Arrays;
import java.util.stream.Collectors;

abstract class JExpression {

    Double constant;
    TLongDoubleHashMap terms;

    /*public JExpression plus(JExpression other) {
        if (other == JZero.getInstance()) return this;
        else return new Plus(this, other);
    }

    public JExpression minus(JExpression other) {
        if (other == JZero.getInstance()) return this;
        else return new Minus(this, other);
    }

    public JExpression mul(JExpression other) {
        if (other == JZero.getInstance()) return JZero.getInstance();
        else if (other == JOne.getInstance()) return this;
        else return new Product(this, other);
    }*/

    public JConstraint geq(JExpression other) {
        return new JConstraint(this, JConstraintRelation.GE, other);
    }

    public JConstraint leq(JExpression other) {
        return new JConstraint(this, JConstraintRelation.LE, other);
    }

    public JConstraint eq(JExpression other) {
        return new JConstraint(this, JConstraintRelation.EQ, other);
    }

    // Order of the expression (e.g linear) maybe is a little slow
    private int order() {
        int order = 0;
        TLongDoubleIterator iterator = terms.iterator();
        while(iterator.hasNext()) {
            iterator.advance();
            order = Math.max(order, Algebra.decode(iterator.key()).length);
        }
        return order;
    }

    public JExpressionOrder getOrder() {
        int order = this.order();
        if (order == 0) return JExpressionOrder.CONSTANT;
        else if (order == 1) return JExpressionOrder.LINEAR;
        else if (order == 2) return JExpressionOrder.QUADRATIC;
        else return JExpressionOrder.HIGHER;
    }

    @Override
     public String toString() {
        if (terms.isEmpty()) return constant.toString();
        else {
            String output = "(";
            TLongDoubleIterator iterator = terms.iterator();
            while(iterator.hasNext()) {
                iterator.advance();
                output += iterator.value() + Arrays.stream(Algebra.decode(iterator.key())).
                        mapToObj(index -> "idx" + index).collect(Collectors.joining("*")) + " + ";
            }
            output += constant + ")";
            return output;
        }

     }

    @Override
    public boolean equals(Object that){
        if (!(that instanceof JExpression)) return false;
        else return ((JExpression) that).terms == this.terms;
    }

}
