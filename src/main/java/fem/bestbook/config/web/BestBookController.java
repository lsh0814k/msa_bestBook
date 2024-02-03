package fem.bestbook.config.web;

import fem.bestbook.config.domain.BestBookService;
import fem.bestbook.config.domain.model.BestBook;
import fem.bestbook.config.web.dto.BookOutputDto;
import fem.bestbook.config.web.dto.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BestBookController {
    private final BestBookService bestBookService;

    @GetMapping("/books")
    public ResponseEntity<Result> getAllBooks() {
        List<BestBook> bestBooks = bestBookService.findAll();
        return ResponseEntity.ok(
                new Result(bestBooks.stream()
                        .map(BookOutputDto::mapToDTO)
                        .toList(),
                        bestBooks.isEmpty(),
                        bestBooks.size()));
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<BestBook> findBook(@PathVariable String id) {
        return ResponseEntity.ok(bestBookService.findById(id));
    }
}
