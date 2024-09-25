import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.border.LineBorder;

public class DigitalClock extends JFrame {

    private JLabel timeLabel;
    private SimpleDateFormat timeFormat;
    private String time;
    private JPanel container;

    public DigitalClock() {
        setTitle("Digital Clock");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container = new JPanel();
        container.setLayout(new GridBagLayout());
        container.setBackground(Color.white);
        JPanel clockPanel = new JPanel();
        clockPanel.setPreferredSize(new Dimension(400, 100));
        clockPanel.setBackground(Color.gray);
        clockPanel.setBorder(new LineBorder(Color.WHITE, 5));
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 50));
        timeLabel.setForeground(Color.black);
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeFormat = new SimpleDateFormat("HH:mm:ss a");
        clockPanel.add(timeLabel);
        container.add(clockPanel);
        add(container);

        startClock();
        setVisible(true);
    }
    public void startClock() {
        Timer timer = new Timer(1000, e -> {

            time = timeFormat.format(Calendar.getInstance().getTime());

            timeLabel.setText(time);
        });
        timer.start();
    }
    public static void main(String[] args) {
        new DigitalClock();
    }
}
