import java.util.*;

public class LongestSubstring {
    public static void main(String[] args) {
        String s="abcABC";
    
    int answer=0;
    int i=-1;
    int j=-1;
    Map<Character, Integer> map=new HashMap<>();
    while(true){
        boolean f1=false;
    boolean f2=false;
        //aquire
        while(i<(s.length()-1))
        {
            f1=true;
            i++;
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
            if(map.get(c)==2)
                break;
            else
            {
                int length=(i-j);
                if(length>answer)
                    answer=length;
            }
        }
    
    //release
    while(j<i)
    {
        f2=true;
        j++;
        char c=s.charAt(j);
        map.put(c,map.get(c)-1);
        if(map.get(c)==1)
            break;
    }
    if(f1==false && f2==false)
        break;
    }
    System.out.println(answer);
}

    }
