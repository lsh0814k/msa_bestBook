package fem.bestbook.domain.model.vo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
@EqualsAndHashCode(of = "no")
public class Item {
    private Long no;
    private String title;

    public static Item createItem(Long no, String title) {
        return new Item(no, title);
    }
}
