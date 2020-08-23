import java.util.Scanner;

/**
* The Game program implements an application that simulates the classic arcade game snake.
* 
* This program uses the classes Board, Cell, Food, and Snake in order to run a fullly functional game of snake.
*
* @author  Yordanos Solomon
* @version 1.0
* @since   2019-11-06 
*/
public class Game
{
	char lastMove = '0';
	boolean gameOver = false;
	Board board = new Board();
	Snake snake = new Snake();

	/**
	* Game constructor in which a new Game object is created where board and snake are instantiated as new Board and Snake objects
	* respectively and gameOver is set to false.
	*/
	public Game()
	{
		gameOver = false;
		board = new Board();
		snake = new Snake();
		board.board[snake.row][snake.col].fillCell(Snake.class);
	}

	/**
	* Game copy constructor in which the instance variables board, snake, and gameOver are set to the instance variables of another Game object.
	* @param g the Game object to be copied
	*/
	public Game(Game g)
	{
		gameOver = g.gameOver;
		board = g.board;
		snake = g.snake;
	}

	/**
	* Method that returns the value of last move made.
	* @return the last move made
	*/
	public char getLastMove()
	{
		return lastMove;
	}

	/**
	* Method that returns the status of the game.
	* @return whether or not the game is over
	*/
	public boolean getStatus()
	{
		return gameOver;
	}

	/**
	* Method that returns the game board.
	* @return the current board
	*/
	public Board getBoard()
	{
		return board;
	}

	/**
	* Method that returns the snake.
	* @return the current snake
	*/
	public Snake getSnake()
	{
		return snake;
	}

	/**
	* Method that checks user input and decides what move to make next.
	* @param choice the choice made by the user
	*/
	public void nextMove(char choice)
	{
		Scanner in = new Scanner(System.in);

		try
		{
			if (choice != 'w' && choice != 'a' && choice != 's' && choice != 'd' && choice != 'l')
			{
				throw new Exception("Please enter w, a, s, d, or l to continue the game. ");
			}
		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
			nextMove(in.next().charAt(0));
		}

		switch (choice)
			{
				case 'w':
				    moveUp();
					break;
				case 'a':
				    moveLeft();
					break;
				case 's':
				    moveDown();
					break;
				case 'd':
				    moveRight();
					break;
				case 'l':
				    System.out.print("\033[H\033[2J");
					System.out.println("Your current length is " + snake.length);
			}
	}

	/**
	* Method that moves the head of the snake up one unit and changes the position of 
	* the rest of the snake objects in body to the values of the one ahead of it.
	*/
	public void moveUp()
	{
		int tailRow, tailCol;
		int headRow, headCol;
		System.out.print("\033[H\033[2J");
		headRow = snake.body.get(0).row;
		headCol = snake.body.get(0).col;
		tailRow = snake.body.get(snake.length-1).row;
		tailCol = snake.body.get(snake.length-1).col; 

		if (headRow + 1 < 20 && lastMove != 's')
		{
			if (headRow + 1 < 20 && (board.board[headRow+1][headCol].getFillType() == null))
			{
				board.board[tailRow][tailCol].clear();

				for (int i = snake.length-1; i > 0; i--)
				{
					snake.body.get(i).setRow(snake.body.get(i-1).getRow());
					snake.body.get(i).setCol(snake.body.get(i-1).getCol());
				}
				lastMove = 'w';

				board.board[headRow+1][headCol].fillCell(Snake.class);
				snake.body.get(0).setRow(headRow + 1);
			}
			else if ((board.board[headRow+1][headCol].getFillType() == Food.class))
			{	
				board.board[tailRow][tailCol].clear();

				for (int i = snake.length-1; i > 0; i--)
				{
					snake.body.get(i).setRow(snake.body.get(i-1).getRow());
					snake.body.get(i).setCol(snake.body.get(i-1).getCol());
				}
				lastMove = 'w';
				
				snake.eat();

				snake.body.get(0).setRow(headRow + 1);
				board.board[headRow+1][headCol].fillCell(Snake.class);
	
				board.spawnFood();
			}
			else if (board.board[headRow+1][headCol].getFillType() == Snake.class)
			{
				gameOver = true;
			}
			else
			{
				System.out.println("You cannot move up.");
			}
		}
		else 
		{
			System.out.println("You cannot move up.");
		}
	}

