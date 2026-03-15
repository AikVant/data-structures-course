import java.io.File;

public class Greedy_decreasing {
	public static String[] Algorithm2(String nameOfFile){
		int[] array = new int[0]; // initialize array containing the contents of the file

		// Read file
		File filename = new File(nameOfFile);
		try {
			ReadFile rf = new ReadFile(filename);
			array = rf.getArray(filename);
		} catch (Exception e) {
			System.out.println(" Wrong data in file:(");
		} // end Read file

		Sort.mergesort(array);//use mergesort to sorting the folder's array

		DiskComparator comparator = new DiskComparator();
		MaxPQ<Disk> pq = new MaxPQ<>(comparator);

		double sum = 0.0;
		Disk disk = new Disk();
		List<Integer> folders = disk.getFolders();
		int diskId = disk.getDiskId();
		int countDisks = 1;
		pq.insert(disk);

		int i = 0;
		Disk maxFreeSpace;
		while (i<array.length) {
			maxFreeSpace = pq.getMax();
			if(maxFreeSpace.getFreeSpace()<array[i]) {
				pq.insert(maxFreeSpace);
				disk = new Disk();
				folders = disk.getFolders();
				diskId = disk.getDiskId();
				countDisks++;
				disk.addInFolders(disk, array[i]);
				sum += array[i];
				pq.insert(disk);
			}
			else {
				maxFreeSpace.addInFolders(maxFreeSpace, array[i]);
				sum += array[i];
				pq.insert(maxFreeSpace);
			}
			i++;
		}

		String s = "";
		for(int k = 0; k < countDisks; k++) {
			s += pq.getMax() + "\n";
		}

		String[] results = new String[4];

		results[0] = Integer.toString(countDisks); //Integer.toString(i)
		results[1] = String.valueOf(sum/1000000);
		results[2] = s;
		results[3] = Integer.toString(array.length);

		return results;

	}

	 public static void main(String[] args) {
		 String[] res = Algorithm2(args[0]);
		 System.out.println("Sum of all folders = " + res[1]+ " TB");
		 System.out.println("Total number of disks used = " + res[0]);
		 if (Integer.parseInt(res[3]) <= 100)
			 System.out.println(res[2]);
	    } // main
} // class Greedy_decreasing
