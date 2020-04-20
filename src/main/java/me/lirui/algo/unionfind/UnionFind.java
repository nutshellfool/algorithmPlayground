package me.lirui.algo.unionfind;

/**
 * An implementation of UnionFind data structure
 * With path compression and path pruning by rank optimization.
 */
class UnionFind {

  private int[] roots;
  private int mCount;
  private int[] mRank;

  UnionFind(int n) {
    mCount = n;
    roots = new int[n];
    mRank = new int[n];

    for (int i = 0; i < n; i++) {
      roots[i] = i;
      mRank[i] = 1;
    }
  }

  /**
   * Union operation
   *
   * @param p the source node(merging node)
   * @param q the target node(merged node, new root node)
   */
  void union(int p, int q) {
    int rootP = findRoot(p);
    int rootQ = findRoot(q);

    if (rootP != rootQ) {
      if (mRank[rootP] < mRank[rootQ]) {
        roots[rootP] = rootQ;
        mRank[rootQ] += mRank[rootP];
      } else {
        roots[rootQ] = rootP;
        mRank[rootP] += mRank[rootQ];
      }
      mCount--;
    }


  }

  /**
   * Is two node connected
   *
   * @param p node-p
   * @param q node-q
   * @return is connected
   */
  boolean connected(int p, int q) {
    return findRoot(p) == findRoot(q);
  }

  int getCount() {
    return mCount;
  }

  private int findRoot(int i) {
    int root = i;
    while (root != roots[root]) {
      root = roots[root];
    }

    //
    // compress path optimization
    //
    while (i != roots[i]) {
      int temp = roots[i];
      roots[i] = root;
      i = temp;
    }
    return root;
  }
}
