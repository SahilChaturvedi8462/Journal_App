package net.BabaJI.journalApp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "journal_entries")//maps this entity to mongodb collection
@Data//this is from lambok project used to create getters setters on compile time.
@NoArgsConstructor
public class JournalEntry {
    @Id//primary key in collection
    private ObjectId id;

    @NonNull
    private String title;

    private LocalDateTime date;

    private String content;
}
