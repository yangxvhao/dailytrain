package com.example.demo.service;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author yangx
 * @date 2019-12-15 16:06.
 */
public class MyImportBeanDefinition implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(MyFactoryBean.class);
        GenericBeanDefinition definition = (GenericBeanDefinition) builder.getBeanDefinition();
        definition.setAutowireMode(3);
        registry.registerBeanDefinition("myFactoryBean", definition);
    }
}
