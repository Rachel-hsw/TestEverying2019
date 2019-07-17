package com.umeng.socialize.view;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.umeng.socialize.bean.ax;
import com.umeng.socialize.common.b;
import com.umeng.socialize.common.b.a;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.socialize.controller.listener.SocializeListeners.UMShareBoardListener;

public class ak extends PopupWindow
{
  private Context a = null;
  private com.umeng.socialize.view.abs.a b = null;
  private UMSocialService c;
  private ax d = ax.b();
  private SocializeListeners.UMShareBoardListener e;

  public ak(Context paramContext, com.umeng.socialize.view.abs.a parama, UMSocialService paramUMSocialService)
  {
    super(parama, -1, -1, false);
    this.a = paramContext;
    this.b = parama;
    this.c = paramUMSocialService;
    com.umeng.socialize.view.wigets.a locala = a();
    this.b.a(locala);
    setAnimationStyle(b.a(this.a, b.a.d, "umeng_socialize_shareboard_animation"));
  }

  private com.umeng.socialize.view.wigets.a a()
  {
    return new al(this, this.d.a(this.a, this.c));
  }

  public void a(SocializeListeners.UMShareBoardListener paramUMShareBoardListener)
  {
    this.e = paramUMShareBoardListener;
  }

  public void dismiss()
  {
    super.dismiss();
    if (this.e != null)
      this.e.b();
  }

  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
      if (this.e != null)
        this.e.a();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.view.ak
 * JD-Core Version:    0.6.0
 */