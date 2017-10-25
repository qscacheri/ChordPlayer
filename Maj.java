public class Maj extends Chord {
    protected int[] noteArray;
    protected int NUMNOTES = 3;
    protected char sharp = '#';
    protected char flat = 'b';
    protected char natural = 'n';

    public Maj(String root) {
        super(root);
        rootNum = note2Num(root);
        noteArray = new int[NUMNOTES];
        noteArray[0] = rootNum;
        noteArray[1] = findThird(rootNum);
        noteArray[2] = findFifth(rootNum);
    }

    public Maj(String root, String sus) {
        super(root);
        NUMNOTES = findNumOfSus(sus);
        //System.out.println(NUMNOTES+"NUM");
        noteArray = new int[NUMNOTES];
        //System.out.println(NUMNOTES+"NUMNOTES");
        noteArray[0] = rootNum;
        noteArray[1] = findThird(rootNum);
        noteArray[2] = findFifth(rootNum);
        findSusNum(sus);
    }

    public void getNoteNums() {
        for (int i = 0; i < NUMNOTES; i++) {
            System.out.println(noteArray[i]);

        }
    }

    public int[] getNoteArray() {
        return noteArray;
    }

    public int getNoteInArray(int i) {
        return noteArray[i];
    }

    protected int findThird(int root) {
        if (rootNum + 4 > 12) {
            return rootNum - 8;
        } else
            return rootNum + 4;
    }

    protected int findFifth(int root) {
        if (rootNum + 7 > 12) {
            return rootNum - 5;
        } else
            return rootNum + 7;
    }

    public void getNumNotes() {
        System.out.println(NUMNOTES);

    }

    public int getNumNotesInt() {
        return NUMNOTES;
    }

    protected int findNumOfSus(String s) {
        String[] susArray2 = s.split(",");
        //System.out.println(susArray2.length+"sus array");
        return NUMNOTES + susArray2.length;
    }

    public String toString() {
        String s = "";
        return s += root;
    }

    protected void findSusNum(String s) {
        String temp = "";
        int tempNum;
        String[] susArray = s.split(",");

        for (int l = 0; l < susArray.length; l++) {
            tempNum = 0;
            temp = "";
            //System.out.println(susArray[l]+"sus array 2");

            //FLAT

            if (susArray[l].charAt(0) == 'b') {
                //System.out.println(susArray[l].length());
                for (int k = 1; k < susArray[l].length(); k++) {
                    temp += susArray[l].charAt(k);
                    tempNum = Integer.parseInt(temp);
                    //System.out.println(temp+'t');
                }
                //SEVENTH
                if (tempNum == 7) {
                    if (rootNum + 10 > 12) {
                        tempNum = rootNum - 2;

                    } else
                        tempNum = rootNum + 10;
                }

                //NINTH
                else if (tempNum == 9) {
                    if (rootNum + 1 > 12) {
                        tempNum = rootNum - 11;
                    } else
                        tempNum = rootNum + 1;
                }

                //ELEVENTH
                else if (tempNum == 11) {
                    if (rootNum + 4 > 12) {
                        tempNum = rootNum - 8;
                    } else
                        tempNum = rootNum + 4;
                    System.out.println(tempNum + "tempnum");
                }

                //THIRTEENTH
                else if (tempNum == 13) {
                    //System.out.println("im 13");
                    if (rootNum + 8 > 12) {
                        tempNum = rootNum - 4;
                    } else
                        tempNum = rootNum + 8;
                }
                //System.out.println(NUMNOTES+"NUM");
                for (int n = 0; n < NUMNOTES; n++) {

                    if (noteArray[n] == 0) {
                        noteArray[n] = tempNum;
                    }
                }
            } else if (susArray[l].charAt(0) == '#') {
                for (int k = 1; k < susArray[l].length(); k++) {
                    temp += susArray[l].charAt(k);
                    tempNum = Integer.parseInt(temp);
                    //System.out.println(tempNum);
                }
                if (tempNum == 9) {
                    if (rootNum + 3 > 12) {
                        tempNum = rootNum - 9;

                    } else
                        tempNum = rootNum + 3;
                }


                //ELEVENTH
                else if (tempNum == 11) {
                    if (rootNum + 7 > 12) {
                        tempNum = rootNum - 6;
                    } else
                        tempNum = rootNum + 7;
                }

                //THIRTEENTH
                else if (tempNum == 13) {
                    if (rootNum + 10 > 12) {
                        tempNum = rootNum - 2;
                    } else
                        tempNum = rootNum + 10;
                }
                //System.out.println(tempNum+"temp nump");
                for (int n = 0; n < NUMNOTES; n++) {
                    if (noteArray[n] == 0) {
                        noteArray[n] = tempNum;
                    }
                }
            }                        //SHARP

            //NATURAL

            else {
                for (int k = 0; k < susArray[l].length(); k++) {
                    temp += susArray[l].charAt(k);
                    tempNum = Integer.parseInt(temp);
                    //System.out.println(tempNum);
                }


                if (tempNum == 7) {
                    if (rootNum + 10 > 12) {
                        tempNum = rootNum - 1;

                    } else
                        tempNum = rootNum + 11;
                } else if (tempNum == 9) {
                    if (rootNum + 2 > 12) {
                        tempNum = rootNum - 10;

                    } else
                        tempNum = rootNum + 2;
                }


                //ELEVENTH
                else if (tempNum == 11) {
                    if (rootNum + 7 > 12) {
                        tempNum = rootNum - 7;
                    } else
                        tempNum = rootNum + 7;
                }

                //THIRTEENTH
                else if (tempNum == 13) {
                    if (rootNum + 9 > 12) {
                        tempNum = rootNum - 3;
                    } else
                        tempNum = rootNum + 9;
                }


                for (int n = 0; n < NUMNOTES; n++) {
                    if (noteArray[n] == 0) {
                        noteArray[n] = tempNum;

                        break;
                    }
                }
            }//NATURAL
        }

    }
} //LAST ONE