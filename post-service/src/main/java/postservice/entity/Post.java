package postservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "post")
@AllArgsConstructor
@Builder
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Data
@EntityListeners(AuditingEntityListener.class)
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "uid")
    private String uId;

    @Column(name = "caption")
    @NotNull(message = "caption is not null")
    private String caption;

    @Column(name = "hashtag")
    @NotNull(message = "hashtag is not null")
    private String hashtag;

    @Column(name = "topic")
    @NotNull(message = "topic is not null")
    private String topic;

    @Column(name = "share_count")
    @PositiveOrZero(message = "share count must >= 0")
    private int shareCount;

    @Column(name = "comment_count")
    @PositiveOrZero(message = "comment count must >= 0")
    @NotNull(message = "comment count is not null")
    private int commentCount;

    @Column(name = "view_count")
    @NotNull(message = "view count is not null")
    @PositiveOrZero(message = "view count must >= 0")
    private int viewCount;

    @Column(name = "react_count")
    @PositiveOrZero(message = "react count must >= 0")
    private int reactCount;

    @Column(name = "feeling")
    @NotNull(message = "fealing is not null")
    private String feeling;

    @Column(name = "share_caption")
    @NotNull(message = "share Count is not null")
    private String shareCaption;

    @Column(name = "hyperlink")
    @NotNull(message = "hyperlink is not null")
    private String hyperLink;

    @CreatedBy
    @Column(name = "created_by", nullable = false, length = 50, updatable = false)
    @JsonIgnore
    private String createdBy;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    @JsonIgnore
    private Instant createdAt = Instant.now();

    @LastModifiedBy
    @Column(name = "updated_by", length = 50)
    @JsonIgnore
    private String updatedBy;

    @LastModifiedDate
    @Column(name = "updated_at")
    @JsonIgnore
    private Instant updatedAt = Instant.now();

    @Column(name = "contain_images")
    private Boolean containImages;

    @Column(name = "url_preview")
    private String urlPreview;

    @Column(name = "title_preview")
    private String titlePreview;

    @Column(name = "description_preview")
    private String descriptionPreview;

    @Column(name = "domain_preview")
    private String domainPreview;

    @Column(name = "width_image_preview")
    private String widthImagePreview;

    @Column(name = "height_image_preview")
    private String heightImagePreview;

    @Column(name = "src_image_preview")
    private String srcImagePreview;
//    @OneToOne
//    @JoinColumn(name = "preview_link_id", nullable = false)
////    @PrimaryKeyJoinColumn
//    @OneToOne(mappedBy = "post", orphanRemoval = true)
//    private PreviewLink previewLink;


    public Boolean getContainImages() {
        return containImages;
    }

    public void setContainImages(Boolean containImages) {
        this.containImages = containImages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public int getShareCount() {
        return shareCount;
    }

    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getReactCount() {
        return reactCount;
    }

    public void setReactCount(int reactCount) {
        this.reactCount = reactCount;
    }

    public String getShareCaption() {
        return shareCaption;
    }

    public void setShareCaption(String shareCaption) {
        this.shareCaption = shareCaption;
    }

    public String getFeeling() {
        return feeling;
    }

    public void setFeeling(String feeling) {
        this.feeling = feeling;
    }

    public String getHyperLink() {
        return hyperLink;
    }

    public void setHyperLink(String hyperLink) {
        this.hyperLink = hyperLink;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
