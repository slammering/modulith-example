package com.hyand.modulith.example.masterdata.repository;

import com.hyand.modulith.example.masterdata.entities.MasterDataEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MasterDataRepository extends CrudRepository<MasterDataEntity, UUID> {
}
