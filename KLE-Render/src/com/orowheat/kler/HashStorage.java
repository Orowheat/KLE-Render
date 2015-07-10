package com.orowheat.kler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HashStorage {
	public static final Map<String,Integer> mtlMap;
	static{
		Map<String,Integer> aMap=new HashMap<String,Integer>();
		aMap.put("KeyboardBase",4);
		aMap.put("QLegend",5);
		aMap.put("Q",6);
		aMap.put("E",7);
		aMap.put("ELegend",8);
		aMap.put("RLegend",9);
		aMap.put("R",10);
		aMap.put("W",11);
		aMap.put("WLegend",12);
		aMap.put("T",13);
		aMap.put("TLegend",14);
		aMap.put("Y",15);
		aMap.put("YLegend",16);
		aMap.put("S",17);
		aMap.put("SLegend",18);
		aMap.put("F",19);
		aMap.put("FLegend",20);
		aMap.put("PLegend",21);
		aMap.put("P",22);
		aMap.put("V",23);
		aMap.put("VLegend",24);
		aMap.put("C",25);
		aMap.put("CLegend",26);
		aMap.put("L",27);
		aMap.put("LLegend",28);
		aMap.put("U",29);
		aMap.put("ULegend",30);
		aMap.put("OLegend",31);
		aMap.put("O",32);
		aMap.put("I",33);
		aMap.put("ILegend",34);
		aMap.put("G",35);
		aMap.put("GLegend",36);
		aMap.put("K",37);
		aMap.put("KLegend",38);
		aMap.put("J",39);
		aMap.put("JLegend",40);
		aMap.put("H",41);
		aMap.put("HLegend",42);
		aMap.put("DLegend",43);
		aMap.put("D",44);
		aMap.put("ALegend",45);
		aMap.put("A",46);
		aMap.put("Z",47);
		aMap.put("ZLegend",48);
		aMap.put("X",49);
		aMap.put("XLegend",50);
		aMap.put("N",51);
		aMap.put("NLegend",52);
		aMap.put("LeftCTRL",53);
		aMap.put("LeftCTRLLegend",54);
		aMap.put("BLegend",55);
		aMap.put("B",56);
		aMap.put("META",57);
		aMap.put("METALegend",58);
		aMap.put("MENU",57);
		aMap.put("MENULegend",58);
		aMap.put("LeftSUPER",59);
		aMap.put("LeftSUPERLegend",60);
		aMap.put("LeftWIN",59);
		aMap.put("LeftWINLegend",60);
		aMap.put("BACK SPACE",61);
		aMap.put("BACK SPACELegend",62);
		aMap.put("LeftALT",63);
		aMap.put("LeftALTLegend",64);
		aMap.put("TAB",65);
		aMap.put("TABLegend",66);
		aMap.put("M",67);
		aMap.put("MLegend",68);
		aMap.put("Spacebar",69);
		aMap.put("#",70);
		aMap.put("#Legend",71);
		aMap.put("&Legend",72);
		aMap.put("&",73);
		aMap.put("!",74);
		aMap.put("!Legend",75);
		aMap.put("*Legend",76);
		aMap.put("*",77);
		aMap.put(")Legend",78);
		aMap.put(")",79);
		aMap.put("Curly2",80);
		aMap.put("Curly2Legend",81);
		aMap.put("CAPS LOCK",82);
		aMap.put("CAPS LOCKLegend",83);
		aMap.put("RETURN",84);
		aMap.put("RETURNLegend",85);
		aMap.put("LSHIFT",86);
		aMap.put("LSHIFTLegend",87);
		aMap.put("RSHIFT",88);
		aMap.put("RSHIFTLegend",89);
		aMap.put("@Legend",90);
		aMap.put("@",91);
		aMap.put("$Legend",92);
		aMap.put("$",93);
		aMap.put("~",94);
		aMap.put("~Legend",95);
		aMap.put("%Legend",96);
		aMap.put("%",97);
		aMap.put("^Legend",98);
		aMap.put("^",99);
		aMap.put("(Legend",100);
		aMap.put("(",101);
		aMap.put("&mdash;",102);
		aMap.put("&mdash;Legend",103);
		aMap.put("+",104);
		aMap.put("+Legend",105);
		aMap.put("Curly1",106);
		aMap.put("Curly1Legend",107);
		aMap.put(":",108);
		aMap.put(":Legend",109);
		aMap.put("Quote",110);
		aMap.put("QuoteLegend",111);
		aMap.put("|",112);
		aMap.put("|Legend",113);
		aMap.put("<",114);
		aMap.put("<Legend",115);
		aMap.put(">",116);
		aMap.put(">Legend",117);
		aMap.put("?",118);
		aMap.put("?Legend",119);
		aMap.put("F5",120);
		aMap.put("F5Legend",121);
		aMap.put("F7",122);
		aMap.put("F7Legend",123);
		aMap.put("F6Legend",124);
		aMap.put("F6",125);
		aMap.put("INS",126);
		aMap.put("INSLegend",127);
		aMap.put("F8Legend",128);
		aMap.put("F8",129);
		aMap.put("F3",130);
		aMap.put("F3Legend",131);
		aMap.put("F1",132);
		aMap.put("F1Legend",133);
		aMap.put("ESC",134);
		aMap.put("ESCLegend",135);
		aMap.put("F4",136);
		aMap.put("F4Legend",137);
		aMap.put("F2",138);
		aMap.put("F2Legend",139);
		aMap.put("F9Legend",140);
		aMap.put("F9",141);
		aMap.put("F10Legend",142);
		aMap.put("F10",143);
		aMap.put("F11",144);
		aMap.put("F11Legend",145);
		aMap.put("F12",146);
		aMap.put("F12Legend",147);
		aMap.put("PRINTLegend",148);
		aMap.put("PRINT",149);
		aMap.put("SCROLL LOCKLegend",150);
		aMap.put("SCROLL LOCK",151);
		aMap.put("PAUSELegend",152);
		aMap.put("PAUSE",153);
		aMap.put("PAGE DOWNLegend",154);
		aMap.put("PAGE DOWN",155);
		aMap.put("&#9652;",156);
		aMap.put("&#9652;Legend",157);
		aMap.put("PAGE UPLegend",158);
		aMap.put("PAGE UP",159);
		aMap.put("DELLegend",160);
		aMap.put("DEL",161);
		aMap.put("&#9666;",162);
		aMap.put("&#9666;Legend",163);
		aMap.put("ENDLegend",164);
		aMap.put("END",165);
		aMap.put("&#9662;",166);
		aMap.put("&#9662;Legend",167);
		aMap.put("&#9656;",168);
		aMap.put("&#9656;Legend",169);
		aMap.put("HOMELegend",170);
		aMap.put("HOME",171);
		aMap.put("6Legend",172);
		aMap.put("6",173);
		aMap.put("ENTER",174);
		aMap.put("ENTERLegend",175);
		aMap.put("7",176);
		aMap.put("7Legend",177);
		aMap.put("9Legend",178);
		aMap.put("9",179);
		aMap.put("4",180);
		aMap.put("4Legend",181);
		aMap.put("NUM LOCKLegend",182);
		aMap.put("NUM LOCK",183);
		aMap.put("5",184);
		aMap.put("5Legend",185);
		aMap.put("Num*",186);
		aMap.put("Num*Legend",187);
		aMap.put("3",188);
		aMap.put("3Legend",189);
		aMap.put("8Legend",190);
		aMap.put("8",191);
		aMap.put("1",192);
		aMap.put("1Legend",193);
		aMap.put("Num+",194);
		aMap.put("Num+Legend",195);
		aMap.put("&ndash;",196);
		aMap.put("&ndash;Legend",197);
		aMap.put("/",198);
		aMap.put("/Legend",199);
		aMap.put("2",200);
		aMap.put("2Legend",201);
		aMap.put("0",202);
		aMap.put("0Legend",203);
		aMap.put("RightALT",204);
		aMap.put("RightALTLegend",205);
		aMap.put("RightSUPER",206);
		aMap.put("RightSUPERLegend",207);
		aMap.put("RightWIN",206);
		aMap.put("RightWINLegend",207);
		aMap.put(".",208);
		aMap.put(".Legend",209);
		aMap.put("RightCTRL",210);
		aMap.put("RightCTRLLegend",211);
		mtlMap=Collections.unmodifiableMap(aMap);
	}
}
