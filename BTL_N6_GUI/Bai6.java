import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bai6 extends JFrame {
    private JTextField lengthField, widthField, areaField, perimeterField,nField,sumField;

    public Bai6() {
        // Thiết lập giao diện chọn bài
        setTitle("Giải bài tập cơ bản ");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Tạo các nút chọn bài
        JButton bai1Button = new JButton("          TAM GIÁC         ");
        JButton bai2Button = new JButton("    TÍNH TỔNG TỪ 1 TỚI N   ");
        JButton bai3Button = new JButton(" GIẢI PHƯƠNG TRÌNH BẬC NHẤT");
        JButton bai4Button = new JButton("   KIỂM TRA SỐ NGUYÊN TỐ   ");
        JButton bai5Button = new JButton("BỘI SỐ CHUNG - ƯỚC SỐ CHUNG");
// XỬ LÍ NÚT BẤM CHỌN BÀI
        // Bấm nút 1
        bai1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRectangleCalculator();
            }
        });
        // Bấm nút 2
        bai2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSumCalculator();
            }
        });
        // Bấm nút 3
        bai3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showEquationSolver();
            }
        });
        // Bấm nút 4
        bai4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPrimeNumberCheck();
            }
        });
        // Bấm nút 5
        bai5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showGC();
            }
        });
// Tạo layout cho giao diện chọn bài
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(bai1Button)
                        .addComponent(bai2Button)
                        .addComponent(bai3Button)
                        .addComponent(bai4Button)
                        .addComponent(bai5Button))
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(bai1Button)
                .addComponent(bai2Button)
                .addComponent(bai3Button)
                .addComponent(bai4Button)
                .addComponent(bai5Button)
        );

        add(panel);

        setVisible(true);
    }
// Bài 1 
    private void showRectangleCalculator() {
        // Tạo các thành phần giao diện
        JLabel lengthLabel = new JLabel("Chiều dài:");
        JLabel widthLabel = new JLabel("Chiều rộng:");
        JLabel areaLabel = new JLabel("Diện tích:");
        JLabel perimeterLabel = new JLabel("Chu vi:");

        lengthField = new JTextField(10);
        widthField = new JTextField(10);
        areaField = new JTextField(10);
        perimeterField = new JTextField(10);
        areaField.setEditable(false);
        perimeterField.setEditable(false);

        JButton submitButton = new JButton("Submit");
        JButton backButton = new JButton("Back");

        // Xử lý sự kiện khi nhấn nút "Submit"
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateAreaAndPerimeter();
            }
        });

        // Xử lý sự kiện khi nhấn nút "Back"
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goBackToMainScreen();
            }
        });

        // Tạo layout cho các thành phần giao diện
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lengthLabel)
                        .addComponent(widthLabel)
                        .addComponent(areaLabel)
                        .addComponent(perimeterLabel)
                        .addComponent(backButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lengthField)
                        .addComponent(widthField)
                        .addComponent(areaField)
                        .addComponent(perimeterField)
                        .addComponent(submitButton))
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lengthLabel)
                        .addComponent(lengthField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(widthLabel)
                        .addComponent(widthField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(areaLabel)
                        .addComponent(areaField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(perimeterLabel)
                        .addComponent(perimeterField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(backButton)
                        .addComponent(submitButton))
        );

        // Xóa nút "Bài 1" và thêm giao diện mới vào frame
        getContentPane().removeAll();
        add(panel);

        // Cập nhật lại giao diện
        revalidate();
        repaint();
    }

    private void calculateAreaAndPerimeter() {
        try {
            double length = Double.parseDouble(lengthField.getText());
            double width = Double.parseDouble(widthField.getText());

            double area = length * width;
            double perimeter = 2 * (length + width);

            areaField.setText(String.format("%.2f", area));
            perimeterField.setText(String.format("%.2f", perimeter));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values for length and width.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
// bài 2
     private void showSumCalculator() {
        JLabel nLabel = new JLabel("Nhập 1 số nguyên dương n: ");
        JLabel sumLabel = new JLabel("Tổng từ 1 tới n: ");

        nField = new JTextField(10);
        sumField = new JTextField(10);
        sumField.setEditable(false);

        JButton submitButton = new JButton("Submit");
        JButton backButton = new JButton("Back");

        // Xử lý sự kiện khi nhấn nút "Submit"
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                summ();
            }
        });

        // Xử lý sự kiện khi nhấn nút "Back"
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goBackToMainScreen();
            }
        });
        // Tạo layout cho các thành phần giao diện
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(nLabel)
                .addComponent(backButton))
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(nField)
                .addComponent(sumField)
                .addComponent(submitButton))
);

