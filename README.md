# java-tutorial

## Recursion

### Implement a square root

Here's how it works... say want to find the square root of 20. Divide by 2 which gives 10. When you square 10 it gives 100. 
100 is larger than 20 so the square root lies between 0 and 10, not 10 and 20. Now call the same function recursively with 10/2 = 5, 5 squared is 25 which larger than 20, so we know the number is between 0 and 5, not 5 to 10. Recurse with 5/2 = 2.5 and so on until you reach a number when squared is almost equal to 20.
