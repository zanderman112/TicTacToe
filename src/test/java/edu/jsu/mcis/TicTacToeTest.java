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
		assertEquals(false, model.checkIsGameOver());
	}
	
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
		
		for(int i = 0; i < 3; i++){
			model.makeMark("X", 0, i);
		}
		assertEquals(true, model.checkGameStatus());
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				model.makeMark("X", i, j);
			}
		}
		assertEquals(true, model.checkGameStatus());
	}	
	
}







