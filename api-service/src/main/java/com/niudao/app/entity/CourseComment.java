package com.niudao.app.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * (CourseComment)表实体类
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-28 18:43:04
 */
@SuppressWarnings("serial")
public class CourseComment extends Model<CourseComment> {

    @TableId(type = IdType.UUID)
    private String commentId;
    
    private String commentText;
    
    private Date commentTime;
    
    private String commentIdRef;
    
    private String courseId;
    
    private String userId;


    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public String getCommentIdRef() {
        return commentIdRef;
    }

    public void setCommentIdRef(String commentIdRef) {
        this.commentIdRef = commentIdRef;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}