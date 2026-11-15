import java.awt.Color;
import java.util.*;

public abstract class Enemy {
    public enum Type {
        HUNTER(new Color(255,83,118)), ROAMER(new Color(255,178,76)), WANDERER(new Color(190,119,255));
        private final Color color; Type(Color color){this.color=color;} public Color getColor(){return color;}
    }
    private int row,col,clock;
    private final Type type;
    private final int moveEveryTicks;
    protected final Random random=new Random();
    protected Enemy(int row,int col,Type type,int moveEveryTicks){this.row=row;this.col=col;this.type=type;this.moveEveryTicks=moveEveryTicks;}
    public int getRow(){return row;} public int getCol(){return col;} public Type getType(){return type;}
    public void setPosition(int row,int col){this.row=row;this.col=col;resetClock();}
    public void advanceClock(){clock++;} public boolean isReadyToMove(){return clock>=moveEveryTicks;} public void resetClock(){clock=0;}
    protected boolean occupied(int row,int col,List<Enemy> enemies){
        for(Enemy other:enemies)if(other!=this&&other.getRow()==row&&other.getCol()==col)return true;return false;
    }
    protected List<int[]> legalMoves(Maze maze,List<Enemy> enemies){
        List<int[]> moves=new ArrayList<>();int[][] ds={{-1,0},{1,0},{0,-1},{0,1}};
        for(int[] d:ds){int r=row+d[0],c=col+d[1];if(maze.canMoveTo(r,c)&&!occupied(r,c,enemies))moves.add(new int[]{r,c});}
        return moves;
    }
    protected int distance(int r1,int c1,int r2,int c2){return Math.abs(r1-r2)+Math.abs(c1-c2);}
    public abstract void takeTurn(Player player,Maze maze,List<Enemy> enemies);
}
