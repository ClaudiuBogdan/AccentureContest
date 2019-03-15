
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
            while (scanner.hasNext()) {
                int tetrisColumns = scanner.nextInt();
                int tetrisPieces = scanner.nextInt();

                TetrisTable tetrisTable = new TetrisTable(tetrisColumns);
                for (int i = 0; i < tetrisPieces; i++) {
                    int pieceId = scanner.nextInt();
                    int pieceRotation = scanner.nextInt();
                    int pieceTranslation = scanner.nextInt();

                    TetrisPiece tetrisPiece = createTetrisPiece(pieceId, pieceRotation);
                    tetrisTable.addPiece(tetrisPiece, pieceTranslation - 1);
                }
                tetrisTable.print();
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
            // insert code to run when exception occurs
        }

    }

    private final static HashMap<String, TetrisPiece> pieceMap = new HashMap<>();

    private static TetrisPiece createTetrisPiece(int pieceId, int pieceRotation) {
        String pieceKey = pieceId + " " + pieceRotation;
        TetrisPiece tetrisPiece = pieceMap.get(pieceKey);
        if (tetrisPiece == null) {
            tetrisPiece = new TetrisPiece(pieceId, pieceRotation);
            pieceMap.put(pieceKey, tetrisPiece);
        }
        return tetrisPiece;
    }
}