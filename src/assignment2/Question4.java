package assignment2;

public class Question4 {
    public static String concatStrings(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        char[] result = new char[n1 + n2];

        for (int i = 0; i < n1; i++) {
            result[i] = s1.charAt(i);
        }

        for (int i = 0; i < n2; i++) {
            result[n1 + i] = s2.charAt(i);
        }

        return new String(result);
    }

    public static String reverseString(String s) {
        int n = s.length();
        char[] rev = new char[n];

        for (int i = 0; i < n; i++) {
            rev[i] = s.charAt(n - 1 - i);
        }

        return new String(rev);
    }

    public static String deleteVowels(String s) {
        char[] temp = new char[s.length()];
        int idx = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||
                    c=='A'||c=='E'||c=='I'||c=='O'||c=='U')) {
                continue;
            } else {
                temp[idx] = s.charAt(i);
                idx++;
            }
        }

        return new String(temp, 0, idx);
    }

    public static String sort(String s) {
        char[] a = s.toCharArray();

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[i]) {
                    char temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        return new String(a);  // convert back to string
    }

    public static String toLowerString(String s) {
        char[] result = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                result[i] = (char)(c + 32);
            } else {
                result[i] = c;
            }
        }

        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println("----- (a) Concatenate -----");
        String a1 = "Hello";
        String a2 = "World";
        System.out.println("concatStrings(\"" + a1 + "\", \"" + a2 + "\") -> " + concatStrings(a1, a2));
        System.out.println();

        System.out.println("----- (b) Reverse -----");
        String r = "Maitri";
        System.out.println("reverseString(\"" + r + "\") -> " + reverseString(r));
        System.out.println();

        System.out.println("----- (c) Delete Vowels -----");
        String v = "Beautiful Day";
        System.out.println("deleteVowels(\"" + v + "\") -> \"" + deleteVowels(v) + "\"");
        System.out.println();

        System.out.println("----- (d) Sort Strings -----");
        String s1 = "Apple";
        System.out.println("Before:" + s1);
        System.out.println("After:" + sort(s1));
        System.out.println();

        System.out.println("----- (e) Uppercase to Lowercase -----");
        String s2 = "HELLO WORLD!";
        System.out.println("upperCase(\"" + s2 + "\") -> \"" + toLowerString(s2) + "\"");
        System.out.println();
    }
}
