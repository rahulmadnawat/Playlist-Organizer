package hashTables;

import cs1c.SongEntry;


/**
 * One object of class SongCompInt stores one SongEntry object as an attribute. A SongCompInt object can compare its ID
 * to the ID's of other SongCompInt objects.
 *
 * @author Foothill College, Bita M, Rahul Madnawat
 */
public class SongCompInt implements Comparable<Integer> {
    private SongEntry data;

    /**
     * Constructor which is used to create a SongCompInt object when given a SongEntry object.
     * @param e A SongEntry object.
     */
    public SongCompInt(SongEntry e) { data = e; }

    /**
     * Compares the ID of a SongCompInt object with another ID.
     * @param key   An ID.
     * @return the difference between the ID of the SongCompInt object and the other ID
     */
    public int compareTo(Integer key) { return data.getID() - key; }

    /**
     * Determines if two SongCompInt objects are equal.
     * @param other A SongCompInt object.
     * @return true if the two SongCompInt objects are equal and false otherwise
     */
    public boolean equals(SongCompInt other) { return data.equals(other.data); }

    /**
     * Generates a hash code for a SongCompInt object.
     * @return the ID of a SongCompInt object
     */
    public int hashCode() { return data.getID(); }

    /**
     * Creates a string representation of a SongCompInt object.
     * @return a string representation of a SongCompInt object
     */
    public String toString() { return "Song: " + data.toString(); }
}
