package cn.first.tool.controllers.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author xiong
 * @Description
 * @date 2023-04-07 1:09 下午
 */
@Setter
@Getter
public class User {
    private String userName;
    private String passWord;
    private String apiKey;
}
