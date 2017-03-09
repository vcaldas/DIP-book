package chapter3;

import java.io.File;

import ij.IJ;
import ij.ImageJ;
import ij.ImagePlus;
import ij.WindowManager;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;


public class ReflectVertical implements PlugInFilter {

	@Override
	public void run(ImageProcessor ip) {
			int w = ip.getWidth();
			int h = ip.getHeight();
			ImageProcessor ip2 = ip.duplicate();
			
			for (int u = 0; u < w; u++){
				for (int v = 0; v < h; v++){
					int p = ip.getPixel(u, v);
					ip2.putPixel(u, h-v, p);
					
				}
			}
			ImagePlus reflected = new ImagePlus("Reflected Vertical", ip2);
			reflected.show();
		
	}

	@Override
	public int setup(String arg, ImagePlus imp) {
		return DOES_8G; // just works on 8-bit image
	}

	public static void main(String[] args) {
	    new ImageJ();
	    ClassLoader loader = ReflectVertical.class.getClassLoader();
	    File file = new File(loader.getResource("images"+ File.separator + "clown8bit.tif").getFile());
	    
	    ImagePlus image = IJ.openImage(file.getAbsolutePath());
	    
	    IJ.runPlugIn(image, "chapter3.ReflectVertical", "parameter=Hello");
	    
	    image.show();
	    WindowManager.addWindow(image.getWindow());
	}
}