public class TwinkleSynchronizer {
    private int step = 0;
    private FilePlayer player = new FilePlayer();
    
    private boolean isThread1Turn() {
        // Thread 1 plays: do, mi, sol-octave (do-octave)
        // Steps where Thread 1 plays
        return step == 0 || step == 1 || step == 2 || step == 3 || step == 6 || 
               step == 9 || step == 10 || step == 13 || step == 14 || step == 15 || 
               step == 18 || step == 19 || step == 21 || step == 22 || step == 25 || 
               step == 26 || step == 28 || step == 29 || step == 30 || step == 31 || 
               step == 34 || step == 37 || step == 38 || step == 41;
    }
    
    private boolean isThread2Turn() {
        // Thread 2 plays: re, fa, la
        // Steps where Thread 2 plays
        return step == 4 || step == 5 || step == 7 || step == 8 || step == 11 || 
               step == 12 || step == 16 || step == 17 || step == 20 || step == 23 || 
               step == 24 || step == 27 || step == 32 || step == 33 || step == 35 || 
               step == 36 || step == 39 || step == 40;
    }
    
    private void threadWait() {
        try {
            wait();
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }
    
    public synchronized void thread1Turn() {
        while (!isThread1Turn()) {
            threadWait();
        }
        
        switch(step) {
            case 0: case 1: case 13: case 28: case 29: case 41:
                System.out.println("Thread 1 plays: do (step " + step + ")");
                player.play("Sounds/do.wav");
                break;
            case 9: case 10: case 18: case 19: case 25: case 26: case 37: case 38:
                System.out.println("Thread 1 plays: mi (step " + step + ")");
                player.play("Sounds/mi.wav");
                break;
            case 2: case 3: case 6: case 14: case 15: case 21: case 22: case 30: case 31: case 34:
                System.out.println("Thread 1 plays: sol-octave (step " + step + ")");
                player.play("Sounds/do-octave.wav");
                break;
        }
        
        step++;
        notifyAll();
    }
    
    public synchronized void thread2Turn() {
        while (!isThread2Turn()) {
            threadWait();
        }
        
        switch(step) {
            case 4: case 5: case 32: case 33:
                System.out.println("Thread 2 plays: la (step " + step + ")");
                player.play("Sounds/la.wav");
                break;
            case 7: case 8: case 16: case 17: case 23: case 24: case 35: case 36:
                System.out.println("Thread 2 plays: fa (step " + step + ")");
                player.play("Sounds/fa.wav");
                break;
            case 11: case 12: case 20: case 27: case 39: case 40:
                System.out.println("Thread 2 plays: re (step " + step + ")");
                player.play("Sounds/re.wav");
                break;
        }
        
        step++;
        notifyAll();
    }
}


