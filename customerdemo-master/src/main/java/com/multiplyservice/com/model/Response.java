package com.multiplyservice.com.model;




import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;



@Entity
@Table(name = "responses")
@Getter
@Setter
@ToString

public class Response extends BaseEntity implements Serializable {

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private BigDecimal value;

}
