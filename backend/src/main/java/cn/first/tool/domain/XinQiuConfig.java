package cn.first.tool.domain;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Component
@Configuration
@ConfigurationProperties(prefix = "xinqiu")
public class XinQiuConfig {
    private String content = "【AI魔法妙妙屋】";
    private String auth = "xinqiu";
    private String freeApiKey;
    private String notAuthContent;
    private String sqlitePath;
}
