package com.jejw.admin.springboot.web.dto;

import com.jejw.admin.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

        @Getter
        @NoArgsConstructor

        public class PostsSaveRequestsDto {
            private String title;
            private String content;
            private String author;

            @Builder
            public PostsSaveRequestsDto(String title, String content, String author) {
                this.title = title;
                this.content = content;
                this.author = author;
            }

            public Posts toEntity() {
                return Posts.builder().title(title).content(content).author(author).build();

            }
}
