// import statements  
import java.awt.*;    
import javax.swing.*;    
    
public class GridLayoutExample  
{    
JFrame frameObj;    
  
// constructor  
GridLayoutExample()  
{    
frameObj = new JFrame();    
  
// creating 9 buttons  
ImageIcon img = new ImageIcon("./images/mic.png");


JButton btn1 = new JButton(img);    
JButton btn2 = new JButton(img);    
JButton btn3 = new JButton(img);    

    
// adding buttons to the frame  
// since, we are using the parameterless constructor, therfore;   
// the number of columns is equal to the number of buttons we   
// are adding to the frame. The row count remains one.  
frameObj.add(btn1); frameObj.add(btn2); frameObj.add(btn3);  

  
// setting the grid layout using the parameterless constructor    
frameObj.setLayout(new GridLayout(1, 3, 20, 100));    
  
  
frameObj.setSize(800, 600);    
frameObj.setVisible(true);    
}  
  
// main method  
public static void main(String argvs[])   
{    
new GridLayoutExample();    
}    
}    