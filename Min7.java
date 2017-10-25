
public class Min7 extends Min {
    protected char sharp = '#';
    protected char flat = 'b';
    protected char natural = 'n';

    public Min7(String root) {
        super(root);
        NUMNOTES += 1;

    }

    public Min7(String root, String sus) {
        super(root);
        NUMNOTES += findNumOfSus(sus);


    }

    public int findNumOfSus(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == sharp)
                count += 1;

            else if (s.charAt(i) == flat)
                count += 1;

            else if (s.charAt(i) == natural)
                count += 1;

            else
                continue;
        }
        return count;
    }
}
