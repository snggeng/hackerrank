/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as:
    class Node {
        int data;
        Node next;
    }
*/

boolean hasCycle(Node head) {
    if (head == null) return false; // check if list is empty

    Node slow, fast; // create two node pointers to compare against each other while traversing list.
    slow = fast = head;

    while(true) {
        slow = slow.next;          // 1 ahead.
        if(fast.next != null)
            fast = fast.next.next; // 2 ahead.
        else
            return false;          // next node null => no cycle.

        if(slow == null || fast == null) // if either are null, there's no cycle.
            return false;

        if(slow == fast) // if identical, there's a cycle.
            return true;
    }

}
