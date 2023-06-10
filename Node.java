//CODE FROM BUILDING JAVA PROGRAMS THIRD EDITION
public class Node{
    public int data;
    public Node next;
    public Node(){
        this(0, null);
    }
    public Node(int data){
        this(data, null);
    }
    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
    public String toString(){
        return "" + data;
    }
    
}