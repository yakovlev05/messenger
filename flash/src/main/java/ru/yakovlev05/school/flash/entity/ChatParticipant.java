package ru.yakovlev05.school.flash.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "chat_participants")
public class ChatParticipant {

    @EmbeddedId
    private CompositeId id;

    @CreationTimestamp
    private Instant joinedAt;

    @Enumerated(EnumType.STRING)
    private Role role = Role.PARTICIPANT;

    public enum Role {
        ADMIN, PARTICIPANT
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Embeddable
    public static class CompositeId {
        @ManyToOne
        @JoinColumn(name = "chat_id", insertable = false, updatable = false)
        private Chat chat;

        @ManyToOne
        @JoinColumn(name = "user_id", insertable = false, updatable = false)
        private User user;
    }
}
