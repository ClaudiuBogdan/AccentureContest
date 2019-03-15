import java.util.HashMap;

import com.sun.xml.internal.fastinfoset.tools.PrintTable;

class ExerciseB {
    public static void main(String[] args) {
        System.out.println("Hello world!: " + args[0]);
        TetrisPiece tetrisPiece1 = new TetrisPiece(5);
        tetrisPiece1.rotatePiece();
        tetrisPiece1.rotatePiece();
        tetrisPiece1.rotatePiece();
        tetrisPiece1.rotatePiece();
        // tetrisPiece1.print();

        TetrisTable tetrisTable = new TetrisTable(8);
        int translatePosition = 0;
        tetrisTable.addPiece(tetrisPiece1, translatePosition);
        tetrisTable.addPiece(tetrisPiece1, translatePosition);

        translatePosition = 2;
        tetrisTable.addPiece(tetrisPiece1, translatePosition);
        // tetrisTable.print();

        int[][] tetrisPieceLimited = tetrisPiece1.getPiecePerimeter();

        System.out.println(tetrisPiece1.printPiece(tetrisPieceLimited));

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
    }

    public TetrisPiece(int pieceID, int pieceRotation) {
        this(pieceID);
        for (int i = 0; i < pieceRotation / 90; i++) {
            this.rotatePiece();
        }
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

    public int[] getPieceLimits() {
        int minFile = mTetrisPiece.length;
        int minColumn = mTetrisPiece.length;
        int maxFile = 0;
        int maxColumn = 0;
        for (int j = 0; j < mTetrisPiece[0].length; j++) {
            for (int i = 0; i < mTetrisPiece.length; i++) {
                if (mTetrisPiece[i][j] != 0) {
                    if (i < minFile)
                        minFile = i;
                    if (i > maxFile)
                        maxFile = i;
                    if (j < minColumn)
                        minColumn = j;
                    if (j > maxColumn)
                        maxColumn = j;
                }
            }

        }
        return new int[] { minFile, minColumn, maxFile, maxColumn };
    }

    public int[][] getPiecePerimeter() {
        int[] pieceLimit = getPieceLimits();
        int minFileIndex = pieceLimit[0];
        int minColumnIndex = pieceLimit[1];
        int maxFileIndex = pieceLimit[2];
        int maxColumnIndex = pieceLimit[3];

        int[][] newPiece = new int[1 + maxFileIndex - minFileIndex][1 + maxColumnIndex - minColumnIndex];
        for (int i = minFileIndex; i <= maxFileIndex; i++) {
            for (int j = minColumnIndex; j <= maxColumnIndex; j++) {
                newPiece[i - minFileIndex][j - minColumnIndex] = mTetrisPiece[i][j];
            }
        }
        return newPiece;
    }

    /**
     * The height of the piece is computed from up towards down.
     */
    public static int getColumnMaxHeight(int[][] tetrisPiece, int columnIndex) {
        int maxHeight = 0;
        for (int i = 0; i < tetrisPiece.length; i++) {
            if (tetrisPiece[i][columnIndex] != 0) {
                if (maxHeight < i + 1)
                    maxHeight = i + 1;
            }
        }
        return maxHeight;
    }

    /**
     * The height of the piece is computed from up towards down.
     */
    public static int getColumnMinHeight(int[][] tetrisPiece, int columnIndex) {
        int minHeight = tetrisPiece.length;
        for (int i = tetrisPiece.length - 1; i >= 0; i--) {
            if (tetrisPiece[i][columnIndex] != 0) {
                if (minHeight > i)
                    minHeight = i;
            }
        }
        return minHeight;
    }

    public String printPiece(int[][] tetrisPiece) {
        StringBuilder outputString = new StringBuilder();
        for (int i = 0; i < tetrisPiece.length; i++) {
            for (int j = 0; j < tetrisPiece[0].length; j++) {
                outputString.append(tetrisPiece[i][j] + " ");
            }
            outputString.append("\n");
        }
        return outputString.toString();
    }

    @Override
    public String toString() {
        return printPiece(mTetrisPiece);
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
        // System.out.println("Created table: " + numberOfColumns);
        mTetrisTable = new int[numberOfColumns];
    }

    /**
     * Add pice to the table.
     */
    public void addPiece(TetrisPiece mPiece, int translatePosition) {
        /*
         * Find the piece start Translate the piece Place the piece
         */
        int[][] mPieceLimited = mPiece.getPiecePerimeter();

        int validColumn = validatePiecePosition(mPieceLimited, translatePosition);

        int tableColumnHeight = mTetrisTable[translatePosition + validColumn];
        int pieceHeightReference = TetrisPiece.getColumnMaxHeight(mPieceLimited, validColumn) + tableColumnHeight;

        for (int i = 0; i < mPieceLimited[0].length; i++) {
            int spacesBetweenMaxHeight = TetrisPiece.getColumnMinHeight(mPieceLimited, i);
            mTetrisTable[translatePosition + i] = pieceHeightReference - spacesBetweenMaxHeight;
        }
    }

    private int validatePiecePosition(int[][] mPieceLimited, int translatePosition) {

        int columnMaximumHeight = 0;
        int columnMaximumHeightIndex = 0;
        for (int pieceColumToValidate = 0; pieceColumToValidate < mPieceLimited[0].length; pieceColumToValidate++) {
            int tableColumnHeight = mTetrisTable[translatePosition + pieceColumToValidate];
            int pieceHeightReference = TetrisPiece.getColumnMaxHeight(mPieceLimited, pieceColumToValidate)
                    + tableColumnHeight;
            if (pieceHeightReference > columnMaximumHeight) {
                columnMaximumHeight = pieceHeightReference;
                columnMaximumHeightIndex = pieceColumToValidate;
            }

        }
        return columnMaximumHeightIndex;
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