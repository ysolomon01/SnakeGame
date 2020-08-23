/**
* The class Food creates an object that simulates the food a snake eats in a game of Snake.
*
* @author Yordanos SOlomon
* @version 1.0
* @since 2019-11-06
*/

public class Food
{
	int foodRow;
	int foodCol;

	/**
	* Food constructor in which a new food object is created where foodRow and foodCol values are set to 0.
	*/
	public Food()
	{
		foodRow = 0;
		foodCol = 0;
	}

	/**
	* Food copy constructor in which the instance variables foodRow and foodCol are set to the instance variables of another Food object.
	* @param f the Food object to be copied
	*/
	public Food(Food f)
	{
		foodRow = f.foodRow;
		foodCol = f.foodCol;
	}

	/**
	* Method that returns the row value of the Food object
	*
	* @return the foodRow value of this object
	*/
	public int getRow()
	{
		return foodRow;
	}

	/**
	* Method that returns the column value of the Food object
	*
	* @return the foodCol value of this object
	*/
	public int getCol()
	{
		return foodCol;
	}

	/**
	* Method that changes the value of foodRow to the user-inputted value.
	*
	* @param row the new row value for the food object
	*/
	public void setRow(int row)
	{
		foodRow = row;
	}

	/**
	* Method that changes the value of foodCol to the user-inputted value.
	*
	* @param col the new column value for the food object
	*/
	public void setCol(int col)
	{
		foodCol = col;
	}

	/**
	* Method that returns the location of the food object (foodCol, foodRow)
	*
	* @return the location of the food object in terms of (x,y) coordinates
	*/
	public String toString()
	{
		return "The food is at position (" + foodCol + ", " + foodRow + ")";
	}	

	/**
	* Method that checks if two Food objects are the same
	* @param f the Food object to be compared
	* @return whether the objects are the same
	*/
	public boolean equals(Food f)
	{
		if (foodRow == f.foodRow && foodCol == f.foodCol)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}