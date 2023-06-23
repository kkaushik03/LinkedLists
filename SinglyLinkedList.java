import java.util.*;

/**
 *  Implementation of lists, using singly linked elements.
 *
 * @author     G. Peck
 * @created    April 27, 2002
 *
 * Modified by Jason Quesenberry and Nancy Quesenberry
 * February 9,2006
 */
public class SinglyLinkedList
{
    private ListNode first;  // first element
    private ListNode last;
    /**
     *  Constructor for the SinglyLinkedList object
     *  Generates an empty list.
     */
    public SinglyLinkedList()
    {
        first = null;
        last = null;
    }

    /**
     *  Returns the first element in this list.
     *
     * @return  the first element in the linked list.
     */
    public Object getFirst()
    {
        if (first == null)
        {
            throw new NoSuchElementException();
        }
        else
            return first.getValue();
    }  

    /**
     *  Inserts the given element at the beginning of this list.
     *
     * @param  value  the element to be inserted at the beginning of this list.
     */
    public void addFirst(Object value)
    {
        first = new ListNode(value, first);
        if(last == null)
            last = first;
    }

    public void addLast(Object value)
    {
        ListNode toAdd = new ListNode(value);
        if(first == null)
            addFirst(value);
        else
        {
            last.setNext(toAdd);
            last = last.getNext();
        }
    }

    public Object getLast()
    {
        if (last == null)
        {
            throw new NoSuchElementException();
        }
        else
            return last.getValue();
    }

    public int size()
    {
        int count = 0;
        ListNode temp = first;
        while(temp != null)
        {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    // /**
    // *  Print the contents of the entire linked list
    // */
    // public void printList() //for SinglyLinkedList
    // {
    // ListNode temp = first;
    // System.out.println("SinglyLinkedList: ");
    // while(temp != null)
    // {
    // Object value = temp.getValue();
    // System.out.print(value + " ");
    // temp = temp.getNext();
    // }
    // }

    public void printList() //for orderedList
    {
        ListNode temp = first;
        System.out.println("SinglyLinkedList: ");
        int count = 1;
        while(temp != null)
        {
            Object value = temp.getValue();
            System.out.printf("%2d", count);
            System.out.printf("%18s", value);
            System.out.println();
            temp = temp.getNext();
            count++;
        }
    }

    /**
     *  Returns a string representation of this list. The string
     *  representation consists of the list's elements in order,
     *  enclosed in square brackets ("[]"). Adjacent elements are
     *  separated by the characters ", " (comma and space).
     *
     * @return    string representation of this list
     */
    public String toString()
    {
        String s = "[";

        ListNode temp = first;  // start from the first node
        while (temp != null)
        {
            s += temp.getValue(); // append the data
            temp = temp.getNext();      // go to next node
            if (temp != null)
                s += ", ";
        }
        s += "]";
        return s;
    }  

    public void insert(Object toInsert)
    {
        Item toAdd = (Item)(toInsert);
        if(first == null)
            addFirst(toInsert);
        else
        {
            ListNode front = first;
            ListNode back = front;
            while(front != null && toAdd.compareTo(front.getValue()) > 0)
            {
                back = front;
                front = front.getNext();
            }
            if(first == front)
                addFirst(toInsert);
            else if(back == last)
                addLast(toInsert);
            else
            {
                ListNode add = new ListNode(toInsert, front);
                back.setNext(add);
            }
        }
    }

    public ListNode find(Object toFind)
    {
        ListNode temp = first;
        Item toCheck = (Item)(toFind);
        while(temp != null)
        {
            Item current = (Item)(temp.getValue());
            if(current.equals(toCheck))
                return temp;
            temp = temp.getNext();
        }
        return null;
    }

    public boolean remove(Object toDelete)
    {
        Item delete = (Item)(toDelete);
        ListNode front = first;
        ListNode back = first;
        while(front != null && delete.compareTo(front.getValue()) != 0)
        {
            back = front;
            front = front.getNext();
        }
        if(front == null)
            return false;
        else if(front == first)
            first = first.getNext();
        else if(front == last)
            last = back;
        back.setNext(front.getNext());
        return true;
    }

    public void clear()
    {
        first = null;
        last = null;
    }

    public void printBackwards()
    {
        System.out.println("Backwards SinglyLinkedList: ");
        getPrevious(first, size());
    }

    private void getPrevious(ListNode node, int length)
    {
        ListNode current = node;
        if(current != null && current.getNext() != null)
        {
            getPrevious(current.getNext(), length - 1);
        }
        if(current != null)
        {
            System.out.printf("%2d", length);
            System.out.printf("%17s", current.getValue());
            System.out.println();
        }
    }
}
