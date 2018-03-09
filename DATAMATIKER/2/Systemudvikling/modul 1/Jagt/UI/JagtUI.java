package UI;

import Controller.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
/**
 * 
 * @author Henrik Munk Hvarregaard
 */
public class JagtUI
{
    // instance variables

    private JFrame frame;    
    private JButton JBstart;
    private JagtCtr jCtr;

    /**
     * Constructor for objects of class JagtUI
     */
    public JagtUI()
    {
        jCtr = new JagtCtr();
        makeFrame();
    }
    
    private void makeFrame()
    {
        frame = new JFrame("JagtUI");                
        Container contentPane = frame.getContentPane();  
        contentPane.setLayout(new BorderLayout(0, 1)); 
        
        JBstart = new JButton("Tag på jagt");     
        contentPane.add(JBstart, BorderLayout.CENTER);   
        
        JBstart.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { tagPaaJagt(); }
                           });   
        
        frame.pack();        
        frame.setVisible(true);
    }
    
    private void tagPaaJagt()
    {
        jCtr.nedlaegDyr(1, "Lumbricus terrestris");
    }

   
}
