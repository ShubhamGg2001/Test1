import java.util.Scanner;

public class PrintInterleavings {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter first string..");
        String string1=sc.nextLine();
        System.out.println("Enter second string..");
        String string2=sc.nextLine();
        System.out.println("Interleavings..");
        interLeavingsPrinter(string1, string2, "");
        sc.close();
    }
    public static void interLeavingsPrinter(String qn1, String qn2, String answer){
        if(qn1.equals("")&&qn2.equals(""))
            {
                System.out.println(answer);
                return;
            }
        if(!qn1.equals(""))
            {
                char c=qn1.charAt(0);
                String qn1Substring=qn1.substring(1);
                interLeavingsPrinter(qn1Substring, qn2, answer+c);
            }
        if(!qn2.equals(""))
            {
                char c=qn2.charAt(0);
                String qn2Substring=qn2.substring(1);
                interLeavingsPrinter(qn1, qn2Substring, answer+c);
            }


    }
}
