package pers.bwr.translaterForPerson.work.translate;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;

import pers.bwr.translaterForPerson.mode.TranslatePart;
import pers.bwr.translaterForPerson.translater.fat.Translater;
import pers.bwr.translaterForPerson.work.translate.fac.Translate;

/**
 * ���ܣ�����һ�����ֵõ��䷭����
 * ʹ�÷�����
 * �ȳ�ʼ��TranslateOneLine�����跭������֡� �� translateMode����ini�л�õ�ʹ����Щapi��Ϣ����
 * Ȼ�����getTranslateResult()�����õ����
 * @author v592128947
 *
 */
public class TranslateOneLine implements Translate {
	String txtLine = "������";
	HashSet<TranslatePart> translateMode;
	String txtName;
	Class<Translater> translaterClass;//ͨ�����䴴���������ʱʹ�õĶ���
	String translateResult = "";
	
	public TranslateOneLine(String txtLine , HashSet<TranslatePart> translateMode) {
		this.txtLine = txtLine;
		this.translateMode = translateMode;
		translateResult += "ԭ�ģ�" + txtLine + "\n";
	}
	

	@SuppressWarnings("unchecked")
	@Override	
	public String getTranslateResult() {
		// TODO Auto-generated method stub
		//LineReader.readLine();
		for(TranslatePart translatePart:translateMode) {
			try {
				this.translaterClass = (Class<Translater>) Class.forName("pers.bwr.translaterForPerson.translater." + translatePart.toString());
				translateResult += translaterClass.getDeclaredConstructor().newInstance().translaterName() + "��" + translaterClass.getDeclaredConstructor().newInstance().translateLine(txtLine) + "\n";
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
