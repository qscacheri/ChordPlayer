import java.util.Arrays;

import java.io.*;
import java.io.IOException;


public class Tester2 {
    //did it work?
    public static void main(String[] args) throws IOException {
        Maj C = new Maj("C", "7");
        Maj F = new Maj("F", "b7");
        Maj G = new Maj("G", "b7");
        Maj[] chordList = new Maj[3];
        chordList[0] = C;
        chordList[1] = F;
        chordList[2] = G;
        System.out.println(FretBoard.makeFretBoard(chordList, 3));
    }


}


