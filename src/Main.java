import gui.LoginFrame;
import service.MarksService;
import service.StudentService;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        StudentService studentService =
                new StudentService();

        MarksService marksService =
                new MarksService();

        SwingUtilities.invokeLater(() -> {

            LoginFrame loginFrame =
                    new LoginFrame(
                            studentService,
                            marksService
                    );

            loginFrame.setVisible(true);
        });
    }
}