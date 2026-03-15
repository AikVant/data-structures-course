import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu extends FunctionsOfMenu {
    String[] array;
    Menu() throws Exception {
        this.array = readFile(theFileName, array);
        TwoDTree tree = createTwoDTree(array);
        Scanner in = new Scanner(System.in);
        boolean end = false;
        while(!end){
            printMenu();
            int choice = getInt(in);
            int a, b, c, d;
            switch (choice){
                case 1:
                    computeTheSizeOfTheTree(tree);
                    break;
                case 2:
                    System.out.print(" Enter the first integer: ");
                    a = getInt(in);
                    if (checkBounds(a))
                        System.out.print(" Enter the second integer: ");
                    else continue;
                    b = getInt(in);
                    if (checkBounds(b)){
                        Point p = new Point(a, b);
                        insertNewPoint(tree, p);
                    }else continue;
                    break;
                case 3:
                    System.out.print(" Enter the first integer: ");
                    a = getInt(in);
                    if (checkBounds(a))
                        System.out.print(" Enter the second integer: ");
                    else continue;
                    b = getInt(in);
                    if (checkBounds(b)){
                        Point p = new Point(a, b);
                        searchIfTheGivenPointExistsInTheTree(tree, p);
                    }else continue;
                    break;
                case 4:
                    System.out.print(" Horizontal line: Enter the first integer(xmin): ");
                    a = getInt(in);
                    if (checkBounds(a))
                        System.out.print(" Horizontal line: Enter the second integer(xmax): ");
                    else continue;
                    b = getInt(in);
                    if (checkBounds(b))
                        System.out.print(" Vertical line: Enter the third integer(ymin): ");
                    else continue;
                    c = getInt(in);
                    if (checkBounds(c))
                        System.out.print(" Vertical line: Enter the fourth integer(ymax): ");
                    else continue;
                    d = getInt(in);
                    if (checkBounds(d)){
                        Rectangle rect = new Rectangle(a, b, c, d);
                        PointsOfTheTreeThatAreInTheRectangle(tree, rect);
                    }else continue;
                    break;
                case 5:
                    System.out.print(" Enter the first integer: ");
                    a = getInt(in);
                    if (checkBounds(a))
                        System.out.print(" Enter the second integer: ");
                    else continue;
                    b = getInt(in);
                    if (checkBounds(b)){
                        Point p = new Point(a, b);
                        PointOfTheTreeThatIsNearestToQueryPoint(tree, p);
                        System.out.println(" ----------------------------------------------------------------------------------------");
                    }else continue;
                    break;
                case 6:
                    System.out.println(" End of the program.");
                    in.close();
                    end = true;
                    break;
                default:
                    System.out.println(" Invalid choice!!! A valid choice for the menu is a number from 1 to 6.");
                    System.out.println(" ----------------------------------------------------------------------------------------");
            }
        }
    }

    /**
     *
     * @param in Scanner(system.in)
     * @return the user's integer input
     */
    public static int getInt(Scanner in){
        int choice;
        while(true) {
            if (in.hasNextInt()){
                choice = in.nextInt();
                in.nextLine();
                return choice;
            }else{
                in.nextLine();
                return -1;
            }
        }
    }

    /**
     *
     * @param choice the user's integer input
     * @return if user's input less than zero or greater than 100 return false, otherwise return true
     */
    public static boolean checkBounds(int choice){
        if (choice < 0 || choice > 100) {
            System.out.println(" Invalid choice!!! A valid choice is a number from 0 to 100.");
            System.out.println(" ----------------------------------------------------------------------------------------");
            return false;
        }
        return true;
    }

    /**
     * prints the choices of the menu
     */
    public static void printMenu(){
        System.out.println(" Press 1 for compute the size of the tree.");
        System.out.println(" ----------------------------------------------------------------------------------------");
        System.out.println(" Press 2 for insert a new point of the tree.\n Give 2 integers from 0 to 100 to make an insertion point.");
        System.out.println(" ----------------------------------------------------------------------------------------");
        System.out.println(" Press 3 for search if a given point exists in the tree.\n Give 2 integers from 0 to 100 to make a searching point.");
        System.out.println(" ----------------------------------------------------------------------------------------");
        System.out.println(" Press 4 for provide a query rectangle.\n" +
                " Give 4 integers from 0 to 100 to make a rectangle.\n" +
                " The first 2 integers create the horizontal side of the rectangle(xmin,xmax).\n" +
                " The second 2 integers create the vertical side of the rectangle(ymin,ymax).\n" +
                " Find which points of the tree are inside this rectangle.");
        System.out.println(" ----------------------------------------------------------------------------------------");
        System.out.println(" Press 5 for provide a query point.\n Give 2 integers making a point.\n Find the nearest neighbor of the query point in the tree.");
        System.out.println(" ----------------------------------------------------------------------------------------");
        System.out.println(" Press 6 for exit the program.");
        System.out.println(" ----------------------------------------------------------------------------------------");
        System.out.print(" Make your choice: ");

    }
}

