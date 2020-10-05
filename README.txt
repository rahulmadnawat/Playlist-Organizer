Brief description of submitted files:

src/cs1c/MillionSongDataSubset.java
    - One object of class MillionSongDataSubset parses a JSON file and creates an array containing all the JSON
      objects.

src/cs1c/SongEntry.java
    - One object of class SongEntry possesses instance variables which hold the title, duration, artist, and genre of
      a song.

src/cs1c/TimeConverter.java
    - Converts time to a string.

src/hashTables/Benchmarking.java
    - The Benchmarking class compares the access times of a quadratic probing hash table and a sequential find.

src/hashTables/FHhashQP.java
    - One object of class FHhashQP contains a hash table which utilizes quadratic probing in order to resolve
      collisions.

src/hashTables/FHhashQPwFind.java
    - One object of class FHhashQPwFind contains a hash table which utilizes quadratic probing in order to resolve
      collisions.
    - Data can be searched for using a field value of the data to be found.

src/hashTables/HashEntry.java
    - One object of class HashEntry contains data and a state.

src/hashTables/MyTunes.java
    - One object of class MyTunes reads songs from a data file, populates a hash tables which contains SongCompInt
      objects, populates a hash table which contains SongsCompGenre objects, finds SongCompInt objects using ID's, and
      finds SongsCompGenre objects using genre names.

src/hashTables/SongCompInt.java
    - One object of class SongCompInt stores one SongEntry object as an attribute.
    - A SongCompInt object can compare its ID to the ID's of other SongCompInt objects.

src/hashTables/SongsCompGenre.java
    - One object of class SongsCompGenre stores an ArrayList of SongEntry objects and a genre.
    - A SongCompsGenre object can compare its genre to the genres of other SongsCompGenre objects.

src/hashTables/TableGenerator.java
    - One object of class TableGenerator stores a hash table which contains SongCompInt objects, a hash table which
      contains SongsCompGenre objects, and an ArrayList containing genre names.
    - A TableGenerator object can populate these hash tables and add genres to the list of genre names.

resources/findGenres.txt
    - An input file.
    - Each line contains the genre of a SongsCompGenre object to be found in a hash table which contains SongsCompGenre
      objects.

resources/findIDs.txt
    - An input file.
    - Each line contains the ID of a SongsCompInt object to be found in a hash table which contains SongsCompInt
      objects.

resources/graph.txt
    - Contains a link to a graph of the access time of a quadratic probing hash table and the access time of sequential
      find.
    - Includes analysis of the graph.

resources/inputFile01.txt
    - An input file.
    - Each line contains the ID of a SongsCompInt object to be found in a hash table which contains SongsCompInt
      objects.
    - Testing attempt to find an object containing a negative ID.

resources/inputFile02.txt
    - An input file.
    - Each line contains the ID of a SongsCompInt object to be found in a hash table which contains SongsCompInt
      objects.
    - Testing attempt to find objects containing IDs when there is a blank line in the input file.

resources/inputFile03.txt
    - An input file.
    - Each line contains the ID of a SongsCompInt object to be found in a hash table which contains SongsCompInt
      objects.
    - Testing attempt to find an object containing a non-numeric ID.

resources/inputFile04.txt
    - An input file.
    - Each line contains the ID of a SongsCompInt object to be found in a hash table which contains SongsCompInt
      objects.
    - Testing attempt to find an object containing an ID which isn't an integer.

resources/inputFile05.txt
    - An input file.
    - Each line contains the ID of a SongsCompInt object to be found in a hash table which contains SongsCompInt
      objects.
    - Testing attempt to find an object containing an ID which is out of range.

resources/inputFile06.txt
    - An input file.
    - Each line contains the genre of a SongsCompGenre object to be found in a hash table which contains SongsCompGenre
      objects.
    - Testing attempt to find objects containing genres when there is a blank line in the input file.

resources/inputFile07.txt
    - An input file.
    - Each line contains the genre of a SongsCompGenre object to be found in a hash table which contains SongsCompGenre
      objects.
    - Testing attempt to find an object containing a numeric genre.

resources/music_genre_subset.json
    - A JSON file.
    - Contains a list of songs.
    - Each song's genre, artist name, title, duration, and song ID is in the file.

resources/BENCHMARKINGRUN.txt
    - console output of Benchmarking.java

resources/RUN.txt
    - console output of MyTunes.java

README.txt
    - description of submitted files
