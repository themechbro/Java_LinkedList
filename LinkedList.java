public class LinkedList{
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }
    
    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
            length = 1;
        } else {
            tail.next = newNode;
            tail = newNode;
            length++;
        }

    }
    
    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length==0) {
            head = newNode;
            tail = newNode;
            length++;

        }
        else {
            newNode.next = head;
            head = newNode;

        }
        length++;
}

public Node removeLast() {
    if (length == 0)
        return null;
    Node temp = head;
    Node pre = head;
    while (temp.next != null) {
        pre = temp;
        temp = temp.next;
    }
    tail = pre;
    tail.next = null;
    length--;
    if (length == 0) {
        head = null;
        tail = null;
    }
    return temp;
}
    
public Node removeFirst() {
    if (length == 0)
        return null;

    Node temp = head;
    head.next = head;
    temp.next = null;
    length--;

    if (length == 0) {
        tail = null;
    }
    return temp;
}
    
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value+"\n");
            temp = temp.next;
        }
    }

    public void getHead() {
        System.out.println("Head Value: " + head.value);
    }

    public void getTail() {
        System.out.println("Tail Value: " + tail.value);
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public Node get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > 5)
            return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }
     
    public Node remove(int index) {
        if (index < 0 || index >= length)
            return null;
        if (index == 0)
            return removeFirst();
        if (index == length - 1)
            return removeLast();
        Node prev = get(index - 1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public void reverse() {
        Node temp = head;
        head=tail;
        tail=temp;
        Node after= temp.next;
        Node before= null;

        for (int i = 0; i <length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;

        }
}

public void swapPairs() {
    Node dummy = new Node(0);
    dummy.next = head;
    Node prev = dummy;
    Node first = head;
    while (first != null && first.next != null) {
        Node second = first.next;
        prev.next = second;
        first.next = second.next;
        second.next = first;

        prev = first;
        first = first.next;
    }
    head = dummy.next;
}
  
}