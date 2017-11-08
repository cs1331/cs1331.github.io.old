public abstract class Piece {
    private Color color;
    public Piece(Color c) {
        color = c;
    }

    public Color getColor() {
        return color;
    }

    public boolean isInBoard(char file, char rank) {
        return file >= 'a' && file <= 'h' && rank >= '1' && rank <= '8';
    }

    public abstract String algebraicName();

    public abstract String fenName();

    public abstract Square[] movesFrom(Square square);

    public String toString() {
        return color.toString() + " " + this.getClass();
    }
}