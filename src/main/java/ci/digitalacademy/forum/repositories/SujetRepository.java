package ci.digitalacademy.forum.repositories;

import ci.digitalacademy.forum.models.Sujet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SujetRepository extends JpaRepository<Sujet, Long> {
    List<Sujet> findByForumId(Long forumId);

}
