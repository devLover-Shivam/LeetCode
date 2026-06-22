import java.util.*;
class Node{
    int data;
    Node next;

    Node(int data, Node next){
        this.data=data;
        this.next=next;
    }

    Node(int data){
        this.data = data;
        this.next = null;        
    }
}

public class completeSolution {

    static Node reverseLL(Node head){
        if(head==null || head.next == null) return head;
        Node temp = head;
        Node prev = null;
        Node front;
        while(temp!=null){
            front = temp.next;
            temp.next = prev;
            prev =temp;
            temp =front;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

         // Find the middle node
        Node revNode = reverseLL(head);

        // Display the value of the middle node
        System.out.println("The rev node value is: " + revNode.data);
    }
}