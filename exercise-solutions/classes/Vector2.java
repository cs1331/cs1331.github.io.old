public class Vector2 {

    public final double x;
    public final double y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "("+x+","+y+")";
    }

    public boolean equals(Vector2 other) {
        return (this.x == other.x) && (this.y == other.y);
    }

    public Vector2 plus(Vector2 other) {
        return new Vector2(this.x + other.x, this.y + other.y);
    }

    public Vector2 minus(Vector2 other) {
        return new Vector2(this.x - other.x, this.y - other.y);
    }

    public double dot(Vector2 other) {
        return (this.x * other.x) + (this.y * other.y);
    }


    public static void main(String[] args) {
        Vector2 a = new Vector2(1,2);
        Vector2 b = new Vector2(3,4);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("a.plus(b) = " + a.plus(b));
        System.out.println("a.minus(b) = " + a.minus(b));
        System.out.println("a.dot(b) = " + a.dot(b));
    }
}
