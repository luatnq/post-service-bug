package postservice.controller;

import com.aibles.model.post.PostDto;
import org.springframework.data.domain.Pageable;

import org.springframework.http.HttpHeaders;
import org.springframework.web.context.request.WebRequest;
import postservice.entity.ApiError;
import postservice.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("api/v1/")
public class PostController {

    private Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostService postService;

    @PostMapping(value = "posts", produces = "application/json")
    public ResponseEntity<?> createPost(@RequestHeader("X-Coxude-UserUid") String userId,
                                        @Valid @RequestBody PostDto postDto){
        logger.info("created new post : {}", postDto);

        try{
            PostDto createdPostDto =  postService.createPost(userId,postDto);
            logger.info("create successfully");

            return new ResponseEntity<>(createdPostDto, HttpStatus.OK);
        }catch (NullPointerException e){
            logger.error("error : {}", e);
            return new ResponseEntity<>(HttpStatus.SEE_OTHER.getReasonPhrase(), HttpStatus.SEE_OTHER);
        }
    }

    @PutMapping(value = "posts", produces = "application/json")
    public ResponseEntity<?> updatePost(@RequestHeader("X-Coxude-UserUid") String userId,
                                        @Valid @RequestBody PostDto postDto){
        logger.info("update post = {}", postDto);

        PostDto updatedPostDto = postService.updatePost(userId,postDto);

        if (updatedPostDto != null){
            logger.info("update successfully");
            return new ResponseEntity<>(updatedPostDto, HttpStatus.OK);
        }
        else{
            logger.error("update error");
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE.getReasonPhrase(),HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping(value = "/posts/{uid}", produces = "application/json")
    public ResponseEntity<?> delete(@PathVariable String uid){
        logger.info("delete post with id = {}",uid);

        PostDto deletedPostDto = postService.deletePost(uid);

        if(deletedPostDto != null){
            logger.info("delete successfully");
            return new ResponseEntity<>(deletedPostDto,HttpStatus.OK);
        }
        else {
            logger.error("delete failed");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/posts", produces = "application/json")
    public ResponseEntity<?> findAll(@RequestHeader("X-Coxude-UserUid") String createdBy,Pageable pageable){
        logger.info("get all post" );
        logger.info("{}", createdBy);
        List<PostDto> listPostDto = postService.findAllPost(createdBy,pageable);

        if(listPostDto.size() != 0){
            logger.info("get all post successfully");
            return new ResponseEntity<>(listPostDto, HttpStatus.OK);
        }

        else {
            logger.error("get post by hashtag failed");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/topic/{topic}", produces = "application/json")
    public ResponseEntity<?> findByTopic(@PathVariable ("topic") String topic, Pageable pageable){
        logger.info("get post by topic : {}", topic);

        List<PostDto> listPostDto = postService.findByTopic(topic, pageable);

        if(listPostDto.size() != 0){
            logger.info("get post by topic successfully");
            return new ResponseEntity<>(listPostDto, HttpStatus.OK);
        }

        else {
            logger.error("get post by topic failed");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/hashtag/{hashtag}", produces = "application/json")
    public ResponseEntity<?> findByHashtag(@PathVariable ("hashtag") String hashtag, Pageable pageable){
        logger.info("get post by hashtag : {}", hashtag);

        List<PostDto> listPostDto = postService.findByHashtag(hashtag, pageable);

        if(listPostDto.size() != 0){
            logger.info("get post by hashtag successfully");
            return new ResponseEntity<>(listPostDto, HttpStatus.OK);
        }

        else {
            logger.error("get post by hashtag failed");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{username}/posts", produces = "application/json")
    public ResponseEntity<?> findByUsername(@PathVariable ("username") String username,
                                            Pageable pageable){
        logger.info("get post by username : {}", username);

        List<PostDto> listPostDto = postService.findByUserName(username, pageable);

        if(listPostDto.size() != 0){
            logger.info("get post by username successfully");
            return new ResponseEntity<>(listPostDto, HttpStatus.OK);
        }

        else {
            logger.error("get post by username failed");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND);
        }
    }



    @GetMapping(value = "/posts/{uid}", produces = "application/json")
    public ResponseEntity<?> findById(@PathVariable String uid){
        logger.info("get post by uid : {}",uid);

        PostDto postDto = postService.findByUid(uid);

        if(postDto != null){
            logger.info("get post by id successfully");
            return new ResponseEntity<>(postDto, HttpStatus.OK);
        }

        else {
            logger.error("get post by id failed");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND);
        }
    }
//    @DeleteMapping(value = "/posts/{id}", produces = "application/json")
//    public ResponseEntity<?> deletePreviewLinkById(@PathVariable int id){
//        postService.deletePreviewLink(id);
//        return new ResponseEntity<>(HttpStatus.OK.getReasonPhrase(),HttpStatus.OK);
//    }

    @ExceptionHandler({ ConstraintViolationException.class })
    public ResponseEntity<Object> handleConstraintViolation(
            ConstraintViolationException ex, WebRequest request) {
        List<String> errors = new ArrayList<>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            errors.add(violation.getRootBeanClass().getName() + " " +
                    violation.getPropertyPath() + ": " + violation.getMessage());
        }

        ApiError apiError =
                new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
        return new ResponseEntity<Object>(
                apiError, new HttpHeaders(), apiError.getStatus());
    }


}
