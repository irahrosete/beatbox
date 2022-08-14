import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Track;

import static javax.sound.midi.ShortMessage.*;
import static util.EventUtil.makeEvent;

public class MiniMusicPlayer2 {
    public static void main(String[] args) {
        MiniMusicPlayer2 mini = new MiniMusicPlayer2();
        mini.go();
    }

    public void go() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            int[] eventsIWant = {127};
            sequencer.addControllerEventListener(event -> System.out.println("la"), eventsIWant);

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            for (int i = 5; i < 61; i+=4) {
                track.add(makeEvent(NOTE_ON, 1, i, 100, i));
                track.add(makeEvent(CONTROL_CHANGE, 1, 127, 0, i));
                track.add(makeEvent(NOTE_OFF, 1, i, 100, i + 2));
            }

            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
