package com.orowheat.kler;

public class HexToRGB {
	//Function to cut the "#" away from the hexadecimal color code
	public static String cutHex(String h){
		return h.startsWith("#")?h.substring(1,h.length()):h;
	}
	//Return red value of the Hex number on a scale of 0-1 rather than 0-255, for use in MTL file
	public static double hexToR(String h){
		int i=Integer.parseInt((cutHex(h).substring(0, 2)),16);
		return (i/(double)255);
	}
	//Return red value on scale of 0-255 for idk lol reasons?
	public static double hexToR(String h,boolean integerMode){
		int i=Integer.parseInt((cutHex(h).substring(0, 2)),16);
		return integerMode?i:(i/(double)255);
	}
	//Return green value in MTL format
	public static double hexToG(String h){
		int i=Integer.parseInt((cutHex(h).substring(2, 4)),16);
		return (i/(double)255);
	}
	//Return green value on scale of 0-255
	public static double hexToG(String h,boolean integerMode){
		int i=Integer.parseInt((cutHex(h).substring(2, 4)),16);
		return integerMode?i:(i/(double)255);
	}
	//Return blue value in MTL format
		public static double hexToB(String h){
			int i=Integer.parseInt((cutHex(h).substring(4, 6)),16);
			return (i/(double)255);
		}
	//Return blue value on scale of 0-255
	public static double hexToB(String h,boolean integerMode){
		int i=Integer.parseInt((cutHex(h).substring(4, 6)),16);
		return integerMode?i:(i/(double)255);
	}
	//Return hex number as RGB, formatted to shove into an MTL file easily
	public static String[] hexToRGB(String h){
		String[] rgb=new String[3];
		String s=String.valueOf(hexToR(h))+"   "+String.valueOf(hexToG(h))+"   "+String.valueOf(hexToB(h))+" ";
		rgb[0]="Ka  "+s;
		rgb[1]="Kd  "+s;
		rgb[2]="Ks  "+s;
		return rgb;
	}
}
