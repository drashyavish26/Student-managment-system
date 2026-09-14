package gui;

import service.MarksService;
import service.StudentService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    private StudentService studentService;
    private MarksService marksService;

    // =====================================================
    // COLORS
    // =====================================================

    private final Color SIDEBAR =
            new Color(30, 41, 59);

    private final Color BACKGROUND =
            new Color(245, 247, 250);

    private final Color CARD =
            Color.WHITE;

    private final Color TEXT =
            new Color(15, 23, 42);

    private final Color SECONDARY_TEXT =
            new Color(100, 116, 139);

    private final Color BORDER =
            new Color(226, 232, 240);

    private final Color PRIMARY =
            new Color(37, 99, 235);

    // =====================================================
    // CONSTRUCTOR
    // =====================================================

    public LoginFrame(
            StudentService studentService,
            MarksService marksService) {

        this.studentService = studentService;
        this.marksService = marksService;

        setTitle(
                "Student Performance System - Login"
        );

        setSize(850, 520);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

        setResizable(false);

        createUI();
    }

    // =====================================================
    // CREATE UI
    // =====================================================

    private void createUI() {

        JPanel mainPanel =
                new JPanel(
                        new GridLayout(1, 2)
                );

        // =================================================
        // LEFT SIDE
        // =================================================

        JPanel leftPanel =
                new JPanel();

        leftPanel.setBackground(
                SIDEBAR
        );

        leftPanel.setLayout(
                new BoxLayout(
                        leftPanel,
                        BoxLayout.Y_AXIS
                )
        );

        leftPanel.setBorder(
                new EmptyBorder(
                        60,
                        45,
                        60,
                        45
                )
        );

        JLabel logoLabel =
                new JLabel(
                        "🎓"
                );

        logoLabel.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.PLAIN,
                        55
                )
        );

        logoLabel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        JLabel titleLabel =
                new JLabel(
                        "Student Performance"
                );

        titleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        30
                )
        );

        titleLabel.setForeground(
                Color.WHITE
        );

        titleLabel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        JLabel systemLabel =
                new JLabel(
                        "Management System"
                );

        systemLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        30
                )
        );

        systemLabel.setForeground(
                Color.WHITE
        );

        systemLabel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        JLabel descriptionLabel =
                new JLabel(
                        "<html>Manage students, marks and<br>"
                                + "performance reports easily.</html>"
                );

        descriptionLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        15
                )
        );

        descriptionLabel.setForeground(
                new Color(
                        203,
                        213,
                        225
                )
        );

        descriptionLabel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        leftPanel.add(logoLabel);

        leftPanel.add(
                Box.createVerticalStrut(30)
        );

        leftPanel.add(titleLabel);

        leftPanel.add(
                Box.createVerticalStrut(2)
        );

        leftPanel.add(systemLabel);

        leftPanel.add(
                Box.createVerticalStrut(20)
        );

        leftPanel.add(descriptionLabel);

        // =================================================
        // RIGHT SIDE
        // =================================================

        JPanel rightPanel =
                new JPanel(
                        new GridBagLayout()
                );

        rightPanel.setBackground(
                BACKGROUND
        );

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        gbc.insets =
                new Insets(
                        8,
                        0,
                        8,
                        0
                );

        gbc.weightx = 1;

        // =================================================
        // LOGIN CARD
        // =================================================

        JPanel loginCard =
                new JPanel();

        loginCard.setBackground(
                CARD
        );

        loginCard.setPreferredSize(
                new Dimension(
                        330,
                        370
                )
        );

        loginCard.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        new EmptyBorder(
                                30,
                                30,
                                30,
                                30
                        )
                )
        );

        loginCard.setLayout(
                new BoxLayout(
                        loginCard,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel loginTitle =
                new JLabel(
                        "Welcome Back"
                );

        loginTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        25
                )
        );

        loginTitle.setForeground(
                TEXT
        );

        loginTitle.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        JLabel loginSubtitle =
                new JLabel(
                        "Login to continue"
                );

        loginSubtitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        loginSubtitle.setForeground(
                SECONDARY_TEXT
        );

        loginSubtitle.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        // =================================================
        // USERNAME
        // =================================================

        JLabel usernameLabel =
                createLabel(
                        "Username"
                );

        usernameField =
                createTextField();

        // =================================================
        // PASSWORD
        // =================================================

        JLabel passwordLabel =
                createLabel(
                        "Password"
                );

        passwordField =
                new JPasswordField();

        passwordField.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        passwordField.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        40
                )
        );

        passwordField.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        new EmptyBorder(
                                5,
                                10,
                                5,
                                10
                        )
                )
        );

        // =================================================
        // LOGIN BUTTON
        // =================================================

        JButton loginButton =
                new JButton(
                        "Login"
                );

        loginButton.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );

        loginButton.setForeground(
                Color.WHITE
        );

        loginButton.setBackground(
                PRIMARY
        );

        loginButton.setFocusPainted(
                false
        );

        loginButton.setBorder(
                BorderFactory.createEmptyBorder(
                        11,
                        20,
                        11,
                        20
                )
        );

        loginButton.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        42
                )
        );

        loginButton.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        // =================================================
        // ADD COMPONENTS
        // =================================================

        loginCard.add(loginTitle);

        loginCard.add(
                Box.createVerticalStrut(5)
        );

        loginCard.add(loginSubtitle);

        loginCard.add(
                Box.createVerticalStrut(28)
        );

        loginCard.add(usernameLabel);

        loginCard.add(
                Box.createVerticalStrut(6)
        );

        loginCard.add(usernameField);

        loginCard.add(
                Box.createVerticalStrut(18)
        );

        loginCard.add(passwordLabel);

        loginCard.add(
                Box.createVerticalStrut(6)
        );

        loginCard.add(passwordField);

        loginCard.add(
                Box.createVerticalStrut(25)
        );

        loginCard.add(loginButton);

        gbc.gridx = 0;
        gbc.gridy = 0;

        rightPanel.add(
                loginCard,
                gbc
        );

        // =================================================
        // LOGIN ACTION
        // =================================================

        loginButton.addActionListener(
                e -> login()
        );

        // Press ENTER to login

        passwordField.addActionListener(
                e -> login()
        );

        mainPanel.add(leftPanel);

        mainPanel.add(rightPanel);

        add(mainPanel);
    }

    // =====================================================
    // LABEL
    // =====================================================

    private JLabel createLabel(
            String text) {

        JLabel label =
                new JLabel(text);

        label.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );

        label.setForeground(
                TEXT
        );

        label.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        return label;
    }

    // =====================================================
    // TEXT FIELD
    // =====================================================

    private JTextField createTextField() {

        JTextField field =
                new JTextField();

        field.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        field.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        40
                )
        );

        field.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        new EmptyBorder(
                                5,
                                10,
                                5,
                                10
                        )
                )
        );

        field.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        return field;
    }

    // =====================================================
    // LOGIN
    // =====================================================

    private void login() {

        String username =
                usernameField
                        .getText()
                        .trim();

        String password =
                new String(
                        passwordField
                                .getPassword()
                );

        if (username.equals("admin")
                && password.equals("admin123")) {

            JOptionPane.showMessageDialog(
                    this,
                    "Login successful!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );

            dispose();

            DashboardFrame dashboardFrame =
                    new DashboardFrame(
                            studentService,
                            marksService
                    );

            dashboardFrame.setVisible(
                    true
            );

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid username or password.",
                    "Login Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
} 