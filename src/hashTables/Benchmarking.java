package hashTables;

import cs1c.SongEntry;
import cs1c.TimeConverter;

import java.io.*;
import java.util.*;


/**
 * The Benchmarking class compares the access times of a quadratic probing hash table and a sequential find.
 *
 * @author Foothill College, Bita M, Rahul Madnawat
 */
public class Benchmarking {
    final static int ALL_SONGS_SIZE = 59600;

    /**
     * Reads a file and stores its data in a list.
     * @param filename	The file name.
     * @return list containing the data of the file
     */
    public static ArrayList<String> readFindRequests(String filename)
    {
        ArrayList<String> requests = new ArrayList<>();
        Scanner input = null;

        try {
            File infile = new File(filename);
            input = new Scanner(infile);

            String line = "";
            while (input.hasNextLine()) {
                line = input.nextLine();

                requests.add("" + line);
            }
        }
        catch (FileNotFoundException e) { e.printStackTrace(); }
        finally {
            if (input != null) { input.close(); }
        }
        return requests;
    }

    /**
     * Finds the SongEntry object whose title matches a certain song title.
     * @param allSongs  An array containing SongEntry objects.
     * @param fileName The file name.
     */
    private static void findSong(SongEntry[] allSongs, String fileName) {
        ArrayList<String> idsToFind = readFindRequests(fileName);

        for (String id : idsToFind) {
            for (int index = 0; index < allSongs.length; index++) {
                if (allSongs[index].getID() == Integer.parseInt(id)) {
                    System.out.println(allSongs[index]);
                }
            }
        }
    }

    /**
     * Writes five randomly generated numbers into a file.
     * @param fileName  The file name.
     * @param randFirst The first randomly generated number.
     * @param randSecond    The second randomly generated number.
     * @param randThird The third randomly generated number.
     * @param randFourth    The fourth randomly generated number.
     * @param randFifth The fifth randomly generated number.
     */
    private static void writeFile(String fileName, int randFirst, int randSecond, int randThird, int randFourth,
                                  int randFifth) {
       try {
            FileWriter fileWriter = new FileWriter(fileName);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(randFirst);
            printWriter.println(randSecond);
            printWriter.println(randThird);
            printWriter.println(randFourth);
            printWriter.println(randFifth);
            printWriter.close();
        }
        catch (IOException e) { e.printStackTrace(); }
    }

    public static void main(String[] args) {
        final String DATAFILE = "resources/music_genre_subset.json";
        final String TESTFILE = "inputFile08.txt";
        final int INDEX_INCREMENT = 1000;
        final int SAMPLE_SIZE = 5;

        SongEntry[] allSongs = MyTunes.readSongsFromDataFile(DATAFILE);

        Random rand = new Random();
        int randFirst = rand.nextInt(INDEX_INCREMENT);
        int randSecond = rand.nextInt(INDEX_INCREMENT);
        int randThird = rand.nextInt(INDEX_INCREMENT);
        int randFourth = rand.nextInt(INDEX_INCREMENT);
        int randFifth = rand.nextInt(INDEX_INCREMENT);

        writeFile(TESTFILE, randFirst, randSecond, randThird, randFourth, randFifth);

        for (int index = INDEX_INCREMENT; index < ALL_SONGS_SIZE; index += INDEX_INCREMENT) {
            SongEntry[] songs = Arrays.copyOfRange(allSongs, 0, index);

            System.out.println("\nN: " + index + "\n");
            System.out.println("Quadratic probing hash table access time: \n");

            MyTunes theStore = new MyTunes(songs);

            long startTime, estimatedTime;

            startTime = System.nanoTime();

            theStore.testIDtable(TESTFILE);

            estimatedTime = (System.nanoTime() - startTime) / SAMPLE_SIZE;

            System.out.println("\nAlgorithm Elapsed Time: " + TimeConverter.convertTimeToString(estimatedTime) + "\n");

            System.out.println("Sequential find access time: \n");

            startTime = System.nanoTime();

            findSong(songs, TESTFILE);

            estimatedTime = (System.nanoTime() - startTime) / SAMPLE_SIZE;

            System.out.println("\nAlgorithm Elapsed Time: " + TimeConverter.convertTimeToString(estimatedTime) + "\n");

            randFirst = rand.nextInt(index);
            randSecond = rand.nextInt(index);
            randThird = rand.nextInt(index);
            randFourth = rand.nextInt(index);
            randFifth = rand.nextInt(index);

            writeFile(TESTFILE, randFirst, randSecond, randThird, randFourth, randFifth);
        }
    }
}
