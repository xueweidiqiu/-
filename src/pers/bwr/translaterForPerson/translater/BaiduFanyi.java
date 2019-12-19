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
		//使用百度翻译
		return result;
		
	}

	@Override
	public String translaterName() {
		// TODO Auto-generated method stub
		return "百度翻译";
	}
	

	//@Override
	public String translateLine1(String translateThem) {
		/*
		*第一种方式post请求
		*/
		String jsonResult = "";
		
		JSONObject result = new JSONObject();
		JSONObject jsons = new JSONObject();
		jsons.put("key","value");
		//translateThem = translateThem.replace(" ", "%20");
		try {
		            URL url = new URL("https://fanyi-api.baidu.com/api/trans/vip/translate");
		            //打开和url之间的连接
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
		            
		            
		            //请求方式 这里设置你需要请求的方式
//		           conn.setRequestMethod("POST");
//		           //设置通用的请求属性
		            //conn.setRequestProperty("accept", "*/*");
		            //conn.setRequestProperty("connection", "Keep-Alive");
		//  这里设置请求头
		            //conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
		            //设置是否向httpUrlConnection输出，设置是否从httpUrlConnection读入，此外发送post请求必须设置这两个
		            //最常用的Http请求无非是get和post，get请求可以获取静态页面，也可以把参数放在URL字串后面，传递给servlet，
		            //post与get的 不同之处在于post的参数不是放在URL字串里面，而是放在http请求的正文内。
		            conn.setDoOutput(true);
		            conn.setDoInput(true);
		            //获取URLConnection对象对应的输出流
		            out = new PrintWriter(conn.getOutputStream());
		            //发送请求参数即数据
		            out.print(result);
		            //缓冲数据
		            out.flush();
		            //获取URLConnection对象对应的输入流
		            InputStream is = conn.getInputStream();
		            //构造一个字符流缓存
		            BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
		            String str = "";
		            com.alibaba.fastjson.JSONObject jsonss = null;
		            while ((str = br.readLine()) != null) {
		            	//System.out.println(str);
		                jsonss =com.alibaba.fastjson.JSONObject.parseObject(str);
		            }
		            System.out.println("获取到的报文数据为："+jsonss);
		            
		            //jsonResult = jsonss.getJSONArray("sentences").getJSONObject(0).getString("trans");
		            //System.out.println(jsonResult);
		            //关闭流
		            is.close();
		            //断开连接，最好写上，disconnect是在底层tcp socket链接空闲时才切断。如果正在被其他线程使用就不切断。
		            //固定多线程的话，如果不disconnect，链接会增多，直到收发不出信息。写上 disconnect后正常一些。
		            conn.disconnect();
		            //System.out.println("结束");
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		return jsonResult;


	}

	//写一个md5加密的方法
		public String md5(String plainText) {
			//定义一个字节数组
			byte[] secretBytes = null;
			try {
				  // 生成一个MD5加密计算摘要  
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            //对字符串进行加密
	            md.update(plainText.getBytes());
	            //获得加密后的数据
				secretBytes = md.digest();
			} catch (NoSuchAlgorithmException e) {
				throw new RuntimeException("没有md5这个算法！");
			}
			//将加密后的数据转换为16进制数字
			String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字
			// 如果生成数字未满32位，需要前面补0
			for (int i = 0; i < 32 - md5code.length(); i++) {
				md5code = "0" + md5code;
			}
			System.err.println(md5code);
			return md5code;
		}
	
}
