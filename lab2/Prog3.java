package lab2;
public class Prog3 {
    public static void main(String[] args) {
       float a = 1.27f;
       float b = 3.881f;
       float c = 9.6f;
       //sum by casting to int
       int sum1 = (int)(a+b+c);
       // sum by using Math.round
       int sum2 = Math.round(a+b+c);
      
       System.out.println("Sum by casting to int: " + sum1);
       System.out.println("Sum by Math.round: " + sum2);
       
    }
}