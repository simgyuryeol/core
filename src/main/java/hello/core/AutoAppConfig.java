package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // 찾고자하는 범위 지정, 지정하지 않는 default는 ComponentScan이 붙은 해당 클래스의 패키지가 시작위치
        basePackages = "hello.core",
        basePackageClasses = AutoAppConfig.class, // 지정한 클래스의 패키지를 탐색 시작 위치로 설정
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Configuration.class)
        //컴포넌트 스캔으로 뺄 것을 설정 Configuration 붙어 있는 클래스를 스캔에서 뺌
)
public class AutoAppConfig {

}
