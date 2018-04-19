import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frames {
	//Returns the Error Frame
	public JFrame FileError() {
		JFrame errorJ= new JFrame();
		JLabel errorL= new JLabel();
		errorL.setVerticalAlignment(JLabel.TOP);
		errorL.setVerticalTextPosition(JLabel.TOP);
		errorL.setText("<html> The File name you entered is invalid, Please close the window and retry.<br/> Goodbye!");
		errorJ.setSize(400,200);
		errorJ.setTitle("Shutting Down");
		errorJ.getContentPane().add(errorL);
		errorL.setFont(new Font("Serif", Font.PLAIN, 30));
		errorJ.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return errorJ;
	}
	//Returns the File as been saved JFrame
	public JFrame Saved() {
		JFrame savedJ= new JFrame();
		JLabel savedL= new JLabel();
		savedL.setVerticalAlignment(JLabel.TOP);
		savedL.setVerticalTextPosition(JLabel.TOP);
		savedL.setText("<html> Your new picture has been saved!\nI will now shutdown.\nGoodbye!");
		savedJ.setSize(400,200);
		savedJ.setTitle("Shutting Down");
		savedJ.getContentPane().add(savedL);
		savedL.setFont(new Font("Serif", Font.PLAIN, 30));
		savedJ.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return savedJ;
	}
}