/**
 *  Implementation of a node of a singly linked list.
 *
 *  Adapted from the College Board's AP Computer Science AB:
 *  Implementation Classes and Interfaces.
 */
public class DListNode
{
    private Object value;
    private DListNode next;
    private DListNode previous;

    /**
     *  Constructs a new element with object initValue,
     *  followed by next element
     *
     * @param  initValue  New element object
     * @param  initNext   Reference to next element
     */
    public DListNode(Object initValue, DListNode initNext, DListNode before)
    {
        value = initValue;
        next = initNext;
        previous = before;
    }
    
        /**
     *  Returns value associated with this element
     *
     * @return    The value associated with this element
     */
    public Object getValue()
    {
        return value;
    }
    
    /**
     *  Returns reference to next value in list
     *
     * @return    The next value in the list
     */
    public DListNode getNext()
    {
        return next;
    }
    
    public DListNode getPrevious()
    {
        return previous;
    }
    
    /**
     *  Sets the value attribute of the ListNode object
     *
     * @param  theNewValue  value attribute of the ListNode object
     */
    public void setValue(Object theNewValue)
    {
        value = theNewValue;
    }

    /**
     *  Sets reference to new next value
     *
     * @param  theNewNext  The new next value
     */
    public void setNext(DListNode theNewNext)
    {
        next = theNewNext;
    }
    
    public void setPrevious(DListNode theNewPrevious)
    {
        previous = theNewPrevious;
    }
}
