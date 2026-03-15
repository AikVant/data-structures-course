public class MazeSolver {
    private final Maze maze;
    private final StringStackImpl<String> stack = new StringStackImpl<>();
    public MazeSolver(Maze maze) {
        this.maze = maze;
    }
    public StringStackImpl<String> getStack(){
        return this.stack;
    }

    /**
     * receives @param x and @param y as ints, converts x and y to string and back to int
     * pops the last node and
     * calls tryPosition at x, y to note that the position(x, y) is accessed
     * pushes the nodes in the stuck if the position(x, y) is valid
     * @return true if the maze is solved
     */
    public boolean traverse(int x, int y){
        boolean done = false;
        String pos = ("(" + x + "," + y + ")"); // (x,y)
        stack.push(pos);

        while (!(done) && !stack.isEmpty()){
            pos = stack.pop();
            StringBuilder result1 = new StringBuilder();
            StringBuilder result2 = new StringBuilder();
            int z = 1;
            while (pos.charAt(z) != ','){
                result1.append(pos.charAt(z));
                z++;
            }
            z++;
            while (pos.charAt(z) != ')'){
                result2.append(pos.charAt(z));
                z++;
            }
            x = Integer.parseInt(result1.toString());
            y = Integer.parseInt(result2.toString());
            maze.tryPosition(x, y);
            if (maze.solved(x, y) && (maze.getEntranceX() != x || maze.getEntranceY() != y)){
                stack.push(pos);
                done = true; // the maze is solved
            }else{
                pushNewPos(x-1, y, stack); // up
                pushNewPos(x, y-1, stack); // left
                pushNewPos(x+1, y, stack); // down
                pushNewPos(x, y+1, stack); // right
            }
        }
        return done;
    }

    /**
     * Checks if position (@param x, @param y) is valid
     * and if it is, pushes the node in @param stack
     */
    public void pushNewPos(int x, int y, StringStackImpl<String> stack){
        String pos = ("(" + x + "," + y + ")");
        if (maze.validPosition(x, y)){
            stack.push(pos);
        }
    }
}
