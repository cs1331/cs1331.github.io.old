public class Square {
    private char rank;
    private char file;
    private String name;
    public Square(char file, char rank) {
        this("" + file + rank);
    }

    public Square(String name) {
        this.name = name;
        if (name != null && name.length() == 2) {
            file = name.charAt(0);
            rank = name.charAt(1);
            if (file >= 'a' && file <= 'h' && rank >= '1' && rank <= '8') {
                this.name = name;
                
            } else {
                throw new InvalidSquareException(name);
            }
        } else {
            throw new InvalidSquareException(name);
        }
    }

    public char getFile() {
        return file;
    }

    public char getRank() {
        return rank;
    }

    public String toString() {
        return name;
    }

    public boolean equals(Object o) {
        if (o instanceof Square) {
            Square that = (Square) o;
            return that.rank == rank && that.file == file;
        } else {
            return false;
        }
    }
}