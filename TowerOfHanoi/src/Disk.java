public class Disk {
    private int size, yPos;
    private Stack stack;

    public Disk(int size, Stack stack){
        this.size = size;
        this.yPos = yPos;
        this.stack = stack;

    }
    public void move (Stack stack){
        if (this.stack.getTopDisk() == this) {
            if (this.smallerThan(stack.getTopDisk())) {
                this.stack.remove(this);
                stack.add(this);
                this.stack = stack;
                this.yPos = stack.getList().indexOf(this)+1;
                try{
                    stack.getBoard().getCanvas().Update(this, this.stack);
                }catch(Exception e){
                    System.out.println("Disk Move " + e);
                }
            } else {
                System.out.println("Disk is larger than target");
            }
        }else{
            System.out.println("Disk is not top of stack");
        }
    }
    public boolean smallerThan(Disk disk2){
        if(disk2 != null) {
            if (this.size < disk2.getSize()) {
                return true;
            } else {
                return false;
            }
        }else{
            return true;
        }
    }
    public int getPos(){
        return this.yPos;
    }
    public int getSize(){
        return this.size;
    }
    public Stack getStack(){
        return this.stack;
    }
}
