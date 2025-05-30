package com.PickOne.domain.messaging.model.entity;

import com.PickOne.domain.messaging.model.domain.Message;

import com.PickOne.domain.messaging.model.domain.MessageStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;

/**
 * MongoDB document for storing messages
 */
@Document(collection = "messages")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageDocument {

    @Id
    private String id;

    @Indexed
    private Long senderId;

    @Indexed
    private Long recipientId;

    private String content;

    private String status;

    private LocalDateTime sentAt;

    private LocalDateTime deliveredAt;

    private LocalDateTime readAt;

    /**
     * Convert from domain model to document
     */
    public static MessageDocument fromDomain(Message message) {
        return MessageDocument.builder()
                .id(message.getId())
                .senderId(message.getSenderIdValue())
                .recipientId(message.getRecipientIdValue())
                .content(message.getContentValue())
                .status(message.getStatus().name())
                .sentAt(message.getSentAt())
                .deliveredAt(message.getDeliveredAt())
                .readAt(message.getReadAt())
                .build();
    }

    /**
     * Convert to domain model
     */
    public Message toDomain() {
        return Message.from(
                id,
                senderId,
                recipientId,
                content,
                MessageStatus.valueOf(status),
                sentAt,
                deliveredAt,
                readAt
        );
    }
}
