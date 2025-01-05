import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Main {
    
    private static boolean isTimerRunning = false;
    private static ZonedDateTime utcTimerStartTime;
    
    //UI
    private static JButton timerButton;
    private static JLabel label;



    public static void main(String[] args) {

        JFrame frame = new JFrame("Hello World App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        label = new JLabel(ZonedDateTime.now(ZoneId.of("UTC")).toString(), SwingConstants.CENTER);
        frame.add(label);
        
        timerButton = new JButton("Start Timer");


        timerButton.addActionListener(e -> {
            if(isTimerRunning){
                //Stop Timer
                StopTimer();
            }else{
                //Start Timer
                StartTimer();
            }
        });

        frame.add(timerButton);

        Timer timer = new Timer(1000, (ActionEvent e) -> {
            Update();
        });

        timer.start();

        frame.setVisible(true);
    }

    private static void StartTimer(){
        timerButton.setText("Stop Timer");
        isTimerRunning = true;  

        utcTimerStartTime = ZonedDateTime.now(ZoneId.of("UTC"));
    }

    private static void StopTimer(){
        timerButton.setText("Start Timer");
        isTimerRunning = false;  
    }

    private static void Update(){
        if(!isTimerRunning) return;
        label.setText(Duration.between(ZonedDateTime.now(ZoneId.of("UTC")), utcTimerStartTime).toString());
    }
}