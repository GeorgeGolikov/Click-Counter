package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.entity.ClickCount;
import project.repository.ClickCountRepository;

import java.util.Iterator;

@Service
public class ClickCountServiceImpl implements ClickCountService {
    private ClickCountRepository repository;
    private Integer clickCountId;

    @Autowired
    public ClickCountServiceImpl(ClickCountRepository repository) {
        this.repository = repository;

        Iterator<ClickCount> it = repository.findAll().iterator();
        clickCountId = it.hasNext() ?
                it.next().getId() :
                repository.save(new ClickCount(0)).getId();
    }

    @Override
    public Integer loadClicksCount() {
        return repository.findById(clickCountId).get().getClicksCount();
    }

    @Override
    public void updateClicksCount() {
        Integer count = loadClicksCount() + 1;
        repository.save(new ClickCount(clickCountId, count));
    }
}
