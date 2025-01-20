package gui;

import java.awt.GridLayout;
import javax.swing.JFrame;

public class DollarWatchGui extends JFrame{
    // setup frame and add panels 
    public DollarWatchGui()
    {
        super("Dollar Watch App");
        
        setSize(400,500);
        
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setResizable(false);
        
        setLayout(new GridLayout(2, 1));
        
        add(new AppPanel());
        
        add(new DescriptionPanel());
    }
  
    
}
