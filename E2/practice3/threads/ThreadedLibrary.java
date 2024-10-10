import java.util.Set;
import java.util.HashSet;

public class ThreadedLibrary {
    private final static String chars = "0123456789" + 
        "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz";
    private final static int filenameLength = 12;

    public void downloadBooks(String[] urls) {
        Thread[] threads = new Thread[urls.length];
        for(int i=0; i<threads.length; ++i) {
            final int j = i;
            threads[j] = new Thread(() -> downloadBook(urls[j]));
            // final String url = urls[j];
            // threads[j] = new Thread(() -> downloadBook(url));
            threads[j].start();
        }
        for(int i=0; i<threads.length; ++i) {
            try {
                threads[i].join();
            } catch(InterruptedException e) {
            }
        }
    }
    public Object[] getFilenames() {
        return files.toArray();
    }


    private static Object mutex = new Object();
    private void downloadBook(String url) {
        String filename = download(url);
        synchronized(mutex) {
            files.add(filename);
        }
    }
    private String download(String url) {
        String filename = new String();
        for(int i=0; i<filenameLength; ++i) {
            int index = (int) (Math.random()*chars.length());
            filename += chars.charAt(index);
        }
        return filename + ".pdf";
    }
    
    Set<String> files = new HashSet<>();
    
    public static void main(String[] args) {
        ThreadedLibrary library = new ThreadedLibrary();
        library.downloadBooks(new String[]{
            "https://a.com/book",
            "https://b.com/book",
            "https://c.com/book",
        });
        for(var b : library.getFilenames())
            System.out.println(b);
    }
}
