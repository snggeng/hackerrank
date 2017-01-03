/*
  Insert Node at the end of a linked list
  head pointer input could be NULL as well for empty list
  Node is defined as
  class Node {
     int data;
     Node next;
     Node prev;
  }
*/

/* SOLUTION 1 : Recursion
// initialize new node with data
// check for empty list
// else if inserted node < head, put it behind it
// else node > head, SortedInsert(head.next, data) so head

Node SortedInsert(Node head,int data) {
    Node n = new Node();
    n.data = data;
    if (head == null) return n;

    else if (data <= head.data) {  // add node behind
        n.next = head;
        head.prev = n;
        return n;
    }
    else {  // add node in front
        Node rest = SortedInsert(head.next, data);
        head.next = rest;
        rest.prev = head;
        return head;
    }
}
*/

/* SOLUTION 2 : Iterative Traversal */

Node SortedInsert(Node head, int data) {
    Node insert = new Node();
    insert.data = data;

    // List is empty
    if (head == null) {
        head = insert;
    }
    // Insert front
    else if (data < head.data) {
        insert.next = head;
        head.prev = insert;
        head = insert;
    }
    // Insert middle or end
    else {
        Node current = head;
        // Iterate through list to find insertion point
        while (current.next != null && current.data < data) {
            current = current.next;
        } // Stops at end of list or just after insertion point

        // Insert before current
        if (data < current.data) {
            Node previous = current.prev;

            // Create links to and from node before insertion point
            previous.next = insert;
            insert.prev = previous;
            // Create links to and from node after insertion point
            insert.next = current;
            current.prev = insert;
        }
        // Insert after current at end of list
        else {
            current.next = insert;
            insert.prev = current;
        }
    }

    return head;
}
