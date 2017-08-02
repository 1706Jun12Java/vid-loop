package com.revature.dao;

import com.revature.domain.Comment;
import java.util.*;

public interface CommentDao {

	public Comment addComment(String str, int vId, int uId);
	public List<Comment> getCommentsByVideo(int id);

}
