package Socket;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class MicrodustAPI {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			String serviceKey = "=UmU5EoBOt1mOKZA2%2F01kyOqnL0wPMpGw4N47LjKZZUIjPQ3XKdOrV%2F9u%2Bb8O%2FHs%2BQkzyEHZOc4Wr%2BzHWu6OFyw%3D%3D";
        
			StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/UlfptcaAlarmInqireSvc/getUlfptcaAlarmInfo"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + serviceKey); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*xml �̳� json*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*�� ������ ��� ��*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*��������ȣ*/
	        urlBuilder.append("&" + URLEncoder.encode("year","UTF-8") + "=" + URLEncoder.encode("2020", "UTF-8"));  /*���� ����*/
	        urlBuilder.append("&" + URLEncoder.encode("itemCode","UTF-8") + "=" + URLEncoder.encode("PM10", "UTF-8")); /*�̼����� �׸� ����(PM10, PM25), PM10/PM25 ��� ��ȸ�� ��� �Ķ���� ����*/
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	       
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();
	        String result =sb.toString();
	        
	        System.out.println(result);
	        System.out.println();
	        
	      //JSON parser�� ����� �޾ƿ� ���ڿ��� ��üȭ
		    JSONParser jsonParser = new JSONParser();
			JSONObject jsonObj = (JSONObject) jsonParser.parse(result);
			JSONObject parse_response = (JSONObject) jsonObj.get("response");
			JSONObject parse_body = (JSONObject) parse_response.get("body");// response �� ���� body ã�ƿ���
			JSONArray parse_items = (JSONArray) parse_body.get("items");// body �κ��� items �迭 ��ü ã�ƿ���
			JSONObject weather;// ��ü�迭�� ��ü���� �����뵵
            String miseType = "";// �̼��������� �ʹ̼��������� ��Ÿ�� ���ڿ�
            
            for (int i=0;i< parse_items.size();i++) {
                weather= (JSONObject) parse_items.get(i);
                
                String dataDate = (String) weather.get("dataDate");            // �߷���, (issueDate�� ���Ƽ� ���� ��������� ����)
                String districtName = (String) weather.get("districtName");    // ������
                String moveName = (String) weather.get("moveName");            // �ǿ���
                String issueDate = (String) weather.get("issueDate");        // �߷���
                String issueTime = (String) weather.get("issueTime");        // �߻��ð�
                String issueVal  = (String) weather.get("issueVal");        // �󵵰�
                String itemCode  = (String) weather.get("itemCode");        // �̼������� ����, PM10, PM25 �ΰ����� ����
                String issueGbn  = (String) weather.get("issueGbn");        // �溸�ܰ�
                String clearDate = (String) weather.get("clearDate");        // ������
                String clearTime = (String) weather.get("clearTime");        // �����ð�
                String clearVal = (String) weather.get("clearVal");            // ������
                
                if (itemCode.equals("PM10")) {            
                    miseType = "PM10";
                } else if (itemCode.equals("PM25")) {    //�� '�̼����� �׸� ����'���� PM10���� �����س��Ƽ� ���� ���� �������� ����, �� �Ķ���͸� �����ϸ� Ȯ�ΰ���
                    miseType = "PM2.5";
                }
                StringBuffer sb2 = new StringBuffer();// ���ڿ��� ��ȯ�� �͵��� �ϳ��� ��ġ�� ���� �뵵
                sb2.append("Date & Time: " + issueDate +" " + issueTime +", Area : " + districtName + " ("+ moveName +"), "  + " intensity : " + issueVal + " ("+ issueGbn +") " + miseType);
                System.out.println(sb2.toString());               
            }
            
         
        } catch (Exception e) {
            e.printStackTrace();
        }
	
	
	
	}

}
