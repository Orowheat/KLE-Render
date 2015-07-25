package com.orowheat.kler;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class KLERCore {
	final static String[] mtlConst={"d 1.0","Tf 1.0","illum 2","Ns  690 ","Ni 1.0",""};
	final static String[] mtlCherryConst1={"Ka  0.149019607843137   0.149019607843137   0.149019607843137 ",
			"Kd  0.149019607843137   0.149019607843137   0.149019607843137 ",
			"Ks  0.149019607843137   0.149019607843137   0.149019607843137 "};
	final static String[] mtlCherryConst2={"Ka  0.266666666666667   0.192156862745098   0.125490196078431 ",
			"Kd  0.266666666666667   0.192156862745098   0.125490196078431 ",
			"Ks  0.266666666666667   0.192156862745098   0.125490196078431 "};
	public static void main(JTextArea jta, JLabel jl) throws FileNotFoundException{
		//Initialize scanner and other assorted things
		Scanner scan=new Scanner(jta.getText());
		String kbMeta;
		String[] rawData=new String[6];
		ArrayList<ArrayList<String[]>> procData=new ArrayList<ArrayList<String[]>>();
		PrintWriter writer;
		boolean rightMods=false;
		boolean numSymb=false;
		boolean rightShift=false;
		boolean keyFlag=false;
		boolean legFlag=false;
		boolean numEnter=false;
		String[] currKeyCol=new String[0];
		String[] currLegCol=new String[0];
		//Get and pre-process(shove the first line into kbMeta) raw data input
		jl.setText("parsing input");
		kbMeta=scan.nextLine();
		int z=0;
		if(!kbMeta.startsWith("{")){
			rawData[0]=kbMeta.replace("\\\"\\n'", "Quote").replace("\"DSA\"", "DSA").replace("\"\"", "Spacebar").replace("{\\n[", "Curly1").replace("}\\n]","Curly2");
			kbMeta="eeeeee";
			z=1;
		}
		for(int x=z;x<6;x++){
			//cheesy regex workaround below, don't touch it it works
			rawData[x]=scan.nextLine().replace("\\\"\\n'", "Quote").replace("\"DSA\"", "DSA").replace("\"\"", "Spacebar").replace("{\\n[", "Curly1").replace("}\\n]","Curly2");
		}
		scan.close();
		//Fill 3D array with formatted rawData.  Includes fancy regex.
		for(int x=0;x<rawData.length;x++){
			String[] splitted=rawData[x].split("(?<!^)(\\{|\\}|\\[|\\],|\\])");
			procData.add(new ArrayList<String[]>());
			for(int y=0;y<splitted.length;y++){
				procData.get(x).add(splitted[y].split("(\",\"|\",|,\"|\"|,)"));
			}
			procData.get(x).remove(0);
		}
		//emergency print yo stuff. you know, for emergencies
		/*for(int x=0;x<procData.size();x++){
			for(int y=0;y<procData.get(x).size();y++){
				for(String s:procData.get(x).get(y)){
					System.out.println(s);;
				}
			}
		}*/
		//create printwriter for generating new mtl file
		try {
			writer=new PrintWriter("kbLayout.mtl","UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			System.out.println(e);
			writer=new PrintWriter("kbLayout.mtl");
		}
		//mtl comments
		jl.setText("creating mtl");
		writer.println("#Generated by Orowheat's KLE-Render v2");
		writer.println("#num_materials:210");
		writer.println();
		//write in cherry mx brown colors 
		writeMtlCherry(writer);
		//write in keyboard base color
		if(kbMeta.contains("backcolor:")){
			writeMtl(writer,HexToRGB.hexToRGB(kbMeta.substring(13, 19)),HashStorage.mtlMap.get("KeyboardBase"));
		}
		else{
			writeMtl(writer,HexToRGB.hexToRGB(kbMeta),HashStorage.mtlMap.get("KeyboardBase"));
		}
		//write in all keys
		for(int x=0;x<procData.size();x++){
			for(int y=0;y<procData.get(x).size();y++){
				for(String s:procData.get(x).get(y)){
					//The KLE Raw data works by setting data for the keys to come, then listing which keys use this data
					//The way I parsed the raw data, even y values mean data, and odd y values mean key names
					if(y%2==0){
						//pull the data for key color(c) and legend color(t).  ignore everything else
						//keyFlag and legFlag are needed because the actual color comes after the c: and t: values
						if(keyFlag){
							currKeyCol=HexToRGB.hexToRGB(s);
							keyFlag=false;
						}
						if(legFlag){
							currLegCol=HexToRGB.hexToRGB(s);
							legFlag=false;
						}
						if(s.startsWith("c:")){
							keyFlag=true;
						}
						if(s.startsWith("t:")){
							legFlag=true;
						}
					}
					//string.split left some blank entries behind.  I know why they're there, but i can't fix it
					//this is a workaround
					else if(!s.equals("")){
						//cut off all legend data not in the first row, because the hashmap works that way
						if(s.contains("\\n")){
							s=s.substring(0,s.indexOf("\\n"));
						}
						//special exceptions for 7(actually 14) keys, because they share the same name
						//don't really have a more elegant way of doing this
						//the numpad 4 has a question mark after it after processing.  idk why, workaround added
						//This first one just sets right/left for ctrl and super
						if(s.toLowerCase().contains("ctrl")||s.toLowerCase().contains("super")||s.toLowerCase().contains("win")){
							s=(rightMods?"Right":"Left")+s;
						}
						//Since alt is the last key on the left (moving left to right), set boolean to true here
						if(s.toLowerCase().contains("alt")){
							s=(rightMods?"Right":"Left")+s;
							rightMods=true;
						}
						if(s.toLowerCase().contains("shift")){
							s=(rightShift?"R":"L")+s;
							rightShift=true;
						}
						//star/8 and +/= have common keys in the numpad.  workarounds below
						if(s.contains("*")){
							s=(numSymb?"Num":"")+s;
						}
						//+/= is the rightmost of the two.  boolean is set to true here.
						if(s.contains("+")){
							s=(numSymb?"Num":"")+s;
							numSymb=true;
						}
						if(!s.equals("F4")&&s.contains("4")){
							s="4";
						}
						if(s.toLowerCase().contains("enter")){
							s=(numEnter?"Num":"")+s;
							numEnter=true;
						}
						if(s.toLowerCase().contains("return")){
							numEnter=true;
						}
						//System.out.println(s);
						jl.setText("Converting "+s);
						//all special cases dealt with.  begin setting key color
						writeMtl(writer,currKeyCol,HashStorage.mtlMap.get(s));
						//set legend color, exclude spacebar for legends
						if(!s.contains("Spacebar")){
							writeMtl(writer,currLegCol,HashStorage.mtlMap.get(s+"Legend"));
						}
					}
				}
			}
		}
		writer.close();
		jl.setText("MTL Generated.  Filename is kbLayout.mtl");
		jta.setText("");
	}
	//function for writing in a whole mtl entry, with correct spacing.  pretty straightforward
	private static void writeMtl(PrintWriter writer, String[] h, int num){
		writer.println("newmtl "+num+" ");
		for(String s:h){
			writer.println(s);
		}
		for(String s:mtlConst){
			writer.println(s);
		}
	}
	//Write cherry mx brown colors to the mtl file
	private static void writeMtlCherry(PrintWriter writer){
		writer.println("newmtl 1 ");
		for(String s:mtlCherryConst1){
			writer.println(s);
		}
		for(String s:mtlConst){
			writer.println(s);
		}
		writer.println("newmtl 2 ");
		for(String s:mtlCherryConst2){
			writer.println(s);
		}
		for(String s:mtlConst){
			writer.println(s);
		}
	}
}
