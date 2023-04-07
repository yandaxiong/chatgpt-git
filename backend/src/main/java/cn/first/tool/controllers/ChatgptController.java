package cn.first.tool.controllers;

import cn.first.tool.controllers.request.Message;
import cn.first.tool.controllers.response.QueryBalanceResponse;
import cn.first.tool.services.ChatGPTService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@RestController
@RequestMapping("api/xinqiu")
@RequiredArgsConstructor
@ResponseBody
public class ChatgptController {
    private final ChatGPTService gptService;

    @GetMapping("/balances")
    public QueryBalanceResponse queryBalanceResponse(@RequestParam(required = false) String apiKey) {
        return gptService.creditQuery(apiKey);
    }

    @PostMapping("send")
    public void stream(@RequestBody Message message,
                       HttpServletResponse response) throws IOException {

        OutputStream outputStream = response.getOutputStream();
        response.setContentType("application/octet-stream");
        gptService.sendResponse(message, (str) -> {
            try {
                if (!"END".equals(str)) {
                    outputStream.write(str.getBytes());
                    outputStream.flush();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });
        outputStream.close();
    }
}
