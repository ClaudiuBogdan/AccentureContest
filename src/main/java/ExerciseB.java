class ExerciseB{
    public static void main(String[] args){
        System.out.println("Hello world!: " + args[0]);
        TetrisPiece tetrisPiece = new TetrisPiece(1);
        TetrisTable tetrisTable = new TetrisTable(2);
    }

    /*Todo: Create piece class
    *   1. Create piece based on id
    *   2. Create methods: Rotate, Translate, Place and GetTable
    *   
    */

    /*TODO: Create Tetris table class
    *   1. Create Empty Table with defined number of columns
    *   2. Create method to add to tables
    *   3. Create getter to get hight of columns
    */
}

class TetrisPiece{
    public TetrisPiece(int pieceID){
        System.out.println("Created piece: " + pieceID);
    }
}

class TetrisTable{
    public TetrisTable(int numberOfColumns){
        System.out.println("Created table: " + numberOfColumns);
    }
}