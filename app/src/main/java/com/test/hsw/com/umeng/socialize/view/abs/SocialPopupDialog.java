package com.umeng.socialize.view.abs;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.umeng.socialize.common.b.a;

public class SocialPopupDialog extends Dialog
{
  private RelativeLayout a;
  private View b;
  private SwitchListener c;

  public SocialPopupDialog(Context paramContext, View paramView, int[] paramArrayOfInt)
  {
    super(paramContext, com.umeng.socialize.common.b.a(paramContext, b.a.d, "umeng_socialize_popup_dialog"));
    this.a = new RelativeLayout(paramContext);
    this.a.setBackgroundDrawable(null);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    this.a.setLayoutParams(localLayoutParams);
    paramView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.a.addView(paramView);
    this.b = View.inflate(paramContext, com.umeng.socialize.common.b.a(paramContext, b.a.a, "umeng_socialize_full_curtain"), null);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    this.a.addView(this.b, localLayoutParams1);
    this.b.setClickable(false);
    this.b.setOnTouchListener(new b(this));
    setContentView(this.a);
    WindowManager.LayoutParams localLayoutParams2 = getWindow().getAttributes();
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length < 2))
    {
      localLayoutParams2.height = -1;
      localLayoutParams2.width = -1;
    }
    for (int i = com.umeng.socialize.common.b.a(getContext(), b.a.d, "umeng_socialize_dialog_animations"); ; i = com.umeng.socialize.common.b.a(getContext(), b.a.d, "umeng_socialize_dialog_anim_fade"))
    {
      getWindow().getAttributes().windowAnimations = i;
      getWindow().setAttributes(localLayoutParams2);
      c();
      return;
      localLayoutParams2.width = paramArrayOfInt[0];
      localLayoutParams2.height = paramArrayOfInt[1];
    }
  }

  public SwitchListener a()
  {
    return this.c;
  }

  public void a(SwitchListener paramSwitchListener)
  {
    this.c = paramSwitchListener;
  }

  public void b()
  {
    this.b.setVisibility(0);
  }

  public void c()
  {
    this.b.setVisibility(4);
  }

  public void dismiss()
  {
    if (this.c != null)
      this.c.b();
    super.dismiss();
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (this.b.getVisibility() == 0))
    {
      this.b.setVisibility(8);
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }

  public void show()
  {
    if (this.c != null)
      this.c.a();
    super.show();
  }

  public static abstract interface SwitchListener
  {
    public abstract void a();

    public abstract void b();
  }

  public static abstract class a
  {
    private Context a;
    private View b;
    private ViewGroup c;
    private ViewGroup d;
    private View e;
    private int[] f;

    public a(Context paramContext)
    {
      this.a = paramContext;
      this.b = View.inflate(paramContext, com.umeng.socialize.common.b.a(paramContext, b.a.a, "umeng_socialize_full_alert_dialog"), null);
      this.c = ((ViewGroup)this.b.findViewById(com.umeng.socialize.common.b.a(paramContext, b.a.b, "umeng_socialize_first_area")));
      this.d = ((ViewGroup)this.b.findViewById(com.umeng.socialize.common.b.a(paramContext, b.a.b, "umeng_socialize_second_area")));
      this.e = this.b.findViewById(com.umeng.socialize.common.b.a(paramContext, b.a.b, "umeng_socialize_title"));
      a(this.e);
    }

    public a a(int paramInt)
    {
      this.c.setVisibility(paramInt);
      ((TextView)this.b.findViewById(com.umeng.socialize.common.b.a(this.a, b.a.b, "umeng_socialize_first_area_title"))).setVisibility(paramInt);
      return this;
    }

    public a a(int paramInt1, int paramInt2)
    {
      this.f = new int[] { paramInt1, paramInt2 };
      return this;
    }

    public a a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
    {
      if (paramLayoutParams == null)
      {
        this.c.addView(paramView);
        return this;
      }
      this.c.addView(paramView, paramLayoutParams);
      return this;
    }

    public a a(String paramString)
    {
      TextView localTextView = (TextView)this.b.findViewById(com.umeng.socialize.common.b.a(this.a, b.a.b, "umeng_socialize_first_area_title"));
      if (TextUtils.isEmpty(paramString))
      {
        localTextView.setVisibility(8);
        return this;
      }
      localTextView.setText(paramString);
      return this;
    }

    public SocialPopupDialog a()
    {
      return new SocialPopupDialog(this.a, this.b, this.f);
    }

    public abstract void a(View paramView);

    public a b(int paramInt)
    {
      this.d.setVisibility(paramInt);
      ((TextView)this.b.findViewById(com.umeng.socialize.common.b.a(this.a, b.a.b, "umeng_socialize_second_area_title"))).setVisibility(paramInt);
      return this;
    }

    public a b(View paramView, ViewGroup.LayoutParams paramLayoutParams)
    {
      if (paramLayoutParams == null)
      {
        this.d.addView(paramView);
        return this;
      }
      this.d.addView(paramView, paramLayoutParams);
      return this;
    }

    public a b(String paramString)
    {
      TextView localTextView = (TextView)this.b.findViewById(com.umeng.socialize.common.b.a(this.a, b.a.b, "umeng_socialize_second_area_title"));
      if (TextUtils.isEmpty(paramString))
      {
        localTextView.setVisibility(8);
        return this;
      }
      localTextView.setText(paramString);
      return this;
    }
  }

  public static class b
  {
    private View a;
    private ImageView b;
    private TextView c;

    public b(Context paramContext)
    {
      this.a = View.inflate(paramContext, com.umeng.socialize.common.b.a(paramContext, b.a.a, "umeng_socialize_full_alert_dialog_item"), null);
      this.b = ((ImageView)this.a.findViewById(com.umeng.socialize.common.b.a(paramContext, b.a.b, "umeng_socialize_full_alert_dialog_item_icon")));
      this.c = ((TextView)this.a.findViewById(com.umeng.socialize.common.b.a(paramContext, b.a.b, "umeng_socialize_full_alert_dialog_item_text")));
    }

    public View a()
    {
      return this.a;
    }

    public b a(int paramInt)
    {
      this.b.setImageResource(paramInt);
      return this;
    }

    public b a(View.OnClickListener paramOnClickListener)
    {
      this.a.setOnClickListener(paramOnClickListener);
      return this;
    }

    public b a(String paramString)
    {
      this.c.setText(paramString);
      return this;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.view.abs.SocialPopupDialog
 * JD-Core Version:    0.6.0
 */