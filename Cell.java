/**
* The class Cell creates an object that simulates the spaces on a board in a game of Snake.
*
* @author Yordanos SOlomon
* @version 1.0
* @since 2019-11-07
*/
public class Cell
{
	private Class fillType;
	
	/**
	* Cell constructor that creates an empty Cell object and sets fillType to null.
	*/
	public Cell()
	{
		fillType = null;
	}

	/**
	* Cell copy constructor in which the instance variable fillType are set to the instance variable of another Cell object.
	* @param c the Cell object to be copied
	*/
	public Cell(Cell c)
	{
		fillType = c.fillType;
	}

	/**
	* Method that returns the fillType of the current cell.
	* 
	* @return the fillType of the cell
	*/
	public Class getFillType()
	{
		return fillType;
	}

	/**
	* Method that setw the fillType to the inputted class type.
	* 
	* @param c the new value for fillType
	*/
	public void fillCell(Class c)
	{
		fillType = c;
	}

	/**
	* Method that empties the Cell object and sets the fillType to null.
	*/
	public void clear()
	{
		fillType = null;
	}

	public String toString()
	{
		if (fillType == null)
		{
			return "Empty";
		}
		else
		{
			return fillType.getName();
		}
	}

	/**
	* Method that checks if two Cell objects are the same
	* @param c the Cell object to be compared
	* @return whether the objects are the same
	*/
	public boolean equals(Cell c)
	{
		if (fillType == c.fillType)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}