package mr.esp.suivi.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import mr.esp.suivi.model.ImageModel;
public interface ImageRepository extends JpaRepository<ImageModel, Long> {
	Optional<ImageModel> findByName(String name);
}