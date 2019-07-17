package com.withustudy.koudaizikao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.widget.Toast;
import com.google.gson.Gson;
import com.withustudy.koudaizikao.a.a;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.Video;
import com.withustudy.koudaizikao.entity.VideoCourse;
import com.withustudy.koudaizikao.entity.content.VideoCourseContent;
import com.withustudy.koudaizikao.entity.content.VideoListLive;
import com.withustudy.koudaizikao.g.h;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VideoPushLoadingActivity extends AbsBaseActivity
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 10;
  public static final int d = 11;
  private static final String[] k = { "课程购买", "直播列表", "直播播放", "直播回放", "录播播放" };
  private String e;
  private String f;
  private String g;
  private VideoCourse h;
  private List<Video> i;
  private a j;

  private void a()
  {
    String[] arrayOfString = this.e.split(";");
    this.f = arrayOfString[1];
    this.g = arrayOfString[4];
  }

  private void a(VideoListLive paramVideoListLive)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("push", true);
    localBundle.putInt("uid", paramVideoListLive.getGensee_uid());
    localBundle.putInt("scale", paramVideoListLive.getGensee_uid());
    String[] arrayOfString = paramVideoListLive.getAspect_ratio().split(":");
    localBundle.putDouble("scale", Double.valueOf(arrayOfString[0]).doubleValue() / Double.valueOf(arrayOfString[1]).doubleValue());
    localBundle.putSerializable("video", (Serializable)this.i.get(0));
    localBundle.putSerializable("mCourse", this.h);
    startNewActivity(VideoLivePlayActivity.class, true, localBundle);
  }

  private void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("push", true);
    localBundle.putString("class", paramString);
    startNewActivity(VideoSaleDetailActivity.class, true, localBundle);
  }

  private void b(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("push", true);
    localBundle.putString("class", paramString);
    startNewActivity(VideoTapePlayActivity.class, true, localBundle);
  }

  private boolean b()
  {
    if ((this.i == null) || (this.i.size() == 0));
    while (true)
    {
      return false;
      for (int m = 0; m < this.i.size(); m++)
        if (((Video)this.i.get(m)).getPlay_status().equals("直播中"))
          return true;
    }
  }

  private void c()
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("push", true);
    localBundle.putSerializable("class", this.h);
    startNewActivity(VideoBoughtDetailActivity.class, true, localBundle);
  }

  protected void bindData()
  {
    if (this.mSP.i().equals(""))
    {
      a(this.g);
      return;
    }
    this.j.sendEmptyMessage(1);
  }

  protected void initData()
  {
    try
    {
      this.e = getIntent().getExtras().getString("data");
      h.a("课程推送数据", this.e);
      this.i = new ArrayList();
      this.j = new a(this);
      a();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void initListener()
  {
  }

  protected void initView()
  {
    com.withustudy.koudaizikao.g.m.d(this.mContext);
  }

  protected void onDestroy()
  {
    super.onDestroy();
  }

  public void onError(String paramString1, String paramString2, int paramInt)
  {
    super.onError(paramString1, paramString2, paramInt);
    Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
    finish();
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    switch (paramInt)
    {
    default:
    case 10:
    case 11:
    }
    while (true)
    {
      return;
      if (paramString1 != null)
      {
        try
        {
          VideoCourseContent localVideoCourseContent = (VideoCourseContent)c.a().fromJson(paramString1, VideoCourseContent.class);
          if ((localVideoCourseContent == null) || (!localVideoCourseContent.getResult().equals("true")))
            continue;
          this.h = localVideoCourseContent.getCourse();
          if (this.h.getBuy_status() == 0)
          {
            a(this.h.getCourse_id());
            return;
          }
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
          return;
        }
        if (this.h.getCategory() == 0)
        {
          if (!this.f.equals(k[2]))
          {
            c();
            return;
          }
          this.j.sendEmptyMessage(2);
          return;
        }
        b(this.h.getCourse_id());
        return;
      }
      Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
      return;
      if (paramString1 == null)
        break label281;
      try
      {
        VideoListLive localVideoListLive = (VideoListLive)c.a().fromJson(paramString1, VideoListLive.class);
        if ((localVideoListLive == null) || (!localVideoListLive.getResult().equals("true")))
          continue;
        this.i.addAll(localVideoListLive.getLiving_list());
        if (!b())
          break;
        a(localVideoListLive);
        return;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
        return;
      }
    }
    c();
    return;
    label281: Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
  }

  protected void setContentView()
  {
    setContentView(2130903099);
  }

  private static class a extends com.withustudy.koudaizikao.base.m<VideoPushLoadingActivity>
  {
    public a(VideoPushLoadingActivity paramVideoPushLoadingActivity)
    {
      super();
    }

    protected void a(VideoPushLoadingActivity paramVideoPushLoadingActivity, Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
        return;
      case 1:
        a locala2 = c.b().aB();
        String[] arrayOfString2 = new String[2];
        arrayOfString2[0] = VideoPushLoadingActivity.a(paramVideoPushLoadingActivity).i();
        arrayOfString2[1] = VideoPushLoadingActivity.b(paramVideoPushLoadingActivity);
        locala2.a(paramVideoPushLoadingActivity, arrayOfString2, 10, paramVideoPushLoadingActivity);
        return;
      case 2:
      }
      a locala1 = c.b().az();
      String[] arrayOfString1 = new String[3];
      arrayOfString1[0] = VideoPushLoadingActivity.a(paramVideoPushLoadingActivity).i();
      arrayOfString1[1] = VideoPushLoadingActivity.c(paramVideoPushLoadingActivity).getCourse_id();
      arrayOfString1[2] = String.valueOf(VideoPushLoadingActivity.c(paramVideoPushLoadingActivity).getCategory());
      locala1.a(paramVideoPushLoadingActivity, arrayOfString1, 11, paramVideoPushLoadingActivity);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.VideoPushLoadingActivity
 * JD-Core Version:    0.6.0
 */