package me.lirui.algo.unionfind;

import org.junit.Assert;


/**
 * Actually this class should not be here This is exactly the same implementation with
 * GridUnionFind, the only difference is the constructor accepted type(char[][] and int[][]), Just
 * because the Java generic programming Type erase limits, we do not have the perfect generic
 * GridUnionFind implementation, may be later.
 */
class GridIntUnionFind {

  private int[] mParents;
  private int[] mRanks;
  private int mCount;

  GridIntUnionFind(int[][] grid) {
    Assert.assertNotNull(grid);
    Assert.assertNotNull(grid[0]);
    int _rowLength = grid.length;
    int _colLength = grid[0].length;
    mCount = 0;
    mParents = new int[_rowLength * _colLength];
    mRanks = new int[_rowLength * _colLength];

    for (int i = 0; i < _rowLength; i++) {
      for (int j = 0; j < _colLength; j++) {
        if (grid[i][j] == 1) {
          mParents[i * _colLength + j] = i * _colLength + j;
          mCount += 1;
        }
      }
    }
  }

  /**
   * Find the root of Node(i)
   *
   * @param i node index
   * @return the root index
   */
  private int find(int i) {
    int root = i;

    while (mParents[root] != root) {
      root = mParents[root];
    }

    return root;
  }

  /**
   * Union operation for node(indexX) and node(indexY)
   *
   * @param indicesX NodeX index
   * @param indicesY NodeY index
   */
  void union(int indicesX, int indicesY) {
    int rootOfX = find(indicesX);
    int rootOfY = find(indicesY);

    if (rootOfX != rootOfY) {
      if (mRanks[rootOfX] > mRanks[rootOfY]) {
        mParents[rootOfY] = rootOfX;
      } else if (mRanks[rootOfX] < mRanks[rootOfY]) {
        mParents[rootOfX] = rootOfY;
      } else {
        mRanks[rootOfX] += 1;
        mParents[rootOfX] = rootOfY;
      }

      mCount--;
    }
  }

  /**
   * Get the count of union
   *
   * @return union count
   */
  int getCount() {
    return mCount;
  }

}
