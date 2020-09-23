/****************************************************************************************
 * Name       : Milan Bui
 * Date       : 21 September 2020
 * Class      : CS 3560
 * Assignment : Assignment 1
 ****************************************************************************************/
package CS3560_Assignment1;
import java.util.ArrayList;

/****************************************************************************************
 * Voting Class
 *    This class represents a VotingService object and manages 3 attributes: question,
 *    acceptedAnswers, and ansStats.
 ****************************************************************************************/
public class VotingService{
	
	// INSTANCE VARIABLES
	private Question question;                        // Poll Question info
	private ArrayList<PollStudent> acceptedAnswers;   // Answers submitted by students
	private int[] ansStats;                           // Results of poll
	
	
	// CONSTRUCTORS
	/************************************************************************************
	 * Constructor
	 * ----------------------------------------------------------------------------------
	 * Initializes question and ansStats and creates new object of ArrayList<PollStudents>
	 * ----------------------------------------------------------------------------------
	 * Parameters:
	 *     question (Question) - the poll question with the answer options
	 * Return:
	 *     none
	 ************************************************************************************/
	public VotingService(Question question) // IN - contains info about poll question
	{
		this.question = new Question(question.getQuestion(), question.getAnswerOptions(),
			                         question.getIsMultiple());
		this.acceptedAnswers = new ArrayList<PollStudent>();
		this.ansStats = new int[question.getAnswerOptions().size()];
	}
	
	
	
	// MUTATORS
	/************************************************************************************
	 * Mutator | setQuestion
	 * ----------------------------------------------------------------------------------
	 * Sets question
	 * ----------------------------------------------------------------------------------
	 * Parameters:
	 *     question (Question) - A question
	 * Returns:
	 *     none
	 ************************************************************************************/
	public void setQuestion(Question question) // IN - a question
	{
		this.question = new Question(question.getQuestion(), question.getAnswerOptions(),
                                     question.getIsMultiple());
	}
	
	
	/************************************************************************************
	 * Mutator | addAnswer
	 * ----------------------------------------------------------------------------------
	 * Accepts answer submitted by give student
	 * ----------------------------------------------------------------------------------
	 * Parameters:
	 *     studentAns (PollStudent) - A PollStudent (has student's ID and answer)
	 * Returns:
	 *     none
	 ************************************************************************************/
	public void addAnswer(PollStudent studentAns) // IN - PollStudent (contains their ID 
	                                              //      and answer)
	{
		// Variables
		int size = acceptedAnswers.size(); // PROC - # of answers submitted
		int i = 0;                         // PROC - increment (counter)
		PollStudent temp = new PollStudent(studentAns.getID(), studentAns.getAnswer());
		
		// PROC - while index(i) is < max index - 1 AND given student ID does not match
		//        student ID at index i, loop through
		while(i < size-1 && !acceptedAnswers.get(i).getID().equals(temp.getID()))
		{
			i++;
		}
		
		
		// If this is not 1st answer to be submitted AND given ID matches one previously
		// used, change answer at that index
		if(size != 0 && acceptedAnswers.get(i).getID().equals(temp.getID()))
		{
			acceptedAnswers.set(i, temp);
		}
		// Else, add student and their answer to submitted answers
		else
		{
			acceptedAnswers.add(temp);
		}
	
	}
	
	
	/************************************************************************************
	 * Mutator | calcAnsStats
	 * ----------------------------------------------------------------------------------
	 * Calculates the # of times each answer option was selected.
	 * ----------------------------------------------------------------------------------
	 * Parameters: none
	 * Returns   : none
	 ************************************************************************************/
	private void calcAnsStats()
	{
		String[] answers; // Student's answer
		// If question is multiple choice
		if(question.getIsMultiple())
		{
			// For each student submission
			for(PollStudent studentAns : acceptedAnswers)
			{
				// Splits answer with "\n" as mult choice answer was submitted with \n
				// separating each selection
				answers = studentAns.getAnswer().split("\n");
				
				// For # of selected answer options
				for(int i = 0; i < answers.length; i++)
				{
					// For # of total answer options
					for(int j = 0; j < question.getAnswerOptions().size(); j++)
					{
						// If/when the answer selection matches the answer option
						if(answers[i].equals(question.getAnswerOptions().get(j).getAnswer()))
						{
							// Increment # of submissions for answer option by 1
							ansStats[j]++;
						}
					} // end answer option loop
					
					
				} // end selected/given answer loop
				
				
			} // end of if mult statement
			
			
		}// Else -> single choice
		else
		{
			// For each student submission
			for(PollStudent studentAns : acceptedAnswers)
			{
				for(int j = 0; j < question.getAnswerOptions().size(); j++)
				{
					if(studentAns.getAnswer().equals(question.getAnswerOptions().get(j).getAnswer()))
					{
						ansStats[j]++;
					} // end if statement
				} // end for loop
				
				
			} // end for loop (studentAns)
			
			
		} // end ...else statement
	} // end function
	
	
	
