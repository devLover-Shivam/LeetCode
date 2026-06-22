# Optimal Approach (Tortoise & Hare Method)

## Intuition

The **Tortoise & Hare Method** is an efficient technique used to find the middle node of a linked list in a **single traversal**.

The idea is simple:

* The **Slow Pointer (Tortoise)** moves one step at a time.
* The **Fast Pointer (Hare)** moves two steps at a time.

Since the fast pointer moves twice as fast as the slow pointer, it reaches the end of the linked list while the slow pointer reaches the middle.

---

## Why Does This Work?

Consider two people:

```text
Person 1 (Fast Pointer)  → Speed = x
Person 2 (Slow Pointer)  → Speed = x/2
```

If Person 1 covers a distance:

```text
d
```

then Person 2 will cover:

```text
d/2
```

When the fast pointer reaches the end of the linked list (distance = d), the slow pointer has covered exactly half that distance (distance = d/2).

Since the middle of a linked list lies at half of its length, the slow pointer naturally ends up at the middle node.

---

## Algorithm

1. Initialize two pointers:

   * `slow = head`
   * `fast = head`

2. Move:

   * Slow pointer by **1 step**
   * Fast pointer by **2 steps**

3. Continue until:

   * Fast pointer becomes `null`, or
   * Fast pointer's next node becomes `null`

4. Return the slow pointer.

At this point, the slow pointer will be positioned at the middle node.

---

## Visual Representation

```text
Initial State

1 → 2 → 3 → 4 → 5

S
F
```

After one iteration:

```text
1 → 2 → 3 → 4 → 5

    S
        F
```

After two iterations:

```text
1 → 2 → 3 → 4 → 5

        S
                F
```

Fast pointer has reached the end.

Middle node:

```text
3
```

---

## Example 1

### Input

```text
1 → 2 → 3 → 4 → 5
```

### Output

```text
3 → 4 → 5
```

### Explanation

The linked list contains 5 nodes.

The fast pointer reaches the end while the slow pointer reaches node 3.

Therefore, node 3 is returned.

---

## Example 2

### Input

```text
1 → 2 → 3 → 4 → 5 → 6
```

### Output

```text
4 → 5 → 6
```

### Explanation

The linked list contains two middle nodes:

```text
3 and 4
```

The problem requires returning the **second middle node**.

The Tortoise & Hare Method naturally returns node 4.

---

# Dry Run

## Input

```text
1 → 2 → 3 → 4 → 5 → 6
```

---

### Initial State

```text
Slow = 1
Fast = 1
```

```text
1 → 2 → 3 → 4 → 5 → 6
↑
S,F
```

---

### Iteration 1

Move:

```text
Slow → 1 step
Fast → 2 steps
```

Result:

```text
Slow = 2
Fast = 3
```

```text
1 → 2 → 3 → 4 → 5 → 6
    ↑   ↑
    S   F
```

---

### Iteration 2

Move:

```text
Slow → 1 step
Fast → 2 steps
```

Result:

```text
Slow = 3
Fast = 5
```

```text
1 → 2 → 3 → 4 → 5 → 6
        ↑       ↑
        S       F
```

---

### Iteration 3

Move:

```text
Slow → 1 step
Fast → 2 steps
```

Result:

```text
Slow = 4
Fast = null
```

```text
1 → 2 → 3 → 4 → 5 → 6
            ↑
            S
```

Since the fast pointer becomes `null`, the traversal stops.

---

### Final Answer

```text
4 → 5 → 6
```

The slow pointer is now positioned at the middle node.

---

## Handling Odd Length Linked Lists

### Input

```text
1 → 2 → 3 → 4 → 5
```

### Traversal

| Iteration | Slow | Fast |
| --------- | ---- | ---- |
| Start     | 1    | 1    |
| 1         | 2    | 3    |
| 2         | 3    | 5    |

The fast pointer reaches the last node.

The slow pointer points to:

```text
3
```

which is the exact middle node.

---

## Complexity Analysis

| Operation        | Complexity |
| ---------------- | ---------- |
| Traversal        | O(n)       |
| Time Complexity  | O(n)       |
| Space Complexity | O(1)       |

---

## Why Is This Better Than the Brute Force Approach?

| Brute Force                 | Tortoise & Hare             |
| --------------------------- | --------------------------- |
| Requires two traversals     | Requires only one traversal |
| Count nodes first           | No counting required        |
| Calculate middle separately | Middle found automatically  |
| O(n) Time                   | O(n) Time                   |
| O(1) Space                  | O(1) Space                  |

Although both approaches have the same time complexity, the Tortoise & Hare Method is preferred because it finds the middle node in a single pass.

---

## Key Takeaway

```text
Slow Pointer → Moves 1 Step
Fast Pointer → Moves 2 Steps

Fast Reaches End
        ↓
Slow Reaches Middle
```

This technique is one of the most important Linked List patterns and is frequently used in problems involving:

* Finding the middle node
* Detecting cycles
* Finding the start of a cycle
* Sorting linked lists
* Reordering linked lists
* Checking linked list palindromes
