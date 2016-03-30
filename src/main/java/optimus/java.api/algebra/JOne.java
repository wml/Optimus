package optimus.algebra;

public class JOne extends JConst {

    private static JOne instance = null;

    private JOne() { super(1.0); }

    public static JOne getInstance() {
        if (instance == null) instance = new JOne();
        return instance;
    }
}
