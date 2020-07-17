package frank.controller;

import frank.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/1")
public class LoginController {

    @RequestMapping(value = "/login")
    public String login(Integer i){
        if(i==1){
            return "redirect:/index.html";  //进行重定向
        }else {
            return "forward:/index.html";  //进行转发
        }
    }

    @RequestMapping(value = "/login2",method = RequestMethod.POST)
    @ResponseBody
    /**
     * @RequestBody:返回的Content-Type响应头为application/json
     * 不带@RequestBody注解，需要返回字符串，表示静态资源路径
     */
    public Object login2(){
       User user =new User();
       user.setUsername("你好");
       user.setPassword("123");
       user.setBirthday(new Date());
       return user;
    }

    /**
     *  public Object login3(@RequestParam("username") String username1, String password, String birthday)是通过@Requestparam请求数据
     * 需要注意的点如下：
     * （1）不加注解，默认就是@RequestParam
     * （2）类型可以是封装数据类型，也可以是自定义类型
     * （3）请求数据中，键和自定义类型属性是匹配的
     * （4）可以接收URL中的数据+x-www-form-urlencoded(表单默认的提交方式) +form-data的方式
     */

    @RequestMapping(value = "/login3",method = RequestMethod.POST)
    @ResponseBody
    public Object login3(@RequestParam("username") String username1, String password, String birthday){
        System.out.println(username1 +"+" + password + "+" +birthday);
        User user =new User();
        user.setUsername("你好");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;
    }

    @RequestMapping(value = "/login4",method = RequestMethod.POST)
    @ResponseBody
    public Object login4(User u){
        System.out.println(u);
        User user =new User();
        user.setUsername("你好");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;
    }

    @RequestMapping(value = "/login5",method = RequestMethod.POST)
    @ResponseBody
    public Object login5(@RequestBody User u){
        System.out.println(u);
        User user =new User();
        user.setUsername("你好暗暗");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;
    }

    @RequestMapping(value = "/login6",method = RequestMethod.POST)
    @ResponseBody
    public Object login6(HttpServletRequest request, HttpServletResponse response, User u){
        if("高峰".equals(u.getUsername())&& "1234".equals(u.getPassword())){
            HttpSession session = request.getSession();
            session.setAttribute("user", u);
            System.out.println(u);
            User user =new User();
            user.setUsername("你好");
            user.setPassword("123");
            user.setBirthday(new Date());
            return user;
        }
       throw new RuntimeException("登录不成功");
    }
}



