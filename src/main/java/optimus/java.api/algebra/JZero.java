package optimus.algebra;

public class JZero extends JConst {

    private static JZero instance = null;

    private JZero() { super(0.0); }

    public static JZero getInstance() {
        if (instance == null) instance = new JZero();
        return instance;
    }
}