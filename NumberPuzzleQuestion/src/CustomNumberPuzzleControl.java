import java.awt.*;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		
		//Your logic here
		/*
		 * 		
		 * 		0  1  2  3 
		 * 		4  5  6  7
		 * 		8  9  10 11
		 * 		12 13 14 15
		 */
		// if at pos 1 and 2 it can move left, right and bottom
		if(emptyCellId == 1 || emptyCellId == 2) { 
			if(buttonClicked == buttons[emptyCellId+1]) {
				swapButton(buttons[emptyCellId], buttonClicked);
				emptyCellId += 1;
			}
			else if(buttonClicked == buttons[emptyCellId-1]) {
				swapButton(buttons[emptyCellId], buttonClicked);
				emptyCellId -= 1;
			}
			else if(buttonClicked == buttons[emptyCellId+4]) {
				swapButton(buttons[emptyCellId], buttonClicked);
				emptyCellId += 4;
			}
		}
		// if pos at 7 and 11 it can move up, down and left
		else if(emptyCellId == 7 || emptyCellId == 11) { 
			if(buttonClicked == buttons[emptyCellId-1]) {
				swapButton(buttons[emptyCellId], buttonClicked);
				emptyCellId -= 1;
			}
			else if(buttonClicked == buttons[emptyCellId-4]) {
				swapButton(buttons[emptyCellId], buttonClicked);
				emptyCellId -= 4;
			}
			else if(buttonClicked == buttons[emptyCellId+4]) {
				swapButton(buttons[emptyCellId], buttonClicked);
				emptyCellId += 4;
			}
		}
		// if pos at 13 and 14 it can mov left, right and up.
		else if(emptyCellId == 13 || emptyCellId == 14) { 
			if(buttonClicked == buttons[emptyCellId+1]) {
				swapButton(buttons[emptyCellId], buttonClicked);
				emptyCellId += 1;
			}
			else if(buttonClicked == buttons[emptyCellId-1]) {
				swapButton(buttons[emptyCellId], buttonClicked);
				emptyCellId -= 1;
			}
			else if(buttonClicked == buttons[emptyCellId-4]) {
				swapButton(buttons[emptyCellId], buttonClicked);
				emptyCellId -= 4;
			}
		}
		//if pos at 4 and 8 it can move up, down and right.
		else if(emptyCellId == 4 || emptyCellId == 8) { 
			if(buttonClicked == buttons[emptyCellId+1]) {
				swapButton(buttons[emptyCellId], buttonClicked);
				emptyCellId += 1;
			}
			else if(buttonClicked == buttons[emptyCellId-4]) {
				swapButton(buttons[emptyCellId], buttonClicked);
				emptyCellId -= 4;
			}
			else if(buttonClicked == buttons[emptyCellId+4]) {
				swapButton(buttons[emptyCellId], buttonClicked);
				emptyCellId += 4;
			}
		}
		else if(emptyCellId == 5 || emptyCellId == 6 || emptyCellId == 9 || emptyCellId == 10) { 
			if(buttonClicked == buttons[emptyCellId+1]) {
				swapButton(buttons[emptyCellId], buttonClicked);
				emptyCellId += 1;
			}
			else if(buttonClicked == buttons[emptyCellId-1]) {
				swapButton(buttons[emptyCellId], buttonClicked);
				emptyCellId -= 1;
			}
			else if(buttonClicked == buttons[emptyCellId+4]) {
				swapButton(buttons[emptyCellId], buttonClicked);
				emptyCellId += 4;
			}
			else if(buttonClicked == buttons[emptyCellId-4]) {
				swapButton(buttons[emptyCellId], buttonClicked);
				emptyCellId -= 4;
			}
		}
		else if(emptyCellId == 0) {
			if(buttonClicked == buttons[emptyCellId+1]) {
				swapButton(buttons[emptyCellId], buttonClicked);
				emptyCellId += 1;
			}
			else if(buttonClicked == buttons[emptyCellId+4]) {
				swapButton(buttons[emptyCellId], buttonClicked);
				emptyCellId += 4;
			}
		}
		else if(emptyCellId == 3) {
			if(buttonClicked == buttons[emptyCellId-1]) {
				swapButton(buttons[emptyCellId], buttonClicked);
				emptyCellId -= 1;
			}
			else if(buttonClicked == buttons[emptyCellId+4]) {
				swapButton(buttons[emptyCellId], buttonClicked);
				emptyCellId += 4;
			}
		}
		else if(emptyCellId == 15) {
			if(buttonClicked == buttons[emptyCellId-1]) {
				swapButton(buttons[emptyCellId], buttonClicked);
				emptyCellId -= 1;
			}
			else if(buttonClicked == buttons[emptyCellId-4]) {
				swapButton(buttons[emptyCellId], buttonClicked);
				emptyCellId -= 4;
			}
		}
		else if(emptyCellId == 12) {
			if(buttonClicked == buttons[emptyCellId+1]) {
				swapButton(buttons[emptyCellId], buttonClicked);
				emptyCellId += 1;
			}
			else if(buttonClicked == buttons[emptyCellId-4]) {
				swapButton(buttons[emptyCellId], buttonClicked);
				emptyCellId -= 4;
			}
		}
		
		return emptyCellId;

	}
	
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		
		//Your logic here
		int a, i = 0;
		boolean[] check = new boolean[16];
		
		
		while(i<15) {
			a = getRandomNumber();
			if(a >= 1 && a<=15) {
				if(check[a] == false) {
					arr[i] = a;
					i++;
					check[a]=true;
//					System.out.printf("%d ", a);
				}
			}
		}
		return arr;
	}
	
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		int[] arr = new int[15];
		arr = getIntegerArrayOfButtonIds(buttons);
		for(int i=1; i<15; i++) {
			if(arr[i-1]>arr[i]) {
				return false;
			}
		}
		
		
		return winner;
	}
}