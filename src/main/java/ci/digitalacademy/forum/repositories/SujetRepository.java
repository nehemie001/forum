package ci.digitalacademy.forum.repositories;

import ci.digitalacademy.forum.models.Sujet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SujetRepository extends JpaRepository<Sujet, Long> {
    Optional<Sujet> findBySlug(String slug);
}
