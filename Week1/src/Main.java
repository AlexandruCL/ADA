public class Main {
    public static void main(String[] args) {
        CustomStack<Integer> stack = new CustomStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        if(!stack.isEmpty())
            System.out.println(stack.pop());
        if(!stack.isEmpty())
            System.out.println(stack.pop());
        if(!stack.isEmpty())
            System.out.println(stack.pop());
    }
}



// StackClient2
// StackClient7