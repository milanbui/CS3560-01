/****************************************************************************************
 * Name       : Milan Bui
 * Date       : 21 September 2020
 * Class      : CS 3560
 * Assignment : Assignment 1
 ****************************************************************************************/
package CS3560_Assignment1;

/****************************************************************************************
 * PollStudent Class
 *    This class represents an PollStudent object that is derived from a Student object
 *    and it manages 1 attribute: answer.
 ****************************************************************************************/
public class PollStudent extends Student{
	
	// INSTANCE VARIABLES
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
		super();
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
		super(id);
		this.answer = ans;
	}
	
	// MUTATORS
	
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
