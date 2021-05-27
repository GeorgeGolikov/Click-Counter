package project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClickCount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer clicksCount;

    public ClickCount() {

    }

    public ClickCount(Integer clicksCount) {
        this.clicksCount = clicksCount;
    }

    public ClickCount(Integer id, Integer clicksCount) {
        this.id = id;
        this.clicksCount = clicksCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClicksCount() {
        return clicksCount;
    }

    public void setClicksCount(Integer clicksCount) {
        this.clicksCount = clicksCount;
    }
}
