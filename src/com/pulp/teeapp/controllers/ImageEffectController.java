package com.pulp.teeapp.controllers;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.pulp.teeapp.controllers.ImageConvolutionMatrix;

public class ImageEffectController {

	
	Button button;
	ImageView image;
	private Bitmap bmp;
	private Bitmap operation;
	private ImageView img;
	
	public  Bitmap createContrast(Bitmap src, double value) {
	    // image size
	    int width = src.getWidth();
	    int height = src.getHeight();
	    // create output bitmap
	    Bitmap bmOut= Bitmap.createBitmap(src.getWidth(),src.getHeight(),src.getConfig());
	    
	    // color information
	    int A, R, G, B;
	    int pixel;
	    // get contrast value
	    double contrast = Math.pow((100 + value) / 100, 2);
	 
	    // scan through all pixels
	    for(int x = 0; x < width; ++x) {
	        for(int y = 0; y < height; ++y) {
	            // get pixel color
	            pixel = src.getPixel(x, y);
	            A = Color.alpha(pixel);
	            // apply filter contrast for every channel R, G, B
	            R = Color.red(pixel);
	            R = (int)(((((R / 255.0) - 0.5) * contrast) + 0.5) * 255.0);
	            if(R < 0) { R = 0; }
	            else if(R > 255) { R = 255; }
	 
	            G = Color.red(pixel);
	            G = (int)(((((G / 255.0) - 0.5) * contrast) + 0.5) * 255.0);
	            if(G < 0) { G = 0; }
	            else if(G > 255) { G = 255; }
	 
	            B = Color.red(pixel);
	            B = (int)(((((B / 255.0) - 0.5) * contrast) + 0.5) * 255.0);
	            if(B < 0) { B = 0; }
	            else if(B > 255) { B = 255; }
	 
	            // set new pixel color to output bitmap
	            bmOut.setPixel(x, y, Color.argb(A, R, G, B));
	        }
	    }
	 
	    // return final image
	    return bmOut;
		
	}
	
public void gray(View view)
	{
	// constant factors
			final double GS_RED = 0.299;
			final double GS_GREEN = 0.587;
			final double GS_BLUE = 0.114;

			// create output bitmap
			//Bitmap bmOut = Bitmap.createBitmap(src.getWidth(), src.getHeight(), src.getConfig());
			
			operation= Bitmap.createBitmap(bmp.getWidth(),bmp.getHeight(),bmp.getConfig());
			// pixel information
			int A, R, G, B;
			int pixel;

			// get image size
			int width = bmp.getWidth();
			int height = bmp.getHeight();

			// scan through every single pixel
			for(int x = 0; x < width; ++x) {
				for(int y = 0; y < height; ++y) {
					// get one pixel color
					pixel = bmp.getPixel(x, y);
					// retrieve color of all channels
					A = Color.alpha(pixel);
					R = Color.red(pixel);
					G = Color.green(pixel);
					B = Color.blue(pixel);
					
				
			           
					// take conversion up to one single value
					R = G = B = (int)(GS_RED * R + GS_GREEN * G + GS_BLUE * B);
					// set new pixel color to output bitmap
					operation.setPixel(x, y, Color.argb(A, R, G, B));
					
				}
			}

		img.setImageBitmap(operation);
	}


