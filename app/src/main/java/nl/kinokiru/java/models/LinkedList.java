package nl.kinokiru.java.models;

public class LinkedList<T> {
    private Node<T> headNode = null;

    /**
     * O(N)
     *
     * @param data
     */
    public void add(T data) {
        if (headNode != null) {
            Node<T> currentNode = headNode;
            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(new Node<T>(data));
        } else {
            headNode = new Node<T>(data);
        }
    }

    /**
     * O(N)
     *
     * @param index
     * @return
     */
    public boolean remove(int index) {
        Node<T> currentNode = headNode;
        int i = 0;
        if (currentNode != null && index >= 0) {
            while (currentNode.getNextNode() != null && index > i++) {
                currentNode = currentNode.getNextNode();
            }
            if (currentNode != null && currentNode.getNextNode() != null && index <= i) {
                currentNode.setNextNode(currentNode.getNextNode().getNextNode());
                return true;
            }
        }
        throw new IndexOutOfBoundsException("Hey sletje je index out of bounds, dus zuig een penis");
    }

    /**
     * O(N)
     *
     * @param index
     * @return
     */
    public Node<T> get(int index) {
        Node<T> currentNode = headNode;
        int i = 0;
        if (currentNode != null && index >= 0) {
            while (currentNode.getNextNode() != null && index >= i++) {
                currentNode = currentNode.getNextNode();
            }
            if (currentNode != null && index <= i) {
                return currentNode;
            }
        }
        throw new IndexOutOfBoundsException("Hey sletje je index out of bounds, dus zuig een penis");
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node<T> currentNode = headNode;
        if (currentNode != null) {
            str.append(currentNode.getData() + ", ");
            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
                str.append(currentNode.getData() + ", ");
            }
        }
        return str.substring(0, str.length() - 2).toString();
    }
}
