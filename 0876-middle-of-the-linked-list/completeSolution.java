import java.util.*;

class Node{
    int data;
    Node next;

    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }

    Node(int data){
        this.data = data;
        this.next = null;    
    }  
}

public class completeSolution {
    static Node findMiddle(Node head){
        if(head==null || head.next == null) return head;

        int cnt = 0;
        Node temp = head;
        while(temp!=null){
            cnt++;
            temp = temp.next;
        }

        int middleNode = cnt/2+1;
        temp = head;
        while(temp != null){
            middleNode = middleNode-1;
            if(middleNode == 0) break;
            temp = temp.next;
        }
        return temp;
    }

    public static void main(String[] args) {
        // Creating a sample linked list:
        Node head = new Node(10);
        head.next = new Node(2);
        head.next.next = new Node(30);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(50);

        // Find the middle node
        Node midNode = findMiddle(head);

        // Display the value of the middle node
        System.out.println("The middle node value is: " + midNode.data);
    }
}