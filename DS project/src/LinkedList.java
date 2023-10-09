public class LinkedList<T>{
    private Node<T> head;
    private Node<T> current;

    public LinkedList(){
        head=current=null;
    }

    public boolean empty(){
     return head==null;
    }

    public boolean last(){
      return current.next==null;
    }

    public boolean full () {
      return false; 
    }

    public void findfirst () {
     current = head;
    }

    public void findnext () {
     current = current.next; 
    }

    public T retrieve () {
     return current.data; 
    }

    public void update (T val) {
     current.data = val; 
    }


    public void insert(T val) {
        Node<T> tmp = new Node<T>(val);
        if(empty()) {
        current = head = tmp;
        }
        else {
        tmp.next = current.next;
        tmp.previous = current;
        if(current.next != null)
        current.next.previous = tmp;
        current.next = tmp;
        current = tmp;
        }
    }
        

    public void remove() {
            if(current == head) {
            head = head.next;
            if(head != null)
            head.previous = null;
            }
            else {
            current.previous.next = current.next;
            if(current.next != null)
            current.next.previous = current.previous;
            }
            if(current.next == null)
            current = head;
            else
            current = current.next;
    }

    public void findPrevious() {
        Node<T> tmp = head;
            while(tmp.next != current)
                tmp = tmp.next;
            current = tmp;
    }

    public void findLast() {
        while(current.next != null)
            current = current.next;
    }

    public boolean find(T data) {
            if(this.empty()) {
                return false;
            }
                       
            Node<T> current = head;
                       
            while(current != null) {
                           
                if(current.getData().equals(data)) {
                    return true;
                }
                           
                current = current.getNext();
            }
        return  false;
    }

    public boolean contains(Contact contact) {
        return false;
    }



    public boolean contains(T obj) {
        Node<T> current = head;

        while (current != null) {
            if (current.data.equals(obj)) {
                return true; 
            }
            current = current.next;
        }

        return false;
    }

}
    
