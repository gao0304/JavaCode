/**
 * 响应的格式：
 *           状态行（版本  状态码  描述） \r\n或者是\n
 *           响应头（很多行，直到一个空行出现） ：key-->value
 *           可选的响应正文（业务关心的部分）
 *       这里涉及到响应如何将请求解包和分用的问题：
 *           如何解包：通过空行来划分开请求头和正文部分
 *           如何分用：通过Host+URL实现 （先通过Host找到首页，然后通过URL里的各种资源路径实现分用）
 */
//给客户端发响应
package v2;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class Response {
    String status="200 OK"; //设置默认的响应状态
    public Map<String,String> headers=new HashMap<>(); //将众多响应头放到Map中存储
    StringBuilder bodyBuilder=new StringBuilder();//定义正文

    Response(){
        headers.put("Content-Type", "text/html; charset=utf-8");
    }//设置默认的响应body格式
    public void setStatus(String status) { //初始化status属性
        this.status = status;
    }

    public void setHeader(String key,String value){
        headers.put(key, value); //执行普通方法
    }

    public void print(String s){
        bodyBuilder.append(s);
    }

    public void println(String s){
        bodyBuilder.append(s);
        bodyBuilder.append("\r\n");
    }
    public void writerAndFlush(OutputStream os) throws IOException {
        //1.准备组装响应（分为状态行，响应报头，响应正文）
        String responseBuilder = buildResponse();
        //2.发送
        os.write(responseBuilder.toString().getBytes("UTF-8"));
        os.flush();
    }

    private String buildResponse() throws UnsupportedEncodingException {
        StringBuilder responseBuilder=new StringBuilder();
        //1.1组装状态行
        responseBuilder.append("HTTP/1.0 ");
        responseBuilder.append(status); //status:状态，也就是200 OK之类的
        responseBuilder.append("\r\n");
        //1.2组装响应头
        if(bodyBuilder.length()!=0){
            //计算Content-Length
            int contentLength=bodyBuilder.toString().getBytes("UTF-8").length;
            setHeader("Content-Length",String.valueOf(contentLength));
        }
        for(Map.Entry<String,String> entry :headers.entrySet()){
            responseBuilder.append(entry.getKey());
            responseBuilder.append(": ");
            responseBuilder.append(entry.getValue());
            responseBuilder.append("\r\n");
        }
        responseBuilder.append("\r\n");
        //1.3添加响应正文
        responseBuilder.append(bodyBuilder);
        System.out.println(responseBuilder.toString());
        return responseBuilder.toString();
    }
}

