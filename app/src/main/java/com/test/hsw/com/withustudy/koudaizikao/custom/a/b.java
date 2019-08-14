package com.withustudy.koudaizikao.custom.a;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.withustudy.koudaizikao.g.h;

public class b
{
  private Activity a;
  private View b;
  private String c;
  private String d;
  private PopupWindow e;
  private Button f;
  private Button g;
  private a h;

  public b(Activity paramActivity, View paramView, String paramString1, String paramString2)
  {
    this.a = paramActivity;
    this.b = paramView;
    this.c = paramString1;
    this.d = paramString2;
    this.h = new a();
  }

  private View c()
  {
    View localView = LinearLayout.inflate(this.a, 2130903138, null);
    this.f = ((Button)localView.findViewById(2131296894));
    this.g = ((Button)localView.findViewById(2131296895));
    this.g.setText(this.d);
    this.f.setText(this.c);
    this.g.setOnClickListener(this.h);
    this.f.setOnClickListener(this.h);
    return localView;
  }

  public void a()
  {
    if (this.e != null)
    {
      this.e.dismiss();
      this.e = null;
    }
    this.e = new PopupWindow(c(), -1, -2);
    this.e.setBackgroundDrawable(new BitmapDrawable());
    this.e.setOutsideTouchable(true);
    this.e.showAsDropDown(this.b, 0, -18);
  }

  public void b()
  {
    if (this.e != null)
      this.e.dismiss();
    this.e = null;
  }

  class a
    implements View.OnClickListener
  {
    a()
    {
    }

    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      default:
        return;
      case 2131296894:
        h.a(b.a(b.this), "up");
        b.this.b();
        return;
      case 2131296895:
      }
      h.a(b.a(b.this), "down");
      b.this.b();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.a.b
 * JD-Core Version:    0.6.0
 */