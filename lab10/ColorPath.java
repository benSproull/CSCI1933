import java.util.*;
import java.util.LinkedList;
public class ColorPath {
    public static int[][] colorPath(int[][] image, int sourceRow, int sourceCol, int newColor){
        bfs(image, sourceRow, sourceCol, newColor);
        //dfs(image,sourceRow,sourceCol,newColor, image[sourceRow][sourceCol]);
        return image;
    }
    public static void bfs(int[][] array, int sourceRow, int sourceCol, int newColor){
        int oldColor = array[sourceRow][sourceCol];
        Queue<Integer[]> queue = new LinkedList<>();
        Integer[] front = new Integer[] {sourceRow,sourceCol};
        queue.add(front);
        while(!queue.isEmpty()){
            front = queue.remove();
            array[front[0]][front[1]] = newColor;
            if (front[0] - 1 >= 0 && array[front[0] - 1][front[1]] == oldColor){
                queue.add(new Integer[]{front[0] - 1, front[1]});
            }
            if (front[0] + 1 < array.length && array[front[0] + 1][front[1]] == oldColor){
                queue.add(new Integer[]{front[0], front[1] + 1});
            }
            if (front[1] + 1 < array[0].length && array[front[0]][front[1] + 1] == oldColor){
                queue.add(new Integer[]{front[0], front[1] + 1});
            }
            if (front[1] - 1 >= 0 && array[front[0]][front[1] - 1] == oldColor){
                queue.add(new Integer[]{front[0], front[1] - 1});
            }

        }
    }
    public static void dfs(int[][] array, int sourceRow, int sourceCol, int newColor, int oldColor){
        if (sourceRow < 0 || sourceRow >= array.length || sourceCol < 0 || sourceCol >= array[0].length || array[sourceRow][sourceCol] != oldColor){
            return;
        }
        else{
            array[sourceRow][sourceCol] = newColor;
            dfs(array, sourceRow-1, sourceCol, newColor, oldColor);
            dfs(array, sourceRow+1, sourceCol, newColor, oldColor);
            dfs(array, sourceRow, sourceCol-1, newColor, oldColor);
            dfs(array, sourceRow, sourceCol+1, newColor, oldColor);
        }
    }
}
