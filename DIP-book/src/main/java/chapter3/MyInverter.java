package chapter3;

import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;


public class MyInverter implements PlugInFilter {

	@Override
	public void run(ImageProcessor ip) {
			int w = ip.getWidth();
			int h = ip.getHeight();
			
			for (int u = 0; u < w; u++){
				for (int v = 0; v < h; v++){
					int p = ip.getPixel(u, v);
					ip.putPixel(u, v, 255-p);
				}
			}
		
	}

	@Override
	public int setup(String arg, ImagePlus imp) {
		return DOES_8G; // just works on 8-bit image
	}

}