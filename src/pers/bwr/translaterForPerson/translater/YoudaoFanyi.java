package pers.bwr.translaterForPerson.translater;

import pers.bwr.translaterForPerson.translater.fat.Translater;

public class YoudaoFanyi implements Translater {

	@Override
	public String translateLine(String translateThem) {
		// TODO Auto-generated method stub
		//ʹ���е�����
		return "ʹ���е����뷭����\"" + translateThem + "\"";
	}

	@Override
	public String translaterName() {
		// TODO Auto-generated method stub
		return "�е�����";
	}

}
