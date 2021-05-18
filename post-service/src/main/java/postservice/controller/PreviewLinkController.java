//package postservice.controller;
//
//import com.aibles.model.previewLink.PreviewLinkDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import postservice.service.PostService;
//import postservice.service.PreviewLinkService;
//
//@RestController
//@RequestMapping("/api/v1/preview_links")
//public class PreviewLinkController {
//    @Autowired
//    private PreviewLinkService previewLinkService;
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteById(@PathVariable int id){
//        previewLinkService.deleteById(id);
//
//        return new ResponseEntity<>(HttpStatus.OK.getReasonPhrase(),HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getById(@PathVariable int id){
//        PreviewLinkDTO previewLink = previewLinkService.findById(id);
//        return new ResponseEntity<>(previewLink, HttpStatus.OK);
//    }
//
//
//}
