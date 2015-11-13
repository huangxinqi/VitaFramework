package com.vita.ioc;

import com.vita.test.Person;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * VitaIoCImpl 依赖注入
 * Created by HighProphet on 2015/11/13.
 */
public class VitaIoCImpl implements IoCInterface {

    private Map<String,String> map;

    private static VitaIoCImpl instance;

    private VitaIoCImpl() {
        map = new HashMap<>();
        SAXBuilder builder = new SAXBuilder();
        try {
            String filePath = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "vitaioc-cfg.xml";
            Document document = builder.build(new File(filePath));
            Element root = document.getRootElement();
            if (root == null){
                throw new Exception("'vitaioc-cfg.xml文件格式错误'");
            }
            List<Element> list = root.getChildren("map");
            String name = null;
            String value = null;
            for (Element map : list){
                name = map.getChildText("name");
                value= map.getChildText("value");
                this.map.put(name,value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized static VitaIoCImpl getInstance() {
        if (instance == null) {
            instance = new VitaIoCImpl();
        }
        return instance;
    }

    public Object getBean(String name){
        Object result = null;
        String className = map.get(name);
        try {
            if (className == null){
                throw new Exception("没有名为\"" + name +"\"的映射对象");
            }
            Class c = Class.forName(className);
            result = c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args){
        IoCInterface v = VitaIoCNativeImpl.getInstance();
        Person p = (Person)v.getBean("Person");
        System.out.println(p.getName());
    }
}
