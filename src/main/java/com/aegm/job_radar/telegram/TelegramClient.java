package com.aegm.job_radar.telegram;

import com.aegm.job_radar.config.TelegramProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.http.MediaType;
import java.util.Map;

@Component
public class TelegramClient {
    private final RestClient restClient;

    public TelegramClient(RestClient.Builder builder, TelegramProperties props){
        this.restClient = builder.baseUrl("https://api.telegram.org/bot" + props.botToken()).build();
    }

    public void sendMessage(Long chatId, String text){
       restClient.post()
               .uri("/sendMessage")
               .contentType(MediaType.APPLICATION_JSON)
               .body(Map.of("chat_id",chatId,"text", text))
               .retrieve()
               .toBodilessEntity();
    }
}
