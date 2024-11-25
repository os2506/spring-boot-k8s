package com.oss.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "articles")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String url;
    private Instant createdAt;
}
