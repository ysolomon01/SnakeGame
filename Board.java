import java.util.Scanner;
/**
* The class Board creates an object that simulates the board in a game of Snake.
*
* @author Yordanos Solomon
* @version 1.0
* @since 2019-11-06
*/
public class Board
{
	Cell[][] board;
	int fRow, fCol;
	Food food = new Food();

	/**
	* Board constructor in which the instance variable board is instantiated as a 20x20 two-dimensional array.
	* An instance of the Food class is also created and placed randomly within the array.
	*/
	public Board()
	{
		board = new Cell[20][20];
		for (int r = 0; r < board.length; r++)
		{
			for (int c = 0; c < board[0].length; c++)
			{
				board[r][c] = new Cell();
			}
		}
		spawnFood();
	}

	/**
	* Board copy constructor in which the instance variables board and food are set to the instance variables of another Board object.
	* @param b the Board object to be copied
	*/
	public Board(Board b)
	{
		board = b.board;
		food = b.food;
	}

	/**
	* Method that clears all of the values of each object in the board array.
	*/
	public void clearBoard()
	{
		for (int r = 0; r < board.length; r++)
		{
			for (int c = 0; c < board[0].length; c++)
			{
				board[r][c].clear();
			}
		}
	}

	/**
	* Method that displays the current board.
	*/
	public void displayBoard()
	{
		System.out.println("-----------------------------------------");
		for(int r = board.length-1; r >= 0; r--)
		{
			for(int c = 0; c < board[0].length; c++)
			{
				if (board[r][c].getFillType() == Snake.class)
				{
					System.out.print("|@");
				}
				else if (board[r][c].getFillType() == Food.class)
				{
					System.out.print("|*");
				}
				else
				{
					System.out.print("| ");
				}

				if (c == board[0].length-1)
				{
					System.out.println("|");
				}
			}
		}
		System.out.println("-----------------------------------------");
	}

	/**
	* Method that creates a new Food object and randomly assigns the object with valid row and column 
	* values and fills the cell at that position with the food object.
	*/
	public void spawnFood()
	{
		do
		{
			fRow = (int) (Math.random() * 20);
			fCol = (int) (Math.random() * 20);
		}
		while (!(board[fRow][fCol].getFillType() == null));

		food.setRow(fRow);
		food.setCol(fCol);

		board[fRow][fCol].fillCell(Food.class);
	}

	/**
	* Method that sets the Food object's row and column values with valid 
	* inputs and fills the cell at that position with the food object.
	*/
	public void setFood(int r, int c)
	{
		Scanner in = new Scanner(System.in);
		try
		{
			if (r < 0 || r >board.length || c < 0 || c > board[0].length)
			{
				throw new Exception("Your coordinate is out of bounds of the board.");
			}
			else
			{
				board[fRow][fCol].clear();
				fRow = r;
				fCol = c;
				board[fRow][fCol].fillCell(Food.class);
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage() + "\nPlease re-enter a row and column value: ");
			setFood(in.nextInt(), in.nextInt());
		}
	}

	/**
	* Method that returns the food variable
	* @return the food variable for the current board
	*/
	public Food getFood()
	{
		return food;
	}

	/**
	* Method that returns the  Board object
	*
	* @return the String representation of the board
	*/
	public String toString()
	{
		String output = "";
		for (int r = board.length-1; r >= 0; r--)
		{
			for (int c = 0; c < board[0].length; c++)
			{
				output += board[r][c] + " ";
			}
			output += "\n";
		}
		return output;
	}

	/**
	* Method that checks if all of the objects within two Boards are identical
	* @param b the Board object to be compared
	* @return whether the objects are the same
	*/
	public boolean equals(Board b)
	{
		for (int r = 0; r < board.length; r++)
		{
			for (int c = 0; c < board[0].length; c++)
			{
				if (board[r][c].getFillType() != b.board[r][c].getFillType());
				{
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args)
	{
		Board b = new Board();

		System.out.println(b.toString());
	}
}