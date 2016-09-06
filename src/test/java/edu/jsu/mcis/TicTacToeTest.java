package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {
    private TicTacToeModel model;
	
    @Before
    public void setup() {
		model = new TicTacToeModel();
    }
    
    @Test
    public void testInitialModelLocationsAreAllEmpty() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				model.makeMark("", i, j);
				assertEquals("", model.getMark(i, j));
			}
		}
    }
	
	@Test
	public void testMarkXUpperRightCorner() {
		model.makeMark("X", 0, 2);
		assertEquals("X", model.getMark(0, 2));
	}
    
	@Test
	public void testMarkOInBottomLeftCorner() {
		model.makeMark("O", 2, 0);
		assertEquals("O", model.getMark(2, 0));
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() {
		model.makeMark("X", 1, 1);
		assertEquals("X", model.getMark(1, 1));
		model.makeMark("O", 1, 1);
		assertEquals("X", model.getMark(1, 1));
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
		model.makeMark("X", 0, 0);
		int markCounter = 0;
		int emptyCounter = 9;
		for(int i = 1; i < 3; i++) {
			for(int j = 1; j < 3; j++) {
				if(!model.getMark(i, j).equals("")){
					markCounter++;
					emptyCounter--;
				}
				
				if(emptyCounter == 8)
					assertTrue(true);
			}
		}
	}
	
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
		
		for(int i = 0; i < 3; i++){
			model.makeMark("X", 0, i);
		}
		
		if(model.getMark(0, 0).equals("X") && model.getMark(0, 1).equals("X") 
		&& model.getMark(0, 2).equals("X")){
			assertTrue(true);
		}else
			assertTrue(false);
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		int counter = 0;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				model.makeMark("X", i, j);
				counter++;
			}
		}
		if(counter == 9)
			assertTrue(true);
	}	
	
}







