package com.comment.model;

import java.util.*;
import com.comment.model.CommentVO;
import java.sql.*;

public interface CommentDAO_interface {
	      public void insert(CommentVO commentVO);
          public void update(CommentVO commentVO);
          public void delete(Integer commentId);
          public CommentVO findByPrimaryKey(Integer commentId);
	      public List<CommentVO> getAll();
	      //�d�߬Y���������~ID
	      public Set<CommentVO> getCommentByCommentProductId(Integer commentProductId);
}
