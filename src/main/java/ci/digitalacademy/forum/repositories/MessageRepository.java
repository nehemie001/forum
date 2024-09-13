package ci.digitalacademy.forum.repositories;

import ci.digitalacademy.forum.models.Message;
import ci.digitalacademy.forum.models.Sujet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


public interface MessageRepository extends JpaRepository<Message, Long>  {
    Optional<Message> findBySlug(String slug);

    List<Message> findMessageById(Long id);
}
