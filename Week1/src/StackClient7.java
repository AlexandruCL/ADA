import javax.print.attribute.HashDocAttributeSet;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class StackClient7 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enther the name of the html file");

        String fileName = scanner.nextLine();

        try {
            if (validateHTML(fileName)) {
                System.out.println("The HTML file is correct.");
            } else {
                System.out.println("The HTML file is not correct.");
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    public static boolean validateHTML(String filename) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        Stack<String> stack = new Stack<>();
        String line;

        while ((line = reader.readLine()) != null) {
            int pos = 0;
            while((pos = line.indexOf("<",pos)) != -1){
                int end = line.indexOf(">",pos);

                if(end == -1){
                    reader.close();
                    return false;
                }

                String tag = line.substring(pos + 1,end);
                if(!tag.startsWith("/")){
                    stack.push(tag);
                } else {
                    if(stack.isEmpty() || !stack.peek().equals(tag.substring(1))){
                        reader.close();
                        return false;
                    } else {
                        stack.pop();
                    }
                }
                pos = end + 1;
            }
        }
        reader.close();
        return stack.isEmpty();
    }
}
