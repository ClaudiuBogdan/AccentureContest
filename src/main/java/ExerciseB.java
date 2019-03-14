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
        // tetrisPiece1.print();

        // TetrisTable tetrisTable = new TetrisTable(8);
        // int translatePosition = 0;
        // tetrisTable.addPiece(tetrisPiece1, translatePosition);
        // tetrisTable.print();

        int[][] tetrisPieceLimited = tetrisPiece1.getPiecePerimeter();

        System.out.println(tetrisPiece1.printPiece(tetrisPieceLimited));
        System.out.println(tetrisPiece1.getColumnMaxHeight(tetrisPieceLimited, 0));
        System.out.println(tetrisPiece1.getColumnMaxHeight(tetrisPieceLimited, 1));
        System.out.println(tetrisPiece1.getColumnMaxHeight(tetrisPieceLimited, 2));

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
                if (maxHeight - 1 < i)
                    maxHeight = i + 1;
            }
        }
        return maxHeight;
    }

    /**
     * The height of the piece is computed from up towards down.
     */
    public static int getColumnMinHeight(int[][] tetrisPiece, int columnIndex) {
        int minHeight = 0;
        for (int i = tetrisPiece.length - 1; i >= 0; i--) {
            if (tetrisPiece[i][columnIndex] != 0) {
                if (minHeight - 1 > i)
                    minHeight = i + 1;
            }
        }
        return maxHeight;
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
        int[][] mPieceLimited = mPiece.getPiecePerimeter();

        int validColumn = Integer.MIN_VALUE;
        for (int pieceColumToValidate = 0; pieceColumToValidate < mPieceLimited[0].length; pieceColumToValidate++) {
            boolean isCorrectPosition = validatePiecePosition(mPieceLimited, translatePosition, pieceColumToValidate);
            if (isCorrectPosition) {
                validColumn = pieceColumToValidate;
                break;
            }
        }

        int pieceHeightReference = TetrisPiece.getColumnMaxHeight(mPieceLimited, validColumn);

        // Check left piece position
        for (int i = pieceColumn - 1; i >= 0; i--) {
            int tableColumnLeftHeight = mTetrisTable[translatePosition + i] + tableColumnHeight;
        }
        // Check right piece position
        for (int j = pieceColumn + 1; j < mPieceLimited[0].length; j++) {
            int tableColumnRightHeight = mTetrisTable[translatePosition + j];
            if (pieceHeightReference - TetrisPiece.getColumnMaxHeight(mPieceLimited, j) + 1 <= tableColumnRightHeight)
                return false;
        }

    }

    private boolean validatePiecePosition(int[][] mPieceLimited, int translatePosition, int pieceColumn) {
        int tableColumnHeight = mTetrisTable[translatePosition + pieceColumToValidate];
        int pieceHeightReference = TetrisPiece.getColumnMaxHeight(mPieceLimited, pieceColumToValidate)
                + tableColumnHeight;
        // Check left piece position
        for (int i = pieceColumn - 1; i >= 0; i--) {
            int tableColumnLeftHeight = mTetrisTable[translatePosition + i];
            if (pieceHeightReference - TetrisPiece.getColumnMaxHeight(mPieceLimited, i) + 1 <= tableColumnLeftHeight)
                return false;
        }
        // Check right piece position
        for (int j = pieceColumn + 1; j < mPieceLimited[0].length; j++) {
            int tableColumnRightHeight = mTetrisTable[translatePosition + j];
            if (pieceHeightReference - TetrisPiece.getColumnMaxHeight(mPieceLimited, j) + 1 <= tableColumnRightHeight)
                return false;
        }
        return true;
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