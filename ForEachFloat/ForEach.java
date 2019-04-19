import java.util.*;
public class ForEach {
    public static void main(String[] args) {
        Random rand = new Random(27);
        float f[] = new float[10];
        for(int i=0;i<10;i++)
        f[i]=rand.nextFloat();

        for(float x : f)  //经典用法：遍历并读出数组元素；理解：对于数组中的每一个元素取出来作为
        //那个类型的变量    for(<类型> <变量>:<数组>)
        System.out.println(x);
    }
}