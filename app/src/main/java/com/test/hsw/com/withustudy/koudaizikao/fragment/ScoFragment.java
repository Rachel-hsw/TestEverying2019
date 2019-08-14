package com.withustudy.koudaizikao.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.umeng.a.g;
import com.withustudy.koudaizikao.activity.ActivitySimuResult;
import com.withustudy.koudaizikao.base.AbsBaseFragment;
import com.withustudy.koudaizikao.custom.a.a;
import com.withustudy.koudaizikao.custom.a.a.b;

public class ScoFragment extends AbsBaseFragment
  implements View.OnClickListener, a.b
{
  private TextView a;
  private TextView b;
  private TextView c;
  private LinearLayout d;
  private ImageButton e;
  private Button f;
  private TextView g;
  private TextView h;
  private ActivitySimuResult i;
  private a j;

  private void d()
  {
    this.j = new a(this.i, this.d);
    this.j.a(this);
    this.j.c("我今日的模拟考过关啦，已获得奖学金！天天喜刷刷，过关就靠它~");
    this.j.b("口袋自考");
    this.j.a(2130838017);
    this.j.a(this.i.w);
    this.j.d(this.i.w);
    this.j.b();
  }

  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    return View.inflate(getActivity(), 2130903180, null);
  }

  public void a()
  {
    this.i.s = true;
  }

  public void a(View paramView)
  {
    this.a = ((TextView)paramView.findViewById(2131297145));
    this.c = ((TextView)paramView.findViewById(2131297146));
    this.b = ((TextView)paramView.findViewById(2131297147));
    this.g = ((TextView)paramView.findViewById(2131297144));
    this.e = ((ImageButton)paramView.findViewById(2131297142));
    this.h = ((TextView)paramView.findViewById(2131297148));
    this.f = ((Button)paramView.findViewById(2131297149));
    this.d = ((LinearLayout)paramView.findViewById(2131297141));
  }

  public void b()
  {
    this.a.setText(this.i.n);
    this.c.setText(this.i.p);
    this.b.setText(this.i.o);
    this.g.setText(this.i.d);
    int k = (int)(1.0D * this.i.r / 100.0D);
    this.h.setText(k + "元");
    new Thread(new v(this)).start();
  }

  public void c()
  {
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.i = ((ActivitySimuResult)paramActivity);
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131297142:
      g.b(this.y, "test_close_con");
      this.i.setResult(102);
      a(0, 0);
      return;
    case 2131297149:
    }
    d();
  }

  public void onDestroy()
  {
    super.onDestroy();
    if (this.j != null)
    {
      this.j.c();
      this.j = null;
    }
  }

  public void popOnItemListener(int paramInt)
  {
    this.i.a();
  }

  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.ScoFragment
 * JD-Core Version:    0.6.0
 */