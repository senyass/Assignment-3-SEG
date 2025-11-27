public class ReThread implements Runnable{
    
    Synchronizer controller;

    ReThread(Synchronizer controller) {
        this.controller = controller;
    }

    @Override
    public void run(){
        for (int i = 0; i < 4; i++) {
            controller.reThreadTurn();  
        }
    }
}
