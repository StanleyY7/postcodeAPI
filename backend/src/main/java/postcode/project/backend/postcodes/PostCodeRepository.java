package postcode.project.backend.postcodes;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCodeRepository extends JpaRepository<PostCode, Long> {
	List<PostCode> findByAreaCode(Long areaCode);

	Optional<PostCode> findBySuburb(String suburb);

	Optional<PostCode> findByAreaCodeAndSuburb(Long areaCode, String suburb);
}
