package fem.bestbook.config.web.dto;

import fem.bestbook.config.domain.model.BestBook;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
@Builder(access = PRIVATE)
public class BookOutputDto {
    private String bestBookId;
    private Long bookId;
    private String bookTitle;
    private long rentCount;

    public static BookOutputDto mapToDTO(BestBook book) {
        return BookOutputDto.builder()
                .bestBookId(book.getId())
                .bookId(book.getItem().getNo())
                .bookTitle(book.getItem().getTitle())
                .rentCount(book.getRentCount())
                .build();
    }
}
