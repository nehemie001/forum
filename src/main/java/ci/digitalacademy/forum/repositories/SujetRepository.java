package ci.digitalacademy.forum.repositories;

import ci.digitalacademy.forum.models.Sujet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SujetRepository extends JpaRepository<Sujet, Long> {
}
