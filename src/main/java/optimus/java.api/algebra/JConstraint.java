package optimus.algebra;

public class JConstraint {

    private JExpression lhs;
    private JExpression rhs;
    private JConstraintRelation operator;

    public JConstraint(JExpression lhs, JConstraintRelation operator, JExpression rhs) {
        this.lhs = lhs; this.operator = operator; this.rhs = rhs;
    }

    public JExpression lhs() { return lhs; }

    public JExpression rhs() { return rhs; }

    public JConstraintRelation operator() { return operator; }
}
