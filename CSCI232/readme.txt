/******************************************************************************
 *  Name: Colin Conrad
 *
 *  Hours to complete assignment (optional):
 *
 ******************************************************************************/

Programming Assignment 2: Autocomplete


/******************************************************************************
 *  Describe how your firstIndexOf() method in BinarySearchDeluxe.java
 *  finds the first index of a key that equals the search key.
 *****************************************************************************/
First I initialised two pointers (High and low) which are the bounries in our 
array. Then I used a while loop to iterate through the bounds until low exceeds high.
(this is my binary search approach). “mid” is calculated by adding half of the difference from high-low to low. 
Then I compare the key at index mid with comparators key compr the adjusts the search range.
example: if compr is less than 0 then key at mid is less than search key so we shift search range to right
by making low mid +1. Opposite when greater than 0. if compr == 0 then mid and 
search key are even and in that case we need to check if it's the first instance.
if first instance mid is returned as index of first occurence. If not then continue
search to left side my setting high to mid-1. Onece low > high loop terminates.



/******************************************************************************
 *  What is the order of growth of the number of compares (in the
 *  worst case) that each of the operations in the Autocomplete
 *  data type make, as a function of the number of terms n and the
 *  number of matching terms m?  (Big-Oh notation)
 *
 *  Recall that with order-of-growth notation, you should discard
 *  leading coefficients and lower-order terms, e.g., m^2 + m log n.
 *****************************************************************************/

constructor: O(n log n)
- From "sort" where n is total number of terms

allMatches():O(log n + m log m)
-Runtime from Binary: log n // Runtime from matching terms (m log m) so log n + m log m

numberOfMatches():O(log n)
-just a binary search so log n


/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
Having an issue where t is output before some casses

ex.
408541/tcompartment
429032/tcompelling
437339/tcomposer
480456/tcomposing
571752/tcomparing

Only on some cases and I don't know why. I's sure its a syntax error or typo but I'm almost out of time for this assignment.

/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings or lectures, but do include
 *  any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *
 *  Also include any resources (including the web) that you may
 *  may have used in creating your design.
 *****************************************************************************/
Help: Several hours of collaberation with classmates ( Kyle, Ingrid),
online resources like Stack Overflow and Geeks for Geeks

/******************************************************************************
 *  Describe any serious problems you encountered.
 *****************************************************************************/





/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback
 *  on how much you learned from doing the assignment, and whether
 *  you enjoyed doing it.
 *****************************************************************************/
