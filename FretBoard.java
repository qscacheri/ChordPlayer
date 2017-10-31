import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FretBoard{
    public static String makeFretBoard(Maj[] c, int n) throws IOException {
        int counter = 0;
        int[][] fretBoard = new int[6][4];
        int[][] yesFret = new int[6][4];
        int[][][] chordDiagrams = new int[3][6][4];

        {
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
            //System.out.println(yesFret[5][3]);
            for (int chord = 0; chord < n; chord++) {
                System.out.println("Chord: " + chord);
                zeroArray(yesFret);
                System.out.println(c[chord].toString());
                for (int note = 0; note < 4; note++) {
                    System.out.println("Note: " + note);
                    System.out.println(c[chord].getNoteInArray(note) + " note");
                    for (int string = 0; string < 6; string++) {
                        System.out.println("String: " + string);
                        for (int fret = 0; fret < 4; fret++) {
                            if (fretBoard[string][fret] == c[chord].getNoteInArray(note)) {
                                chordDiagrams[chord][string][fret] = 1;
                                counter++;
                                break;
                            }
                        }

                    }
                }

//                chordDiagrams[counter] = yesFret;
//                counter++;
            }


            //Print Statement
            for (int i = 0; i < 3; i++) {
                for (int k = 0; k < 6; k++) {
                    System.out.print("\n{");
                    System.out.print(" ");
                    for (int b = 0; b < 4; b++) {

                        System.out.print(chordDiagrams[i][k][b]);
                        System.out.print(" , ");
                    }
                    System.out.println("}");
                }
                System.out.print("\n\n\n");
            }
        }

        File tmpFile = File.createTempFile("chordDiagrams1.0", ".txt");
        FileWriter writer = new FileWriter(tmpFile);
        writer.write(java.util.Arrays.deepToString(chordDiagrams));
        writer.close();
        System.out.println("Temp file : " + tmpFile.getAbsolutePath());
        String cDString = java.util.Arrays.deepToString(chordDiagrams);
        cDString = cDString.replace("[", "");
        cDString = cDString.replace("]", "");
        cDString = cDString.replace(" ", "");
        cDString = cDString.replace(",", "");
        return n + "" + cDString;
    }

    public static void zeroArray(int[][] a) {
        for (int i = 0; i < 6; i++) {
            for (int l = 0; l < 4; l++) {
                a[i][l] = 0;
            }

        }
    }
}