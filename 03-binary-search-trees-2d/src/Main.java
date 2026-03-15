import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        try{
            FunctionsOfMenu.readFile(args[0], new String[0]);
            System.out.println();
            new Menu();
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
