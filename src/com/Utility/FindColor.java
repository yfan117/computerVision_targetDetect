package com.Utility;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class FindColor {
	
	public static void findColor(Color targetColor) {
		
		int tolerance = 255/3;
		
		int red = targetColor.getRed();
		int green = targetColor.getGreen();
		int blue = targetColor.getBlue();
//		int mark = Integer.valueOf(Integer.toHexString(targetColor.getRGB()).substring(2));
//		System.out.println(Integer.toHexString(targetColor.getRGB()));
		
		int[][] imageArray = MidService.imageData.getImageArray();
//		System.out.println(imageArray[0]);
		MidService.initProcessedImage = new BufferedImage(MidService.imageData.getSize()[0],
															MidService.imageData.getSize()[1], 
															BufferedImage.TYPE_INT_ARGB);
		
		int width = MidService.imageData.getSize()[0];
		int height = MidService.imageData.getSize()[1];
		MidService.processedArray = new int[width][height];
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
		    
			int hex = imageArray[x][y];
		    int r = (hex & 0xFF0000) >> 16;
		    int g = (hex & 0xFF00) >> 8;
		    int b = (hex & 0xFF);
		    
		    
		    if(r <= red+tolerance && r >= red-tolerance
		    	&&
		    	g <= green+tolerance && g >= green-tolerance
		    	&&
		    	b <= blue+tolerance && b >= blue-tolerance) {
		    	
//		    	System.out.println(targetColor.getRGB());
//		    	MidService.initProcessedImage.setRGB(x, y, targetColor.getRGB());
		    	MidService.processedArray[x][y] = 1;
		    	}
			}
		}	
	}
}
