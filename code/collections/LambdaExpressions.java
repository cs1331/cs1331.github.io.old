public class LambdaExpressions {


    interface Foo {
        void bar(Object o);
    }

    static void doo(Foo f) {
        f.bar("baz");
    }

    public static void main(String[] args) {
        doo(System.out::println);
        doo(x -> System.out.println(x));
    }
}