layout.setVerticalGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(nLabel)
                .addComponent(nField))
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(backButton)
                .addComponent(submitButton))
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(sumField))
);

        // Xóa nút "Bài 2" và thêm giao diện mới vào frame
        getContentPane().removeAll();
        add(panel);

        // Cập nhật lại giao diện
        revalidate();
        repaint();
    }

    private void summ() {
        try {
            int n = Integer.parseInt(nField.getText());

            if (n > 0) {
                int sum = 0;
                for (int i = 1; i <= n; i++) {
                    sum += i;
                }
                sumField.setText("Sum: " + sum);
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a positive integer for n.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid integer for n.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void goBackToMainScreen() {
        // Hiển thị lại giao diện chọn bài
        getContentPane().removeAll();
        add(new Bai6());

        // Cập nhật lại giao diện
        revalidate();
        repaint();
    }
// Bài 3
    // Bổ sung phương thức để hiển thị giao diện cho Bài 3
private void showEquationSolver() {
    // Tạo các thành phần giao diện
    JLabel aLabel = new JLabel("Nhập số a:");
    JLabel bLabel = new JLabel("Nhập số b:");
    JLabel resultLabel = new JLabel("Kết quả phương trình ax+b=0: ");

    JTextField aField = new JTextField(10);
    JTextField bField = new JTextField(10);
    JTextField resultField = new JTextField(10);
    resultField.setEditable(false);

    JButton submitButton = new JButton("Submit");
    JButton backButton = new JButton("Back");

    // Xử lý sự kiện khi nhấn nút "Submit"
    submitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            calculateEquationResult(aField, bField, resultField);
        }
    });

    // Xử lý sự kiện khi nhấn nút "Back"
    backButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            goBackToMainScreen();
        }
    });

    // Tạo layout cho các thành phần giao diện
    JPanel panel = new JPanel();
    GroupLayout layout = new GroupLayout(panel);
    panel.setLayout(layout);

    layout.setAutoCreateGaps(true);
    layout.setAutoCreateContainerGaps(true);

    layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(aLabel)
                    .addComponent(bLabel)
                    .addComponent(resultLabel)
                    .addComponent(backButton))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(aField)
                    .addComponent(bField)
                    .addComponent(resultField)
                    .addComponent(submitButton))
    );

    layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(aLabel)
                    .addComponent(aField))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(bLabel)
                    .addComponent(bField))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(resultLabel)
                    .addComponent(resultField))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(submitButton))
    );

    // Xóa nút "Bài 1" và thêm giao diện mới vào frame
    getContentPane().removeAll();
    add(panel);

    // Cập nhật lại giao diện
    revalidate();
    repaint();
}

// Phương thức tính toán kết quả cho Bài 3
private void calculateEquationResult(JTextField aField, JTextField bField, JTextField resultField) {
    try {
        double a = Double.parseDouble(aField.getText());
        double b = Double.parseDouble(bField.getText());

        if (a != 0) {
            double result = -b / a;
            resultField.setText(String.format("%.2f", result));
        } else {
            JOptionPane.showMessageDialog(this, "The value of 'a' cannot be zero.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Please enter valid numeric values for 'a' and 'b'.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
//Bài 4
private void showPrimeNumberCheck() {
    // Tạo các thành phần giao diện
    JLabel numberLabel = new JLabel("Nhập 1 số nguyên dương (tối đa 9 chữ số): ");
    JTextField numberField = new JTextField(10);
    JButton submitButton = new JButton("Submit");
    JButton backButton = new JButton("Back");

    // Xử lý sự kiện khi nhấn nút "Submit"
    submitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            checkPrimeNumber(numberField.getText());
        }
    });

    // Xử lý sự kiện khi nhấn nút "Back"
    backButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            goBackToMainScreen();
        }
    });

    // Tạo layout cho các thành phần giao diện
    JPanel panel = new JPanel();
    GroupLayout layout = new GroupLayout(panel);
    panel.setLayout(layout);

    layout.setAutoCreateGaps(true);
    layout.setAutoCreateContainerGaps(true);

    layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(numberLabel)
                    .addComponent(backButton))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(numberField)
                    .addComponent(submitButton))
    );

    layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(numberLabel)
                    .addComponent(numberField))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(submitButton))
    );

    // Xóa nút "Bài 2" và thêm giao diện mới vào frame
    getContentPane().removeAll();
    add(panel);

    // Cập nhật lại giao diện
    revalidate();
    repaint();
}

