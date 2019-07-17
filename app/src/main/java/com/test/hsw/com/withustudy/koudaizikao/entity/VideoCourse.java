package com.withustudy.koudaizikao.entity;

import java.io.Serializable;

public class VideoCourse
  implements Serializable
{
  private int buy_status;
  private int category;
  private int course_hour;
  private String course_id;
  private String course_name;
  private String discount;
  private String handout;
  private String intro;
  private int is_trail;
  private String live_time;
  private float original_price;
  private String pic_url;
  private String play_status;
  private float price;
  private String service_button_text;
  private String service_click_text;
  private String service_copy_text;
  private String service_tips_text;
  private int sold_num;
  private String tag;
  private int video_num;

  public int getBuy_status()
  {
    return this.buy_status;
  }

  public int getCategory()
  {
    return this.category;
  }

  public int getCourse_hour()
  {
    return this.course_hour;
  }

  public String getCourse_id()
  {
    return this.course_id;
  }

  public String getCourse_name()
  {
    return this.course_name;
  }

  public String getDiscount()
  {
    return this.discount;
  }

  public String getHandout()
  {
    return this.handout;
  }

  public String getIntro()
  {
    return this.intro;
  }

  public int getIs_trail()
  {
    return this.is_trail;
  }

  public String getLive_time()
  {
    return this.live_time;
  }

  public float getOriginal_price()
  {
    return this.original_price;
  }

  public String getPic_url()
  {
    return this.pic_url;
  }

  public String getPlay_status()
  {
    return this.play_status;
  }

  public float getPrice()
  {
    return this.price;
  }

  public String getService_button_text()
  {
    return this.service_button_text;
  }

  public String getService_click_text()
  {
    return this.service_click_text;
  }

  public String getService_copy_text()
  {
    return this.service_copy_text;
  }

  public String getService_tips_text()
  {
    return this.service_tips_text;
  }

  public int getSold_num()
  {
    return this.sold_num;
  }

  public String getTag()
  {
    return this.tag;
  }

  public int getVideo_num()
  {
    return this.video_num;
  }

  public void setBuy_status(int paramInt)
  {
    this.buy_status = paramInt;
  }

  public void setCategory(int paramInt)
  {
    this.category = paramInt;
  }

  public void setCourse_hour(int paramInt)
  {
    this.course_hour = paramInt;
  }

  public void setCourse_id(String paramString)
  {
    this.course_id = paramString;
  }

  public void setCourse_name(String paramString)
  {
    this.course_name = paramString;
  }

  public void setDiscount(String paramString)
  {
    this.discount = paramString;
  }

  public void setHandout(String paramString)
  {
    this.handout = paramString;
  }

  public void setIntro(String paramString)
  {
    this.intro = paramString;
  }

  public void setIs_trail(int paramInt)
  {
    this.is_trail = paramInt;
  }

  public void setLive_time(String paramString)
  {
    this.live_time = paramString;
  }

  public void setOriginal_price(float paramFloat)
  {
    this.original_price = paramFloat;
  }

  public void setPic_url(String paramString)
  {
    this.pic_url = paramString;
  }

  public void setPlay_status(String paramString)
  {
    this.play_status = paramString;
  }

  public void setPrice(float paramFloat)
  {
    this.price = paramFloat;
  }

  public void setService_button_text(String paramString)
  {
    this.service_button_text = paramString;
  }

  public void setService_click_text(String paramString)
  {
    this.service_click_text = paramString;
  }

  public void setService_copy_text(String paramString)
  {
    this.service_copy_text = paramString;
  }

  public void setService_tips_text(String paramString)
  {
    this.service_tips_text = paramString;
  }

  public void setSold_num(int paramInt)
  {
    this.sold_num = paramInt;
  }

  public void setTag(String paramString)
  {
    this.tag = paramString;
  }

  public void setVideo_num(int paramInt)
  {
    this.video_num = paramInt;
  }

  public String toString()
  {
    return "VideoCourse [course_id=" + this.course_id + ", course_name=" + this.course_name + ", pic_url=" + this.pic_url + ", tag=" + this.tag + ", intro=" + this.intro + ", price=" + this.price + ", sold_num=" + this.sold_num + ", buy_status=" + this.buy_status + ", category=" + this.category + ", play_status=" + this.play_status + ", live_time=" + this.live_time + ", course_hour=" + this.course_hour + ", video_num=" + this.video_num + ", is_trail=" + this.is_trail + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.entity.VideoCourse
 * JD-Core Version:    0.6.0
 */