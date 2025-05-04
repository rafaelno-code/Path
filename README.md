# Shortest Path Java Application

## Overview

This Java application computes the shortest path (in number of edges) between two nodes in an undirected graph. The graph is defined by adjacency pairs, and breadth-first search (BFS) is used to find the minimum distance.

## File Structure

- `Path.java` — Main class:
  - Reads input test cases from a file specified as a command-line argument.
  - Builds an adjacency map from character pairs.
  - Performs BFS to compute shortest path length or reports no path.

## Prerequisites

- Java Development Kit (JDK) 8 or higher installed.
- A terminal or command prompt.

## Input File Format

The input file (e.g., `graphs.dat`) should follow:

1. First line: integer `N` — number of test cases.
2. For each test case, two lines:
   - **Line 1**: space-separated adjacency pairs (e.g. `AB BC CD EF`).
   - **Line 2**: two characters (no space) representing start and goal nodes (e.g. `AC`).

Example:
```
3
AB BC CD
AD
XZ YZ ZW
XW
AB CD EF
AE
```

## Compilation

```bash
javac Path.java
```

This produces `Path.class`.

## Running the Application

```bash
java Path graphs.dat
```

Output format:
```
Nodes:  Shortest Path
A and D: 3
X and W: 2
A and E: No Path
```

- If no file is specified, prints `No file entered`.
- If the file cannot be read or parsed, prints `Invalid File`.

## How It Works

1. **Graph Construction**:  
   - `create(String statement)` builds a `HashMap<Character, ArrayList<Character>>` listing each node’s neighbors.

2. **BFS Search**:  
   - `search(Character start, Character goal)` uses a queue to traverse levels and counts the number of edges until the goal is reached, returning `-1` if unreachable.
