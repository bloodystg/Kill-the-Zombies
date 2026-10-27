package videogame;

/**
 *
 * @author Jian
 * @param <E>
 */
public class OrderedSinglyLinkedList<E extends Comparable<E>> {

    // declare fields here ( private )
    private Node<E> head;
    private Node<E> tail;
    private int numElements;

    // write constructor here
    /**
     * Constructor
     *
     */
    public OrderedSinglyLinkedList() {

        head = null;
        tail = null;
        numElements = 0;
    }

    // methods here - iterator() is provided at the bottom
    /**
     * size method returns the collection's current size
     *
     * @return the value in the numElements field
     */
    public int size() {
        return numElements;
    }

    /**
     * add method adds value to the collection
     *
     * @param newElement the value to be added to the collection
     */
    public void add(E newElement) {
        Node<E> cursor = head, previous = null;
        boolean found = false;
        if (tail == null) {
            head = new Node<E>(newElement, null);
            tail = head;
        } else {
            while (cursor != null && !found) {
                if (cursor.getData().compareTo(newElement) > 0) {
                    found = true;
                    if (previous == null) {
                        head = new Node<E>(newElement, head);
                    } else {
                        previous.setNext(new Node<E>(newElement, cursor));
                    }
                } else {
                    previous = cursor;
                    cursor = cursor.getNext();
                }
            }
            if (!found) {
                previous.setNext(new Node<E>(newElement, null));
                tail = tail.getNext();
            }
        }
        numElements++;
    }

    /**
     * the exists method looks for a value in the list
     *
     * @param target the value to be found in the collection
     * @return a boolean to indicate if target value is found in the collection
     */
    public boolean exists(E target) {
        boolean found = false;
        Node<E> cursor = head;
        while (cursor != null && !found) {
            if (cursor.getData().equals(target)) {
                found = true;
            } else {
                cursor = cursor.getNext();
            }
        }
        return found;
    }

    /**
     * remove method looks for a value in the collection and removes the first
     * occurrence, this version maintains order
     *
     * @param target the value to be removed from the collection
     * @return a boolean to indicate if the target value was removed from the
     * collection
     */
    public boolean remove(E target) {
        Node<E> cursor = head, previous = null; //
        boolean found = false;

        while (cursor != null && !found) {
            if (cursor.getData().equals(target)) {
                found = true;
            } else {
                previous = cursor;
                cursor = cursor.getNext();
            }
        }
        if (found && cursor != null) {
            if (previous == null) {
                head = head.getNext();
            } else {
                previous.setNext(cursor.getNext());
            }
            if (tail == cursor) {
                tail = previous;
            }
            numElements--;
        }
        return found;
    }

    /**
     * the countOccurrences method looks for the number of times the value is in the collection
     *
     * @param target the value to be found in the collection
     * @return an int with the number of times target value is found in the
     * collection
     */
    public int countOccurrences(E target) {
        Node<E> cursor = head;
        int count = 0;
        while (cursor != null) {
            if (cursor.getData().equals(target)) {
                count++;
            }
            cursor = cursor.getNext();

        }
        return count;
    }

    /**
     * the iterator method "copies" the linked list and passes the copied linked
     * list to a new Lister
     *
     * @return a Lister using a copy of the linked list
     */
    public Lister<E> iterator() {
        // declare variables
        Node<E> headOfListToReturn; // beginning of new "copied" list
        Node<E> cursorOfListToCopy; // active node of list to copy
        Node<E> lastNodeOfListToReturn; // end of new "copied" list

        // establish the copied list
        headOfListToReturn = null;

        if (head != null) {
            // create the head of the new list
            headOfListToReturn = new Node<E>(head.getData(), null);
            // use lastNodeOfListToReturn as a pointer to the last node in the copied list
            lastNodeOfListToReturn = headOfListToReturn;
            /* for debugging:
             if (head == tail)
             System.out.println("T: "+head.getData());
             */
            // use currentCursor as the pointer to the existing list
            cursorOfListToCopy = head.getNext();
            // if we have a node...
            while (cursorOfListToCopy != null) {
                // create a new node from the end of the new list
                lastNodeOfListToReturn.setNext(new Node<E>(cursorOfListToCopy.getData(), null));
                // move lastNodeOfListToReturn to the new last node
                lastNodeOfListToReturn = lastNodeOfListToReturn.getNext();
                /* for debugging:
                 if (cursorOfListToCopy == tail)
                 System.out.println("T: "+cursorOfListToCopy.getData());
                 */
                // move the cursorOfListToCopy to the next node
                cursorOfListToCopy = cursorOfListToCopy.getNext();
            }
        }
        return new Lister<E>(headOfListToReturn);
    }

}
