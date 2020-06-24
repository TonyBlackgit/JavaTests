package basic;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class JosephCircle {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Please input the number of all people(n>2): ");
    int n = scan.nextInt();
    if (n < 2) {
      System.out.println("Wrong number");
      return;
    }

    Node head = buildData(n);
    scanData(head);
    Node current = head;
    Node pre = current;
    while (current.next.next != current) {
      pre = current.next;
      current = pre.next;
      System.out.println("current remove person is: " + current.num);
      pre.next = current.next;
      current = pre.next;
    }
    scanData(current);
  }

  private static Node buildData(int n) {
    Node head = new Node(1, null);
    Node current = head;
    for (int i = 2; i <= n; i++) {
      Node tmp = new Node(i, null);
      current.next = tmp;
      current = tmp;
    }
    current.next = head;
    return head;
  }

  private static void scanData(Node head) {
    Node current = head;
    do {
      System.out.print(current.num + ",");
      current = current.next;
    }while(current != head);
    System.out.println();
  }
}

class Node {
  int num;
  Node next;

  public Node(int num, Node next) {
    this.num = num;
    this.next = next;
  }
}