package com.example.demo.Entity;

import lombok.*;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.UUID;

@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Document(collection = "images")
public class Images {

    public static final Images NO_IMAGE = Images.builder().id("-NO-IMAGE-").build();

    @Id
    @Builder.Default
    private final String id = UUID.randomUUID().toString();

    @Builder.Default
    private final Binary publicationData = new Binary(new byte[0]);
}
