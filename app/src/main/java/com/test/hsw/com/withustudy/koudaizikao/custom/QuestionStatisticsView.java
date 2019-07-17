package com.withustudy.koudaizikao.custom;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class QuestionStatisticsView extends LinearLayout
{
  private Context a;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private ImageView[] g;

  public QuestionStatisticsView(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    a();
  }

  public QuestionStatisticsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    a();
  }

  public QuestionStatisticsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    a();
  }

  @TargetApi(21)
  public QuestionStatisticsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    this.a = paramContext;
    a();
  }

  private void a()
  {
    View localView = LayoutInflater.from(this.a).inflate(2130903140, null);
    this.d = ((TextView)localView.findViewById(2131296904));
    this.e = ((TextView)localView.findViewById(2131296906));
    this.f = ((TextView)localView.findViewById(2131296908));
    this.b = ((TextView)localView.findViewById(2131296905));
    this.c = ((TextView)localView.findViewById(2131296907));
    this.g = new ImageView[5];
    this.g[0] = ((ImageView)localView.findViewById(2131296909));
    this.g[1] = ((ImageView)localView.findViewById(2131296910));
    this.g[2] = ((ImageView)localView.findViewById(2131296911));
    this.g[3] = ((ImageView)localView.findViewById(2131296912));
    this.g[4] = ((ImageView)localView.findViewById(2131296913));
    addView(localView);
    localView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
  }

  public void setImageMaster(int paramInt)
  {
    if ((paramInt > 5) || (paramInt < 1))
      return;
    int i = 0;
    label13: if (i < 5)
    {
      if (i >= paramInt)
        break label40;
      this.g[i].setBackgroundResource(2130838069);
    }
    while (true)
    {
      i++;
      break label13;
      break;
      label40: this.g[i].setBackgroundResource(2130838069);
    }
  }

  public void setTextContentLeft(String paramString)
  {
    this.b.setText(paramString);
  }

  public void setTextContentMiddle(String paramString)
  {
    this.c.setText(paramString);
  }

  public void setTextTitleLeft(String paramString)
  {
    this.d.setText(paramString);
  }

  public void setTextTitleMiddle(String paramString)
  {
    this.e.setText(paramString);
  }

  public void setTextTitleRight(String paramString)
  {
    this.f.setText(paramString);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.QuestionStatisticsView
 * JD-Core Version:    0.6.0
 */