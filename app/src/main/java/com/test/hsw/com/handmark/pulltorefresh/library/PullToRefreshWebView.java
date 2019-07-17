package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class PullToRefreshWebView extends PullToRefreshBase<WebView>
{
  private static final PullToRefreshBase.e<WebView> o = new h();
  private final WebChromeClient p = new i(this);

  public PullToRefreshWebView(Context paramContext)
  {
    super(paramContext);
    setOnRefreshListener(o);
    ((WebView)this.n).setWebChromeClient(this.p);
  }

  public PullToRefreshWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOnRefreshListener(o);
    ((WebView)this.n).setWebChromeClient(this.p);
  }

  public PullToRefreshWebView(Context paramContext, PullToRefreshBase.b paramb)
  {
    super(paramContext, paramb);
    setOnRefreshListener(o);
    ((WebView)this.n).setWebChromeClient(this.p);
  }

  public PullToRefreshWebView(Context paramContext, PullToRefreshBase.b paramb, PullToRefreshBase.a parama)
  {
    super(paramContext, paramb, parama);
    setOnRefreshListener(o);
    ((WebView)this.n).setWebChromeClient(this.p);
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    ((WebView)this.n).restoreState(paramBundle);
  }

  protected WebView b(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (Build.VERSION.SDK_INT >= 9);
    for (Object localObject = new a(paramContext, paramAttributeSet); ; localObject = new WebView(paramContext, paramAttributeSet))
    {
      ((WebView)localObject).setId(j.e.webview);
      return localObject;
    }
  }

  protected void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    ((WebView)this.n).saveState(paramBundle);
  }

  public final PullToRefreshBase.h getPullToRefreshScrollDirection()
  {
    return PullToRefreshBase.h.a;
  }

  protected boolean m()
  {
    return ((WebView)this.n).getScrollY() == 0;
  }

  protected boolean n()
  {
    float f = FloatMath.floor(((WebView)this.n).getContentHeight() * ((WebView)this.n).getScale());
    return ((WebView)this.n).getScrollY() >= f - ((WebView)this.n).getHeight();
  }

  @TargetApi(9)
  final class a extends WebView
  {
    static final int a = 2;
    static final float b = 1.5F;

    public a(Context paramAttributeSet, AttributeSet arg3)
    {
      super(localAttributeSet);
    }

    private int a()
    {
      return (int)Math.max(0.0F, FloatMath.floor(((WebView)PullToRefreshWebView.this.n).getContentHeight() * ((WebView)PullToRefreshWebView.this.n).getScale()) - (getHeight() - getPaddingBottom() - getPaddingTop()));
    }

    protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
    {
      boolean bool = super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      d.a(PullToRefreshWebView.this, paramInt1, paramInt3, paramInt2, paramInt4, a(), 2, 1.5F, paramBoolean);
      return bool;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.PullToRefreshWebView
 * JD-Core Version:    0.6.0
 */