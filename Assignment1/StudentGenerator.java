/****************************************************************************************
 * Name       : Milan Bui
 * Date       : 21 September 2020
 * Class      : CS 3560
 * Assignment : Assignment 1
 ****************************************************************************************/
package CS3560_Assignment1;
import java.util.ArrayList;
import java.util.Random;

/****************************************************************************************
 * StudentGenerator Class
 *    Contains method to generate a random ID and answer to create a student
 ****************************************************************************************/
public class StudentGenerator {
	
	/************************************************************************************
	 * void generateStudents
	 * ----------------------------------------------------------------------------------
	 * Generates [numOfIDs] random student IDs (allowing repeats), with the ID #s ranging
	 * from [minID] to [maxID], and generates random answers for each based on 
	 * [answerOptions].
	 * ----------------------------------------------------------------------------------
	 * Parameters:
	 *     maxID (int) - highest ID # to generate
	 *     minID (int) - lowest ID # to generate
	 *     answerOptions (ArrayList<Answer>) - answer options of poll question
	 *     isMult (boolean) - if question allows multiple choice or not.
	 * Return:
	 *     none
	 ************************************************************************************/	
	public static PollStudent generateStudent(int maxID, int minID, 
			                                  ArrayList<Answer> answerOptions, 
			                                  boolean isMult)
	{
		Random rand = new Random();   // to generate random id and index
		int randIndex;                // random index to access answer option
		
		// PROCESSING - generates random student ID's and answers
			// Variables for generating random students
			PollStudent randStudent = new PollStudent();
			int randId      = rand.nextInt(maxID-minID+1)+minID;
			randStudent.setID(String.valueOf(randId));
			
			// Variables for generating random answers
		    String studentAns  = "";
			int max         = answerOptions.size();
			int randNum     = rand.nextInt(max-1)+1;
			ArrayList<Integer> prevIndex   = new ArrayList<Integer>();

			
			// If question is multiple choice
			if(isMult)
			{	
				// PROC - generate randNum (1 to max-1) of answer selections for student
				for(int i = 0; i < randNum; i++)
				{
					randIndex = rand.nextInt(max);    // Random index 0 to max-1
					
					// If randIndex has not yet been used, add answer selection
					if(!prevIndex.contains(randIndex))
					{
						String randAns = answerOptions.get(randIndex).getAnswer();
						studentAns = studentAns + (randAns + "\n");
						prevIndex.add(randIndex);
					}
				}

				
			}
			// Else -> single choice, randomly select one option
			else
			{
				randIndex = rand.nextInt(max);
				studentAns = answerOptions.get(randIndex).getAnswer();
			}
			
			randStudent.setAnswer(studentAns);   // PROC - set random student's answer
			
			return randStudent;

	}
	

}
