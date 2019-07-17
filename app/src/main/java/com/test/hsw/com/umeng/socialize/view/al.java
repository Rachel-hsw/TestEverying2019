package com.umeng.socialize.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.umeng.socialize.bean.aw;
import com.umeng.socialize.bean.ax;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.common.b;
import com.umeng.socialize.common.b.a;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.socialize.controller.listener.SocializeListeners.SnsPostListener;
import com.umeng.socialize.utils.d;
import com.umeng.socialize.view.wigets.a;
import java.util.List;

class al extends a
{
  al(ak paramak, List paramList)
  {
  }

  private void a(View paramView, aw paramaw)
  {
    ((ImageView)paramView.findViewById(b.a(ak.a(this.b), b.a.b, "umeng_socialize_shareboard_image"))).setImageResource(paramaw.c);
    ((TextView)paramView.findViewById(b.a(ak.a(this.b), b.a.b, "umeng_socialize_shareboard_pltform_name"))).setText(paramaw.b);
  }

  private void a(aw paramaw)
  {
    if ((paramaw.c == -1) && (paramaw.j == p.d))
      paramaw.c = b.a(ak.a(this.b), b.a.c, "umeng_socialize_gmail_on");
    do
      return;
    while ((paramaw.c != -1) || (paramaw.j != p.c));
    paramaw.c = b.a(ak.a(this.b), b.a.c, "umeng_socialize_sms_on");
  }

  private void a(aw paramaw, p paramp)
  {
    if (paramp != null)
      ak.b(this.b).f().a(ak.a(this.b), paramp, 14);
    if (paramaw != null)
    {
      ax.e(paramp);
      SocializeListeners.SnsPostListener localSnsPostListener = d.a();
      paramaw.a(ak.a(this.b), ak.b(this.b).f(), localSnsPostListener);
    }
  }

  public int a()
  {
    if (this.a == null)
      return 0;
    return this.a.size();
  }

  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    aw localaw = (aw)this.a.get(paramInt);
    a(localaw);
    View localView = View.inflate(ak.a(this.b), b.a(ak.a(this.b), b.a.a, "umeng_socialize_shareboard_item"), null);
    a(localView, localaw);
    localView.setOnClickListener(new am(this, localaw));
    localView.setOnTouchListener(new an(this, localView));
    localView.setFocusable(true);
    return localView;
  }

  public Object a(int paramInt)
  {
    if (this.a == null)
      return null;
    return (aw)this.a.get(paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.view.al
 * JD-Core Version:    0.6.0
 */