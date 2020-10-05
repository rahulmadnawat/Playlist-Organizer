package hashTables;


/**
 * One object of class FHhashQP contains a hash table which utilizes quadratic probing in order to resolve collisions.
 * @param <E>   Type of the data in each HashEntry object.
 *
 * @author Foothill College, Bita M, Rahul Madnawat
 */
public class FHhashQP<E> {
    protected static final int ACTIVE = 0;
    protected static final int EMPTY = 1;
    protected static final int DELETED = 2;

    static final int INIT_TABLE_SIZE = 97;
    static final double INIT_MAX_LAMBDA = 0.49;

    protected HashEntry<E>[] mArray;
    protected int mSize;
    protected int mLoadSize;
    protected int mTableSize;
    protected double mMaxLambda;

    /**
     * Constructor which is used to create a hash table which utilizes quadratic probing in order to resolve collisions
     * when given a table size for the hash table.
     * @param tableSize     The number of entries in the hash table.
     */
    public FHhashQP(int tableSize) {
        mLoadSize = mSize = 0;
        if (tableSize < INIT_TABLE_SIZE) { mTableSize = INIT_TABLE_SIZE; }
        else { mTableSize = nextPrime(tableSize); }

        allocateArray();
        mMaxLambda = INIT_MAX_LAMBDA;
    }

    /**
     * Constructor which is used to create a hash table which utilizes quadratic probing in order to resolve collisions
     * when a table size for the hash table is not given.
     */
    public FHhashQP() { this(INIT_TABLE_SIZE); }

    /**
     * Inserts data into a hash table which utilizes quadratic probing in order to resolve collisions.
     * @param x The data to be inserted into the hash table.
     * @return true if the data is successfully inserted into the hash table and false otherwise
     */
    public boolean insert(E x) {
        int bucket = findPos(x);

        if (mArray[bucket].state == ACTIVE) { return false; }

        mArray[bucket].data = x;
        mArray[bucket].state = ACTIVE;
        mSize++;

        if (++mLoadSize > mMaxLambda * mTableSize) { rehash(); }

        return true;
    }

    /**
     * Removes data from a hash table which utilizes quadratic probing in order to resolve collisions.
     * @param x The data to be removed from the hash table.
     * @return true if the data is successfully removed from the hash table and false otherwise
     */
    public boolean remove( E x ) {
        int bucket = findPos(x);

        if (mArray[bucket].state != ACTIVE) { return false; }

        mArray[bucket].state = DELETED;
        mSize--;
        return true;
    }

    /**
     * Checks if a hash table which utilizes quadratic probing in order to resolve collisions contains specific data.
     * @param x The data to be searched for in the hash table.
     * @return  true if the hash table contains the data and false otherwise
     */
    public boolean contains(E x) { return mArray[findPos(x)].state == ACTIVE; }

    /**
     * Returns the instance variable which keeps track of the number of entries marked as active in a hash table which
     * utilizes quadratic probing in order to resolve collisions.
     * @return the number of entries in the hash table which are marked as active
     */
    public int size()  { return mSize; }

    /**
     * Marks all the entries in a hash table which utilizes quadratic probing in order to resolve collisions as empty.
     */
    void makeEmpty() {
        int k, size = mArray.length;

        for(k = 0; k < size; k++) { mArray[k].state = EMPTY; }
        mSize = mLoadSize = 0;
    }

    /**
     * Sets the load factor of a hash table which utilizes quadratic probing in order to resolve collisions.
     * @param lam   The double to be set as the load factor of the hash table.
     * @return true if the load factor of the hash table is successfully set and false otherwise
     */
    public boolean setMaxLambda(double lam) {
        if (lam < .1 || lam > INIT_MAX_LAMBDA ) { return false; }
        mMaxLambda = lam;
        return true;
    }

    /**
     * Finds a position for data in a hash table which utilizes quadratic probing in order to resolve collisions.
     * @param x The data for which a position is to be found in the hash table.
     * @return an index in the hash table associated with the position for the data
     */
    int findPos(E x) {
        int kthOddNum = 1;
        int index = myHash(x);

        while (mArray[index].state != EMPTY && !mArray[index].data.equals(x)) {
            index += kthOddNum;
            kthOddNum += 2;
            if (index >= mTableSize) { index -= mTableSize; }
        }
        return index;
    }

    /**
     * Creates a new hash table which utilizes quadratic probing in order to resolve collisions. The new hash table has
     * at least double the table size of the old hash table.
     */
    protected void rehash() {
        HashEntry<E>[] oldArray = mArray;
        int k, oldTableSize = mTableSize;;

        mTableSize = nextPrime(2*oldTableSize);

        allocateArray();

        mSize = mLoadSize = 0;
        for(k = 0; k < oldTableSize; k++) {
            if (oldArray[k].state == ACTIVE) { insert(oldArray[k].data); }
        }
    }

    /**
     * Generates a hash code for specific data.
     * @param x The data for which a hash code is to be generated.
     * @return the hash code for the data
     */
    protected int myHash(E x) {
        int hashVal;

        hashVal = x.hashCode() % mTableSize;
        if (hashVal < 0) { hashVal += mTableSize; }

        return hashVal;
    }

    /**
     * Finds the next prime number for a given number.
     * @param n The number for which the next prime number is to be found.
     * @return the next prime number
     */
    protected static int nextPrime(int n) {
        int k, candidate, loopLim;

        if (n <= 2) { return 2; }
        else if (n == 3) { return 3; }

        for (candidate = (n % 2 == 0) ? n + 1 : n; true; candidate += 2) {
            loopLim = (int) ((Math.sqrt((double)candidate) + 1)/6);

            if (candidate % 3 == 0) { continue; }

            for (k = 1; k <= loopLim; k++) {
                if (candidate % (6 * k - 1) == 0) { break; }
                if (candidate % (6 * k + 1) == 0) { break; }
            }
            if (k > loopLim) { return candidate; }
        }
    }

    /**
     * Allocates a new array of HashEntry objects for a hash table which utilizes quadratic probing in order to resolve
     * collisions.
     */
    void allocateArray() {
        int k;

        mArray = new HashEntry[mTableSize];
        for (k = 0; k < mTableSize; k++) { mArray[k] = new HashEntry<E>(); }
    }
}