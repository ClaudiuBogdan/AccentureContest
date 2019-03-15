
import java.util.*;
import java.math.*;
import java.io.*;

class ExerciseA {
    // private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            InputStream is = new FileInputStream("InputA.txt");
            BufferedInputStream bf = new BufferedInputStream(is);
            Scanner scanner = new Scanner(bf);
            while(scanner.hasNext()){
                int tetrisColumns = scanner.nextInt();
                int tetrisPieces = scanner.nextInt();

                System.out.print("Columns: " + tetrisColumns);
                System.out.print(" Pieces: " + tetrisPieces);
                System.out.println();
                for(int i = 0; i < tetrisPieces; i++){
                    int pieceId = scanner.nextInt();
                    int pieceRotation = scanner.nextInt();
                    int pieceTranslation = scanner.nextInt();
                    System.out.print("Id: " + pieceId);
                    System.out.print(" Rotation: " + pieceRotation);
                    System.out.print(" Translation: " + pieceTranslation);
                    System.out.println();
                }                
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
            // insert code to run when exception occurs
        }

    }
}