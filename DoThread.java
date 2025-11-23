public class DoThread implements Runnable{

    Synchronizer controller;


    DoThread(Synchronizer controller) {
        this.controller = controller;
    }

    @Override
    public void run(){
        for (int i = 0; i < 5; i++){
            controller.doThreadTurn();
       }
    }
}
