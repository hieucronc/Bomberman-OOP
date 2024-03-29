package uet.oop.bomberman.entities.dynamic.Smart;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static uet.oop.bomberman.BombermanGame.*;

public class Ai {
    public static boolean[][] visited = new boolean[HEIGHT][WIDTH];
    public static int[] dx = {-1, 0, 0, 1};
    public static int[] dy = {0, -1, 1, 0};
    public static Vertex[][] prev = new Vertex[HEIGHT][WIDTH];
    public static List<Vertex> parent = new ArrayList<>();

    public static void bfsForGhost(int i, int j) {
        Queue<Vertex> list = new LinkedList<>();
        Vertex v = new Vertex(i, j);
        list.add(v);
        visited[i][j] = true;
        while (!list.isEmpty()) {
            Vertex top = list.remove();
            for (int k = 0; k < 4; k++) {
                int i1 = top.x + dx[k];
                int j1 = top.y + dy[k];
                if (i1 >= 0 && i1 < HEIGHT && j1 >= 0 && j1 < WIDTH && position[i1][j1] == 0 && !visited[i1][j1]) {
                    prev[i1][j1] = top;
                    list.add(new Vertex(i1, j1));
                    visited[i1][j1] = true;
                }
            }
        }
    }

    public static void bfsForOneal(int i, int j) {
        Queue<Vertex> list = new LinkedList<>();
        Vertex v = new Vertex(i, j);
        list.add(v);
        visited[i][j] = true;
        while (!list.isEmpty()) {
            Vertex top = list.remove();
            for (int k = 0; k < 4; k++) {
                int i1 = top.x + dx[k];
                int j1 = top.y + dy[k];
                if (i1 >= 0 && i1 < HEIGHT && j1 >= 0 && j1 < WIDTH && position[i1][j1] != 1 && position[i1][j1] != 2 && !visited[i1][j1]) {
                    prev[i1][j1] = top;
                    list.add(new Vertex(i1, j1));
                    visited[i1][j1] = true;
                }
            }
        }
    }

    public static void path(Vertex s, Vertex e) {
        while (!e.isEquals(s)) {
            parent.add(e);
            e = prev[e.x][e.y];
        }
    }

    public static boolean connectedComponentOneal(Vertex s, Vertex e) {
        bfsForOneal(s.x, s.y);
        return visited[e.x][e.y];
    }

    public static boolean connectedComponentGhost(Vertex s, Vertex e) {
        bfsForGhost(s.x, s.y);
        return visited[e.x][e.y];
    }

    public static void resetFindPath() {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = false;
            }
        }
        for (int i = 0; i < prev.length; i++) {
            for (int j = 0; j < prev[0].length; j++) {
                prev[i][j] = null;
            }
        }
        parent.clear();
    }
}