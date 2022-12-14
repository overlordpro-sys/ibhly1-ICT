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
    {
      return first.getValue();
    }
  }

  public Object getLast()
  {
    if (last == null)
    {
      throw new NoSuchElementException();
    }
    else
    {
      return last.getValue();
    }
  }


  /**
   *  Inserts the given element at the beginning of this list.
   *
   * @param  value  the element to be inserted at the beginning of this list.
   */
  public void addFirst(Object value)
  {
    // note the order that things happen:
    // head is parameter, then assigned

    // code this
    first = new ListNode(value, first);
  }

  public void addLast(Object value)
  {
    if (first == null)
    {
      first = new ListNode(value);
      last = first;
    }
    else
    {
      last.setNext(new ListNode(value));
      last = last.getNext();
    }

  }
//fix later
  public ListNode find(Object value)
  {
    ListNode node = first;
    while(node != null && !(node.getValue().equals(value)))
    {
      node = node.getNext();
    }
    return node;
  }
  public void insert(Object value)
  {
    Comparable compareVal = (Comparable)value;
    if (first == null)
    {
      first = new ListNode(value);
      last = first;
    }
    else if (compareVal.compareTo(first.getValue()) < 0)
    {
      addFirst(value);
    }
    else if (compareVal.compareTo(last.getValue()) > 0)
    {
      addLast(value);
    }
    else
    {
      ListNode front = first;
      ListNode back = null;
      while (front != null && compareVal.compareTo(front.getValue()) > 0)
      {
        back = front;
        front = front.getNext();
      }
      back.setNext(new ListNode(value, front));
    }
  }
  public boolean remove(Object value)
  {
    if (first == null)
    {
      return false;
    }
    if (first.getValue().equals(value)) {
      first = first.getNext();
      return true;
    }
    ListNode front = first;
    ListNode back = null;
    while(front != null && !front.getValue().equals(value))
    {
      back = front;
      front = front.getNext();
    }
    if (front == null)
    {
      return false;
    }
    back.setNext(front.getNext());
    return true;
  }

  public int size()
  {
    int count = 0;
    ListNode node = first;
    while (node != null)
    {
      count++;
      node = node.getNext();
    }
    return count;
  }

  /**
   *  Returns a string representation of this list. The string
   *  representation consists of the list's elements in order,
   *  enclosed in square brackets ("[]"). Adjacent elements are
   *  separated by the characters ", " (comma and space).
   *
   * @return    string representation of this list
   */
  public void printList()
  {
    String list = "Singly Linked List: ";

    ListNode temp = first;  // start from the first node
    list+= "\n";
    while (temp != null)
    {
      list += temp.getValue(); // append the data
      temp = temp.getNext();      // go to next node
      if (temp != null)
        list += "\n";
    }
    System.out.print(list);
  }

  public void clear()
  {
    first = null;
    last = null;
  }

  public void printBackwards()
  {
    backwards(first);
    System.out.println();
  }

  private void backwards(ListNode node)
  {
    if (node!= null)
    {
      backwards(node.getNext());
      System.out.print(node.getValue() + "\n");
    }
  }

}
