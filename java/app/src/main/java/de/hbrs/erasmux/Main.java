package de.hbrs.erasmux;

import de.hbrs.erasmux.ManagePersonalImpl;
import de.hbrs.erasmux.task.ManagePersonalUI;

public class Main {
    public static void main(String[] args) {
        ManagePersonalUI managePersonalUI = new ManagePersonalUI(new ManagePersonalImpl());
        managePersonalUI.start();
    }
}
