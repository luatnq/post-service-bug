package postservice.mapper;

import com.aibles.model.post.PostDto;
import postservice.entity.Post;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class PostMapper {
  private  static ModelMapper modelMapper = new ModelMapper();

    public static PostDto convertToDTO(Post post){
        return modelMapper.map(post, PostDto.class);
    }

    public static Post convertToEntity(PostDto postDto){
        return modelMapper.map(postDto, Post.class);
    }

    public static List<PostDto> convertToListDTOs(List<Post> posts){
        return posts.stream().map(PostMapper::convertToDTO).collect(Collectors.toList());
    }

}
