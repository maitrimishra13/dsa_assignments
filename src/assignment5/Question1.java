package assignment5;

public class Question1 {
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

        public void insertAtSpecificPosition(int num, int value){
            Node temp = new Node(num);

            if(head == null){
                head = temp;
                return;
            }

            Node temp1 = head;
            while(temp1.next != null && temp1.data != value){
                temp1 = temp1.next;
            }

            if (temp1 == null){
                System.out.println("Node not present in the list!");
            }
            else if (temp1.next == null){
                temp1.next = temp;
            } else {
                temp.next = temp1.next;
                temp1.next = temp;
            }
        }

        public void deleteAtBeg(){
            if(head == null){
                System.out.println("List is empty!");
                return;
            }
            head = head.next;
        }

        public void deleteAtEnd(){
            if(head == null){
                System.out.println("List is empty!");
                return;
            }

            if(head.next == null){
                head = null;
                return;
            }

            Node temp = head;
            Node prev = null;
            while(temp.next != null){
                prev = temp;
                temp = temp.next;
            }
            prev.next = null;
        }

        public void deleteAtSpecificPosition(int num){
            if(head == null){
                System.out.println("List is empty!");
                return;
            }

            if(head.data == num){
                head = head.next;
                return;
            }

            Node temp = head;
            Node prev = null;
            while(temp != null && temp.data != num){
                prev = temp;
                temp = temp.next;
            }

            if(temp == null){
                System.out.println("Node not present in the list!");
                return;
            }

            prev.next = temp.next;
        }

        public void search(int value) {
            Node temp = head;
            int position = 1;

            while (temp != null) {
                if (temp.data == value) {
                    System.out.println("Value " + value +
                            " found at position: " + position);
                    return;
                }
                temp = temp.next;
                position++;
            }

            System.out.println("Value " + value + " not found in the list.");
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtBeg(1);
        list.insertAtEnd(2);
        list.insertAtSpecificPosition(4, 5);
        list.insertAtEnd(5);
        list.insertAtEnd(4);
        list.display();
        list.deleteAtBeg();
        list.display();
        list.deleteAtEnd();
        list.display();
        list.deleteAtSpecificPosition(4);
        list.display();
        list.search(4);
        list.search(5);
    }
}
