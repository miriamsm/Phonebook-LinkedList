public class Node { 
    Contact data;
    Node next;
    Node prev;

    public Node(Contact data) {
        this.data = data;
        this.next = null;
        this.prev=null;
    }
}
