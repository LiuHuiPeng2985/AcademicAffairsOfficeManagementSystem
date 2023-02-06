package controller;

/*
 * @author  LiuHuiPeng
 */

import cn.dsna.util.images.ValidateCode;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.temporal.ValueRange;

/**
 * 验证码
 */
@WebServlet(name = "CreateCodeController",urlPatterns = "/createCode")
public class CreateCodeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建验证码
        ValidateCode validateCode = new ValidateCode(200,30,4,10);
        //拿到输入的字符串
        String codes = validateCode.getCode();
        //将验证码存入到session中
        HttpSession session = req.getSession();
        session.setAttribute("codes",codes);
        validateCode.write(resp.getOutputStream());
    }
}
