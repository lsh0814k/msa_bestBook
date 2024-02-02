package fem.bestbook.config.domain;

import fem.bestbook.config.domain.model.BestBook;
import fem.bestbook.config.domain.model.vo.Item;
import fem.bestbook.config.persistence.BestBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BestBookService {
    private final BestBookRepository bestBookRepository;

    public List<BestBook> findAll() {
        return bestBookRepository.findAll();
    }

    public BestBook findById(String id) {
        return bestBookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("찾으시는 책이 없습니다."));
    }

    public void dealBestBook(Item item) {
        Optional<BestBook> bestBookOptional = bestBookRepository.findByItem(item);

        if (bestBookOptional.isPresent()) {
            bestBookOptional.get().increaseBestBookCount();
        } else {
            BestBook bestBook = BestBook.registerBestBook(item);
            bestBookRepository.save(bestBook);
        }
    }
}
