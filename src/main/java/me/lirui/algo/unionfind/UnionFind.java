package me.lirui.algo.unionfind;

/**
 * An implementation of UnionFind data structure
 */
class UnionFind {

  private int[] roots;

  UnionFind(int n) {
    roots = new int[n];

    for (int i = 0; i < n; i++) {
      roots[i] = i;
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
    int rootq = findRoot(q);
    roots[rootP] = rootq;
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