private void checkPrimeNumber(String numberStr) {
    try {
        long number = Long.parseLong(numberStr);

        if (isPrime(number)) {
            JOptionPane.showMessageDialog(this, "YES", "Result", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "NO", "Result", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

private boolean isPrime(long number) {
    if (number <= 1) {
        return false;
    }
    for (long i = 2; i <= Math.sqrt(number); i++) {
        if (number % i == 0) {
            return false;
        }
    }
    return true;
}
// Phương thức hiển thị giao diện cho Bài 5
private void showGC() {
    // Tạo các thành phần giao diện
    JLabel aLabel = new JLabel("Nhập số a:");
    JLabel bLabel = new JLabel("Nhập số b:");
    JLabel gcdLabel = new JLabel("ƯCLN:");
    JLabel lcmLabel = new JLabel("BCNN:");

    JTextField aField = new JTextField(10);
    JTextField bField = new JTextField(10);
    JTextField gcdField = new JTextField(10);
    JTextField lcmField = new JTextField(10);

    JButton submitButton = new JButton("Submit");
    JButton backButton = new JButton("Back");

    // Xử lý sự kiện khi nhấn nút "Submit"
    submitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            calculateGCDAndLCM(aField, bField, gcdField, lcmField);
        }
    });

    // Xử lý sự kiện khi nhấn nút "Back"
    backButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            goBackToMainScreen();
        }
    });

    // Tạo layout cho các thành phần giao diện
    JPanel panel = new JPanel();
    GroupLayout layout = new GroupLayout(panel);
    panel.setLayout(layout);

    layout.setAutoCreateGaps(true);
    layout.setAutoCreateContainerGaps(true);

    layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(aLabel)
                    .addComponent(bLabel)
                    .addComponent(gcdLabel)
                    .addComponent(lcmLabel)
                    .addComponent(backButton))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(aField)
                    .addComponent(bField)
                    .addComponent(gcdField)
                    .addComponent(lcmField)
                    .addComponent(submitButton))
    );

    layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(aLabel)
                    .addComponent(aField))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(bLabel)
                    .addComponent(bField))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(gcdLabel)
                    .addComponent(gcdField))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lcmLabel)
                    .addComponent(lcmField))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(submitButton))
    );

    // Xóa nút "Bài 1" và thêm giao diện mới vào frame
    getContentPane().removeAll();
    add(panel);

    // Cập nhật lại giao diện
    revalidate();
    repaint();
}

// Phương thức tính toán GCD và LCM
private void calculateGCDAndLCM(JTextField aField, JTextField bField, JTextField gcdField, JTextField lcmField) {
    try {
        int a = Integer.parseInt(aField.getText());
        int b = Integer.parseInt(bField.getText());

        int gcd = findGCD(a, b);
        int lcm = findLCM(a, b);

        gcdField.setText(String.valueOf(gcd));
        lcmField.setText(String.valueOf(lcm));
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Please enter valid integer values for a and b.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

// Phương thức tìm ước chung lớn nhất (GCD)
private int findGCD(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return Math.abs(a);
}

// Phương thức tìm bội chung nhỏ nhất (LCM)
private int findLCM(int a, int b) {
    return Math.abs(a * b) / findGCD(a, b);
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Bai6();
            }
        });
    }
}
