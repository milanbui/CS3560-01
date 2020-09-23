/****************************************************************************************
 * Name       : Milan Bui
 * Date       : 21 September 2020
 * Class      : CS 3560
 * Assignment : Assignment 1
 ****************************************************************************************/
package CS3560_Assignment1;

/****************************************************************************************
 * Answer Class
 *    This class represents an Answer object and it manages 2 attributes: answer and
 *    isCorrect.
 ****************************************************************************************/
public class Answer 
{
	// INSTANCE VARIABLES
	private String answer;      // IN/OUT - Answer
	private boolean isCorrect;  // IN/OUT - Whether the answer is correct or not
	
	// CONSTRUCTOR
	/************************************************************************************
	 * Default Constructor
	 * ----------------------------------------------------------------------------------
	 * Initializes answer and isCorrect variables
	 * ----------------------------------------------------------------------------------
	 * Parameters:
	 *     none
	 * Return:
	 *     none
	 ************************************************************************************/
	public Answer()
	{
		this.answer = "";
		this.isCorrect = false;
	}
	
	
	/************************************************************************************
	 * Constructor
	 * ----------------------------------------------------------------------------------
	 * Initializes answer and isCorrect variables
	 * ----------------------------------------------------------------------------------
	 * Parameters:
	 *     answer    (String) - answer option
	 *     isCorrect (boolean)- whether the answer is a correct answer
	 * Return:
	 *     none
	 ************************************************************************************/
	public Answer(String answer,     // IN - answer option
			      boolean isCorrect) // IN - whether answer is a correct answer
	{
		this.answer = answer;
		this.isCorrect = isCorrect;
	}
	
	// Mutators
	/************************************************************************************
	 * Mutator | setAnswer
	 * ----------------------------------------------------------------------------------
	 * Sets answer to given string
	 * ----------------------------------------------------------------------------------
	 * Parameters:
	 *     answer (String) - the answer option
	 * Return:
	 *     none
	 ************************************************************************************/
	public void setAnswer(String answer) // IN - answer option
	{
		this.answer = answer;
	}
	
	/************************************************************************************
	 * Mutator | setIsCorrect
	 * ----------------------------------------------------------------------------------
	 * Sets isCorrect to given variable (true or false)
	 * ----------------------------------------------------------------------------------
	 * Parameters:
	 *     isCorrect (boolean) - the poll question
	 * Return:
	 *     none
	 ************************************************************************************/
	public void setIsCorrect(boolean isCorrect) // IN - if answer is a correct answer
	{
		this.isCorrect = isCorrect;
	}
	
	// Accessors
	/************************************************************************************
	 * Accessor | getAnswer
	 * ----------------------------------------------------------------------------------
	 * Returns the answer option
	 * ----------------------------------------------------------------------------------
	 * Parameters: none
	 * Return:
	 *     answer (String) - the answer option
	 ************************************************************************************/
	public String getAnswer()
	{
		return answer;
	}
	
	/************************************************************************************
	 * Accessor | getIsCorrect
	 * ----------------------------------------------------------------------------------
	 * Returns isCorrect -> whether answer is a correct answer
	 * ----------------------------------------------------------------------------------
	 * Parameters: none
	 * Return:
	 *     isCorrect (boolean) - whether answer is a correct answer
	 ************************************************************************************/
	public boolean getIsCorrect()
	{
		return isCorrect;
	}

}
