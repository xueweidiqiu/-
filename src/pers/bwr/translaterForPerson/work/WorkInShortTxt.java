package pers.bwr.translaterForPerson.work;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;

import pers.bwr.translaterForPerson.lineReader.ReadLineFromShortTxt;
import pers.bwr.translaterForPerson.mode.TranslatePart;
import pers.bwr.translaterForPerson.translater.fat.Translater;
import pers.bwr.translaterForPerson.work.fac.Work;

/**
 * 此类是只翻译txt中第一行内容的简单流程方法类
 * 使用方法：
 * 先创建对象，传入的两个参数分别是要读取的文件名和使用的翻译工具的set集合
 * 然后再调用getTranslateResult()方法将翻译结果写入文件中
 * @author v592128947
 *
 */

public class WorkInShortTxt implements Work{
	String txtLine = "无内容";
	HashSet<TranslatePart> translateMode;
	String txtName;
	Class<Translater> translaterClass;//通过反射创建翻译对象时使用的对象
	String translateResult = "";

	public WorkInShortTxt(String readFrom,HashSet<TranslatePart> translateMode) {
		this.txtName = readFrom;
		this.translateMode = translateMode;
	}
	
	@SuppressWarnings("unchecked")
	@Override	
	public String getTranslateResult() {
		// TODO Auto-generated method stub
		//LineReader.readLine();
		
		//从txt中读取一行的代码
		try {
			txtLine = new ReadLineFromShortTxt().readLine(txtName);
			//System.out.println(txtLine);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(TranslatePart translatePart:translateMode) {
			try {
				this.translaterClass = (Class<Translater>) Class.forName("pers.bwr.translaterForPerson.translater." + translatePart.toString());
				translateResult += translaterClass.getDeclaredConstructor().newInstance().translaterName() + "：" + translaterClass.getDeclaredConstructor().newInstance().translateLine(txtLine) + "\n";
			} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalArgumentException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(translateResult);
		//return Translater.translateLine();
		return null;
	}

}
