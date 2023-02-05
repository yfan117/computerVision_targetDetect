package com.Utility;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;

import com.Bean.Group;
import com.Bean.ImageData;

public class MidService {
	
	public static int[] windowSize = {1920/2, 1080/2};
	public static int[] imageSize = {984, 656};
//	public static int[] imageSize = {1920, 1080};

	public static String URL = "D:\\resource\\SUAS\\";
	public static String imageName = "david.jpg";
	public static ImageData imageData;
	public static BufferedImage initProcessedImage;
	public static BufferedImage resizedImage;
	
	public static int[][] processedArray;
	public static ArrayList<Group> groupList = new ArrayList<>();
	
	public static int[] minCoord = new int[2];
	public static int[] maxCoord = new int[2];
	public static Group maxDesnity;
	
	static int temp = 1;
	public static double[] resized = {imageSize[0]/temp, imageSize[1]/temp};
	public static int minGridAmount = 0;
	public static int maxGridAmount = (int) (resized[0]*resized[1]*1/10);
	public static int maxRecursion = 5000;
	
	//startX, startY, endX, endY, density
	public static ArrayList<double []> orderedGroup = new ArrayList<>();
	public static boolean orderByDensity(Group p) {
		
		double startX = (double)p.getMinCoord()[0]/resized[0];
		double startY = (double)p.getMinCoord()[1]/resized[1];
		double endX = (double)p.getMaxCoord()[0]/resized[0];
		double endY = (double)p.getMaxCoord()[1]/resized[1];
//		System.out.println(p.getDensity());
		
		//can't have 100% match.  Change depending on situation
		if(p.getDensity() >= 1.0) {
			return true;
		}
		for(int i = 0; i < orderedGroup.size(); i++) {
			
			if(p.getDensity() >= orderedGroup.get(i)[4]) {
				
				orderedGroup.add(i, new double[] {startX, startY, endX, endY, p.getDensity()});	
				return true;
			}
		}
		orderedGroup.add(new double[] {startX, startY, endX, endY, p.getDensity()});
		return true;
	}
}
