# Balanced Parentheses

## Problem Statement

Given a string `s` containing only the characters:

- `(` and `)`
- `{` and `}`
- `[` and `]`

Determine whether the input string is **balanced**.

A string is considered balanced if:

1. Every opening bracket has a corresponding closing bracket of the same type.
2. Every closing bracket has a corresponding opening bracket.
3. Brackets are closed in the correct order (LIFO order).

---

## Examples

### Example 1

Input:

```text
()
```

Output:

```text
true
```

Explanation:

- `(` is opened.
- `)` closes the most recent opening bracket.
- All brackets are matched.

---

### Example 2

Input:

```text
()[]{}
```

Output:

```text
true
```

Explanation:

Every opening bracket has a matching closing bracket.

---

### Example 3

Input:

```text
([{}])
```

Output:

```text
true
```

Explanation:

Nested brackets are closed in the exact reverse order of opening.

---

### Example 4

Input:

```text
(]
```

Output:

```text
false
```

Explanation:

`(` should be closed by `)` but is closed by `]`.

---

### Example 5

Input:

```text
([)]
```

Output:

```text
false
```

Explanation:

Brackets are not closed in the correct order.

---

### Example 6

Input:

```text
(((
```

Output:

```text
false
```

Explanation:

Opening brackets remain unmatched.

---

### Example 7

Input:

```text
}}
```

Output:

```text
false
```

Explanation:

Closing brackets appear before any opening brackets.

---

# Intuition

The key observation is:

Whenever we encounter a closing bracket, it must match the **most recently opened bracket**.

This behavior follows:

```text
Last Opened → First Closed
```

which is exactly the behavior of a **Stack (LIFO)**.

Example:

```text
([{}])
```

Opening sequence:

```text
(
[
{
```

Closing sequence:

```text
}
]
)
```

Notice how brackets close in reverse order of opening.

Hence, Stack is the perfect data structure.

---

# Why Stack?

A stack follows:

```text
Last In First Out (LIFO)
```

Operations:

```text
push()  -> Insert element
pop()   -> Remove top element
top()   -> View top element
empty() -> Check if stack is empty
```

Visual Representation:

```text
Push '('

Top
 |
 v
-----
| ( |
-----

Push '['

Top
 |
 v
-----
| [ |
-----
| ( |
-----

Push '{'

Top
 |
 v
-----
| { |
-----
| [ |
-----
| ( |
-----
```

When `}` appears:

```text
Pop '{'
```

Perfect match.

---

# Algorithm

1. Create an empty stack.
2. Traverse every character in the string.
3. If current character is an opening bracket:
   - Push it into the stack.
4. If current character is a closing bracket:
   - If stack is empty → return `false`.
   - Pop top element.
   - Check if popped bracket matches current closing bracket.
   - If not matched → return `false`.
5. After traversal:
   - If stack is empty → return `true`.
   - Otherwise → return `false`.

---

# Detailed Dry Run #1

## Input

```text
([{}])
```

### Initial State

```text
Stack = []
```

---

### Step 1

Current Character:

```text
(
```

Opening bracket.

Push into stack.

```text
Stack = [(]
```

---

### Step 2

Current Character:

```text
[
```

Push into stack.

```text
Stack = [(, []
```

---

### Step 3

Current Character:

```text
{
```

Push into stack.

```text
Stack = [(, [, {]
```

---

### Step 4

Current Character:

```text
}
```

Top of stack:

```text
{
```

Match found.

Pop.

```text
Stack = [(, []
```

---

### Step 5

Current Character:

```text
]
```

Top:

```text
[
```

Match found.

Pop.

```text
Stack = [(]
```

---

### Step 6

Current Character:

```text
)
```

Top:

```text
(
```

Match found.

Pop.

```text
Stack = []
```

---

### Final Check

Stack is empty.

```text
Return true
```

---

# Detailed Dry Run #2

## Input

```text
([)]
```

### Initial State

```text
Stack = []
```

---

### Step 1

Character:

```text
(
```

Push.

```text
Stack = [(]
```

---

### Step 2

Character:

```text
[
```

Push.

```text
Stack = [(, []
```

---

### Step 3

Character:

```text
)
```

Top:

```text
[
```

Expected:

```text
]
```

But received:

```text
)
```

Mismatch.

```text
Return false
```

---

# Detailed Dry Run #3

## Input

```text
}}
```

### Initial State

```text
Stack = []
```

---

### Step 1

Character:

```text
}
```

Current character is closing bracket.

Stack is already empty.

```text
Return false
```

Reason:

No opening bracket exists for matching.

---

# Detailed Dry Run #4

## Input

```text
(((
```

### Initial State

```text
Stack = []
```

---

### Step 1

```text
(
```

Push.

```text
Stack = [(]
```

---

### Step 2

```text
(
```

Push.

```text
Stack = [(, (]
```

---

### Step 3

```text
(
```

Push.

```text
Stack = [(, (, (]
```

---

### Traversal Ends

Stack:

```text
[(, (, (]
```

Not empty.

This means some opening brackets never got closed.

```text
Return false
```

---

# Visual Understanding

Consider:

```text
{[()]}
```

Opening order:

```text
{
[
(
```

Stack:

```text
Top
 |
 v
-----
| ( |
-----
| [ |
-----
| { |
-----
```

Closing sequence:

```text
)
]
}
```

The stack removes brackets in reverse order:

```text
(
[
{
```

which perfectly matches the required behavior.

---

# Pseudocode

```text
create empty stack

for each character ch in string:

    if ch is opening bracket:
        push ch

    else:

        if stack is empty:
            return false

        top = pop()

        if ch == ')' and top != '(':
            return false

        if ch == ']' and top != '[':
            return false

        if ch == '}' and top != '{':
            return false

if stack is empty:
    return true

return false
```

---

# Java Solution

```java
import java.util.Stack;

public class BalancedParentheses {

    public static boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {

                if (st.isEmpty()) {
                    return false;
                }

                char top = st.pop();

                if (ch == ')' && top != '(') {
                    return false;
                }

                if (ch == ']' && top != '[') {
                    return false;
                }

                if (ch == '}' && top != '{') {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }

    public static void main(String[] args) {

        String s = "([{}])";

        System.out.println(isValid(s));
    }
}
```

---

# Optimized Approach Using HashMap

Instead of multiple if-else checks, we can store bracket mappings.

```java
import java.util.*;

public class BalancedParentheses {

    public static boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        HashMap<Character, Character> map = new HashMap<>();

        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for(char ch : s.toCharArray()) {

            if(ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            }
            else {

                if(st.isEmpty())
                    return false;

                if(st.pop() != map.get(ch))
                    return false;
            }
        }

        return st.isEmpty();
    }
}
```

---

# Edge Cases

### Case 1

```text
Input: ""
Output: true
```

Empty string is balanced.

---

### Case 2

```text
Input: "("
Output: false
```

Unmatched opening bracket.

---

### Case 3

```text
Input: ")"
Output: false
```

Closing bracket without opening bracket.

---

### Case 4

```text
Input: "()"
Output: true
```

Perfectly matched.

---

### Case 5

```text
Input: "((()))"
Output: true
```

Deep nesting but valid.

---

### Case 6

```text
Input: "(()"
Output: false
```

One opening bracket remains.

---

# Complexity Analysis

## Time Complexity

We traverse the string exactly once.

```text
O(n)
```

where `n` is the length of the string.

---

## Space Complexity

In the worst case:

```text
((((((((
```

All characters are stored in the stack.

```text
O(n)
```

---

