public class TwinklePlayer {
    public static void main(String[] args) {
        System.out.println("Playing Twinkle Twinkle Little Star...");
        System.out.println("Song sequence:");
        System.out.println("do do sol| sol| la la sol| fa fa mi mi re re do");
        System.out.println("sol| sol| fa fa mi mi re sol| sol| fa fa mi mi re");
        System.out.println("do do sol| sol| la la sol| fa fa mi mi re re do");
        System.out.println("\nThread 1 plays: do, mi, sol-octave");
        System.out.println("Thread 2 plays: re, fa, la");
        System.out.println("\nStarting playback...\n");
        
        TwinkleSynchronizer controller = new TwinkleSynchronizer();
        
        Thread1 thread1 = new Thread1(controller);
        Thread t1 = new Thread(thread1);
        
        Thread2 thread2 = new Thread2(controller);
        Thread t2 = new Thread(thread2);
        
        t1.start();
        t2.start();
        
        try {
            t1.join();
            t2.join();
            System.out.println("\nSong complete!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


