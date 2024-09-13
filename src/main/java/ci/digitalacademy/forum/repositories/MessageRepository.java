package ci.digitalacademy.forum.repositories;

import ci.digitalacademy.forum.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long>  {
    List<Message> getMessagesBySujetId(Long sujetId);

    Collection<Object> findAllBySujetId(Long sujetId);
}
