import java.util.HashMap;

class ExerciseB {
    public static void main(String[] args) {
        System.out.println("Hello world!: " + args[0]);
        TetrisPiece tetrisPiece = new TetrisPiece(1);
        TetrisTable tetrisTable = new TetrisTable(2);

        System.out.println(tetrisPiece.toString());

    }
}

/*
 * Todo: Create piece class 1. Create piece based on id 2. Create methods:
 * Rotate, Translate, Place and GetTable
 * 
 */
class TetrisPiece {

    public TetrisPiece(int pieceID) {
        System.out.println("Created piece: " + pieceID);
    }

    /**
     * Method that return a tetris piece based on the id;
     * @params Integer from 1 to 7
     */
    private int[][] getElementByID(Integer id) {
        HashMap<Integer, int[][]> elementMap = new HashMap<Integer, int[][]>();
        elementMap.put(1, new int[][] { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 1, 1, 1, 1 } });
        elementMap.put(2, new int[][] { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 1, 0, 0, 0 }, { 1, 1, 1, 0 } });
        elementMap.put(3, new int[][] { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 }, { 1, 1, 1, 0 } });
        elementMap.put(4, new int[][] { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 1, 1, 0, 0 }, { 1, 1, 0, 0 } });
        elementMap.put(5, new int[][] { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 1, 1, 0 }, { 1, 1, 0, 0 } });
        elementMap.put(6, new int[][] { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 1, 1, 1, 0 } });
        elementMap.put(7, new int[][] { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 1, 1, 0, 0 }, { 0, 1, 1, 0 } });
        return elementMap.get(id);
    }

    /**
     * Rotate piece by changinc files with columns and starting from the last column
     * @params Array of integers that represent the piece to be rotated.
     */
    private int[][] roatePiece(int[][] aPiece){
        int[][] rotatedPiece = new int[aPiece.length][aPiece[0].length];
        for(int j = aPiece.length - 1; j >= 0 ; j++){
            for(int i = 0; j < aPiece[0].length; i++){

            }
        }
        return rotatedPiece;
    }

    @Override
    public String toString(){
        StringBuilder outputString = new StringBuilder();
        outputString.append("This is ");
        outputString.append("My string");
        outputString.append("\n");
        outputString.append("New line");
        return outputString.toString();
    }

}

/*
 * TODO: Create Tetris table class 1. Create Empty Table with defined number of
 * columns 2. Create method to add to tables 3. Create getter to get hight of
 * columns
 */
class TetrisTable {
    public TetrisTable(int numberOfColumns) {
        System.out.println("Created table: " + numberOfColumns);
    }
}