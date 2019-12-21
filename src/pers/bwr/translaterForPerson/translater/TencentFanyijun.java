package pers.bwr.translaterForPerson.translater;

import com.alibaba.fastjson.JSONObject;

import pers.bwr.translaterForPerson.translater.fat.Translater;
import tencentTranslater.TextTranslate;


public class TencentFanyijun implements Translater {
	String result;

	@Override
	public String translateLine(String translateThem) {
		result = this.translaterName() + "·­Òë³ö´í¡£";
		
		JSONObject jsonPar = new JSONObject();
		jsonPar = jsonPar.parseObject(TextTranslate.translate(translateThem) );
		result = jsonPar.getString("TargetText");
		return result;
	}

	@Override
	public String translaterName() {
		// TODO Auto-generated method stub
		return "ÌÚÑ¶·­Òë¾ý";
	}

}
