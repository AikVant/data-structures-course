public class Point {
    private int x;
    private int y;

    public Point(){
        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int x(){
        return this.x;
    }
    public int y(){
        return this.y;
    }

    /**
     *
     * @param z Point
     * @return euclidean distance between this and the parameter point
     */
    public double distanceTo(Point z){
        if (z.x() >= 0 && z.x() <= 100 && z.y() >= 0 && z.y() <= 100) {
            int cord_x = this.x - z.x;
            int cord_y = this.y - z.y;
            return Math.sqrt(cord_x * cord_x + cord_y * cord_y);
        }
        System.out.print("Out of bounds:(");
        return 0.0;
    }

    /**
     *
     * @param z Point
     * @return square of euclidean distance between this and the parameter point
     */
    public int squareDistanceTo(Point z){
        double distance = distanceTo(z);
        return (int) (distance * distance);
    }

    public String toString(){
        return "(" + x + ", " + y + ")";
    }
}
