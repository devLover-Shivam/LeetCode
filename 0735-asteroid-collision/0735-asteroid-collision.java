class Solution{
public int[] asteroidCollision(int[] a) {

    Stack<Integer> st = new Stack<>();

    for (int i = 0; i < a.length; i++) {

        // Positive asteroid kabhi immediately collide nahi karega
        if (a[i] > 0) {
            st.push(a[i]);
        } else {

            // Current negative asteroid jitne chhote positive asteroids hain
            // unhe destroy karta rahega
            while (!st.isEmpty()
                    && st.peek() > 0
                    && st.peek() < -a[i]) {

                st.pop();
            }

            // Equal size -> dono destroy
            if (!st.isEmpty() && st.peek() == -a[i]) {
                st.pop();
            }

            // Stack empty hai ya top already negative hai
            // to current asteroid survive karega
            else if (st.isEmpty() || st.peek() < 0) {
                st.push(a[i]);
            }

            // Agar top positive aur bada hai
            // (st.peek() > -a[i])
            // to current asteroid destroy ho jayega.
            // Is case me kuch nahi karna.
        }
    }

    int[] ans = new int[st.size()];

    for (int i = 0; i < st.size(); i++) {
        ans[i] = st.get(i);
    }

    return ans;
}
}
