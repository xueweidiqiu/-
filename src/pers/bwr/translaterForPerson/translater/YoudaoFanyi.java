package pers.bwr.translaterForPerson.translater;

import pers.bwr.translaterForPerson.translater.fat.Translater;

public class YoudaoFanyi implements Translater {

	@Override
	public String translateLine(String translateThem) {
		// TODO Auto-generated method stub
		//使用有道翻译
		return "使用有道翻译翻译了\"" + translateThem + "\"";
	}

	@Override
	public String translaterName() {
		// TODO Auto-generated method stub
		return "有道翻译";
	}

}
