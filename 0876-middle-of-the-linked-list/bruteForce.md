# Brute Force Approach

## Intuition

To find the middle node of a linked list, we first need to know the total number of nodes present in the list.

The brute force approach works in **two traversals**:

1. Traverse the linked list and count the total number of nodes (`n`).
2. Calculate the middle position and traverse again to reach that node.

---

## Finding the Middle Position

If the linked list contains `n` nodes, the middle node will be located at:

```text
(n / 2) + 1
```

where `/` represents integer division.

This formula automatically handles both odd and even length linked lists and returns the **second middle node** when two middle nodes exist.

---

## Example 1

### Input

```text
1 → 2 → 3 → 4 → 5
```

### Step 1: Count Nodes

```text
n = 5
```

### Step 2: Find Middle Position

```text
Middle Position = (5 / 2) + 1
                = 2 + 1
                = 3
```

### Output

```text
3 → 4 → 5
```

The 3rd node is the middle node.

---

## Example 2

### Input

```text
1 → 2 → 3 → 4 → 5 → 6
```

### Step 1: Count Nodes

```text
n = 6
```

### Step 2: Find Middle Position

```text
Middle Position = (6 / 2) + 1
                = 3 + 1
                = 4
```

### Output

```text
4 → 5 → 6
```

Since the linked list has two middle nodes (`3` and `4`), we return the second middle node (`4`).

---

## Dry Run

### Input

```text
1 → 2 → 3 → 4 → 5 → 6
```

### First Traversal

Count the total number of nodes.

```text
Node 1 → Count = 1
Node 2 → Count = 2
Node 3 → Count = 3
Node 4 → Count = 4
Node 5 → Count = 5
Node 6 → Count = 6
```

Final count:

```text
n = 6
```

---

### Calculate Middle Position

```text
Middle Position = (6 / 2) + 1
                = 4
```

---

### Second Traversal

Move to the 4th node.

```text
Position 1 → Node 1
Position 2 → Node 2
Position 3 → Node 3
Position 4 → Node 4
```

Middle node found:

```text
4 → 5 → 6
```

---

## Algorithm

1. Initialize a counter to `0`.

2. Traverse the linked list and count the total number of nodes.

3. Calculate the middle position using:

   ```text
   (n / 2) + 1
   ```

4. Traverse the linked list again until the middle position is reached.

5. Return the node at that position.

---

## Complexity Analysis

| Operation                         | Complexity |
| --------------------------------- | ---------- |
| First Traversal (Counting Nodes)  | O(n)       |
| Second Traversal (Finding Middle) | O(n)       |
| Total Time Complexity             | O(n)       |
| Space Complexity                  | O(1)       |

---

## Why Is This Called a Brute Force Approach?

This method requires traversing the linked list **twice**:

* First traversal to count the nodes.
* Second traversal to locate the middle node.

Although the overall time complexity is still **O(n)**, it is less efficient than the **Slow & Fast Pointer** approach, which finds the middle node in a single traversal.


