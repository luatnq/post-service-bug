//package postservice.service.impl;
//
//import com.aibles.model.previewLink.PreviewLinkDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import postservice.entity.Post;
//import postservice.mapper.PreviewLinkMapper;
//import postservice.repository.PostRepository;
//import postservice.repository.PreviewLinkRepository;
//import postservice.service.PreviewLinkService;
//
//
//@Service
//public class PreviewLinkServiceImpl implements PreviewLinkService {
//    @Autowired
//    private PreviewLinkRepository previewLinkRepository;
//
//    @Autowired
//    private PostRepository postRepository;
//
//    public void deleteById(int id){
//        previewLinkRepository.deleteById(id);
//    }
//
//    public PreviewLinkDTO findById(int id){
//        return PreviewLinkMapper.convertToDTO(previewLinkRepository.getOne(id));
//    }
//}
