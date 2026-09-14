package gui;

import model.Student;
import service.StudentService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StudentFrame extends JFrame {

    private StudentService studentService;

    private JTextField idField;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField courseField;

    private JTable studentTable;
    private DefaultTableModel tableModel;

    // =====================================================
    // SAME THEME AS DASHBOARD
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

    public StudentFrame(StudentService studentService) {

        this.studentService = studentService;

        setTitle("Student Management");
        setSize(950, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        createUI();
        refreshTable();
    }

    // =====================================================
    // MAIN UI
    // =====================================================

    private void createUI() {

        JPanel rootPanel =
                new JPanel(new BorderLayout());

        rootPanel.setBackground(BACKGROUND);

        // =================================================
        // SIDEBAR
        // =================================================

        JPanel sidebar =
                new JPanel();

        sidebar.setPreferredSize(
                new Dimension(220, 600)
        );

        sidebar.setBackground(SIDEBAR);

        sidebar.setBorder(
                new EmptyBorder(
                        25, 15, 25, 15
                )
        );

        sidebar.setLayout(
                new BoxLayout(
                        sidebar,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel logo =
                new JLabel(
                        "🎓  Student System"
                );

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

        // Current page indicator

        studentsButton.setBackground(
                new Color(51, 65, 85)
        );

        sidebar.add(dashboardButton);

        sidebar.add(
                Box.createVerticalStrut(10)
        );

        sidebar.add(studentsButton);

        sidebar.add(
                Box.createVerticalStrut(10)
        );

        sidebar.add(marksButton);

        sidebar.add(
                Box.createVerticalStrut(10)
        );

        sidebar.add(reportsButton);

        sidebar.add(
                Box.createVerticalGlue()
        );

        sidebar.add(logoutButton);

        // =================================================
        // CONTENT AREA
        // =================================================

        JPanel contentPanel =
                new JPanel(
                        new BorderLayout(
                                0,
                                20
                        )
                );

        contentPanel.setBackground(
                BACKGROUND
        );

        contentPanel.setBorder(
                new EmptyBorder(
                        30, 35, 30, 35
                )
        );

        // =================================================
        // HEADER
        // =================================================

        JPanel headerPanel =
                new JPanel();

        headerPanel.setOpaque(false);

        headerPanel.setLayout(
                new BoxLayout(
                        headerPanel,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel titleLabel =
                new JLabel(
                        "Student Management"
                );

        titleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        26
                )
        );

        titleLabel.setForeground(TEXT);

        JLabel subtitleLabel =
                new JLabel(
                        "Add, update, search and manage student records"
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

        headerPanel.add(titleLabel);

        headerPanel.add(
                Box.createVerticalStrut(5)
        );

        headerPanel.add(subtitleLabel);

        contentPanel.add(
                headerPanel,
                BorderLayout.NORTH
        );

        // =================================================
        // CENTER CONTENT
        // =================================================

        JPanel centerPanel =
                new JPanel(
                        new BorderLayout(
                                0,
                                15
                        )
                );

        centerPanel.setOpaque(false);

        // =================================================
        // FORM CARD
        // =================================================

        JPanel formCard =
                new JPanel(
                        new BorderLayout(
                                0,
                                15
                        )
                );

        formCard.setBackground(CARD);

        formCard.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        new EmptyBorder(
                                18,
                                20,
                                18,
                                20
                        )
                )
        );

        JLabel formTitle =
                new JLabel(
                        "Student Information"
                );

        formTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        17
                )
        );

        formTitle.setForeground(TEXT);

        formCard.add(
                formTitle,
                BorderLayout.NORTH
        );

        // =================================================
        // FORM FIELDS
        // =================================================

        JPanel formPanel =
                new JPanel(
                        new GridLayout(
                                2,
                                4,
                                15,
                                8
                        )
                );

        formPanel.setOpaque(false);

        idField = createTextField();
        nameField = createTextField();
        emailField = createTextField();
        courseField = createTextField();

        formPanel.add(
                createLabel("Student ID")
        );

        formPanel.add(
                createLabel("Name")
        );

        formPanel.add(
                createLabel("Email")
        );

        formPanel.add(
                createLabel("Course")
        );

        formPanel.add(idField);
        formPanel.add(nameField);
        formPanel.add(emailField);
        formPanel.add(courseField);

        formCard.add(
                formPanel,
                BorderLayout.CENTER
        );

        centerPanel.add(
                formCard,
                BorderLayout.NORTH
        );

        // =================================================
        // TABLE CARD
        // =================================================

        JPanel tableCard =
                new JPanel(
                        new BorderLayout(
                                0,
                                12
                        )
                );

        tableCard.setBackground(CARD);

        tableCard.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        new EmptyBorder(
                                18,
                                20,
                                18,
                                20
                        )
                )
        );

        JLabel tableTitle =
                new JLabel(
                        "Student Records"
                );

        tableTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        17
                )
        );

        tableTitle.setForeground(TEXT);

        tableCard.add(
                tableTitle,
                BorderLayout.NORTH
        );

        // =================================================
        // TABLE
        // =================================================

        String[] columns = {
                "ID",
                "Name",
                "Email",
                "Course"
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

        studentTable =
                new JTable(tableModel);

        studentTable.setRowHeight(30);

        studentTable.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        studentTable.setForeground(TEXT);

        studentTable.setSelectionBackground(
                new Color(219, 234, 254)
        );

        studentTable.setSelectionForeground(TEXT);

        studentTable.setGridColor(BORDER);

        studentTable.setShowVerticalLines(false);

        studentTable.setShowHorizontalLines(true);

        studentTable.getTableHeader()
                .setFont(
                        new Font(
                                "Segoe UI",
                                Font.BOLD,
                                13
                        )
                );

        studentTable.getTableHeader()
                .setBackground(
                        new Color(248, 250, 252)
                );

        studentTable.getTableHeader()
                .setForeground(TEXT);

        studentTable.getTableHeader()
                .setPreferredSize(
                        new Dimension(
                                0,
                                35
                        )
                );

        // Center ID column

        DefaultTableCellRenderer centerRenderer =
                new DefaultTableCellRenderer();

        centerRenderer.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        studentTable
                .getColumnModel()
                .getColumn(0)
                .setCellRenderer(
                        centerRenderer
                );

        JScrollPane scrollPane =
                new JScrollPane(
                        studentTable
                );

        scrollPane.setBorder(
                BorderFactory.createLineBorder(
                        BORDER
                )
        );

        tableCard.add(
                scrollPane,
                BorderLayout.CENTER
        );

        centerPanel.add(
                tableCard,
                BorderLayout.CENTER
        );

        contentPanel.add(
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

        buttonPanel.setOpaque(false);

        JButton addButton =
                createButton(
                        "Add",
                        PRIMARY
                );

        JButton updateButton =
                createButton(
                        "Update",
                        new Color(16, 185, 129)
                );

        JButton deleteButton =
                createButton(
                        "Delete",
                        new Color(220, 38, 38)
                );

        JButton searchButton =
                createButton(
                        "Search",
                        new Color(124, 58, 237)
                );

        JButton clearButton =
                createButton(
                        "Clear",
                        new Color(71, 85, 105)
                );

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(clearButton);

        contentPanel.add(
                buttonPanel,
                BorderLayout.SOUTH
        );

        // =================================================
        // BUTTON ACTIONS
        // =================================================

        addButton.addActionListener(
                e -> addStudent()
        );

        updateButton.addActionListener(
                e -> updateStudent()
        );

        deleteButton.addActionListener(
                e -> deleteStudent()
        );

        searchButton.addActionListener(
                e -> searchStudent()
        );

        clearButton.addActionListener(
                e -> clearFields()
        );

        // =================================================
        // SIDEBAR NAVIGATION
        // =================================================

        dashboardButton.addActionListener(e -> {

            dispose();

            new DashboardFrame(
                    studentService,
                    null
            ).setVisible(true);
        });

        marksButton.addActionListener(e -> {

            // Marks navigation will be connected
            // after we finalize the MarksFrame.
        });

        reportsButton.addActionListener(e -> {

            // Reports navigation will be connected
            // from the dashboard.
        });

        logoutButton.addActionListener(e -> {

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

                // Login navigation remains available
                // through the main dashboard flow.
            }
        });

        // =================================================
        // TABLE SELECTION
        // =================================================

        studentTable
                .getSelectionModel()
                .addListSelectionListener(e -> {

                    if (!e.getValueIsAdjusting()) {

                        int selectedRow =
                                studentTable
                                        .getSelectedRow();

                        if (selectedRow >= 0) {

                            idField.setText(
                                    tableModel
                                            .getValueAt(
                                                    selectedRow,
                                                    0
                                            )
                                            .toString()
                            );

                            nameField.setText(
                                    tableModel
                                            .getValueAt(
                                                    selectedRow,
                                                    1
                                            )
                                            .toString()
                            );

                            emailField.setText(
                                    tableModel
                                            .getValueAt(
                                                    selectedRow,
                                                    2
                                            )
                                            .toString()
                            );

                            courseField.setText(
                                    tableModel
                                            .getValueAt(
                                                    selectedRow,
                                                    3
                                            )
                                            .toString()
                            );
                        }
                    }
                });

        rootPanel.add(
                sidebar,
                BorderLayout.WEST
        );

        rootPanel.add(
                contentPanel,
                BorderLayout.CENTER
        );

        add(rootPanel);
    }

    // =====================================================
    // SIDEBAR BUTTON
    // =====================================================

    private JButton createSidebarButton(
            String text) {

        JButton button =
                new JButton(text);

        button.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );

        button.setForeground(Color.WHITE);

        button.setBackground(SIDEBAR);

        button.setFocusPainted(false);

        button.setBorder(
                BorderFactory.createEmptyBorder(
                        12,
                        10,
                        12,
                        10
                )
        );

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

        field.setPreferredSize(
                new Dimension(
                        150,
                        35
                )
        );

        field.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        new EmptyBorder(
                                5,
                                8,
                                5,
                                8
                        )
                )
        );

        return field;
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
                        12
                )
        );

        label.setForeground(
                SECONDARY_TEXT
        );

        return label;
    }

    // =====================================================
    // BUTTON
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

        button.setForeground(Color.WHITE);

        button.setBackground(background);

        button.setFocusPainted(false);

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
    // ADD STUDENT
    // =====================================================

    private void addStudent() {

        try {

            int id =
                    Integer.parseInt(
                            idField.getText().trim()
                    );

            String name =
                    nameField.getText().trim();

            String email =
                    emailField.getText().trim();

            String course =
                    courseField.getText().trim();

            if (name.isEmpty()
                    || email.isEmpty()
                    || course.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please fill all fields.",
                        "Missing Information",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            Student student =
                    new Student(
                            id,
                            name,
                            email,
                            course
                    );

            boolean added =
                    studentService.addStudent(
                            student
                    );

            if (added) {

                refreshTable();
                clearFields();

                JOptionPane.showMessageDialog(
                        this,
                        "Student added successfully!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Student ID already exists.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Student ID must be a number.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // =====================================================
    // UPDATE STUDENT
    // =====================================================

    private void updateStudent() {

        try {

            int id =
                    Integer.parseInt(
                            idField.getText().trim()
                    );

            String name =
                    nameField.getText().trim();

            String email =
                    emailField.getText().trim();

            String course =
                    courseField.getText().trim();

            if (name.isEmpty()
                    || email.isEmpty()
                    || course.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please fill all fields.",
                        "Missing Information",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            boolean updated =
                    studentService.updateStudent(
                            id,
                            name,
                            email,
                            course
                    );

            if (updated) {

                refreshTable();
                clearFields();

                JOptionPane.showMessageDialog(
                        this,
                        "Student updated successfully!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Student not found.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
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
    // DELETE STUDENT
    // =====================================================

    private void deleteStudent() {

        try {

            int id =
                    Integer.parseInt(
                            idField.getText().trim()
                    );

            int choice =
                    JOptionPane.showConfirmDialog(
                            this,
                            "Are you sure you want to delete this student?",
                            "Confirm Delete",
                            JOptionPane.YES_NO_OPTION
                    );

            if (choice ==
                    JOptionPane.YES_OPTION) {

                boolean deleted =
                        studentService.deleteStudent(id);

                if (deleted) {

                    refreshTable();
                    clearFields();

                    JOptionPane.showMessageDialog(
                            this,
                            "Student deleted successfully!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                } else {

                    JOptionPane.showMessageDialog(
                            this,
                            "Student not found.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
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
    // SEARCH STUDENT
    // =====================================================

    private void searchStudent() {

        try {

            int id =
                    Integer.parseInt(
                            idField.getText().trim()
                    );

            Student student =
                    studentService.findStudentById(id);

            if (student != null) {

                nameField.setText(
                        student.getName()
                );

                emailField.setText(
                        student.getEmail()
                );

                courseField.setText(
                        student.getCourse()
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Student not found.",
                        "Search Result",
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

        for (Student student :
                studentService.getAllStudents()) {

            tableModel.addRow(
                    new Object[]{
                            student.getId(),
                            student.getName(),
                            student.getEmail(),
                            student.getCourse()
                    }
            );
        }
    }

    // =====================================================
    // CLEAR
    // =====================================================

    private void clearFields() {

        idField.setText("");
        nameField.setText("");
        emailField.setText("");
        courseField.setText("");

        studentTable.clearSelection();
    }
}