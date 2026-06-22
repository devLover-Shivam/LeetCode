# Maximum Number of Balloons

## Problem Statement

Given a string `text`, determine the maximum number of times the word:

```text
balloon
```

can be formed using the characters present in the string.

Each character in the string can be used **at most once**.

---

## Understanding the Problem

To form the word:

```text
balloon
```

we need:

| Character | Required Count |
| --------- | -------------- |
| b         | 1              |
| a         | 1              |
| l         | 2              |
| o         | 2              |
| n         | 1              |

Notice that:

```text
l appears twice
o appears twice
```

This means a single occurrence of `l` or `o` is not enough to form a complete word.

---

## Intuition

Instead of checking every possible combination, we can count how many times each character appears in the input string.

Once we know the frequencies, we can determine how many complete instances of `"balloon"` can be formed.

The answer will be limited by the character that runs out first.

---

## Example 1

### Input

```text
text = "nlaebolko"
```

### Character Frequency

```text
b = 1
a = 1
l = 2
o = 2
n = 1
```

### Balloons Possible

```text
b → 1 balloon
a → 1 balloon
l → 2/2 = 1 balloon
o → 2/2 = 1 balloon
n → 1 balloon
```

### Answer

```text
1
```

---

## Example 2

### Input

```text
text = "loonbalxballpoon"
```

### Character Frequency

```text
b = 2
a = 2
l = 4
o = 4
n = 2
```

### Balloons Possible

```text
b → 2 balloons
a → 2 balloons
l → 4/2 = 2 balloons
o → 4/2 = 2 balloons
n → 2 balloons
```

### Answer

```text
2
```

Two complete instances of:

```text
balloon
```

can be formed.

---

## Key Observation

The maximum number of balloons depends on the character with the smallest usable count.

For example:

```text
b = 5
a = 3
l = 8
o = 6
n = 2
```

Possible balloons from each character:

```text
b → 5
a → 3
l → 8/2 = 4
o → 6/2 = 3
n → 2
```

The minimum value is:

```text
2
```

Therefore:

```text
Maximum Balloons = 2
```

---

## Dry Run

### Input

```text
text = "loonbalxballpoon"
```

### Step 1: Count Frequencies

```text
b = 2
a = 2
l = 4
o = 4
n = 2
```

---

### Step 2: Calculate Balloon Contribution

```text
b → 2

a → 2

l → 4/2 = 2

o → 4/2 = 2

n → 2
```

---

### Step 3: Find the Minimum

```text
min(2, 2, 2, 2, 2)
```

Result:

```text
2
```

---

## Real-Life Analogy

Suppose a burger requires:

```text
1 Bun
1 Patty
2 Cheese Slices
```

Available ingredients:

```text
10 Bun
7 Patty
4 Cheese
```

Possible burgers:

```text
Bun → 10

Patty → 7

Cheese → 4/2 = 2
```

Even though buns and patties are available in larger quantities, cheese limits the number of burgers.

Therefore:

```text
Maximum Burgers = 2
```

The same idea applies to the word:

```text
balloon
```

---

## Algorithm

1. Count the frequency of every character in the string.

2. Extract the counts of:

   * b
   * a
   * l
   * o
   * n

3. Since:

   * `l` is needed twice
   * `o` is needed twice

   divide their frequencies by 2.

4. Return the minimum among:

```text
b
a
l / 2
o / 2
n
```

---

## Complexity Analysis

| Operation             | Complexity |
| --------------------- | ---------- |
| Frequency Counting    | O(n)       |
| Finding Answer        | O(1)       |
| Total Time Complexity | O(n)       |
| Space Complexity      | O(1)       |

---

