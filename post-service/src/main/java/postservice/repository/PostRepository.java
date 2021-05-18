package postservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import postservice.entity.Post;


@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

    Page<Post> findAllByHashtagIgnoreCaseStartsWithOrderByCreatedAtDesc(String hashtag, Pageable pageable);

    Page<Post> findByCreatedByOrderByCreatedAtDesc(String userName, Pageable pageable);

    Page<Post> findByTopicOrderByCreatedAtDesc(String topic, Pageable pageable);

    Page<Post> findAllByCreatedByOrderByCreatedAtDesc(String createdBy,Pageable pageable);

    Post findByuId(String uId);

    Post findById(String id);

    void deleteByuId(String uid);

}
