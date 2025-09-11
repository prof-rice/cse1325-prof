import javax.sound.midi.MidiUnavailableException;

public class Song {
    public static void main(String[] args) 
        throws InterruptedException, MidiUnavailableException {
        Note pause = new Note();
        Note gb = new Note(Pitch.Gb, 0);
        Note g  = new Note(Pitch.G, 0);
        Note a  = new Note(Pitch.A, 0);
        Note b  = new Note(Pitch.B, 0);
        Note d  = new Note(Pitch.D, 1);
        Note[] song = {b, a, g, a, b, b, b, pause,
                       a, a, a, pause,
                       b, d, d, pause,
                       b, a, g, a, b, b, b, b,
                       a, a, g, gb, g, pause
        };
        for(Note note : song) {
            System.out.print(note + " ");
            note.play();
        }
        System.out.println();
    }
}
