package com.Driver;

import java.awt.Color;
import java.io.IOException;
import java.util.Arrays;

import com.Bean.Group;
import com.Display.Display;
import com.Utility.FindColor;
import com.Utility.GroupSelection;
import com.Utility.MidService;

public class Driver {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		Display display = new Display();
		
		FindColor.findColor(Color.BLACK);
		GroupSelection.groupSelection();

		display.render.update();

		
	}

}
