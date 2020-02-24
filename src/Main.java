import java.awt.print.PrinterGraphics;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2){
            System.out.println("Enter number of readers and writers");
        }
        else{
            final int READERS = Integer.parseInt(args[0]);
            final int WRITERS = Integer.parseInt(args[1]);

            Data db = new Data();

            for (int i = 0; i < READERS; i++){
                new Reader(db).start();
            }

            for (int i = 0; i < WRITERS; i++){
                new Writer(db).start();
            }
        }
    }
}
