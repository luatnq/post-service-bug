package postservice.service.impl;

import com.aibles.model.post.PostDto;
import com.aibles.model.previewLink.PreviewLinkDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Pageable;
import postservice.entity.Post;
//import postservice.entity.PreviewLink;
//import postservice.mapper.PreviewLinkMapper;
import postservice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import postservice.repository.PreviewLinkRepository;
import postservice.service.PostService;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class PostServiceImp implements PostService {
    private Logger logger = LoggerFactory.getLogger(PostServiceImp.class);
    @Autowired
    private PostRepository postRepository;

//    @Autowired
//    private PreviewLinkRepository previewLinkRepository;

    @Override
    @Caching(
            evict = {@CacheEvict(value = "postsOfTopic", allEntries = true),
                    @CacheEvict(value = "postsOfHashtag", allEntries = true)
                    , @CacheEvict(value = "postsOfUserName", allEntries = true),
                    @CacheEvict(value = "postAll", allEntries = true)
            },
            put = {@CachePut(value = "postOfUid", key = "#result.uId")}
    )
    public PostDto createPost(String userId, PostDto createdPostDto) {
        Post createdPost = new Post();
        String uId = generateId();
//        PreviewLink previewLink = new PreviewLink();

//        previewLinkRepository.save(previewLink);
        createdPost = Post.builder()
                .caption(createdPostDto.getCaption())
                .hashtag(createdPostDto.getHashtag())
                .shareCount(createdPostDto.getShareCount())
                .commentCount(createdPostDto.getCommentCount())
                .viewCount(createdPostDto.getViewCount())
                .reactCount(createdPostDto.getReactCount())
                .feeling(createdPostDto.getFeeling())
                .shareCaption(createdPostDto.getShareCaption())
                .hyperLink(createdPostDto.getHyperLink())
                .topic(createdPostDto.getTopic())
//                .previewLink(null)
                .uId(uId)
                .createdBy(userId)
                .updatedBy("")
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .containImages(createdPostDto.getContainImages())
                .build();
//        if (Objects.nonNull(createdPost.getPreviewLink())) {
//            PreviewLink previewLink = PreviewLinkMapper.convertToEntity(createdPostDto.getPreviewLinkDTO());
//            createdPost.setPreviewLink(previewLink);
//            previewLink.setPost(createdPost);
//            previewLinkRepository.save(previewLink);
//        }
//
//        createdPost.setPreviewLink(null);
        postRepository.save(createdPost);
//        logger.info(createdPost.getPreviewLink().getDomain());
//        postRepository.save(createdPost);


        return convertToDto(createdPost);
//        return PostMapper.convertToDTO(createdPost);

    }

    private String generateId() {
        String uuid = UUID.randomUUID().toString();

        return uuid;
    }

    @Override
    @Caching(
            evict = {@CacheEvict(value = "postsOfTopic", allEntries = true),
                    @CacheEvict(value = "postsOfHashtag", allEntries = true)
                    , @CacheEvict(value = "postsOfUserName", allEntries = true),
                    @CacheEvict(value = "postAll", allEntries = true)
            },
            put = {@CachePut(value = "postOfUid", key = "#result.uId")}
    )
    public PostDto updatePost(String userId, PostDto updatedPostDto) {
        Post updatedPost = new Post();
        Post isUpdatedPost = null;
        isUpdatedPost = postRepository.findByuId(updatedPostDto.getUId());

        logger.info("post are queried : {}", updatedPost);
        if (isUpdatedPost != null) {
            updatedPost.setId(isUpdatedPost.getId());
            updatedPost.setuId(isUpdatedPost.getuId());
            updatedPost.setCaption(updatedPostDto.getCaption());
            updatedPost.setCommentCount(updatedPostDto.getCommentCount());
            updatedPost.setFeeling(updatedPostDto.getFeeling());
            updatedPost.setHashtag(updatedPostDto.getHashtag());
            updatedPost.setHyperLink(updatedPostDto.getHyperLink());
            updatedPost.setUpdatedBy(userId);
            updatedPost.setCreatedAt(isUpdatedPost.getCreatedAt());
//            updatedPost.setCreatedBy(isUpdatedPost.getUpdatedBy());
            updatedPost.setReactCount(updatedPostDto.getReactCount());
            updatedPost.setShareCount(updatedPostDto.getShareCount());
            updatedPost.setShareCaption(updatedPostDto.getShareCaption());
            updatedPost.setViewCount(updatedPostDto.getViewCount());
            updatedPost.setTopic(updatedPostDto.getTopic());
            updatedPost.setUpdatedAt(Instant.now());
            updatedPost.setContainImages(updatedPostDto.getContainImages());
//            updatedPostDto.setCreatedBy(isUpdatedPost.getCreatedBy());
//            updatedPostDto.setUpdatedBy(updatedPost.getUpdatedBy());

            return convertToDto(postRepository.saveAndFlush(updatedPost));
        }

        return null;
    }

    @Override
    @Caching(
            evict = {@CacheEvict(value = "postsOfTopic", allEntries = true),
                    @CacheEvict(value = "postsOfHashtag", allEntries = true),
                    @CacheEvict(value = "postsOfUserName", allEntries = true),
                    @CacheEvict(value = "postOfUid", key = ""),
                    @CacheEvict(value = "postAll", allEntries = true)
            }
    )
    public PostDto deletePost(String uid) {
        Post deletedPost = null;
        deletedPost = postRepository.findByuId(uid);

        if (deletedPost != null) {
            postRepository.deleteByuId(uid);
            return convertToDto(deletedPost);
        }

        return null;
    }

    @Override
    @Cacheable(value = "postsOfUserName", key = "#user_name + #pageable.pageNumber")
    public List<PostDto> findByUserName(String user_name, Pageable pageable) {

        List<Post> listPostOfUserName = postRepository.findByCreatedByOrderByCreatedAtDesc(user_name, pageable).getContent();

        return convertToDtoList(listPostOfUserName);

    }

    @Override
    @Cacheable(value = "postsOfHashtag", key = "#hashtag + #pageable.pageNumber")
    public List<PostDto> findByHashtag(String hashtag, Pageable pageable) {

        List<Post> listPostWithHashtag = postRepository.findAllByHashtagIgnoreCaseStartsWithOrderByCreatedAtDesc(hashtag, pageable).getContent();

        return convertToDtoList(listPostWithHashtag);
    }

    @Override
    @Cacheable(value = "postsOfTopic", key = "#topic + #pageable.pageNumber")
    public List<PostDto> findByTopic(String topic, Pageable pageable) {

        List<Post> listPostWithTopic = postRepository.findByTopicOrderByCreatedAtDesc(topic, pageable).getContent();

        return convertToDtoList(listPostWithTopic);
    }

    @Override
    @Cacheable(value = "postAll", key = "#createdBy + #pageable.pageNumber")
    public List<PostDto> findAllPost(String createdBy, Pageable pageable) {
        List<Post> postList = postRepository.findAllByCreatedByOrderByCreatedAtDesc(createdBy, pageable).getContent();
        return convertToDtoList(postList);
    }

    @Override
//    @Cacheable(value = "postOfUid", key = "#uid")
    public PostDto findByUid(String uid) {
        Post postFindedById = null;
        postFindedById = postRepository.findByuId(uid);

        if (postFindedById != null) {
            return convertToDto(postFindedById);
        }
        return null;
    }

//    @Override
//    public void deletePreviewLink(int id) {
////        previewLinkRepository.deleteById(id);
//    }

    private PostDto convertToDto(Post post) {
        PostDto postDto = new PostDto();
        if (post != null) {
            postDto.setUId(post.getuId());
            postDto.setId(post.getId());
            postDto.setCaption(post.getCaption());
            postDto.setCommentCount(post.getCommentCount());
            postDto.setCreatedAt(post.getCreatedAt());
//            postDto.setCreatedBy(post.getCreatedBy());
            postDto.setFeeling(post.getFeeling());
            postDto.setHashtag(post.getHashtag());
            postDto.setHyperLink(post.getHyperLink());
            postDto.setUpdatedAt(post.getUpdatedAt());
//            postDto.setUpdatedBy(post.getUpdatedBy());
            postDto.setReactCount(post.getReactCount());
            postDto.setShareCaption(post.getShareCaption());
            postDto.setShareCount(post.getShareCount());
            postDto.setViewCount(post.getViewCount());
            postDto.setTopic(post.getTopic());
            postDto.setContainImages(post.getContainImages());
//            PreviewLink previewLink = post.getPreviewLink();
//            if(Objects.nonNull(previewLink)){
//                PreviewLinkDTO previewLinkDTO = PreviewLinkMapper.convertToDTO(post.getPreviewLink());
//                postDto.setPreviewLinkDTO(previewLinkDTO);
//            }

            return postDto;
        }

        return null;
    }

    private List<PostDto> convertToDtoList(List<Post> postList) {
        if (postList != null) {
            return postList.stream().map(this::convertToDto).collect(Collectors.toList());
        }
        return null;
    }
}
