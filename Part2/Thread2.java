public class Thread2 implements Runnable {
    
    private TwinkleSynchronizer controller;
    
    public Thread2(TwinkleSynchronizer controller) {
        this.controller = controller;
    }
    
    @Override
    public void run() {
        // Thread 2 plays 18 notes in the song
        for (int i = 0; i < 18; i++) {
            controller.thread2Turn();
        }
    }
}


