import java.util.ArrayList;

/**
* The Snake creates an object that acts as a part of a snake's body.
* 
* Giving proper comments in your program makes it more
* user friendly and it is assumed as a high quality code.
* 
*
* @author  Yordanos Solomon
* @version 1.0
* @since   2019-11-06 
*/
public class Snake
{
	int row, col;
	ArrayList<Snake> body = new ArrayList<Snake>();
	int length = 1;
	int lastRow, lastCol;

	/**
	* Snake constructor in which a new Snake object is created with row and col values of 0.
	*/
	public Snake()
	{
		row = 0;
		col = 0;
		body.add(this);
		lastRow = body.get(length-1).row;
		lastCol = body.get(length-1).col;	
	}

	/**
	* Snake constructor in which a new Snake object is created from a pre-existing Snake object.
	* @param s the Snake object to be copied
	*/
	public Snake(Snake s)
	{
		row = s.row;
		col = s.col;
		lastRow = s.lastRow;
		lastCol = s.lastCol;
	}

	/**
	* Snake constructor in which a new Snake object's row and column values are set to user-inputted row and column values respectively.
	* The object is also added to the ArrayList body.
	* 
	* @param r the row value for the Snake object
	* @param c the column value for the Snake object
	*/
	public Snake(int r, int c)
	{
		row = r;
		col = c;
		lastRow = r;
		lastCol = c;
	}

	/**
	* Method that returns the current length of the Snake
	* @return the length of the snake
	*/
	public int getLength()
	{
		return length;
	}

	/**
	* Method that returns the row value of the Snake object
	* @return the row value of this object
	*/
	public int getRow()
	{
		return row;
	}

	/**
	* Method that returns the column value of the Snake object
	* @return the col value of this object
	*/
	public int getCol()
	{
		return col;
	}

	/**
	* Method that changes the value of row to the user-inputted value.
	* @param row the new row value for the Snake object
	*/
	public void setRow(int row)
	{
		this.row = row;
	}
	
	/**
	* Method that changes the value of col to the user-inputted value.
	* @param col the new column value for the Snake object
	*/
	public void setCol(int col)
	{
		this.col = col;
	}

	/**
	* This method increments the length variable by one and adds a new Snake object to the ArrayList body.
	* 
	* It uses the saved values of the last position of the tail and sets the new Snake object's row and col
	* values to those values.
	*/
	public void eat() //DO NOT FILL CELL FROM HERE OR SNAKE WILL BE DISJOINTED//
	{
		body.add(new Snake(lastRow, lastCol));
		length += 1;
	}

	/**
	* Method that returns the location of the Snake object (col, row)
	* @return the location of the Snake object in terms of (x,y) coordinates
	*/
	public String toString()
	{
		return "The snake's head is at position (" + col + ", " + row + ") and it is " + length + "units long.";
	}

	/**
	* Method that checks if two Snake objects are the same
	* @param s the Snake object to be compared
	* @return whether the objects are the same
	*/
	public boolean equals(Snake s)
	{
		if(row == s.row && col == s.col)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}