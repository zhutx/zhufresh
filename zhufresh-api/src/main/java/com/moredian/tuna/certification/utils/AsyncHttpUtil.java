package com.moredian.tuna.certification.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.moredian.bee.common.utils.JsonUtils;

public class AsyncHttpUtil {
	
	private static final String SERVLET_POST = "POST";
    private static final String SERVLET_GET = "GET";
    private static final String SERVLET_DELETE = "DELETE";
    private static final String SERVLET_PUT = "PUT";

    private static String prepareParam(Map<String, Object> paramMap) {
        StringBuffer sb = new StringBuffer();
        if (paramMap == null || paramMap.isEmpty()) {
            return "";
        } else {
            for (String key : paramMap.keySet()) {
                String value = String.valueOf(paramMap.get(key));
                if (sb.length() < 1) {
                    sb.append(key).append("=").append(value);
                } else {
                    sb.append("&").append(key).append("=").append(value);
                }
            }
            return sb.toString();
        }
    }

    public static void doPost(final String urlStr,
            final Map<String, Object> paramMap,
            final HttpCallbackListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //String paramStr = prepareParam(paramMap);
                HttpURLConnection conn = null;
                try {
                    URL url = new URL(urlStr);
                    conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod(SERVLET_POST);
                    conn.setRequestProperty("Content-Type", "application/json");
                    conn.setRequestProperty("Charset", "UTF-8"); 
                    conn.setDoInput(true);
                    conn.setDoOutput(true);
                    OutputStream os = conn.getOutputStream();
                    
                    //os.write(paramStr.toString().getBytes("utf-8"));
                    os.write(JsonUtils.toJson(paramMap).getBytes("utf-8"));
                    os.close();

                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(conn.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    reader.close();
                    if (listener != null) {
                        listener.onFinish(response.toString());
                    }
                } catch (Exception e) {
                    if (listener != null) {
                        listener.onError(e);
                    }
                } finally {
                    if (listener != null) {
                        conn.disconnect();
                    }
                }
            }
        }).start();

    }
    
    public static void doGet(final String urlStr,
            final Map<String, Object> paramMap,
            final HttpCallbackListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                String myurl = urlStr;
                String paramStr = prepareParam(paramMap);
                if (paramStr != null && paramStr.trim().length() > 0) {
                    myurl += "?" + paramStr;
                }
                HttpURLConnection conn = null;
                try {
                    URL url = new URL(myurl);
                    conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod(SERVLET_GET);
                    conn.setRequestProperty("Content-Type",
                            "text/html; charset=UTF-8");
                    conn.connect();

                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(conn.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    reader.close();
                    if (listener != null) {
                        listener.onFinish(response.toString());
                    }
                } catch (Exception e) {
                    if (listener != null) {
                        listener.onError(e);
                    }
                } finally {
                    if (listener != null) {
                        conn.disconnect();
                    }
                }
            }
        }).start();

    }

    public static void doPut(final String urlStr,
            final Map<String, Object> paramMap,
            final HttpCallbackListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //String paramStr = prepareParam(paramMap);
                HttpURLConnection conn = null;
                try {
                    URL url = new URL(urlStr);
                    conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod(SERVLET_PUT);
                    conn.setDoInput(true);
                    conn.setDoOutput(true);

                    OutputStream os = conn.getOutputStream();
                    //os.write(paramStr.toString().getBytes("utf-8"));
                    os.write(JsonUtils.toJson(paramMap).getBytes("utf-8"));
                    os.close();

                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(conn.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    reader.close();
                    if (listener != null) {
                        listener.onFinish(response.toString());
                    }
                } catch (Exception e) {
                    if (listener != null) {
                        listener.onError(e);
                    }
                } finally {
                    if (listener != null) {
                        conn.disconnect();
                    }
                }
            }
        }).start();

    }

    public static void doDelete(final String urlStr,
            final Map<String, Object> paramMap,
            final HttpCallbackListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                String myurl = urlStr;
                String paramStr = prepareParam(paramMap);
                if (paramStr != null && paramStr.trim().length() > 0) {
                    myurl += "?" + paramStr;
                }

                HttpURLConnection conn = null;
                try {
                    URL url = new URL(myurl);
                    conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod(SERVLET_DELETE);
                    conn.setDoOutput(true);

                    if (conn.getResponseCode() == 200) {
                        if (listener != null) {
                            listener.onFinish(null);
                        }
                    }
                } catch (Exception e) {
                    if (listener != null) {
                        listener.onError(e);
                    }
                } finally {
                    if (listener != null) {
                        conn.disconnect();
                    }
                }
            }
        }).start();

    }
    
    public static void main(String[] args) {
    	Map<String, Object> paramMap = new HashMap<String, Object>();
    	paramMap.put("authRecordId", 1576406139011072000L);
    	
    	String json = "{\"authRecordId\":1576410296539414528,\"authWay\":1,\"catchImageUrl\":\"/memberFaceImage/2017/8/22/14/ca694e7257644d9482260b12b88e7292.jpg\",\"matchImageUrl\":\"/memberFaceImage/2017/8/22/14/0635a352edec4f8aaa552114e39c989a.jpg\",\"deviceId\":1572339921673256960,\"deviceSn\":\"AUK0BGHAS4\",\"orgType\":4,\"orgId\":1572324605819879424,\"orgName\":\"魔点调试酒店\",\"provinceCode\":330000,\"cityCode\":330100,\"townCode\":330110107,\"orgAddress\":\"海智创业茂\",\"authTime\":1503382012508,\"confidence\":95.80044,\"realName\":\"朱田祥\",\"sex\":1,\"nature\":1,\"birthday\":\"19861014\",\"address\":\"浙江省杭州市余杭区仓前街道太炎社区仓兴街293-11号\",\"certNo\":\"330381198610141415\",\"signOrg\":\"杭州市公安局余杭分局\",\"validBeginDate\":\"2017-08-22 00:00:000\",\"validEndDate\":\"2017-08-22 00:00:000\",\"provPoliceOrgId\":1572327337419079680,\"cityPoliceOrgId\":1572327363188883456,\"districtPoliceOrgId\":1572327449088229376,\"townPoliceOrgId\":1572327483447967744,\"status\":1}";
		JsonUtils.fromJson(Map.class, json);
    	AsyncHttpUtil.doPost("http://192.168.4.66:8107/alarm/receiveAuth", JsonUtils.fromJson(Map.class, json), new HttpCallbackListener() {
			
			@Override
			public void onFinish(String response) {
				System.out.println(response);
			}
			
			@Override
			public void onError(Exception e) {
				e.printStackTrace();
			}
		});
	}

}
