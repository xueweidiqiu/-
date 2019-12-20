package pers.bwr.translaterForPerson.work;

import java.util.HashSet;

import pers.bwr.translaterForPerson.mode.TranslatePart;
import pers.bwr.translaterForPerson.translater.fat.Translater;
import pers.bwr.translaterForPerson.work.fac.Work;
import pers.bwr.translaterForPerson.work.getContent.GetOneLineFromTxt;
import pers.bwr.translaterForPerson.work.translate.TranslateOneLine;
import pers.bwr.translaterForPerson.work.translate.fac.Translate;
import pers.bwr.translaterForPerson.work.writeOut.WriteToTxt;

/**
 * 此类是只翻译txt中第一行内容的简单流程方法类
 * 使用方法：
 * 先创建对象，传入的两个参数分别是要读取的文件名和使用的翻译工具的set集合
 * 然后再调用getWorkResult()方法将翻译结果写入文件中
 * 此类的工作流程说明：1.读取txt文件单行内容，1.进行翻译，3.将翻译结果输出到txt文件中
 * @author v592128947
 *
 */

public class WorkInShortTxt implements Work {
	String txtLine = "无内容";
	HashSet<TranslatePart> translateMode;
	//String txtName;
	Class<Translater> translaterClass;//通过反射创建翻译对象时使用的对象
	String translateResult = "";
	Translate translate;//调用翻译类的对象
	String writeTo;//翻译结果要写入的文件名

	public WorkInShortTxt(String readFrom,HashSet<TranslatePart> translateMode,String writeTo) {
		//this.txtName = readFrom;
		this.translateMode = translateMode;
		this.writeTo = writeTo;
	
		txtLine = new GetOneLineFromTxt(readFrom).getResult();
		
		translate = new TranslateOneLine(txtLine,translateMode);
		translateResult += translate.getTranslateResult();
		
		//System.out.println(translateResult);
	}
	
	@Override
	public String getWorkResult() {
		new WriteToTxt(translateResult , writeTo);
		
		//当前的处理方式是将结果交给上层处理，请尽快编写写入文件的方法
		return translateResult;
	}

}
