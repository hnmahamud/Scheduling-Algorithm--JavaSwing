import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Scheduling_Algorithm_Calculator extends JFrame implements ActionListener {
    private ImageIcon frameIcon, labelImage, developerImage;
    private Container container;
    private JButton FCFS, SJF, Priority, About;
    private Font arial;
    private Cursor handCursor;
    private JLabel imageLabel;
    
    Scheduling_Algorithm_Calculator(){
        initComponents();
    }
    
    public void initComponents(){
        frameIcon = new ImageIcon(getClass().getResource("icon.png"));    
        this.setIconImage(frameIcon.getImage());
        
        this.setTitle("Scheduling Algorithm Calculator");
        this.setSize(600, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        container = this.getContentPane();
        container.setLayout(null);
        container.setBackground(Color.LIGHT_GRAY);
        
        arial = new Font("Arial", Font.BOLD, 14);
        handCursor = new Cursor(Cursor.HAND_CURSOR);
        
        labelImage = new ImageIcon(getClass().getResource("image.png"));    
        imageLabel = new JLabel(labelImage);
        imageLabel.setBounds(45, 20, 500, 250);
        container.add(imageLabel);
        
        FCFS = new JButton("FCFS");
        FCFS.setBounds(180, 350, 220, 50);
        FCFS.setFont(arial);
        FCFS.setCursor(handCursor);
        FCFS.addActionListener(this);
        FCFS.setToolTipText("First_Come, First_Served Scheduling");
        container.add(FCFS);
        
        SJF = new JButton("SJF");
        SJF.setBounds(45, 420, 220, 50); 
        SJF.setFont(arial);
        SJF.setCursor(handCursor);
        SJF.addActionListener(this);
        SJF.setToolTipText("Shortest_Job_First Scheduling");
        container.add(SJF);
        
        Priority = new JButton("Priority");
        Priority.setBounds(325, 420, 220, 50); 
        Priority.setFont(arial);
        Priority.setCursor(handCursor);
        Priority.addActionListener(this);
        Priority.setToolTipText("Priority Scheduling");
        container.add(Priority);
        
        About = new JButton("About-Developer");
        About.setBounds(45, 490, 500, 50);
        About.setFont(arial);
        About.setCursor(handCursor);
        About.addActionListener(this);
        About.setToolTipText("About_Developer");
        container.add(About);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("FCFS")) {
            try {
                int num = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of process:"));

            int burstTime[] = new int[num];
            int waitingTime[] = new int[num];

            for (int i = 0; i < num; i++) {
                int count = i + 1;
                burstTime[i] = Integer.parseInt(JOptionPane.showInputDialog("Enter the burst time of process " + count + ":"));
            }

            int sum = 0;
            for (int i = 0; i < num; i++) {
                waitingTime[i] = 0;
                for (int j = 0; j < i; j++) {
                    waitingTime[i] = waitingTime[i] + burstTime[j];
                }
                sum = sum + waitingTime[i];
            }

            float avg = (float)sum/num;
            JOptionPane.showMessageDialog(null, "The average waiting time of the processes is = " + avg, "Result", JOptionPane.INFORMATION_MESSAGE);
        
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
        
        else if (ae.getActionCommand().equals("SJF")) {
            try {
                int num = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of process:"));

            int burstTime[] = new int[num];
            int waitingTime[] = new int[num];

            for (int i = 0; i < num; i++) {
                int count = i + 1;
                burstTime[i] = Integer.parseInt(JOptionPane.showInputDialog("Enter the burst time of process " + count + ":"));
            }

            for (int i = 0; i < num; i++) {
            for (int j = i + 1; j < num; j++) {
                if (burstTime[i] > burstTime[j]) {
                    int temp = burstTime[i];
                    burstTime[i] = burstTime[j];
                    burstTime[j] = temp;
                }
            }     
        }
        
        int sum = 0;
        for (int i = 0; i < num; i++) {
            waitingTime[i] = 0;
            for (int j = 0; j < i; j++) {
                waitingTime[i] = waitingTime[i] + burstTime[j];
            }
            sum = sum + waitingTime[i];
        }

            float avg = (float)sum/num;
            JOptionPane.showMessageDialog(null, "The average waiting time of the processes is = " + avg, "Result", JOptionPane.INFORMATION_MESSAGE);
        
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
        
        else if (ae.getActionCommand().equals("Priority")) {
            try {
                int num = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of process:"));

            int burstTime[] = new int[num];
            int waitingTime[] = new int[num];
            int priorityLevel[] = new int[num];

            for (int i = 0; i < num; i++) {
                int count = i + 1;
                burstTime[i] = Integer.parseInt(JOptionPane.showInputDialog("Enter the burst time of process " + count + ":"));
            }
            
            for (int i = 0; i < num; i++) {
                int count = i + 1;
                priorityLevel[i] = Integer.parseInt(JOptionPane.showInputDialog("Enter the priority level of process " + count + ":"));
            }

            for (int i = 0; i < num; i++) {
            for (int j = i + 1; j < num; j++) {
                if (priorityLevel[i] > priorityLevel[j]) {
                    int temp = priorityLevel[i];
                    priorityLevel[i] = priorityLevel[j];
                    priorityLevel[j] = temp;
                    
                    temp = burstTime[i];
                    burstTime[i] = burstTime[j];
                    burstTime[j] = temp;
                }
            }     
        }
        
        int sum = 0;
        for (int i = 0; i < num; i++) {
            waitingTime[i] = 0;
            for (int j = 0; j < i; j++) {
                waitingTime[i] = waitingTime[i] + burstTime[j];
            }
            sum = sum + waitingTime[i];
        }

            float avg = (float)sum/num;
            JOptionPane.showMessageDialog(null, "The average waiting time of the processes is = " + avg, "Result", JOptionPane.INFORMATION_MESSAGE);
        
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
        
        else if (ae.getActionCommand().equals("About-Developer")) { 
            ImageIcon developerImage = new ImageIcon(getClass().getResource("developer.jpg"));
            JOptionPane.showMessageDialog(null, "HN Mahamud\nUODA,CSE-45\n01788062232\nhnmahamud@gmail.com", "About_Developer", JOptionPane.PLAIN_MESSAGE, developerImage);
        }
            
    }
    
    public static void main(String[] args) {
        Scheduling_Algorithm_Calculator frame = new Scheduling_Algorithm_Calculator();
        frame.setVisible(true);
        
    }

    
}
