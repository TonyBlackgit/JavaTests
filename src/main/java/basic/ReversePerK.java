package basic;

public class ReversePerK {
  private static final int K = 5;
  private static final int D = 40;

  public static void main(String[] args) {
    Node head = buildData(D);
    Node left = head;
    Node right = left;
    int i = 0;
    while(i < D){
      for(int j=1; j<Math.min(K, D-i); j++){
        left = left.next;
      }
      reverse(right);
      i += K;
    }
  }
  private static Node reverse(Node head){
    return null;
  }

  private static Node buildData(int n) {
    Node head = new Node(1, null);
    Node current = head;
    for (int i = 2; i <= n; i++) {
      Node tmp = new Node(i, null);
      current.next = tmp;
      current = tmp;
    }
    return head;
  }
}