	/**
	* Method that moves the head of the snake down one unit and changes the position of 
	* the rest of the snake objects in body to the values of the one ahead of it.
	*/
	public void moveDown()
	{
		int tailRow, tailCol;
		int headRow, headCol;
		System.out.print("\033[H\033[2J");
		headRow = snake.body.get(0).row;
		headCol = snake.body.get(0).col;
		tailRow = snake.body.get(snake.length-1).row;
		tailCol = snake.body.get(snake.length-1).col;
		if (headRow - 1 >= 0 && lastMove != 'w')
		{
			if (headRow - 1 >= 0 && (board.board[headRow-1][headCol].getFillType() == null))
			{
				board.board[tailRow][tailCol].clear();

				for (int i = snake.length-1; i > 0; i--)
				{
					snake.body.get(i).setRow(snake.body.get(i-1).getRow());
					snake.body.get(i).setCol(snake.body.get(i-1).getCol());
				}
				lastMove = 's';
				snake.body.get(0).setRow(headRow - 1);
				board.board[headRow-1][headCol].fillCell(Snake.class);

			}
			else if ((board.board[headRow-1][headCol].getFillType() == Food.class))
			{
				board.board[tailRow][tailCol].clear();
				for (int i = snake.length-1; i > 0; i--)
				{
					snake.body.get(i).setRow(snake.body.get(i-1).getRow());
					snake.body.get(i).setCol(snake.body.get(i-1).getCol());
				}
				lastMove = 's';
				
				snake.body.get(0).setRow(headRow - 1);
				snake.eat();
				
				board.board[headRow-1][headCol].fillCell(Snake.class);

				board.spawnFood();
			}
			else if (board.board[headRow-1][headCol].getFillType() == Snake.class)
			{
				gameOver = true;
			}
			else
			{
				System.out.println("You cannot move down.");
			}
		}
		else
		{
			System.out.println("You cannot move down.");
		}
	}

	/**
	* Method that moves the head of the snake right one unit and changes the position of 
	* the rest of the snake objects in body to the values of the one ahead of it.
	*/
	public void moveRight()
	{
		int tailRow, tailCol;
		int headRow, headCol;
		System.out.print("\033[H\033[2J");
		headRow = snake.body.get(0).row;
		headCol = snake.body.get(0).col;
		tailRow = snake.body.get(snake.length-1).row;
		tailCol = snake.body.get(snake.length-1).col; 
		if (headCol + 1 < 20 && lastMove != 'a')
		{
			if (headCol + 1 < 20 && (board.board[headRow][headCol+1].getFillType() == null))
			{
				board.board[tailRow][tailCol].clear();

				for (int i = snake.length-1; i > 0; i--)
				{
					snake.body.get(i).setRow(snake.body.get(i-1).getRow());
					snake.body.get(i).setCol(snake.body.get(i-1).getCol());
				}
				lastMove = 'd';

				snake.body.get(0).setCol(headCol + 1);
				board.board[headRow][headCol+1].fillCell(Snake.class);
			}
			else if ((board.board[headRow][headCol+1].getFillType() == Food.class))
			{
				board.board[tailRow][tailCol].clear();
				for (int i = snake.length-1; i > 0; i--)
				{
					snake.body.get(i).setRow(snake.body.get(i-1).getRow());
					snake.body.get(i).setCol(snake.body.get(i-1).getCol());
				}
				lastMove = 'd';
				
				snake.body.get(0).setCol(board.food.foodCol);
				snake.eat();
				

				board.board[headRow][headCol+1].fillCell(Snake.class);
	
				board.spawnFood();
			}
			else if (board.board[headRow][headCol+1].getFillType() == Snake.class)
			{
				gameOver = true;
			}
			else
			{
				System.out.println("You cannot move right.");
			}
		}
		else
		{
			System.out.println("You cannot move right.");
		}
	}

