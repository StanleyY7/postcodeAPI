package postcode.project.backend.postcodes;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCodeRepository extends JpaRepository<PostCode, Long> {
	Optional<PostCode> findByAreaCode(Long areaCode);

	Optional<PostCode> findBySuburb(String suburb);
}
