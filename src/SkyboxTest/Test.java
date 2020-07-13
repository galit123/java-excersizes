package SkyboxTest;

import java.io.PrintStream;
import java.util.Scanner;

class Test {


    /* Ignore and do not change the code below */
    // #region main
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());
        System.out.println("\nn = " + n);
        String[] ts = new String[n];
        for (int i = 0; i < n; i++) {
            ts[i] = in.nextLine();
            System.out.println(i + ") = " + ts[i]);

        }
        System.out.println("length = " + ts.length);

        for (int j = 0; j < ts.length; j++){
            System.out.println(ts[j]);
        }
        PrintStream outStream = System.out;
        System.setOut(System.err);
        System.setOut(outStream);
    }
}

//100100000111111101010010010011010101110110