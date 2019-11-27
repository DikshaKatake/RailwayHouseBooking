/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author diksha
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author diksha
 */




import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


public class house extends JFrame{
    JButton button ;
    JButton button2;
    JButton back;
    JLabel label;
    JTextField textID;
    JTextField textNAME;
    JTextField price, pincode;
    JTextArea area;
    String s;
    
    JRadioButton jRadioButton1; 
  
    // Declaration of object of JRadioButton class. 
    JRadioButton jRadioButton2; 
  
  
    // Declaration of object of ButtonGroup class. 
    ButtonGroup G1; 
  
    // Declaration of object of  JLabel  class. 
    JLabel L1;
     
    public house(){
        
    super("Add houses");
        
//    this.setLocationRelativeTo(null);
    
    back = new JButton("BACK");
    back.setBounds(320,50,100,30);
    
    button = new JButton("ADD ROOM");
    button.setBounds(200,300,100,40);
    
    button2 = new JButton("Upload Image");
    button2.setBounds(80, 300, 100, 40);
    
    textID = new JTextField("ID");
    textID.setBounds(120,90,200,30);

    textNAME = new JTextField("Name");
    textNAME.setBounds(120,130,200,30);
    
    price = new JTextField("Price");
    price.setBounds(120,160,200,30);

//    area = new JTextArea("DESCRIPTION",100, 100);
    
//    JScrollPane pane = new JScrollPane(area);
//    pane.setBounds(450, 270, 200, 100);
    
    label = new JLabel();
    label.setBounds(100,400,670,450); 
    
    jRadioButton1 = new JRadioButton(); 
  
        // Initialization of object of "JRadioButton" class. 
        jRadioButton2 = new JRadioButton(); 
        JRadioButton jRadioButton3 = new JRadioButton(); 
  
        // Initialization of object of "JButton" class. 
       
  
        // Initialization of object of "ButtonGroup" class. 
        G1 = new ButtonGroup(); 
  
        // Initialization of object of " JLabel" class. 
        L1 = new JLabel("Qualification"); 
  
        // setText(...) function is used to set text of radio button. 
        // Setting text of "jRadioButton2". 
        jRadioButton1.setText("Community hall"); 
  
        // Setting text of "jRadioButton4". 
        jRadioButton2.setText("Rest house"); 
        jRadioButton3.setText("Holiday Homes");
  
        // Setting Bounds of "jRadioButton2". 
        jRadioButton1.setBounds(120, 190, 150, 50); 
  
        // Setting Bounds of "jRadioButton4". 
        jRadioButton2.setBounds(260, 190, 150, 50);
        
        jRadioButton3.setBounds(370, 190, 150, 50);
    
        L1.setBounds(20, 190, 150, 50); 
  
        // "this" keyword in java refers to current object. 
        // Adding "jRadioButton2" on JFrame. 
        this.add(jRadioButton1); 
  
        // Adding "jRadioButton4" on JFrame. 
        this.add(jRadioButton2); 
        this.add(jRadioButton3);
  
        // Adding "jButton" on JFrame. 
       
        // Adding JLabel "L2" on JFrame. 
        this.add(L1); 
  
        // Adding "jRadioButton1" and "jRadioButton3" in a Button Group "G2". 
        G1.add(jRadioButton1); 
        G1.add(jRadioButton2); 
        G1.add(jRadioButton3);
        
        
        
        
        String s1[] = { "Pune", "Mumbai", "Noida", "Kolkata", "New Delhi" }; 
  
        // create checkbox 
        JComboBox loc = new JComboBox(s1); 
        this.add(loc);
        loc.setBounds(120, 230, 180, 50);
        
        
        pincode = new JTextField("pincode");
        pincode.setBounds(340,230,180,50);
  
        // add ItemListener 
//        c1.addItemListener(s);
        
        
        back.addActionListener(new ActionListener(){
        @Override
     public void actionPerformed(ActionEvent e){
         AdminDashboard a = new AdminDashboard();
         a.setVisible(true);
//         this.setVisible(false);
     }
    });
    
  
    //button to browse the image into jlabel
    button2.addActionListener(new ActionListener(){
        @Override
     public void actionPerformed(ActionEvent e){
         JFileChooser fileChooser = new JFileChooser();
         fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
         FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
         fileChooser.addChoosableFileFilter(filter);
         int result = fileChooser.showSaveDialog(null);
         if(result == JFileChooser.APPROVE_OPTION){
             File selectedFile = fileChooser.getSelectedFile();
             String path = selectedFile.getAbsolutePath();
             label.setIcon(ResizeImage(path));
             s = path;
              }
         else if(result == JFileChooser.CANCEL_OPTION){
             System.out.println("No Data");
         }
     }
    });

    //button to insert image and some data into mysql database
    button.addActionListener(new ActionListener(){
    
       @Override
       public void actionPerformed(ActionEvent e){
           try{
               Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rail","root","");
               PreparedStatement ps = con.prepareStatement("insert into house values(?,?,?,?,?,?,?,?)");
               
                jRadioButton1.setActionCommand("Community hall");
                jRadioButton2.setActionCommand("Rest Room");
                jRadioButton3.setActionCommand("Holiday Home");
               
               String item=(String)G1.getSelection().getActionCommand();
               
               String loc1=(String) loc.getSelectedItem();
               
               InputStream is = new FileInputStream(new File(s));
               ps.setString(1, textID.getText());
               ps.setString(2, textNAME.getText());
               ps.setInt(3,9);
               ps.setString(4,item);
                ps.setInt(5,1);
                ps.setString(6,price.getText());
                ps.setBlob(7,is);
                ps.setString(8,pincode.getText());
               
               
               ps.executeUpdate();
               JOptionPane.showMessageDialog(null, "Data Inserted");
           }catch(Exception ex){
               ex.printStackTrace();
           }
       }
    });

    add(label);
    add(textID);
    add(textNAME);
    add(price);
//    add(pane);
    add(button);
    add(button2);
    add(back);
    add(pincode);
    setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(800,800);
    setVisible(true);
    }
    
    //Methode To Resize The ImageIcon
    public ImageIcon ResizeImage(String imgPath){
        ImageIcon MyImage = new ImageIcon(imgPath);
        Image img = MyImage.getImage();
        Image newImage = img.getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }
 
    public static void main(String[] args){
        new house();
    }
   }