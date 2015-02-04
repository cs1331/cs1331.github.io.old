public class StringsAreImmutable {
    public static void main(String[] args) {
        String s1 = "foo";
        String s2 = "foo";
        String s3 = new String("foo");
        String s4 = "foo";
        System.out.println("Setup:");
        System.out.println("String s1 = \"foo\";");
        System.out.println("String s2 = \"foo\";");
        System.out.println("String s3 = new String(\"foo\");");
        System.out.println("String s4 = \"foo\";");
        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("s1.equals(s2): " + s1.equals(s2));
        System.out.println("s1.equals(\"foo\"): " + s1.equals("foo"));
        System.out.println("\"foo\".equals(s1): " + "foo".equals(s1));
        System.out.println("\"foo\" == s1: " + ("foo" == s1));
        System.out.println("\"foo\" == s3: " + ("foo" == s3));
        System.out.println("s1 == s4: " + (s1 == s4));
        s4 = s4 + "";
        System.out.println("after s4 += \"\", s1 == s4: "
        + (s1 == s4));
    }

}
