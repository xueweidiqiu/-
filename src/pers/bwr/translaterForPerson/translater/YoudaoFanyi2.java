package pers.bwr.translaterForPerson.translater;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import com.alibaba.fastjson.JSONObject;

import pers.bwr.translaterForPerson.translater.fat.Translater;

public class YoudaoFanyi2 implements Translater {

	@Override
	public String translateLine(String translateThem) {
		/*
		 * �Ǳ��˴���
		 */
		/*
		*��һ�ַ�ʽpost����
		*/
		String jsonResult = this.translaterName() + "�������";
		
		JSONObject result = new JSONObject();
		JSONObject jsons = new JSONObject();
		jsons.put("key","value");
		//translateThem = translateThem.replace(" ", "%20");
		try {
		            URL url = new URL("http://fanyi.youdao.com/translate?&doctype=json&type=AUTO&i=" + translateThem.replace(" ", "%20"));
		            //�򿪺�url֮�������
		            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		            PrintWriter out = null;
		            
		            conn.setRequestMethod("POST");
		            
		            //conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		            //conn.setRequestProperty("i" , translateThem.replace(" ", "%20"));
		            //conn.setRequestProperty("doctype" , "json");
		            //conn.setRequestProperty("type" , "AUTO");
		            //conn.setRequestProperty("appid" , "20191019000342812");
		            //conn.setRequestProperty("salt" , "000");
		            //conn.setRequestProperty("sign" , this.md5("20191019000342812how dare you.125sdf847eQIntKyAX4Kpx58K3lC9T"));
		            //conn.setRequestProperty("sign" , this.md5("20191019000342812" + "+" + translateThem + "+" + "000" + "+" + "QIntKyAX4Kpx58K3lC9T"));
		            
		            
		            //����ʽ ������������Ҫ����ķ�ʽ
//		           conn.setRequestMethod("POST");
//		           //����ͨ�õ���������
		            //conn.setRequestProperty("accept", "*/*");
		            //conn.setRequestProperty("connection", "Keep-Alive");
		//  ������������ͷ
		            //conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
		            //�����Ƿ���httpUrlConnection����������Ƿ��httpUrlConnection���룬���ⷢ��post�����������������
		            //��õ�Http�����޷���get��post��get������Ի�ȡ��̬ҳ�棬Ҳ���԰Ѳ�������URL�ִ����棬���ݸ�servlet��
		            //post��get�� ��֮ͬ������post�Ĳ������Ƿ���URL�ִ����棬���Ƿ���http����������ڡ�
		            conn.setDoOutput(true);
		            conn.setDoInput(true);
		            //��ȡURLConnection�����Ӧ�������
		            out = new PrintWriter(conn.getOutputStream());
		            //�����������������
		            out.print(result);
		            //��������
		            out.flush();
		            //��ȡURLConnection�����Ӧ��������
		            InputStream is = conn.getInputStream();
		            //����һ���ַ�������
		            BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
		            String str = "";
		            com.alibaba.fastjson.JSONObject jsonss = null;
		            while ((str = br.readLine()) != null) {
		            	//System.out.println(str);
		                jsonss =com.alibaba.fastjson.JSONObject.parseObject(str);
		            }
		            //System.out.println("��ȡ���ı�������Ϊ��"+jsonss);
		            
		            jsonResult = jsonss.getJSONArray("translateResult").getJSONArray(0).getJSONObject(0).getString("tgt");
		            //System.out.println(jsonResult);
		            //�ر���
		            is.close();
		            //�Ͽ����ӣ����д�ϣ�disconnect���ڵײ�tcp socket���ӿ���ʱ���жϡ�������ڱ������߳�ʹ�þͲ��жϡ�
		            //�̶����̵߳Ļ��������disconnect�����ӻ����ֱ࣬���շ�������Ϣ��д�� disconnect������һЩ��
		            conn.disconnect();
		            //System.out.println("����");
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		return jsonResult;


	}

	@Override
	public String translaterName() {
		// TODO Auto-generated method stub
		return "�е�����api";
	}

}
