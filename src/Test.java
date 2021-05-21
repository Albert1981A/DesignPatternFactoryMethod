
public class Test {

    public static void main(String[] args) {

        /**
         * This class deals with different methods for creating instances of objects.
         * Some are tighter and harder to change their code.
         * some are looser and easier to change their code.
         */

        Iphone iphone = new Iphone();
        iphone.calling();
        iphone.browse();

        // It will need 65% Code Refactor to chang Iphone to Android
        Android android = new Android(); // Tight Coupling!
        android.calling();
        android.browse();

        // __________________________________________________________

        Mobile mobile1 = new Iphone();
        mobile1.calling();
        mobile1.browse();

        // 12% Code Refactor, using interface we can change only the "new Iphone/Android"
        Mobile mobile2 = new Android(); // Loose Coupling!
        mobile2.calling();
        mobile2.browse();

        // __________________________________________________________

        Mobile mobile3 = createPhone("Iphone");
        mobile3.calling();
        mobile3.browse();

        // 12% Code Refactor, using interface and a factory method
        Mobile mobile4 = createPhone("Android"); // Loose Coupling!
        mobile4.calling();
        mobile4.browse();

        // __________________________________________________________

        // 0% Code Refactor, getting a configuration (the decision) from out side
        Mobile mobile5 = createPhone(args[0]); // Loose Coupling!
        mobile5.calling();
        mobile5.browse();
    }

    public static Mobile createPhone(String input) {
        if (input.equalsIgnoreCase("Iphone")) {
            return new Iphone();
        }
        return new Android();
    }
}
