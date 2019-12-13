package pers.bwr.translaterForPerson.initialization;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import pers.bwr.translaterForPerson.mode.ReadingMode;
import pers.bwr.translaterForPerson.mode.TranslateMode;
import pers.bwr.translaterForPerson.mode.TranslatePart;
import pers.bwr.translaterForPerson.mode.part.WorkPart;

/**
 * 配置文件阅读器，请将配置文件命名为
 * “ini.txt”,或初始化该类时将配置文件的文件全名传入
 * 此类功能：读取配置文件，
 * 并返回包含了工作方式的HashMap<某一部分工作，其工作方式>
 * 使用方法：进行初始化后调用readIni()方法获取返回值
 * 可能抛出的异常：IO异常
 * @author 黑色的白兔子（592128947@qq.com）
 *
 */

public class IniReader {
	String iniLine;//配置文件每一行的内容
	BufferedReader readin;//具体内容的阅读器
	InputStream iniStream;//配置文件的输入流
	Map<WorkPart, Object> iniContents;//要返回的值，通过map存储配置信息
	String iniName;//配置文件的名称
	//ReadingMode readingMode;
	
	/*
	//测试用变量
	File testFile;
	int i = 0;
	*/
	
	//不传参的默认构造方式
	public IniReader() throws FileNotFoundException{
		this("ini.txt");
	}
	
	//传入配置文件名的构造方法
	//这是构造方法，请在该方法中修改配置文件含有的项目
	public IniReader(String iniName) throws FileNotFoundException {
		this.iniName = iniName;
		iniContents = new HashMap<WorkPart , Object>();//初始化
		
	}
	
	//读取方法
	public Map<WorkPart, Object> readIni() throws IOException {
		iniStream = new FileInputStream(new File(iniName));//将配置文件包装成file类并以此类创建输入流
		
		/*//测试用初始化方法
		testFile = new File(iniName);
		iniStream = new FileInputStream(testFile);
		*/
		
		readin = new BufferedReader(new InputStreamReader(iniStream));//用阅读器包装输入流并创建缓冲区
		//iniLine = readin.readLine();//使用缓冲阅读器的readLine方法读取其中一行的内容。
		
		//按行读取配置文件
		while( (iniLine = readin.readLine()) != null){//判断方式可能存在出现空行扫描停止的情况，联网后请查相关资料
			//判断此行是否为注释内容
			if(iniLine.startsWith("#")){
				//System.out.println("第" + i + "行为注释");
				continue;
			}
			//判断读取需翻译的文本的方式
			if(iniLine.startsWith("Reading:")){
				iniContents.put(WorkPart.ReadingMode, ReadingMode.valueOf(iniLine.substring(8)));
			}
			//判断使用的api
			if(iniLine.startsWith("Translater:")) {
				/*//调试代码
				String partstring = iniLine.substring(11);
				TranslatePart TranPart = TranslatePart.valueOf(partstring);
				System.out.println(TranPart.values());
				TranslateMode.addTranslateMode(TranslatePart.BaiduFanyi);
				*/
				TranslateMode.addTranslateMode(TranslatePart.valueOf(iniLine.substring(11)));
			}
		}
		
		//readingMode = ReadingMode.ReadLineFromShortTxt;
		//读取方法已在读取配置信息进行判断的过程中进行过存储，因此无需再存储一遍
		//iniContents.put(WorkPart.ReadingMode , ReadingMode.ReadLineFromShortTxt);
		
		//将翻译使用的方法全部存入iniContents信息中
		iniContents.put(WorkPart.TranslateMode, TranslateMode.getTranslateMode());
		
		return iniContents;//最终返回值
	}
}
