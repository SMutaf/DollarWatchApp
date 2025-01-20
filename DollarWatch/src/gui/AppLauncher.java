package gui;

import backend.DollarWatchManagement;
import javax.swing.JOptionPane;

public class AppLauncher {
    //set the static error message
    private static final String NET_ERROR = "No internet connection.";
    
    public static void main(String[] args) {
       //if user ineternet connection avalieble run the proccess
       if(DollarWatchManagement.isInternetAvaileble())
           new DollarWatchGui().setVisible(true);
          else
           JOptionPane.showMessageDialog(null, NET_ERROR,"Error",JOptionPane.WARNING_MESSAGE);
    }
    
}
