package pers.bwr.translaterForPerson.translater;

import pers.bwr.translaterForPerson.translater.fat.Translater;

public class BaiduFanyi implements Translater {

	@Override
	public String translateLine(String translateThem) {
		// TODO Auto-generated method stub
		//使用百度翻译
		return "使用百度翻译翻译了\"" + translateThem + "\"";
		//return null;
	}

	@Override
	public String translaterName() {
		// TODO Auto-generated method stub
		return "百度翻译";
	}

}
