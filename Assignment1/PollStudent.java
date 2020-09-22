/****************************************************************************************
 * Name       : Milan Bui
 * Date       : 21 September 2020
 * Class      : CS 3560
 * Assignment : Assignment 1
 * Description: A student taking a poll. Has a unique id as a string and their answer as
 *              a string.
 ****************************************************************************************/
package CS3560_Assignment1;

public class PollStudent implements Student{
	
	// INSTANCE VARIABLES
	private String id;     // Student's unique ID
	private String answer; // Student's answer. If multiple answers, separated by "\n"
	
	// CONSTRUCTOR
	/************************************************************************************
	 * Default Constructor
	 * ----------------------------------------------------------------------------------
	 * Initializes id and answer
	 * ----------------------------------------------------------------------------------
	 * Parameters:
	 *     none
	 * Return:
	 *     none
	 ************************************************************************************/
	public PollStudent() {
		this.id = "";
		this.answer = "";
	}
	
	
	/************************************************************************************
	 * Constructor
	 * ----------------------------------------------------------------------------------
	 * Initializes id and answer
	 * ----------------------------------------------------------------------------------
	 * Parameters:
	 *     id  (String) - student's ID 
	 *     ans (String) - student's answer
	 * Return:
	 *     none
	 ************************************************************************************/
	public PollStudent(String id,  // IN - student's ID
			           String ans) // IN - student's answer
	{
		this.id = id;
		this.answer = ans;
	}
	
	// MUTATORS
	/************************************************************************************
	 * Mutator | setID | Student interface method
	 * ----------------------------------------------------------------------------------
	 * Sets the student's ID to given string.
	 * ----------------------------------------------------------------------------------
	 * Parameters:
	 *     id (String) - student's ID
	 * Returns:
	 *     none
	 ************************************************************************************/
	@Override
	public void setID(String id) // IN - student's ID
	{
		this.id = id;
	}
	
	
	/************************************************************************************
	 * Mutator | setAnswer
	 * ----------------------------------------------------------------------------------
	 * Sets the student's answer to given string.
	 * ----------------------------------------------------------------------------------
	 * Parameters:
	 *     ans (String) - student's answer
	 * Returns:
	 *     none
	 ************************************************************************************/
	public void setAnswer(String ans) // IN - student's answer
	{
		answer = ans;
	}
	
	// ACCESSORS
	/************************************************************************************
	 * Accessor | getID
	 * ----------------------------------------------------------------------------------
	 * Returns studen't id
	 * ----------------------------------------------------------------------------------
	 * Parameters:
	 *     none
	 * Return:
	 *     id (String) - student's ID
	 ************************************************************************************/
	public String getID(){
		return id;
	}
	
	
	/************************************************************************************
	 * Accessor | getAnswer
	 * ----------------------------------------------------------------------------------
	 * Returns student's answer
	 * ----------------------------------------------------------------------------------
	 * Parameters:
	 *     none
	 * Return:
	 *     answer (String) - student's answer
	 ************************************************************************************/
	public String getAnswer(){
		return answer;
	}
}
