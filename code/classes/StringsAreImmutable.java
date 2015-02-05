public class StringsAreImmutable {
    public static void main(String[] args) {
        String input = "Some Input";
        String output = input;
        output.toUpperCase();
        output.replaceAll(" ", "");
        System.out.println("Strings are immutable, so after");
        System.out.println("String input = \"Some Input\";");
        System.out.println("String output = input;");
        System.out.println("output.toUpperCase();");
        System.out.println("output.replaceAll(\" \", \"\");");
        System.out.println();
        System.out.println("input: " + input);
        System.out.println("output: " + output);
        System.out.println();
        System.out.println("You have to assign the results of String");
        System.out.println("transformations to (not necessarily new)");
        System.out.println("variables.");
        String normalizedOutput = output.toUpperCase().replaceAll(" ", "");
        System.out.println("normalizedOutput: " + normalizedOutput);
        System.out.println();

        String s1 = "foo";
        String s2 = "foo";
        String s3 = new String("foo");
        String s4 = "foo";
        System.out.println("Strings are interned, so after:");
        System.out.println("String s1 = \"foo\";");
        System.out.println("String s2 = \"foo\";");
        System.out.println("String s3 = new String(\"foo\");");
        System.out.println("String s4 = \"foo\";");
        System.out.println();
        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("s1.equals(s2): " + s1.equals(s2));
        System.out.println("s1.equals(\"foo\"): " + s1.equals("foo"));
        System.out.println("\"foo\".equals(s1): " + "foo".equals(s1));
        System.out.println("\"foo\" == s1: " + ("foo" == s1));
        System.out.println("\"foo\" == s3: " + ("foo" == s3));
        System.out.println("\"foo\".equals(s3): " + "foo".equals(s3));
        System.out.println("s1 == s4: " + (s1 == s4));
        s4 = s1 + "";
        System.out.println("after s4 += \"\":");
        System.out.println("s1 == s4: " + (s1 == s4));
        System.out.println("s1.equals(s4): " + s1.equals(s4));
    }

}
