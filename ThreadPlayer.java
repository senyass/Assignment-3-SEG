public class ThreadPlayer {
    public static void main(String[] args){
        Synchronizer controller = new Synchronizer();
        DoThread doThread = new DoThread(controller);
        Thread t1 = new Thread(doThread);

        ReThread reThread = new ReThread(controller);
        Thread t2 = new Thread(reThread);

        t1.start();
        t2.start();

    }
}
