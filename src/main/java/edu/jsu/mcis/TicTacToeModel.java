package edu.jsu.mcis;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeModel extends JPanel {
	private JButton[][] grid;
	//private JButton button;
	private JLabel turnLabel;
	private int userInput = 0;
	private String winner;
	
	
	public TicTacToeModel() {
		grid = new JButton[3][3];
		setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        turnLabel = new JLabel("Turn: X");
        panel.add(turnLabel);
        JPanel gameBoard = new JPanel(new GridLayout(3, 3));
		for(int row = 0; row < 3; row++){
			for(int col = 0; col < 3; col++){
				grid[row][col] = new JButton();
				grid[row][col].setText("");
				grid[row][col].addActionListener(new ButtonListener());
				gameBoard.add(grid[row][col]);
			}
		}
        add(panel, BorderLayout.NORTH);
        add(gameBoard, BorderLayout.CENTER);
		setPreferredSize(new Dimension(300, 300));
	}
	
	public String getMark(int row, int col) {
		if(grid[row][col] == 0){
			
			return "";
		}
		else if(grid[row][col] == 1) {
			return "X";
		}
		
		else{
			return "O";
		}
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
	
	private boolean checkForHorizontalWin(){
		if(grid[0][0] == grid[0][1] && grid [0][1] == grid[0][2]){
			return true;
		}
		else if(grid[1][0] == grid[1][1] && grid [1][1] == grid[1][2]){
			return true;
		}
		if(grid[2][0] == grid[2][1] && grid [2][1] == grid[2][2]){
			return true;
		}
		else return false;
	}
	
	private boolean checkForVerticalWin(){
		if(grid[0][0] == grid[1][0] && grid [1][0] == grid[2][0]){
			return true;
		}
		else if(grid[0][1] == grid[1][1] && grid [1][1] == grid[2][1]){
			return true;
		}
		else if(grid[0][2] == grid[1][2] && grid [1][1] == grid[2][2]){
			return true;
		}
		else return false;
	}
	
	private boolean checkForDiagonalWin(){
		if(grid[0][0] == grid[1][1] && grid [1][1] == grid[2][2]){
			return true;
		}
		else if(grid[0][2] == grid[1][1] && grid [1][1] == grid[2][0]){
			return true;
		}
		else return false;
	}
	
	private boolean checkForTie(){
		int markCounter = 0;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(grid[i][j] != 0){
					markCounter++;
				}
			}
		}
		if(markCounter == 9){
            turnLabel.setText("It's a DRAW!");
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public boolean checkIsGameOver(){
		int emptyCounter = 9;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(grid[i][j] != 0){
					emptyCounter--;
				}
			}
		}
		if(emptyCounter < 9){
			return false;
		}
		else return true;
		
	}
	
	public boolean checkGameStatus(){		
		
		if(checkForHorizontalWin() == true){
			return true;
		}
		else if(checkForVerticalWin() == true){
			return true;
		}
		else if(checkForDiagonalWin() == true){
			return true;
		}
		else if(checkForTie() == true){
			return true;
		}
		else{
			return false;
		}
	}
	
	private class ButtonListener implements ActionListener {
        /**
         * main method of ButtonListener
         * 
         * @param event ActionEvent object
         */
        public void actionPerformed(ActionEvent event) {
                Object source = event.getSource();
                JButton srcButton = (JButton) source;
                Font oldFont = srcButton.getFont();
                Font newFont = oldFont.deriveFont(60.0f);
                srcButton.setFont(newFont);
                
                if (userInput % 2 == 0) {
                    srcButton.setText("X");
					
                    turnLabel.setText("Turn: O");
                    winner = "X";
                }
                
                else {
                    srcButton.setText("O");
                    turnLabel.setText("Turn: X");
                    winner = "O";
                }
                userInput++;
                
                if(checkGameStatus() == true) {
                    turnLabel.setText(winner + " WINS!"); 
                    for(int row = 0; row < 3; row++){
                        for(int col = 0; col < 3; k++) {
                            srcButton.setEnabled(false);
                        }
                    }
                }
                else if (checkIsGameOver()) {
                    turnLabel.setText("DRAW!");
                    for(int row = 0; row < 3; row++){
                        for(int col = 0; col < 3; k++) {
                            srcButton.setEnabled(false);
                        }
                    }
                }
        }
    }
}
