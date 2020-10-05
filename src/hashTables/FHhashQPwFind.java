package hashTables;

import java.util.NoSuchElementException;


/**
 * One object of class FHhashQPwFind contains a hash table which utilizes quadratic probing in order to resolve
 * collisions. Data can be searched for using a field value of the data to be found.
 * @param <KeyType> Type of the key.
 * @param <E>   Type of the data in each HashEntry object.
 *
 * @author Foothill College, Bita M, Rahul Madnawat
 */
public class FHhashQPwFind<KeyType, E extends Comparable<KeyType>> extends FHhashQP<E> {
    /**
     * Finds data using a field value of the data to be found.
     * @param key   A field value of the data to be found.
     * @return the data found using a field value of the data to be found
     * @throws NoSuchElementException indicates that an element does not exist
     */
    public E find(KeyType key) throws NoSuchElementException {
        if (mArray[findPosKey(key)].data == null) { throw new NoSuchElementException(); }
        return mArray[findPosKey(key)].data;
    }

    /**
     * Generates a hash code for a key.
     * @param key   A field value of data in a hash table which utilizes quadratic probing in order to resolve
     *              collisions.
     * @return the hash code for the key
     */
    protected int myHashKey(KeyType key) {
        int hashVal;

        hashVal = key.hashCode() % mTableSize;
        if (hashVal < 0) { hashVal += mTableSize; }

        return hashVal;
    }

    /**
     * Finds a position for data in a hash table which utilizes quadratic probing in order to resolve collisions when
     * given a key.
     * @param key   A field value of data in the hash table.
     * @return an index in the hash table associated with the position for the data
     */
    protected int findPosKey(KeyType key) {
        int kthOddNum = 1;
        int index = myHashKey(key);

        while (mArray[index].state != EMPTY && mArray[index].data.compareTo(key) != 0) {
            index += kthOddNum;
            kthOddNum += 2;
            if (index >= mTableSize) { index -= mTableSize; }
        }
        return index;
    }
}