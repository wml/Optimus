package optimus.algebra;

import gnu.trove.map.hash.TLongDoubleHashMap;

public class JConst extends JExpression {

    private Double constant;
    private TLongDoubleHashMap terms;

    public JConst(Double constant) {
        this.constant = constant;
        this.terms = new TLongDoubleHashMap();
    }
}
