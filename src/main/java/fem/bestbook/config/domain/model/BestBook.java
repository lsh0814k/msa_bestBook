package fem.bestbook.config.domain.model;

import fem.bestbook.config.domain.model.vo.Item;
import lombok.*;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Getter
@EqualsAndHashCode(of = "id")
@Builder(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
@NoArgsConstructor(access = PROTECTED)
public class BestBook {
    private String id;
    private Item item;
    private long rentCount;

    public static BestBook registerBestBook(Item item) {
        return BestBook
                .builder()
                .id(UUID.randomUUID().toString())
                .item(item)
                .rentCount(1)
                .build();
    }

    public long increaseBestBookCount() {
        this.rentCount = getRentCount() + 1;
        return this.rentCount;
    }
}
