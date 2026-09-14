package gui;

import exception.InvalidMarksException;
import model.Marks;
import service.MarksService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MarksFrame extends JFrame {

    private MarksService marksService;

    private JTextField studentIdField;
    private JTextField subjectCodeField;
    private JTextField marksField;
    private JTextField maxMarksField;

    private JTable marksTable;
    private DefaultTableModel tableModel;

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

    public MarksFrame(MarksService marksService) {

        this.marksService = marksService;

        setTitle("Student Performance System - Marks");
        setSize(1000, 650);

        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        setLocationRelativeTo(null);

        createUI();

        // Load existing marks from marks.csv
        refreshTable();
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
                        "Marks Management"
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
                        "Add and view student academic performance"
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
        // CENTER PANEL
        // =================================================

        JPanel centerPanel =
                new JPanel(
                        new BorderLayout(15, 15)
                );

        centerPanel.setBackground(
                BACKGROUND
        );

        // =================================================
        // INPUT CARD
        // =================================================

        JPanel formCard =
                new JPanel();

        formCard.setBackground(
                CARD
        );

        formCard.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        new EmptyBorder(
                                18,
                                18,
                                18,
                                18
                        )
                )
        );

        formCard.setPreferredSize(
                new Dimension(
                        250,
                        0
                )
        );

        formCard.setLayout(
                new BoxLayout(
                        formCard,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel formTitle =
                new JLabel(
                        "Enter Marks"
                );

        formTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );

        formTitle.setForeground(
                TEXT
        );

        formCard.add(formTitle);

        formCard.add(
                Box.createVerticalStrut(20)
        );

        // Student ID
        formCard.add(
                createLabel("Student ID")
        );

        studentIdField =
                createTextField();

        formCard.add(studentIdField);

        formCard.add(
                Box.createVerticalStrut(14)
        );

        // Subject
        formCard.add(
                createLabel("Subject Code")
        );

        subjectCodeField =
                createTextField();

        formCard.add(subjectCodeField);

        formCard.add(
                Box.createVerticalStrut(14)
        );

        // Marks
        formCard.add(
                createLabel("Marks Obtained")
        );

        marksField =
                createTextField();

        formCard.add(marksField);

        formCard.add(
                Box.createVerticalStrut(14)
        );

        // Maximum Marks
        formCard.add(
                createLabel("Maximum Marks")
        );

        maxMarksField =
                createTextField();

        maxMarksField.setText("100");

        formCard.add(maxMarksField);

        centerPanel.add(
                formCard,
                BorderLayout.WEST
        );

        // =================================================
        // TABLE CARD
        // =================================================

        JPanel tableCard =
                new JPanel(
                        new BorderLayout()
                );

        tableCard.setBackground(
                CARD
        );

        tableCard.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        new EmptyBorder(
                                12,
                                12,
                                12,
                                12
                        )
                )
        );

        String[] columns = {
                "Student ID",
                "Subject",
                "Marks",
                "Max Marks",
                "Percentage",
                "Grade"
        };

        tableModel =
                new DefaultTableModel(
                        columns,
                        0
                ) {

                    @Override
                    public boolean isCellEditable(
                            int row,
                            int column) {

                        return false;
                    }
                };

        marksTable =
                new JTable(tableModel);

        marksTable.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        marksTable.setRowHeight(30);

        marksTable.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );

        marksTable.setShowGrid(false);

        marksTable.setIntercellSpacing(
                new Dimension(
                        0,
                        0
                )
        );

        marksTable.getTableHeader()
                .setFont(
                        new Font(
                                "Segoe UI",
                                Font.BOLD,
                                13
                        )
                );

        marksTable.getTableHeader()
                .setBackground(
                        new Color(
                                241,
                                245,
                                249
                        )
                );

        marksTable.getTableHeader()
                .setForeground(
                        TEXT
                );

        marksTable.getTableHeader()
                .setPreferredSize(
                        new Dimension(
                                0,
                                35
                        )
                );

        // Center table values
        DefaultTableCellRenderer centerRenderer =
                new DefaultTableCellRenderer();

        centerRenderer.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        for (int i = 0;
             i < marksTable.getColumnCount();
             i++) {

            marksTable
                    .getColumnModel()
                    .getColumn(i)
                    .setCellRenderer(
                            centerRenderer
                    );
        }

        JScrollPane scrollPane =
                new JScrollPane(
                        marksTable
                );

        scrollPane.setBorder(
                BorderFactory.createEmptyBorder()
        );

        tableCard.add(
                scrollPane,
                BorderLayout.CENTER
        );

        centerPanel.add(
                tableCard,
                BorderLayout.CENTER
        );

        mainPanel.add(
                centerPanel,
                BorderLayout.CENTER
        );

        // =================================================
        // BUTTON PANEL
        // =================================================

        JPanel buttonPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT,
                                10,
                                0
                        )
                );

        buttonPanel.setBackground(
                BACKGROUND
        );

        JButton addButton =
                createButton(
                        "Add Marks",
                        PRIMARY
                );

        JButton viewButton =
                createButton(
                        "View Student Marks",
                        new Color(
                                71,
                                85,
                                105
                        )
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

        buttonPanel.add(
                clearButton
        );

        buttonPanel.add(
                viewButton
        );

        buttonPanel.add(
                addButton
        );

        mainPanel.add(
                buttonPanel,
                BorderLayout.SOUTH
        );

        // =================================================
        // BUTTON ACTIONS
        // =================================================

        addButton.addActionListener(
                e -> addMarks()
        );

        viewButton.addActionListener(
                e -> viewStudentMarks()
        );

        clearButton.addActionListener(
                e -> clearFields()
        );

        add(mainPanel);
    }

    // =====================================================
    // CREATE LABEL
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
    // CREATE TEXT FIELD
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
    // ADD MARKS
    // =====================================================

    private void addMarks() {

        try {

            int studentId =
                    Integer.parseInt(
                            studentIdField
                                    .getText()
                                    .trim()
                    );

            String subjectCode =
                    subjectCodeField
                            .getText()
                            .trim();

            double marksObtained =
                    Double.parseDouble(
                            marksField
                                    .getText()
                                    .trim()
                    );

            double maxMarks =
                    Double.parseDouble(
                            maxMarksField
                                    .getText()
                                    .trim()
                    );

            if (subjectCode.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter the subject code.",
                        "Invalid Input",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            if (maxMarks <= 0) {

                throw new InvalidMarksException(
                        "Maximum marks must be greater than 0."
                );
            }

            if (marksObtained < 0
                    || marksObtained > maxMarks) {

                throw new InvalidMarksException(
                        "Marks must be between 0 and "
                                + maxMarks
                );
            }

            Marks marks =
                    new Marks(
                            studentId,
                            subjectCode,
                            marksObtained,
                            maxMarks
                    );

            // This also saves to marks.csv
            marksService.addMarks(marks);

            refreshTable();

            clearFields();

            JOptionPane.showMessageDialog(
                    this,
                    "Marks added successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid numbers.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE
            );

        } catch (InvalidMarksException e) {

            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage(),
                    "Invalid Marks",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // =====================================================
    // VIEW STUDENT MARKS
    // =====================================================

    private void viewStudentMarks() {

        try {

            int studentId =
                    Integer.parseInt(
                            studentIdField
                                    .getText()
                                    .trim()
                    );

            tableModel.setRowCount(0);

            for (Marks marks :
                    marksService
                            .getMarksByStudent(
                                    studentId
                            )) {

                addRowToTable(marks);
            }

            if (tableModel.getRowCount() == 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "No marks found for Student ID: "
                                + studentId,
                        "No Results",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Enter a valid Student ID.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // =====================================================
    // REFRESH TABLE
    // =====================================================

    private void refreshTable() {

        if (tableModel == null) {
            return;
        }

        tableModel.setRowCount(0);

        for (Marks marks :
                marksService.getAllMarks()) {

            addRowToTable(marks);
        }
    }

    // =====================================================
    // ADD ROW
    // =====================================================

    private void addRowToTable(
            Marks marks) {

        tableModel.addRow(
                new Object[]{
                        marks.getStudentId(),
                        marks.getSubjectCode(),
                        marks.getMarksObtained(),
                        marks.getMaxMarks(),
                        String.format(
                                "%.2f%%",
                                marks.getPercentage()
                        ),
                        marks.getGrade()
                }
        );
    }

    // =====================================================
    // CLEAR FIELDS
    // =====================================================

    private void clearFields() {

        studentIdField.setText("");
        subjectCodeField.setText("");
        marksField.setText("");
        maxMarksField.setText("100");

        marksTable.clearSelection();

        // Show all marks again after clearing
        refreshTable();
    }
}