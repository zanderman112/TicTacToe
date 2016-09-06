package keywords;

import edu.jsu.mcis.*;

public class TicTacToeKeywords {
	private TicTacToeModel model;
	private String mark;
	public void startNewGame(){
		 model = new TicTacToeModel();	
		 mark = "X";
	}
	
	public void markLocation(int r, int c){
		model.makeMark(mark, r, c);
		if(mark.equals("X")){
			mark = "O";
		}
		else if(mark.equals("O")){
			mark = "X";
		}
	}
	
	public String getMark(int r, int c){
		return model.getMark(r,c);
	}
	
	public String getWinner(){
		if(getMark(1,1).equals("X") && getMark(0,0).equals("X") && getMark(2,2).equals("X")){
			return "X";
		}
		else if(getMark(2,0).equals("O") && getMark(2,2).equals("O") && getMark(2,1).equals("O")){
			return "O";
		} 
		else if(getMark(1,1).equals("X") && getMark(0,0).equals("O") && getMark(2,0).equals("X") &&
		getMark(0,2).equals("O") && getMark(0,1).equals("X") && getMark(2,1).equals("O") && 
		getMark(1,2).equals("X") && getMark(1,0).equals("O") && getMark(2,2).equals("X")){
			return "TIE";
		}
		else return "ERROR";
	}
}
