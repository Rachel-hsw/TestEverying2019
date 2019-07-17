package com.withustudy.koudaizikao.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LoadingView extends LinearLayout
{
  private Context a;
  private ImageView b;
  private TextView c;
  private AnimationDrawable d;

  public LoadingView(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    a();
  }

  public LoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    a();
  }

  public LoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    a();
  }

  @SuppressLint({"NewApi"})
  public LoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    this.a = paramContext;
    a();
  }

  private void a()
  {
    View localView = LayoutInflater.from(this.a).inflate(2130903135, null);
    this.b = ((ImageView)localView.findViewById(2131296881));
    this.c = ((TextView)localView.findViewById(2131296882));
    this.b.setImageResource(2130837572);
    this.d = ((AnimationDrawable)this.b.getDrawable());
    this.b.post(new k(this));
    addView(localView);
    setGravity(17);
  }

  public void setText(String paramString)
  {
    this.c.setText(paramString);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.LoadingView
 * JD-Core Version:    0.6.0
 */