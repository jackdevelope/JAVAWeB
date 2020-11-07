package bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        Map map  =new HashMap();
        System.out.println();
        double[] a = new double[10];
        ArrayList< Double>b = new ArrayList();
        b.add(4.0);
        b.add(4.2);
        b.add(41.0);
        b.add(2.0);
        System.out.println(b.size());
        double min = 0.0;
        for (double o : b) {
            min = Math.min(o,min);
            System.out.println(o);
        }
    }
}
