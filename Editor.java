import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JFrame;

public class Editor {
	//Editor Creates each of the many re-coloring options
	  public Color[][] Grayscale(Color[][] img){
		  int width = img.length;
		    int height = img[0].length;
		    Color[][] result = new Color[width][height];
		    // Iterate through the array, adding new Colors from the intRGB values.
		    for (int row = 0; row < height; row++) {
		      for (int col = 0; col < width; col++) {
		        // Get the integer RGB, and separate it into individual components.
		        // (BufferedImage saves RGB as a single integer value).
		        int intRGB = img[col][row].getRGB();
		        int red = (intRGB >> 16)&255;
		        int green = (intRGB >> 8)&255;
		        int blue = intRGB&255;
		        int avg=(red+green+blue)/3;
		        int gray= (avg<<16) | (avg<<8) | avg;
		        
		        // Set the pixel to the Color.
		        result[col][row] = new Color(gray);
		       }
		   }
		    return result;
	  }
	  public Color[][] Cyanotype(Color[][] img){
		  int width = img.length;
		    int height = img[0].length;
		    Color[][] result = new Color[width][height];
		    // Iterate through the array, adding new Colors from the intRGB values.
		    for (int row = 0; row < height; row++) {
		      for (int col = 0; col < width; col++) {
		        // Get the integer RGB, and separate it into individual components.
		        // (BufferedImage saves RGB as a single integer value).
		        int intRGB = img[col][row].getRGB();
		        int red = (intRGB >> 16)&255;
		        int green = (intRGB >> 8)&255;
		        int blue = intRGB&255;
		        int avg=(red+green+blue)/3;
		        result[col][row] = new Color(avg);
		       }
		   }
		    return result;
	  }
	  public Color[][] Sephia(Color[][] img){
		  int width = img.length;
		    int height = img[0].length;
		    Color[][] result = new Color[width][height];
		    for (int row = 0; row < width; row++) {
		      for (int col = 0; col < height; col++) {
		        int intRGB = img[row][col].getRGB();
		        int red = (intRGB >> 16)&255;
		        int green = (intRGB >> 8)&255;
		        int blue = intRGB&255;
		        //Formula used to change the colors for a Sephia effect
		        double outRed = (red * .393) + (green *.769) + (blue * .18901);
		        double outGreen = (red *.349) + (green *.686) + (blue * .168);
		        double outBlue = (red *.272) + (green *.534) + (blue * .131);
		        int outputRed=(int)outRed;
		        int outputGreen=(int)outGreen;
		        int outputBlue=(int)outBlue;
		        if(outputRed>255) {
		        	outputRed=255;
		        }if(outputBlue>255) {
		        	outputBlue=255;
		        }if(outputGreen>255) {
		        	outputGreen=255;
		        }
		        result[row][col] = new Color(outputRed, outputGreen, outputBlue);
		       }
		   }
		    return result;
	  }
	  public Color[][] Purple(Color[][] img){
		  int width = img.length;
		    int height = img[0].length;
		    Color[][] result = new Color[width][height];
		    for (int row = 0; row < width; row++) {
		      for (int col = 0; col < height; col++) {
		        int intRGB = img[row][col].getRGB();
		        int red = (intRGB >> 16)&255;
		        int green = (intRGB >> 8)&255;
		        int blue = intRGB&255;
		        //Rewritten formula for a Cyan overtone
		        double outRed =  (red *.349) + (green *.686) + (blue * .168);
		        double outGreen =(red *.272) + (green *.534) + (blue * .131);
		        double outBlue = (red * .393) + (green *.769) + (blue * .189);
		        int outputRed=(int)outRed;
		        int outputGreen=(int)outGreen;
		        int outputBlue=(int)outBlue;
		        if(outputRed>255) {
		        	outputRed=255;
		        }if(outputBlue>255) {
		        	outputBlue=255;
		        }if(outputGreen>255) {
		        	outputGreen=255;
		        }
		        result[row][col] = new Color(outputRed, outputGreen, outputBlue);
		       }
		   }
		    return result;
	  }
	  public Color[][] Green(Color[][] img){
		  int width = img.length;
		    int height = img[0].length;
		    Color[][] result = new Color[width][height];
		    for (int row = 0; row < width; row++) {
		      for (int col = 0; col < height; col++) {
		        int intRGB = img[row][col].getRGB();
		        int red = (intRGB >> 16)&255;
		        int green = (intRGB >> 8)&255;
		        int blue = intRGB&255;
		        //formula manipulated for a green overtone
		        double outRed =  (red *.272) + (green *.534) + (blue * .131);
		        double outGreen =(red * .393) + (green *.769) + (blue * .189);
		        double outBlue = (red *.349) + (green *.686) + (blue * .168);
		        int outputRed=(int)outRed;
		        int outputGreen=(int)outGreen;
		        int outputBlue=(int)outBlue;
		        if(outputRed>255) {
		        	outputRed=255;
		        }if(outputBlue>255) {
		        	outputBlue=255;
		        }if(outputGreen>255) {
		        	outputGreen=255;
		        }
		        result[row][col] = new Color(outputRed, outputGreen, outputBlue);
		       }
		   }
		    return result;
	  }
	  //Rotates each pixel to rotate the image
	  public Color[][] Rotate90Right(Color[][] img){
		  Color[][] rotated= new Color[img[0].length][img.length];
		  int width = rotated.length;
		    int height = rotated[0].length;
		    int i=img.length-1;
		    int j=0;
		    Color[][] result = new Color[width][height];
		    // Iterate through the array, adding new Colors from the intRGB values.
		    for (int row = 0; row < height; row++) {
		    	j=0;
		      for (int col = 0; col < width; col++) {
		        result[col][row] =img[i][j];
		        j++;
		       }
		      i--;
		   }
		    return result;
	  }
}