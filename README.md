# Project #: Experiments with Hashing 

* Author: Martin Gonzalez
* Class: CS321 Section #002
* Semester: Spring 2025

## Overview
Implements a Hashtable class with open addressing by inserting n HashObject 
objects into a specific hash table of size m until we get a load factor α defined 
as n/m. The project looks at the use of linear probing and double hashing, 
and their performance.

## Reflection
I feel this was one of the tougher challenges so far. I think it was because
there was a lot less instruction included with this one, like not being told
was specific methods I would need. I just decided to take it as I went, and 
added certain methods and functions when I found a need for them.

This reflection would be far too long if I talked about everything I struggled 
with. The checking of conditions everywhere fried my brain, because I had to keep 
going back to find which one was breaking my program. Eventually got through it
and had some nice output. 

## Compiling and Using
Compile with 
        javac HashtableExperiment.java

Usage: java HashtableExperiment <dataSource> <loadFactor> [<debugLevel>]
       <dataSource>: 1 ==> random numbers
                     2 ==> date value as a long
                     3 ==> word list
       <loadFactor>: The ratio of objects to table size, 
                       denoted by alpha = n/m
       <debugLevel>: 0 ==> print summary of experiment
                     1 ==> save the two hash tables to a file at the end
                     2 ==> print debugging output for each insert
		 

## Results 

### Random Numbers
| Load Factor | Method         | Size  | Duplicates | Average Probes |
|-------------|----------------|-------|------------|----------------|
| 0.5         | Linear Probing  | 47896 | 1          | 1.50           |
| 0.5         | Double Hashing  | 47896 | 1          | 1.39           |
| 0.6         | Linear Probing  | 57475 | 0          | 1.75           |
| 0.6         | Double Hashing  | 57475 | 0          | 1.53           |
| 0.7         | Linear Probing  | 67054 | 1          | 2.18           |
| 0.7         | Double Hashing  | 67054 | 1          | 1.73           |
| 0.8         | Linear Probing  | 76633 | 4          | 2.98           |
| 0.8         | Double Hashing  | 76633 | 4          | 2.01           |
| 0.9         | Linear Probing  | 86212 | 0          | 5.74           |
| 0.9         | Double Hashing  | 86212 | 0          | 2.56           |
| 0.95        | Linear Probing  | 91002 | 0          | 12.27          |
| 0.95        | Double Hashing  | 91002 | 0          | 3.20           |
| 0.99        | Linear Probing  | 94834 | 1          | 31.30          |
| 0.99        | Double Hashing  | 94834 | 1          | 4.67           |

### Dates
| Load Factor | Method         | Size  | Duplicates | Average Probes |
|-------------|----------------|-------|------------|----------------|
| 0.5         | Linear Probing  | 47896 | 0          | 1.28           |
| 0.5         | Double Hashing  | 47896 | 0          | 1.38           |
| 0.6         | Linear Probing  | 57475 | 0          | 1.44           |
| 0.6         | Double Hashing  | 57475 | 0          | 1.68           |
| 0.7         | Linear Probing  | 67054 | 0          | 1.60           |
| 0.7         | Double Hashing  | 67054 | 0          | 2.00           |
| 0.8         | Linear Probing  | 76633 | 0          | 1.82           |
| 0.8         | Double Hashing  | 76633 | 0          | 2.51           |
| 0.9         | Linear Probing  | 86212 | 0          | 2.18           |
| 0.9         | Double Hashing  | 86212 | 0          | 3.15           |
| 0.95        | Linear Probing  | 91002 | 0          | 2.70           |
| 0.95        | Double Hashing  | 91002 | 0          | 3.78           |
| 0.99        | Linear Probing  | 94834 | 0          | 5.41           |
| 0.99        | Double Hashing  | 94834 | 0          | 5.41           |

### Word List
| Load Factor | Method         | Size  | Duplicates | Average Probes |
|-------------|----------------|-------|------------|----------------|
| 0.5         | Linear Probing  | 47896 | 1258034    | 1.60           |
| 0.5         | Double Hashing  | 47896 | 1258034    | 1.39           |
| 0.6         | Linear Probing  | 57475 | 1530184    | 2.15           |
| 0.6         | Double Hashing  | 57475 | 1530184    | 1.53           |
| 0.7         | Linear Probing  | 67054 | 1802152    | 3.60           |
| 0.7         | Double Hashing  | 67054 | 1802152    | 1.72           |
| 0.8         | Linear Probing  | 76633 | 2071115    | 6.71           |
| 0.8         | Double Hashing  | 76633 | 2071115    | 2.02           |
| 0.9         | Linear Probing  | 86212 | 2753838    | 19.81          |
| 0.9         | Double Hashing  | 86212 | 2753838    | 2.57           |
| 0.95        | Linear Probing  | 91002 | 2922620    | 110.59         |
| 0.95        | Double Hashing  | 91002 | 2922620    | 3.19           |
| 0.99        | Linear Probing  | 94834 | 2929300    | 471.67         |
| 0.99        | Double Hashing  | 94834 | 2929300    | 4.70           |
