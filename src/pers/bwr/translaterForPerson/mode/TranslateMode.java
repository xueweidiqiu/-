package pers.bwr.translaterForPerson.mode;

import java.util.ArrayList;

public class TranslateMode {
	static ArrayList<TranslatePart> TranslateMode;
	
	public static void addTranslateMode(TranslatePart part) {
		TranslateMode.add(part);
	}
	
	/*
	public static ArrayList<TranslatePart> setTranslateMode(TranslatePart part) {
		TranslateMode.add(part);
		return TranslateMode;
	}
	*/
	
	
	public static ArrayList<TranslatePart> getTranslateMode() {
		return TranslateMode;
	}
	
}

