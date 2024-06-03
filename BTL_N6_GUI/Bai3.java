import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

 class DigitalClock extends JPanel implements Runnable
{
    JLabel digitalClock;
    Thread clockThread;

    public DigitalClock()
    {
        digitalClock = new JLabel();
        digitalClock.setFont(new Font("Arial", Font.BOLD, 30));
        digitalClock.setForeground(new Color(0, 71, 113));
        add(digitalClock);
        startRun();
    }

    private void startRun()
    {
        clockThread = new Thread(this);
        clockThread.start();
    }

    @Override
    public void run()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        while(true)
        {
            Date now = new Date();
            String time = sdf.format(now);
            digitalClock.setText(time);
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}
class StillClock extends JPanel implements Runnable
{
    private int hour;
    private int minute;
    private int second;
    private Thread clockThread;

    public StillClock()
    {
        setCurrentTime();
        startRun();
    }

    public StillClock(int hour, int minute, int second)
    {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        clockThread = new Thread(this);
        clockThread.start();
    }

    private void startRun()
    {
        clockThread = new Thread(this);
        clockThread.start();
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        int clockRadius = (int) (Math.min(getWidth(), getHeight()) * 0.8 * 0.5);
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;

        g.setColor(Color.black);
        g.drawOval(xCenter - clockRadius, yCenter - clockRadius, 2 * clockRadius, 2 * clockRadius);
        g.drawString("12", xCenter - 5, yCenter - clockRadius + 12);
        g.drawString("9", xCenter - clockRadius + 3, yCenter + 5);
        g.drawString("3", xCenter + clockRadius - 10, yCenter + 3);
        g.drawString("6", xCenter - 3, yCenter + clockRadius - 3);

        int sLength = (int) (clockRadius * 0.8);
        int xSecond = (int) (xCenter + sLength * Math.sin(second * (2 * Math.PI / 60)));
        int ySecond = (int) (yCenter - sLength * Math.cos(second * (2 * Math.PI / 60)));
        g.setColor(Color.red);
        g.drawLine(xCenter, yCenter, xSecond, ySecond);

        int mLength = (int) (clockRadius * 0.65);
        int xMinute = (int) (xCenter + mLength * Math.sin(minute * (2 * Math.PI / 60)));
        int yMinute = (int) (yCenter - mLength * Math.cos(minute * (2 * Math.PI / 60)));
        g.setColor(Color.blue);
        g.drawLine(xCenter, yCenter, xMinute, yMinute);

        int hLength = (int) (clockRadius * 0.5);
        int xHour = (int) (xCenter + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
        int yHour = (int) (yCenter - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
        g.setColor(Color.BLACK);
        g.drawLine(xCenter, yCenter, xHour, yHour);
    }

    public void setCurrentTime()
    {
        Calendar calendar = new GregorianCalendar();
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
    }

    @Override
    public void run()
    {
        while(true)
        {
            setCurrentTime();
            repaint();
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Bai3 {
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setTitle("Clock");
        frame.setLayout(new BorderLayout());
        frame.add(new StillClock(), BorderLayout.CENTER);
        frame.add(new DigitalClock(), BorderLayout.SOUTH);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
