package com.tictactoe;

public class Board {

    private int[][] grid;
    public Board(){
        this(3);
    }
    public Board(int n){
        this.grid = new int[n][n];
    }
    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    public void setGridVal(int row, int col, int val){
        grid[row][col]=val;
    }
    public int getGridVal(int row,int col){
        return grid[row][col];
    }

    public void printBoard(){
        int n = grid.length;
        System.out.println(" ___ ___ ___");
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                int num = grid[i][j];
                System.out.print("| " + (num == -1 ? 'X' : (num == 0 ? ' ' : 'O'))+" ");
            }
            System.out.println(" |");
            System.out.println(" ___ ___ ___");
        }
    }
}
