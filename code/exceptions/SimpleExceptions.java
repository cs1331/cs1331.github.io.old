public class SimpleExceptions {

    static void iThrowException() throws Exception {
        boolean isThereAProblem = true;
        // ..
        if (isThereAProblem) {
            Exception ex = new Exception("Thrown from iThrowExcepion()");
            throw ex;
        }
        System.out.println("Will this line execute?");
    }

    static void foo() throws Exception {
        //iThrowException();
        throw new Throwable("");
    }

    public static void main(String[] args) throws Exception {
        int i = 0;
        try {

            iThrowException();
            System.out.println("Will this line execute?");
        } catch (Exception e) {
            System.out.println("i == " + i);
            System.out.println("Caught Exception in main: " + e.getMessage());
            e.printStackTrace(System.out);
        }


        try {
            foo();
        } catch (Exception e) {
            System.out.println("Caught Exception in foo()'s catch block: "
                               + e.getMessage());
        }

        foo();
    }
}
