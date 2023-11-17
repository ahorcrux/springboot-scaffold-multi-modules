package org.ahorcrux.dao.base;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
public class BaseDateEntity extends BaseIdEntity {

    @Column(name = "gmt_created")
    private Date gmtCreated;

    @Column(name = "gmt_modified")
    private Date gmtModified;

}

