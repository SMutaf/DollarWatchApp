package gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class DescriptionPanel extends JPanel{
    // setup components 
    private JLabel descriptionLabel = new JLabel();
    private ImageIcon icon = new ImageIcon("src/Assets/DollarIcon.png");
    private JLabel iconLabel = new JLabel();
    
    //setup panel
    public DescriptionPanel()
    {
        setBackground(new Color(104,104,104));
       
        setLayout(null);
        
        addGuiComponents();
    }
    
    //configure components and add to panel
    private void addGuiComponents()
    {
        iconLabel.setIcon(icon);
        iconLabel.setBounds(10, 10, 100, 100);
        add(iconLabel);
               
        String descriptionString = "<html>This application displays the current USD exchange rates.<br> "
         +"The data is fetched dynamically from a reliable source:<br>"
                + "https://api.exchangerate-api.com/v4/latest/USD<br>"
                + "</html>";
        
        descriptionLabel.setText(descriptionString);
        descriptionLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        descriptionLabel.setBounds(10, 100, 360, 110);
        descriptionLabel.setFont(new Font("Arials",Font.TYPE1_FONT,16));
        descriptionLabel.setForeground(Color.LIGHT_GRAY);
        add(descriptionLabel);
    }    
}
