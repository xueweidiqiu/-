package pers.bwr.translaterForPerson.translater;

import pers.bwr.translaterForPerson.translater.fat.Translater;

public class BaiduFanyi implements Translater {

	@Override
	public String translateLine(String translateThem) {
		// TODO Auto-generated method stub
		//ʹ�ðٶȷ���
		return "ʹ�ðٶȷ��뷭����\"" + translateThem + "\"";
		//return null;
	}

	@Override
	public String translaterName() {
		// TODO Auto-generated method stub
		return "�ٶȷ���";
	}

}
