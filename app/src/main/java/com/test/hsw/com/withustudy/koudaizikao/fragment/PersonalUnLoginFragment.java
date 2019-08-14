package com.withustudy.koudaizikao.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.umeng.a.g;
import com.withustudy.koudaizikao.activity.LoginActivity;
import com.withustudy.koudaizikao.base.AbsBaseFragment;

public class PersonalUnLoginFragment extends AbsBaseFragment
{
  private ImageView a;
  private TextView b;
  private TextView c;
  private a d;

  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903163, null);
  }

  public void a()
  {
    this.d = new a();
  }

  public void a(View paramView)
  {
    this.a = ((ImageView)paramView.findViewById(2131297008));
    this.b = ((TextView)paramView.findViewById(2131297009));
    this.c = ((TextView)paramView.findViewById(2131297010));
  }

  public void b()
  {
  }

  public void c()
  {
    this.a.setOnClickListener(this.d);
    this.c.setOnClickListener(this.d);
    this.b.setOnClickListener(this.d);
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
      case 2131297008:
      case 2131297009:
      case 2131297010:
      }
      g.b(PersonalUnLoginFragment.a(PersonalUnLoginFragment.this), "login");
      Intent localIntent = new Intent(PersonalUnLoginFragment.a(PersonalUnLoginFragment.this).getApplicationContext(), LoginActivity.class);
      localIntent.putExtra("flag", "0");
      PersonalUnLoginFragment.this.startActivity(localIntent);
      PersonalUnLoginFragment.this.getActivity().finish();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.PersonalUnLoginFragment
 * JD-Core Version:    0.6.0
 */