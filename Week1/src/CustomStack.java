import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class CustomStack<T>{

    private List<T> list = new ArrayList<>();

    public void push(T x){
        list.add(x);
    }

    public T pop(){
        T toReturn = list.get(list.size()-1);
        list.remove(list.size()-1);
        return toReturn;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public static class StackClient2 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Stack<Integer> intStack = new Stack<>();
            Stack<String> stringStack = new Stack<>();

            System.out.println("Enter the nr of lines: ");
            int nrOfLines = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < nrOfLines; i++) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ",2);

                try {
                    intStack.push(Integer.parseInt(parts[0]));
                    stringStack.push(parts[1]);
                }catch (NumberFormatException e){
                    System.out.println("Invalid format for the line");
                }
            }

            if(nrOfLines == 0 || stringStack.isEmpty() || intStack.isEmpty()){
                System.out.println("No input found");
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
}