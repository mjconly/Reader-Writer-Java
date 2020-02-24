public class Data {
    private int readers;

    public Data(){
        this.readers = 0;
    }

    public void read(int number){
        synchronized (this){
            this.readers += 1;
            System.out.println("Reader " + number + " started reading");
        }

        try{
            Thread.sleep((int) (Math.random() * 5000));
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        synchronized (this){
            System.out.println("Reader " + number + " stopped reading");
            this.readers -= 1;
            if (this.readers == 0){
                this.notifyAll();
            }
        }
    }
}
