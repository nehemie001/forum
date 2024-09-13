package ci.digitalacademy.forum.repositories;

import ci.digitalacademy.forum.models.Forum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ForumRepository extends JpaRepository<Forum, Long> {
    Optional<Forum> findBySlug(String slug);
}
