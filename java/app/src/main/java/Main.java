import secondVersion.ManagePersonalImpl;
import task.ManagePersonalUI;

public class Main {
    public static void main(String[] args) {
        ManagePersonalUI managePersonalUI = new ManagePersonalUI(new ManagePersonalImpl());
        managePersonalUI.start();
    }
}
