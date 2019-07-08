package com.collabera.odetocode.ems.text;

import java.util.Map;
import java.util.TreeMap;

public class SegmentLineText {

	Map<String, int[]> letters = new TreeMap<String, int[]>();
	SegmentPatterns rowPatterns = new SegmentPatterns();

	final int maxRowChars = 26;

	SegmentLineText() {
		setCharacters();
	}

	private void setCharacters() {

		int[] seqA = { 0, 1, 2 };
		letters.put("A", seqA);

		int[] seqB = { 0, 1, 1 };
		letters.put("B", seqB);

		int[] seqC = { 0, 3, 4 };
		letters.put("C", seqC);

		int[] seqD = { 0, 5, 6 };
		letters.put("D", seqD);

		int[] seqE = { 0, 4, 4 };
		letters.put("E", seqE);

		int[] seqF = { 0, 4, 3 };
		letters.put("F", seqF);

		int[] seqG = { 0, 7, 1 };
		letters.put("G", seqG);

		int[] seqH = { 29, 1, 2 };
		letters.put("H", seqH);

		int[] seqI = { 8, 9, 10 };
		letters.put("I", seqI);

		int[] seqJ = { 11, 12, 1 };
		letters.put("J", seqJ);

		int[] seqK = { 29, 6, 13 };
		letters.put("K", seqK);

		int[] seqL = { 29, 3, 4 };
		letters.put("L", seqL);

		int[] seqM = { 29, 14, 15 };
		letters.put("M", seqM);

		int[] seqN = { 29, 16, 17 };
		letters.put("N", seqN);

		int[] seqO = { 0, 2, 1 };
		letters.put("O", seqO);

		int[] seqP = { 0, 1, 3 };
		letters.put("P", seqP);

		int[] seqQ = { 0, 2, 18 };
		letters.put("Q", seqQ);

		int[] seqR = { 0, 1, 5 };
		letters.put("R", seqR);

		int[] seqS = { 0, 4, 19 };
		letters.put("S", seqS);

		int[] seqT = { 20, 9, 9 };
		letters.put("T", seqT);

		int[] seqU = { 29, 2, 1 };
		letters.put("U", seqU);

		int[] seqV = { 29, 21, 22 };
		letters.put("V", seqV);

		int[] seqW = { 29, 15, 23 };
		letters.put("W", seqW);

		int[] seqX = { 29, 24, 25 };
		letters.put("X", seqX);

		int[] seqY = { 29, 24, 9 };
		letters.put("Y", seqY);

		int[] seqZ = { 26, 27, 28 };
		letters.put("Z", seqZ);

		int[] seq0 = { 0, 2, 1 };
		letters.put("0", seq0);

		int[] seq1 = { 29, 30, 30 };
		letters.put("1", seq1);

		int[] seq2 = { 0, 31, 4 };
		letters.put("2", seq2);

		int[] seq3 = { 0, 31, 31 };
		letters.put("3", seq3);

		int[] seq4 = { 29, 1, 30 };
		letters.put("4", seq4);

		int[] seq5 = { 0, 4, 19 };
		letters.put("5", seq5);

		int[] seq6 = { 0, 4, 1 };
		letters.put("6", seq6);

		int[] seq7 = { 0, 30, 30 };
		letters.put("7", seq7);

		int[] seq8 = { 0, 1, 1 };
		letters.put("8", seq8);

		int[] seq9 = { 0, 1, 30 };
		letters.put("9", seq9);

		int[] seqSpace = { 32, 32, 32 };
		letters.put(" ", seqSpace);

		int[] seqNothing = { 34, 34, 34 };
		letters.put("", seqNothing);

		int[] seqPeriod = { 29, 29, 35 };
		letters.put(".", seqPeriod);

		int[] seqComma = { 29, 29, 27 };
		letters.put(",", seqComma);

		int[] seqExclamationPoint = { 9, 9, 35 };
		letters.put("!", seqExclamationPoint);

		int[] seqColon = { 29, 35, 35 };
		letters.put(":", seqColon);

		int[] seqSemiColon = { 29, 35, 27 };
		letters.put(";", seqSemiColon);

		int[] seqAtSymbol = { 36, 37, 38 };
		letters.put("@", seqAtSymbol);

		int[] seqDollarSymbol = { 39, 40, 41 };
		letters.put("$", seqDollarSymbol);

		int[] seqHashTag = { 42, 42, 43 };
		letters.put("#", seqHashTag);

		int[] seqPercent = { 44, 45, 46 };
		letters.put("%", seqPercent);

		int[] seqCarrot = { 47, 48 };
		letters.put("^", seqCarrot);

		int[] seqAmpersand = { 20, 24, 49 };
		letters.put("&", seqAmpersand);

		int[] seqStar = { 50, 47, 29 };
		letters.put("*", seqStar);

		int[] seqLeftParenthesis = { 51, 9, 52 };
		letters.put("(", seqLeftParenthesis);

		int[] seqRightParenthesis = { 53, 30, 27 };
		letters.put(")", seqRightParenthesis);

		int[] seqMinus = { 29, 54, 29 };
		letters.put("-", seqMinus);

		int[] seqUnderscore = { 29, 29, 55 };
		letters.put("_", seqUnderscore);

		int[] seqPlus = { 29, 56, 30 };
		letters.put("+", seqPlus);

		int[] seqEquals = { 11, 11, 29 };
		letters.put("=", seqEquals);

		int[] seqBackSlash = { 57, 53, 58 };
		letters.put("\\", seqBackSlash);

		int[] seqFrontSlash = { 59, 27, 60 };
		letters.put("/", seqFrontSlash);

		int[] seqQuestionMark = { 54, 64, 9 };
		letters.put("?", seqQuestionMark);

	}

	private String printCharacterRow(String letter, int row) {
		int[] patternSeg = letters.get(letter);
		return rowPatterns.getPattern(patternSeg[row]);
	}

	public void write(String toWrite) {

		// set all to upper case then convert string to char array then string array
		char[] chars = toWrite.toUpperCase().toCharArray();
		String[] strChars = new String[toWrite.length()];
		for (int i = 0; i < toWrite.length(); i++) {
			strChars[i] = Character.toString(chars[i]);
		}

		// System.out.println(chars);

		for (int row = 0; row < 3; row++) {

			for (String rowLetter : strChars) {
				if (letters.containsKey(rowLetter))
					System.out.print(printCharacterRow(rowLetter, row));
				else
					System.out.print(rowPatterns.getPattern(33));
			}

			System.out.println();
		}

	}

	public void writeAll(String toWrite) {

		if (toWrite.length() > maxRowChars) {

			String[] allWords = toWrite.split(" ");
			StringBuffer rowToPrint = new StringBuffer("");

			for (int word = 0; word < allWords.length; word++) {
				rowToPrint.append(allWords[word] + " ");

				if (rowToPrint.length() > maxRowChars | word == allWords.length - 1) {
					write(rowToPrint.toString().trim());
					rowToPrint.replace(0, rowToPrint.length() - 1, "");
				}
			}
		} else {
			write(toWrite);
		}
	}

}
