package com.tictactoe;

import java.util.Scanner;

public class TicTacToe {

    private Player players[] = new Player[2];
    private Board board;
    private int currentPlayer = -1;
    int n = 0;
    private Scanner scanner;
    private int[] rowSum, colSum;
    private int diagSum, crossDiagSum;

    public TicTacToe(){
        scanner = new Scanner(System.in);
    }
    private void initializeTicTacToe(){
        board = new Board(n);
        this.rowSum = new int[n];
        this.colSum = new int[n];
        System.out.print("Please enter the first Player name : ");
        players[0] = new Player(scanner.next());
        System.out.print("Please enter the second Player name : ");
        players[1] = new Player(scanner.next());
    }
    public void play() {
        System.out.println("Please enter the size of the board");
        n = scanner.nextInt();
        if(n<3){
            try {
                throw new Exception("Invalid board size "+n);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        initializeTicTacToe();

        for(int i=0;i<3;i++)System.out.println();
        System.out.println("Game started");
        while(true){
            this.board.printBoard();
            System.out.println("Player "+players[(currentPlayer==-1?0:1)].getName());
            System.out.println("Please enter the row and col values");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            move(row,col);
            if(isWinner(row,col)){
                System.out.println("Congractulations! Player "+players[(currentPlayer==-1?0:1)].getName()+" is the winner");
                System.out.println("Game Over");
                return;
            }
            if(currentPlayer==1){
                currentPlayer=-1;
            }
            else currentPlayer=1;
        }
    }

    private void move(int i, int j){
        if(i>0 && i>=n && j>0 && j>=n){
            throw new IndexOutOfBoundsException("Entered value row "+i+" and column "+j+" is out of board length");
        }else if(this.board.getGridVal(i,j)!=0){
            throw new RuntimeException("The entered index value is already present");
        }else{
            this.board.setGridVal(i,j,currentPlayer);
            this.rowSum[i]+=currentPlayer;
            this.colSum[j]+=currentPlayer;
            if(i==j) diagSum+=currentPlayer;
            if(i==n-1-j){
                crossDiagSum+=currentPlayer;
            }
        }
    }

    private boolean isWinner(int i, int j){
        if(Math.abs(rowSum[i])==n || Math.abs(colSum[j])==n || Math.abs(diagSum)==n || Math.abs(crossDiagSum)==n) return true;
        return false;
    }
}

//public class TicTacToe {
//
//    private int board[][];
//    private int n ;
//    private int currentPlayer = 1;
//    private int steps = 0;
//    private int[] rowSum, colSum;
//    private int diagSum, crossDiagSum;
//
//    public  TicTacToe(){
//        this(3);
//    }
//    public TicTacToe(int n){
//        this.board = new int[n][n];
//        this.rowSum = new int[n];
//        this.colSum = new int[n];
//        this.diagSum = 0;
//        this.crossDiagSum = 0;
//        this.n=n;
//    }
//
//    public void move(int i, int j){
//        if(i>0 && i>=n && j>0 && j>=n){
//            throw new IndexOutOfBoundsException("Entered value row "+i+" and column "+j+" is out of board length");
//        }else if(board[i][j]!=0){
//            throw new RuntimeException("The entered index value is already present");
//        }else{
//            board[i][j]= currentPlayer;
//            rowSum[i]+=currentPlayer;
//            colSum[j]+=currentPlayer;
//            if(i==j) diagSum+=currentPlayer;
//            if(i==n-1-j){
//                crossDiagSum+=currentPlayer;
//            }
//        }
//    }
//
//    public void play(){
//        Scanner scanner = new Scanner(System.in);
//        while(true){
//            System.out.println("Player "+currentPlayer);
//            System.out.println("Please enter row and column values");
//            int i = scanner.nextInt();
//            int j = scanner.nextInt();
//            move(i,j);
//            boolean winner = isWinner(i,j);
//            if(winner) {
//                System.out.println("Player "+(currentPlayer==-1?2:1)+" is the winner");
//                System.out.println("Game Over");
//                return;
//            }
//            if(currentPlayer==1){
//                currentPlayer=-1;
//            }
//            else currentPlayer=1;
//            steps++;
//        }
//    }
//    public boolean isWinner(int i,int j){
//
////        boolean column = true;
////        boolean row = true;
////        boolean diagonal = true;
////        boolean crossdiagonal = true;
////
////        for(int i=0;i<n;i++){
////            //column
////            column = column && board[i][0]==currentPlayer;
////            //row
////            row = row && board[0][i]==currentPlayer;
////            //diagonal
////            diagonal = diagonal && board[i][i]==currentPlayer;
////            //crossdiagonal
////            crossdiagonal = crossdiagonal && board[i][n-1-i]==currentPlayer;
////        }
////        return (column || row || diagonal || crossdiagonal);
//
//        if(Math.abs(rowSum[i])==n || Math.abs(colSum[j])==n || Math.abs(diagSum)==n || Math.abs(crossDiagSum)==n) return true;
//        return false;
//    }
//}
