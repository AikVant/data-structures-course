import java.io.*;

public class ReadFile {
    StringBuffer buffer;
    int size = 0;
    int array[];
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

    int[] getArray(File filename){

        String s = buffer.toString();
        int array[] = new int[size];
        String line = "";
        int j = 0;
        for (int i = 0; i < size; i++){
            while((s.charAt(j)) != '\n'){
                line += (s.charAt(j));
                j++;
            }
            j++;

            if (Integer.parseInt(line) > 1000000)
                throw new RuntimeException();
            array[i] = Integer.parseInt(line);
            line = "";
        }
//        for (int i = 0; i < size; i++){
//            System.out.println(array[i]);
//        }
        return array;
    }
}
