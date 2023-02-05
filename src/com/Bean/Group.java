package com.Bean;

import java.awt.Point;
import java.util.ArrayList;

import com.Utility.MidService;

public class Group {
	
	private double density = 0.0;
	private int[] minCoord = {Integer.MAX_VALUE, Integer.MAX_VALUE};
	private int[] maxCoord = {Integer.MIN_VALUE, Integer.MIN_VALUE};
//	private int[] minCoord = {0, 0};
//	private int[] maxCoord = {0, 0};
	
//	private ArrayList<Point> points = new ArrayList<>();
	private int colorCounter = 0;
	
	public Group() {
		
	}
	
	public void addPoint(int x, int y) {
		
//		System.out.println()
		if(x < minCoord[0]) {
			minCoord[0] = x;
		}
		if(x > maxCoord[0]) {
			maxCoord[0] = x;
		}
		
		if(y < minCoord[1]) {
			minCoord[1] = y;
		}
		if(y > maxCoord[1]) {
			maxCoord[1] = y;
		}
//		points.add(new Point(x, y));
		colorCounter++;
	}
	
//	public void findMinMax() {
//		
//		double minX = points.get(0).getX();
//		double minY = points.get(0).getY();
//		double maxX = points.get(0).getX();
//		double maxY = points.get(0).getY();
//		
//		for(Point p : points) {
//			
//			if(minX > p.getX()) {
//				minX = p.getX();
//			}
//			else if(maxX < p.getX()) {
//				maxX = p.getX();
//			}
//			
//			if(minY > p.getY()) {
//				minY = p.getY();
//			}
//			else if(maxY < p.getY()) {
//				maxY = p.getY();
//			}
//		}
//		
//		minCoord = new int[] {(int)minX, (int)minY};
//		maxCoord = new int[] {(int)maxX, (int)maxX};
//		
//	}
	
	public void findDensity() {
		
		double gridAmount = (maxCoord[0] - minCoord[0] + 1) * (maxCoord[1] - minCoord[1] + 1);
		this.density = (double)colorCounter / gridAmount;
		
		if(gridAmount < MidService.minGridAmount || gridAmount > MidService.maxGridAmount) {
			this.density = 2;
		}
		
//		this.density = (double)colorCounter;
	}
	
	public double getDensity() {
		return this.density;
	}
	
	public int[] getMaxCoord() {
		return this.maxCoord;
	}
	
	public int[] getMinCoord() {
		return this.minCoord;
	}
}
