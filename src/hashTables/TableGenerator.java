package hashTables;

import cs1c.SongEntry;

import java.util.ArrayList;


/**
 * One object of class TableGenerator stores a hash table which contains SongCompInt objects, a hash table which
 * contains SongsCompGenre objects, and an ArrayList containing genre names. A TableGenerator object can populate these
 * hash tables and add genres to the list of genre names.
 *
 * @author Foothill College, Bita M, Rahul Madnawat
 */
public class TableGenerator {
    private FHhashQPwFind<Integer, SongCompInt> tableOfSongIDs = new FHhashQPwFind<>();
    private FHhashQPwFind<String, SongsCompGenre> tableOfSongGenres = new FHhashQPwFind<>();
    private ArrayList<String> genreNames = new ArrayList<>();

    /**
     * Populates a hash table which contains SongCompInt objects.
     * @param allSongs  An array containing every SongEntry object.
     * @return the hash table which contains SongCompInt objects
     */
    public FHhashQPwFind<Integer, SongCompInt> populateIDtable(SongEntry[] allSongs) {
        for (int index = 0; index < allSongs.length; index++) {
            tableOfSongIDs.insert(new SongCompInt(allSongs[index]));
        }
        return tableOfSongIDs;
    }

    /**
     * Populates a hash table which contains SongsCompGenre objects.
     * @param allSongs  An array containing every SongEntry object.
     * @return the hash tables which contains SongsCompGenre objects
     */
    public FHhashQPwFind<String, SongsCompGenre> populateGenreTable(SongEntry[] allSongs) {
        for (int index = 0; index < allSongs.length; index++) {
            if (!genreNames.contains(allSongs[index].getGenre())) {
                genreNames.add(allSongs[index].getGenre());
                tableOfSongGenres.insert(new SongsCompGenre(allSongs[index]));
            }
            else { tableOfSongGenres.find(allSongs[index].getGenre()).addSong(allSongs[index]); }
        }
        return tableOfSongGenres;
    }

    /**
     * Accesses the list of genre names of a TableGenerator object.
     * @return the list of genre names of a TableGenerator object
     */
    public ArrayList<String> getGenreNames() { return genreNames; }
}
