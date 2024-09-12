package ci.digitalacademy.forum.repositories;

import ci.digitalacademy.forum.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long>  {
}