	/**
	* Method that moves the head of the snake left one unit and changes the position of 
	* the rest of the snake objects in body to the values of the one ahead of it.
	*/
	public void moveLeft()
	{
		int tailRow, tailCol;
		int headRow, headCol;
		System.out.print("\033[H\033[2J");
		headRow = snake.body.get(0).row;
		headCol = snake.body.get(0).col;
		tailRow = snake.body.get(snake.length-1).row;
		tailCol = snake.body.get(snake.length-1).col; 
		if (headCol - 1 >= 0 && lastMove != 'd')
		{
			if (headCol - 1 >= 0 && (board.board[headRow][headCol-1].getFillType() == null))
			{
				board.board[tailRow][tailCol].clear();

				for (int i = snake.length-1; i > 0; i--)
				{
					snake.body.get(i).setRow(snake.body.get(i-1).getRow());
					snake.body.get(i).setCol(snake.body.get(i-1).getCol());
				}
				lastMove = 'a';

				board.board[headRow][headCol-1].fillCell(Snake.class);
				snake.body.get(0).setCol(headCol - 1);
			}
			else if ((board.board[headRow][headCol-1].getFillType() == Food.class))
			{
				board.board[tailRow][tailCol].clear();
				for (int i = snake.length-1; i > 0; i--)
				{
					snake.body.get(i).setRow(snake.body.get(i-1).getRow());
					snake.body.get(i).setCol(snake.body.get(i-1).getCol());
				}
				lastMove = 'a';
				
				snake.body.get(0).setCol(board.food.foodCol);
				snake.eat();
				

				board.board[headRow][headCol-1].fillCell(Snake.class);
	
				board.spawnFood();
			}
			else if (board.board[headRow][headCol-1].getFillType() == Snake.class)
			{
				gameOver = true;
			}
			else
			{
				System.out.println("You cannot move left.");
			}
		}
		else
		{
			System.out.println("You cannot move left.");
		}
	}

	/**
	* Method that checks if all of the objects within two Games are identical
	* @param g the Game object to be compared
	* @return whether the objects are the same
	*/
	public boolean equals(Game g)
	{
		if (snake.equals(g.snake) && board.equals(g.board) && gameOver == g.gameOver && lastMove == g.lastMove)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	* Method that returns the Game
	*
	* @return the String representation of the Game
	*/
	public String toString()
	{
		return snake + "\n" + board.food + "\n" + board + "Is the game over: " + gameOver;
	}

	/**
	* Main method that runs the game.
	*
	* The method begins a do/while loop that allows the user to make moves (up/down/left/right), 
	* by entering w/a/s/d respectively, to eat the food randomly spawned in a Board object and
	* allows the user to move until the generated snake runs into itself.
	*/
	public static void main(String[] args)
	{
		Game game = new Game();
		Scanner in = new Scanner(System.in);

		System.out.println("Welcome to the game Snake!\nThe rules of the game are simple:\nMove towards the food, and for every one you eat, the tail of the snake gets longer.\nIf you eat your own tail, you lose!");
		System.out.println("To move up, enter w.\nTo move left, enter a.\nTo move down, enter s.\nTo move right, enter d.\nTo see how long your snake is, enter l.\nEnjoy the game and good luck!");
		do
		{
			game.board.displayBoard();
			game.nextMove(in.next().charAt(0));
		}
		while(!game.getStatus() && game.snake.length != 400);

		System.out.println("You lose! Your final score is " + game.snake.getLength() + "\nThank you for playing!");
	}
}