public class Strings {
    public static void main(String[] args) {
        // These are all legal ways of initializing Strings.
        String foo = new String("foo");
        String bar = "bar"; // The most common way
        String baz;
        baz = "baz";

        // Strings can be concatenated with other Strings
        String bam = foo + bar + baz;

        // Strings can also be concatenated with other objects
        String s = bam + (42 + 1);
        String t = 42 + 1 + bam; // t is "42foobarbaz"

        System.out.println("bam=\"" + bam + "\"");
        System.out.println("s=\"" + s + "\"");
        System.out.println("t=\"" + t + "\"");

        /* Strings are immutable.  None of the previous operations
        modified the original Strings */
        System.out.println("foo=\"" + foo + "\"");
        System.out.println("bar=\"" + bar + "\"");
        System.out.println("baz=\"" + baz + "\"");
        System.out.println("bam=\"" + bam + "\"");

        // The String class contains many useful methods
        int bPos = bam.indexOf("b");
        System.out.println("In bam, \"b\" first occurs at index " + bPos);

        System.out.println("bam.substring(3, 6)= \""+bam.substring(3, 6)+"\"");

        System.out.println("\"a\".compareTo(\"z\")" + "returns "
        + "a".compareTo("z"));


        // The empty String is just that:
        String empty = "";
        System.out.println("empty has length " + empty.length());
        int aPos = empty.indexOf("a");
        System.out.println("In empty, \"a\" first occurs at index " + aPos);
        String boom = null;
        int aPosInBoom = boom.indexOf("a"); // NullPointerException
    }
}
