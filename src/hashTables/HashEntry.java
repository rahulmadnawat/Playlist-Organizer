package hashTables;


/**
 * One object of class HashEntry contains data and a state.
 * @param <E>   Type of the data.
 *
 * @author Foothill College, Bita M, Rahul Madnawat
 */
public class HashEntry<E> {
    public E data;
    public int state;

    /**
     * Constructor which is used to create a HashEntry object when given data and a state.
     * @param x The data to be entered into a HashEntry object.
     * @param st    A number associated with a state.
     */
    public HashEntry(E x, int st) {
        data = x;
        state = st;
    }

    /**
     * Constructor which is used to create a HashEntry object when data and a state are not given.
     */
    public HashEntry() { this(null, FHhashQP.EMPTY); }
}