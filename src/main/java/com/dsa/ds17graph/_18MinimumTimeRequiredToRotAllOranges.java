package com.dsa.ds17graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class _18MinimumTimeRequiredToRotAllOranges {

	// Grid values: 0 = empty cell, 1 = fresh orange, 2 = rotten orange.
	// Multi-source BFS is used because all rotten oranges spread at the same time.
	public int minimumTimeRequiredToRotAllOranges(int[][] grid){
		if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0){
			throw new IllegalArgumentException("Invalid grid input!");
		}

		int rows = grid.length;
		int cols = grid[0].length;
		// Count fresh oranges so we can know if all of them become rotten
		int freshOranges = 0;
		// Stores the latest minute at which an orange becomes rotten
		int time = 0;
		boolean[][] visited = new boolean[rows][cols];
		// Each queue item stores row, column and current time
		Deque<int[]> queue = new ArrayDeque<>();

		// Add all initially rotten oranges to queue before BFS starts
		for (int i = 0 ; i < rows ; i++){
			if (grid[i] == null || grid[i].length != cols){
				throw new IllegalArgumentException("Invalid grid input!");
			}

			for (int j = 0 ; j < cols ; j++){
				if (grid[i][j] < 0 || grid[i][j] > 2){
					throw new IllegalArgumentException("Invalid orange value!");
				}

				if (grid[i][j] == 2){
					// This rotten orange starts spreading at minute 0
					queue.add(new int[]{i,j,0});
					visited[i][j] = true;
				} else if (grid[i][j] == 1){
					freshOranges++;
				}
			}
		}

		// Four possible moves: right, down, left and up
		int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

		while (!queue.isEmpty()){
			// Process one rotten orange from the queue
			int[] curr = queue.poll();
			int row = curr[0];
			int col = curr[1];
			time = curr[2];

			for (int[] direction : directions){
				int newRow = row + direction[0];
				int newCol = col + direction[1];

				if (isValidFreshOrange(grid,visited,newRow,newCol,rows,cols)){
					// Adjacent fresh orange becomes rotten after one more minute
					visited[newRow][newCol] = true;
					freshOranges--;
					queue.add(new int[]{newRow,newCol,time + 1});
				}
			}
		}

		if (freshOranges > 0){
			// Some fresh oranges were unreachable from all rotten oranges
			return -1;
		}

		return time;
	}

	private boolean isValidFreshOrange(int[][] grid,boolean[][] visited,int row,int col,int rows,int cols){
		// Cell must be inside grid, fresh and not already rotten by BFS
		return row >= 0 && row < rows
				&& col >= 0 && col < cols
				&& grid[row][col] == 1
				&& !visited[row][col];
	}
}
