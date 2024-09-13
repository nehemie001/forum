package ci.digitalacademy.forum.services.mapper;

import ci.digitalacademy.forum.models.Sujet;
import ci.digitalacademy.forum.services.dto.SujetDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface SujetMapper extends EntityMapper<SujetDTO, Sujet> {

    @Mapping(target = "forum", source = "forum") // Ignore la référence inverse pour éviter la boucle infinie
    SujetDTO toDto(Sujet sujet);

    @Mapping(target = "forum", source = "forum") // Ignore la référence inverse pour éviter la boucle infinie
    Sujet toEntity(SujetDTO sujetDTO);
}
