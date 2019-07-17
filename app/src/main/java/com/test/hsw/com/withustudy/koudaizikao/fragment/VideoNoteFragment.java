package com.withustudy.koudaizikao.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.widget.TextView;
import com.withustudy.koudaizikao.base.AbsBaseFragment;
import com.withustudy.koudaizikao.entity.Video;

public class VideoNoteFragment extends AbsBaseFragment
{
  private WebView a;
  private TextView b;
  private Video c;

  private void d()
  {
    WebSettings localWebSettings = this.a.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setAllowFileAccess(true);
    localWebSettings.setSupportZoom(true);
    localWebSettings.setBuiltInZoomControls(true);
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
    localWebSettings.setLoadWithOverviewMode(true);
    this.a.loadUrl(this.c.getHandout().split(";")[1]);
  }

  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903173, null);
  }

  public void a()
  {
  }

  public void a(View paramView)
  {
    this.a = ((WebView)paramView.findViewById(2131297123));
    this.b = ((TextView)paramView.findViewById(2131297124));
  }

  public void a(Video paramVideo)
  {
    this.c = paramVideo;
    try
    {
      if ((paramVideo.getHandout() != null) && (!paramVideo.getHandout().equals("")))
      {
        this.a.setVisibility(0);
        this.b.setVisibility(8);
        d();
        return;
      }
      this.a.setVisibility(8);
      this.b.setVisibility(0);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void b()
  {
    try
    {
      if ((this.c.getHandout() != null) && (!this.c.getHandout().equals("")))
      {
        this.a.setVisibility(0);
        this.b.setVisibility(8);
        d();
        return;
      }
      this.a.setVisibility(8);
      this.b.setVisibility(0);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void c()
  {
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.VideoNoteFragment
 * JD-Core Version:    0.6.0
 */