package me.lirui.algo.unionfind;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

class LeetCodeUnionFindSolution {

  private static final int[] DX = {0, 0, 1, -1};
  private static final int[] DY = {1, -1, 0, 0};

  int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int rowLength = grid.length;
    int columnLength = grid[0].length;

    GridUnionFind _unionFind = new GridUnionFind(grid);

    for (int i = 0; i < rowLength; i++) {
      for (int j = 0; j < columnLength; j++) {
        if (grid[i][j] == '0') {
          continue;
        }

        for (int k = 0; k < 4; k++) {
          int newRowIndex = i + DX[k];
          int newColumnIndex = j + DY[k];
          if (newRowIndex >= 0 && newRowIndex < rowLength && newColumnIndex >= 0
              && newColumnIndex < columnLength && grid[newRowIndex][newColumnIndex] == '1') {
            _unionFind.union(i * columnLength + j, newRowIndex * columnLength + newColumnIndex);
          }
        }
      }
    }

    return _unionFind.getCount();

  }

  int numIslandsDFS(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int rowLength = grid.length;
    int columnLength = grid[0].length;
    int numberOfIslands = 0;
    Set<Point> visited = new HashSet<>();

    for (int i = 0; i < rowLength; i++) {
      for (int j = 0; j < columnLength; j++) {
        numberOfIslands += _floodFillDFS(grid, rowLength, columnLength, i, j, visited);
      }
    }

    return numberOfIslands;
  }

  private int _floodFillDFS(char[][] grid, int maxRow, int maxCol, int i, int j,
      Set<Point> visited) {
    if (!_is_valid(grid, maxRow, maxCol, i, j, visited)) {
      return 0;
    }

    visited.add(new Point(i, j));

    for (int k = 0; k < 4; k++) {
      _floodFillDFS(grid, maxRow, maxCol, i + DX[k], j + DY[k], visited);
    }
    return 1;
  }

  private boolean _is_valid(char[][] grid, int maxRow, int maxCol, int i, int j, Set visited) {
    return i >= 0 && i < maxRow && j >= 0 && j < maxCol && grid[i][j] == '1' && !visited
        .contains(new Point(i, j));
  }

  int numIslandsDFSNoMoreExtraSpace(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int rowLength = grid.length;
    int columnLength = grid[0].length;
    int numberOfIslands = 0;

    for (int i = 0; i < rowLength; i++) {
      for (int j = 0; j < columnLength; j++) {
        if (grid[i][j] == '1') {
          _dfs(grid, i, j, rowLength, columnLength);
          numberOfIslands++;
        }
      }
    }
    return numberOfIslands;
  }

  private void _dfs(char[][] grid, int i, int j, int maxRow, int maxCol) {
    if (i >= 0 && i < maxRow && j >= 0 && j < maxCol && grid[i][j] == '1') {
      grid[i][j] = 'm';
      for (int k = 0; k < 4; k++) {
        _dfs(grid, i + DX[k], j + DY[k], maxRow, maxCol);
      }
    }
  }

  int findCircleNum(int[][] M) {
    if (M == null || M.length == 0) {
      return 0;
    }

    int rowLength = M.length;
    int columnLength = M[0].length;

    GridIntUnionFind _unionFind = new GridIntUnionFind(M);

    for (int i = 0; i < rowLength; i++) {
      for (int j = 0; j < columnLength; j++) {
        if (M[i][j] == 0) {
          continue;
        }

        for (int k = 0; k < 4; k++) {
          int newRowIndex = i + DX[k];
          int newColumnIndex = j + DY[k];
          if (newRowIndex >= 0 && newRowIndex < rowLength && newColumnIndex >= 0
              && newColumnIndex < columnLength && M[newRowIndex][newColumnIndex] == 1) {
            _unionFind.union(i * columnLength + j, newRowIndex * columnLength + newColumnIndex);
          }
        }
      }
    }

    return _unionFind.getCount();

  }
}
