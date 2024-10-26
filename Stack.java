/**
 * This program is a Generic Stack with implementation of Linked List.
 *
 * @author Jiayue Yang
 * @version 1.0
 */
public class Stack<E> {

    private Node<E> top;//Hold the top of the list

    /**
     * Constructor.
     */
    public Stack(){
        top = null;
    }

    /**
     * The push function pushes a new number to the top of a list.
     *
     * @param val number to be stored in list
     */
    public void push(E val){
        Node<E> newNode = new Node<>(val);
        if(top == null){
            top = newNode;
        }
        else {
            newNode.next = top;
            top = newNode;
        }
    }

    /**
     * The pop function returns and removes a number from the top of list.
     *
     * @return the double at top
     */
    public E pop(){
        if(top == null){
            throw new IllegalArgumentException("No value found!");
        }
        else {
            E val = top.val;
            top = top.next;
            return val;
        }
    }

    /**
     * The hasDuplicate function determine if there's a same value in the stack
     * already.
     *
     * @param key the value to be searched
     * @return true if there is at least one duplicate, false if there's no
     * duplicate.
     */
    public boolean hasDuplicate(E key){
        Node<E> temp = top;
        while(temp != null){
            if(temp.val.equals(key))
                return true;
            temp = temp.next;
        }
        return false;
    }

    /**
     * The isEmpty function determine if the list is empty
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty(){
        return top == null;
    }

    /**
     * The peek function returns the value on the top of the list. Prints an
     * error message if the list is empty.
     *
     * @return value of the top Node
     */
    public E peek(){
        if(this.isEmpty())
            throw new IllegalArgumentException("No value found!");
        return top.val;
    }

    /**
     * The size function returns the size of the list.
     *
     * @return an integer of the size of the list.
     */
    public int size(){
        int size = 0;
        Node<E> temp = top;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        return size;
    }

    /**
     * toString Method that returns the content of Stack.
     *
     * @return A String of the content of Stack with a space in between each
     * element
     */
    public String toString(){
        StringBuilder str = new StringBuilder();
        Node temp = top;
        while(temp != null){
            str.append(temp.val).append(" ");
            temp = temp.next;
        }
        return str.toString();
    }
}
