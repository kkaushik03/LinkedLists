import java.util.*;

public class CircularlyLinkedList
{
    private DListNode first;  // first element
    private DListNode last;  // last element
    /**
     *  Constructor for the DoublyLinkedList object
     *  Generates an empty list.
     */
    public CircularlyLinkedList()
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

    public DListNode getFirstNode()
    {
        return first;
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
            first.setNext(first);
            first.setPrevious(first);
            last = first;
        }
        else
        {
            DListNode temp = new DListNode(value, first, last);
            first.setPrevious(temp);
            last.setNext(temp);
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
            last = new DListNode(value, first, last);
            first.setPrevious(last);
            DListNode temp = last.getPrevious();
            temp.setNext(last);
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

    public DListNode getLastNode()
    {
        return last;
    }

    public int size()
    {
        if(first != null)
        {
            int count = 0;
            DListNode temp = first;
            do
            {
                count++;
                temp = temp.getNext();
            }while(temp != first);
            return count;
        }
        return 0;
    }

    public void printList()
    {
        System.out.println("CircularlyLinkedList: ");
        if(first != null)
        {
            DListNode temp = first;
            int count = 1;
            do
            {
                Object value = temp.getValue();
                System.out.printf("%2d", count);
                System.out.printf("%18s", value);
                System.out.println();
                temp = temp.getNext();
                count++;
            }while(temp != first);
            System.out.println();
        }
    }

    public String toString()
    {
        if(first == null)
            return "[]";
        else
        {
            String s = "[";

            DListNode temp = first;  // start from the first node
            do
            {
                s += temp.getValue(); // append the data
                temp = temp.getNext();      // go to next node
                if (temp != null && temp.getNext() != first)
                    s += ", ";
            }while (temp != first);
            s += "]";
            return s;
        }
    }  

    public void insert(Object toInsert)
    {
        Item toAdd = (Item)(toInsert);
        if(first == null || toAdd.compareTo(first.getValue()) < 0)
            addFirst(toInsert);
        else if(toAdd.compareTo(last.getValue()) > 0)
            addLast(toInsert);
        else
        {
            DListNode front = first;
            DListNode back = front;
            do
            {
                back = front;
                front = front.getNext();
            }while(front != first && toAdd.compareTo(front.getValue()) > 0);
            back.setNext(new DListNode(toInsert, front, back));
            front.setPrevious(back.getNext());
        }
    }

    public DListNode find(Object toFind)
    {
        if(first != null)
        {
            DListNode temp = first;
            Item toCheck = (Item)(toFind);
            do
            {
                Item current = (Item)(temp.getValue());
                if(current.equals(toCheck))
                    return temp;
                temp = temp.getNext();
            }while(temp != first);
            return null;
        }
        return null;
    }

    public boolean remove(Object toDelete)
    {
        if(first == null)
            return false;
        else
        {
            Item delete = (Item)(toDelete);
            DListNode current = first;
            while(!delete.equals((Item) current.getValue()) && current.getNext() != first)
            {
                current = current.getNext();
            }
            if(delete.equals((Item) current.getValue()))
            {
                if(current == first && current == last)
                {
                    clear();
                    return true;
                }
                else if (current == first)
                {
                    first = first.getNext();
                    last.setNext(first);
                    first.setPrevious(last);
                    return true;
                }
                else if(current == last)
                {
                    last = last.getPrevious();
                    last.setNext(first);
                    first.setPrevious(last);
                    return true;
                }
                else
                {
                    DListNode back = current.getPrevious();
                    DListNode front = current.getNext();
                    back.setNext(front);
                    front.setPrevious(back);
                    return true;
                }
            }
            return false;
        }
    }

    public void clear()
    {
        first = null;
        last = null;
    }

    public void printBackwards()
    {
        System.out.println("Backwards CircularlyLinkedList: ");
        if(last != null)
        {
            DListNode backwards = last;
            int count = 1;
            do
            {
                Object value = backwards.getValue();
                System.out.printf("%2d", count);
                System.out.printf("%18s", value);
                System.out.println();
                backwards = backwards.getPrevious();
                count++;
            }while(backwards != last);
        }
        System.out.println();
    }
}