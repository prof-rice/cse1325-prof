import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiUnavailableException;

public class Note {
    public Note() {
        this.pitch = null;
    }
    public Note(Pitch pitch, int octave) throws MidiUnavailableException {
        if(octave < -5) octave = -5;
        if(octave >  4) octave =  4;
        this.pitch = pitch;
        this.octave = octave;
        
        if(channel == null) {
            Synthesizer synth = MidiSystem.getSynthesizer();
            synth.open();
            channel = synth.getChannels()[0];
        }
    }
    private static final int milliseconds = 500;
    private static final int volume = 60;
    public void play() throws InterruptedException {
        int note = (pitch == null) ? 0 : pitch.toValue() + octave*12;
        if(pitch != null) channel.noteOn(note, volume);
        Thread.sleep(milliseconds);
        if(pitch != null) channel.noteOff(note);
    }
    private String[] octaves = {"⁻⁵", "⁻⁴", "⁻³", "⁻²", "⁻¹",
                             "", "¹",  "²",  "³",  "⁴",  "⁵"};
    @Override
    public String toString() {
        return (pitch != null) ? pitch.toString() + octaves[octave+5] : " ";
    }
    private Pitch pitch;
    private int octave;
    private static MidiChannel channel;
    
}
