
/**
 * An interface that describes the operations of a bag of objects
 * 
 * @author HNV 
 * @version 2015.11.01
 */
public interface BagInterface<T>
{

 public int getCurrentSize();
 
 public boolean isEmpty();
 
 public boolean add(T newEntry);
 
 public T remove();
 
 public boolean remove(T anEntry);
 
 public void clear();
 
 public int getFrequencyOf(T anEntry);
 
 public boolean contains(T anEntry);
 
 public T[] toArray();

}
