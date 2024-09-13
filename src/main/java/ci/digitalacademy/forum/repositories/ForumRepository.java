package ci.digitalacademy.forum.repositories;

import ci.digitalacademy.forum.models.Forum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumRepository extends JpaRepository<Forum, Long> {

}
