public class Synchronizer {
    int step = 0;
    int onSync = 0;

    FilePlayer player = new FilePlayer();
     
    private boolean doTurn() {
        return step == 0 || step == 2 || step == 4  || step == 6 || step == 7;
    }
    
    private boolean reTurn() {
        return step == 1 || step == 3 || step == 5  || step == 7;
    }

    private void threadWait(){
         try {
                wait();
            } catch (InterruptedException e) {
                System.err.println(e);
            }
    }
    
    public synchronized void doThreadTurn() {
        while (!doTurn()) {
           threadWait();
        }   

        switch(step) {
            case 0: player.play("Sounds/do.wav");
                break;
            case 2: player.play("Sounds/mi.wav");
                break;
            case 4: player.play("Sounds/sol.wav"); 
                break;
            case 6: player.play("Sounds/si.wav");
                break; 
            case 7:
                onSync++;
                if (onSync == 1){
                  threadWait();
                }
                // Both threads play do-octave simultaneously
                player.play("Sounds/do-octave.wav");
                notifyAll();
                return;
        }
                
        step++;
        notifyAll();
        
    }

    public synchronized void reThreadTurn() {
        while (!reTurn()) {
            threadWait();
        }

        switch(step) {
            case 1: player.play("Sounds/re.wav"); 
                break;
            case 3: player.play("Sounds/fa.wav"); 
                break;
            case 5: player.play("Sounds/la.wav"); 
                break;
            case 7:
                onSync++;
                if (onSync == 1){
                  threadWait();
                }
                // Both threads play do-octave simultaneously
                player.play("Sounds/do-octave.wav");
                notifyAll();
                return;    
        }   
        step++;
        notifyAll();

    }
}
