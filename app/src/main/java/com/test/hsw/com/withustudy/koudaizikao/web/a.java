package com.withustudy.koudaizikao.web;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebSettings;
import android.widget.FrameLayout;
import android.widget.VideoView;

public class a extends WebChromeClient
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener
{
  private View a;
  private ViewGroup b;
  private View c;
  private VideoEnabledWebView d;
  private boolean e;
  private FrameLayout f;
  private WebChromeClient.CustomViewCallback g;
  private a h;

  public a()
  {
  }

  public a(View paramView, ViewGroup paramViewGroup)
  {
    this.a = paramView;
    this.b = paramViewGroup;
    this.c = null;
    this.d = null;
    this.e = false;
  }

  public a(View paramView1, ViewGroup paramViewGroup, View paramView2)
  {
    this.a = paramView1;
    this.b = paramViewGroup;
    this.c = paramView2;
    this.d = null;
    this.e = false;
  }

  public a(View paramView1, ViewGroup paramViewGroup, View paramView2, VideoEnabledWebView paramVideoEnabledWebView)
  {
    this.a = paramView1;
    this.b = paramViewGroup;
    this.c = paramView2;
    this.d = paramVideoEnabledWebView;
    this.e = false;
  }

  public void a(a parama)
  {
    this.h = parama;
  }

  public boolean a()
  {
    return this.e;
  }

  public boolean b()
  {
    if (this.e)
    {
      onHideCustomView();
      return true;
    }
    return false;
  }

  public View getVideoLoadingProgressView()
  {
    if (this.c != null)
    {
      this.c.setVisibility(0);
      return this.c;
    }
    return super.getVideoLoadingProgressView();
  }

  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    onHideCustomView();
  }

  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    return false;
  }

  public void onHideCustomView()
  {
    if (this.e)
    {
      this.b.setVisibility(4);
      this.b.removeView(this.f);
      this.a.setVisibility(0);
      if ((this.g != null) && (!this.g.getClass().getName().contains(".chromium.")))
        this.g.onCustomViewHidden();
      this.e = false;
      this.f = null;
      this.g = null;
      if (this.h != null)
        this.h.a(false);
    }
  }

  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (this.c != null)
      this.c.setVisibility(8);
  }

  public void onShowCustomView(View paramView, int paramInt, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    onShowCustomView(paramView, paramCustomViewCallback);
  }

  public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    View localView;
    if ((paramView instanceof FrameLayout))
    {
      FrameLayout localFrameLayout = (FrameLayout)paramView;
      localView = localFrameLayout.getFocusedChild();
      this.e = true;
      this.f = localFrameLayout;
      this.g = paramCustomViewCallback;
      this.a.setVisibility(4);
      this.b.addView(this.f, new ViewGroup.LayoutParams(-1, -1));
      this.b.setVisibility(0);
      if (!(localView instanceof VideoView))
        break label120;
      VideoView localVideoView = (VideoView)localView;
      localVideoView.setOnPreparedListener(this);
      localVideoView.setOnCompletionListener(this);
      localVideoView.setOnErrorListener(this);
    }
    while (true)
    {
      if (this.h != null)
        this.h.a(true);
      return;
      label120: if ((this.d == null) || (!this.d.getSettings().getJavaScriptEnabled()) || (!(localView instanceof SurfaceView)))
        continue;
      String str = new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf("javascript:")).append("var _ytrp_html5_video_last;").toString())).append("var _ytrp_html5_video = document.getElementsByTagName('video')[0];").toString())).append("if (_ytrp_html5_video != undefined && _ytrp_html5_video != _ytrp_html5_video_last) {").toString())).append("_ytrp_html5_video_last = _ytrp_html5_video;").toString())).append("function _ytrp_html5_video_ended() {").toString())).append("_VideoEnabledWebView.notifyVideoEnd();").toString())).append("}").toString())).append("_ytrp_html5_video.addEventListener('ended', _ytrp_html5_video_ended);").toString() + "}";
      this.d.loadUrl(str);
    }
  }

  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.web.a
 * JD-Core Version:    0.6.0
 */