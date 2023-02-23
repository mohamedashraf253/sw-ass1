import java.util.Scanner;
import javax.swing.text.Position;
class Board{
    
  public static char [][] board ={{'_','_','_'},{'_','_','_'},{'_','_','_'}};
   public static void printboard(){
        for (char[]row :board){
            System.out.print("|");
            for(char c : row){
                System.out.print(c+"|");
            }

            System.out.println();
        }   
    }
    public static void move(char symbol){
      
      
        Scanner input = new Scanner(System.in);
        
        
        int row=0,col=0;
        System.out.println("enter row and column (1-3)");
        row = input.nextInt();
        col = input.nextInt();
        while(board[row-1][col-1]!='_'){
            System.out.println(" invalid choice , enter row and column (1-3)");
            row = input.nextInt();
            col = input.nextInt();
        }
        board[row-1][col-1]=symbol;
    }   
    public boolean  is_winner () {
            for(int i=0;i<3;i++){
                if(board[0][i]==board[1][i]&&board[0][i]==board[2][i]&&board[0][i]!='_'){
                    return true;
                }
            }
            for(int i=0;i<3;i++){
                if(board[i][0]==board[i][1]&&board[i][0]==board[i][2]&&board[i][0]!='_'){
                    return true;
                }
            }
            if(board[0][0]==board[1][1]&&board[0][0]==board[2][2]&&board[0][0]!='_'){
                return true;
            }
            if(board[0][2]==board[1][1]&&board[0][2]==board[2][0]&&board[0][2]!='_'){
                return true;
            }
            return false;


    }
    public boolean is_draw () {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]=='_')
                    return false;
            }
        }
        return true;
    }
}
 class player{
    String name;
    public char symbol;
    player(){
        
    }
    player(String name,char symbol){
        this.name=name;
        this.symbol=symbol;
        
    }
    
public String getName() {
    return name;
}
public char getSymbol() {
    return symbol;
}
}
 class game{
   private int turn=0;
   private player [] players=new player[2];
   private  Board board;  
   game(){
    String name;
    char symbol;
    System.out.println("first player,enter name and symbol (x or o)");
    Scanner input = new Scanner(System.in);
    name= input.next();
    symbol=input.next().charAt(0);
    players[0]=new player(name,symbol);
    System.out.println("player name : "+name+" ,symbol : "+symbol);
    while (symbol!='x'&&symbol!='o') {
            System.out.println("invalid input , enter symbol (x or o)");
            symbol=input.next().charAt(0);
        }
        System.out.println("second player,enter name and symbol (x or o)");
    name= input.next();
    symbol=(symbol=='x'?'o':'x');

    players[1]=new player(name,symbol);
    System.out.println("player name : "+name+" ,symbol : "+symbol);
   }
   

   public void play_game(){
    board = new Board();
    while(!(board.is_winner() || board.is_draw())){
        if(turn==0){
            board.move(players[0].getSymbol());
        }
        else{
            board.move(players[1].getSymbol());
        } 
        board.printboard();
        turn^=1;
    }
    
    if(board.is_winner()){
        System.out.println(players[turn^1].getName()+"  is the winner"); 
    
    }
    else{
        System.out.println("draw");
    }
   }
}

public class main {
    public static void main (String[] args){
       game b =new game();
       b.play_game();
    }
}
