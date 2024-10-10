import java.util.Set;
import java.util.HashSet;

public class Library {
    private final static String chars = "0123456789" + 
        "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz";
    private final static int filenameLength = 12;

    public void downloadBooks(String[] urls) {
        for(String url : urls) {
            downloadBook(url);
        }
    }
    public Object[] getFilenames() {
        return files.toArray();
    }
    

    private void downloadBook(String url) {
        String filename = download(url);
        files.add(filename);
    }
    private String download(String url) {
        String filename = new String();
        for(int i=0; i<filenameLength; ++i) {
            int index = (int) (Math.random()*chars.length());
            filename += chars.charAt(index);
        }
        return filename + ".pdf";
    }

    private Set<String> files = new HashSet<>();
    
    public static void main(String[] args) {
        Library library = new Library();
        library.downloadBooks(new String[]{
            "https://a.com/book",
            "https://b.com/book",
            "https://c.com/book",
        });
        for(var b : library.getFilenames())
            System.out.println(b);
    }
}
