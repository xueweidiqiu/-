package pers.bwr.translaterForPerson.work.translate;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;

import pers.bwr.translaterForPerson.mode.TranslatePart;
import pers.bwr.translaterForPerson.translater.fat.Translater;
import pers.bwr.translaterForPerson.work.translate.fac.Translate;

/**
 * 功能：传入一行文字得到其翻译结果
 * 使用方法：
 * 先初始化TranslateOneLine（“需翻译的文字” ， translateMode【从ini中获得的使用哪些api信息】）
 * 然后调用getTranslateResult()方法得到结果
 * @author v592128947
 *
 */
public class TranslateOneLine implements Translate {
	String txtLine = "无内容";
	HashSet<TranslatePart> translateMode;
	String txtName;
	Class<Translater> translaterClass;//通过反射创建翻译对象时使用的对象
	String translateResult = "";
	
	public TranslateOneLine(String txtLine , HashSet<TranslatePart> translateMode) {
		this.txtLine = txtLine;
		this.translateMode = translateMode;
		translateResult += "原文：" + txtLine + "\n";
	}
	

	@SuppressWarnings("unchecked")
	@Override	
	public String getTranslateResult() {
		// TODO Auto-generated method stub
		//LineReader.readLine();
		for(TranslatePart translatePart:translateMode) {
			try {
				this.translaterClass = (Class<Translater>) Class.forName("pers.bwr.translaterForPerson.translater." + translatePart.toString());
				translateResult += translaterClass.getDeclaredConstructor().newInstance().translaterName() + "：" + translaterClass.getDeclaredConstructor().newInstance().translateLine(txtLine) + "\n";
			} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalArgumentException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//System.out.println(translateResult);
		//return Translater.translateLine();
		return translateResult;
	}

}
