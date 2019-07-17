package com.withustudy.koudaizikao.entity;

import java.io.Serializable;
import java.util.List;

public class Post
  implements Serializable
{
  private int forum_id;
  private String forum_name;
  private long last_modify_time;
  private int new_reply_num;
  private String post_area;
  private List<String> post_files;
  private int post_img_count;
  private int topic_id;
  private int topic_isfollow;
  private int topic_ispraise;
  private int topic_level;
  private int topic_praise;
  private int topic_replies;
  private String topic_sub_desc;
  private long topic_time;
  private String topic_title;
  private int topic_type;
  private int topic_views;
  private String user_headimg;
  private String user_name;
  private String userid;

  public int getForum_id()
  {
    return this.forum_id;
  }

  public String getForum_name()
  {
    return this.forum_name;
  }

  public long getLast_modify_time()
  {
    return this.last_modify_time;
  }

  public int getNew_reply_num()
  {
    return this.new_reply_num;
  }

  public String getPost_area()
  {
    return this.post_area;
  }

  public List<String> getPost_files()
  {
    return this.post_files;
  }

  public int getPost_img_count()
  {
    return this.post_img_count;
  }

  public int getTopic_id()
  {
    return this.topic_id;
  }

  public int getTopic_isfollow()
  {
    return this.topic_isfollow;
  }

  public int getTopic_ispraise()
  {
    return this.topic_ispraise;
  }

  public int getTopic_level()
  {
    return this.topic_level;
  }

  public int getTopic_praise()
  {
    return this.topic_praise;
  }

  public int getTopic_replies()
  {
    return this.topic_replies;
  }

  public String getTopic_sub_desc()
  {
    return this.topic_sub_desc;
  }

  public long getTopic_time()
  {
    return this.topic_time;
  }

  public String getTopic_title()
  {
    return this.topic_title;
  }

  public int getTopic_type()
  {
    return this.topic_type;
  }

  public int getTopic_views()
  {
    return this.topic_views;
  }

  public String getUser_headimg()
  {
    return this.user_headimg;
  }

  public String getUser_name()
  {
    return this.user_name;
  }

  public String getUserid()
  {
    return this.userid;
  }

  public void setForum_id(int paramInt)
  {
    this.forum_id = paramInt;
  }

  public void setForum_name(String paramString)
  {
    this.forum_name = paramString;
  }

  public void setLast_modify_time(long paramLong)
  {
    this.last_modify_time = paramLong;
  }

  public void setNew_reply_num(int paramInt)
  {
    this.new_reply_num = paramInt;
  }

  public void setPost_area(String paramString)
  {
    this.post_area = paramString;
  }

  public void setPost_files(List<String> paramList)
  {
    this.post_files = paramList;
  }

  public void setPost_img_count(int paramInt)
  {
    this.post_img_count = paramInt;
  }

  public void setTopic_id(int paramInt)
  {
    this.topic_id = paramInt;
  }

  public void setTopic_isfollow(int paramInt)
  {
    this.topic_isfollow = paramInt;
  }

  public void setTopic_ispraise(int paramInt)
  {
    this.topic_ispraise = paramInt;
  }

  public void setTopic_level(int paramInt)
  {
    this.topic_level = paramInt;
  }

  public void setTopic_praise(int paramInt)
  {
    this.topic_praise = paramInt;
  }

  public void setTopic_replies(int paramInt)
  {
    this.topic_replies = paramInt;
  }

  public void setTopic_sub_desc(String paramString)
  {
    this.topic_sub_desc = paramString;
  }

  public void setTopic_time(long paramLong)
  {
    this.topic_time = paramLong;
  }

  public void setTopic_title(String paramString)
  {
    this.topic_title = paramString;
  }

  public void setTopic_type(int paramInt)
  {
    this.topic_type = paramInt;
  }

  public void setTopic_views(int paramInt)
  {
    this.topic_views = paramInt;
  }

  public void setUser_headimg(String paramString)
  {
    this.user_headimg = paramString;
  }

  public void setUser_name(String paramString)
  {
    this.user_name = paramString;
  }

  public void setUserid(String paramString)
  {
    this.userid = paramString;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.entity.Post
 * JD-Core Version:    0.6.0
 */