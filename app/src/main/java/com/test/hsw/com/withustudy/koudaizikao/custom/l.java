package com.withustudy.koudaizikao.custom;

import android.os.CountDownTimer;
import android.widget.TextView;

public class l extends CountDownTimer
{
  public static final int a = 240000;
  private TextView b;
  private int c;
  private int d;
  private int e;

  public l(long paramLong1, long paramLong2, TextView paramTextView, int paramInt)
  {
    super(paramLong1, paramLong2);
    this.b = paramTextView;
    this.c = paramInt;
  }

  public l(TextView paramTextView)
  {
    super(240000L, 1000L);
    this.b = paramTextView;
    this.c = 2131165508;
  }

  public l(TextView paramTextView, int paramInt)
  {
    super(240000L, 1000L);
    this.b = paramTextView;
    this.c = paramInt;
  }

  public l(TextView paramTextView, int paramInt1, int paramInt2)
  {
    this(paramTextView);
    this.d = paramInt1;
    this.e = paramInt2;
  }

  public void onFinish()
  {
    if (this.d > 0)
      this.b.setTextColor(this.d);
    this.b.setText(this.c);
    this.b.setEnabled(true);
  }

  public void onTick(long paramLong)
  {
    if (this.e > 0)
      this.b.setTextColor(this.e);
    this.b.setEnabled(false);
    this.b.setText(paramLong / 1000L + "秒");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.l
 * JD-Core Version:    0.6.0
 */