	// ACCESSORS
	/************************************************************************************
	 * Accessor | getQuestion
	 * ----------------------------------------------------------------------------------
	 * Returns question object. (Question, answer options, and question type)
	 * ----------------------------------------------------------------------------------
	 * Parameters: none
	 * Returns   : 
     *     temp (Question) - copy of question
	 ************************************************************************************/
	public Question getQuestion()
	{
		Question temp = new Question(this.question.getQuestion(), 
				                     this.question.getAnswerOptions(), 
				                     this.question.getIsMultiple());
		return temp;
	}
	
	
	/************************************************************************************
	 * Accessor | getAcceptedAnswers
	 * ----------------------------------------------------------------------------------
	 * Returns answers submitted by students
	 * ----------------------------------------------------------------------------------
	 * Parameters: none
	 * Returns   : 
	 *     temp (ArrayList<PollStudent>) - copy of answers
	 ************************************************************************************/
	public ArrayList<PollStudent> getAcceptedAnswers()
	{
		ArrayList<PollStudent> temp = new ArrayList<PollStudent>();
		
		// Creates a copy to return
		for(PollStudent studentAns : this.acceptedAnswers)
		{
			PollStudent student = new PollStudent(studentAns.getID(), studentAns.getAnswer());
			temp.add(student);
		}
		
		return temp;
	}
	
	
	/************************************************************************************
	 * Accessor | getAnsStats
	 * ----------------------------------------------------------------------------------
	 * Returns the results of the poll (number of votes per answer option)
	 * ----------------------------------------------------------------------------------
	 * Parameters: none
	 * Returns   : 
	 *     ansStats (int[])
	 ************************************************************************************/
	public int[] getAnsStats()
	{
		return this.ansStats;
	}
	
	
	/************************************************************************************
	 * Accessor | displayResults
	 * ----------------------------------------------------------------------------------
	 * Displays the question, the answer options, and the number of votes per answer
	 * options. Also indicates which answer options were correct answers if there were
	 * any.
	 * ----------------------------------------------------------------------------------
	 * Parameters: none
	 * Returns   : none -> displays question and ansStats on screen
	 ************************************************************************************/
	public void displayResults()
	{
		calcAnsStats();                   // Calculates the # of votes per answer option
		
		int length = findLongestString(); // Finds the length of the longest answer option
		
		// Creates a string for the format of the output like setw.
		// %-#s = left justified (-) width of length # String (s)
		String format = "%-" + String.valueOf(length) + "s";
		
		// OUTPUT - outputs the question from the poll
		System.out.println("Question: " + question.getQuestion() + "\n");
		
		// OUTPUT - displays the results
		for(int i = 0; i < ansStats.length; i++)
		{
			System.out.format(format, question.getAnswerOptions().get(i).getAnswer());
			System.out.format(": %-6d", ansStats[i]);
			
			// If answer option is a correct answer, outputs idicator
			if(question.getAnswerOptions().get(i).getIsCorrect())
			{
				System.out.print("|  Correct Answer");
			}
			
			System.out.println();
		}
		
		
	}
	
	
	/************************************************************************************
	 * Accessor | findLongestString
	 * ----------------------------------------------------------------------------------
	 * Finds length of the longest answer option
	 * ----------------------------------------------------------------------------------
	 * Parameters: none
	 * Returns   : 
	 *     longest (int) - length of the longest answer option
	 ************************************************************************************/
	private int findLongestString()
	{
		// Sets longest to the first answer option
		int longest = question.getAnswerOptions().get(0).getAnswer().length();
		
		// From answer option 2 until the last answer option
		for(int i = 1; i < question.getAnswerOptions().size(); i++)
		{
			// Length of current answer option
			int length = question.getAnswerOptions().get(i).getAnswer().length();
			
			// If the current answer option is longer than longest, becomes longest
			if(length > longest)
			{
				longest = length;
			}
		}
		
		
		return longest;
	}

	
}
