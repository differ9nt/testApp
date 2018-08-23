import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class test {
    public static void main(String[] args) {
        int a = 2;
        int b = -5;
        System.out.println("FOO: " + foo(a,b));
        System.out.println("POW: " + Math.pow(a,b));
    }

    public static double foo(int a,int b) {
        if (b < 0)
            return foo(a,b+1)/a;
        else if (b > 0)
            return a * foo(a,b-1);
        else
            return 1;
    }


}
