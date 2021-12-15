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
	        urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*xml 이나 json*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
	        urlBuilder.append("&" + URLEncoder.encode("year","UTF-8") + "=" + URLEncoder.encode("2020", "UTF-8"));  /*측정 연도*/
	        urlBuilder.append("&" + URLEncoder.encode("itemCode","UTF-8") + "=" + URLEncoder.encode("PM10", "UTF-8")); /*미세먼지 항목 구분(PM10, PM25), PM10/PM25 모두 조회할 경우 파라미터 생략*/
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
	        
	      //JSON parser을 만들어 받아온 문자열을 객체화
		    JSONParser jsonParser = new JSONParser();
			JSONObject jsonObj = (JSONObject) jsonParser.parse(result);
			JSONObject parse_response = (JSONObject) jsonObj.get("response");
			JSONObject parse_body = (JSONObject) parse_response.get("body");// response 로 부터 body 찾아오기
			JSONArray parse_items = (JSONArray) parse_body.get("items");// body 로부터 items 배열 객체 찾아오기
			JSONObject weather;// 객체배열을 객체별로 읽을용도
            String miseType = "";// 미세먼지인지 초미세먼지인지 나타낼 문자열
            
            for (int i=0;i< parse_items.size();i++) {
                weather= (JSONObject) parse_items.get(i);
                
                String dataDate = (String) weather.get("dataDate");            // 발령일, (issueDate와 같아서 따로 사용하지는 않음)
                String districtName = (String) weather.get("districtName");    // 지역명
                String moveName = (String) weather.get("moveName");            // 권역명
                String issueDate = (String) weather.get("issueDate");        // 발령일
                String issueTime = (String) weather.get("issueTime");        // 발생시간
                String issueVal  = (String) weather.get("issueVal");        // 농도값
                String itemCode  = (String) weather.get("itemCode");        // 미세먼지의 종류, PM10, PM25 두가지로 구분
                String issueGbn  = (String) weather.get("issueGbn");        // 경보단계
                String clearDate = (String) weather.get("clearDate");        // 해제일
                String clearTime = (String) weather.get("clearTime");        // 해제시간
                String clearVal = (String) weather.get("clearVal");            // 해제농도
                
                if (itemCode.equals("PM10")) {            
                    miseType = "PM10";
                } else if (itemCode.equals("PM25")) {    //위 '미세먼지 항목 구분'에서 PM10으로 고정해놓아서 따로 값이 나오지는 않음, 위 파라메터를 삭제하면 확인가능
                    miseType = "PM2.5";
                }
                StringBuffer sb2 = new StringBuffer();// 문자열로 변환한 것들을 하나로 합치기 위한 용도
                sb2.append("Date & Time: " + issueDate +" " + issueTime +", Area : " + districtName + " ("+ moveName +"), "  + " intensity : " + issueVal + " ("+ issueGbn +") " + miseType);
                System.out.println(sb2.toString());               
            }
            
         
        } catch (Exception e) {
            e.printStackTrace();
        }
	
	
	
	}

}
