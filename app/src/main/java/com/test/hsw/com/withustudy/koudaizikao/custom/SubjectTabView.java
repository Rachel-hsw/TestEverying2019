package com.withustudy.koudaizikao.custom;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SubjectTabView extends LinearLayout
{
  private Context a;
  private TextView b;
  private ImageView c;

  public SubjectTabView(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    a();
  }

  public SubjectTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    a();
  }

  public SubjectTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    a();
  }

  @TargetApi(21)
  public SubjectTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    this.a = paramContext;
    a();
  }

  private void a()
  {
    View localView = inflate(this.a, 2130903133, null);
    this.b = ((TextView)localView.findViewById(2131296877));
    this.c = ((ImageView)localView.findViewById(2131296878));
    addView(localView);
  }

  public void setSubject(String paramString)
  {
    this.b.setText(paramString);
  }

  public void setSubjectState(int paramInt)
  {
    if (paramInt == 1)
    {
      this.c.setVisibility(0);
      this.b.getPaint().setFakeBoldText(true);
      this.b.setTextColor(Color.parseColor("#ffffff"));
      this.b.setTextSize(2, 16.0F);
      return;
    }
    this.c.setVisibility(8);
    this.b.getPaint().setFakeBoldText(false);
    this.b.setTextColor(Color.parseColor("#A9A9A9"));
    this.b.setTextSize(2, 15.0F);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.SubjectTabView
 * JD-Core Version:    0.6.0
 */