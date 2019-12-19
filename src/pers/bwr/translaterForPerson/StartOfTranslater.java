package pers.bwr.translaterForPerson;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import pers.bwr.translaterForPerson.initialization.IniReader;
import pers.bwr.translaterForPerson.mode.TranslatePart;
import pers.bwr.translaterForPerson.mode.part.WorkPart;
import pers.bwr.translaterForPerson.work.WorkInShortTxt;
import pers.bwr.translaterForPerson.work.fac.Work;

public class StartOfTranslater {

	public static void main(String[] args) {
		//正式代码
		
		//测试用代码
		
		/* //测试枚举
		ReadingMode test = ReadingMode.ReadLineFromShortTxt;
		System.out.println(test.name());
		*/
		
		/*（测试从txt中读取一行的代码
		try {
			String txtLine = new ReadLineFromShortTxt().readLine("oneLine.txt");
			System.out.println(txtLine);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//测试从txt中读取一行的代码）*/
		
		Map ini = new HashMap();
		
		//》测试从txt中读取配置
		try {
			IniReader nrdr = new IniReader();
			ini = nrdr.readIni();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//《测试从txt中读取配置
		
		//测试从ShortTxt中读取
		@SuppressWarnings("unchecked")
		Work workPro = new WorkInShortTxt(ini.get(WorkPart.ReadingFrom).toString() , (HashSet<TranslatePart>)ini.get(WorkPart.TranslateMode) , ini.get(WorkPart.WritingTo).toString());
		//System.out.println(workPro.getWorkResult());
		workPro.getWorkResult();
		System.out.println("程序执行结束，任务已完成。");
		
	}

}
