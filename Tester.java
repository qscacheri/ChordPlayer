//import java.util.Arrays;

import java.io.*;
import java.io.IOException;


public class Tester {
    //did it work?
    public static void main(String[] args) throws IOException{
        System.out.println("hello world");
//		int [][] fretBoard=new int [5][3];
        Dim G2 = new Dim("G", "b7");
        Maj C = new Maj("C", "7");
        //G2.getNoteNums();
        //Maj7 C=new Maj7("C", "#11b13")
        G2.getNoteNums();
        Maj[] chordList = new Maj[2];
        chordList[0] = C;

        Fretboard(chordList, 1);
    }

    //	{ 0 , 1 , 0 , 0 }
    //	{ 0 , 0 , 1 , 0 }
    //	{ 0 , 1 , 0 , 0 }
    //	{ 0 , 1 , 0 , 1 }

    public static void Fretboard(Maj[] c, int n)  throws IOException {
        int[][] fretBoard = new int[6][4];
        int[][] yesFret = new int[6][4];

        fretBoard[5][0] = 12;
        fretBoard[5][1] = 1;
        fretBoard[5][2] = 2;
        fretBoard[5][3] = 3;

        fretBoard[4][0] = 5;
        fretBoard[4][1] = 6;
        fretBoard[4][2] = 7;
        fretBoard[4][3] = 8;

        fretBoard[3][0] = 10;
        fretBoard[3][1] = 11;
        fretBoard[3][2] = 12;
        fretBoard[3][3] = 1;

        fretBoard[2][0] = 3;
        fretBoard[2][1] = 4;
        fretBoard[2][2] = 5;
        fretBoard[2][3] = 6;

        fretBoard[1][0] = 7;
        fretBoard[1][1] = 8;
        fretBoard[1][2] = 9;
        fretBoard[1][3] = 10;

        fretBoard[0][0] = 12;
        fretBoard[0][1] = 1;
        fretBoard[0][2] = 2;
        fretBoard[0][3] = 3;

        //Maj [] chordList= new Maj[n];
        System.out.println(yesFret[5][3]);
        for (int chord = 0; chord < n; chord++) {
            System.out.println(c[chord].toString());
            for (int note = 0; note < 4; note++) {
                System.out.println(c[chord].getNoteInArray(note) + "note");
                for (int string = 0; string < 6; string++) {
                    for (int fret = 0; fret < 4; fret++) {
                        if (fretBoard[string][fret] == c[chord].getNoteInArray(note)) {
                            yesFret[string][fret] = 1;
                            break;
                        }
                    }
                }
            }
        }
        String finalYesFret="";
        File tmpFile = File.createTempFile("chordArray", ".tmp");
        System.out.println("Temp file : " + tmpFile.getAbsolutePath());
        FileWriter writer = new FileWriter(tmpFile);
        //Print Statement
        //System.out.println(yesFret[5][3]);
        for (int k = 0; k < 6; k++) {
            System.out.print("\n{");
            finalYesFret+="\n{";
            System.out.print(" ");
            finalYesFret+=" ";
            for (int b = 0; b < 4; b++) {

                System.out.print(yesFret[k][b]);
                finalYesFret+=(yesFret[k][b]);
                System.out.print(" , ");
                finalYesFret+= " , ";
            }
            System.out.println("}");
            finalYesFret+="}";
            writer.write(finalYesFret);

        }

        String str;
        BufferedReader br = new BufferedReader(new FileReader(tmpFile));
        System.out.println("suck dick");
        writer.write("This is the temporary file content\n");
        writer.close();
        while((str = br.readLine()) != null) {
            System.out.println(str);
        }
        br.close();

    }


}

