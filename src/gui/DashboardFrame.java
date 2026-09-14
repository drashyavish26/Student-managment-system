package gui;

import service.MarksService;
import service.StudentService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DashboardFrame extends JFrame {

    private StudentService studentService;
    private MarksService marksService;

    private StudentFrame studentFrame;
    private MarksFrame marksFrame;
    private ReportFrame reportFrame;

    // Modern UI fonts
    private final Font TITLE_FONT =
            new Font("Segoe UI", Font.BOLD, 26);

    private final Font SUBTITLE_FONT =
            new Font("Segoe UI", Font.PLAIN, 14);

    private final Font BUTTON_FONT =
            new Font("Segoe UI", Font.BOLD, 15);

    public DashboardFrame(
            StudentService studentService,
            MarksService marksService) {

        this.studentService = studentService;
        this.marksService = marksService;

        setTitle("Student Performance System");
        setSize(950, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        createUI();
    }

    private void createUI() {

        JPanel mainPanel =
                new JPanel(new BorderLayout());

        mainPanel.setBackground(
                new Color(245, 247, 250)
        );

        // =====================================================
        // SIDEBAR
        // =====================================================

        JPanel sidebar =
                new JPanel();

        sidebar.setPreferredSize(
                new Dimension(220, 600)
        );

        sidebar.setBackground(
                new Color(30, 41, 59)
        );

        sidebar.setLayout(
                new BoxLayout(
                        sidebar,
                        BoxLayout.Y_AXIS
                )
        );

        sidebar.setBorder(
                new EmptyBorder(
                        25, 15, 25, 15
                )
        );

        // Logo / Application name

        JLabel logo =
                new JLabel("🎓  Student System");

        logo.setForeground(Color.WHITE);
        logo.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );

        logo.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        sidebar.add(logo);

        sidebar.add(
                Box.createVerticalStrut(45)
        );

        // Sidebar buttons

        JButton dashboardButton =
                createSidebarButton(
                        "🏠  Dashboard"
                );

        JButton studentsButton =
                createSidebarButton(
                        "👨‍🎓  Students"
                );

        JButton marksButton =
                createSidebarButton(
                        "📝  Marks"
                );

        JButton reportsButton =
                createSidebarButton(
                        "📊  Reports"
                );

        JButton logoutButton =
                createSidebarButton(
                        "🚪  Logout"
                );

        sidebar.add(dashboardButton);
        sidebar.add(Box.createVerticalStrut(10));

        sidebar.add(studentsButton);
        sidebar.add(Box.createVerticalStrut(10));

        sidebar.add(marksButton);
        sidebar.add(Box.createVerticalStrut(10));

        sidebar.add(reportsButton);

        sidebar.add(
                Box.createVerticalGlue()
        );

        sidebar.add(logoutButton);

        // =====================================================
        // MAIN CONTENT
        // =====================================================

        JPanel contentPanel =
                new JPanel(new BorderLayout());

        contentPanel.setBackground(
                new Color(245, 247, 250)
        );

        contentPanel.setBorder(
                new EmptyBorder(
                        30, 35, 30, 35
                )
        );

        // Header

        JPanel headerPanel =
                new JPanel(
                        new BorderLayout()
                );

        headerPanel.setOpaque(false);

        JLabel title =
                new JLabel(
                        "Welcome to Dashboard 👋"
                );

        title.setFont(TITLE_FONT);

        title.setForeground(
                new Color(15, 23, 42)
        );

        JLabel subtitle =
                new JLabel(
                        "Manage students, marks and performance reports"
                );

        subtitle.setFont(SUBTITLE_FONT);

        subtitle.setForeground(
                new Color(100, 116, 139)
        );

        JPanel heading =
                new JPanel();

        heading.setOpaque(false);

        heading.setLayout(
                new BoxLayout(
                        heading,
                        BoxLayout.Y_AXIS
                )
        );

        heading.add(title);

        heading.add(
                Box.createVerticalStrut(5)
        );

        heading.add(subtitle);

        headerPanel.add(
                heading,
                BorderLayout.WEST
        );

        contentPanel.add(
                headerPanel,
                BorderLayout.NORTH
        );

        // =====================================================
        // CARDS
        // =====================================================

        JPanel cardsPanel =
                new JPanel(
                        new GridLayout(
                                1,
                                2,
                                20,
                                20
                        )
                );

        cardsPanel.setOpaque(false);

        int studentCount =
                studentService.getStudentCount();

        JPanel studentCard =
                createCard(
                        "👨‍🎓",
                        "Total Students",
                        String.valueOf(studentCount)
                );

        JPanel marksCard =
                createCard(
                        "📝",
                        "Marks Management",
                        "Manage"
                );

        cardsPanel.add(studentCard);
        cardsPanel.add(marksCard);

        // =====================================================
        // REPORT CARD
        // =====================================================

        JPanel reportCard =
                createLargeCard(
                        "📊  Performance Reports",
                        "Generate detailed performance reports for students"
                );

        JPanel centerPanel =
                new JPanel(
                        new BorderLayout(
                                0,
                                25
                        )
                );

        centerPanel.setOpaque(false);

        centerPanel.add(
                cardsPanel,
                BorderLayout.NORTH
        );

        centerPanel.add(
                reportCard,
                BorderLayout.CENTER
        );

        contentPanel.add(
                centerPanel,
                BorderLayout.CENTER
        );

        // =====================================================
        // BUTTON ACTIONS
        // =====================================================

        studentsButton.addActionListener(
                e -> openStudents()
        );

        marksButton.addActionListener(
                e -> openMarks()
        );

        reportsButton.addActionListener(
                e -> openReports()
        );

        // Dashboard button

        dashboardButton.addActionListener(
                e -> {
                    setVisible(true);
                    refreshDashboard();
                }
        );

        // Logout

        logoutButton.addActionListener(
                e -> logout()
        );

        add(sidebar, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);
    }

    // =========================================================
    // SIDEBAR BUTTON
    // =========================================================

    private JButton createSidebarButton(
            String text) {

        JButton button =
                new JButton(text);

        button.setFont(BUTTON_FONT);
        button.setForeground(Color.WHITE);

        button.setBackground(
                new Color(30, 41, 59)
        );

        button.setBorder(
                BorderFactory.createEmptyBorder(
                        12, 10, 12, 10
                )
        );

        button.setFocusPainted(false);
        button.setHorizontalAlignment(
                SwingConstants.LEFT
        );

        button.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        button.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        50
                )
        );

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        return button;
    }

    // =========================================================
    // SMALL CARD
    // =========================================================

    private JPanel createCard(
            String icon,
            String title,
            String value) {

        JPanel card =
                new JPanel();

        card.setBackground(Color.WHITE);

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(226, 232, 240)
                        ),
                        new EmptyBorder(
                                20, 20, 20, 20
                        )
                )
        );

        card.setLayout(
                new BoxLayout(
                        card,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel iconLabel =
                new JLabel(icon);

        iconLabel.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.PLAIN,
                        25
                )
        );

        JLabel titleLabel =
                new JLabel(title);

        titleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        titleLabel.setForeground(
                new Color(100, 116, 139)
        );

        JLabel valueLabel =
                new JLabel(value);

        valueLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        25
                )
        );

        valueLabel.setForeground(
                new Color(15, 23, 42)
        );

        card.add(iconLabel);

        card.add(
                Box.createVerticalStrut(8)
        );

        card.add(titleLabel);

        card.add(
                Box.createVerticalStrut(5)
        );

        card.add(valueLabel);

        return card;
    }

    // =========================================================
    // LARGE REPORT CARD
    // =========================================================

    private JPanel createLargeCard(
            String title,
            String description) {

        JPanel card =
                new JPanel(
                        new BorderLayout()
                );

        card.setBackground(Color.WHITE);

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(226, 232, 240)
                        ),
                        new EmptyBorder(
                                25, 25, 25, 25
                        )
                )
        );

        JLabel titleLabel =
                new JLabel(title);

        titleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        20
                )
        );

        titleLabel.setForeground(
                new Color(15, 23, 42)
        );

        JLabel descriptionLabel =
                new JLabel(description);

        descriptionLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        descriptionLabel.setForeground(
                new Color(100, 116, 139)
        );

        JPanel textPanel =
                new JPanel();

        textPanel.setOpaque(false);

        textPanel.setLayout(
                new BoxLayout(
                        textPanel,
                        BoxLayout.Y_AXIS
                )
        );

        textPanel.add(titleLabel);

        textPanel.add(
                Box.createVerticalStrut(8)
        );

        textPanel.add(descriptionLabel);

        card.add(
                textPanel,
                BorderLayout.CENTER
        );

        JButton openButton =
                new JButton("Open Reports →");

        openButton.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );

        openButton.setFocusPainted(false);

        openButton.addActionListener(
                e -> openReports()
        );

        card.add(
                openButton,
                BorderLayout.EAST
        );

        return card;
    }

    // =========================================================
    // OPEN STUDENTS
    // =========================================================

    private void openStudents() {

        if (studentFrame == null ||
                !studentFrame.isDisplayable()) {

            studentFrame =
                    new StudentFrame(
                            studentService
                    );

            studentFrame.addWindowListener(
                    new WindowAdapter() {

                        @Override
                        public void windowClosed(
                                WindowEvent e) {

                            showDashboard();
                        }
                    }
            );
        }

        setVisible(false);
        studentFrame.setVisible(true);
    }

    // =========================================================
    // OPEN MARKS
    // =========================================================

    private void openMarks() {

        if (marksFrame == null ||
                !marksFrame.isDisplayable()) {

            marksFrame =
                    new MarksFrame(
                            marksService
                    );

            marksFrame.addWindowListener(
                    new WindowAdapter() {

                        @Override
                        public void windowClosed(
                                WindowEvent e) {

                            showDashboard();
                        }
                    }
            );
        }

        setVisible(false);
        marksFrame.setVisible(true);
    }

    // =========================================================
    // OPEN REPORTS
    // =========================================================

    private void openReports() {

        if (reportFrame == null ||
                !reportFrame.isDisplayable()) {

            reportFrame =
                    new ReportFrame(
                            studentService,
                            marksService
                    );

            reportFrame.addWindowListener(
                    new WindowAdapter() {

                        @Override
                        public void windowClosed(
                                WindowEvent e) {

                            showDashboard();
                        }
                    }
            );
        }

        setVisible(false);
        reportFrame.setVisible(true);
    }

    // =========================================================
    // REFRESH DASHBOARD
    // =========================================================

    private void refreshDashboard() {

        getContentPane().revalidate();
        getContentPane().repaint();
    }

    // =========================================================
    // SHOW DASHBOARD
    // =========================================================

    private void showDashboard() {

        setLocationRelativeTo(null);
        setVisible(true);
        refreshDashboard();
    }

    // =========================================================
    // LOGOUT
    // =========================================================

    private void logout() {

        int choice =
                JOptionPane.showConfirmDialog(
                        this,
                        "Are you sure you want to logout?",
                        "Logout",
                        JOptionPane.YES_NO_OPTION
                );

        if (choice ==
                JOptionPane.YES_OPTION) {

            dispose();

            LoginFrame loginFrame =
                    new LoginFrame(
                            studentService,
                            marksService
                    );

            loginFrame.setVisible(true);
        }
    }
}