package lab2;

public class Prog2 {
    public class RandomNumbers {
        public static int getRandomInt(int low, int high) {
            return (int)(Math.random() * (high - low + 1)) + low;
        }
    }

    public static void main(String[] args) {

        int x = RandomNumbers.getRandomInt(1, 9);
        double result1 = Math.pow(Math.PI, x);
        System.out.println("PI raised to the power of " + x + " is: " + result1);

        int y = RandomNumbers.getRandomInt(3, 14);
        double result2 = Math.pow(y, Math.PI);
        System.out.println(y + " raised to the power of PI is: " + result2);
    }
}
