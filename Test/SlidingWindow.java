import java.util.*;
import java.util.Scanner;

public class SlidingWindow {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of array..");
        int size=sc.nextInt();// array size
        int[] nums=new int[size];
        System.out.println("Enter elements of array..");
        for(int i=0;i<size;i++)
            nums[i]=sc.nextInt();
        System.out.println("Enter size of sliding window..");
        int k=sc.nextInt();// window size
        if(k>size)
            System.out.println("Window size should be grater than Array size..");
        else
            System.out.println(slidingWindow(nums, k));;// sliding window function is called here.
        sc.close();

    }
    public static List<Integer> slidingWindow(int[] array, int k){
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<=(array.length-k);i++){
            int max=array[i];
            for(int j=1;j<k;j++){
                if(array[i+j]>max)
                    max=array[i+j];
            }// In this array, i is the iterator.
            list.add(max);
        }
        return list;
    }
}
