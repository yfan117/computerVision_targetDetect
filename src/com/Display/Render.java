package com.Display;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.swing.JPanel;

import com.Bean.Group;
import com.Bean.ImageData;
import com.Utility.MidService;

public class Render extends JPanel{
	
	public Render() throws IOException {
		this.setBackground(Color.DARK_GRAY);
		MidService.imageData = new ImageData(MidService.URL+MidService.imageName);
	}
	
	public void update() {
		repaint();
	}
	
	Graphics2D g2d;
    public void paintComponent(Graphics g) {
    	g2d = (Graphics2D)g;
        super.paintComponent(g2d);
        
//        g2d.drawImage(MidService.imageData.getImage(),
//        		0,
//        		0,
//        		MidService.imageData.getImage().getWidth(),
//        		MidService.imageData.getImage().getHeight(),
//        		null);
//        g2d.drawImage(MidService.resizedImage,
//        		0,
//        		0,
//        		MidService.resizedImage.getWidth(),
//        		MidService.resizedImage.getHeight(),
//        		null);
        
        g2d.drawImage(MidService.initProcessedImage,
        		0,
        		0,
        		MidService.imageData.getImage().getWidth(),
        		MidService.imageData.getImage().getHeight(),
        		null);
        
//        g2d.drawImage(MidService.resizedImage,
//        		0,
//        		0,
//        		MidService.imageData.getResizedSize()[0],
//        		MidService.imageData.getResizedSize()[1],
//        		null);
        
//        g2d.drawRect(MidService.minCoord[0],
//	        		MidService.minCoord[1], 
//	        		MidService.maxCoord[0], 
//	        		MidService.maxCoord[1]);
        
//		for(Group p : MidService.groupList) {
////			p.findDensity();
//	        g2d.drawRect(p.getMinCoord()[0],
//	        		p.getMinCoord()[1], 
//	        		-p.getMinCoord()[0]+p.getMaxCoord()[0], 
//	        		-p.getMinCoord()[1]+p.getMaxCoord()[1]);
//		}
        if(MidService.orderedGroup.size() != 0) {
	        g2d.setColor(Color.GREEN);
	        g2d.setStroke(new BasicStroke(4));
	        
			for(int i = 0 ; i < MidService.orderedGroup.size(); i++) {
			//	p.findDensity();
//				System.out.println(MidService.orderedGroup.get(i)[4]);
			    g2d.drawRect((int)((MidService.orderedGroup.get(i)[0]*MidService.imageSize[0])),
				    		(int)((MidService.orderedGroup.get(i)[1]*MidService.imageSize[1])), 
				    		-(int)((MidService.orderedGroup.get(i)[0]*MidService.imageSize[0]))+(int)((MidService.orderedGroup.get(i)[2]*MidService.imageSize[0])), 
				    		-(int)((MidService.orderedGroup.get(i)[1]*MidService.imageSize[1]))+(int)((MidService.orderedGroup.get(i)[3]*MidService.imageSize[1])));
			    g2d.drawString(String.valueOf(i), (int)((MidService.orderedGroup.get(i)[2]*MidService.imageSize[0])), (int)((MidService.orderedGroup.get(i)[1]*MidService.imageSize[1])));
			}
        }
//        if(MidService.maxDesnity != null) {
//        	Group p = MidService.maxDesnity;
//	        g2d.drawRect(p.getMinCoord()[0],
//			    		p.getMinCoord()[1], 
//			    		-p.getMinCoord()[0]+p.getMaxCoord()[0], 
//			    		-p.getMinCoord()[1]+p.getMaxCoord()[1]);
//        }
    }
    
    public void markDensity(int x, int y, int x2, int y2) {
    	g2d.drawRect(x, y, x2, y2);
    }


}
