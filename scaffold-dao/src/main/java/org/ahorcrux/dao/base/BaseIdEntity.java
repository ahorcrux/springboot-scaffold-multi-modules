package org.ahorcrux.dao.base;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Data
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
public class BaseIdEntity implements Serializable {

    private static final long serialVersionUID = -5939639305613140760L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId(){
        return id;
    }
}
