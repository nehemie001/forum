package ci.digitalacademy.forum.services.mapper;

import ci.digitalacademy.forum.models.Forum;
import ci.digitalacademy.forum.services.dto.ForumDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface ForumMapper extends EntityMapper<ForumDTO, Forum> {
}
