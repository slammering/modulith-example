package com.hyand.modulith.example.masterdata.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MasterDataEntity {

    @Id
    @EqualsAndHashCode.Include
    private UUID id;
    @Column(name = "key_column")
    private String key;

}
