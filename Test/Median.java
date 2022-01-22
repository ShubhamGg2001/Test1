import java.util.Scanner;

public class Median{
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter size of first array..");
    int size1=sc.nextInt();// Size of first array.
    int[] array1=new int[size1];
    System.out.println("Enter elements of array1..");
    for(int i=0;i<array1.length;i++)
        array1[i]=sc.nextInt();// Inputs for first array
    
    System.out.println("Enter size of second array..");
    int size2=sc.nextInt();// Size of second array.
    int[] array2=new int[size2];
    System.out.println("Enter elements of array2..");
    for(int i=0;i<array2.length;i++)
            array2[i]=sc.nextInt();// Inputs for second array..

    System.out.println("Median is: "+median(array1, array2)); // Calling median function for finding medians of 2 arrays.
    sc.close();
}
public static int median(int[] array1, int[] array2){
    int[] merged=new int[array1.length+array2.length];
    int i=0;// Pointer for array1
    int j=0;// Pointer for array2
    int s=0;// Pointer for merged array
    while(i<array1.length&&j<array2.length){
        if(array1[i]<array2[j])
        {
            merged[s]=array1[i];
            i++;s++;
        }
        else{
            merged[s]=array2[j];
            j++;s++;
        }
    }
        while(i<array1.length){
            merged[s]=array1[i];
            i++;s++;
        }
    
        while(j<array2.length){
            merged[s]=array2[j];
            j++;s++;
        }
        if((merged.length)%2!=0)
            return (merged[(merged.length-1)/2]);
        else
            return ((merged[merged.length/2]+merged[(merged.length/2)-1])/2);
        
    
    

}
}