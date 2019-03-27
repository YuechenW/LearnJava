import java.util.*;
public class ForEach {
    public static void main(String[] args) {
        Random rand = new Random(27);
        float f[] = new float[10];
        for(int i=0;i<10;i++)
        f[i]=rand.nextFloat();

        for(float x : f)
        System.out.println(x);
    }
}