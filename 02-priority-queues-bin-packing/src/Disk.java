import java.util.Comparator;

public class Disk implements Comparable<Disk>{
    private List<Integer> folders = null;
    private static int Id = -1;
    private final int diskId;
    private static final int MAXCAPACITY = 1000000; // MB
    private int freeSpace;
    public Disk(){
        this.folders = new List<Integer>();
        freeSpace = MAXCAPACITY;
        Id++;
        diskId = Id;
    }

    /**
     * @param d
     * returns
     * positive if free space of this > d
     * negative if free space of this < d
     * 0 if free space of this == d
     */
    @Override
    public int compareTo(Disk d) {
        return getFreeSpace() - d.getFreeSpace();
    }

    public int getFreeSpace(){
        return this.freeSpace;
    }

    public void setSpace(int data){
        if (data <= MAXCAPACITY && data <= freeSpace)
            freeSpace -= data;
        else
            System.out.println("There is no enough space on Disk!!!");
    }

    public int getDiskId(){
        return diskId;
    }

    public List<Integer> getFolders() {
        return this.folders;
    }

    /**
     *
     * @param disk if the disk has enough space adds the folder into list folders
     * @param folderSize
     * @return true if the disk has enough space otherwise return false
     */
    public boolean addInFolders(Disk disk, int folderSize) {
        if (disk.getFreeSpace() < folderSize)
            return false;
        disk.folders.insertAtBack(folderSize);
        disk.setSpace(folderSize);
        return true;
    }

    public String toString() {
        String s = "id " + getDiskId() + " " + getFreeSpace() + ": " + folders;
        return s;
    }

} // class Disk


