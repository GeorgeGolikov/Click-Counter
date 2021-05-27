package project.repository;

import org.springframework.data.repository.CrudRepository;
import project.entity.ClickCount;

public interface ClickCountRepository extends CrudRepository<ClickCount, Integer> {

}
