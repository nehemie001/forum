package ci.digitalacademy.forum.services.mapper;

import ci.digitalacademy.forum.models.Message;
import ci.digitalacademy.forum.services.dto.MessageDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper extends EntityMapper<MessageDTO, Message> {

}
