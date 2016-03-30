package optimus.algebra.util;

public final class Algebra {

    public static long encode(int x) { return encode(x, -1); }

    public static long encode(int x, int y) {
        long xm = 2 * x;
        long ym;
        if (y == -1) ym = 1;
        else ym = 2 * y;
        long w = xm + ym;
        return (w * (w + 1) / 2) + ym;
    }

    public static int[] decode(long z) {
        double w = Math.floor( (-1D + Math.sqrt(1D + 8 * z)) / 2D);
        double x = (w * (w + 3) / 2 - z) / 2;
        double y = z - w * (w + 1) / 2;
        if (y == 1) return new int[] { (int) x };
        else return new int[] { (int) x, (int) (y / 2) };
    }
}
