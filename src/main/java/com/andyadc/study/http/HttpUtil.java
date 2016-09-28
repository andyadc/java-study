package com.andyadc.study.http;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * A http utility class that sends http request and parse response.
 *
 * @author mindwind
 * @version 1.0, 2011-10-18
 */
public class HttpUtil {


    public static final String DEFAULT_CHARSET = "UTF-8";
    public static final String DEFAULT_CONTENT_TYPE = "application/x-www-form-urlencoded;charset=";
    private static final Map<String, String> DEFAULT_HEADER = new HashMap<>();


    static {
        DEFAULT_HEADER.put("User-Agent", "http-util");
        DEFAULT_HEADER.put("Accept", "text/xml,text/javascript,text/html");
    }


    /**
     * Build http query string.
     *
     * @param params
     * @param charset
     * @return http query string
     * @throws UnsupportedEncodingException
     */
    public static String buildQuery(Map<String, String> params, String charset) throws UnsupportedEncodingException {
        if (params == null || params.isEmpty()) {
            return null;
        }

        StringBuilder query = new StringBuilder();
        Set<Entry<String, String>> entries = params.entrySet();
        boolean hasParam = false;
        for (Entry<String, String> entry : entries) {
            String name = entry.getKey();
            String value = entry.getValue();
            if (isAllNotEmpty(name, value)) {
                if (hasParam) {
                    query.append("&");
                } else {
                    hasParam = true;
                }
                query.append(name).append("=").append(URLEncoder.encode(value, charset));
            }
        }

        return query.toString();
    }

    public static boolean isAllNotEmpty(String... strings) {
        if (isAnyEmpty(strings)) {
            return false;
        }
        return true;
    }

    public static boolean isAnyEmpty(String... strings) {
        if (strings == null) {
            return true;
        }

        for (String s : strings) {
            if (isEmpty(s)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    /**
     * Execute http post request, using query string as post content with
     * default charset(UTF-8).
     *
     * @param url
     * @param params
     * @param connectTimeout an int that specifies the connect timeout value in milliseconds
     * @param readTimeout    an int that specifies the read timeout value in milliseconds
     * @return post response
     * @throws Exception
     */
    public static String doPost(String url, Map<String, String> params, int connectTimeout, int readTimeout) throws Exception {
        return doPost(url, params, DEFAULT_CHARSET, connectTimeout, readTimeout);
    }

    /**
     * Execute http post request, using query string as post content with
     * dedicated charset.
     *
     * @param url
     * @param params
     * @param charset
     * @param connectTimeout an int that specifies the connect timeout value in milliseconds
     * @param readTimeout    an int that specifies the read timeout value in milliseconds
     * @return post response
     * @throws Exception
     */
    public static String doPost(String url, Map<String, String> params, String charset, int connectTimeout, int readTimeout) throws Exception {
        String ctype = DEFAULT_CONTENT_TYPE + charset;
        String query = buildQuery(params, charset);
        byte[] content = {};
        if (query != null) {
            content = query.getBytes(charset);
        }
        return doPost(url, ctype, content, DEFAULT_HEADER, connectTimeout, readTimeout);
    }

    /**
     * Execute http post request, use dedicated content and content type with
     * dedicated header.
     *
     * @param url
     * @param contentType
     * @param content
     * @param connectTimeout an int that specifies the connect timeout value in milliseconds
     * @param readTimeout    an int that specifies the read timeout value in milliseconds
     * @param header
     * @return post response
     * @throws IOException
     */
    public static String doPost(String url, String contentType, byte[] content, Map<String, String> header, int connectTimeout, int readTimeout) throws IOException {
        HttpURLConnection conn = null;
        OutputStream out = null;
        String rsp = null;
        try {
            conn = getConnection(new URL(url), "POST", contentType, header);
            conn.setConnectTimeout(connectTimeout);
            conn.setReadTimeout(readTimeout);

            out = conn.getOutputStream();
            out.write(content);
            rsp = getResponseAsString(conn);
        } finally {
            if (out != null) {
                out.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }

        return rsp;
    }

    private static HttpURLConnection getConnection(URL url, String method, String ctype, Map<String, String> header) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod(method);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", ctype);

        if (header != null) {
            for (Map.Entry<String, String> entry : header.entrySet()) {
                conn.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }

        return conn;
    }

    private static String getResponseAsString(HttpURLConnection conn) throws IOException {
        String charset = getResponseCharset(conn.getContentType());
        InputStream es = conn.getErrorStream();
        if (es == null) {
            return getStreamAsString(conn.getInputStream(), charset);
        } else {
            String msg = getStreamAsString(es, charset);
            if (isBlank(msg)) {
                throw new IOException(conn.getResponseCode() + ":" + conn.getResponseMessage());
            } else {
                throw new IOException(msg);
            }
        }
    }

    private static String getResponseCharset(String ctype) {
        String charset = DEFAULT_CHARSET;

        if (!isBlank(ctype)) {
            String[] params = ctype.split(";");
            for (String param : params) {
                param = param.trim();
                if (param.startsWith("charset")) {
                    String[] pair = param.split("=", 2);
                    if (pair.length == 2 && !isBlank(pair[1])) {
                        charset = pair[1].trim();
                    }
                    break;
                }
            }
        }
        return charset;
    }

    private static String getStreamAsString(InputStream stream, String charset) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream, charset));
            StringWriter writer = new StringWriter();

            char[] chars = new char[256];
            int count = 0;
            while ((count = reader.read(chars)) > 0) {
                writer.write(chars, 0, count);
            }

            return writer.toString();
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
    }

    private HttpUtil() {
        throw new UnsupportedOperationException();
    }

    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!(Character.isWhitespace(str.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

}