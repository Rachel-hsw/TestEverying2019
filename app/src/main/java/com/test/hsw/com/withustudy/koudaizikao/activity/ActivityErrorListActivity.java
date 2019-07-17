package com.withustudy.koudaizikao.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.withustudy.koudaizikao.a.b;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.custom.ViewPagerIndicator;
import com.withustudy.koudaizikao.custom.j.a;
import com.withustudy.koudaizikao.entity.Chapter;
import com.withustudy.koudaizikao.entity.ErrorExercise;
import com.withustudy.koudaizikao.entity.OpreationState;
import com.withustudy.koudaizikao.entity.SubjectErrorExerciseW;
import com.withustudy.koudaizikao.entity.Subjects;
import com.withustudy.koudaizikao.entity.SubjectsW;
import com.withustudy.koudaizikao.entity.req.FavoriteExercise;
import com.withustudy.koudaizikao.entity.req.ReqDeleteErrors;
import com.withustudy.koudaizikao.entity.req.ReqMockList;
import com.withustudy.koudaizikao.entity.req.UserSubject;
import com.withustudy.koudaizikao.fragment.ErrorListFragement;
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.l;
import com.withustudy.koudaizikao.g.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ActivityErrorListActivity extends AbsBaseActivity
  implements View.OnClickListener, j.a
{
  private static final int A = 11;
  private static final int K = 5;
  private static final int L = 12;
  private static final int M = 13;
  private static final int P = 1;
  private static final int k = 4;
  private DelelErrotReceiver B;
  private String C;
  private String D;
  private SubjectsW E;
  private SubjectErrorExerciseW F;
  private boolean G = false;
  private boolean H;
  private boolean I = false;
  private List<FavoriteExercise> J;
  private a N;
  private List<String> O;
  private List<Subjects> Q = new ArrayList();
  public List<String> a = new ArrayList();
  public HashMap<Integer, List<ErrorExercise>> b = new HashMap();
  public HashMap<Integer, List<String>> c = new HashMap();
  public List<Map.Entry<String, List<ErrorExercise>>> d;
  Handler e = new c(this);
  public HashMap<Integer, List<Map.Entry<String, List<ErrorExercise>>>> f = new HashMap();
  public List<Map.Entry<String, List<ErrorExercise>>> g = new ArrayList();
  private ViewPagerIndicator h;
  private ViewPager i;
  private List<ErrorListFragement> j = new ArrayList();
  private ImageButton l;
  private ImageButton m;
  private ImageButton n;
  private LinearLayout o;
  private LinearLayout p;
  private TextView q;
  private TextView r;
  private ListView s;
  private Button t;
  private int u;
  private LinearLayout v;
  private LinearLayout w;
  private List<String> x = new ArrayList();
  private FragmentPagerAdapter y;
  private HashMap<Integer, Boolean> z;

  private void a()
  {
    this.B = new DelelErrotReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.koudai.delete_excers");
    registerReceiver(this.B, localIntentFilter);
  }

  private void b()
  {
    int i1 = 0;
    try
    {
      List localList = (List)this.f.get(Integer.valueOf(this.u));
      if (this.I)
      {
        if ((localList != null) && (localList.size() > 0))
        {
          int i2 = localList.size();
          while (true)
          {
            if (i1 >= i2)
            {
              this.n.setBackgroundResource(2130837807);
              this.e.sendEmptyMessage(1);
              return;
            }
            this.z.put(Integer.valueOf(i1), Boolean.valueOf(true));
            i1++;
          }
        }
      }
      else if ((localList != null) && (localList.size() > 0))
      {
        int i3 = localList.size();
        for (int i4 = 0; ; i4++)
        {
          if (i4 >= i3)
          {
            this.n.setBackgroundResource(2130838198);
            this.e.sendEmptyMessage(1);
            return;
          }
          this.z.put(Integer.valueOf(i4), Boolean.valueOf(false));
        }
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void c()
  {
    if (this.H)
    {
      if (this.H);
      for (boolean bool = false; ; bool = true)
      {
        this.H = bool;
        this.o.setVisibility(0);
        this.p.setVisibility(8);
        this.m.setVisibility(0);
        this.l.setVisibility(0);
        h();
        return;
      }
    }
    finish(0, 0);
  }

  private void d()
  {
    while (true)
    {
      int i1;
      try
      {
        if (this.H)
        {
          List localList = (List)this.f.get(Integer.valueOf(this.u));
          if ((localList != null) && (localList.size() > 0))
          {
            this.d = new ArrayList();
            i1 = 0;
            if (i1 < localList.size())
              continue;
            h.a(Integer.valueOf(this.d.size()));
            ReqDeleteErrors localReqDeleteErrors = new ReqDeleteErrors();
            localReqDeleteErrors.setVersionName(this.mSP.p());
            localReqDeleteErrors.setClientType(n.a());
            localReqDeleteErrors.setImei(n.d(this.mContext));
            localReqDeleteErrors.setNet(n.c(this.mContext));
            UserSubject localUserSubject = new UserSubject();
            localUserSubject.setSubjectId(this.C);
            localUserSubject.setUid(this.mSP.i());
            localReqDeleteErrors.setUserSubject(localUserSubject);
            localReqDeleteErrors.setExerciseId((List)this.c.get(Integer.valueOf(this.u)));
            this.mProTools.a(true);
            com.withustudy.koudaizikao.a.c.b().an().a(this, localReqDeleteErrors, 12);
            return;
            Boolean localBoolean = (Boolean)this.z.get(Integer.valueOf(i1));
            Map.Entry localEntry = (Map.Entry)localList.get(i1);
            if ((localBoolean != null) && (localBoolean.booleanValue()))
              continue;
            this.d.add(localEntry);
            break label386;
            Iterator localIterator = ((List)localEntry.getValue()).iterator();
            if (!localIterator.hasNext())
              break label386;
            String str = ((ErrorExercise)localIterator.next()).getExerciseId();
            Object localObject = (List)this.c.get(Integer.valueOf(this.u));
            if (localObject != null)
              continue;
            localObject = new ArrayList();
            this.c.put(Integer.valueOf(this.u), localObject);
            if (((List)localObject).contains(str))
              continue;
            ((List)localObject).add(str);
            continue;
          }
        }
      }
      catch (Exception localException)
      {
      }
      return;
      label386: i1++;
    }
  }

  private void e()
  {
    if (this.H)
    {
      this.o.setVisibility(8);
      this.p.setVisibility(0);
      this.m.setVisibility(8);
      this.l.setVisibility(8);
      f();
      return;
    }
    this.o.setVisibility(0);
    this.p.setVisibility(8);
    h();
  }

  private void f()
  {
    if ((this.a != null) && (this.a.size() > 0))
      this.q.setText((CharSequence)this.a.get(this.u));
    List localList = (List)this.f.get(Integer.valueOf(this.u));
    int i1;
    int i2;
    int i3;
    if ((localList != null) && (localList.size() > 0))
    {
      i1 = localList.size();
      i2 = 0;
      i3 = 0;
    }
    while (true)
    {
      if (i2 >= i1)
      {
        this.r.setText(i3 + "道错题");
        if (this.z == null)
          this.z = new HashMap();
        this.e.sendEmptyMessage(1);
        return;
      }
      i3 += ((List)((Map.Entry)localList.get(i2)).getValue()).size();
      i2++;
    }
  }

  private void g()
  {
    if (this.G)
      this.l.setBackgroundResource(2130837806);
    while (true)
    {
      h();
      return;
      this.l.setBackgroundResource(2130837812);
    }
  }

  private void h()
  {
    if ((this.j != null) && (this.j.size() > 0))
      if ((this.c == null) || (this.c.size() <= 0))
        break label83;
    label83: for (List localList = (List)this.c.get(Integer.valueOf(this.u)); ; localList = null)
    {
      ((ErrorListFragement)this.j.get(this.u)).a(this.G, this.u, localList);
      return;
    }
  }

  public void a(int paramInt)
  {
    if (paramInt >= 0)
      try
      {
        if (paramInt > -1 + this.j.size())
          return;
        ((ErrorListFragement)this.j.get(paramInt)).a((Subjects)this.Q.get(paramInt), paramInt, this.G);
        return;
      }
      catch (Exception localException)
      {
      }
  }

  protected void bindData()
  {
  }

  protected void initData()
  {
    try
    {
      a();
      Intent localIntent = getIntent();
      if (localIntent != null)
      {
        Bundle localBundle = localIntent.getExtras();
        if (localBundle != null)
        {
          this.C = localBundle.getString("subjectId");
          this.D = localBundle.getString("subjectName");
        }
      }
      this.mProTools.a(true);
      ReqMockList localReqMockList = new ReqMockList();
      localReqMockList.setVersionName(this.mSP.p());
      localReqMockList.setClientType(n.a());
      localReqMockList.setImei(n.d(this.mContext));
      localReqMockList.setNet(n.c(this.mContext));
      localReqMockList.setUid(this.mSP.i());
      localReqMockList.setSubjectId(this.C);
      this.mProTools.a(true);
      com.withustudy.koudaizikao.a.c.b().am().a(this, localReqMockList, 11);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void initListener()
  {
    this.l.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.v.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.h.setOnPageChangeListener(new e(this));
    this.s.setOnItemClickListener(new f(this));
  }

  protected void initView()
  {
    this.h = ((ViewPagerIndicator)findViewById(2131296920));
    this.i = ((ViewPager)findViewById(2131296921));
    this.l = ((ImageButton)findViewById(2131296917));
    this.m = ((ImageButton)findViewById(2131296918));
    this.n = ((ImageButton)findViewById(2131296924));
    this.o = ((LinearLayout)findViewById(2131296919));
    this.p = ((LinearLayout)findViewById(2131296922));
    this.q = ((TextView)findViewById(2131296401));
    this.r = ((TextView)findViewById(2131296923));
    this.s = ((ListView)findViewById(2131296925));
    this.t = ((Button)findViewById(2131296926));
    this.v = ((LinearLayout)findViewById(2131296916));
    this.w = ((LinearLayout)findViewById(2131296469));
  }

  public void onClick(View paramView)
  {
    while (true)
    {
      try
      {
        switch (paramView.getId())
        {
        case 2131296917:
          boolean bool5 = this.G;
          bool6 = false;
          if (!bool5)
            break;
          this.G = bool6;
          g();
          return;
        case 2131296918:
          boolean bool3 = this.H;
          bool4 = false;
          if (!bool3)
            break label155;
          this.H = bool4;
          e();
          return;
        case 2131296924:
          boolean bool1 = this.I;
          bool2 = false;
          if (!bool1)
            break label161;
          this.I = bool2;
          b();
          return;
        case 2131296926:
          d();
          return;
        case 2131296916:
          c();
        case 2131296919:
        case 2131296920:
        case 2131296921:
        case 2131296922:
        case 2131296923:
        case 2131296925:
        default:
          return;
        }
      }
      catch (Exception localException)
      {
        return;
      }
      boolean bool6 = true;
      continue;
      label155: boolean bool4 = true;
      continue;
      label161: boolean bool2 = true;
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
    try
    {
      if (this.B != null)
      {
        unregisterReceiver(this.B);
        this.B = null;
      }
      this.mProTools.b();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    this.mProTools.b();
    if (paramString1 != null);
    try
    {
      Gson localGson = com.withustudy.koudaizikao.a.c.a();
      switch (paramInt)
      {
      case 11:
        this.F = ((SubjectErrorExerciseW)localGson.fromJson(paramString1, SubjectErrorExerciseW.class));
        if (this.F != null)
        {
          this.e.sendEmptyMessage(11);
          return;
        }
        h.a("sw为null");
        return;
      case 12:
        OpreationState localOpreationState = (OpreationState)localGson.fromJson(paramString1, OpreationState.class);
        if (localOpreationState == null)
          break;
        if ("OK".equals(localOpreationState.getStatus()))
        {
          this.e.sendEmptyMessage(5);
          return;
        }
        this.e.sendEmptyMessage(13);
      case 4:
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void setContentView()
  {
    setContentView(2130903143);
  }

  public class DelelErrotReceiver extends BroadcastReceiver
  {
    public DelelErrotReceiver()
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      h.a("删除刷题id  DelelErrotReceiver");
      ArrayList localArrayList = (ArrayList)paramIntent.getExtras().getSerializable("deleteIdList");
      ((ErrorListFragement)ActivityErrorListActivity.d(ActivityErrorListActivity.this).get(ActivityErrorListActivity.k(ActivityErrorListActivity.this))).a(localArrayList);
    }
  }

  class a extends BaseAdapter
  {
    public a()
    {
    }

    public int getCount()
    {
      List localList = (List)ActivityErrorListActivity.this.f.get(Integer.valueOf(ActivityErrorListActivity.k(ActivityErrorListActivity.this)));
      if (localList == null)
        return 0;
      return localList.size();
    }

    public Object getItem(int paramInt)
    {
      return null;
    }

    public long getItemId(int paramInt)
    {
      return 0L;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      a locala1;
      Map.Entry localEntry;
      if (paramView == null)
      {
        paramView = View.inflate(ActivityErrorListActivity.this.getApplicationContext(), 2130903144, null);
        a locala2 = new a();
        a.a(locala2, (TextView)paramView.findViewById(2131296923));
        a.b(locala2, (TextView)paramView.findViewById(2131296401));
        a.c(locala2, (TextView)paramView.findViewById(2131296929));
        a.a(locala2, (ImageView)paramView.findViewById(2131296928));
        paramView.setTag(locala2);
        locala1 = locala2;
        localEntry = (Map.Entry)((List)ActivityErrorListActivity.this.f.get(Integer.valueOf(ActivityErrorListActivity.k(ActivityErrorListActivity.this)))).get(paramInt);
        if (!ActivityErrorListActivity.o(ActivityErrorListActivity.this))
          break label288;
        a.a(locala1).setText(((ErrorExercise)((List)localEntry.getValue()).get(0)).getChapter().getName());
        a.b(locala1).setText("");
        a.b(locala1).setBackgroundResource(2130837811);
      }
      while (true)
      {
        a.c(locala1).setText(((List)localEntry.getValue()).size() + "道错题");
        Boolean localBoolean = (Boolean)ActivityErrorListActivity.j(ActivityErrorListActivity.this).get(Integer.valueOf(paramInt));
        if ((localBoolean == null) || (!localBoolean.booleanValue()))
          break label358;
        a.d(locala1).setBackgroundResource(2130837807);
        return paramView;
        locala1 = (a)paramView.getTag();
        break;
        label288: a.a(locala1).setText(((ErrorExercise)((List)localEntry.getValue()).get(0)).getChapter().getName());
        a.b(locala1).setText(paramInt + 1);
        a.b(locala1).setBackgroundResource(2130838080);
      }
      label358: a.d(locala1).setBackgroundResource(2130838198);
      return paramView;
    }

    class a
    {
      private TextView b;
      private TextView c;
      private TextView d;
      private ImageView e;

      a()
      {
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.ActivityErrorListActivity
 * JD-Core Version:    0.6.0
 */