import java.lang.reflect.Array;
import java.util.*;

/**
 * Class BagList: A linked implementation of the BagInterface interface.
 * 
 * @author hnv@ucn.dk - fen@ucn.dk - knol@ucn.dk
 * @version 2016.11.13, 2017.11.16
 * 
 * 
 */
public class LinkedBag<T> implements BagInterface<T> {
    private Node head;
    private int nItems;
    private Node.X x = new Node(null).new X();

    private class Node { // made constructor private - no need to expose Node
       
        private class X {}
        private T data;
        private Node next;

        private Node(T newData) {
            this(newData, null);
        } 

        private Node(T newData, Node nextNode) {
            data = newData;
            next = nextNode;
        }

        public void setData(T newData) {
            data = newData;
        } 

        public T getData() {
            return data;
        } 

        public void setNextNode(Node nextNode) {
            next = nextNode;
        } 

        public Node getNextNode() {
            return next;
        } 
    } 

    /**
     * Constructor for objects of class BagList Implement necessary
     * initialization!
     */
    public LinkedBag() {
        head = null;
        nItems = 0;
    }

    public int getCurrentSize() {
        return nItems;
    }

    public boolean isEmpty() {
        return nItems == 0; // simplified
    }

    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);
        newNode.setNextNode(head);
        head = newNode;
        nItems++;
        return true;
    }

    public T remove() {
        T theData = head.getData();
        head = head.getNextNode();
        nItems--;
        return theData;
    }

    /**
     * Rewritten, knol
     */
    public boolean remove(T e) {
        Node currNode = head;
        Node prevNode = null;
        boolean done = false;
        while(currNode != null && !done) {
            if(currNode.getData().equals(e)) {
                done = true; // do the housekeeping befaure actually removing the node 
                this.nItems--; // just so we don't forget...
                if(prevNode == null) { // head
                    head = head.getNextNode();
                }
                else { // not head node had the data
                    prevNode.setNextNode(currNode.getNextNode());
                }
            }
            else { // we didn't find the data this time
                prevNode = currNode;
                currNode = currNode.getNextNode();
            }
        }
        return done;
    }

    /**
     * FIXME - review implementation
     * @param anEntry
     * @return
     */
    public boolean remove1(T anEntry) {
        T theData = null;
        Node tmpNode = head;
        boolean found = false;
        int index = 0;
        while ((tmpNode != null) && (!found)) {
            theData = tmpNode.getData();
            if (theData.equals(anEntry)) {
                found = true;
            } else {
                tmpNode = tmpNode.getNextNode();
                index++;
            }
        }

        if (found) {
            if (index == 0) {
                head = head.getNextNode();
            } else {
                tmpNode = head;
                int newIndex = 0;
                while ((tmpNode != null) && (newIndex < index)) {
                    newIndex++;
                    tmpNode = tmpNode.getNextNode();
                }
                tmpNode.setNextNode((tmpNode.getNextNode()).getNextNode());
            }
        }

        return found;
    }

    public void clear() {
        head = null;
        nItems = 0;
    }

    public int getFrequencyOf(T anEntry) {
        int nExist = 0;
        T theData = null;
        Node tmpNode = head;
        while (tmpNode != null) {
            theData = tmpNode.getData();
            if (theData.equals(anEntry)) {
                nExist++;
            }
            tmpNode = tmpNode.getNextNode();
        }
        return nExist;
    }

    public boolean contains(T anEntry) {
        boolean found = false;
        T theData = null;
        Node tmpNode = head;
        while ((tmpNode != null) && (!found)) {
            theData = tmpNode.getData();
            if (theData.equals(anEntry)) {
                found = true;
            } else {
                tmpNode = tmpNode.getNextNode();
            }
        }
        return found;
    }

    /**
     * Rewritten 2017, knol
     */
    @SuppressWarnings("unchecked")
	public T[] toArray() {
    	List<T> list = new ArrayList<>();
    	Node currNode = head;
    	for(int i = 0; i < nItems; i++) {
    		list.add(currNode.getData());
    		currNode = currNode.getNextNode();
    	}
    	T[] tt = null;
    	if(list.size() > 0) {
    		tt = (T[])Array.newInstance(list.get(0).getClass(), list.size());
    		tt = list.toArray(tt);
    	}
    	return tt;
    }
}
