package hashTables;

import cs1c.SongEntry;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * One object of class SongsCompGenre stores an ArrayList of SongEntry objects and a genre. A SongCompsGenre object can
 * compare its genre to the genres of other SongsCompGenre objects.
 *
 * @author Foothill College, Bita M, Rahul Madnawat
 */
public class SongsCompGenre implements Comparable<String> {
    private String name;
    private ArrayList<SongEntry> data = new ArrayList<>();

    /**
     * Constructor which is used to create a SongsCompGenre object when given a SongEntry object.
     * @param e A SongEntry object.
     */
    public SongsCompGenre(SongEntry e) {
        name = e.getGenre();
        data.add(e);
    }

    /**
     * Adds a song to the list of songs.
     * @param e The SongEntry object to be added.
     */
    public void addSong(SongEntry e) { data.add(e); }

    /**
     * Accesses the genre of a SongsCompGenre object.
     * @return the genre of a SongsCompGenre object
     */
    public String getName() { return name; }

    /**
     * Accesses the list of songs of a SongsCompGenre object.
     * @return the list of songs of a SongsCompGenre object
     */
    public ArrayList<SongEntry> getData() { return data; }

    /**
     * Compares the genre of a SongsCompGenre object with another genre.
     * @param key   A genre.
     * @return zero if the genres are equal and any other number if the genres are not equal
     */
    public int compareTo(String key) { return name.compareTo(key); }

    /**
     * Determines if two SongsCompGenre objects are equal.
     * @param other A SongsCompGenre object.
     * @return true if the two SongsCompGenre objects are equal and false otherwise
     */
    public boolean equals(SongsCompGenre other) { return data.equals(other.data); }

    /**
     * Generates a hash code for a SongsCompGenre object.
     * @return the hash code of the genre of the SongsCompGenre object
     */
    public int hashCode() { return name.hashCode(); }

    /**
     * Creates a string representation of a SongsCompGenre object.
     * @return a string representation of a SongsCompGenre object
     */
    public String toString() {
        String songs = "[";
        for (int index = 0; index < data.size(); index++) {
            if (index == data.size() - 1) { songs += data.get(index); }
            else { songs += data.get(index) + ";\n"; }
        }
        songs += "]";
        return "Genre: " + name + "\nSongs: \n" + songs;
    }
}
