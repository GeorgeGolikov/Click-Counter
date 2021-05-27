package project.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import project.entity.ClickCount;

import javax.transaction.Transactional;

public interface ClickCountRepository extends CrudRepository<ClickCount, Integer> {
    @Transactional
    @Modifying
    @Query("update ClickCount set clicksCount = clicksCount + 1 where id = ?1")
    void modifyById(Integer id);
}
