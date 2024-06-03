import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 class Circle extends Geometry
{
    private final int WIDTH = 150 * scale;
    private final int HEIGHT = 150 * scale;

    public Circle(int scale, String type, Color color)
    {
        super(scale, type, color);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(color);
        if (type.equals("Fill"))
            g.fillOval(getWidth() / 2 - WIDTH / 2, getHeight() / 2 - HEIGHT / 2, WIDTH, HEIGHT);
        else
            g.drawOval(getWidth() / 2 - WIDTH / 2, getHeight() / 2 - HEIGHT / 2, WIDTH, HEIGHT);
    }
}
class Frame extends JFrame implements ActionListener
{
    private JPanel tools;
    private JButton OK;
    private JComboBox<String> color;
    private JComboBox<String> type;
    private JComboBox<String> zoom;
    private JComboBox<String> geometry;
    private String selectedType;
    private Color selectedColor;
    private int scale = 1;

    public Frame() throws HeadlessException
    {
        super("Drawing Geometry");

        tools = new JPanel();
        color = new JComboBox<>();
        type = new JComboBox<>();
        zoom = new JComboBox<>();
        geometry = new JComboBox<>();
        OK = new JButton("OK");
        selectedColor = Color.red;
        selectedType = "Fill";

        setLayout(new BorderLayout());

        type.addItem("Fill");
        type.addItem("Not Fill");

        color.addItem("Red");
        color.addItem("Green");
        color.addItem("Blue");
        color.addItem("Yellow");

        zoom.addItem("1x");
        zoom.addItem("2x");
        zoom.addItem("3x");
        zoom.addItem("4x");

        geometry.addItem("Rectangle");
        geometry.addItem("Square");
        geometry.addItem("Circle");
        geometry.addItem("Polygon");

        tools.setLayout(new FlowLayout());
        tools.add(OK);
        tools.add(geometry);
        tools.add(type);
        tools.add(color);
        tools.add(zoom);
        add(tools, BorderLayout.SOUTH);

        OK.addActionListener(this);

        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        //pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == OK)
        {
            switch (color.getSelectedItem().toString())
            {
                case "Red":
                    selectedColor = new Color(255, 0, 0);
                    break;
                case "Yellow":
                    selectedColor = new Color(255,255,0);
                    break;
                case "Green":
                    selectedColor = new Color(0,142,0);
                    break;
                case "Blue":
                    selectedColor = new Color(0,192,192);
                    break;
            }
            selectedType = type.getSelectedItem().toString();
            scale = zoom.getSelectedItem().toString().charAt(0) - '0';
            switch (geometry.getSelectedItem().toString())
            {
                case "Rectangle":
                    add(new Rectangle(scale, selectedType, selectedColor));
                    break;
                case "Square":
                    add(new Square(scale, selectedType, selectedColor));
                    break;
                case "Circle":
                    add(new Circle(scale, selectedType, selectedColor));
                    break;
                case "Polygon":
                    add(new Polygons(scale, selectedType, selectedColor));
                    break;
            }
            setVisible(true);
        }
    }
}
abstract class Geometry extends JPanel
{
    protected int scale = 1;
    protected String type;
    protected Color color;

    public Geometry(int scale, String type, Color color)
    {
        this.scale = scale;
        this.type = type;
        this.color = color;
    }
}
 class Polygons extends Geometry
{
    private final int WIDTH = 150 * scale;
    private final int HEIGHT = 150 * scale;
    public Polygons(int scale, String type, Color color)
    {
        super(scale, type, color);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(color);

        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;
        int radius = (int) (Math.min(WIDTH, HEIGHT) * 0.4);

        Polygon polygon = new Polygon();

        polygon.addPoint(xCenter + radius, yCenter);
        polygon.addPoint((int) (xCenter + radius * Math.cos(2 * Math.PI / 6)), (int) (yCenter - radius * Math.sin(2 * Math.PI / 6)));
        polygon.addPoint((int) (xCenter + radius * Math.cos(2 * 2 * Math.PI / 6)), (int) (yCenter - radius * Math.sin(2 * 2 * Math.PI / 6)));
        polygon.addPoint((int) (xCenter + radius * Math.cos(3 * 2 * Math.PI / 6)), (int) (yCenter - radius * Math.sin(3 * 2 * Math.PI / 6)));
        polygon.addPoint((int) (xCenter + radius * Math.cos(4 * 2 * Math.PI / 6)), (int) (yCenter - radius * Math.sin(4 * 2 * Math.PI / 6)));
        polygon.addPoint((int) (xCenter + radius * Math.cos(5 * 2 * Math.PI / 6)), (int) (yCenter - radius * Math.sin(5 * 2 * Math.PI / 6)));

        if (type.equals("Fill"))
            g.fillPolygon(polygon);
        else
            g.drawPolygon(polygon);
    }
}
class Rectangle extends Geometry
{
    private final int WIDTH = 150 * scale;
    private final int HEIGHT = 90 * scale;

    public Rectangle(int scale, String type, Color color)
    {
        super(scale, type, color);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(color);
        if (type.equals("Fill"))
            g.fillRect(getWidth() / 2 - WIDTH / 2, getHeight() / 2 - HEIGHT / 2, WIDTH, HEIGHT);
        else
            g.drawRect(getWidth() / 2 - WIDTH / 2, getHeight() / 2 - HEIGHT / 2, WIDTH, HEIGHT);
    }
}

class Square extends Geometry
{
    private final int WIDTH = 150 * scale;
    private final int HEIGHT = 150 * scale;

    public Square(int scale, String type, Color color)
    {
        super(scale, type, color);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(color);
        if (type.equals("Fill"))
            g.fillRect(getWidth() / 2 - WIDTH / 2, getHeight() / 2 - HEIGHT / 2, WIDTH, HEIGHT);
        else
            g.drawRect(getWidth() / 2 - WIDTH / 2, getHeight() / 2 - HEIGHT / 2, WIDTH, HEIGHT);
    }
}

public class Bai2 {
    public static void main(String[] args)
    {
        new Frame();
    }
}
