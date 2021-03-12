package org.jiang.util;


import org.jiang.model.Dog;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * @Description TODO
 * @Author jiang
 * @Create 2021/3/12
 * @Version 1.0
 */
@Component
public class TestImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{Dog.class.getName()};
    }
}
