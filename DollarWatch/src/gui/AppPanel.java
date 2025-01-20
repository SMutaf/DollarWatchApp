package gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import backend.DollarWatchManagement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.border.Border;


public class AppPanel extends JPanel implements ActionListener{
    // setup components and static massages
    private static final String SHOW_DOLLAR = "1$ = ";
    private JLabel dollarValue = new JLabel();
    private JComboBox ExchangeRate = new JComboBox();
    
    //setup panel
    public AppPanel()
    {
        setBackground(new Color(80,80,80));
       
        setLayout(null);
        
        addGuiComponents();
    }
    
    //configure components and add to panel
    private void addGuiComponents()
    {
        dollarValue.setText(SHOW_DOLLAR);
        dollarValue.setBounds(10,30,360,80);
        dollarValue.setFont(new Font("Dialog",Font.BOLD,40));
        dollarValue.setHorizontalAlignment(SwingConstants.CENTER);
        dollarValue.setVerticalAlignment(SwingConstants.CENTER);
        dollarValue.setForeground(Color.WHITE);
        add(dollarValue);
        
        Border dollarValueBorder = BorderFactory.createLineBorder(new Color(190,190,190), 3);
        dollarValue.setBorder(dollarValueBorder);
        
        ExchangeRate.setBounds(20, 130, 100, 30);
        ExchangeRate.setFont(new Font("Arials",Font.ITALIC,22));
        ExchangeRate.addActionListener(this);
        DollarWatchManagement.settComboBoxComponents(ExchangeRate);
        add(ExchangeRate);        
    }
    
    //Finds the exchange rate based on the users selected currency and displays it on the screen.
    @Override
    public void actionPerformed(ActionEvent e) {              
        double exchangeRate = DollarWatchManagement.findValueExchangeRate((String)ExchangeRate.getSelectedItem());
        dollarValue.setText(SHOW_DOLLAR + exchangeRate + " "  + ExchangeRate.getSelectedItem());      
    }
    
}
