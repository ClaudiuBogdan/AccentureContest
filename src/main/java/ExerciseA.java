

import java.util.*;
import java.math.*;
class ExerciseA{
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Hello WOrld!");
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
        scanner.close();

        System.out.println("Hello WOrld!" + n + " " + p);
    }
}