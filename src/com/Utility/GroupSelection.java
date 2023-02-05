package com.Utility;

import java.util.LinkedList;
import java.util.Queue;

import com.Bean.Group;

public class GroupSelection {
	
	static int height;
	static int width;
	static Queue<int[]> recursionQueue= new LinkedList<>();
	static int recursiveCounter = 0;
	
	public static void groupSelection() {
		
		width = MidService.imageData.getSize()[0];
		height = MidService.imageData.getSize()[1];
		
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				
				if(isValid(x, y) == true) {
					recursionQueue.add(new int[]{x, y});
					Group group = new Group();
//					recursiveDectect(group, x, y);
//					group.findDensity();
//					MidService.orderByDensity(group);
//					MidService.groupList.add(group);
//					System.out.println(x +" "+y);
					while(recursionQueue.isEmpty() == false) {
						recursiveCounter = 0;
						int[] tempCoord = recursionQueue.poll();
						recursiveDectect(group, tempCoord[0], tempCoord[1]);
//						System.out.println("here");
					}
//					System.out.println("here");
					group.findDensity();
					MidService.orderByDensity(group);
				}
			} 
		}
		
//		for(Group p : MidService.groupList) {
//			p.findMinMax();
//		}
		
	}
	
	
	static int[][] temp = {{-1, 0},{0, -1},{1, 0},{0, 1}};
	public static boolean recursiveDectect(Group group, int x, int y) {

//		System.out.println(recursiveCounter);
		if(recursiveCounter > MidService.maxRecursion) {
			return false;
		}
		if(x >= 0 && x < width && y >= 0 && y <height) 
		{
			if(MidService.processedArray[x][y] == 1) 
			{
				group.addPoint(x, y);
				MidService.initProcessedImage.setRGB(x, y, -16777216);
				MidService.processedArray[x][y] = 0;
			
				for(int[] element: temp)
				{
					int newX = x + element[0];
					int newY = y + element[1];
					recursionQueue.add(new int[]{newX, newY});
					recursiveCounter++;
					recursiveDectect(group, newX, newY);
				}
			}
		}
		
		return true;
	}
	
	public static boolean isValid(int x, int y) {
		
		if(x >= 0 && x < width && y >= 0 && y <height) {
			if(MidService.processedArray[x][y] == 1) {
				return true;
			}
		}
		
		return false;
	}
}
