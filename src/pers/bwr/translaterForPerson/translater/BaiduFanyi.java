package pers.bwr.translaterForPerson.translater;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.alibaba.fastjson.JSONObject;
import com.baidu.translate.demo.TransApi;

import pers.bwr.translaterForPerson.translater.fat.Translater;

public class BaiduFanyi implements Translater {
	
	private static final String APP_ID = "20191019000342812";
    private static final String SECURITY_KEY = "QIntKyAX4Kpx58K3lC9T";

	@Override
	public String translateLine(String translateThem) {
		
	    TransApi api = new TransApi(APP_ID, SECURITY_KEY);
	    String query = translateThem;
	    String trans_result = api.getTransResult(query, "auto", "auto");
	    
	    com.alibaba.fastjson.JSONObject jsonss = null;
        jsonss =com.alibaba.fastjson.JSONObject.parseObject(trans_result);
	    
	    String result = jsonss.getJSONArray("trans_result").getJSONObject(0).getString("dst");
	    
		//System.err.println(result);
		//return null;
		//ʹ�ðٶȷ���
		return result;
		
	}

	@Override
	public String translaterName() {
		// TODO Auto-generated method stub
		return "�ٶȷ���";
	}
	

	//@Override
	public String translateLine1(String translateThem) {
		/*
		*��һ�ַ�ʽpost����
		*/
		String jsonResult = "";
		
		JSONObject result = new JSONObject();
		JSONObject jsons = new JSONObject();
		jsons.put("key","value");
		//translateThem = translateThem.replace(" ", "%20");
		try {
		            URL url = new URL("https://fanyi-api.baidu.com/api/trans/vip/translate");
		            //�򿪺�url֮�������
		            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		            PrintWriter out = null;
		            
		            conn.setRequestMethod("GET");
		            
		            //conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		            conn.setRequestProperty("q" , translateThem);
		            conn.setRequestProperty("from" , "auto");
		            conn.setRequestProperty("to" , "auto");
		            conn.setRequestProperty("appid" , "20191019000342812");
		            conn.setRequestProperty("salt" , "000");
		            //conn.setRequestProperty("sign" , this.md5("20191019000342812how dare you.125sdf847eQIntKyAX4Kpx58K3lC9T"));
		            conn.setRequestProperty("sign" , this.md5("20191019000342812" + "+" + translateThem + "+" + "000" + "+" + "QIntKyAX4Kpx58K3lC9T"));
		            
		            
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
		            System.out.println("��ȡ���ı�������Ϊ��"+jsonss);
		            
		            //jsonResult = jsonss.getJSONArray("sentences").getJSONObject(0).getString("trans");
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

	//дһ��md5���ܵķ���
		public String md5(String plainText) {
			//����һ���ֽ�����
			byte[] secretBytes = null;
			try {
				  // ����һ��MD5���ܼ���ժҪ  
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            //���ַ������м���
	            md.update(plainText.getBytes());
	            //��ü��ܺ������
				secretBytes = md.digest();
			} catch (NoSuchAlgorithmException e) {
				throw new RuntimeException("û��md5����㷨��");
			}
			//�����ܺ������ת��Ϊ16��������
			String md5code = new BigInteger(1, secretBytes).toString(16);// 16��������
			// �����������δ��32λ����Ҫǰ�油0
			for (int i = 0; i < 32 - md5code.length(); i++) {
				md5code = "0" + md5code;
			}
			System.err.println(md5code);
			return md5code;
		}
	
}
