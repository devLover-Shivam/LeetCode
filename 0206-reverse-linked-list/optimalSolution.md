# Optimal Approach (Iterative Pointer Reversal)

## Intuition

To reverse a linked list, we need to change the direction of every link.

Normally, a linked list looks like:

```text
1 → 2 → 3 → 4 → 5 → NULL
```

After reversing:

```text
5 → 4 → 3 → 2 → 1 → NULL
```

The challenge is that once we change a node's `next` pointer, we may lose access to the remaining part of the list.

To avoid this, we maintain three pointers:

- **prev** → Points to the previous node.
- **curr** → Points to the current node being processed.
- **next** → Temporarily stores the next node before changing links.

This allows us to safely reverse the links without losing track of the remaining nodes.

---

## Core Idea

For every node:

1. Save the next node.
2. Reverse the current node's link.
3. Move `prev` forward.
4. Move `curr` forward.

Repeat until the current pointer becomes `NULL`.

At the end:

```text
prev
```

will point to the new head of the reversed linked list.

---

## Algorithm

### Initialization

```text
prev = NULL
curr = head
```

---

### Repeat Until curr Becomes NULL

#### Step 1

Store the next node.

```text
next = curr.next
```

#### Step 2

Reverse the link.

```text
curr.next = prev
```

#### Step 3

Move prev forward.

```text
prev = curr
```

#### Step 4

Move curr forward.

```text
curr = next
```

---

### Final Step

Return:

```text
prev
```

because it points to the new head of the reversed list.

---

## Visual Representation

### Original List

```text
NULL ← 1 → 2 → 3 → 4 → 5 → NULL
       ↑
      curr

prev = NULL
```

---

### After Complete Reversal

```text
NULL ← 1 ← 2 ← 3 ← 4 ← 5
                         ↑
                        prev
```

New Head:

```text
5
```

---

# Example

## Input

```text
1 → 2 → 3 → 4 → 5 → NULL
```

## Output

```text
5 → 4 → 3 → 2 → 1 → NULL
```

---

# Detailed Dry Run

## Initial State

```text
prev = NULL

curr
 ↓
1 → 2 → 3 → 4 → 5 → NULL
```

---

## Iteration 1

### Save Next Node

```text
next = 2
```

### Reverse Link

```text
1 → NULL
```

### Move Pointers

```text
prev = 1
curr = 2
```

Current State:

```text
NULL ← 1

prev
 ↓

curr
 ↓
2 → 3 → 4 → 5 → NULL
```

---

## Iteration 2

### Save Next Node

```text
next = 3
```

### Reverse Link

```text
2 → 1 → NULL
```

### Move Pointers

```text
prev = 2
curr = 3
```

Current State:

```text
NULL ← 1 ← 2

          prev
           ↓

curr
 ↓
3 → 4 → 5 → NULL
```

---

## Iteration 3

### Save Next Node

```text
next = 4
```

### Reverse Link

```text
3 → 2 → 1 → NULL
```

### Move Pointers

```text
prev = 3
curr = 4
```

Current State:

```text
NULL ← 1 ← 2 ← 3

               prev
                ↓

curr
 ↓
4 → 5 → NULL
```

---

## Iteration 4

### Save Next Node

```text
next = 5
```

### Reverse Link

```text
4 → 3 → 2 → 1 → NULL
```

### Move Pointers

```text
prev = 4
curr = 5
```

Current State:

```text
NULL ← 1 ← 2 ← 3 ← 4

                    prev
                     ↓

curr
 ↓
5 → NULL
```

---

## Iteration 5

### Save Next Node

```text
next = NULL
```

### Reverse Link

```text
5 → 4 → 3 → 2 → 1 → NULL
```

### Move Pointers

```text
prev = 5
curr = NULL
```

Current State:

```text
NULL ← 1 ← 2 ← 3 ← 4 ← 5

                         ↑
                        prev
```

---

## Loop Terminates

Since:

```text
curr = NULL
```

the traversal stops.

---

## Final Answer

Return:

```text
prev
```

which points to:

```text
5 → 4 → 3 → 2 → 1 → NULL
```

---

# Why Do We Need the Next Pointer?

Suppose we have:

```text
1 → 2 → 3 → NULL
```

If we immediately do:

```text
1 → NULL
```

we lose access to:

```text
2 → 3 → NULL
```

and the remaining linked list becomes unreachable.

Therefore, before changing any links, we first save:

```text
next = curr.next
```

This ensures we never lose access to the remaining nodes.

---

# Complexity Analysis

| Operation | Complexity |
|------------|------------|
| Traversal | O(n) |
| Time Complexity | O(n) |
| Space Complexity | O(1) |

---

# Why Is This Optimal?

- Only one traversal of the linked list.
- No extra data structures are used.
- Constant extra space.
- Every node is visited exactly once.

---

# Key Takeaway

```text
Save Next Node
       ↓
Reverse Current Link
       ↓
Move prev Forward
       ↓
Move curr Forward
       ↓
Repeat
```

### Pointer Movement Summary

```text
prev ← curr → next
```

At the end of the traversal:

```text
prev
```

always points to the new head of the reversed linked list.