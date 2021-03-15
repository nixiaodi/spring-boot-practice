package org.jiang.factory;

import org.jiang.model.Flower;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author jiang
 * @Create 2021/3/11
 * @Version 1.0
 */
@Component
public class TestFacoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        Flower flower = new Flower();
        flower.setColor("red");
        flower.setName("玫瑰");
        return flower;
    }

    @Override
    public Class<?> getObjectType() {
        return Flower.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
