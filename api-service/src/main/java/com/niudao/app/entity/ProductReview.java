package com.niudao.app.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * (ProductReview)表实体类
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-15 22:49:38
 */
@SuppressWarnings("serial")
public class ProductReview extends Model<ProductReview> {
    //唯一ID
    private Integer id;
    //创建时间
    private Date createTime;
    //评论内容
    private String reviewContent;
    //用户ID
    private Integer userId;
    //等级【1~5等级】
    private Integer reviewStars;
    //用户晒图ID
    private Integer reviewImgId;
    //用户晒短视频ID
    private Integer reviewVidoeId;
    //来源（1移动端、PC端【预留】）
    private String reviewFrom;
    //父节点ID【追评使用】
    private Integer reviewPerentId;
    //点赞数量
    private Integer reviewLikes;
    //客服回复（后台回复）
    private String reviewReply;
    //客服回复时间
    private Date reviewReplyTime;
    //状态
    private Integer reviewState;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getReviewStars() {
        return reviewStars;
    }

    public void setReviewStars(Integer reviewStars) {
        this.reviewStars = reviewStars;
    }

    public Integer getReviewImgId() {
        return reviewImgId;
    }

    public void setReviewImgId(Integer reviewImgId) {
        this.reviewImgId = reviewImgId;
    }

    public Integer getReviewVidoeId() {
        return reviewVidoeId;
    }

    public void setReviewVidoeId(Integer reviewVidoeId) {
        this.reviewVidoeId = reviewVidoeId;
    }

    public String getReviewFrom() {
        return reviewFrom;
    }

    public void setReviewFrom(String reviewFrom) {
        this.reviewFrom = reviewFrom;
    }

    public Integer getReviewPerentId() {
        return reviewPerentId;
    }

    public void setReviewPerentId(Integer reviewPerentId) {
        this.reviewPerentId = reviewPerentId;
    }

    public Integer getReviewLikes() {
        return reviewLikes;
    }

    public void setReviewLikes(Integer reviewLikes) {
        this.reviewLikes = reviewLikes;
    }

    public String getReviewReply() {
        return reviewReply;
    }

    public void setReviewReply(String reviewReply) {
        this.reviewReply = reviewReply;
    }

    public Date getReviewReplyTime() {
        return reviewReplyTime;
    }

    public void setReviewReplyTime(Date reviewReplyTime) {
        this.reviewReplyTime = reviewReplyTime;
    }

    public Integer getReviewState() {
        return reviewState;
    }

    public void setReviewState(Integer reviewState) {
        this.reviewState = reviewState;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
    }