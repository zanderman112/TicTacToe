package edu.jsu.mcis;

import javax.swing.JFrame;


public class MainGame{

	
	public static void main(String[] args){
        JFrame TicTacToe = new JFrame("TicTacToe");
        TicTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        TicTacToeModel panel = (new TicTacToeModel());        
        TicTacToe.add(panel);
        
        TicTacToe.pack();
        TicTacToe.setVisible(true);
	}
}