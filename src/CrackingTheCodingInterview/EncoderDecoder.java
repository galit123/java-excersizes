package CrackingTheCodingInterview;

import java.util.ArrayList;
import java.util.List;

public class EncoderDecoder {

    public String encode(String str) {
        if ((str == null) || str.isEmpty()) {
            return "";
        }

        StringBuilder res = new StringBuilder();
        char[] charAr = str.toCharArray();

        char prev = charAr[0];
        int counter = 1;
        int i = 1;
        while (i < str.length()) {
            char c = charAr[i];
            if (c == prev) {
                counter++;
            } else {
                res.append(counter).append(prev);
                counter = 1;
            }
            prev = c;
            i++;
        }
        res.append(counter).append(prev);

        return res.toString();
    }

    public String decode(String str) {
        if ((str == null) || str.isEmpty()) {
            return "";
        }
        char[] charAr = str.toCharArray();
        StringBuilder res = new StringBuilder();

        int i = 0;
        while (i < str.length()) {
            if (i % 2 == 0) {
                int num = charAr[i] - '0';
                for (int j = 0; j < num; j++) res.append(charAr[i + 1]);

                i += 2;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        EncoderDecoder encoderDecoder = new EncoderDecoder();

        List<String> strList = new ArrayList<String>();
        strList.add("aabbbcc");
        strList.add("a");
        strList.add("aaaaaaaaaaaa");
        strList.add("");
        strList.add(null);
        strList.add("aaaaaac");


        for (String str : strList) {
            System.out.print("encode " + str);
            String res = encoderDecoder.encode(str);
            System.out.println(" = " + res);

            System.out.print("decode " + res);
            String in = encoderDecoder.decode(res);
            System.out.println(" = " + in);
            if (in.equals(str)) {
                System.out.println("Success");
            } else {
                System.out.println("Failure");
            }

        }


    }
}
