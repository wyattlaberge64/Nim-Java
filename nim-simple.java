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
		count = 0;
		turns = 0;
		next = games%2;
		while(again == true) {
			if(count < 21) {
				if(next == 0){
					turns++;
					if(count < 20) {
						turn = CPUTurn();
					}
					else {
						turn = 1;
					}
					count += turn;
					System.out.println("The count is now "+count+".");
					next = nextSwitch(next);
						
				}
				else {
					turns++;
					turn = userTurn();
					count += turn;
					System.out.println("The count is now "+count+".");
					next = nextSwitch(next);
				}
			}
			else {
				declareWinner();
				if(playAgain() == true) {
					again = true;
					count = 0;
					turns = 0;
					games++;
					next = games%2;
				}
				else {
					again = false;
					System.out.println("Thanks for playing");
					break;
				}
			}
		}
	}
	
	/* Functions */
	
	public static int userTurn() {
		boolean goodNumber = false;
		turn = 0;
		while(goodNumber == false) {
			System.out.print("Enter a number between 1-3: ");
			Scanner manualInput = new Scanner(System.in);
			turn = manualInput.nextInt();
			if(turn == 1 || turn == 2 || turn == 3) {
				goodNumber = true;
			}
			else {
				System.out.println("Number out of range choose anouther number.");
			}
		}
		return turn;
	}
	
	public static int CPUTurn(){
		int turn = (int) Math.floor(Math.random()*3)+1;
		while(turn==1 || count+turn>20) {
			turn = (int) Math.floor(Math.random()*3)+1;
		}
		System.out.println("CPU counts "+turn+".");
		return turn;
	}
	
	public static boolean playAgain() {
		System.out.print("Play again? y = yes: ");
		Scanner manualInput = new Scanner(System.in);
		String playAgain = manualInput.nextLine();
		if(playAgain.equals("y")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static int nextSwitch(int next) {
		if(next == 0) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public static void declareWinner() {
		if(next == 0) {
			System.out.println("You lose!");
		}
		else {
			System.out.println("You win!");
		}
	}
}
