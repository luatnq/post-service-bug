//package postservice.entity;
//
//import lombok.*;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
//@Entity
//@Table(name = "prevew_link")
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//public class PreviewLink implements Serializable {
//
////    @Id
////    @Column(name = "id")
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private int id;
////
////    @OneToOne( fetch = FetchType.LAZY, orphanRemoval = false)
////    @MapsId
////    @JoinColumn(name = "post_id")
////    private Post post;
//
//    @Id
//    @Column(name = "post_id")
//    private int id;
//
//    @OneToOne()
//    @MapsId
//    @JoinColumn(name = "post_id")
//    private Post post;
//
//    @Column(name = "url")
//    private String url;
//
//    @Column(name = "title")
//    private String title;
//
//    @Column(name = "description")
//    private String description;
//
//    @Column(name = "domain")
//    private String domain;
//
//    @Column(name = "width_image")
//    private String widthImage;
//
//    @Column(name = "height_image")
//    private String heightImage;
//
//    @Column(name = "src_image")
//    private String srcImage;
//}
