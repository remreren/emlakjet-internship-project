package com.emlakjet.adapter.post.repo;

import com.emlakjet.adapter.post.entity.PostEntity;
import com.emlakjet.approval.enums.ApprovalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

    @Query("update post set post.approvalStatus = :approvalStatus where post.postId = :postId")
    Optional<PostEntity> updateApprovalStatus(Long postId, ApprovalStatus approvalStatus);
}
