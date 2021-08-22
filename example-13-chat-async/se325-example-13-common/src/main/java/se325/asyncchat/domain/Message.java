package se325.asyncchat.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import se325.asyncchat.jackson.LocalDateTimeDeserializer;
import se325.asyncchat.jackson.LocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A simple POJO to send as JSON back and forth between client and service
 */
public class Message {

    private String username;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime timestamp;

    private String content;

    public Message() {
    }

    public Message(String username, String content) {
        this(username, LocalDateTime.now(), content);
    }

    public Message(String username, LocalDateTime timestamp, String content) {
        this.username = username;
        this.timestamp = timestamp;
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_TIME;
        return "[" + formatter.format(timestamp) + "] " + username + " says: '" + content + "'";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        return new EqualsBuilder()
                .append(username, message.username)
                .append(timestamp, message.timestamp)
                .append(content, message.content)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(username)
                .append(timestamp)
                .append(content)
                .toHashCode();
    }
}
