package me.lirui.algo.bitwise;

class LeetCodeBitwiseSolution {

  //  Number of 1 Bits
  //  https://leetcode.com/problems/number-of-1-bits/
  //
  int hammingWeight(int n) {
    int count = 0;
    while (n != 0) {
      count ++;
      n &= (n -1);
    }

    return count;
  }

  int hammingWeightBrutalForce(int n) {
    int count = 0;
    while (n != 0) {
      if (n % 2 == 1) {
        count ++;
      }
      n = (n >> 1);
    }

    return count;
  }
  //  Number of 1 Bits
  //  https://leetcode.com/problems/number-of-1-bits/
  //
}
