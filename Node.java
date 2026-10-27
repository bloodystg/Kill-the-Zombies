package videogame;

/**
 *
 * @author Jian
 */
public class Node<E> {

    private E data;
    private Node<E> next;

    /**
     * Constructor to initialize a new node with data and the next node
     * reference
     *
     * @param initialData The initial value for the data of the node
     * @param initialNext The initial reference for the next node
     */
    public Node(E initialData, Node<E> initialNext) {
        this.data = initialData;
        this.next = initialNext;
    }

    /**
     * getData method returns value from the data field
     *
     * @return value from the data field
     */
    public E getData() {
        return data;
    }

    /**
     * assigns new data for data
     *
     * @param newData The new value to assign to the data field
     */
    public void setData(E newData) {
        this.data = newData;
    }

    /**
     * getNext method returns value from the next field
     *
     * @return value from the next field
     */
    public Node<E> getNext() {
        return next;
    }

    /**
     * assigns new value for next
     *
     * @param newNext The new node reference to assign to the next field
     */
    public void setNext(Node<E> newNext) {
        this.next = newNext;
    }

}
