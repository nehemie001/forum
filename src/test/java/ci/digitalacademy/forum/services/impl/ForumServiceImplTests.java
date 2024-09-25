package ci.digitalacademy.forum.services.impl;

import ci.digitalacademy.forum.models.Forum;
import ci.digitalacademy.forum.repositories.ForumRepository;
import ci.digitalacademy.forum.services.dto.ForumDTO;
import ci.digitalacademy.forum.services.mapper.ForumMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
public class ForumServiceImplTests {

    @Mock
    private ForumRepository forumRepository;

    @Mock
    private ForumMapper forumMapper;

    @InjectMocks
    private ForumServiceImpl forumService;

    private Forum forum;
    private ForumDTO forum1;

    private ForumDTO forumDTO;

    private ForumDTO forumDTO1;

    @BeforeEach
    void setup() {
        forum = new Forum(5L, "Test", "Test Description", "test-slug", Instant.now());
        forum1 = new ForumDTO(5L, "Test", "Test Description", "test-slug", Instant.now());
        forumDTO = new ForumDTO(5L, "test", "test", "test", Instant.now());
        forumDTO1 = new ForumDTO(16L, "test1", "test1", "test1", Instant.now());
    }

    @Test
    public void whenGetForumById_thenReturnForum() {
        when(forumRepository.findById(5L)).thenReturn(Optional.of(forum));
        when(forumMapper.toDto(forum)).thenReturn(forum1);

        Optional<ForumDTO> forumRecovered = forumService.findOne(5L);
        Assertions.assertNotNull(forumRecovered.orElse(null));
    }

    @Test
    public void whenSave_thenReturnForumDTO() {
        when(forumMapper.toDto(forum)).thenReturn(forumDTO1);
        when(forumMapper.toEntity(forumDTO1)).thenReturn(forum);
        when(forumRepository.save(forum)).thenReturn(forum);

        ForumDTO forumDTO2 = forumService.save(forumDTO1);
        Assertions.assertEquals(forumDTO2.getId(), 16L);
    }

}
