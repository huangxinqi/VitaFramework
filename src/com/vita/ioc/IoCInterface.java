package com.vita.ioc;

/**
 * Created by HighProphet on 2015/11/13.
 */
public interface IoCInterface {

    /**
     * 根据所传name参数获取对象实例
     *
     * @param name 对象映射名
     * @return 该映射类的实例
     */
    public Object getBean(String name);
}
