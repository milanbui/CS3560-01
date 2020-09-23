/****************************************************************************************
 * Name       : Milan Bui
 * Date       : 21 September 2020
 * Class      : CS 3560
 * Assignment : Assignment 1
 ****************************************************************************************/
package CS3560_Assignment1;

/****************************************************************************************
 * iVOTE SIMULATOR
 * ______________________________________________________________________________________
 * 
 * This program creates a question and answer options to submit to a voting service. 
 * Answer options can be marked as a correct answer and the question can be marked as
 * a multiple or single choice question. Once the voting service has received the question 
 * and answer options, it accepts submissions from students. The students and their 
 * answers are randomly generated. If a student submits more than once, their answer is 
 * changed to their latest submission. Once all students have submitted, the results are 
 * displayed also indicating which answers were correct if any were marked correct. 
 * ______________________________________________________________________________________
 * 
 * INPUT:
 *    pollQuestion : The question, answer options, and question type for the poll.
 *    iVote        : pollQuestion and student answers
 *    
 * OUTPUT:
 *    iVote : The results along with the question and answer option for it.
 ****************************************************************************************/
public class SimulationDriver {
	public static void main(String[] args){
		
		// INSTANCE VARIABLES
		Question pollQuestion;   // IN   - Poll question used for voting service
		VotingService iVote;     // PROC/OUT - voting service. Takes answers from students
		                         //            and calculates/outputs the results
		PollStudent studentAns;  // PROC - random student (ID and answer)

// ---------------------------------------------------------------------------------------
		
		pollQuestion = new Question(); // Creates new question object
		
		// INPUT - Sets question and isMultiple
		pollQuestion.setQuestion("What languages am I learning?");
		pollQuestion.setIsMultiple(true);
		
		// INPUT - adds answer options to pollQuestion
		pollQuestion.addAnswerOptions("Korean"  , true );
		pollQuestion.addAnswerOptions("German"  , false);
		pollQuestion.addAnswerOptions("Chinese" , false);
		pollQuestion.addAnswerOptions("Japanese", true );
		pollQuestion.addAnswerOptions("Spanish" , true );
		
		// PROC - creates VotingService object for given question
		iVote = new VotingService(pollQuestion);
	
		// PROCESSING - generates random student ID's and answers
		// Generate 40 random IDs between 1500 & 1530
		for(int num = 0; num < 40; num++)
		{
			studentAns = StudentGenerator.generateStudent(1530, 1500, 
					                         iVote.getQuestion().getAnswerOptions(), 
					                         iVote.getQuestion().getIsMultiple());
			
			//System.out.println(studentAns.getID() + ":\n" + studentAns.getAnswer());
			// Submits student ID and answer
			iVote.addAnswer(studentAns);
		}
		
		// OUTPUT - displays results of poll
		iVote.displayResults();

		System.out.println("\n\n");

// ---------------------------------------------------------------------------------------
		
		pollQuestion = new Question(); // Creates new question object
		
		// INPUT - Sets question and isMultiple
		pollQuestion.setQuestion("Who was the 2018 Olympic gold medalist for men's figure skating?");
		pollQuestion.setIsMultiple(false);
		
		// INPUT - adds answer options to pollQuestion
		pollQuestion.addAnswerOptions("Javier Fernandez", false );
		pollQuestion.addAnswerOptions("Shoma Uno"   , false);
		pollQuestion.addAnswerOptions("Nathan Chen" , false);
		pollQuestion.addAnswerOptions("Yuzuru Hanyu", true );
		pollQuestion.addAnswerOptions("Boyang Jin"  , false );
		
		// PROC - creates VotingService object for given question
		iVote = new VotingService(pollQuestion);
	
	
		// PROCESSING - generates random student ID's and answers
		// Generate 40 random IDs between 1500 & 1540
		for(int num = 0; num < 40; num++)
		{
			studentAns = StudentGenerator.generateStudent(1530, 1500, 
					                               iVote.getQuestion().getAnswerOptions(), 
					                               iVote.getQuestion().getIsMultiple());
			// Submits student ID and answer
			iVote.addAnswer(studentAns);
		}

			
		// OUTPUT - displays results of poll
		iVote.displayResults();
				
		
		
	} // end main
	
} // end SimulationDriver
