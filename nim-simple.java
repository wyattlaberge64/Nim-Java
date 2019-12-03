// Nim Simple java By Wyatt Laberge
// import the scanner utility.
import java.util.Scanner;
public class NimSimple {

	/* Nim Simple By Wyatt LaBerge */

	/* Global Variables */
	static int games = 0;
	static int count = 0;
	static int turns = 0;
	static boolean again = true;
	static int next = 0;
	static int turn = 0;
	
	/* Main */
	public static void main(String[] args) {
		// Set the count and turns variables to 0.
		count = 0;
		turns = 0;
		// Set the next variable equal to the games variable with a modulus of 2.
		next = games%2;
		// Make a while loop that runs while again is equal to true.
		while(again == true) {
			// Make a if statement that runs if count is less than 21.
			if(count < 21) {
				// Make a if statement that runs if next is equal to 0.
				if(next == 0){
					// Increase the turns variable by 1.
					turns++;
					// Make an if statement that runs if count is less than 20.
					if(count < 20) {
						// Set the turn variable equal to the CPUTurn() function.
						turn = CPUTurn();
					}
					else {
						// Set the turn variable equal to 1.
						turn = 1;
					}
					// Make the total of the count variable increase by the turn variable.
					count += turn;
					// Have the system show what the count is.
					System.out.println("The count is now "+count+".");
					// Set the next variable equal to the nextSwitch(next) function.
					next = nextSwitch(next);
						
				}
				else {
					// Increase the turns variable by 1.
					turns++;
					// Set the turn variable equal to userTurn() function.
					turn = userTurn();
					// Make the total of the count variable increase by the turn variable.
					count += turn;
					// Have the system show what the count is.
					System.out.println("The count is now "+count+".");
					// Set the next variable equal to the nextSwitch(next) function.
					next = nextSwitch(next);
				}
			}
			else {
				// run the declareWinner function
				declareWinner();
				// Make an if statement that runs if the playAgain function is equal to true.
				if(playAgain() == true) {
					// Set the again variable to true.
					again = true;
					// Set the count and turns variables equal to 0.
					count = 0;
					turns = 0;
					// Increase the games variable by 1;
					games++;
					// Set the next variable equal to the games variable with a modulus of 2.
					next = games%2;
				}
				else {
					// Set the again variable to false.
					again = false;
					// Have the System say Thanks for playing.
					System.out.println("Thanks for playing");
					// Stop main function.
					break;
				}
			}
		}
	}
	
	/* Functions */
	
	/**
	 * Create the user turn function.
	 * @return turn
	 */
	public static int userTurn() {
		// Create the boolean variable goodNumber and set it equal to false.
		boolean goodNumber = false;
		// Set the turn variable equal to 0.
		turn = 0;
		// Make A while loop that runs while the goodNumber variable is equal to false.
		while(goodNumber == false) {
			// Have the system ask the user to enter a number between 1 and 3.
			System.out.print("Enter a number between 1-3: ");
			Scanner manualInput = new Scanner(System.in);
			turn = manualInput.nextInt();
			// Make an if statement that runs if the turn variable is equal to 1, 2, or 3.
			if(turn == 1 || turn == 2 || turn == 3) {
				// Set the goodNumber variable to true.
				goodNumber = true;
			}
			else {
				// Have the system tell the user that the number they choose is out of range and hey have to pick another number.
				System.out.println("Number out of range choose another number.");
			}
		}
		return turn;
	}
	
	/**
	 * Create the function CPUTurn.
	 * @return turn
	 */
	public static int CPUTurn(){
		// Create the int variable turn and set it equal to a casted int random number.
		int turn = (int) Math.floor(Math.random()*3)+1;
		// Make a while loop that runs while turn is not equal to 1 and the count and turn variables are added to be greater than 20.
		while(turn!=1 && count+turn>20) {
			// Set the turn variable equal to a casted int random number.
			turn = (int) Math.floor(Math.random()*3)+1;
		}
		// Have the system show what the CPU counts.
		System.out.println("CPU counts "+turn+".");
		return turn;
	}
	
	/**
	 * Create the boolean function playAgain.
	 * @return true or false
	 */
	public static boolean playAgain() {
		// Have the system ask the user if they want to play again.
		System.out.print("Play again? y = yes: ");
		Scanner manualInput = new Scanner(System.in);
		String playAgain = manualInput.nextLine();
		// Create an if statement that runs if the playAgain variable is equal to y.
		if(playAgain.equals("y")) {
			// Have the function return true.
			return true;
		}
		else {
			return false;
		}
	}
	
	/** 
	 * Create an nextSwitch function.
	 * @param next
	 * @return 1 or 0
	 */
	public static int nextSwitch(int next) {
		// Make an if statement that runs if the next variable is equal to 0.
		if(next == 0) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	/**
	 * Create an declareWinner function.
	 */
	public static void declareWinner() {
		// Make an if statement that runs if the next variable.
		if(next == 0) {
			// Have the system tell the user that they lost.
			System.out.println("You lose!");
		}
		else {
			// Have the system tell the user that they won.
			System.out.println("You win!");
		}
	}
}
