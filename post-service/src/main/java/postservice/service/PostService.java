package postservice.service;

import com.aibles.model.post.PostDto;
import com.aibles.model.previewLink.PreviewLinkDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.swing.plaf.basic.BasicListUI;
import java.util.List;

public interface PostService {
    PostDto createPost(String userId,PostDto createdPostDto);

    PostDto updatePost(String userId, PostDto updatedPostDto);

    PostDto deletePost(String uid);

    List<PostDto> findByUserName(String user_name, Pageable pageable);

    List<PostDto> findByHashtag(String hashtag, Pageable pageable);

    List<PostDto> findByTopic(String topic, Pageable pageable);

    List<PostDto> findAllPost(String createdBy,Pageable pageable);

    PostDto findByUid(String uid);

//    void deletePreviewLink(int id);
}
