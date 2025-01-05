import java.awt.FlowLayout;
import java.time.LocalTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Main {
    private static boolean isTimerRunning = false;
    private static int count = 0;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Hello World App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel(LocalTime.now().toString(), SwingConstants.CENTER);
        frame.add(label);

        JButton button = new JButton("Start Timer");


        button.addActionListener(e -> {

            if(isTimerRunning){
                //Stop Timer
                button.setText("Start Timer");
            }else{
                //Start Timer
                button.setText("Stop Timer");
            }
            isTimerRunning = !isTimerRunning;
        });


        frame.add(button);


        // Make the frame visible
        frame.setVisible(true);
    }
}