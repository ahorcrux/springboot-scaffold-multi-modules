package org.ahorcrux.dao.base;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Data
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
public class BaseIsDeletedEntity extends BaseDateEntity {

    @Column(name = "is_deleted")
    private Integer isDeleted;

}

