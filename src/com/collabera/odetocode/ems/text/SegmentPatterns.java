package com.collabera.odetocode.ems.text;

import java.util.Map;
import java.util.TreeMap;

public class SegmentPatterns {

	Map<String, String> patterns = new TreeMap<String, String>();

	public SegmentPatterns() {
		setPatterns();
	}

	private void setPatterns() {

		patterns.put("0", " _  ");
		patterns.put("1", "|_| ");
		patterns.put("2", "| | ");
		patterns.put("3", "|   ");
		patterns.put("4", "|_  ");
		patterns.put("5", "| \\ ");
		patterns.put("6", "|_/ ");
		patterns.put("7", "| _ ");
		patterns.put("8", "_ _ ");
		patterns.put("9", " |  ");
		patterns.put("10", "_|_ ");
		patterns.put("11", " ___");
		patterns.put("12", "  | ");
		patterns.put("13", "| \\ ");
		patterns.put("14", "|\\/|");
		patterns.put("15", "|  |");
		patterns.put("16", "|\\ |");
		patterns.put("17", "| \\|");
		patterns.put("18", "|_\\ ");
		patterns.put("19", " _| ");
		patterns.put("20", "___ ");
		patterns.put("21", "\\  /");
		patterns.put("22", " \\/ ");
		patterns.put("23", "|/\\|");
		patterns.put("24", "\\_/ ");
		patterns.put("25", "/ \\ ");
		patterns.put("26", "__  ");
		patterns.put("27", " /  ");
		patterns.put("28", "/_  ");
		patterns.put("29", "    ");
		patterns.put("30", "  | ");
		patterns.put("31", " _| ");

		patterns.put("32", "    ");
		patterns.put("33", "|??|");
		patterns.put("34", "");

		patterns.put("35", " o  ");
		patterns.put("36", " __\\");
		patterns.put("37", "/_/|");
		patterns.put("38", "\\__/");
		patterns.put("39", " _|_ ");
		patterns.put("40", "|_|_ ");
		patterns.put("41", " _|_|");
		patterns.put("42", "_|_|_");
		patterns.put("43", " | | ");
		patterns.put("44", " O /");
		patterns.put("45", "  / ");
		patterns.put("46", " / O");
		patterns.put("47", " /\\ ");
		patterns.put("48", "/  \\");
		patterns.put("49", "/_\\/");
		patterns.put("50", "_\\/_");
		patterns.put("51", "  / ");
		patterns.put("52", "  \\ ");
		patterns.put("53", " \\  ");
		patterns.put("54", " __ ");
		patterns.put("55", "____");
		patterns.put("56", " _|_");
		patterns.put("57", "\\   ");
		patterns.put("58", "  \\ ");
		patterns.put("59", "  / ");
		patterns.put("60", "/   ");
		patterns.put("61", "  //");
		patterns.put("62", "\\\\  ");
		patterns.put("63", "   /");
		patterns.put("64", " __|");
	}

	public String getPattern(int patternNum) {
		return patterns.get(patternNum + "");
	}

}
