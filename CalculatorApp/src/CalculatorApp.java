import java.util.Scanner;

public class CalculatorApp {

	public static void main(String[] args) {
		boolean loopCalculator = true;
		
		UI.renderMenu();
		// loop for menu
		while(loopCalculator == true) {
			int a = UI.scanInt();
			char op = UI.scanOp();
			int b = UI.scanInt();
			int rInteger = 0;
			double rDouble = 0;
			
			// if / else
//			if(op == '+') {
//				rInteger = Arithmetics.add(a, b);
//				UI.renderResultInteger(a, b, op, rInteger);
//			}
//			if(op == '-') {
//				rInteger = Arithmetics.sub(a, b);
//				UI.renderResultInteger(a, b, op, rInteger);
//			}
//			if(op == '*') {
//				rInteger = Arithmetics.mlp(a, b);
//				UI.renderResultInteger(a, b, op, rInteger);
//			}
//			if(op == '/') {
//				rDouble = Arithmetics.div(a, b);
//				UI.renderResultDouble(a, b, op, rDouble);
//			}
			
			// switch / case
			switch(op) {
			case '+': 
				rInteger = Arithmetics.add(a, b);
				UI.renderResultInteger(a, b, op, rInteger);
				break;
			case '-':
				rInteger = Arithmetics.sub(a, b);
				UI.renderResultInteger(a, b, op, rInteger);
				break;
			case '*':
				rInteger = Arithmetics.mlp(a, b);
				UI.renderResultInteger(a, b, op, rInteger);
				break;
			case '/':
				rDouble = Arithmetics.div(a, b);
				UI.renderResultDouble(a, b, op, rDouble);
				break;
			default:
				break;
			}
			loopCalculator = UI.loopCalculator();
		}
		
	}

}

// SECONDARY CLASSES
class Arithmetics {
	static int add(int a, int b) {
		return a+b;
	}
	static int sub(int a, int b) {
		return a-b;
	}
	static int mlp(int a, int b) {
		return a*b;
	}
	static double div(double a, double b) {
		return a/b;
	}
	
}

// UI - USER INTERFACE
class UI {
	static void renderMenu() {
		System.out.println("------------------------------------");
		System.out.println("|            CALCULATOR            |");
		System.out.println("------------------------------------");
		System.out.println("|           Instructions           |");
		System.out.println("|       1) insert first number     |");
		System.out.println("|       2) choose operation:       |");
		System.out.println("|            +, -, *, /            |");
		System.out.println("|       3) insert second number    |");
		System.out.println("------------------------------------");

	}
	static int scanInt() {
		Scanner in = new Scanner(System.in);
		System.out.print("enter value: ");
		int value = in.nextInt();
		return value;
	}
	static char scanOp() {
		Scanner in = new Scanner(System.in);
		System.out.print("choose operation(+, -, *, /):  ");
		char op = in.next().charAt(0);
		return op;
	}
	static void renderResultInteger(int a, int b, char op, int r) {
		System.out.printf("%d %c %d = %d\n", a, op, b, r);
	}
	static void renderResultDouble(int a, int b, char op, double r) {
		System.out.printf("%d %c %d = %.2f\n", a, op, b, r);
	}
	static boolean loopCalculator() {
		Scanner in = new Scanner(System.in);
		System.out.println("You will need another operation? ");
		System.out.print("Type \"yes\" or \"no\": ");
		String userAction = in.next();
		if( userAction.equals("yes") || userAction.equals("y") || userAction.equals("YES") ) {
			return true;
		} else {
			System.out.println("------------------------------------");
			System.out.println("|             BYE-BYE!             |");
			System.out.println("------------------------------------");
			return false;
		}
	}
}