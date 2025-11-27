public class Thread1 implements Runnable {
    
    private TwinkleSynchronizer controller;
    
    public Thread1(TwinkleSynchronizer controller) {
        this.controller = controller;
    }
    
    @Override
    public void run() {
        // Thread 1 plays 24 notes in the song
        for (int i = 0; i < 24; i++) {
            controller.thread1Turn();
        }
    }
}


