package com.xiaomi.mipush;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class b extends Dialog
  implements TimePicker.OnTimeChangedListener
{
  private a a;
  private Context b;
  private TimePicker c;
  private TimePicker d;
  private Button e;
  private Button f;
  private int g;
  private int h;
  private int i;
  private int j;
  private View.OnClickListener k = new c(this);

  public b(Context paramContext, a parama)
  {
    this(paramContext, parama, 0, 0, 23, 59);
  }

  public b(Context paramContext, a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramContext);
    this.b = paramContext;
    this.a = parama;
    this.g = paramInt1;
    this.h = paramInt2;
    this.i = paramInt3;
    this.j = paramInt4;
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903266);
    setCancelable(true);
    setTitle(this.b.getString(2131165552));
    this.c = ((TimePicker)findViewById(2131297498));
    this.c.setIs24HourView(Boolean.valueOf(true));
    this.c.setCurrentHour(Integer.valueOf(this.g));
    this.c.setCurrentMinute(Integer.valueOf(this.h));
    this.c.setOnTimeChangedListener(this);
    this.d = ((TimePicker)findViewById(2131297499));
    this.d.setIs24HourView(Boolean.valueOf(true));
    this.d.setCurrentHour(Integer.valueOf(this.i));
    this.d.setCurrentMinute(Integer.valueOf(this.j));
    this.d.setOnTimeChangedListener(this);
    this.e = ((Button)findViewById(2131297501));
    this.e.setOnClickListener(this.k);
    this.f = ((Button)findViewById(2131297500));
    this.f.setOnClickListener(this.k);
  }

  public void onTimeChanged(TimePicker paramTimePicker, int paramInt1, int paramInt2)
  {
    if (paramTimePicker == this.c)
    {
      this.g = paramInt1;
      this.h = paramInt2;
    }
    do
      return;
    while (paramTimePicker != this.d);
    this.i = paramInt1;
    this.j = paramInt2;
  }

  static abstract interface a
  {
    public abstract void a();

    public abstract void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.mipush.b
 * JD-Core Version:    0.6.0
 */