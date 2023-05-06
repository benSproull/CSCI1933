import java.util.LinkedList;
import java.util.Queue;

public class PathExists {
    public static boolean doesPathExist(char[][] grid, int sourceRow, int sourceCol){
        return bfs(grid, sourceRow, sourceCol);
        //return dfs(grid, sourceRow, sourceCol, new char[grid.length][grid[0].length], sourceRow, sourceCol);
    }
    public static boolean bfs(char[][] array, int sourceRow, int sourceCol){
        Queue<Integer[]> queue = new LinkedList<>();
        char[][] copy = new char[array.length][array[0].length];
        copy[sourceRow][sourceCol] = 'x';
        Integer[] front = new Integer[]{sourceRow, sourceCol};
        queue.add(front);
        while(!queue.isEmpty()){
            front = queue.remove();
            if(front[0] - 1 >= 0 && (array[front[0] - 1][front[1]] == 'p' || array[front[0] - 1][front[1]] == 'v') && copy[front[0] - 1][front[1]] != 'x'){
                if(array[front[0] - 1][front[1]] == 'p') {
                    queue.add(new Integer[]{front[0] - 1, front[1]});
                    copy[front[0] - 1][front[1]] = 'x';
                }else if(array[front[0] - 1][front[1]] == 'v' && new Integer[]{front[0] - 1, front[1]} != new Integer[]{sourceRow, sourceCol}) {
                    return true;
                }
            }
            if (front[0] + 1 < array.length && (array[front[0] + 1][front[1]] == 'p' || array[front[0] + 1][front[1]] == 'v') && copy[front[0] + 1][front[1]] != 'x') {
                if (array[front[0] + 1][front[1]] == 'p') {
                    queue.add(new Integer[]{front[0] + 1, front[1]});
                    copy[front[0] + 1][front[1]] = 'x';
                }else if(array[front[0] + 1][front[1]] == 'v' && new Integer []{front[0] - 1, front[1]} != new Integer[]{sourceRow, sourceCol}) {
                    return true;
                }
            }
            if(front[1] + 1 < array[0].length && (array[front[0]][front[1] + 1] == 'p' || array[front[0]][front[1] + 1] == 'v') && copy[front[0]][front[1] + 1] != 'x') {
                if(array[front[0]][front[1] + 1] == 'p') {
                    queue.add(new Integer[]{front[0], front[1] + 1});
                    copy[front[0]][front[1] + 1] = 'x';
                }else if(array[front[0]][front[1] + 1] == 'v' && new Integer []{front[0], front[1] + 1} != new Integer[]{sourceRow, sourceCol}) {
                    return true;
                }
            }
            if(front[1] - 1 >= 0 && (array[front[0]][front[1] - 1] == 'p' || array[front[0]][front[1] - 1] == 'v') && copy[front[0]][front[1] - 1] != 'x') {
                if(array[front[0]][front[1] - 1] == 'p') {
                    queue.add(new Integer[]{front[0], front[1] - 1});
                    copy[front[0]][front[1] - 1] = 'x';
                }else if(array[front[0]][front[1] - 1] == 'v' && new Integer[]{front[0] - 1, front[1]} != new Integer[]{sourceRow, sourceCol}) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean dfs(char[][] array, int sourceRow, int sourceCol, char[][] copy, int startRow, int startCol) {
        if(sourceRow >= 0 && sourceRow < array.length && sourceCol >= 0 && sourceCol < array[0].length) {
            if ((array[sourceRow][sourceCol] == 'p' || array[sourceRow][sourceCol] == 'v') && copy[sourceRow][sourceCol] != 'x') {
                if(array[sourceRow][sourceCol] == 'p'){
                    copy[sourceRow][sourceCol] = 'x';
                }else if(array[sourceRow][sourceCol] == 'v' && (sourceRow != startRow || sourceCol != startCol)) {
                    return true;
                }
                if(dfs(array, sourceRow - 1, sourceCol, copy, startRow, startCol)){
                    return true;
                }
                if(dfs(array, sourceRow + 1, sourceCol, copy, startRow, startCol)){
                    return true;
                }
                if(dfs(array, sourceRow, sourceCol - 1, copy, startRow, startCol)){
                    return true;
                }
                if(dfs(array, sourceRow, sourceCol + 1, copy, startRow, startCol)){
                    return true;
                }
            }
        }
        return false;
    }
}


