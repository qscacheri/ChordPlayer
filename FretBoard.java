import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FretBoard{
    public static String makeFretBoard(Maj[] c, int n) throws IOException {
        int counter = 0;
        int[][] fretBoard = new int[6][5];
        int[][] yesFret = new int[6][5];
        int[][][] chordDiagrams = new int[3][6][5];

        {
            fretBoard[5][0] = 11;
            fretBoard[5][1] = 12;
            fretBoard[5][2] = 1;
            fretBoard[5][3] = 2;
            fretBoard[5][4] = 3;

            fretBoard[4][0] = 4;
            fretBoard[4][1] = 5;
            fretBoard[4][2] = 6;
            fretBoard[4][3] = 7;
            fretBoard[4][4] = 8;

            fretBoard[3][0] = 9;
            fretBoard[3][1] = 10;
            fretBoard[3][2] = 11;
            fretBoard[3][3] = 12;
            fretBoard[3][4] = 1;

            fretBoard[2][0] = 2;
            fretBoard[2][1] = 3;
            fretBoard[2][2] = 4;
            fretBoard[2][3] = 5;
            fretBoard[2][4] = 6;

            fretBoard[1][0] = 6;
            fretBoard[1][1] = 7;
            fretBoard[1][2] = 8;
            fretBoard[1][3] = 9;
            fretBoard[1][4] = 10;

            fretBoard[0][0] = 11;
            fretBoard[0][1] = 12;
            fretBoard[0][2] = 1;
            fretBoard[0][3] = 2;
            fretBoard[0][4] = 3;

            //Maj [] chordList= new Maj[n];
            //System.out.println(yesFret[5][3]);
            for (int chord = 0; chord < n; chord++) {
                zeroArray(yesFret);
                System.out.println(c[chord].toString());
                for (int note = 0; note < c[chord].getNumNotesInt(); note++) {
                    System.out.println(c[chord].getNoteInArray(note) + " note");
                    for (int string = 0; string < 6; string++) {
                        //System.out.println("String: " + string);
                        for (int fret = 0; fret < 5; fret++) {
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
                    for (int b = 0; b < 5; b++) {

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