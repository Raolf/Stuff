import java.util.ArrayList;

public class Board {
    private int sizeY;
    private Stack targetStack,startStack, stack2, checkStack;
    private ArrayList<Stack> stacks;
    private ArrayList<Disk> disks;
    private Canvas canvas;

    public Board(int sizeY){
        this.sizeY = sizeY;
        stacks = new ArrayList<Stack>();
        disks = new ArrayList<Disk>();
        checkStack = new Stack(this,-1);

        for (int i=0; i<3; i++){
            Stack stack = new Stack(this,i);
            stacks.add(stack);
        }

        for(int i=0; i<sizeY; i++){
            Disk disk = new Disk(sizeY-i, stacks.get(0));
            stacks.get(0).add(disk);
            checkStack.add(disk);
            this.disks.add(disk);
        }
    }
    public Stack getStack(int index){
        return stacks.get(index);
    }
    public int getSizeY(){
        return sizeY;
    }
    public boolean checkWin(){
        if(targetStack == checkStack){
            return true;
        }else {
            return false;
        }

    }
    public ArrayList<Disk> getDisks(){
        return this.disks;
    }
    public Disk getDisk(int index){
        if (index <= sizeY){
            return disks.get(sizeY-index);
        }
        else return disks.get(sizeY);
    }
    public Canvas getCanvas(){
        return canvas;
    }
    public void setCanvas(Canvas canvas){
        this.canvas = canvas;
    }
}
