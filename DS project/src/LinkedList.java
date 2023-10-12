public class LinkedList<T> {
    private Node<T> head;
    private Node<T> current;

    public LinkedList() {
        head = current = null;
    }

    public boolean empty() {
        return head == null;
    }

    public boolean last() {
        return current == null || current.next == null;
    }

    public void findfirst() {
        current = head;
    }

    public void findnext() {
        if (current != null) {
            current = current.next;
        }
    }

    public T retrieve() {
        return (current != null) ? current.getData() : null;
    }

    public void insert(T data) {
        Node<T> node = new Node<>(data);

        if (empty()) {
            head = current = node;
        } else {
            current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
    }

    public void remove(T data) {
        if (empty()) {
            return;
        }

        if (head.getData().equals(data)) {
            head = head.next;
            current = head;
            return;
        }

        current = head;
        Node<T> previous = null;

        while (current != null && !current.getData().equals(data)) {
            previous = current;
            current = current.next;
        }

        if (current != null) {
            previous.next = current.next;
            current = previous;
        }
    }


    public void findLast() {
        if (head == null) {
            current = null;
            return;
        }

        current = head;
        while (current.next != null) {
            current = current.next;
        }
    }

    public boolean contains(T obj) {
        current = head;
        while (current != null) {
            if (current.getData().equals(obj)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }


    // a method that returns an object Contact from a Stirng
    public Contact searchContact(String name){
        if (name == null || name=="")
        return null;

        if (this.empty())
        return null;

        current=head;
        Contact temp = (Contact) current.data;

        while(!((temp).getName().equalsIgnoreCase((name)))){
            current=current.getNext();
            temp=(Contact) current.data;
        }
        return temp;
    }


    // // a method that returns an object Event from a Stirng
    public Event searchEvent(String title){
        if (title == null || title=="")
        return null;

        if (this.empty())
        return null;

        current=head;
        Event temp = (Event) current.data;

        while(!((temp).getTitle().equalsIgnoreCase((title)))){
            current=current.getNext();
            temp=(Event) current.data;
        }
        return temp;
    }

    public void Sort() {
        if (head == null || head.next == null) {
            return; // Nothing to sort
        }
    
        boolean swapped;
        Node<T> last = null;
    
        do {
            swapped = false;
            current = head;
    
            while (current.next != last) {
                if (((Comparable<T>) current.getData()).compareTo(current.next.getData()) > 0) {
                    // Swap the data of current and current.next
                    T temp = current.getData();
                    current.setData(current.next.getData());
                    current.next.setData(temp);
                    swapped = true;
                }
                current = current.next;
            }
            last = current;
        } while (swapped);
    }
    







}






    
