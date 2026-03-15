import java.io.*;
import java.util.*;
import java.nio.charset.StandardCharsets;

public class Maze {
    private static final char OPEN = '0';
    private static final char TRIED = '2';

    private int entranceX = -1;
    private int entranceY = -1;
    private final int endRow;
    private final int endColumn;
    private final char[][] grid;

    /**
     * constructor to reading @param filename and creating char array of labyrinth
     */
    public Maze(File filename) throws Exception{
        ArrayList<String> array = new ArrayList<>();
        BufferedReader reader;
        int sizeOfRows;
        int sizeOfCols;
        int posOfEntryX;
        int posOfEntryY;

        // reading file
        reader = new BufferedReader(new FileReader(filename, StandardCharsets.UTF_8));
        String line;
        int d = 0;
        while ((line = reader.readLine()) != null){
            if (d >= 2) {
                array.add(line.replaceAll("\\s", ""));
            }
            else{
                array.add(line);
                d++;
            }
        }
        reader.close();

        // taking number of rows and columns
        StringBuilder result1 = new StringBuilder();
        StringBuilder result2 = new StringBuilder();
        int z = 0;
        int size = array.get(0).length();
        while (Character.isDigit(array.get(0).charAt(z))){
            result1.append(array.get(0).charAt(z));
            z++;
        }
        z++;
        while ( z < size && Character.isDigit(array.get(0).charAt(z))){
            result2.append(array.get(0).charAt(z));
            z++;
        }

        // taking coordinates of entrance
        StringBuilder result3 = new StringBuilder();
        StringBuilder result4 = new StringBuilder();
        z = 0;
        size = array.get(1).length();
        while (Character.isDigit(array.get(1).charAt(z))){
            result3.append(array.get(1).charAt(z));
            z++;
        }
        z++;
        while ( z < size && Character.isDigit(array.get(1).charAt(z))){
            result4.append(array.get(1).charAt(z));
            z++;
        }

        sizeOfRows = Integer.parseInt(result1.toString());
        sizeOfCols = Integer.parseInt(result2.toString());
        posOfEntryX = Integer.parseInt(result3.toString());
        posOfEntryY = Integer.parseInt(result4.toString());

        // Checks whether the input coordinates are equal to English or Greek epsilon
        char ch = array.get(posOfEntryX+2).charAt(posOfEntryY);
        boolean flag2 = false; // flag to check validity of entrance E
        if ((ch != 'E') && (ch != 'Ε')){
            System.out.println(" Wrong position of entrance(:");
            throw new NoSuchElementException();
        }
        else{
            int i = 0;
            for (String item : array){
                if (i >= 2) {
                    for (int j = 0; j < item.length(); j++){
                        if (item.charAt(j) < '0' || item.charAt(j) > '1') {
                            if (i-2 != posOfEntryX || j != posOfEntryY) {
                                flag2 = true;
                            }
                        }
                    }
                }
                i++;
            }
        }
        if (flag2) {
            System.out.println(" Wrong Data:(");
            throw new NoSuchElementException();
        }

        int countRows = -2;
        int countCols;

        // traverse array and keep max number of columns
        int maxCountCols = 0;
        for (String item : array){
            countRows++;
            if (item.length() > maxCountCols){
                countCols = item.length();
                maxCountCols = countCols;
            }
        }
        if (countRows != sizeOfRows){
            System.out.println(countRows);
            System.out.println(" Wrong number of rows:(");
            throw new NoSuchElementException();
        }
        boolean flag = false; // flag to check the columns of maze
        int c = 0;
        for (String item : array){
            if (c >= 2) {
                if (item.length() != maxCountCols) {
                    flag = true;
                }
            }
            c++;
        }
        if (flag){
            System.out.println(" Wrong number of columns:(");
            throw new NoSuchElementException();
        }

        // create grid (array of chars)
        this.grid = new char [sizeOfRows][sizeOfCols];
        for (int i = 0; i < sizeOfRows; i++) {
            for (int j = 0; j < sizeOfCols; j++) {
                grid[i][j] = (array.get(i + 2).charAt(j));
                if ((Objects.equals(grid[i][j], 'E') || (Objects.equals(grid[i][j], 'Ε') ))){
                    this.entranceX = i;
                    this.entranceY = j;
                }
            }
        }
        endRow = getRows()-1;
        endColumn = getColumns()-1;
    }

    /**
     * Marks the path with the character '2' ατ position (@param row, @param col)
     */
    public void tryPosition(int row, int col){
        grid[row][col] = TRIED;
    }

    /**
     * Check the borders of grid
     */
    public boolean solved(int row, int col){
        return ((row == endRow) || (col == endColumn)|| ((row == 0) || ( col == 0)));
    }

    public int getRows(){
        return grid.length;
    }

    public int getColumns(){
        return grid[0].length;
    }

    public int getEntranceX(){
        return this.entranceX;
    }

    public int getEntranceY(){
        return this.entranceY;
    }

    /**
     * Checks if position(@param row, @param column) to be pushed is inside of the bounds of the grid
     * @return boolean
     */
    public boolean validPosition(int row, int column){
        boolean result = false;
        if (row >= 0 && row < grid.length && column >= 0 && column < grid[row].length){
            if (grid[row][column] == OPEN){
                result = true;
            }
        }
        return result;
    }

    public String toString(){
        StringBuilder result = new StringBuilder("\n");
        for (char[] chars : grid) {
            for (char ch : chars) {
                result.append(ch).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
