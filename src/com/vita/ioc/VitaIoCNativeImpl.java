package com.vita.ioc;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Uncompelted!!!
 *
 * Created by HighProphet on 2015/11/13.
 */
public class VitaIoCNativeImpl implements IoCInterface {
    private Map<String, String> map;

    private static VitaIoCNativeImpl instance;

    private VitaIoCNativeImpl() {
        map = new HashMap<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            String filePath = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "vitaioc-cfg.xml";
            Document document = builder.parse(new File(filePath));
            Element root = document.getDocumentElement();
            if (root == null) {
                throw new Exception("'vitaioc.cfg.xml文件格式错误'");
            }
            NodeList list = root.getChildNodes();
            Node map = null;
            String name = null;
            String value = null;
            for (int i = 0;i < list.getLength();i++){
                map = list.item(i);
                name = map.getChildNodes().item(0).getTextContent();
                value = map.getChildNodes().item(0).getTextContent();
                this.map.put(name, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized static VitaIoCNativeImpl getInstance() {
        if (instance == null) {
            instance = new VitaIoCNativeImpl();
        }
        return instance;
    }

    @Override
    public Object getBean(String name) {
        Object obj = null;
        String className = map.get(name);
        try {
            if (className == null) {
                throw new Exception("没有名为\"" + name + "\"的映射对象");
            }
            Class c = Class.forName(className);
            obj = c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

}
