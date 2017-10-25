
public class Dim extends Min {
    public Dim(String root) {
        super(root);
        noteArray[1] = noteArray[1] - 1;
    }

    public Dim(String root, String sus) {
        super(root);
        NUMNOTES = findNumOfSus(sus);
        noteArray = new int[NUMNOTES];
        noteArray[0] = rootNum;
        noteArray[1] = findThird(rootNum);
        noteArray[1] = noteArray[1] - 1;
        noteArray[2] = findFifth(rootNum);
        noteArray[2] = noteArray[2] - 1;
        findSusNum(sus);
        noteArray[3] -= 1;
    }
}
