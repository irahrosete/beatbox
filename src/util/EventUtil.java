package util;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

public class EventUtil {
    public static MidiEvent makeEvent (int command, int channel, int dataOne, int dataTwo, int tick) {
        MidiEvent event = null;

        try {
            ShortMessage msg = new ShortMessage();
            msg.setMessage(command, channel, dataOne, dataTwo);
            event = new MidiEvent(msg, tick);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }
}
