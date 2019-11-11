package pers.bwr.translaterForPerson.mode;

import java.util.ArrayList;

public class TranslateMode {
	static ArrayList<TranslatePart> TranslateMode;
	
	public static ArrayList<TranslatePart> setTranslateMode(TranslatePart part) {
		TranslateMode.add(part);
		return TranslateMode;
	}
	public static ArrayList<TranslatePart> setTranslateMode(TranslatePart part1 , TranslatePart part2) {
		setTranslateMode(part1);
		setTranslateMode(part2);
		return TranslateMode;
	}
	public static ArrayList<TranslatePart> setTranslateMode(TranslatePart part1 , TranslatePart part2 , TranslatePart part3) {
		setTranslateMode(part1);
		setTranslateMode(part2);
		setTranslateMode(part3);
		return TranslateMode;
	}
	
	public static ArrayList<TranslatePart> getTranslateMode() {
		return TranslateMode;
	}
	
}

