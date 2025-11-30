package assignment5;

public class Question2 {
    public static class LinkedList{
        public static class Node{
            int data;
            Node next;

            Node(int value){
                data = value;
                next = null;
            }
        }

        private Node head;

        public LinkedList() { head = null; }

        public void display(){
            Node current = head;
            while(current != null){
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println("NULL");
        }

        public void insertAtBeg(int value){
            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
        }

        public void insertAtEnd(int value){
            Node temp = new Node(value);

            if(head == null){
                head = temp;
                return;
            }

            Node current = head;

            while(current.next != null){
                current = current.next;
            }
            current.next = temp;
        }

        public void countAndDelete(int value){
            int count = 0;
            if (head == null){
                System.out.print("NULL");
                return;
            }
            if(head.data == value){
                head = head.next;
                count++;
            }
            Node temp = head;

            while (temp != null && temp.next != null){
                if(temp.next.data == value){
                    temp.next = temp.next.next;
                    count++;
                } else {
                    temp = temp.next;
                }
            }
            System.out.println("The number of times " + value + " occurs is " + count);
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtBeg(1);
        list.insertAtEnd(2);
        list.insertAtEnd(1);
        list.insertAtEnd(3);
        list.insertAtEnd(1);
        list.insertAtEnd(1);
        list.insertAtEnd(4);
        list.display();
        list.countAndDelete(1);
        list.display();
    }
}
