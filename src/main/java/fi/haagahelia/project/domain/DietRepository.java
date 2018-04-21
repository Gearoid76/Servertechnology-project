package fi.haagahelia.project.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DietRepository extends CrudRepository <Diet, Long> {
	List<Diet> findByDname (String dname);

}
