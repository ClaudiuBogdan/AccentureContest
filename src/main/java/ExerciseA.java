

import java.util.*;
import java.math.*;
class ExerciseA{
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println(args[0]);
        // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
        int n = scanner.nextInt();
        

        int p = scanner.nextInt();
        // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
        scanner.close();

        System.out.println("Hello World!" + n + " " + p);
    }
}