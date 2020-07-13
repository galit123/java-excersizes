package SkyboxTest;

public class CalculatePi {

    public static void main(String[] args) {
        double[][] pts = new double[1000000][2];

        for (int i = 0; i < 1000000; i++) {
            pts[i][0] = Math.random();
            pts[i][1] = Math.random();
        }

        double pii = calcPi(pts);
        System.out.println(pii);
    }

    public static double calcPi(double[][] pts) {
        int inside = 0;
        for (int i = 0; i < pts.length; i++) {
            double x = pts[i][0];
            double y = pts[i][1];

            if ((x * x + y * y) < 1) {
                inside++;
            }
        }
        double pi4 = (double) inside / (double) pts.length;
        return pi4 * 4.0;
    }


}
