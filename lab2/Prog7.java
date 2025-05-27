import java.util.*;
class Prog7 {
    private static int[][] a = new int[8][2];

    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            int one = RandomNumbers.getRandomInt(1, 99);
            int two = RandomNumbers.getRandomInt(1, 99);
            a[i][0] = one;
            a[i][1] = two;
        }
        draw(0, 4);
        draw(4, 8);
    }

    public static void draw(int from, int to) {
        for (int i = from; i < to; i++) {
            if (a[i][0] < 10) {
                for (int j = 0; j < 2; j++) System.out.print(" ");
            } else
                for (int j = 0; j < 1; j++) System.out.print(" ");
            System.out.print(a[i][0]);
            System.out.print("\t");
        }
        System.out.println();
        for (int i = from; i < to; i++) {
            System.out.print("+");
            if (a[i][1] < 10) {
                System.out.print(" ");
            }
            System.out.print(a[i][1]);
            System.out.print("\t");
        }
        System.out.println();
        for (int i = from; i < to; i++) {
            System.out.print("---");
            System.out.print("\t");
        }
        for (int i = 0; i < 4; i++)
            System.out.println();
    }
}


/**
 *  This class keeps hold of an instance of Random and guarantees
 *  that the same instance will be used over and over (so the cost
 *  of re-seeding the random number generator is avoided).
 *  Each time the getRandomInt() method is called, the next integer
 *  from this Random instance is returned. 
 */
class RandomNumbers {
    
    static Random random;
    
    private RandomNumbers() {
        random = new Random();
    }
    
    
    /** 
     *  Use this method to get a random integer, with a call like this:
     *     int myInt = RandomNumbers.getRandomInt();
     */
    public static int getRandomInt() {
        if(random == null) new RandomNumbers();
        return random.nextInt();
    }
    /**
     * Returns a random integer x satisfying
     * lower <= x <= upper. If lower > upper, returns 0.
     * @param lower
     * @param upper
     * @return
     */
    public static int getRandomInt(int lower, int upper) {
        if(lower > upper) return 0;
        if(lower == upper) return lower;
        int difference = upper - lower;
        int start = getRandomInt();
        
        //nonneg int in the range 0..difference - 1
        start = Math.abs(start) % (difference+1);
        
        start += lower;
        return start;
    }
	
	public static void main(String[] args){
		Random r = new Random();
		System.out.println(r.nextInt()+" "+r.nextInt()+" "+r.nextInt()+" "+r.nextInt());
		r = new Random();
		System.out.println(r.nextInt()+" "+r.nextInt()+" "+r.nextInt()+" "+r.nextInt());
		r = new Random();
		System.out.println(r.nextInt()+" "+r.nextInt()+" "+r.nextInt()+" "+r.nextInt());
		r = new Random();
		System.out.println(r.nextInt()+" "+r.nextInt()+" "+r.nextInt()+" "+r.nextInt());
		String s = "hello";
		char c = s.charAt(0);
		char d = s.charAt(1);
		System.out.println(c+" "+d+" "+(char)(c+d));
	}
        
}