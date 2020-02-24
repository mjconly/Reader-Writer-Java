public class Writer extends Thread {
    private static int writers = 0;

    private int number;
    private Data db;

    public Writer(Data db){
        this.db = db;
        this.number = Writer.writers++;
    }

    public void run(){
        while(true){
            try{
                Thread.sleep((int) (Math.random() * 5000));
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            this.db.write(this.number);
        }
    }
}
