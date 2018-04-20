import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Tester extends ImageUtils implements ActionListener{

	public static void main(String[] args) {
		ImageUtils image=new ImageUtils();
		Editor edit=new Editor();
		Frames frames=new Frames();
		JFrame inputname= new JFrame();
		JFrame outputFrame= new JFrame();
		//Asks for input name
		String filename= (String)JOptionPane.showInputDialog(
	            inputname,
	            "Please enter the filename of the picture you/n wish to manipulate (include .png(jpg) etc..",
	            "Input File Name",
	            JOptionPane.PLAIN_MESSAGE);
		//Asks for output name
		String outputname= (String)JOptionPane.showInputDialog(
	            outputFrame,
	            "Please Enter your desired output File name (do not include a .png(jpg ect)",
	            "Output File Name",
	            JOptionPane.PLAIN_MESSAGE)+".png";
		//Pulls in each color array option for Editor
		Color[][] original = image.loadImage(filename);
	    Color[][] gray = edit.Grayscale(original);
	   	Color[][] purple= edit.Purple(original);
	   	Color[][] sephia = edit.Sephia(original);
	   	Color[][] green = edit.Green(original);
	   	Color[][] rotate90= edit.Rotate90Right(original);
    	Color[][] rotate180=edit.Rotate90Right(ImageUtils.cloneArray(rotate90));	    	
    	Color[][] rotate270=edit.Rotate90Right(ImageUtils.cloneArray(rotate180));
    	//Adds each array to the tabbedpane from ImageUtils
	   	image.addImage(original, "Original");
	   	image.addImage(gray, "Grayscale");
	   	image.addImage(purple, "Purple");
	   	image.addImage(sephia, "Sephia");
    	image.addImage(green, "Green");
    	image.addImage(rotate90, "90 degrees");
	    image.addImage(rotate180, "180 degrees");
	    image.addImage(rotate270, "270 degrees");
	    //pulls in display
		image.display(original);
		//Useless while loop to keep the window open until a decision has been made
			int saveoption=image.decision;
				while(saveoption==0) {
					saveoption=image.decision;
					System.out.print("");
				}
				saveoption=image.decision;
				//Creates the chosen array
				Color[][] result=ImageUtils.cloneArray(original);
					if(saveoption==1) {
						result=ImageUtils.cloneArray(gray);
					}if(saveoption==2) {
						result=ImageUtils.cloneArray(purple);
					}if(saveoption==3) {
						result=ImageUtils.cloneArray(sephia);
					}if(saveoption==4) {
						result=ImageUtils.cloneArray(green);
					}if(saveoption==5) {
						result=ImageUtils.cloneArray(rotate90);
					}if(saveoption==6) {
						result=ImageUtils.cloneArray(rotate180);
					}if(saveoption==7) {
						result=ImageUtils.cloneArray(rotate270);
					}
					//Tries to save that image
				try {
					// retrieve image
					File outputfile = new File(outputname);
					BufferedImage output=ImageUtils.convertToBufferedFrom2D(result);
					ImageIO.write(output, "png", outputfile);
					JFrame saved=frames.Saved();
					saved.setVisible(true);
				} catch (Exception b) {
					System.out.println("Could not save the image, please ensure the filepath"
		    				+ " was properly specified.");
		    		System.exit(1);
				}
	}
}