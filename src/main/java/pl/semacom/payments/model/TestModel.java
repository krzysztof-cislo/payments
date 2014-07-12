package pl.semacom.payments.model;

import javax.jdo.annotations.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TestModel {

    @Id
    private Long id;

    @Column
    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}
