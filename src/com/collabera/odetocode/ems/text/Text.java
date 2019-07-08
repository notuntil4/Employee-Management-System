package com.collabera.odetocode.ems.text;

import java.util.HashMap;

public class Text {
	private HashMap<Character,String[]> bubbleText;
	private int lineLen, delayTime;
	private String textStyle;
	private SegmentLineText lineText;
	public Text() {
		textStyle = "Default";
		bubbleText = makeTable();
		lineLen = 15;
		delayTime = 0;
		lineText = new SegmentLineText();
	}
	public void setTextDefault() {
		textStyle = "Default";
	}
	public void setTextBubble() {
		textStyle = "Bubble";
	}
	public void setTextLine() {
		textStyle = "Line";
	}
	public void writeToScreen(String s) {
		if(textStyle.equals("Default")) {
			System.out.println(s);
		} else if(textStyle.equals("Bubble")) {
			writeBubbleToScreen(s);
		} else {
			writeLineToScreen(s);
		}
	}
	public void writeToScreen() {
		if(textStyle.equals("Default")) {
			System.out.println();
		} else if(textStyle.equals("Bubble")) {
			System.out.println();
			System.out.println();
		} else {
			System.out.println();
		}
	}
	public void setLineLength(int l) {
		lineLen = l;
	}
	public void writeBubbleToScreen(String s) {
		int currLine = 0;
		String[] sLines = s.toUpperCase().split("\n");
		String sLine = "";
		for(String sNextLine : sLines) {
			String[] sa = sNextLine.split(" ");
			for(String curr : sa) {
				sLine += curr + " ";
				currLine += curr.length() + 1;
				if(currLine > lineLen || curr.equals(sa[sa.length - 1])) {
					currLine = 0;
					for(int i = 0; i < 4; i++) {
						for(int j = 0; j < sLine.length(); j++) {
							if(!bubbleText.containsKey(sLine.charAt(j))) {
								System.out.print("&&&&");
							} else {
								for(int k = 0; k < bubbleText.get(sLine.charAt(j))[i].length(); k++) {
									System.out.print(bubbleText.get(sLine.charAt(j))[i].charAt(k));
									try {
										Thread.sleep(delayTime);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
								}
							}
						}
						System.out.println();
					}
					sLine = "";
				}
			}
		}
	}
	public static HashMap<Character,String[]> makeTable() {
		HashMap<Character,String[]> al = new HashMap<Character,String[]>();
		String[] ch = {"  __  "," / _\\ ","/    \\","\\_/\\_/"};
		al.put(new Character('A'),ch);
		ch = new String[]{" ____ ","(  _ \\"," ) _ (","(____/"};
		al.put(new Character('B'),ch);
		ch = new String[]{"  ___ "," / __)","( (__ "," \\___)"};
		al.put(new Character('C'),ch);
		ch = new String[]{" ____ ","(    \\"," ) D (","(____/"};
		al.put(new Character('D'),ch);
		ch = new String[]{" ____ ","(  __)"," ) _) ","(____)"};
		al.put(new Character('E'),ch);
		ch = new String[]{" ____ ","(  __)"," ) _) ","(__)  "};
		al.put(new Character('F'),ch);
		ch = new String[]{"  ___ "," / __)","( (_ \\"," \\___/"};
		al.put(new Character('G'),ch);
		ch = new String[]{" _  _ ","/ )( \\",") __ (","\\_)(_/"};
		al.put(new Character('H'),ch);
		ch = new String[]{" __ ","(  )"," )( ","(__)"};
		al.put(new Character('I'),ch);
		ch = new String[]{"   __ "," _(  )","/ \\) \\","\\____/"};
		al.put(new Character('J'),ch);
		ch = new String[]{" __ _ ","(  / )"," )  ( ","(__\\_)"};
		al.put(new Character('K'),ch);
		ch = new String[]{" __   ","(  )  ","/ (_/\\","\\____/"};
		al.put(new Character('L'),ch);
		ch = new String[]{" _  _ ","( \\/ )","/ \\/ \\","\\_)(_/"};
		al.put(new Character('M'),ch);
		ch = new String[]{" __ _ ","(  ( \\","/    /","\\_)__)"};
		al.put(new Character('N'),ch);
		ch = new String[]{"  __  "," /  \\ ","(  O )"," \\__/ "};
		al.put(new Character('O'),ch);
		ch = new String[]{" ____ ","(  _ \\"," ) __/","(__)  "};
		al.put(new Character('P'),ch);
		ch = new String[]{"  __  "," /  \\ ","( O  )"," \\__\\)"};
		al.put(new Character('Q'),ch);
		ch = new String[]{" ____ ","(  _ \\"," )   /","(__\\_)"};
		al.put(new Character('R'),ch);
		ch = new String[]{" ____ ","/ ___)","\\___ \\","(____/"};
		al.put(new Character('S'),ch);
		ch = new String[]{" ____ ","(_  _)","  )(  "," (__) "};
		al.put(new Character('T'),ch);
		ch = new String[]{" _  _ ","/ )( \\",") \\/ (","\\____/"};
		al.put(new Character('U'),ch);
		ch = new String[]{" _  _ ","/ )( \\","\\ \\/ /"," \\__/ "};
		al.put(new Character('V'),ch);
		ch = new String[]{" _  _ ","/ )( \\","\\ /\\ /","(_/\\_)"};
		al.put(new Character('W'),ch);
		ch = new String[]{" _  _ ","( \\/ )"," )  ( ","(_/\\_)"};
		al.put(new Character('X'),ch);
		ch = new String[]{" _  _ ","( \\/ )"," )  / ","(__/  "};
		al.put(new Character('Y'),ch);
		ch = new String[]{" ____ ","(__  )"," / _/ ","(____)"};
		al.put(new Character('Z'),ch);
		ch = new String[]{"   ","   ","   ","   "};
		al.put(new Character(' '),ch);
		ch = new String[]{"  __  "," /  \\ ","(  0 )"," \\__/ "};
		al.put(new Character('0'),ch);
		ch = new String[]{"  __ "," /  \\","(_/ /"," (__)"};
		al.put(new Character('1'),ch);
		ch = new String[]{" ____ ","(___ \\"," / __/","(____)"};
		al.put(new Character('2'),ch);
		ch = new String[]{" ____ ","( __ \\"," (__ (","(____/"};
		al.put(new Character('3'),ch);
		ch = new String[]{"  ___ "," / _ \\","(__  (","  (__/"};
		al.put(new Character('4'),ch);
		ch = new String[]{"  ___ "," / __)","(___ \\","(____/"};
		al.put(new Character('5'),ch);
		ch = new String[]{"  ___ "," / __)","(  _ \\"," \\___/"};
		al.put(new Character('6'),ch);
		ch = new String[]{" ____ ","(__  )","  / / "," (_/  "};
		al.put(new Character('7'),ch);
		ch = new String[]{" ____ ","/ _  \\",") _  (","\\____/"};
		al.put(new Character('8'),ch);
		ch = new String[]{" ___  ","/ _ \\ ","\\__  )","(___/ "};
		al.put(new Character('9'),ch);
		ch = new String[]{" _ ","/ \\","\\_/","(_)"};
		al.put(new Character('!'),ch);
		ch = new String[]{" ___ ","(__ \\"," (__/"," (_) "};
		al.put(new Character('?'),ch);
		ch = new String[]{"   ","   "," _ ","(_)"};
		al.put(new Character('.'),ch);
		ch = new String[]{" _ ","(_)"," _ ","(_)"};
		al.put(new Character(':'),ch);
		ch = new String[]{"     "," ___ ","(___)","     "};
		al.put(new Character('-'),ch);
		ch = new String[]{" _  _ ","/ )( \\",")    (","\\_)(_/"};
		al.put(new Character('#'),ch);
		ch = new String[]{"  ___ "," /   \\","( (__/"," \\___)"};
		al.put(new Character('@'),ch);
		ch = new String[]{"  _ "," / )","( ( "," \\_)"};
		al.put(new Character('('),ch);
		ch = new String[]{" _  ","( \\ "," ) )","(_/ "};
		al.put(new Character(')'),ch);
		ch = new String[]{"   _ ","  / )"," / / ","(_/  "};
		al.put(new Character('/'),ch);
		ch = new String[]{"   "," _ ","( )","(/ "};
		al.put(new Character(','),ch);
		return al;
	}
	
	public void writeLineToScreen(String s) {
		String[] sLines = s.toUpperCase().split("\n");
		
		for(String line:sLines) {
			lineText.write(line);
		}
		
	}
}
