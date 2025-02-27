import java.util.Scanner;
import java.util.Stack;

public class StackClient2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack<Integer> intStack = new Stack<>();
        Stack<String>stringStack = new Stack<>();

        System.out.println("Enter the number of lines: ");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i<n; i++){
            String line = sc.nextLine();
            String[] parts = line.split(" ", 2);

            try{
                int number = Integer.parseInt(parts[0]);
                intStack.push(number);
                stringStack.push(parts[1]);
            }catch(NumberFormatException e){
                System.out.println("Invalid format for the line");
            }
        }

        if(n == 0 || intStack.isEmpty() || stringStack.isEmpty()){
            System.out.println("There was no input");
            return;
        }
        while(!intStack.isEmpty()){
            System.out.println(intStack.pop());
        }
        while(!stringStack.isEmpty()){
            System.out.println(stringStack.pop());
        }

    }
}