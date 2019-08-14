package com.withustudy.koudaizikao.custom.a;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.umeng.socialize.bean.p;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.g.n;

public class a
{
  private Activity a;
  private PopupWindow b;
  private View c;
  private TextView d;
  private LinearLayout e;
  private ImageView f;
  private ImageView g;
  private ImageView h;
  private ImageView i;
  private Button j;
  private a k;
  private String l = "";
  private String m = "";
  private String n = "";
  private String o = "";
  private b p;
  private String q;
  private int r = -1;

  public a(Activity paramActivity, View paramView, String paramString1, String paramString2, String paramString3)
  {
    this.a = paramActivity;
    this.c = paramView;
    this.l = paramString1;
    this.o = paramString2;
    this.n = paramString3;
    this.k = new a();
  }

  public a(Context paramContext, View paramView)
  {
    this.a = ((Activity)paramContext);
    this.c = paramView;
    this.k = new a();
  }

  private void a(float paramFloat)
  {
    WindowManager.LayoutParams localLayoutParams = this.a.getWindow().getAttributes();
    localLayoutParams.alpha = paramFloat;
    this.a.getWindow().setAttributes(localLayoutParams);
  }

  private View d()
  {
    View localView = LinearLayout.inflate(this.a, 2130903137, null);
    this.d = ((TextView)localView.findViewById(2131296886));
    this.e = ((LinearLayout)localView.findViewById(2131296887));
    this.f = ((ImageView)localView.findViewById(2131296888));
    this.g = ((ImageView)localView.findViewById(2131296889));
    this.h = ((ImageView)localView.findViewById(2131296890));
    this.i = ((ImageView)localView.findViewById(2131296891));
    this.j = ((Button)localView.findViewById(2131296892));
    this.d.setOnClickListener(this.k);
    this.e.setOnClickListener(this.k);
    this.f.setOnClickListener(this.k);
    this.g.setOnClickListener(this.k);
    this.h.setOnClickListener(this.k);
    this.i.setOnClickListener(this.k);
    this.j.setOnClickListener(this.k);
    localView.setFocusable(true);
    localView.setFocusableInTouchMode(true);
    localView.setOnKeyListener(this.k);
    return localView;
  }

  public String a()
  {
    return this.l;
  }

  public void a(int paramInt)
  {
    this.r = paramInt;
  }

  public void a(b paramb)
  {
    this.p = paramb;
  }

  public void a(String paramString)
  {
    this.l = paramString;
  }

  public void b()
  {
    if (this.b != null)
    {
      this.b.dismiss();
      this.b = null;
    }
    this.b = new PopupWindow(d(), f.a(this.a).y(), n.a(this.a, 450.0F));
    this.b.setAnimationStyle(2131231021);
    this.b.setFocusable(true);
    this.b.showAtLocation(this.c, 80, 0, 0);
    a(0.3F);
  }

  public void b(String paramString)
  {
    this.o = paramString;
  }

  public void c()
  {
    if (this.b != null)
      this.b.dismiss();
    this.b = null;
    a(1.0F);
  }

  public void c(String paramString)
  {
    this.n = paramString;
  }

  public void d(String paramString)
  {
    this.m = paramString;
  }

  public void e(String paramString)
  {
    this.q = paramString;
  }

  class a
    implements View.OnClickListener, View.OnKeyListener
  {
    a()
    {
    }

    public void onClick(View paramView)
    {
      AbsBaseActivity localAbsBaseActivity = (AbsBaseActivity)a.a(a.this);
      switch (paramView.getId())
      {
      default:
        return;
      case 2131296888:
        if (a.b(a.this) != null)
          a.b(a.this).popOnItemListener(0);
        if (a.c(a.this).equals(""))
          localAbsBaseActivity.share(p.i, "http://share.kdzikao.com/app/share.page");
        while (true)
        {
          a.this.c();
          return;
          if (a.d(a.this) != -1)
          {
            localAbsBaseActivity.share(p.i, a.c(a.this), a.e(a.this), a.f(a.this), a.d(a.this));
            continue;
          }
          localAbsBaseActivity.share(p.i, a.c(a.this), a.e(a.this), a.f(a.this));
        }
      case 2131296889:
        if (a.b(a.this) != null)
          a.b(a.this).popOnItemListener(1);
        if (a.c(a.this).equals(""))
          localAbsBaseActivity.share(p.j, "http://share.kdzikao.com/app/share.page");
        while (true)
        {
          a.this.c();
          return;
          if (a.d(a.this) != -1)
          {
            localAbsBaseActivity.share(p.j, a.c(a.this), a.e(a.this), a.f(a.this), a.d(a.this));
            continue;
          }
          localAbsBaseActivity.share(p.j, a.c(a.this), a.e(a.this), a.f(a.this));
        }
      case 2131296890:
        if (a.b(a.this) != null)
          a.b(a.this).popOnItemListener(2);
        if (a.c(a.this).equals(""))
          localAbsBaseActivity.share(p.g, "http://share.kdzikao.com/app/share.page");
        while (true)
        {
          a.this.c();
          return;
          if (a.d(a.this) != -1)
          {
            localAbsBaseActivity.share(p.g, a.c(a.this), a.e(a.this), a.f(a.this), a.d(a.this));
            continue;
          }
          localAbsBaseActivity.share(p.g, a.c(a.this), a.e(a.this), a.f(a.this));
        }
      case 2131296891:
        if (a.b(a.this) != null)
          a.b(a.this).popOnItemListener(3);
        if (a.c(a.this).equals(""))
          localAbsBaseActivity.share(p.e, "http://share.kdzikao.com/app/share.page");
        while (true)
        {
          a.this.c();
          return;
          if (a.g(a.this).equals(""))
          {
            localAbsBaseActivity.share(p.e, a.c(a.this), a.e(a.this), a.f(a.this));
            continue;
          }
          if (a.d(a.this) != -1)
          {
            localAbsBaseActivity.share(p.e, a.g(a.this), a.e(a.this), a.f(a.this), a.d(a.this));
            continue;
          }
          localAbsBaseActivity.share(p.e, a.g(a.this), a.e(a.this), a.f(a.this));
        }
      case 2131296886:
      case 2131296887:
      case 2131296892:
      }
      a.this.c();
    }

    public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
    {
      if (paramInt == 4)
      {
        a.this.c();
        return true;
      }
      return false;
    }
  }

  public static abstract interface b
  {
    public abstract void popOnItemListener(int paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.a.a
 * JD-Core Version:    0.6.0
 */