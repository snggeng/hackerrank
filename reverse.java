/*
  Insert Node at the end of a linked list
  head pointer input could be NULL as well for empty list
  Node is defined as
  class Node {
     int data;
     Node next;
     Node prev;
  }
  null <- 1 <-> 2 <-> 3 -> null
  null <- 3 <-> 1 <-> 2 -> null
  null <- 3 <-> 2 <-> 1 -> null
*/

/*
// Iterative
Node Reverse(Node head) {
    Node temp = head;
    Node newHead = head;
    while (temp != null) {
        Node prev = temp.prev;
        temp.prev = temp.next;
        temp.next = prev;
        newHead = temp;
        temp = temp.prev;
    }
    return newHead;
}
*/

/* Recursion */
Node Reverse(Node head)
{
    // Complete this function
    // Do not write the main method.
    if(head==null){
        return head;
    }
    else if(head.next==null){
        head.next=head.prev;
        head.prev=null;
        return head;
    }
    Node prevPtr=head.prev;
    Node nextPtr=head.next;
    head.next=prevPtr;
    head.prev=nextPtr;
    return Reverse(nextPtr);
}
