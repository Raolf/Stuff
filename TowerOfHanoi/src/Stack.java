import java.util.ArrayList;

public class Stack {
    private ArrayList<Disk> list;
    private int indexS;
    private Board board;

    public Stack(Board board, int indexS){
        list = new ArrayList();
        this.indexS = indexS;
        this.board = board;
    }
    public void add(Disk disk2){
        list.add(disk2);
    }
    public void remove(Disk disk2){
        list.remove(disk2);
    }
    public int getStackSize(){
        return list.size();
    }
    public Disk getElement(int index){
        return list.get(index);
    }
    public Disk getTopDisk(){
        if (list.size()>0) {
            return list.get(list.size() - 1);
        }else{
            return null;
        }
    }
    public Disk getDisk(int index){
        return list.get(index-1);
    }

    public int getIndex() {
        return indexS;
    }
    public Board getBoard(){
        return board;
    }

    public ArrayList<Disk> getList() {
        return list;
    }
}
