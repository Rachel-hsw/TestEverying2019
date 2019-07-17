package com.withustudy.koudaizikao.fragment;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.http.r;
import com.google.gson.Gson;
import com.umeng.a.g;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.activity.AboutActivity;
import com.withustudy.koudaizikao.activity.ChooseProvinceActivity;
import com.withustudy.koudaizikao.activity.ChooseSubjectActivity;
import com.withustudy.koudaizikao.activity.FavoriteActivity;
import com.withustudy.koudaizikao.activity.LoginActivity;
import com.withustudy.koudaizikao.activity.MyPostActivity;
import com.withustudy.koudaizikao.activity.SimuHistoryListActivity;
import com.withustudy.koudaizikao.activity.SuggestionActivity;
import com.withustudy.koudaizikao.activity.dialog.DialogActivityUpdateNew;
import com.withustudy.koudaizikao.activity.dialog.DialogActivityUpdateNone;
import com.withustudy.koudaizikao.base.AbsBaseFragment;
import com.withustudy.koudaizikao.base.n;
import com.withustudy.koudaizikao.d.a.j;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.ChooseProToChooseSub;
import com.withustudy.koudaizikao.entity.PersonalInfo;
import com.withustudy.koudaizikao.entity.Scholarship;
import com.withustudy.koudaizikao.entity.Subject;
import com.withustudy.koudaizikao.entity.Version;
import com.withustudy.koudaizikao.entity.content.MajorContent;
import com.withustudy.koudaizikao.entity.req.MajorUpLoad;
import com.withustudy.koudaizikao.g.h;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PersonalFragment extends AbsBaseFragment
{
  private static final int R = 8;
  public static b b;
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 10;
  public static final int g = 11;
  public static final int h = 12;
  public static final int i = 3;
  public static final int j = 4;
  private LinearLayout F;
  private LinearLayout G;
  private TextView H;
  private LinearLayout I;
  private Button J;
  private PersonalLoginFragment K;
  private PersonalUnLoginFragment L;
  private PersonalInfo M = null;
  private a N;
  private boolean O;
  private TextView P;
  private ImageView Q;
  private Scholarship S;
  private boolean T;
  private com.withustudy.koudaizikao.custom.a.a U;
  private boolean V;
  public List<Subject> a;
  public boolean c;
  private ScrollView k;
  private TextView l;
  private LinearLayout m;
  private LinearLayout n;
  private LinearLayout o;
  private LinearLayout p;
  private LinearLayout q;
  private ImageView r;
  private LinearLayout s;
  private LinearLayout t;
  private LinearLayout u;
  private LinearLayout v;
  private TextView w;

  private boolean h()
  {
    if (!this.O)
    {
      Toast.makeText(this.y, getResources().getString(2131165379), 0).show();
      return false;
    }
    return this.O;
  }

  private void i()
  {
    if (this.O)
    {
      this.l.setVisibility(0);
      this.A.beginTransaction().replace(2131296985, this.K).commit();
      this.J.setVisibility(0);
      return;
    }
    this.l.setVisibility(8);
    this.A.beginTransaction().replace(2131296985, this.L).commit();
    this.J.setVisibility(8);
  }

  private void j()
  {
    this.H.setText(getResources().getString(2131165377));
    this.a.clear();
    Subject localSubject = new Subject();
    localSubject.setName(getResources().getString(2131165377));
    this.a.add(localSubject);
  }

  private void k()
  {
    int i1 = 0;
    int i2;
    if (this.a != null)
    {
      this.I.removeAllViews();
      i2 = 0;
      if (i2 < this.a.size())
        break label116;
      if ((this.a.size() != 0) && (((Subject)this.a.get(0)).getId() != null) && (!((Subject)this.a.get(0)).getId().equals("")))
      {
        if (a.j.a != null)
          break label196;
        a.j.a = new ArrayList();
      }
    }
    while (true)
    {
      if (i1 >= this.a.size())
      {
        return;
        label116: TextView localTextView = new TextView(this.y);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localTextView.setText(((Subject)this.a.get(i2)).getName());
        localTextView.setTextColor(Color.parseColor("#999999"));
        localTextView.setTextSize(2, 15.0F);
        localTextView.setLayoutParams(localLayoutParams);
        this.I.addView(localTextView);
        i2++;
        break;
        label196: a.j.a.clear();
        i1 = 0;
        continue;
      }
      a.j.a.add(((Subject)this.a.get(i1)).getId());
      i1++;
    }
  }

  private void l()
  {
    if (this.K != null)
    {
      if (!this.E.v().equals(""))
        this.K.a(this.E.v());
      if (!this.E.u().equals(""))
        this.K.b(this.E.u());
    }
  }

  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903161, null);
  }

  public void a()
  {
    try
    {
      if (!this.E.i().equals(""))
        this.O = true;
      while (true)
      {
        this.K = new PersonalLoginFragment();
        this.L = new PersonalUnLoginFragment();
        this.N = new a();
        b = new b(this);
        this.a = new ArrayList();
        if (this.O)
        {
          float f1 = this.E.a() / 100.0F;
          this.P.setText(f1 + "元");
          this.P.setVisibility(0);
          Bundle localBundle = getArguments();
          if ((localBundle == null) || (!localBundle.getBoolean("isShowScoRedDot")))
            break;
          b.sendEmptyMessage(8);
          return;
          this.O = false;
          continue;
        }
        else
        {
          this.P.setVisibility(8);
        }
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void a(View paramView)
  {
    this.k = ((ScrollView)paramView.findViewById(2131296984));
    this.l = ((TextView)paramView.findViewById(2131296983));
    this.H = ((TextView)paramView.findViewById(2131296987));
    this.I = ((LinearLayout)paramView.findViewById(2131296989));
    this.m = ((LinearLayout)paramView.findViewById(2131296986));
    this.n = ((LinearLayout)paramView.findViewById(2131296988));
    this.o = ((LinearLayout)paramView.findViewById(2131296993));
    this.p = ((LinearLayout)paramView.findViewById(2131296994));
    this.q = ((LinearLayout)paramView.findViewById(2131296995));
    this.r = ((ImageView)paramView.findViewById(2131296996));
    this.s = ((LinearLayout)paramView.findViewById(2131296997));
    this.t = ((LinearLayout)paramView.findViewById(2131296998));
    this.u = ((LinearLayout)paramView.findViewById(2131296999));
    this.v = ((LinearLayout)paramView.findViewById(2131297000));
    this.w = ((TextView)paramView.findViewById(2131297001));
    this.F = ((LinearLayout)paramView.findViewById(2131297002));
    this.G = ((LinearLayout)paramView.findViewById(2131297003));
    this.J = ((Button)paramView.findViewById(2131297004));
    this.P = ((TextView)paramView.findViewById(2131296992));
    this.Q = ((ImageView)paramView.findViewById(2131296991));
  }

  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }

  public void b()
  {
    this.w.setText(this.E.p());
    j();
    if (this.O)
    {
      if ((!this.E.r().equals("")) && (!this.E.t().equals("")))
        this.H.setText(this.E.r() + "," + this.E.t());
      this.a.clear();
      Subject localSubject = new Subject();
      localSubject.setName("正在加载");
      this.a.add(localSubject);
      k();
      com.withustudy.koudaizikao.a.a locala = c.b().N();
      String[] arrayOfString = new String[1];
      arrayOfString[0] = this.E.i();
      locala.a(this, arrayOfString, 11, this.y);
    }
  }

  public void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.O))
      b.sendEmptyMessage(8);
  }

  public void c()
  {
    this.m.setOnClickListener(this.N);
    this.H.setOnClickListener(this.N);
    this.n.setOnClickListener(this.N);
    this.I.setOnClickListener(this.N);
    this.o.setOnClickListener(this.N);
    this.p.setOnClickListener(this.N);
    this.q.setOnClickListener(this.N);
    this.s.setOnClickListener(this.N);
    this.t.setOnClickListener(this.N);
    this.u.setOnClickListener(this.N);
    this.v.setOnClickListener(this.N);
    this.F.setOnClickListener(this.N);
    this.G.setOnClickListener(this.N);
    this.J.setOnClickListener(this.N);
  }

  public boolean d()
  {
    return this.c;
  }

  public void e()
  {
    this.P.setVisibility(8);
  }

  public void f()
  {
    if (this.O)
    {
      float f1 = getActivity().getSharedPreferences("koudai", 0).getFloat("ScoMount", 0.0F) / 100.0F;
      this.P.setText(f1 + "元");
      this.P.setVisibility(0);
    }
  }

  public void onDestroy()
  {
    super.onDestroy();
    if (this.U != null)
    {
      this.U.c();
      this.U = null;
    }
  }

  public void onError(String paramString1, String paramString2, int paramInt)
  {
    super.onError(paramString1, paramString2, paramInt);
    Toast.makeText(this.y, "服务器未响应，请稍后再试", 0).show();
  }

  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (paramBoolean)
    {
      h.a(getActivity(), "onHiddenChanged");
      if (this.Q.getVisibility() == 0)
        this.Q.setVisibility(8);
    }
  }

  public void onResume()
  {
    super.onResume();
    i();
    k();
    if ((this.O) && (d()))
      this.r.setVisibility(0);
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    switch (paramInt)
    {
    default:
    case 10:
    case 11:
    case 12:
    }
    do
    {
      do
      {
        do
          return;
        while (paramString1 == null);
        try
        {
          this.M = ((PersonalInfo)c.a().fromJson(paramString1, PersonalInfo.class));
          if (this.M != null)
          {
            this.E.r(this.M.getNickname());
            this.E.q(this.M.getProfileUrl());
            l();
            return;
          }
        }
        catch (Exception localException3)
        {
          localException3.printStackTrace();
          Toast.makeText(this.y, "服务器未响应，请稍后再试", 0).show();
          return;
        }
        Toast.makeText(this.y, "服务器未能返回数据，请稍后再试", 0).show();
        return;
      }
      while (paramString1 == null);
      try
      {
        MajorContent localMajorContent = (MajorContent)c.a().fromJson(paramString1, MajorContent.class);
        if ((localMajorContent != null) && (localMajorContent.getMajor() != null) && (localMajorContent.getSubject() != null))
        {
          b.sendMessage(b.obtainMessage(1, localMajorContent));
          return;
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        b.sendEmptyMessage(2);
        return;
      }
      b.sendEmptyMessage(2);
      return;
    }
    while (paramString1 == null);
    try
    {
      Version localVersion = (Version)c.a().fromJson(paramString1, Version.class);
      if (localVersion == null)
        break label382;
      if (!localVersion.getStatus().equals("STATUS_OK"))
        break label370;
      if (!r.a)
      {
        Bundle localBundle = new Bundle();
        localBundle.putSerializable("update", localVersion);
        a(DialogActivityUpdateNew.class, 0, 0, false, localBundle);
        return;
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      Toast.makeText(this.y, "服务器未响应，请稍后再试", 0).show();
      return;
    }
    int i1 = (int)(100.0D * (r.c / r.b));
    Toast.makeText(this.y, "正在下载安装包...当前进度：" + String.valueOf(i1) + "%", 0).show();
    return;
    label370: a(DialogActivityUpdateNone.class, 0, 0, false, null);
    return;
    label382: Toast.makeText(this.y, "服务器未能返回数据，请稍后再试", 0).show();
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
      case 2131296990:
      case 2131296991:
      case 2131296992:
      case 2131296996:
      case 2131297001:
      default:
        return;
      case 2131296986:
      case 2131296987:
        g.b(PersonalFragment.e(PersonalFragment.this), "personal_choose_major");
        if (PersonalFragment.h(PersonalFragment.this))
        {
          PersonalFragment.a(PersonalFragment.this, ChooseProvinceActivity.class, 2130968591, 2130968589, false, null);
          return;
        }
        Intent localIntent5 = new Intent(PersonalFragment.e(PersonalFragment.this).getApplicationContext(), LoginActivity.class);
        localIntent5.putExtra("flag", "0");
        PersonalFragment.this.startActivity(localIntent5);
        return;
      case 2131296988:
      case 2131296989:
        g.b(PersonalFragment.e(PersonalFragment.this), "personal_choose_subject");
        if (PersonalFragment.h(PersonalFragment.this))
        {
          if ((PersonalFragment.d(PersonalFragment.this).q().equals("")) || (PersonalFragment.d(PersonalFragment.this).r().equals("")) || (PersonalFragment.d(PersonalFragment.this).s().equals("")) || (PersonalFragment.d(PersonalFragment.this).t().equals("")))
          {
            Toast.makeText(PersonalFragment.e(PersonalFragment.this), PersonalFragment.this.getResources().getString(2131165378), 0).show();
            return;
          }
          ChooseProToChooseSub localChooseProToChooseSub = new ChooseProToChooseSub();
          localChooseProToChooseSub.setProId(PersonalFragment.d(PersonalFragment.this).q());
          localChooseProToChooseSub.setProvName(PersonalFragment.d(PersonalFragment.this).r());
          localChooseProToChooseSub.setMajorId(PersonalFragment.d(PersonalFragment.this).s());
          localChooseProToChooseSub.setMajorName(PersonalFragment.d(PersonalFragment.this).t());
          Bundle localBundle3 = new Bundle();
          localBundle3.putSerializable("Major", localChooseProToChooseSub);
          PersonalFragment.a(PersonalFragment.this, ChooseSubjectActivity.class, false, localBundle3);
          return;
        }
        Intent localIntent4 = new Intent(PersonalFragment.e(PersonalFragment.this).getApplicationContext(), LoginActivity.class);
        localIntent4.putExtra("flag", "0");
        PersonalFragment.this.startActivity(localIntent4);
        return;
      case 2131296993:
        g.b(PersonalFragment.e(PersonalFragment.this), "personal_follow");
        PersonalFragment.a(PersonalFragment.this, FavoriteActivity.class, false, null);
        return;
      case 2131296994:
        g.b(PersonalFragment.e(PersonalFragment.this), "personal_history");
        PersonalFragment.a(PersonalFragment.this, SimuHistoryListActivity.class, false, null);
        return;
      case 2131296995:
        g.b(PersonalFragment.e(PersonalFragment.this), "personal_my_post");
        PersonalFragment.this.a(false);
        PersonalFragment.i(PersonalFragment.this).setVisibility(8);
        if (PersonalFragment.h(PersonalFragment.this))
        {
          Bundle localBundle2 = new Bundle();
          localBundle2.putInt("state", 100);
          PersonalFragment.a(PersonalFragment.this, MyPostActivity.class, false, localBundle2);
          return;
        }
        Intent localIntent3 = new Intent(PersonalFragment.e(PersonalFragment.this).getApplicationContext(), LoginActivity.class);
        localIntent3.putExtra("flag", "0");
        PersonalFragment.this.startActivity(localIntent3);
        return;
      case 2131296997:
        g.b(PersonalFragment.e(PersonalFragment.this), "personal_my_reply");
        if (PersonalFragment.h(PersonalFragment.this))
        {
          Bundle localBundle1 = new Bundle();
          localBundle1.putInt("state", 101);
          PersonalFragment.a(PersonalFragment.this, MyPostActivity.class, false, localBundle1);
          return;
        }
        Intent localIntent2 = new Intent(PersonalFragment.e(PersonalFragment.this).getApplicationContext(), LoginActivity.class);
        localIntent2.putExtra("flag", "0");
        PersonalFragment.this.startActivity(localIntent2);
        return;
      case 2131296998:
        PersonalFragment.a(PersonalFragment.this, SuggestionActivity.class, false, null);
        return;
      case 2131296999:
        g.b(PersonalFragment.e(PersonalFragment.this), "personal_share");
        PersonalFragment.a(PersonalFragment.this, new com.withustudy.koudaizikao.custom.a.a(PersonalFragment.this.getActivity(), PersonalFragment.j(PersonalFragment.this)));
        PersonalFragment.k(PersonalFragment.this).b();
        return;
      case 2131297000:
        g.b(PersonalFragment.e(PersonalFragment.this), "personal_update");
        com.withustudy.koudaizikao.a.a locala = c.b().O();
        PersonalFragment localPersonalFragment = PersonalFragment.this;
        String[] arrayOfString = new String[2];
        arrayOfString[0] = PersonalFragment.d(PersonalFragment.this).i();
        arrayOfString[1] = PersonalFragment.d(PersonalFragment.this).p();
        locala.a(localPersonalFragment, arrayOfString, 12, PersonalFragment.e(PersonalFragment.this));
        return;
      case 2131297002:
        g.b(PersonalFragment.e(PersonalFragment.this), "personal_android_market");
        try
        {
          Intent localIntent1 = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + PersonalFragment.e(PersonalFragment.this).getPackageName()));
          localIntent1.addFlags(268435456);
          PersonalFragment.this.startActivity(localIntent1);
          return;
        }
        catch (ActivityNotFoundException localActivityNotFoundException)
        {
          Toast.makeText(PersonalFragment.e(PersonalFragment.this), "您的手机还没有安装任何应用市场哦", 0).show();
          return;
        }
      case 2131297003:
        g.b(PersonalFragment.e(PersonalFragment.this), "personal_about");
        PersonalFragment.a(PersonalFragment.this, AboutActivity.class, false, null);
        return;
      case 2131297004:
      }
      g.b(PersonalFragment.e(PersonalFragment.this), "personal_exit");
      PersonalFragment.d(PersonalFragment.this).b(true);
      PersonalFragment.d(PersonalFragment.this).C();
      PersonalFragment.l(PersonalFragment.this);
      PersonalFragment.c(PersonalFragment.this);
      PersonalFragment.this.e();
      PersonalFragment.a(PersonalFragment.this, false);
      PersonalFragment.m(PersonalFragment.this).setVisibility(8);
      PersonalFragment.n(PersonalFragment.this).beginTransaction().replace(2131296985, new PersonalUnLoginFragment()).commit();
      PersonalFragment.j(PersonalFragment.this).setVisibility(8);
      PersonalFragment.o(PersonalFragment.this).scrollTo(0, 0);
    }
  }

  public static class b extends n<PersonalFragment>
  {
    private PersonalFragment a;

    public b(PersonalFragment paramPersonalFragment)
    {
      super();
      this.a = paramPersonalFragment;
    }

    protected void a(PersonalFragment paramPersonalFragment, Message paramMessage)
    {
      switch (paramMessage.what)
      {
      case 5:
      case 6:
      case 7:
      default:
      case 1:
      case 2:
        do
        {
          do
            return;
          while (!PersonalFragment.a(paramPersonalFragment));
          MajorContent localMajorContent = (MajorContent)paramMessage.obj;
          PersonalFragment.b(paramPersonalFragment).setText(localMajorContent.getMajor().getProvName() + "," + localMajorContent.getMajor().getMajorName());
          paramPersonalFragment.a.clear();
          paramPersonalFragment.a.addAll(localMajorContent.getSubject());
          if (paramPersonalFragment.a.size() == 0)
          {
            Subject localSubject2 = new Subject();
            localSubject2.setName(paramPersonalFragment.getResources().getString(2131165377));
            paramPersonalFragment.a.add(localSubject2);
          }
          PersonalFragment.c(paramPersonalFragment);
          PersonalFragment.d(paramPersonalFragment).m(localMajorContent.getMajor().getProvId());
          PersonalFragment.d(paramPersonalFragment).n(localMajorContent.getMajor().getProvName());
          PersonalFragment.d(paramPersonalFragment).o(localMajorContent.getMajor().getMajorId());
          PersonalFragment.d(paramPersonalFragment).p(localMajorContent.getMajor().getMajorName());
          return;
          Toast.makeText(PersonalFragment.e(paramPersonalFragment), "服务器未响应或者您还没有保存专业信息", 0).show();
        }
        while (paramPersonalFragment.a.size() != 0);
        Subject localSubject1 = new Subject();
        localSubject1.setName(paramPersonalFragment.getResources().getString(2131165377));
        paramPersonalFragment.a.add(localSubject1);
        PersonalFragment.c(paramPersonalFragment);
        return;
      case 4:
        com.withustudy.koudaizikao.a.a locala2 = c.b().J();
        String[] arrayOfString2 = new String[1];
        arrayOfString2[0] = PersonalFragment.d(paramPersonalFragment).i();
        locala2.a(paramPersonalFragment, arrayOfString2, 10, PersonalFragment.e(paramPersonalFragment));
        return;
      case 3:
        com.withustudy.koudaizikao.a.a locala1 = c.b().N();
        String[] arrayOfString1 = new String[1];
        arrayOfString1[0] = PersonalFragment.d(paramPersonalFragment).i();
        locala1.a(paramPersonalFragment, arrayOfString1, 11, PersonalFragment.e(paramPersonalFragment));
        return;
      case 8:
      }
      float f = paramPersonalFragment.getActivity().getSharedPreferences("koudai", 0).getFloat("ScoMount", 0.0F) / 100.0F;
      PersonalFragment.f(paramPersonalFragment).setText(f + "元");
      PersonalFragment.f(paramPersonalFragment).setVisibility(0);
      PersonalFragment.g(paramPersonalFragment).setVisibility(0);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.PersonalFragment
 * JD-Core Version:    0.6.0
 */