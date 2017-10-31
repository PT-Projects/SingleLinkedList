public class SingleLinkedList<E>
{
    private static class Node<E> {
        private E data;
        private Node<E> next;

        /**
         * Construct a node with the given data value and link
         * @param data - The data value
         * @param next - The link
         */
        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head = null;
    private int size = 0;

    // Helper Methods
    /** Insert an item as the first item of the list.
     *	@param item The item to be inserted
     */
    private void addFirst(E item) {
        head = new Node<>(item,null);
        size++;
    }

    /**
     * Find the node at a specified index
     * @param index The index of the node sought
     * @returns The node at index or null if it does not exist
     */
    private Node<E> getNode(int index) {

        if (index >= size){
            throw new IndexOutOfBoundsException("Size: " + size + ", Index: " + index);
        }

        try {
            Node<E> returnVar = head;

            for (int x = 0; x < index; x++) {
                returnVar = returnVar.next;
            }
            return returnVar;
        }
        catch(Exception e){
            throw new IndexOutOfBoundsException("Size: " + size + ", Index: " + index);
        }

    }

    // Public Methods
    /**
     * Get the data value at index
     * @param index The index of the element to return
     * @returns The data at index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public E get(int index) {

        Node<E> returnNode = getNode(index);

        if (returnNode.data == null){
            return null;
        }
        else{
            return returnNode.data;
        }

    }

    /**
     * Set the data value at index
     * @param index The index of the item to change
     * @param newValue The new value
     * @returns The data value previously at index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public E set(int index, E newValue) {

        Node<E> changeNode = getNode(index);

        System.out.println(changeNode.data);

        E oldData = changeNode.data;

        changeNode.data = newValue;

        return oldData;

    }

    /**
     * Insert the specified item at the specified position in the list.
     * Shifts the element currently at that position (if any) and any
     * subsequent elements to the right (adds one to their indicies)
     * @param index Index at which the specified item is to be inserted
     * @param item The item to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void add(int index, E item) {

        if (index == 0 &&  head == null){
            addFirst(item);
        }
        else if (index == 0){
            Node<E> after = getNode(index);
            head = new Node<E>(item,after);
            size++;
        }
        else if (index == size-1){
            getNode(index).next = new Node<>(item,null);
            size++;
        }
        else{
            Node<E> before = getNode(index-1);
            Node<E> after = getNode(index);
            before.next = new Node<E> (item,after);
            size++;
        }

    }

    /**
     * Append the specified item to the end of the list
     * @param item The item to be appended
     * @returns true (as specified by the Collection interface)
     */
    public boolean add(E item) {
        if (head == null){
            addFirst(item);
        }
        else{
            getNode(size-1).next = new Node(item, null);
            size++;
            return true;
        }
        return false;
    }

    /**
     * Query the size of the list
     * @return The number of objects in the list
     */
    int size() {
        return size;
    }
    /**
     * Remove the specified item at the specified position in the list.
     * shifts any subsequent elements to the left (subtracts one from their indicies)
     * returns the data from the deleted index
     * @param index The index of the item to remove
     * @returns The data value previously at index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public E remove(int index) {

        Node<E> removeNode = getNode(index);
        E returnData = removeNode.data;

        if (index == 0){
            head = head.next;
            size--;
        }
        else if(index == size){
            getNode(size).next = null;
        }
        else{
            Node<E> before = getNode(index-1);
            Node<E> after = getNode(index+1);
            before.next = after;
            size--;
        }

        return returnData;

    }

    /**
     * Obtain a string representation of the list
     * @return A String representation of the list
     */
    @Override
    public String toString() {

        String finalString = "[";

        for (int x = 0; x < size; x++){
            if (x == size-1){
                finalString += get(x);
            }
            else{
                finalString += get(x) + ", ";
            }
        }

        finalString += "]";

        return finalString;
    }
}
