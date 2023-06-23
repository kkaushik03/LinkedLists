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
public class DoublyLinkedList
{
    private DListNode first;  // first element
    private DListNode last;
    /**
     *  Constructor for the DoublyLinkedList object
     *  Generates an empty list.
     */
    public DoublyLinkedList()
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
        if(first == null)
        {
            first = new DListNode(value, null, null);
            last = first;
        }
        else
        {
            DListNode temp = new DListNode(value, first, null);
            temp.setNext(first);
            first.setPrevious(temp);
            first = first.getPrevious();
        }
    }

    public void addLast(Object value)
    {
        if(first == null)
        {
            addFirst(value);
        }
        else
        {
            DListNode temp = new DListNode(value, null, last);
            last.setNext(temp);
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
        DListNode temp = first;
        while(temp != null)
        {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    public void printList()
    {
        DListNode temp = first;
        System.out.println("Ordered DoublyLinkedList: ");
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

        DListNode temp = first;  // start from the first node
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
            DListNode front = first;
            DListNode back = front;
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
                back.setNext(new DListNode(toInsert, front, back));
                front.setPrevious(back.getNext());
            }
        }
    }

    public DListNode find(Object toFind)
    {
        DListNode temp = first;
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
        DListNode front = first;
        DListNode back = first;
        while(front != null && delete.compareTo(front.getValue()) != 0)
        {
            back = front;
            front = front.getNext();
        }
        if(front == null)
            return false;

        else if(front == first && front.getNext() != null)
        {
            first = first.getNext();
            first.setPrevious(null);
        }
        else if(front == last && front.getPrevious() != null)
        {
            last = back;
            last.setNext(null);
        }
        else
        {
            if(front != last)
            {
                back.setNext(front.getNext());
                (front.getNext()).setPrevious(back);
            }
            else //last node deletion
            {
                first = front.getNext();
                last = back.getPrevious();
            }
        }
        return true;
    }

    public void clear()
    {
        first = null;
        last = null;
    }

    public void printBackwards()
    {
        System.out.println("Backwards DoublyLinkedList: ");
        DListNode backwards = last;
        int count = 1;
        while(backwards != null)
        {
            Object value = backwards.getValue();
            System.out.printf("%2d", count);
            System.out.printf("%18s", value);
            System.out.println();
            backwards = backwards.getPrevious();
            count++;
        }
    }
}
