package ru.yakovlev05.school.flash.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.yakovlev05.school.flash.entity.Chat;

import java.util.List;
import java.util.Optional;

public interface ChatRepository extends JpaRepository<Chat, Long> {
    @Query("""
            SELECT c FROM Chat c
            JOIN ChatParticipant cp1 ON cp1.id.chat.id = c.id
            JOIN ChatParticipant cp2 ON cp2.id.user.id = cp1.id.user.id
            WHERE c.type = 'PRIVATE'
                AND cp2.id.user.id IN (:firstUserId, :secondUserId)
                AND cp1.id.user.id IN (:firstUserId, :secondUserId)
            """)
    List<Chat> findPrivateChatByParticipantsId(Long firstUserId, Long secondUserId);

    @Query("""
            SELECT c FROM Chat c
            JOIN ChatParticipant cp ON cp.id.chat = c
            WHERE cp.id.user.id = :userId
            """)
    List<Chat> findAllByUserId(Long userId, Pageable pageable);

    @Query("""
            SELECT c FROM Chat c
            JOIN ChatParticipant cp ON cp.id.chat = c
            WHERE cp.id.user.id = :userId
                AND c.id = :chatId
            """)
    Optional<Chat> findByChatIdAndUserId(Long chatId, Long userId);
}
