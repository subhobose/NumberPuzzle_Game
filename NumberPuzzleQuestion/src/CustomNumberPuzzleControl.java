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
		int clickId=-1;
		for(int i=0;i<buttons.length;i++)
		{
			if(buttons[i]==buttonClicked)
			{
				clickId=i;
			}
		}
		//horizontal traversal
		if(Math.abs(clickId-emptyCellId)==1)
		{
		swapButton(buttons[emptyCellId],buttonClicked);
		emptyCellId=clickId;
		}
		//vertical traversal
		else if(clickId+4==emptyCellId || clickId-4==emptyCellId)
		{
			swapButton(buttons[emptyCellId],buttonClicked);
			emptyCellId=clickId;
		}
		
		return emptyCellId;

	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		//Your logic here
		//logic for generating random between 1-15
		int i=0;
		while(i<15) {
			int a=getRandomNumber();
			if(a>=1 && a<=15) {
				int flag=0;
				for(int j=0;j<=i;j++) {
					if(arr[j]==a) {
						flag=1;
						break;
					}
				}
				if(flag==0) {
					arr[i]=a;
					i++;
				}
			}
		}	
		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		int[] arr= getIntegerArrayOfButtonIds(buttons);
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=i+1) {
				winner=false;
				break;
			}
		}
		return winner;
	}
}