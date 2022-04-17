package Thread;

public class AnimationThread extends Thread {

    private String[] months = {"January", "Ferbruary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };


    public AnimationThread() {

    }

    public void run() {
        while(true) {
            try{
                Thread.sleep(1000);


            } catch(Exception e) {

            }
        }
    }
}
