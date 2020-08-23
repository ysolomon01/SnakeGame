import java.util.Scanner;

public class SnakeGame
{
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









































