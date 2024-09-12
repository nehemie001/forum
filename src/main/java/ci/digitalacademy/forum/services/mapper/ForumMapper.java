package ci.digitalacademy.forum.services.mapper;

import ci.digitalacademy.forum.models.Forum;
import ci.digitalacademy.forum.services.dto.ForumDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ForumMapper extends EntityMapper<ForumDTO, Forum> {
}
