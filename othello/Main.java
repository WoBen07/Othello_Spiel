package othello;

import othello.controller.OthelloController;
import othello.view.BoardView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        beautifyUI();
        OthelloController.instance();
    }

    /**
     * A little bit of black magic never hurt anyone
     */
    private static void beautifyUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            System.err.println("Error during startup. UI customisation seems to have failed");
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }

        for (var font : GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts()) {
            if (!font.getName().equals("Comic Sans MS")) continue;
            setGlobalFont(font.deriveFont(15f));
            break;
        }
    }

    /**
     * Sets the font for all ui components
     */
    private static void setGlobalFont(Font font) {
        // Thank the lord for Stackoverflow
        for (var key : UIManager.getDefaults().keySet()) {
            var value = UIManager.get(key);

            if (value instanceof javax.swing.plaf.FontUIResource) {
                UIManager.put(key, font);
            }
        }
    }
}