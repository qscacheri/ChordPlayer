
public class Chord {
    protected String root;
    protected int rootNum;

    public Chord(String root) {
        this.root = root;
        rootNum = note2Num(root);


    }

    public int note2Num(String note) {
        int noteNum = 0;
        if (note == "A")
            noteNum = 1;
        else if (note == "A#" || note == "Bb")
            noteNum = 2;
        else if (note == "B")
            noteNum = 3;
        else if (note == "C")
            noteNum = 4;
        else if (note == "C#" || note == "Db")
            noteNum = 5;
        else if (note == "D")
            noteNum = 6;
        else if (note == "D#" || note == "Eb")
            noteNum = 7;
        else if (note == "E")
            noteNum = 8;
        else if (note == "F")
            noteNum = 9;
        else if (note == "F#" || note == "Gb")
            noteNum = 10;
        else if (note == "G")
            noteNum = 11;
        else if (note == "G#" || note == "Ab")
            noteNum = 12;
        return noteNum;
    }
}
