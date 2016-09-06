package edu.jsu.mcis;

public class TicTacToeModel {
	private int[][] grid;
	
	public TicTacToeModel() {
		grid = new int[3][3];
	}
	
	public String getMark(int row, int col) {
		if(grid[row][col] == 0) return "";
		else if(grid[row][col] == 1) return "X";
		else return "O";
	}
	
	public void makeMark(String mark, int row, int col) {
		if(grid[row][col] == 0) {
			if(mark.equals("X")){
				grid[row][col] = 1;
			}	
			else if(mark.equals("O")){
				grid[row][col] = 2;
			}
			else if(mark.equals("")){ 
				grid[row][col] = 0;
			}
		}
	}
}













