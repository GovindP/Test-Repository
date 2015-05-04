


public class LongestPalindrum {

    int max(int x, int y) {
        return (x > y) ? x : y;
    }

    int lps(char[] a, int i, int j) {
        if (i == j) //If only 1 letter
        {
            return 1;
        }
        if (a[i] == a[j] && (i + 1) == j) // if there are 2 character and both are equal
        {
            return 2;
        }
        if (a[i] == a[j]) // If first and last char are equal
        {
            return lps(a, i + 1, j - 1) + 2;
        }
        return max(lps(a, i + 1, j), lps(a, i, j - 1));
    }

    public static void main(String[] args) {
        String[] names = new String[]{"Bharti", "Bharat", "Akash", "Bhavya", "Chand", "Brijesh", "Chetak", "Arvind", "Bhavna"};
        String nameString = "";
        for (int i = 0; i < names.length; i++) {
            nameString += names[i].charAt(0);
        }
        LongestPalindrum p = new LongestPalindrum();
        char[] c = nameString.toCharArray();
        System.out.println("Length of longest seq is   " + p.lps(c, 0, c.length - 1));
    }
}
