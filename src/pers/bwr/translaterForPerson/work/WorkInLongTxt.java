package pers.bwr.translaterForPerson.work;

import java.util.ArrayList;
import java.util.HashSet;

import pers.bwr.translaterForPerson.mode.TranslatePart;
import pers.bwr.translaterForPerson.work.fac.Work;
import pers.bwr.translaterForPerson.work.getContent.ReadAllFromTxt;
import pers.bwr.translaterForPerson.work.getContent.fat.GetContent;
import pers.bwr.translaterForPerson.work.translate.TranslateOneLine;
import pers.bwr.translaterForPerson.work.translate.fac.Translate;
import pers.bwr.translaterForPerson.work.writeOut.WriteToTxt;

public class WorkInLongTxt implements Work {
	String translateResult = "";//翻译结果的字符串
	String writeTo;//要写入的文件名
	Translate translate;//调用翻译类的对象

	public WorkInLongTxt(String readFrom , HashSet<TranslatePart> translateMode , String writeTo) {
		this.writeTo = writeTo;
		
		//先从文档中读取所有的字符串
		GetContent readContent = new ReadAllFromTxt(readFrom);
		//System.out.println(readContent.getResult());
		String theContent = readContent.getResult();
		
		//然后通过回车和句尾标点对字符串进行分割
		theContent = theContent.replaceAll("\\?", "?。：。");
		theContent = theContent.replaceAll("\\.", ".。：。");
		theContent = theContent.replaceAll("\\!", "!。：。");
		
		String[] eachLine = theContent.split("。：。", 0);
		System.out.println(eachLine[1]);
		
		int i = 0;
		//对分割后的内容进行逐句翻译（业务逻辑同WorkInShortTxt）
		for(String lineText:eachLine) {
			translate = new TranslateOneLine(lineText,translateMode);
			translateResult += translate.getTranslateResult() + "\n";
			System.out.println("已翻译" + i + "句");
			i++;
		}
		
		//new WorkInShortTxt(readFrom , translateMode , writeTo).getWorkResult();
	}
	
	
	public String getWorkResult() {
		new WriteToTxt(translateResult , writeTo);
		
		//另外向上层返回写入的内容
		return translateResult;
	}

}
