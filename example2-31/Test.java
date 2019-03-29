public class Test {
    public static double[] Findvalues(double[] b) {
        double[] v = new double[3];
        v[0] = v[1] = v[2] = b[0];
        for (int i = 1; i < b.length; i++) {
            if (b[i] > v[0])
                v[0] = b[i];
            if (b[i] < v[i])
                v[1] = b[i];
            v[2] += b[i];
        }
        v[2] = v[2] / b.length;
        return v;
    }

    public static void main(String[] args) {
        double[] a = new double[20];
        for (int i = 0; i < a.length; i++)
            a[i] = Math.random() * 200;

        double[] v = Findvalues(a);
        System.out.println("max=" + v[0]);
        System.out.println("min=" + v[1]);
        System.out.println("avg=" + v[2]);
    }
}