package backend;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DollarWatchManagement {
    
    //set static error message
    private static final String FETCH_API_ERROR = "An error occurred while connecting to the API. Please"
            + " check your internet connection or try again later.";
      
    //check user internet availeblity
    public static boolean isInternetAvaileble()
    {
        try {
            URL url = new URL("https://www.google.com");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(3000);
            
            connection.connect();
            
            int response = connection.getResponseCode();
            
            return response == 200;
                     
        } catch (Exception e) {
            System.out.println("Internet Availeble Error: " + e.getMessage());
        }
        
        return false;
    }
    
    //set the comboBox components
    public static void settComboBoxComponents(JComboBox comboBox){       
        try {
            JSONObject jsonObject;
            if((jsonObject = getCurrency()) == null)
            {
                JOptionPane.showMessageDialog(null, FETCH_API_ERROR,"Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
                  
            for(Object key: jsonObject.keySet())
            {
                if(key instanceof String)
                    comboBox.addItem((String) key);
            }
        } catch (Exception e) {
            System.out.println("settComboBoxComponents Error: "+e.getMessage());
        }        
    }
    
    //finds the exchange rate for the specified currency
    public static double findValueExchangeRate(String temp){         
            JSONObject jsonObject = getCurrency();
            
            Number exchangeRate = (Number)jsonObject.get(temp);
            
            return exchangeRate.doubleValue();      
    }
    
    // control api connection and return dollar rates
    public static JSONObject getCurrency()
    {
        try {
            HttpURLConnection connection = fetchApiConnection("https://api.exchangerate-api.com/v4/latest/USD");
        
            int responseCode = connection.getResponseCode();
        
            if(responseCode != 200)
            {
                JOptionPane.showMessageDialog(null,FETCH_API_ERROR , "Error", JOptionPane.WARNING_MESSAGE);
                System.out.println("Connection Fail Code: "+responseCode);
                return null;
            }else{
                
                Scanner scanner = new Scanner(connection.getInputStream());
                StringBuilder stringBuilder = new StringBuilder();
                
                while(scanner.hasNextLine()){
                    stringBuilder.append(scanner.nextLine());
                }
                      
                JSONParser parser = new JSONParser();             
                JSONObject Jobj = (JSONObject)parser.parse(stringBuilder.toString());
                
                return (JSONObject) Jobj.get("rates");
            }
            
            
        } catch (Exception e) {
            System.out.println("Get Currency Error: " + e.getMessage());
        }
             
        return null;
    }
    
    //get api connection 
    private static HttpURLConnection fetchApiConnection(String urlString)
    {      
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            connection.setRequestMethod("GET");
            connection.connect();
            
            return connection;
        } catch (Exception e) {
            System.out.println("FetchApiConnection Error: "+e.getMessage());
        }
        
        return null;
    }
       
}
