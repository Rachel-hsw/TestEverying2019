package com.withustudy.koudaizikao.custom;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class OptionView extends LinearLayout
{
  private List<String> a;
  private int b;
  private List<Integer> c;
  private int d;
  private int e = 0;
  private boolean f = false;
  private boolean g = true;
  private boolean h = false;
  private boolean[] i;
  private boolean j;
  private List<String> k;
  private Handler l;
  private int m;
  private TextView[] n;
  private Button o;
  private int[] p = { 2130837507, 2130837578, 2130837711, 2130837749, 2130837779, 2130837817 };
  private int[] q = { 2130837504, 2130837575, 2130837708, 2130837747, 2130837777, 2130837815 };
  private int[] r = { 2130837504, 2130837575, 2130837708, 2130837747, 2130837777, 2130837815 };
  private int[] s = { 2130837508, 2130837579, 2130837712, 2130837750, 2130837780, 2130837818 };
  private a t;
  private Context u;

  public OptionView(Context paramContext)
  {
    super(paramContext);
    this.u = paramContext;
    c();
  }

  public OptionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.u = paramContext;
    c();
  }

  public OptionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.u = paramContext;
    c();
  }

  @TargetApi(21)
  public OptionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    this.u = paramContext;
    c();
  }

  private void a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return;
    case 0:
      this.k.add("A");
      return;
    case 1:
      this.k.add("B");
      return;
    case 2:
      this.k.add("C");
      return;
    case 3:
      this.k.add("D");
      return;
    case 4:
      this.k.add("E");
      return;
    case 5:
    }
    this.k.add("F");
  }

  private void a(TextView paramTextView, int paramInt, boolean paramBoolean)
  {
    Drawable localDrawable1;
    Drawable localDrawable2;
    if (paramBoolean)
    {
      localDrawable1 = getResources().getDrawable(this.r[paramInt]);
      localDrawable2 = getResources().getDrawable(2130837945);
      paramTextView.setTextColor(Color.parseColor("#34b601"));
    }
    while (true)
    {
      localDrawable1.setBounds(0, 0, localDrawable1.getMinimumWidth(), localDrawable1.getMinimumHeight());
      localDrawable2.setBounds(0, 0, localDrawable2.getMinimumWidth(), localDrawable2.getMinimumHeight());
      paramTextView.setCompoundDrawables(localDrawable1, null, localDrawable2, null);
      return;
      localDrawable1 = getResources().getDrawable(this.s[paramInt]);
      localDrawable2 = getResources().getDrawable(2130837947);
      paramTextView.setTextColor(Color.parseColor("#FF0033"));
    }
  }

  private void b(TextView paramTextView, int paramInt, boolean paramBoolean)
  {
    Drawable localDrawable;
    if (paramBoolean)
    {
      localDrawable = getResources().getDrawable(this.p[paramInt]);
      paramTextView.setTextColor(Color.parseColor("#666666"));
    }
    while (true)
    {
      localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
      paramTextView.setCompoundDrawables(localDrawable, null, null, null);
      return;
      localDrawable = getResources().getDrawable(this.q[paramInt]);
      paramTextView.setTextColor(Color.parseColor("#34b601"));
    }
  }

  private void c()
  {
    setOrientation(1);
    this.t = new a();
  }

  private void d()
  {
    this.g = false;
    int i1 = 0;
    if (i1 >= this.b)
    {
      if (this.e != 2)
        this.e = 1;
      return;
    }
    int i2 = 0;
    int i3 = 0;
    label33: if (i2 >= this.d)
    {
      label41: if (i3 == this.d)
        break label101;
      a(this.n[i1], i1, true);
    }
    while (true)
    {
      i1++;
      break;
      if (i1 == ((Integer)this.c.get(i2)).intValue())
        break label41;
      int i4 = i2 + 1;
      i3++;
      i2 = i4;
      break label33;
      label101: if (this.i[i1] == 0)
        continue;
      a(this.n[i1], i1, false);
      this.e = 2;
    }
  }

  private void setSingleResult(int paramInt)
  {
    this.g = false;
    int i1 = 0;
    if (i1 >= this.b)
      return;
    int i2 = 0;
    int i3 = 0;
    label21: if (i2 >= this.d)
    {
      label29: if (i3 == this.d)
        break label100;
      a(this.n[i1], i1, true);
      if (paramInt == i1)
        this.e = 1;
    }
    while (true)
    {
      i1++;
      break;
      if (i1 == ((Integer)this.c.get(i2)).intValue())
        break label29;
      int i4 = i2 + 1;
      i3++;
      i2 = i4;
      break label21;
      label100: if (paramInt != i1)
        continue;
      a(this.n[i1], i1, false);
      this.e = 2;
    }
  }

  public void a(List<String> paramList, List<Integer> paramList1, Handler paramHandler, int paramInt, boolean paramBoolean)
  {
    this.a = paramList;
    this.c = paramList1;
    this.l = paramHandler;
    this.m = paramInt;
    this.j = paramBoolean;
    this.b = paramList.size();
    this.d = paramList1.size();
    LinearLayout.LayoutParams localLayoutParams1;
    int i1;
    if (this.d > 1)
    {
      this.f = true;
      this.k = new ArrayList();
      this.n = new TextView[this.b];
      localLayoutParams1 = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams1.setMargins(0, 50, 0, 0);
      i1 = 0;
      label108: if (i1 < this.b)
        break label280;
      this.i = new boolean[this.b];
    }
    for (int i2 = 0; ; i2++)
    {
      if (i2 >= this.b)
      {
        if ((this.f) && (!paramBoolean))
        {
          this.o = new Button(this.u);
          this.o.setText(this.u.getResources().getString(2131165433));
          this.o.setBackgroundResource(2130837946);
          this.o.setTextColor(Color.parseColor("#ffffff"));
          this.o.setTextSize(2, 18.0F);
          LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -1);
          localLayoutParams2.setMargins(0, 50, 0, 0);
          this.o.setLayoutParams(localLayoutParams2);
          this.o.setOnClickListener(this.t);
          addView(this.o);
        }
        this.h = true;
        return;
        this.f = false;
        break;
        label280: this.n[i1] = new TextView(this.u);
        this.n[i1].setTag(Integer.valueOf(i1));
        this.n[i1].setText((CharSequence)paramList.get(i1));
        this.n[i1].setTextColor(Color.parseColor("#666666"));
        this.n[i1].setTextSize(2, 18.0F);
        this.n[i1].getPaint().setFakeBoldText(true);
        this.n[i1].setLayoutParams(localLayoutParams1);
        this.n[i1].setGravity(16);
        Drawable localDrawable = getResources().getDrawable(this.p[i1]);
        localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
        this.n[i1].setCompoundDrawables(localDrawable, null, null, null);
        this.n[i1].setCompoundDrawablePadding(40);
        this.n[i1].setOnClickListener(this.t);
        addView(this.n[i1]);
        i1++;
        break label108;
      }
      this.i[i2] = false;
    }
  }

  public boolean a()
  {
    return this.h;
  }

  public void b()
  {
    this.g = false;
    int i1 = 0;
    if (i1 >= this.b)
    {
      if (this.o != null)
        this.o.setVisibility(8);
      return;
    }
    for (int i2 = 0; ; i2++)
    {
      if (i2 >= this.d)
      {
        i1++;
        break;
      }
      if (i1 != ((Integer)this.c.get(i2)).intValue())
        continue;
      a(this.n[i1], i1, true);
    }
  }

  public List<String> getClicked()
  {
    this.k.clear();
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= this.b)
        return this.k;
      if (this.i[i1] == 0)
        continue;
      a(i1);
    }
  }

  class a
    implements View.OnClickListener
  {
    a()
    {
    }

    public void onClick(View paramView)
    {
      int m;
      int n;
      if ((paramView instanceof Button))
      {
        m = 0;
        n = 0;
        if (m >= OptionView.a(OptionView.this))
        {
          if (n != 0)
            break label82;
          Toast.makeText(OptionView.c(OptionView.this), OptionView.c(OptionView.this).getResources().getString(2131165434), 0).show();
        }
      }
      label82: 
      do
      {
        return;
        if (OptionView.b(OptionView.this)[m] != 0)
          n = 1;
        m++;
        break;
        OptionView.d(OptionView.this);
        if (OptionView.e(OptionView.this) != null)
          OptionView.e(OptionView.this).setVisibility(8);
        Message localMessage2 = OptionView.f(OptionView.this).obtainMessage(OptionView.g(OptionView.this), Integer.valueOf(OptionView.h(OptionView.this)));
        OptionView.f(OptionView.this).sendMessage(localMessage2);
        return;
      }
      while (!OptionView.i(OptionView.this));
      if (!OptionView.j(OptionView.this))
      {
        String str = ((TextView)paramView).getText().toString();
        boolean bool = OptionView.k(OptionView.this);
        int j = 0;
        if (!bool)
          while (true)
          {
            if (j >= OptionView.a(OptionView.this))
            {
              Message localMessage1 = OptionView.f(OptionView.this).obtainMessage(OptionView.g(OptionView.this), Integer.valueOf(OptionView.h(OptionView.this)));
              OptionView.f(OptionView.this).sendMessage(localMessage1);
              return;
            }
            if (str.equals(OptionView.l(OptionView.this).get(j)))
            {
              OptionView.b(OptionView.this)[j] = 1;
              OptionView.a(OptionView.this, j);
            }
            j++;
          }
        int k = 0;
        label309: if (k < OptionView.a(OptionView.this))
        {
          if (!str.equals(OptionView.l(OptionView.this).get(k)))
            break label379;
          OptionView.b(OptionView.this)[k] = 1;
          OptionView.a(OptionView.this, OptionView.m(OptionView.this)[k], k, false);
        }
        while (true)
        {
          k++;
          break label309;
          break;
          label379: OptionView.b(OptionView.this)[k] = 0;
          OptionView.a(OptionView.this, OptionView.m(OptionView.this)[k], k, true);
        }
      }
      int i = ((Integer)paramView.getTag()).intValue();
      if (OptionView.b(OptionView.this)[i] != 0)
      {
        OptionView.a(OptionView.this, OptionView.m(OptionView.this)[i], i, true);
        OptionView.b(OptionView.this)[i] = 0;
        return;
      }
      OptionView.a(OptionView.this, OptionView.m(OptionView.this)[i], i, false);
      OptionView.b(OptionView.this)[i] = 1;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.OptionView
 * JD-Core Version:    0.6.0
 */