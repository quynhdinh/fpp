import java.util.Scanner;

public class Prog5 {

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(reverseString(input));

    }

    private static String reverseString(String input){
     String reversestr = "";
     for(int i=0;i<input.length();i++){
         reversestr = input.charAt(i) + reversestr;
     }

     return reversestr;
    }
}