 public void bright(View view){
	 

	 Bitmap bmpMod= createContrast(bmp, 50) ;
	 img.setImageBitmap(bmpMod);
	
	
}
 
// 1. To use this
// public void dark(View view){
//
//	Bitmap bmpMod = createSepiaToningEffect( bmp, 100,1.5, 0.6, 0.12) ;
//	img.setImageBitmap(bmpMod);
//}
 
//2. To use this
// public void dark(View view){
//
//		Bitmap bmpMod = createSepiaToningEffect( bmp, 30,1.5, 0.6, 0.12) ;
//		img.setImageBitmap(bmpMod);
//	}

//3. To use this
// public void dark(View view){
//
//		Bitmap bmpMod = createSepiaToningEffect( bmp,80,1.2, 0.87, 2.1) ;
//		img.setImageBitmap(bmpMod);
//	}
 
//4. To use this
//public void dark(View view){
//
//		Bitmap bmpMod = createSepiaToningEffect( bmp,40,0.88, 2.45, 1.43) ;
//		img.setImageBitmap(bmpMod);
//	}
//5. To use this
//public void dark(View view){
//
//	Bitmap bmpMod = createContrast(bmp,1) ;
//	img.setImageBitmap(bmpMod);
//}
 
//6. To use this
//public void dark(View view){
//
//	Bitmap bmpMod = doBrightness(bmp,50) ;
//	img.setImageBitmap(bmpMod);
//}
//7. To use this
//public void dark(View view){
//
//	Bitmap bmpMod = doBrightness(bmp,-20) ;
//	img.setImageBitmap(bmpMod);
//}
//8. To use this
//public void dark(View view){
//
//	Bitmap bmpMod = applyGaussianBlur(bmp);//,400) ;
//	img.setImageBitmap(bmpMod);
//}
//9. To use this
//public void dark(View view){
//
//	Bitmap bmpMod = boost(bmp,  1,  1);//,400) ;
//	img.setImageBitmap(bmpMod);
//}
//10. To use this
//public void dark(View view){
//
//	Bitmap bmpMod = boost(bmp,  3,  1);//,400) ;
//	img.setImageBitmap(bmpMod);
//}


public Bitmap sharpen(Bitmap src, double weight) {
    double[][] SharpConfig = new double[][] {
        { 0 , -2    , 0  },
        { -2, weight, -2 },
        { 0 , -2    , 0  }
    };
    ImageConvolutionMatrix convMatrix = new ImageConvolutionMatrix(3);
    convMatrix.applyConfig(SharpConfig);
    convMatrix.Factor = weight - 8;
    Bitmap map= ImageConvolutionMatrix.computeConvolution3x3(src, convMatrix);
    return map;
}

public  Bitmap boost(Bitmap src, int type, float percent) {
	int width = src.getWidth();
	int height = src.getHeight();
	Bitmap bmOut = Bitmap.createBitmap(width, height, src.getConfig());

	int A, R, G, B;
	int pixel;

	for(int x = 0; x < width; ++x) {
		for(int y = 0; y < height; ++y) {
			pixel = src.getPixel(x, y);
			A = Color.alpha(pixel);
			R = Color.red(pixel);
			G = Color.green(pixel);
			B = Color.blue(pixel);
			if(type == 1) {
				R = (int)(R * (1 + percent));
				if(R > 255) R = 255;
			}
			else if(type == 2) {
				G = (int)(G * (1 + percent));
				if(G > 255) G = 255;
			}
			else if(type == 3) {
				B = (int)(B * (1 + percent));
				if(B > 255) B = 255;
			}
			bmOut.setPixel(x, y, Color.argb(A, R, G, B));
		}
	}
	return bmOut;
}
public  Bitmap applyGaussianBlur(Bitmap src) {
    double[][] GaussianBlurConfig = new double[][] {
        { 1, 0, 4 },
        { 0, 4, 0},
        { -1, 2, -1 }
    };
    
    ImageConvolutionMatrix convMatrix = new ImageConvolutionMatrix(3);
    convMatrix.applyConfig(GaussianBlurConfig);
    convMatrix.Factor = 16;
    convMatrix.Offset = 0;
   
    Bitmap map= ImageConvolutionMatrix.computeConvolution3x3(src, convMatrix);
    return map;
}



 public static Bitmap doBrightness(Bitmap src, int value) {
	    // image size
	    int width = src.getWidth();
	    int height = src.getHeight();
	    // create output bitmap
	    Bitmap bmOut = Bitmap.createBitmap(width, height, src.getConfig());
	    // color information
	    int A, R, G, B;
	    int pixel;
	 
	    // scan through all pixels
	    for(int x = 0; x < width; ++x) {
	        for(int y = 0; y < height; ++y) {
	            // get pixel color
	            pixel = src.getPixel(x, y);
	            A = Color.alpha(pixel);
	            R = Color.red(pixel);
	            G = Color.green(pixel);
	            B = Color.blue(pixel);
	 
	            // increase/decrease each channel
	            R += value;
	            if(R > 255) { R = 255; }
	            else if(R < 0) { R = 0; }
	 
	            G += value;
	            if(G > 255) { G = 255; }
	            else if(G < 0) { G = 0; }
	 
	            B += value;
	            if(B > 255) { B = 255; }
	            else if(B < 0) { B = 0; }
	 
	            // apply new pixel color to output bitmap
	            bmOut.setPixel(x, y, Color.argb(A, R, G, B));
	        }
	    }
	 
	    // return final image
	    return bmOut;
}
 
 
 public Bitmap createSepiaToningEffect(Bitmap src, int depth, double red, double green, double blue) {
	    // image size
	    int width = src.getWidth();
	    int height = src.getHeight();
	    // create output bitmap
	    Bitmap bmOut = Bitmap.createBitmap(width, height, src.getConfig());
	    // constant grayscale
	    final double GS_RED = 0.3;
	    final double GS_GREEN = 0.59;
	    final double GS_BLUE = 0.11;
	    // color information
	    int A, R, G, B;
	    int pixel;
	 
	    // scan through all pixels
	    for(int x = 0; x < width; ++x) {
	        for(int y = 0; y < height; ++y) {
	            // get pixel color
	            pixel = src.getPixel(x, y);
	            // get color on each channel
	            A = Color.alpha(pixel);
	            R = Color.red(pixel);
	            G = Color.green(pixel);
	            B = Color.blue(pixel);
	            
	          //  Log.d("Ritu", "%s"+A);
	            
	            // apply grayscale sample
	            B = G = R = (int)(GS_RED * R + GS_GREEN * G + GS_BLUE * B);
	 
	            // apply intensity level for sepid-toning on each channel
	            R += (depth * red);
	            if(R > 255) { R = 255; }
	 
	            G += (depth * green);
	            if(G > 255) { G = 255; }
	 
	            B += (depth * blue);
	            if(B > 255) { B = 255; }
	            
	            // set new pixel color to output image
	            bmOut.setPixel(x, y, Color.argb(A, R, G, B));
	        }
	    }
	    
	    // return final image
	   return bmOut;
	}
		         
		
}

