package fem.bestbook.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fem.bestbook.domain.BestBookService;
import fem.bestbook.domain.event.ItemRented;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RentBestBookConsumer {
    private final ObjectMapper objectMapper;
    private final BestBookService bestBookService;
    private static final String TOPIC = "TOPIC_RENT";

    @KafkaListener(topics = TOPIC, groupId = "bestbook")
    public void consume(ConsumerRecord<String, String> record) {
        try {
            ItemRented itemRented = objectMapper.readValue(record.value(), ItemRented.class);
            bestBookService.dealBestBook(itemRented.getItem());
        } catch (JsonProcessingException e) {
            log.error("json 변환 에러 : ", e);
            throw new IllegalStateException(e);
        }

    }


}
