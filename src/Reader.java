public class Reader extends Thread {
    private static int readers = 0;

    private int number;
    private Data db;

    public Reader(Data db){
        this.db = db;
        this.number = Reader.readers += 1;
    }

    public void run(){
        while(true){
            try{
                Thread.sleep((int)(Math.random() * 5000));
            } catch(InterruptedException e){
                e.printStackTrace();
            }
            this.db.read(this.number);
        }
    }
}
