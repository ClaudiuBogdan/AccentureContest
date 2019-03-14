import java.util.HashMap;

class ExerciseB {
    public static void main(String[] args) {
        System.out.println("Hello world!: " + args[0]);
        TetrisPiece tetrisPiece1 = new TetrisPiece(6);
        // TetrisPiece tetrisPiece2 = new TetrisPiece(2);
        // TetrisPiece tetrisPiece3 = new TetrisPiece(3);
        // TetrisPiece tetrisPiece4 = new TetrisPiece(4);
        // TetrisPiece tetrisPiece5 = new TetrisPiece(5);
        // TetrisPiece tetrisPiece6 = new TetrisPiece(6);
        // TetrisPiece tetrisPiece7 = new TetrisPiece(7);

        tetrisPiece1.rotatePiece();
        tetrisPiece1.rotatePiece();
        tetrisPiece1.print();        
        System.out.println("Piece start: " + tetrisPiece1.getPieceStart());

        TetrisTable tetrisTable = new TetrisTable(8);
        int translatePosition = 0;
        tetrisTable.addPiece(tetrisPiece1, translatePosition);
        tetrisTable.print();

    }
}

/*
 * Todo: Create piece class 1. Create piece based on id 2. Create methods:
 * Rotate, Translate, Place and GetTable
 * 
 */
class TetrisPiece {
    int[][] mTetrisPiece;

    public TetrisPiece(int pieceID) {
        mTetrisPiece = getElementByID(pieceID);

        System.out.println("Created piece: " + pieceID);
        System.out.println(this.toString());
    }

    /**
     * Method that return a tetris piece based on the id;
     * 
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
     * 
     * @params Array of integers that represent the piece to be rotated.
     */
    public int[][] rotatePiece() {
        int[][] rotatedPiece = new int[mTetrisPiece.length][mTetrisPiece[0].length];
        for (int i = mTetrisPiece.length - 1; i >= 0; i--) {
            for (int j = 0; j < mTetrisPiece[0].length; j++) {
                rotatedPiece[mTetrisPiece.length - 1 - i][j] = mTetrisPiece[j][i];
            }
        }
        this.mTetrisPiece = rotatedPiece;
        return rotatedPiece;
    }

    /**
     * Return the most left culomn with value;
    */
    public int getPieceStart(){
        for(int j = 0; j < mTetrisPiece[0].length; j++ ){
            for(int i = 0; i < mTetrisPiece.length; i++){
                if(mTetrisPiece[i][j] != 0)
                    return j;
            }            
        }
        return mTetrisPiece[0].length;        
    }

    @Override
    public String toString() {
        StringBuilder outputString = new StringBuilder();
        for (int i = 0; i < mTetrisPiece.length; i++) {
            for (int j = 0; j < mTetrisPiece[0].length; j++) {
                outputString.append(mTetrisPiece[i][j] + " ");
            }
            outputString.append("\n");
        }
        return outputString.toString();
    }

    public void print() {
        System.out.println(this.toString());
    }

}

/*
 * TODO: Create Tetris table class 1. Create Empty Table with defined number of
 * columns 2. Create method to add to tables 3. Create getter to get hight of
 * columns
 */
class TetrisTable {
    private int[] mTetrisTable;

    public TetrisTable(int numberOfColumns) {
        System.out.println("Created table: " + numberOfColumns);
        mTetrisTable = new int[numberOfColumns];
    }

    /**
     * Add pice to the table.
     */
    public void addPiece(TetrisPiece mPiece, int translatePosition) {
        /*
         * Find the piece start Translate the piece Place the piece
         */
        int pieceStart = mPiece.getPieceStart();

    }

    @Override
    public String toString() {
        StringBuilder outputString = new StringBuilder();
        for (int i = 0; i < mTetrisTable.length; i++) {
            outputString.append(mTetrisTable[i] + " ");
        }
        return outputString.toString();
    }

    public void print() {
        System.out.println(this.toString());
    }

}