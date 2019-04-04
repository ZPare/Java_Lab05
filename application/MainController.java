package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.awt.Label;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

//Zoe - 300972366

public class MainController {
	
    @FXML
    private Button insertBtn;

    @FXML
    private Button updateBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private TextField bookcodeField;

    @FXML
    private TextField titleField;

    @FXML
    private TextField authorField;

    @FXML
    private TextField priceField;

    @FXML
    private TextField typeField;

    @FXML
    private TextField subjectField;

    @FXML
    private TextField saledateField;

    @FXML
    private Label displayOutput;
    
    @FXML
    private Button displayBtn;
    
//Select Query
    @FXML
    void displayBtn_onclick(ActionEvent event) {
    	try {
    	String query= "SELECT * FROM BOOKS_JAVA";
    	executeQuery(query);
    	displayOutput.setText(query);}
    	catch(Exception ex) {
    		System.out.println(ex.toString());
    	}
    }
    
//Delete Query
    @FXML
    void deletebtn_onclick(ActionEvent event) {
    	try {
    	String query = "DELETE FROM books_java WHERE BOOKCODE="+bookcodeField.getText()+"";
    	executeQuery(query);
    	displayOutput.setText(query);}
    	catch(Exception ex) {
    		System.out.println(ex.toString());
    	}
    
    }
//Insert Query
    @FXML
    void insertbtn_onclick(ActionEvent event) {
    	try {
    	String query = "insert into books_java values("+bookcodeField.getText()+",'"+titleField.getText()+"','"+authorField.getText()+"',"+priceField.getText()+","+typeField.getText()+"','"+subjectField.getText()+")";
    	executeQuery(query);
    	displayOutput.setText(query);}
    	catch (Exception ex) {
    		System.out.println(ex.toString());
    	}
    	
    }
//Update Query
    @FXML
    void updatebtn_onclick(ActionEvent event) {
    	try {
        String query = "UPDATE books_java SET Title='"+titleField.getText()+"',Author='"+authorField.getText()+"',Price="+priceField.getText()+",Type="+typeField.getText()+",Subject ="+subjectField.getText()+" WHERE BOOKCODE="+bookcodeField.getText()+"";
        executeQuery(query);
        displayOutput.setText(query);}
    	catch(Exception ex) {
    		System.out.println(ex.toString());
    	}
    
    }
  //Connecting to Database
    public void executeQuery(String query) {
    	Connection conn = getConnection();
    	java.sql.Statement stmt;
    	try {
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    public Connection getConnection() {
    	
    	Connection conn;
    	ResultSet rs;
    	
		//Creating connection to Oracle Database
		try {
		Class.forName("oracle.jdbc.OracleDriver");
					
		String connectionUrl = "jdbc:oracle:thin:@oracle1.centennialcollege.ca:1521:SQLD";
		String connectionUser="COMP214F18_001_P_19";
		String connectionPassword = "password";
					
		conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
		}
		catch(Exception ex){
			System.out.println(ex.toString());
		}
		return null;
    	
    }

}

