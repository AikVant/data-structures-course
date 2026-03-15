public class Rectangle {
    private int xmin;
    private int xmax;
    private int ymin;
    private int ymax;

    /**
     * constructor
     * creates a rectangle [0,100] x [0,100]
     */
    public Rectangle(){
        this.xmin = 0;
        this.xmax = 100;
        this.ymin = 0;
        this.ymax = 100;
    }

    /**
     * constructor of a Rectangle object
     * @param p1 Point
     * @param p2 Point
     * p1.x() < p2.x()
     * p1.y() < p2.y()
     * lower left corner: (xmin, ymin)
     * upper right corner: (xmax, ymax)
     */
    public Rectangle(Point p1, Point p2){
        if (p1.x() < p2.x()) {
            this.xmin = p1.x();
            this.xmax = p2.x();
        }else{
            this.xmin = p2.x();
            this.xmax = p1.x();
        }
        if (p1.y() < p2.y()) {
            this.ymin = p1.y();
            this.ymax = p2.y();
        }else{
            this.ymin = p2.y();
            this.ymax = p1.y();
        }
    }

    /**
     * constructor of a Rectangle object [xmin, xmax] x [ymin, ymax]
     * @param xmin int
     * @param xmax int
     * @param ymin int
     * @param ymax int
     */
    public Rectangle(int xmin, int xmax, int ymin, int ymax){
        if (xmin < xmax) {
            this.xmin = xmin;
            this.xmax = xmax;
        }else{
            this.xmin = xmax;
            this.xmax = xmin;
        }
        if (ymin < ymax) {
            this.ymin = ymin;
            this.ymax = ymax;
        }else{
            this.ymin = ymax;
            this.ymax = ymin;
        }

    }

    /**
     * getter
     * @return xmin
     */
    public int xmin(){
        return this.xmin;
    }

    /**
     * getter
     * @return ymin
     */
    public int ymin(){
        return this.ymin;
    }

    /**
     * getter
     * @return xmax
     */
    public int xmax(){
        return this.xmax;
    }

    /**
     * getter
     * @return ymax
     */
    public int ymax(){
        return this.ymax;
    }

    /**
     * Does p belong to this rectangle?
     * @param p
     * @return false if p not in the Rectangle, otherwise true
     */
    public boolean contains(Point p){
        if (p.x() < xmin() || p.x() > xmax() || p.y() < ymin() || p.y() > ymax())
            return false;
        return true;
    }

    /**
     * Do the two rectangles intersect?
     * @param that
     * @return false if this and that Rectangles not intersects, otherwise true
     */
    public boolean intersects(Rectangle that){
        if (that.xmax() < this.xmin() || that.xmin() > this.xmax() || that.ymax() < this.ymin() || that.ymin() > this.ymax())
            return false;
        return true;
    }

    /**
     * @param p the point whose distance from the rectangle we are looking for
     * @return double euclidean distance of the query point and the rectangle
     */
    public double distanceTo(Point p){
        double distance = 0.0;
        if (!contains(p)){
            // if the point is in the bottom-left corner(xmin,ymin) extension of the rectangle
            if (p.x() < this.xmin() && p.y() < this.ymin()){
                Point c = new Point(xmin(), ymin());
                distance = c.distanceTo(p);
            }
            // if the point is in the bottom-right corner(xmax,ymin) extension of the rectangle
            if (p.x() > this.xmax() && p.y() < this.ymin()){
                Point c = new Point(xmax(), ymin());
                distance = c.distanceTo(p);
            }
            // if the point is in the upper-left corner(xmin,ymax) extension of the rectangle
            if (p.x() < this.xmin() && p.y() > this.ymax()){
                Point c = new Point(xmin(), ymax());
                distance = c.distanceTo(p);
            }
            // if the point is in the upper-right corner(xmax, ymax) extension of the rectangle
            if (p.x() > this.xmax() && p.y() > this.ymax()){
                Point c = new Point(xmax(), ymax());
                distance = c.distanceTo(p);
            }
            // if the point is in the left extension of the rectangle
            if (p.x() < this.xmin() && p.y() <= this.ymax() && p.y() >= this.ymin()){
                Point c = new Point(this.xmin(), p.y());
                distance = c.distanceTo(p);
            }
            // if the point is in the right extension of the rectangle
            if (p.x() > this.xmax() && p.y() <= this.ymax() && p.y() >= this.ymin()){
                Point c = new Point(this.xmax(), p.y());
                distance = c.distanceTo(p);
            }
            // if the point is in the upper extension of the rectangle
            if (p.y() > this.ymax() && p.x() <= this.xmax() && p.x() >= this.xmin()){
                Point c = new Point(p.x(), this.ymax());
                distance = c.distanceTo(p);

            }
            // if the point is in the lower extension of the rectangle
            if (p.y() < this.ymin() && p.x() <= this.xmax() && p.x() >= this.xmin()){
                Point c = new Point(p.x(), this.ymin());
                distance = c.distanceTo(p);
            }
        }
        return distance;
    }

    /**
     * @param p
     * @return int square of euclidean distance from p to the closest point in rectangle
     */
    public int squareDistanceTo(Point p){
        double distance = distanceTo(p);
        return (int) (distance * distance);
    }

    public String toString(){
        return "[" + xmin() + "," + xmax() + "] x [" + ymin() + "," + ymax() + "]";
    }

}
