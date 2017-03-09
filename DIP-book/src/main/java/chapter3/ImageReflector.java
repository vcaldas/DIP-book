package chapter3;

import ij.IJ;
import ij.ImagePlus;
import ij.gui.GenericDialog;
import ij.plugin.filter.ExtendedPlugInFilter;
import ij.plugin.filter.PlugInFilterRunner;
import ij.process.ImageProcessor;

public class ImageReflector implements ExtendedPlugInFilter {

	private int flags = DOES_8G;
	private String[] directions = {"Vertical", "Horizontal"};
	private String reflection;
	
	
	public ImageReflector() {
		
	}
	
	public ImageReflector(String reflection) {
		this.reflection = reflection;
	}
	
	
	@Override
	public void run(ImageProcessor ip) {
		
		ImageProcessor duplicate = ip.duplicate();
		
		int h = ip.getHeight();
		int w = ip.getWidth();
		// Vertical reflection
		//Invert direction collumn position
		if(reflection == "Vertical"){
			
		for (int u = 0; u < w; u++){ // rows
			for (int v = 0; v < h; v++){ // collumns
				int pixelValue = ip.getPixel(u, v);
				duplicate.putPixel(u, h-v, pixelValue);
			}
		}
		}
		else if (reflection == "Horizontal"){
			for (int u = 0; u < w; u++){ // rows
				for (int v = 0; v < h; v++){ // collumns
					int pixelValue = ip.getPixel(u, v);
					duplicate.putPixel(h-u, v, pixelValue);
				}
			}
			
			
		}
		
	}

	@Override
	public int setup(String arg, ImagePlus imp) {
		return flags;
	}


	public int showDialog(ImagePlus imp, String arg, PlugInFilterRunner pfr) {
		
		GenericDialog dialog = new GenericDialog("Image Reflector");
		dialog.addRadioButtonGroup(null,directions, 2,1,directions[0]);
		dialog.addPreviewCheckbox(pfr);
		dialog.showDialog();
		
		if (dialog.wasCanceled())
			return DONE;
		
		return IJ.setupDialog(imp, flags);
	}

	@Override
	public void setNPasses(int arg0) {
		// TODO Auto-generated method stub
		
	}

	

}
