package com.withustudy.koudaizikao.custom;

import android.os.CountDownTimer;
import android.widget.TextView;

public class h extends CountDownTimer
{
  private static final int b = 60;
  private static final int c = 3600;
  private TextView a;
  private long d = 0L;
  private long e = 0L;
  private long f = 0L;
  private long g = 0L;
  private long h = 0L;

  public h(long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2);
  }

  public h(TextView paramTextView, int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2);
    this.a = paramTextView;
  }

  public void onFinish()
  {
  }

  public void onTick(long paramLong)
  {
    this.d = (paramLong / 1000L);
    if (this.d < 60L)
    {
      TextView localTextView6 = this.a;
      StringBuilder localStringBuilder10 = new StringBuilder("00:00:");
      if (this.d < 10L);
      for (Object localObject10 = "0" + this.d; ; localObject10 = Long.valueOf(this.d))
      {
        localTextView6.setText(localObject10);
        return;
      }
    }
    if (this.d < 3600L)
    {
      this.e = (this.d % 60L);
      this.g = (this.d / 60L);
      if (this.e == 0L)
      {
        TextView localTextView5 = this.a;
        StringBuilder localStringBuilder9 = new StringBuilder("00:");
        if (this.g < 10L);
        for (Object localObject9 = "0" + this.g; ; localObject9 = Long.valueOf(this.g))
        {
          localTextView5.setText(localObject9 + ":00");
          return;
        }
      }
      TextView localTextView4 = this.a;
      StringBuilder localStringBuilder7 = new StringBuilder("00:");
      Object localObject7;
      StringBuilder localStringBuilder8;
      if (this.g < 10L)
      {
        localObject7 = "0" + this.g;
        localStringBuilder8 = localStringBuilder7.append(localObject7).append(":");
        if (this.e >= 10L)
          break label346;
      }
      label346: for (Object localObject8 = "0" + this.e; ; localObject8 = Long.valueOf(this.e))
      {
        localTextView4.setText(localObject8);
        return;
        localObject7 = Long.valueOf(this.g);
        break;
      }
    }
    this.e = (this.d % 3600L);
    this.g = (this.d / 3600L);
    if (this.e == 0L)
    {
      this.a.setText("0" + this.d / 3600L + ":00:00");
      return;
    }
    if (this.e < 60L)
    {
      TextView localTextView3 = this.a;
      StringBuilder localStringBuilder5 = new StringBuilder();
      Object localObject5;
      StringBuilder localStringBuilder6;
      if (this.g < 10L)
      {
        localObject5 = "0" + this.g;
        localStringBuilder6 = localStringBuilder5.append(localObject5).append(":00:");
        if (this.e >= 10L)
          break label559;
      }
      label559: for (Object localObject6 = "0" + this.e; ; localObject6 = Long.valueOf(this.e))
      {
        localTextView3.setText(localObject6);
        return;
        localObject5 = Long.valueOf(this.g);
        break;
      }
    }
    this.f = (this.e % 60L);
    this.h = (this.e / 60L);
    if (this.f == 0L)
    {
      TextView localTextView2 = this.a;
      StringBuilder localStringBuilder3 = new StringBuilder();
      Object localObject3;
      StringBuilder localStringBuilder4;
      if (this.g < 10L)
      {
        localObject3 = "0" + this.g;
        localStringBuilder4 = localStringBuilder3.append(localObject3).append(":");
        if (this.h >= 10L)
          break label730;
      }
      label730: for (Object localObject4 = "0" + this.h; ; localObject4 = Long.valueOf(this.h))
      {
        localTextView2.setText(localObject4 + ":00");
        return;
        localObject3 = Long.valueOf(this.g);
        break;
      }
    }
    TextView localTextView1 = this.a;
    StringBuilder localStringBuilder1 = new StringBuilder();
    Object localObject1;
    StringBuilder localStringBuilder2;
    if (this.g < 10L)
    {
      localObject1 = "0" + this.g;
      localStringBuilder2 = localStringBuilder1.append(localObject1).append(":");
      if (this.h >= 10L)
        break label873;
    }
    label873: for (Object localObject2 = "0" + this.h; ; localObject2 = Long.valueOf(this.h))
    {
      localTextView1.setText(localObject2 + ":" + this.f);
      return;
      localObject1 = Long.valueOf(this.g);
      break;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.h
 * JD-Core Version:    0.6.0
 */