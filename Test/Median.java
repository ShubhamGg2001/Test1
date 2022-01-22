public class Median{
public static void main(String[] args) {
    int[] array1={1,5,6,8};
    int[] array2={2,3,4,9,10};
    System.out.println(median(array1, array2));
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