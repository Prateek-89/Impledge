# Impledge - Compound Word Finder

A Java program that finds the longest and second-longest compound words from a given list of words. A compound word is defined as a word that can be constructed entirely by concatenating two or more other words from the same list.

## How It Works

1. Reads all words from a user-specified input file.
2. Sorts the words by length in descending order (longest first).
3. For each word, recursively checks whether it can be formed by concatenating two or more shorter words from the list.
4. Uses memoization to cache results and improve performance.
5. Outputs the longest compound word, the second longest compound word, and the total time taken.

## Prerequisites

- **Java Development Kit (JDK)** 8 or higher installed on your system.
- Verify installation by running:
  ```bash
  java -version
  javac -version
  ```

## Input File Format

The input file should be a plain text file with one word per line. Two sample files are provided:

- **`Input_01.txt`** — A small test file (9 words) for quick verification.
- **`Input_02.txt`** — A large dictionary file for performance testing.

## How to Compile and Run

### 1. Compile the program

```bash
javac Main.java
```

This generates a `Main.class` file in the same directory.

### 2. Run the program

```bash
java Main
```

### 3. Enter the input file name when prompted

```
 
Word Finder
==
Enter input file name
```

Type the name of the input file (e.g., `Input_01.txt` or `Input_02.txt`) and press **Enter**.

## Example Run

**Input file** (`Input_01.txt`):
```
cat
cats
catsdogcats
catxdogcatsrat
dog
dogcatsdog
hippopotamuses
rat
ratcatdogcat
```

**Output**:
```
 
Word Finder
==
Enter input file name
Input_01.txt
 Result-
Longest Compound Word: ratcatdogcat
Second Longest Compound Word: catsdogcats
Time Taken: 1 ms
```

## Files in This Repository

| File             | Description                                      |
|------------------|--------------------------------------------------|
| `Main.java`      | Main source code with compound word logic        |
| `Input_01.txt`   | Sample input file (small)                        |
| `Input_02.txt`   | Sample input file (large dictionary)             |
| `README.md`      | This file                                        |

## Notes

- The program runs entirely from the command line — no external libraries or build tools required.
- If the specified input file is not found in the current directory, an error message will be displayed.
- Performance varies with input size. The algorithm has been optimized with memoization for efficient compound-word detection.