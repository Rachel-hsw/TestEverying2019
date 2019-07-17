package com.umeng.socialize.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import com.umeng.socialize.utils.m;

class ad extends FrameLayout
{
  ad(aa paramaa, Context paramContext, View paramView1, View paramView2, int paramInt)
  {
    super(paramContext);
  }

  private void a(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    if ((paramView2.getVisibility() == 0) && (paramInt2 < paramInt1))
      aa.d(this.d).post(new ae(this, paramView2, paramView1));
    do
      return;
    while ((paramView2.getVisibility() == 0) || (paramInt2 < paramInt1));
    aa.d(this.d).post(new af(this, paramView2, paramView1));
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (!m.d(aa.c(this.d)))
      a(this.a, this.b, this.c, paramInt2);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.view.ad
 * JD-Core Version:    0.6.0
 */