package com.vita.jdi;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * JavascriptDirectInvoke
 * Created by HighProphet on 2015/11/13.
 */
public class JDIServlet extends HttpServlet {

    private List<Map<String,String>> classList;
    private List<Map<String,String>> beanList;

    public JDIServlet(){
        intialize();
    }

    private void intialize() {
        classList = new ArrayList<>();
        beanList = new ArrayList<>();
        try {
            SAXBuilder builder = new SAXBuilder();
            Document doc = builder.build(new File(Thread.currentThread().getContextClassLoader().getResource("").getPath() + "/jdi-cfg.xml"));
            Element root = doc.getRootElement();

        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //拆解url串
        String url = req.getRequestURL().toString();
        String rest = url.substring(url.lastIndexOf("jdi/") + 4);
        String module = rest.substring(0,rest.lastIndexOf("/"));
        String fun = rest.substring(rest.lastIndexOf("/")+1);
        resp.getWriter().println("lalala");
        resp.getWriter().close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
