/*
  Insert Node at the end of a linked list
  head pointer input could be NULL as well for empty list
  Node is defined as
  class Node {
     int data;
     Node next;
  }
*/
// get length of nodes first
// reposition pointer of the longer node so that nodes are the same length
// check for merge

/*
// SOLUTION 1 : using node.data
int FindMergeNode(Node headA, Node headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);

        while(lenA > lenB) {
            headA = headA.next;
            lenA--;
        }

        while(lenA < lenB) {
            headB = headB.next;
            lenB--;
        }

        while(headA != null) {
            if (headA.data == headB.data) {
                return headA.data;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return Integer.MIN_VALUE;
    }

    // helper method to find length of node
    private int getLength(Node node) {
        int len = 0;
        Node curr = node;
        while (curr != null) {
            curr = curr.next;
            len++;
        }
        return len;
    }
*/

// SOLUTION 2 : using node points
int FindMergeNode(Node headA, Node headB) {
    Node currentA = headA;
    Node currentB = headB;

    //Do till the two nodes are the same
    while(currentA != currentB){
        //If you reached the end of one list start at the beginning of the other one
        //currentA
        if(currentA.next == null){
            currentA = headB;
        }else{
            currentA = currentA.next;
        }
        //currentB
        if(currentB.next == null){
            currentB = headA;
        }else{
            currentB = currentB.next;
        }
    }
    return currentB.data;
}
