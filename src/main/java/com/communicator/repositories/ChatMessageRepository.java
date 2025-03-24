package com.communicator.repositories;

import com.communicator.entity.chat.ChatMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {

//    @Query("")
//    Page<ChatMessage> findByMessageId(String messageId, Pageable pageable);



    /**
     * Method to get 10 last messages.
     * @param messageId id of message
     * @return all results that match the query
     */
    @Query("{ 'chatMessage.messageId': ?0}")
    List<ChatMessage> findTop10ByMessageId(String messageId);

    /**
     * Method to get chat messages send before.
     * @param chatId id of chat
     * @param messageId id of last message
     * @param pageable the pagination information
     * @return all results that match the query
     */
    @Query(value = "{ 'chatId': ?0, 'messageId': { $lt: ?1 } }", sort = "{ 'timestamp': 1 }")
    List<ChatMessage> findMessagesBefore(String chatId, String messageId, Pageable pageable);


//    /**
//     * Retrieves a paginated list of chat messages that match the given message ID.
//     * If the message ID is null or empty, it returns all messages paginated.
//     *
//     * @param messageId the message ID used to filter chat messages
//     * @param page the zero-based page index to retrieve
//     * @param size the number of items to include in a single page
//     * @return a {@link Page} containing the filtered chat messages
//     */
//    public Page<ChatMessage> findByMessageId(final String messageId, final Pageable page, final int size) {
//        Pageable pageable = PageRequest.of(page, size);
//
//
//        if (messageId == null || messageId.isEmpty()) {
//            // If no messageId is provided, return all messages
//            return chatMessageRepository.findAll(pageable);
//        }
//
//        // Query for messages with the provided messageId
//        Page<ChatMessage> chatMessagesPage = chatMessageRepository.findByMessageId(messageId, pageable);
//        return new PageImpl<>(chatMessagesPage.getContent(), pageable, chatMessagesPage.getTotalElements());
//    }

    /**
     * Method to found by messageId.
     * @param query query
     * @param pageable the pagination information
     * @return null
     */
    Page<ChatMessage> findByMessageId(String query, Pageable pageable);
}


