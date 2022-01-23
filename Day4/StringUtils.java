import java.util.*;

public class StringUtils {
    public static void main(String[] args) {
        System.out.println(countChar("Shubham", 'S'));
        System.out.println(stringReverse("Shubham"));
        reverseVowels("Hello");
        System.out.println(split("Shubham a", ' '));
        System.out.println(allWordsContainsChar("Shubham a agod ay", 'a'));
        System.out.println(hasPattern("Shubham", "r"));
    }

    public static int countChar(String str, char ch) {
        int count = 0;
        int length = 0;
        str = str + " ";
        int i = 0;
        while (!((str.charAt(i) + "").equals(" "))) {
            length++;
            i++;
        }
        // System.out.println(length);
        for (int j = 0; j < length; j++) {
            if (str.charAt(j) == ch)
                count++;
        }
        return count;
    }

    public String subString(String str, int start, int end) {
        String temp = "";
        for (int i = start; i < end; i++)
            temp = temp + str.charAt(i);
        return temp;

    }
    // public static boolean isPattern(String str,String pattern)
    // {

    // }
    public static String stringReverse(String str) {
        String tester = "";
        for (int i = str.length() - 1; i >= 0; i--)
            tester = tester + str.charAt(i);
        return tester;// reversed String
    }

    public static void reverseVowels(String str) {
        int length = 0;
        str = str + " ";
        int i = 0;
        while (!((str.charAt(i) + "").equals(" "))) {
            length++;
            i++;
        }
        char[] array = new char[length];
        for (int j = 0; j < length; j++)
            array[j] = str.charAt(j);
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            while ((left < right) && checkVowel(array[left]) == false)
                left++;
            while ((left < right) && checkVowel(array[right]) == false)
                right--;
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
        System.out.println(array);
    }

    public static String[] split(String str, char ch) {
        int i = 0;
        List<String> list = new ArrayList<>();
        String s = "";
        str=str+" ";
        int count=0;
        while (i < str.length()) {

            if (!((str.charAt(i) + "").equals(" ")))
                s = s + str.charAt(i) + "";
            else {
                list.add(s);count++;
                s = "";
            }
            i++;
        }
        String[] array=new String[count];
        // System.out.println(count);
        for(int it=0;it<array.length;it++)
            array[it]=list.get(it);
        return array;


    }
    
    public static boolean allWordsContainsChar(String str, char ch){
        String[] array=split(str,' ');
        // System.out.println(Arrays.toString(array));
        boolean flags[]=new boolean[array.length];
        for(int i=0;i<array.length;i++){
            String s=array[i];
            int j;
            for( j=0;j<s.length();j++)
            {
                if(s.charAt(j)==ch){
                    break;
                }
            } 
            if(j==s.length())
                flags[i]=false;
            else
                flags[i]=true;
            }
        for(int i=0;i<flags.length;i++)
        {
            if(flags[i]==false)
                return false;
        }
        return true;

    }
    public static boolean hasPattern(String str, String pattern){
        char S[] = str.toCharArray();
        char p[] = pattern.toCharArray();
        // Pre-process the pattern
        int table[] = new int[p.length];
        preProcess(p, table, p.length);
        // Searching the pattern in the given string
        int i = 0; // index for string
        int j = 0; // index for pattern
        boolean found = false; // Boolean variable to indicate that the pattern is found or not
        
        while (i < S.length) {
            if (S[i] == p[j]) {
                // Advance forward the characters are same
                i++;
                j++;
            } else {
                // Characters are not same, revert back the progress in the pattern
                if (j !=0) // Reset the position of j in the pattern, do no advance in string
                    j = table[j - 1];
                else // first character is mis-matched, advance in the string
                    i++;
            }
            if (j == p.length) {
                // The pattern is found in the string
                found = true;
                break;
            }
        }
    
        if (found)
            return true;
        else
            return false;
     }
    private static void preProcess(char[] p, int[] table, int n) {
        // Initialize table[0] as 0
        table[0] = 0;
        // Initialise i = 0 and j = 1
        int i = 0, j = 1;
        // Run a loop till length of pattern, if p[i] and p[j] matches table[j] = i + 1 else table[j] = 0
        while (j < n) {
            if (p[j] == p[i]) {
                // Match found set table[i] = i + 1, and advance i and j
                table[j] = i + 1;
                i++; j++;
            } else {
                if (i != 0) {
                    i = table[i - 1];
                    // We do not increment j here
                } else {
                    table[j] = 0;
                    j++;
                }
            }
        }
    }
    public static boolean checkVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
                || c == 'U')
            return true;
        return false;
    }
}
