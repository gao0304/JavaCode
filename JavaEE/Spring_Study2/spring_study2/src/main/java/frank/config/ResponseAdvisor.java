package frank.config;

import frank.model.Response;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice  //响应数据的封装
public class ResponseAdvisor implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        // 返回true，表示响应数据时，先执行beforeBodyWrite   返回false则不执行
        //获取请求方法对象，判断Controller方法上是否有@ResponseBody
        return methodParameter.getMethod().getAnnotation(ResponseBody.class) != null;
    }

    //Body为请求方法执行完以后返回的对象
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        Response resp = new Response();
        resp.setSuccess(true);
        resp.setData(o);
        return resp;
    }
}
