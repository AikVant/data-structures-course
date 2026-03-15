import java.io.*;
import java.util.NoSuchElementException;

public class Thiseas {
    public static void main(String[] args) throws Exception{
        File filename = new File(args[0]);
        System.out.println(filename);
        Maze thiseas;

        try {
            thiseas = new Maze(filename);
            System.out.println("\n\nInitial state of thiseas maze:");
            System.out.println(thiseas);
            StringStackImpl<String> stack;
            MazeSolver solver = new MazeSolver(thiseas);
            stack = solver.getStack();

            if (solver.traverse(thiseas.getEntranceX(), thiseas.getEntranceY()))
                System.out.println("Thiseas maze was successfully traversed at the exit: " + stack.peek());
            else {
                System.out.println("There is no possible path");
            }
            System.out.println("\nSolved state of thiseas maze:");
            System.out.println(thiseas);
        }
        catch (NoSuchElementException e){
            System.out.println(" Error reading file...");
        }
    }
}
