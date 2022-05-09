package UI.animation;

public class AnimationThread extends Thread {

    private ScrollingDate changeDate;
    public AnimationThread(ScrollingDate changeDate) {
        this.changeDate = changeDate;
    }

    public void run() {
        while(true) {
            try{
                Thread.sleep(1000);
                changeDate.getChangeDate().changeDate();
                changeDate.removeAll();
                changeDate.repaint();
            } catch(Exception e) {
                System.out.println(e);
            }
        }
    }
}
