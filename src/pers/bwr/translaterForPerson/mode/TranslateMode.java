package pers.bwr.translaterForPerson.mode;

import java.util.HashSet;

public class TranslateMode {
	static HashSet<TranslatePart> translateMode = new HashSet<TranslatePart>();
	
	public static void addTranslateMode(TranslatePart part) {
		//System.out.println("开始给set添加内容");
		//System.out.println(part.values());
		translateMode.add(part);
		//System.out.println("给set添加内容结束");
	}
	
	/*
	public static ArrayList<TranslatePart> setTranslateMode(TranslatePart part) {
		TranslateMode.add(part);
		return TranslateMode;
	}
	*/
	
	
	public static HashSet<TranslatePart> getTranslateMode() {
		return translateMode;
	}
	
}

