package dev.lhpnd.graphflow.ui;

import dev.lhpnd.graphflow.util.MailUtils;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class CustomDialog{

    public static String getEmail(ApplicationContext applicationContext) {
        ImageIcon emailIcon = new ImageIcon();
        try {
            emailIcon = new ImageIcon(new ImageIcon(new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRwBFtMJONsY-lCR13YzYSYstsZMGwxGtZxOw&usqp=CAU"))
                    .getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        }
        String result = (String)JOptionPane.showInputDialog(
                applicationContext,
                "Enter your email:",
                "Send image to email",
                JOptionPane.INFORMATION_MESSAGE,
                emailIcon,
                null,
                "tunaudam@yopmail.com"
        );
        return result;
    }

}
