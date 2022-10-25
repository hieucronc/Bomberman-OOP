package uet.oop.bomberman.entities.dynamic.Smart;

public class Vertex {
    public int x;
    public int y;

    public Vertex(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public boolean isEquals(Vertex other) {
        return x == other.x && y == other.y;
    }
}
