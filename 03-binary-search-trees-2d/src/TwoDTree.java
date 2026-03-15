public class TwoDTree {
    private class TreeNode {
        private Point item;
        private int level;
        private TwoDTree.TreeNode l;
        private TwoDTree.TreeNode r;

        TreeNode() {
            this.l = null;
            this.r = null;
            this.level = 0;
        }

        TreeNode(Point value) {
            this.item = value;
            this.l = null;
            this.r = null;
            this.level = 0;
        }

        public int level() {
            return this.level;
        }

        public Point getItem() {
            return this.item;
        }

        public TwoDTree.TreeNode l() {
            return this.l;
        }

        public TwoDTree.TreeNode r() {
            return this.r;
        }

        public void setItem(Point value){
            this.item = value;
        }
        public void setl(TwoDTree.TreeNode l){
            this.l = l;
        }
        public void setr(TwoDTree.TreeNode r){
            this.r = r;
        }
        public void setLevel(int level){ this.level = level; }

        public String toString(){
            return getItem().toString();
        }
    }
    private TwoDTree.TreeNode head; // root of the tree
    private int size;

    /**
     * constructor
     * creates an empty tree
     */
    public TwoDTree(){
        this.head = null;
        this.size = 0;
    }

    public TwoDTree(TreeNode root){
        this.head = root;
        this.size = 0;
    }

    /**
     * @return int number of points in the tree
     */
    public int size(){
        return this.size;
    }

    /**
     * is the tree empty?
     * @return boolean
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * public method for inserting a point to tree
     * @param p the point to be inserted
     */
    public void insert(Point p){
        head = insertR(head, p, 0);
    }

    /**
     * private auxiliary method for inserting a point to tree
     * @param current node as we traverse the tree
     * @param p the point to be inserted
     * @param level the level set to the current node with the value of p
     * @return the current node
     */
    private TwoDTree.TreeNode insertR(TreeNode current, Point p, int level){
        if (current == null){
            current = new TreeNode(p);
            current.setLevel(level);
            size++;
            return current;
        }
        if (p.x() == current.getItem().x() && p.y() == current.getItem().y()){
            return current;
        }
        if (level % 2 == 0){
            if (p.x() <= current.getItem().x()){
                current.l = insertR(current.l(), p, current.level()+1);
            }else if (p.x() > current.getItem().x()){
                current.r = insertR(current.r(), p, current.level()+1);
            }
        }else{
            if (p.y() < current.getItem().y()){
                current.l = insertR(current.l(), p, current.level()+1);
            }else{
                current.r = insertR(current.r(), p, current.level()+1);
            }
        }
        return current;
    }

    /**
     * Does the tree contains p?
     * @param p the query point
     * @return true if the tree contains p
     */
    public boolean search(Point p){
        boolean bool = searchTree(head, p);
        return bool;
    }

    /**
     * private auxiliary method for searching query point
     * @param current node as we traverse the tree
     * @param p the query point
     * @return true if the tree contains p, if we reach a null pointer means it is not found
     */
    private boolean searchTree(TwoDTree.TreeNode current, Point p){
        while(true){
            if (current == null)
                return false;
            if (current.getItem().x() == p.x() && current.getItem().y() == p.y())
                return true;
            if (current.level() % 2 == 0){
                if (p.x() <= current.getItem().x()){
                    current = current.l();
                }else if (p.x() > current.getItem().x()){
                    current = current.r();
                }
            }else{
                if (p.y() < current.getItem().y()){
                    current = current.l();
                }else{
                    current = current.r();
                }
            }
        }
    }

    /**
     * private auxiliary recursive method to nearest
     * @param targetRect the rectangle corresponding to the target point
     * @param root of the subtree
     * @param target the node of which we are looking for the corresponding rectangle
     * @return a rectangle corresponding to the target point
     */
    private Rectangle targetRectR(Rectangle targetRect, TreeNode root, TreeNode target){
        if (root != null) {
            if (root.level() % 2 == 0) {
                if (target.getItem().x() <= root.getItem().x()) {
                    targetRect = new Rectangle(0, root.getItem().x(), targetRect.ymin(), targetRect.ymax());
                    root = root.l(); // left
                    return targetRect;
                } else {
                    targetRect = new Rectangle(root.getItem().x(), targetRect.xmax(), targetRect.ymin(), targetRect.ymax());
                    root = root.r(); // right
                    return targetRect;
                }
            } else {
                if (target.getItem().x() <= root.getItem().x() && target.getItem().y() < root.getItem().y()) {
                    targetRect = new Rectangle(targetRect.xmin(), root.getItem().x(), targetRect.ymin(), targetRect.ymax());
                    root = root.l(); // left down
                    return targetRect;
                }
                if (target.getItem().x() <= root.getItem().x() && target.getItem().y() >= root.getItem().y()) {
                    targetRect = new Rectangle(targetRect.xmin(), root.getItem().x(), target.getItem().y(), targetRect.ymax());
                    root = root.r(); // left up
                    return targetRect;
                }
                if (target.getItem().x() > root.getItem().x() && target.getItem().y() < root.getItem().y()) {
                    targetRect = new Rectangle(root.getItem().x(), targetRect.xmax(), targetRect.ymin(), root.getItem().y());
                    root = root.l(); // right down
                    return targetRect;
                }
                if (target.getItem().x() > root.getItem().x() && target.getItem().y() >= root.getItem().y()) {
                    targetRect = new Rectangle(root.getItem().x(), targetRect.xmax(), root.getItem().y(), targetRect.ymax());
                    root = root.r(); // right up
                    return targetRect;
                }
            }
            targetRect = targetRectR(targetRect, root, target);
        }
        return targetRect;
    }

    /**
     *
     * @param p the query point
     * @return Point in the tree that is the closest to the query point p
     */
    public Point nearestNeighbor(Point p){
        TwoDTree.TreeNode closest = nearest(head, p, head);
        return closest.getItem();
    }

    /**
     * auxiliary private method to nearestNeighbor
     * @param current node in the tree
     * @param target the query point
     * @param closest node of the tree that is the closest to query point
     * @return the closest node to the query point
     */
    private TreeNode nearest(TreeNode current, Point target, TreeNode closest){
        TreeNode bestSide;
        TreeNode worstSide;
        int distanceFromBest = 0;
        int distanceFromWorst = 0;
        Rectangle worstRect = new Rectangle();

        // traverse the tree to find the closest node to the target point
        if (current == null)
            return closest;
        if (current.getItem().squareDistanceTo(target) < closest.getItem().squareDistanceTo(target))
            closest = current;
        if (current.level() % 2 == 0){
            if (target.x() <= current.getItem().x()){
                bestSide = current.l();
                worstSide = current.r();
                if (worstSide != null)
                    worstRect = targetRectR(new Rectangle(worstSide.getItem(), target), current, new TreeNode(target));
            }else{
                bestSide = current.r();
                worstSide = current.l();
                if (worstSide != null)
                    worstRect = targetRectR(new Rectangle(worstSide.getItem(), target), current, new TreeNode(target));
            }
        }else{
            if (target.y() < current.getItem().y()){
                bestSide = current.l();
                worstSide = current.r();
                if (worstSide != null)
                    worstRect = targetRectR(new Rectangle(worstSide.getItem(), target), current, new TreeNode(target));
            }else{
                bestSide = current.r();
                worstSide = current.l();
                if (worstSide != null)
                    worstRect = targetRectR(new Rectangle(worstSide.getItem(), target), current, new TreeNode(target));
            }
        }
        closest = nearest(bestSide, target, closest);

        // calculate the square distance from the bestSide node to the target point
        if (bestSide != null)
            distanceFromBest = bestSide.getItem().squareDistanceTo(target);

        // calculate the square distance from the worstSide node to the target point
        if (worstSide != null)
            distanceFromWorst = worstRect.squareDistanceTo(target);

        // if the distance from worstSide node is shorter than the distance from bestSide node
        // then it is worth exploring this
        if (distanceFromWorst < distanceFromBest)
            closest = nearest(worstSide, target, closest);

        return closest;
    }

    /**
     *
     * @param rect the query rectangle
     * @return list with the Points that are contained in the query rectangle
     */
    public Queue<Point> rangeSearch(Rectangle rect){
        Queue queue = new Queue();
        queue = rangeSearchR(rect, queue, head);
        return queue;
    }

    /**
     * auxiliary private method to rangeSearch
     * @param rect the query rectangle
     * @param queue the list where the points contained in the query rectangle are stored
     * @param current node at the tree
     * @return list with the Points that are contained in the query rectangle
     */
    private Queue<Point> rangeSearchR(Rectangle rect, Queue queue, TwoDTree.TreeNode current){
        if (current == null)
            return queue;
        if (rect.contains(current.getItem())){
                queue.put(current.getItem());
        }
        rangeSearchR(rect, queue, current.l());
        rangeSearchR(rect, queue, current.r());
        return queue;
    }

    /**
     * auxiliary private method to toString
     * @param current node at the tree
     * @param s StringBuilder
     * @return a StringBuilder representation of the tree in level order
     */
    private StringBuilder levelOrder(TwoDTree.TreeNode current, StringBuilder s){
        Queue<TreeNode> queue = new Queue<TreeNode>();
        if (head == null)
            return s;
        queue.put(head);
        while (!queue.isEmpty()){
            current = (TreeNode) queue.get();
            if (current.l() != null)
                queue.put(current.l());
            if (current.r() != null)
                queue.put(current.r());
            s.append(" level:" + current.level() + " " + current.getItem() + " ");
        }
        return s;
    }

    /**
     * @return Representation of the tree in level order
     */
    public String toString(){
        StringBuilder s = levelOrder(head, new StringBuilder(""));
        return s.toString();
    }


}
