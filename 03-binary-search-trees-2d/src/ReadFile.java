import java.io.*;
import java.lang.Exception;
import java.util.NoSuchElementException;

public class ReadFile {
    StringBuffer buffer;
    int size = 0; // size of String[] array
    int array[];

    /**
     * reading a file that contains points
     * @param filename of the txt file
     * @throws Exception
     */
    public ReadFile(File filename) throws Exception{
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        StringBuffer sb = new StringBuffer();
        String line;
        while((line=br.readLine()) != null){
            sb.append(line);
            sb.append("\n");
            size++;
        }
        buffer = sb;
        fr.close();
    }
    StringBuffer getBuffer(){
        return buffer;
    }
    int getLength(){
        return size;
    }

    /**
     *
     * @param filename of the txt file
     * @return an array contains String lines of the txt file
     */
    String[] getArray(File filename) throws Exception {

        String s = buffer.toString();
        String array[] = new String[size];
        String line = "";
        String[] tokens = line.split(" ");
        int count; // counts the number of tokens in a line
        int j = 0;
        for (int i = 0; i < size; i++){
            while((s.charAt(j)) != '\n'){
                line += (s.charAt(j));
                j++;
            }
            j++;
            array[i] = line + ' '; // add space to the end of line
            tokens = line.split(" "); // split the line to numbers
            count = 0;
            for (String t : tokens) {
                count++;
            }
            // if count of tokens > 2 means that the line contains more than 2 numbers
            if (count > 2)
                throw new InterruptedIOException(" Wrong data in file:(");
            line = ""; // initializes the next line
        }
        // if the number of first line of txt file do not match the rest number of rows in the file
        if (Integer.parseInt(String.valueOf(array[0]).replaceAll("\\s", "")) != size-1) {
            throw new NumberFormatException(" Wrong data in file:(");
        }
        return array;
    }

    /**
     *
     * @param array contains String lines of txt file - needed a space at the end
     *  otherwise the charAt(j) finds null
     * @param index of line in the array
     * @return Point from line containing 2 numbers
     * @throws Exception
     */
    public static Point getPointFromArrayOfStrings(String[] array, int index) throws Exception{
        if (index == 0)
            throw new IllegalArgumentException("Zero index is not allowed!");
        String[] arr = new String[2];
        int j = 0;
        for (int i = 0; i < 2; i++) {
            String s = "";
            while (Character.isDigit(array[index].charAt(j))) {
                s += array[index].charAt(j);
                j++;
            }
            if (Integer.parseInt(String.valueOf(s)) < 0 || Integer.parseInt(String.valueOf(s)) > 100)
                throw new NoSuchElementException("Invalid data in file!");
            arr[i] = s;
            j++;
        }
        Point p = new Point(Integer.parseInt(String.valueOf(arr[0])), Integer.parseInt(String.valueOf(arr[1])));
        return p;
    }
}
