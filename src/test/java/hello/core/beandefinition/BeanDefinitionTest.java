package hello.core.beandefinition;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanDefinitionTest {

    //AnnotationConfigApplicationContext ac =new AnnotationConfigApplicationContext(AppConfig.class); \
    // Bean을 만들 때 factoryBean을 이용해서 등록

    GenericXmlApplicationContext ac =new GenericXmlApplicationContext("appConfig.xml");
    //xml버전, Bean을 만들 때 직접 등록


    @Test
    @DisplayName("빈 설정 메타 정보 확인")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole()==BeanDefinition.ROLE_APPLICATION)
            {
                System.out.println("beanDefinitionName = "+ beanDefinitionName + " beanDefinition = " +  beanDefinition);
            }
        }

    }
}
