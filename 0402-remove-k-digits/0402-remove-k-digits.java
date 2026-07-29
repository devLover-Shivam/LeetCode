class Solution {

    public String removeKdigits(String num, int k) {

        Stack<Character> st = new Stack<>();

        for (char ch : num.toCharArray()) {

            // Agar current digit chhoti hai
            // aur previous digit badi hai
            // to previous digit hata do
            while (!st.isEmpty() && k > 0 && st.peek() > ch) {
                st.pop();
                k--;
            }

            st.push(ch);
        }

        // Agar abhi bhi k bacha hai
        // to end se remove karo
        while (k > 0) {
            st.pop();
            k--;
        }

        // Stack se string banayenge
        StringBuilder sb = new StringBuilder();

        for (char ch : st) {
            sb.append(ch);
        }

        // Leading zeros remove karo
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        // Agar sab remove ho gaya
        if (sb.length() == 0)
            return "0";

        return sb.toString();
    }
}