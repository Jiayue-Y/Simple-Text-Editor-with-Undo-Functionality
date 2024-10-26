import java.util.Scanner;

public class TextOperation {
    String text = "";
    Stack<String> flow = new Stack<>();

    TextOperation() {
        flow.push(text);
    }

    void add(String addText) {
        text += addText;
        flow.push(text);
        display();
    }

    void delete() {
        if (text != null && !text.isEmpty()) {
            // Remove the last character
            text = text.substring(0, text.length() - 1);
            flow.push(text);
            display();
        }
    }

    void undo() {
        if (flow.size() > 1) {
            flow.pop();
            text = flow.peek();
        }
        display();
    }

    void display(){
        System.out.println("Current text is: " + text);
    }

    public static void main(String[] args) {
        TextOperation t = new TextOperation();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to TextOperation!\n\nEnter 'a' to add " +
                "text;\nEnter 'd' to delete the last character of the text;" +
                "\nEnter 'u' to undo the last operation;\nEnter 'q' to quit.");
        char operation;

        do {
            System.out.print("\nEnter operation: ");
            operation = sc.nextLine().charAt(0);

            switch (operation) {
                case 'a':
                case 'A':
                    System.out.print("Enter text to be added: ");
                    t.add(sc.nextLine());
                    break;

                case 'd':
                case 'D':
                    if (t.text.isEmpty()) {
                        System.out.println("There is nothing to delete.");
                    }
                    else {
                        System.out.println("Last character deleted.");
                        t.delete();
                    }
                    break;

                case 'u':
                case 'U':
                    if(t.flow.size() <= 1){
                        System.out.println("There is nothing to undo.");
                    }
                    else {
                        System.out.println("Last operation undo.");
                        t.undo();
                    }
                    break;

                case 'q':
                case 'Q':
                    System.out.println("Final text is: " + t.text +
                            "\nProgram quit. Thanks for using TextOperation!");
                    break;

                default:
                    System.out.println("""
                            Invalid operation.
                            Enter 'a' to add text;
                            Enter 'd' to delete the last character of the text;
                            Enter 'u' to undo the last operation;
                            Enter 'q' to quit.""");
                    break;
            }
        } while (operation != 'q' && operation != 'Q');
    }
}
