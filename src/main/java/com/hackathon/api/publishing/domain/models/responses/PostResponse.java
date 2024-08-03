package com.hackathon.api.publishing.domain.models.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
    private Long id;
    private String text;
    private String mediaUrl;
    private Date createdAt;
    private TagResponse tag;
}
