package fem.bestbook.config.persistence;

import fem.bestbook.config.domain.model.BestBook;
import fem.bestbook.config.domain.model.vo.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BestBookRepository extends MongoRepository<BestBook, String> {
    Optional<BestBook> findByItem(Item item);
}
