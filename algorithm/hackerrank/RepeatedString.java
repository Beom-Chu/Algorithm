/*
Repeated String

There is a string, s, of lowercase English letters that is repeated infinitely many times. 
Given an integer, n, find and print the number of letter a's in the first n letters of the infinite string.

Example
s = 'abcac'
n = 10

The substring we consider is abcacabcac, the first 10 characters of the infinite string. 
There are 4 occurrences of a in the substring.

Function Description

Complete the repeatedString function in the editor below.

repeatedString has the following parameter(s):
s: a string to repeat
n: the number of characters to consider

Returns
int: the frequency of a in the substring

Input Format
The first line contains a single string, .
The second line contains an integer, .

Constraints
1 <= s <= 100
1 <= n <= 10^12
For 25% of the test cases, n   <= 10^6.

Sample Input
Sample Input 0
aba
10

Sample Output 0
7

Explanation 0
The first n = 10 letters of the infinite string are abaabaabaa. 
Because there are 7 a's, we return 7.

Sample Input 1
a
1000000000000

Sample Output 1
1000000000000
Explanation 1
Because all of the first n = 1000000000000 letters of the infinite string are a, we return 1000000000000.

* 분석
s 문자열을 n 갯수만큼 반복해서 붙였을때 알파벳 a의 개수를 구하기

1. n 갯수만큼 반복해서 붙일시 out of memory 발생
2. n 에서 문자열 갯수만큼 나눠준 값에서 문자열의 'a' 개수를 곱해 줌
3. n/문자열 길이가 딱 맞아떨어지지 않을수 있으므로 문자열 처음에서 나머지 값만큼 중 'a'의 갯수 추가로 더해줌

*/
package algorithm.hackerrank;

public class RepeatedString {

  public long repeatedString(String s, long n) {

    //문자열에서 a의 갯수
    long cnt = s.chars().filter(c -> c == 'a').count();

    //전체 길이 / 문자열 길이 * 문자열 a의 개수 = 전체 문자열 a 개수(나머지갯수 제외)
    long rtn = n / s.length() * cnt;
    
    //나머지 문자열의 길이
    int remain = (int) (n % s.length());

    //나머지 문자열의 a 개수
    rtn += s.substring(0, remain).chars().filter(c -> c == 'a').count();

    return rtn;
  }

}
