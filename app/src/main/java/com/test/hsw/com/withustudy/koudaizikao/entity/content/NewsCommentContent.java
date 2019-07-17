package com.withustudy.koudaizikao.entity.content;

import com.withustudy.koudaizikao.entity.InfoComment;
import java.util.List;

public class NewsCommentContent
{
  private List<InfoComment> comments;

  public List<InfoComment> getComments()
  {
    return this.comments;
  }

  public void setComments(List<InfoComment> paramList)
  {
    this.comments = paramList;
  }

  public String toString()
  {
    return "NewsCommentContent [comments=" + this.comments + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.entity.content.NewsCommentContent
 * JD-Core Version:    0.6.0
 */