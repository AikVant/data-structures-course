import java.io.File;

public class FunctionsOfMenu  {
    protected static String theFileName;
    static String[] readFile(String fileName, String[] array) throws Exception{
        array = new String[0]; // initialize array containing the contents of the file
        String nameOfFile = fileName;
        theFileName = nameOfFile;
        // Read file
        File filename = new File(nameOfFile);
        ReadFile rf = new ReadFile(filename);
        array = rf.getArray(filename);

        return array;
    }

    static TwoDTree createTwoDTree(String[] array) {
        TwoDTree tree = new TwoDTree();
        try {
            for (int i = 1; i < array.length; i++) {
                tree.insert(ReadFile.getPointFromArrayOfStrings(array, i));
            }
            System.out.println(" The 2d_tree in question:\n" + tree);
            System.out.println(" ----------------------------------------------------------------------------------------\n");
        } catch (Exception e) {
            System.out.println(e);
        }
        return tree;
    }

    static int computeTheSizeOfTheTree(TwoDTree tree) {
        System.out.println(" The size of the tree = " + tree.size());
        System.out.println(" ----------------------------------------------------------------------------------------\n");
        return tree.size();
    }

    static TwoDTree insertNewPoint(TwoDTree tree, Point p) {
        boolean exists = tree.search(p);
        if (!exists) {
            tree.insert(p);
            System.out.println(" The point " + p + " has been inserted into the tree.\n" + tree);
            System.out.println(" ----------------------------------------------------------------------------------------\n");
        }else{
            System.out.println(" The point " + p + " was not inserted, it already exists in the tree.\n" + tree);
            System.out.println(" ----------------------------------------------------------------------------------------\n");
        }
        return tree;
    }

    static boolean searchIfTheGivenPointExistsInTheTree(TwoDTree tree, Point p) {
        boolean exists = tree.search(p);
        if (exists) {
            System.out.println(" The point " + p + " exists in the tree.\n" + tree);
            System.out.println(" ----------------------------------------------------------------------------------------\n");
        } else {
            System.out.println(" The point " + p + " is not exists in the tree.\n" + tree);
            System.out.println(" ----------------------------------------------------------------------------------------\n");
        }
        return exists;
    }

    static Queue<Point> PointsOfTheTreeThatAreInTheRectangle(TwoDTree tree, Rectangle rect) {
        Queue<Point> queue = tree.rangeSearch(rect);
        System.out.println(" The points that are in the query rectangle " + rect + ":\n" + queue);
        System.out.println(" ----------------------------------------------------------------------------------------\n");
        return queue;
    }

    static Point PointOfTheTreeThatIsNearestToQueryPoint(TwoDTree tree, Point queryPoint) {
        Point p = tree.nearestNeighbor(queryPoint);
        double doubleDistance = p.distanceTo(queryPoint);
        int intDistance = p.squareDistanceTo(queryPoint);
        System.out.println(" The nearest neighbor to " + queryPoint + " is the point " + p + " of the tree");
        System.out.println(" The distance between " + queryPoint + " and " + p + " = " + doubleDistance + " units.");
        System.out.println(" The square distance between " + queryPoint + " and " + p + " = " + intDistance + " units.");
        return queryPoint;
    }
}
