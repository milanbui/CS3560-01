/****************************************************************************************
 * Name       : Milan Bui
 * Date       : 21 September 2020
 * Class      : CS 3560
 * Assignment : Assignment 1
 ****************************************************************************************/
package CS3560_Assignment1;
import java.util.ArrayList;

/****************************************************************************************
 * Question Class
 *    This class represents an Question object and it manages 3 attributes: question, 
 *    answerOptions, and isMultiple.
 ****************************************************************************************/
public class Question{
	
	// Instance Variables
	private String question;                 // A question for a poll
	private ArrayList<Answer> answerOptions; // Candidate answers for the poll
	private boolean isMultiple;              // Whether the question is multiple choice
	                                         // or single choice
	
	// CONSTRUCTORS
	/************************************************************************************
	 * Default Constructor
	 * ----------------------------------------------------------------------------------
	 * Initializes question and isMultiple and creates new object of ArrayList<Answer>
	 * ----------------------------------------------------------------------------------
	 * Parameters: none
	 * Return    : none
	 ************************************************************************************/
	public Question(){
		this.question = "";
		this.isMultiple = false;
		this.answerOptions = new ArrayList<Answer>();
	}
	
	/************************************************************************************
	 * Constructor
	 * ----------------------------------------------------------------------------------
	 * Initializes question and isMultiple and creates new object of ArrayList<Answer>
	 * ----------------------------------------------------------------------------------
	 * Parameters:
	 *     question   (String)  - the poll question
	 *     isMultiple (boolean) - whether the question is multiple choice or single choice
	 *     answerOptions (ArrayList<Answer>) - answer options
	 * Return:
	 *     none
	 ************************************************************************************/
	public Question(String question,                 // IN - poll question
			        ArrayList<Answer> answerOptions, // IN - answer options
			        boolean isMultiple)              // IN - if q is mult or single choice
	{                
		this.question = question;
		this.isMultiple = isMultiple;
		this.answerOptions = new ArrayList<Answer>();
		
		// Makes a copy of each answerOption to fill the class answerOption variable
		for(Answer option : answerOptions)
		{
			Answer temp = new Answer(option.getAnswer(), option.getIsCorrect());
			this.answerOptions.add(temp);
		}
	}
	
	
	// MUTATORS
	/************************************************************************************
	 * Mutator | setQuestion
	 * ----------------------------------------------------------------------------------
	 * Sets question to given string
	 * ----------------------------------------------------------------------------------
	 * Parameters:
	 *     question (String) - the poll question
	 * Return:
	 *     none
	 ************************************************************************************/
	public void setQuestion(String question) // IN - poll question
	{
		this.question = question;
	}

	
	/************************************************************************************
	 * Mutator | setAnswerOptions
	 * ----------------------------------------------------------------------------------
	 * Sets answer options to given array list of type Answer 
	 * ----------------------------------------------------------------------------------
	 * Parameters:
	 *     answerOptions (ArrayList<Answer>) - the answer options
	 * Return:
	 *     none
	 ************************************************************************************/
	public void setAnswerOptions(ArrayList<Answer> answerOptions) // IN - answer options
	{
		// Makes a copy of each answerOption to fill the class answerOption variable
		for(Answer option : answerOptions)
		{
			Answer temp = new Answer(option.getAnswer(), option.getIsCorrect());
			this.answerOptions.add(temp);
		}
	}
	
	
	/************************************************************************************
	 * Mutator | addAnswerOptions
	 * ----------------------------------------------------------------------------------
	 * Adds an answer option to the array list of answer options
	 * ----------------------------------------------------------------------------------
	 * Parameters:
	 *     answer    (String)  - the answer option
	 *     isCorrect (boolean) - if it is a correct answer
	 * Return:
	 *     none
	 ************************************************************************************/
	public void addAnswerOptions(String answer,     // IN - answer option
			                     boolean isCorrect) // IN - if it is a correct answer
	{
		// Creates a copy to add
		Answer temp = new Answer(answer, isCorrect);
		answerOptions.add(temp);
	}
	
	
	/************************************************************************************
	 * Mutator | setIsMultiple
	 * ----------------------------------------------------------------------------------
	 * Sets isMultiple variable to true or false depending on parameter
	 * ----------------------------------------------------------------------------------
	 * Parameters:
	 *     isMultiple (boolean) - if the question is multiple or single choice
	 * Return:
	 *     none
	 ************************************************************************************/
	public void setIsMultiple(boolean isMultiple) // IN - if mult choice or single choice
	{
		this.isMultiple = isMultiple;
	}

	
	// ACCESSOR
	/************************************************************************************
	 * Accessor | getQuestion
	 * ----------------------------------------------------------------------------------
	 * Returns the question
	 * ----------------------------------------------------------------------------------
	 * Parameters: none
	 * Return:
	 *     question (String) - the question for the poll
	 ************************************************************************************/
	public String getQuestion() {
		return this.question;
	}


	/************************************************************************************
	 * Accessor | getAnswerOptions
	 * ----------------------------------------------------------------------------------
	 * Returns the answer options as an Array List of type Answer
	 * ----------------------------------------------------------------------------------
	 * Parameters:
	 *     none
	 * Return:
	 *     temp (ArrayList<Answer) - answer options for poll question
	 ************************************************************************************/
	public ArrayList<Answer> getAnswerOptions() {
		ArrayList<Answer> temp = new ArrayList<Answer>();
		
		// Creates a copy of answerOption to return
		for(Answer option : this.answerOptions)
		{
			Answer tempAns = new Answer(option.getAnswer(), option.getIsCorrect());
			temp.add(tempAns);
		}
		return temp;
	}
	
	/************************************************************************************
	 * Accessor | getIsMultiple
	 * ----------------------------------------------------------------------------------
	 * Returns isMultiple
	 * ----------------------------------------------------------------------------------
	 * Parameters:
	 *     none
	 * Return:
	 *     isMultiple (boolean) - whether question is multiple or single choice
	 ************************************************************************************/
	public boolean getIsMultiple(){
		return this.isMultiple;
	}


}
