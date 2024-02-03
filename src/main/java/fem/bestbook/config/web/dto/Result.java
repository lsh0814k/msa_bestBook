package fem.bestbook.config.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Result<T> {
    private T data;
    private boolean isEmpty;
    private int size;

}
