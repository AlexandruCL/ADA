import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class StackClient7 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enther the path of the html file");

        String fileName = scanner.nextLine();

        try {
            if (validateFILE(fileName)) {
                System.out.println("The HTML file is correct.");
            } else {
                System.out.println("The HTML file is not correct.");
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    public static boolean validateFILE(String filename) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        Stack<String> stack = new Stack<>();
        String line;

        while ((line = reader.readLine()) != null) {
            int startIndex = 0;
            while((startIndex = line.indexOf("<", startIndex)) != -1){ //Find the starting tag index to compute the tag
                int endIndex = line.indexOf(">", startIndex);

                if(endIndex == -1){
                    reader.close();
                    return false;
                }

                String tag = line.substring(startIndex + 1, endIndex);
                if(!tag.startsWith("/")){
                    stack.push(tag);
                } else {
                    if(stack.isEmpty() || !stack.peek().equals(tag.substring(1))){ //Remove the / character from the closing tag in order to check it
                        reader.close();
                        return false;
                    } else {
                        stack.pop();
                    }
                }
                startIndex = endIndex + 1;
            }
        }
        reader.close();
        return stack.isEmpty();
    }
}
