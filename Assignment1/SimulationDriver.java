/****************************************************************************************
 * Name       : Milan Bui
 * Date       : 21 September 2020
 * Class      : CS 3560
 * Assignment : Assignment 1
 * Description: Create a voting service. Poll-maker can create a question that is either
 *              single or multiple choice and provide the candidate answers. The service
 *              can accept answers from students that have a unique ID. If a student
 *              submits more than once, the answer is changed to their most recent 
 *              submission. The service can then display the results. The driver will
 *              configure the question, question type, candidate answers, random students,
 *              and random answers to be accepted. It will then submit the answers to
 *              the voting service and display the results using the voting service.
 ****************************************************************************************/
package CS3560_Assignment1;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SimulationDriver {
	public static void main(String[] args){
		
		// INSTANCE VARIABLES
		Scanner input = new Scanner(System.in); // IN   - input stream (user)
		Question pollQuestion = new Question(); // IN   - Poll question used for 
		                                        //        voting service
		Random rand = new Random();             // PROC - random # generator to 
		                                        //        generate students & answers
		ArrayList<Integer> prevIndex;           // PROC - list of indices of answer option 
		                                        //        previously chosen by student
		String ans;              // IN   - answer option for question
		char isCorrect;          // IN   - whether the answer option is a correct answer or 
                                 //        not (y/n) input by user
		char isMultiple;         // IN   - if question is multiple or single choice (M/S)
		String studentAns;       // PROC - randomly generate student answer
		String randAns;          // PROC - answer selected using random index
		int randId;              // PROC - random student id (1500 - 1540)
		int max;                 // PROC - max # of answer/submission (# of ans options)
		int randNum;             // PROC - random # = # answer options student selects
		int randIndex;           // PROC - random (index of answer option student selects)
		PollStudent randStudent; // PROC - randomized students (id & answer)
		boolean isCorrectAns;    // PROC - whether the answer option is correct answer or 
		                         //        not (true/false). based on isCorrect (char)
		boolean isValid;         // PROC - whether the input (isCorrect) is valid input
		VotingService iVote;     // PROC/OUT - voting service. Takes answers from students
		                         //            and calculates/outputs the results

	
// ---------------------------------------------------------------------------------------
		
		// INPUT - Prompting user/poll-maker to enter question and answer options
		System.out.print("Enter question to be asked: ");
		pollQuestion.setQuestion(input.nextLine());
		
		do
		{
			isValid = true;
			
			// IN - prompt poll-maker to mark question type as multiple or single choice
			System.out.print("Is it multiple or single choice (M or S)? ");
			isMultiple = input.next().charAt(0);
			
			if(isMultiple=='M'|| isMultiple=='m')
			{
				pollQuestion.setIsMultiple(true);
			}
			else if(isMultiple=='S'|| isMultiple=='s')
			{
				pollQuestion.setIsMultiple(false);
			}
			else
			{
				System.out.println("Invalid Input! Enter M or S");
				isValid = false;
			}
			
			input.nextLine();  // Consume what is left in buffer to clear buffer
		}while(!isValid);
		
		
		// Prompt for answer option input while user has not yet entered "exit"
		do
		{
			// IN - prompt poll-maker for answer option
			System.out.print("Enter answer option (Enter 'exit' to quit): ");
			ans = input.nextLine();
			
			// If user has not entered "Exit"
			if (!ans.equals("exit"))
			{	
				// Ask if answer option is a correct answer while user input is invalid
				do
				{
					isValid = true;
					isCorrectAns = false;
					
					// IN - prompt poll-maker to mark answer option as correct or not
					System.out.print("Is this a correct answer (Y/N)? ");
					isCorrect = input.next().charAt(0);
					
					if(isCorrect=='Y'|| isCorrect=='y')
					{
						isCorrectAns = true;
					}
					else if(isCorrect=='N'|| isCorrect=='n')
					{
						isCorrectAns = false;
					}
					else
					{
						System.out.println("Invalid Input! Enter Y or N");
						isValid = false;
					}
					
					input.nextLine();  // Consume what is left in buffer to clear buffer
				}while(!isValid);
				
				// PROC - add answer option to pollQuestion
				pollQuestion.addAnswerOptions(ans, isCorrectAns); 
			} // end of "exit" if statement 
			
		}while(!ans.equals("exit"));
	
		
		// PROC - creates VotingService object for given question
		iVote = new VotingService(pollQuestion);
		
// ---------------------------------------------------------------------------------------
		
		// PROCESSING - generates random student ID's and answers
		// Generate random IDs between 1500 & 1540
		for(int num = 0; num < 10; num++)
		{
			// Variables for generating random students
			randStudent = new PollStudent();
			randId      = rand.nextInt(1505-1500+1)+1500;
			randStudent.setID(String.valueOf(randId));
			
			// Variables for generating random answers
		    studentAns  = "";
			max         = pollQuestion.getAnswerOptions().size();
			randNum     = rand.nextInt(max-1)+1;
			prevIndex   = new ArrayList<Integer>();

			
			// If question is multiple choice
			if(pollQuestion.getIsMultiple())
			{	
				// PROC - generate randNum (1 to max-1) of answer selections for student
				for(int i = 0; i < randNum; i++)
				{
					randIndex = rand.nextInt(max);    // Random index 0 to max-1
					
					// If randIndex has not yet been used, add answer selection
					if(!prevIndex.contains(randIndex))
					{
						randAns = pollQuestion.getAnswerOptions().get(randIndex).getAnswer();
						studentAns = studentAns + (randAns + "\n");
						prevIndex.add(randIndex);
					}
				}

				
			}
			// Else -> single choice, randomly select one option
			else
			{
				randIndex = rand.nextInt(max);
				studentAns = pollQuestion.getAnswerOptions().get(randIndex).getAnswer();
			}
			
			randStudent.setAnswer(studentAns);   // PROC - set random student's answer
			iVote.addAnswer(randStudent);        // submit answers to iVote
			
		} // end rand id# for loop 

	
// ---------------------------------------------------------------------------------------
		
		// OUTPUT - clears screen and displays results of poll
		for(int i = 0; i < 300; i++)
		{
			System.out.println();
		}
		
		
		iVote.displayResults();
		input.close();	         // Closes input stream
		
	} // end main

	
} // end SimulationDriver
