package org.ahorcrux.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.ahorcrux.dao.base.BaseIsDeletedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@SuperBuilder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "demo")
public class EDemo extends BaseIsDeletedEntity {

    @Column(name="demo")
    private String demo;
}

