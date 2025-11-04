# CS3310_Assignment2_Anagrams
## Background: anagrams
An anagram is a word or phrase that is created by rearranging the letters of another word
or phrase. For example, the words “eat”, “ate”, and “tea” are anagrams of one another.

## Function
This program finds all anagram groups of the words in the given text file. The program then creates an output text file, and stores one annagram group per line. 
For example, an input file:

``` 
elbow
night
below
meats
steam
teams 
```
Will result in an output file:
```
below, elbow
meats, steam, teams
```


This program ignores...
* distinctions between upercase and lowercase numbers. For example, “Elvis” and “lives” will be identified as
anagrams of one another.
* punctuation, including apostrophes. For example, "t'ar", "ra't", and "art" will be identified as anagrams of one another.
* accent markers. For example, "cät" and "act" will be identified as anagrams of one another.
* duplicates. For example, if there are two instances of "bake" in the input file, "bake" will appear twice in its respective anagram group in the output file. 

## How to run
Note: The input text file must be formatted with one string on each line.

1. clone this GitHub repository 
2. open up the command prompt terminal on your machine
3. use the change directory command "cd" and navigate to the CS3310_Assignment2_Anagrams > src > main > java
4. compile the program using the "javac" command
5. run the program using the "java" command, including the full path to your text file as a command line argument

Example shown below:
<img width="1469" height="160" alt="image" src="https://github.com/user-attachments/assets/9427fe2f-b9bf-4d0b-be54-ff24a374a3d1" />

You can access the output file, outputFile.txt, by navigating to CS3310_Assignment2_Anagrams > src > main > resources

