## Write Up

n = total number of words
m = average length of word

Operation                                        |  Time Complexity
-------------------------------------------------|--------------------------------
Normalize string                                 |  Θ(m)
Convert to char array and sort characters        |  Θ(m log m)
Insert the sorted string into the HashMap        |  Θ(1) average
Add the word to the list inside the HashMap      |  Θ(1) average

Each word is processed independently with a time complexity of `Θ(m log m)`.

Repeat this process for n words to get a total time complexity of `Θ(n × m log m)`.
