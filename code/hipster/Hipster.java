import java.awt.Color;

public class Hipster extends Person {

    private int beardLength;
    private Color beanieColor;

    public Hipster(String name, int jeanBagginess,
                   int beardLength, Color beanieColor) {
        super(name);
        if (jeanBagginess > 0) {
            throw new IllegalArgumentException("Jeans must be skinny!");
        }
        this.beardLength = beardLength;
        this.beanieColor = beanieColor;
    }

    public int getBeardLength() {
        return beardLength;
    }

    public Color getBeanieColor() {
        return beanieColor;
    }

    public boolean equals(Object other) {
        if (this == other) { return true; }
        if (!(other instanceof Hipster)) { return false; }
        Hipster that = (Hipster) other;
        return super.equals(that)
            && this.beardLength == that.beardLength
            && this.beanieColor.equals(that.beanieColor);
    }
}
