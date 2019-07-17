package com.handmark.pulltorefresh.library.extras;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.b;
import com.handmark.pulltorefresh.library.PullToRefreshWebView;
import java.util.concurrent.atomic.AtomicBoolean;

public class PullToRefreshWebView2 extends PullToRefreshWebView
{
  static final String o = "ptr";
  static final String p = "javascript:isReadyForPullDown();";
  static final String q = "javascript:isReadyForPullUp();";
  private a r;
  private final AtomicBoolean s = new AtomicBoolean(false);
  private final AtomicBoolean t = new AtomicBoolean(false);

  public PullToRefreshWebView2(Context paramContext)
  {
    super(paramContext);
  }

  public PullToRefreshWebView2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public PullToRefreshWebView2(Context paramContext, PullToRefreshBase.b paramb)
  {
    super(paramContext, paramb);
  }

  protected WebView b(Context paramContext, AttributeSet paramAttributeSet)
  {
    WebView localWebView = super.b(paramContext, paramAttributeSet);
    this.r = new a();
    localWebView.addJavascriptInterface(this.r, "ptr");
    return localWebView;
  }

  protected boolean m()
  {
    ((WebView)getRefreshableView()).loadUrl("javascript:isReadyForPullDown();");
    return this.s.get();
  }

  protected boolean n()
  {
    ((WebView)getRefreshableView()).loadUrl("javascript:isReadyForPullUp();");
    return this.t.get();
  }

  final class a
  {
    a()
    {
    }

    public void a(boolean paramBoolean)
    {
      PullToRefreshWebView2.a(PullToRefreshWebView2.this).set(paramBoolean);
    }

    public void b(boolean paramBoolean)
    {
      PullToRefreshWebView2.b(PullToRefreshWebView2.this).set(paramBoolean);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.extras.PullToRefreshWebView2
 * JD-Core Version:    0.6.0
 */