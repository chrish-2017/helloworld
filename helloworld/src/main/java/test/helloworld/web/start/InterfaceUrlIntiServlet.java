package test.helloworld.web.start;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * @author Zou Ling
 * @date 2016年9月7日 上午11:04:16
 * @description 项目启动初始化servlet
 */
public class InterfaceUrlIntiServlet extends HttpServlet {
	 
    private static final long serialVersionUID = 1L;
 
    @Override
    public void init(ServletConfig config) throws ServletException {
        InterfaceUrlInti.init();
    }
 
}
