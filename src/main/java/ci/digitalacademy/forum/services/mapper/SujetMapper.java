package ci.digitalacademy.forum.services.mapper;

import ci.digitalacademy.forum.models.Sujet;
import ci.digitalacademy.forum.services.dto.SujetDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SujetMapper extends EntityMapper<SujetDTO, Sujet> {
}
