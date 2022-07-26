package com.emlakjet.adapter.post.repo;

import com.emlakjet.adapter.post.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
