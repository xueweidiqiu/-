package pers.bwr.translaterForPerson.translater;

import pers.bwr.translaterForPerson.translater.fat.Translater;
import youdao.YouDao;

public class YoudaoFanyi implements Translater {

	@Override
	public String translateLine(String translateThem) {
		// TODO Auto-generated method stub
		//ʹ���е�����
		try {
			return YouDao.youdaoFanyi(translateThem);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.translaterName() + "�������";
	}

	@Override
	public String translaterName() {
		// TODO Auto-generated method stub
		return "�е�����";
	}

}
