public class CompareAlgorithms {
    static void compareAlgorithms(int numOfFolders){
        double sum1 = 0.0;
        double sum2 = 0.0;
        for (int i = 1; i <= 10; i++){
            String filename = String.format("sample_%d_%d.txt", numOfFolders, i);

            System.out.println("---------------------------------------------------------");
            System.out.println(filename + ":");
            String[] countDisks1 = Greedy.Algorithm1(filename);
            System.out.println("Results of Algorithm1:" + countDisks1[0] + " disks");
            String[] countDisks2 = Greedy_decreasing.Algorithm2(filename);
            System.out.println("Results of Algorithm2:" + countDisks2[0] + " disks");
            System.out.println("---------------------------------------------------------");

            sum1 += Integer.parseInt(countDisks1[0]);
            sum2 += Integer.parseInt(countDisks2[0]);

        } // sample_%d_" + i + ".txt
        double average1 = sum1/10;
        double average2 = sum2/10;
        System.out.printf("For %d folders samples, Algorithm1 used average " + average1 + " disks%n", numOfFolders);
        System.out.printf("For %d folders samples, Algorithm2 used average " + average2 + " disks%n", numOfFolders);
    }
    public static void main(String[] args) {
        compareAlgorithms(100);
        compareAlgorithms(500);
        compareAlgorithms(1000);

    } // main
} // CompareAlgorithms
