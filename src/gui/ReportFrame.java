package gui;

import model.Student;
import service.MarksService;
import service.ReportService;
import service.StudentService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ReportFrame extends JFrame {

    private StudentService studentService;
    private MarksService marksService;
    private ReportService reportService;

    private JTextField studentIdField;
    private JTextArea reportArea;

    // =====================================================
    // COLORS
    // =====================================================

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

    public ReportFrame(
            StudentService studentService,
            MarksService marksService) {

        this.studentService = studentService;
        this.marksService = marksService;

        this.reportService =
                new ReportService(marksService);

        setTitle(
                "Student Performance System - Reports"
        );

        setSize(900, 650);

        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        setLocationRelativeTo(null);

        createUI();
    }

    // =====================================================
    // CREATE UI
    // =====================================================

    private void createUI() {

        JPanel mainPanel =
                new JPanel(
                        new BorderLayout(15, 15)
                );

        mainPanel.setBackground(
                BACKGROUND
        );

        mainPanel.setBorder(
                new EmptyBorder(
                        20,
                        20,
                        20,
                        20
                )
        );

        // =================================================
        // HEADER
        // =================================================

        JPanel headerPanel =
                new JPanel(
                        new BorderLayout()
                );

        headerPanel.setBackground(
                BACKGROUND
        );

        JLabel titleLabel =
                new JLabel(
                        "Performance Reports"
                );

        titleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        28
                )
        );

        titleLabel.setForeground(
                TEXT
        );

        JLabel subtitleLabel =
                new JLabel(
                        "Generate detailed academic performance reports"
                );

        subtitleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        subtitleLabel.setForeground(
                SECONDARY_TEXT
        );

        JPanel titlePanel =
                new JPanel();

        titlePanel.setLayout(
                new BoxLayout(
                        titlePanel,
                        BoxLayout.Y_AXIS
                )
        );

        titlePanel.setBackground(
                BACKGROUND
        );

        titlePanel.add(titleLabel);

        titlePanel.add(
                Box.createVerticalStrut(4)
        );

        titlePanel.add(subtitleLabel);

        headerPanel.add(
                titlePanel,
                BorderLayout.WEST
        );

        mainPanel.add(
                headerPanel,
                BorderLayout.NORTH
        );

        // =================================================
        // CENTER
        // =================================================

        JPanel centerPanel =
                new JPanel(
                        new BorderLayout(15, 15)
                );

        centerPanel.setBackground(
                BACKGROUND
        );

        // =================================================
        // SEARCH CARD
        // =================================================

        JPanel searchCard =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.LEFT,
                                12,
                                15
                        )
                );

        searchCard.setBackground(
                CARD
        );

        searchCard.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        new EmptyBorder(
                                5,
                                15,
                                5,
                                15
                        )
                )
        );

        JLabel idLabel =
                new JLabel(
                        "Student ID"
                );

        idLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );

        idLabel.setForeground(
                TEXT
        );

        studentIdField =
                new JTextField(12);

        studentIdField.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        studentIdField.setPreferredSize(
                new Dimension(
                        150,
                        38
                )
        );

        studentIdField.setBorder(
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

        JButton generateButton =
                createButton(
                        "Generate Report",
                        PRIMARY
                );

        JButton clearButton =
                createButton(
                        "Clear",
                        Color.WHITE
                );

        clearButton.setForeground(
                TEXT
        );

        clearButton.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        new EmptyBorder(
                                9,
                                18,
                                9,
                                18
                        )
                )
        );

        searchCard.add(idLabel);

        searchCard.add(studentIdField);

        searchCard.add(generateButton);

        searchCard.add(clearButton);

        centerPanel.add(
                searchCard,
                BorderLayout.NORTH
        );

        // =================================================
        // REPORT CARD
        // =================================================

        JPanel reportCard =
                new JPanel(
                        new BorderLayout()
                );

        reportCard.setBackground(
                CARD
        );

        reportCard.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        new EmptyBorder(
                                15,
                                15,
                                15,
                                15
                        )
                )
        );

        JLabel reportTitle =
                new JLabel(
                        "Performance Report"
                );

        reportTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );

        reportTitle.setForeground(
                TEXT
        );

        reportTitle.setBorder(
                new EmptyBorder(
                        0,
                        0,
                        12,
                        0
                )
        );

        reportCard.add(
                reportTitle,
                BorderLayout.NORTH
        );

        // =================================================
        // REPORT AREA
        // =================================================

        reportArea =
                new JTextArea();

        reportArea.setEditable(false);

        reportArea.setFont(
                new Font(
                        "Monospaced",
                        Font.PLAIN,
                        14
                )
        );

        reportArea.setForeground(
                TEXT
        );

        reportArea.setBackground(
                new Color(
                        248,
                        250,
                        252
                )
        );

        reportArea.setLineWrap(false);

        reportArea.setWrapStyleWord(false);

        reportArea.setBorder(
                new EmptyBorder(
                        15,
                        15,
                        15,
                        15
                )
        );

        JScrollPane scrollPane =
                new JScrollPane(
                        reportArea
                );

        scrollPane.setBorder(
                BorderFactory.createLineBorder(
                        BORDER
                )
        );

        reportCard.add(
                scrollPane,
                BorderLayout.CENTER
        );

        centerPanel.add(
                reportCard,
                BorderLayout.CENTER
        );

        mainPanel.add(
                centerPanel,
                BorderLayout.CENTER
        );

        // =================================================
        // BUTTON ACTIONS
        // =================================================

        generateButton.addActionListener(
                e -> generateReport()
        );

        clearButton.addActionListener(
                e -> clearReport()
        );

        // Press ENTER to generate
        studentIdField.addActionListener(
                e -> generateReport()
        );

        add(mainPanel);
    }

    // =====================================================
    // CREATE BUTTON
    // =====================================================

    private JButton createButton(
            String text,
            Color background) {

        JButton button =
                new JButton(text);

        button.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );

        button.setBackground(
                background
        );

        button.setForeground(
                Color.WHITE
        );

        button.setFocusPainted(
                false
        );

        button.setBorder(
                BorderFactory.createEmptyBorder(
                        10,
                        18,
                        10,
                        18
                )
        );

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        return button;
    }

    // =====================================================
    // GENERATE REPORT
    // =====================================================

    private void generateReport() {

        try {

            String text =
                    studentIdField
                            .getText()
                            .trim();

            if (text.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter a Student ID.",
                        "Input Required",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            int studentId =
                    Integer.parseInt(text);

            Student student =
                    studentService.findStudentById(
                            studentId
                    );

            if (student == null) {

                reportArea.setText(
                        "STUDENT NOT FOUND\n"
                                + "========================\n\n"
                                + "No student exists with ID: "
                                + studentId
                );

                return;
            }

            String report =
                    reportService.generateStudentReport(
                            student.getId(),
                            student.getName()
                    );

            reportArea.setText(report);

            reportArea.setCaretPosition(0);

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid numeric Student ID.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error generating report:\n"
                            + e.getMessage(),
                    "Report Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // =====================================================
    // CLEAR
    // =====================================================

    private void clearReport() {

        studentIdField.setText("");

        reportArea.setText("");

        studentIdField.requestFocus();
    }
}