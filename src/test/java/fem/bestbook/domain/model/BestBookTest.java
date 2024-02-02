package fem.bestbook.domain.model;

import fem.bestbook.ItemFactory;
import fem.bestbook.config.domain.model.BestBook;
import fem.bestbook.config.domain.model.vo.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BestBookTest {

    @Test
    @DisplayName("베스터셀러 등록")
    void register() {
        Item item = ItemFactory.create();
        BestBook bestBook = BestBook.registerBestBook(item);

        assertThat(bestBook.getRentCount()).isEqualTo(1);
        assertThat(bestBook.getItem()).isEqualTo(item);
    }

    @Test
    @DisplayName("베스트셀러 대여 수 증가")
    void increaseCount() {
        BestBook bestBook = BestBook.registerBestBook(ItemFactory.create());

        bestBook.increaseBestBookCount();
        assertThat(bestBook.getRentCount()).isEqualTo(2);
    }
}
