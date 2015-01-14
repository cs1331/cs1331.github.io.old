public class Shout {

    public static void main(String[] args) {
        System.out.println("The command line arguments are:");
        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "] = " + args[i]);
        }

        System.out.println("Now I'm gonna shout them to you:");
        for (String arg: args) {
            System.out.print(arg.toUpperCase() + " ");
        }
        System.out.println();
    }
}
