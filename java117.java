public class java117 {
    public static void main (String args[]){
        Queen q = new Queen();
        q.moves();
    }
    
}
interface ChessPlayer{
    void moves();//we cannot implement as we have to do abstraction 
}
class Queen implements ChessPlayer{
    // we have to recreate the function with implementation
    public void moves(){//we have to make it public other wise it is going to become default type
        System.out.println("up,down,left, right,diagonal (in all 4 directions)");
    }
}
class Rook implements ChessPlayer{
    public void moves(){
        System.out.println("up,down,left, right");
    }
}
class King implements ChessPlayer{
    public void moves(){
        System.out.println("up,down,left, right,diagonal (by 1 step)");
    }
}
