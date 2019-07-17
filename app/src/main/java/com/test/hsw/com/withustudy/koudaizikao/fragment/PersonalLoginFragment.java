package com.withustudy.koudaizikao.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.http.e;
import com.umeng.a.g;
import com.withustudy.koudaizikao.activity.PersonalSetActivity;
import com.withustudy.koudaizikao.base.AbsBaseFragment;
import com.withustudy.koudaizikao.d.f;

public class PersonalLoginFragment extends AbsBaseFragment
{
  private ImageView a;
  private TextView b;
  private Button c;
  private a d;

  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903162, null);
  }

  public void a()
  {
    this.d = new a();
  }

  public void a(View paramView)
  {
    this.a = ((ImageView)paramView.findViewById(2131297005));
    this.b = ((TextView)paramView.findViewById(2131297006));
    this.c = ((Button)paramView.findViewById(2131297007));
  }

  public void a(String paramString)
  {
    this.b.setText(paramString);
  }

  public void b()
  {
    if (!this.E.v().equals(""))
    {
      this.b.setText(this.E.v());
      if (!this.E.u().equals(""))
        this.D.a(this.E.u(), this.a, 1000);
    }
    do
      return;
    while (PersonalFragment.b == null);
    PersonalFragment.b.sendEmptyMessage(4);
  }

  public void b(String paramString)
  {
    this.D.a(paramString, this.a, 1000);
  }

  public void c()
  {
    this.c.setOnClickListener(this.d);
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
      case 2131297007:
      }
      g.b(PersonalLoginFragment.a(PersonalLoginFragment.this), "personal_set_person");
      PersonalLoginFragment.a(PersonalLoginFragment.this, PersonalSetActivity.class, false, null);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.PersonalLoginFragment
 * JD-Core Version:    0.6.0
 */