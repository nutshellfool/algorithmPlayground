package me.lirui.algo.unionfind;

import org.junit.Assert;


/**
 * Specification implementation of UnionFind
 * for "grid" like following:<p>
 *
 * | '0' '1' '0' |<p> | '1' '1' '0' |<p> | '0' '0' '1' |<p>
 *
 * 1 : occupied region
 */
class GridUnionFind {

  private int[] mParents;
  private int[] mRanks;
  private int mCount;

  GridUnionFind(char[][] grid) {
    Assert.assertNotNull(grid);
    Assert.assertNotNull(grid[0]);
    int _rowLength = grid.length;
    int _colLength = grid[0].length;
    mCount = 0;
    mParents = new int[_rowLength * _colLength];
    mRanks = new int[_rowLength * _colLength];

    for (int i = 0; i < _rowLength; i++) {
      for (int j = 0; j < _colLength; j++) {
        if (grid[i][j] == '1') {
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
    int rootX = find(indicesX);
    int rootY = find(indicesY);

    if (rootX != rootY) {
      if (mRanks[rootX] < mRanks[rootY]) {
        mParents[rootX] = rootY;
      } else if (mRanks[rootX] > mRanks[rootY]) {
        mParents[rootY] = rootX;
      } else {
        mParents[rootX] = rootY;
        mRanks[rootX] += 1;
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
