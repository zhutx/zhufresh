package com.moredian.tuna.certification.web.controller.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class AsyncHttpUtil {
	
	private static final String SERVLET_POST = "POST";
    private static final String SERVLET_GET = "GET";
    private static final String SERVLET_DELETE = "DELETE";
    private static final String SERVLET_PUT = "PUT";

    private static String prepareParam(Map<String, Object> paramMap) {
        StringBuffer sb = new StringBuffer();
        if (paramMap.isEmpty()) {
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
                String paramStr = prepareParam(paramMap);
                HttpURLConnection conn = null;
                try {
                    URL url = new URL(urlStr);
                    conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod(SERVLET_POST);
                    conn.setDoInput(true);
                    conn.setDoOutput(true);
                    OutputStream os = conn.getOutputStream();
                    os.write(paramStr.toString().getBytes("utf-8"));
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
                String paramStr = prepareParam(paramMap);
                HttpURLConnection conn = null;
                try {
                    URL url = new URL(urlStr);
                    conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod(SERVLET_PUT);
                    conn.setDoInput(true);
                    conn.setDoOutput(true);

                    OutputStream os = conn.getOutputStream();
                    os.write(paramStr.toString().getBytes("utf-8"));
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
    	paramMap.put("mobileNo", "15088668850");
		AsyncHttpUtil.doPost("http://120.24.220.86:9999/BUY_SERVER/account/checkCodeForRegister", paramMap, null);
	}

}
