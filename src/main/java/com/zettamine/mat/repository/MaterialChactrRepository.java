package com.zettamine.mat.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zettamine.mat.entity.MaterialCharacteristics;

public interface MaterialChactrRepository extends JpaRepository<MaterialCharacteristics, Serializable> {

	@Query("from com.zettamine.mat.entity.MaterialCharacteristics where active='active'")
	List<MaterialCharacteristics> findAllMaterialChars();
	
	@Query("select mc from com.zettamine.mat.entity.MaterialCharacteristics mc where characterId=:chid and active ='active'")
	Optional<MaterialCharacteristics> findByCharacterId(Integer chid);
}
