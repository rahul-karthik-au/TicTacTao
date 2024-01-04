package TicTacToe;
import java.util.Scanner;
public class Main{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        char[][] box= new char[3][3];
        char player='X';
        boolean gameOver=false;
        int row;
        int col;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                box[i][j]=' ';
            }
        }
        displayBox(box);
        while(!gameOver && hasSpace(box)){
            System.out.println("Player "+ player +":Enter the row and column");
            row =in.nextInt();
            col=in.nextInt();
            if(box[row-1][col-1]==' '){
                box[row-1][col-1]=player;
                displayBox(box);
                gameOver=checkGameOver(box,player);
                if(player=='X'){
                    player='O';
                }
                else{
                    player='X';
                }
            }
            else{
                System.err.println("Invalid Input!");
            }
        }
        if(!hasSpace(box)){
            displayBox(box);
            System.out.println("Match Draw");
        }
        
        in.close();
    }
    public static boolean hasSpace(char[][] box){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(box[i][j]==' '){
                    return true;
                }
            }
        }
        return false;
    }
    public static void displayBox(char[][] box){
        System.out.println("-------");
        for(int i=0;i<3;i++){
            System.out.print("|");
            for(int j=0;j<3;j++){
                System.out.print(box[i][j]+"|");
            }
            System.out.println();
            System.out.println("-------");
        }
    }
    public static boolean checkGameOver(char[][] box,char player){
        for(int i=0;i<3;i++){
            if(box[i][0] == player && box[i][1]==player && box[i][2]==player){
                System.out.println(player+" is winner!");

                return true;
            }
            if(box[0][i] == player && box[1][i]==player && box[2][i]==player){
                System.out.println(player+" is winner!");
                return true;
            }
        }
        if(box[0][0]==player && box[1][1]==player && box[2][2]==player){
            System.out.println(player+" is winner!");
            return true;
        }
        if(box[0][2]==player && box[1][1]==player && box[2][0]==player){
            System.out.println(player+" is winner!");
            return true;
        }
        return false;
    }

}
