import java.io.*;

// See documentation at https://en.wikipedia.org/wiki/ID3#ID3v1

public class MP3Reader implements AutoCloseable {
    public MP3Reader(String filePath) throws FileNotFoundException, IOException {
        mp3 = new RandomAccessFile(filePath, "r");
        length = mp3.length();
        
        // verify MP3 format
        String tag = readString(128, 3);  // Offset and size are straight from the standard
        if(!tag.equals("TAG")) 
            throw new IOException(filePath + " doesn't support ID3v1 (" + tag + ")");
    }
    @Override
    public void close() {
        try {
            mp3.close();  // This releases the resource attribute mp3 when we're done
        } catch(IOException e) {
        }
    }
    
    // Offset from end of file and field sizes are straight from the standard (see link above)
    public String title() throws IOException {return readString(125, 30);}
    public String artist() throws IOException {return readString(95,30);}
    public String album() throws IOException {return readString(65, 30);}
    public String year() throws IOException {return readString(35, 4);}
    public String comment() throws IOException {
        if(hasTrack()) return readString(31,28);
        else return readString(31, 30);
    }
    public boolean hasTrack() throws IOException {return readByte(3) == 0;}
    public int track() throws IOException {return readByte(2);}
    public String genre() throws IOException {
        int index = readByte(1);
        if(index >= genres.length) return "Unknown";
        else return genres[index];
    }
    
    // These two utility methods convert binary fields to String or int, respectively
    protected String readString(int offset, int size) throws IOException {
        mp3.seek(length - offset);
        byte[] bytes = new byte[size];
        mp3.read(bytes);
        return new String(bytes);
    }
    protected int readByte(int offset) throws IOException {
        mp3.seek(length - offset);
        return mp3.read();
    }
    
    // As an application, this reports on any number of MP3 files provided as arguments
    public static void main(String[] args) {
        System.out.println("All About MP3\n=============\n");
        for(String file : args) {
            System.out.println("File " + file);
            try (MP3Reader mp3 = new MP3Reader(file)) {
                System.out.println("  " + mp3.title() + " by " + mp3.artist() + " (" + mp3.year() + ")");
                if(mp3.hasTrack()) System.out.println("  From the album " + mp3.album() + " Track " + mp3.track());
                else System.out.println("  From the album " + mp3.album());
                System.out.println("  " + mp3.genre() + " genre, \"" + mp3.comment() + "\""); 
                System.out.println("\n");
            } catch (Exception e) {
                System.err.println("  Not an ID3v1 MP3\n  " + e.getMessage() + "\n");
             }
        }
    }
     
    // We remember the file object (a resource) and its length   
    private RandomAccessFile mp3;
    private long length;
    
    // This is straight from the standard, and is the meaning of the byte that specifies the genre
    private static final String[] genres = {
        "Blues", "Classic rock", "Country", "Dance", "Disco", "Funk", "Grunge", 
        "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", 
        "Rhythm and Blues", "Rap", "Reggae", "Rock", "Techno", "Industrial", 
        "Alternative", "Ska", "Death metal", "Pranks", "Soundtrack", "Euro-Techno", 
        "Ambient", "Trip-Hop", "Vocal", "Jazz & Funk", "Fusion", "Trance", 
        "Classical", "Instrumental", "Acid", "House", "Game", "Sound clip", 
        "Gospel", "Noise", "Alternative Rock", "Bass", "Soul", "Punk", "Space", 
        "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", 
        "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", 
        "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", 
        "Christian Rap", "Pop/Funk", "Jungle", "Native US", "Cabaret", "New Wave", 
        "Psychedelic", "Rave", "Show tunes", "Trailer", "Lo-Fi", "Tribal", 
        "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock ’n’ Roll", 
        "Hard rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", 
        "Bebop", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", 
        "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", 
        "Slow rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", 
        "Speech", "Chanson", "Opera", "Chamber music", "Sonata", "Symphony", 
        "Booty bass", "Primus", "Porn groove", "Satire", "Slow jam", "Club", 
        "Tango", "Samba", "Folklore", "Ballad", "Power ballad", "Rhythmic Soul", 
        "Freestyle", "Duet", "Punk Rock", "Drum solo", "A cappella", "Euro-House", 
        "Dancehall", "Goa", "Drum & Bass", "Club-House", "Hardcore Techno", "Terror", 
        "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", 
        "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", 
        "Christian rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", 
        "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", 
        "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", 
        "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", 
        "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", 
        "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", 
        "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", 
        "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", 
        "Dubstep", "Garage Rock", "Psybient"};
}
