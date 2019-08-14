package com.withustudy.koudaizikao.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.withustudy.koudaizikao.a.b;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.activity.ActivityErrorListActivity;
import com.withustudy.koudaizikao.base.AbsBaseFragment;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.Chapter;
import com.withustudy.koudaizikao.entity.ErrorExercise;
import com.withustudy.koudaizikao.entity.SubjectErrorExercise;
import com.withustudy.koudaizikao.entity.SubjectErrorExerciseW;
import com.withustudy.koudaizikao.entity.Subjects;
import com.withustudy.koudaizikao.entity.req.UserSubject;
import com.withustudy.koudaizikao.g.l;
import com.withustudy.koudaizikao.g.n;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;

public class ErrorListFragement extends AbsBaseFragment
{
  private static final int F = 4;
  public static final int b = 10;
  public static final int c = 86400;
  public static final long d = 86400000L;
  private static final int l = 0;
  private static final int v = 2;
  private static final int w = 3;
  private ActivityErrorListActivity G;
  private List<String> H = new ArrayList();
  SubjectErrorExercise a;
  private View e;
  private ListView f;
  private LinearLayout g;
  private List<String> h;
  private Subjects i;
  private String j;
  private String k;
  private List<ErrorExercise> m = new ArrayList();
  private Handler n = new h(this);
  private List<ErrorExercise> o;
  private List<Map.Entry<String, List<ErrorExercise>>> p;
  private List<Map.Entry<String, List<ErrorExercise>>> q;
  private int r;
  private SubjectErrorExerciseW s;
  private a t;
  private boolean u;

  public static String a(long paramLong)
  {
    Timestamp localTimestamp = new Timestamp(paramLong);
    String[] arrayOfString = localTimestamp.split(" ")[0].split("-");
    return arrayOfString[0] + arrayOfString[1] + arrayOfString[2];
  }

  public static boolean a(long paramLong1, long paramLong2)
  {
    long l1 = paramLong1 - paramLong2;
    return (l1 < 86400000L) && (l1 > -86400000L) && (b(paramLong1) == b(paramLong2));
  }

  private boolean a(String paramString)
  {
    if ((this.H != null) && (this.H.size() > 0));
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= this.H.size())
        return false;
      if (paramString.equals((String)this.H.get(i1)))
        return true;
    }
  }

  private static long b(long paramLong)
  {
    return (paramLong + TimeZone.getDefault().getOffset(paramLong)) / 86400000L;
  }

  private void d()
  {
    this.o = new ArrayList();
    Iterator localIterator2;
    HashMap localHashMap;
    Iterator localIterator1;
    if ((this.m != null) && (this.m.size() > 0))
    {
      localIterator2 = this.m.iterator();
      if (localIterator2.hasNext());
    }
    else
    {
      if ((this.o == null) || (this.o.size() <= 0))
        break label487;
      localHashMap = new HashMap();
      new ArrayList();
      if (localHashMap != null)
        localHashMap.clear();
      if (this.q != null)
        this.q.clear();
      localIterator1 = this.o.iterator();
    }
    while (true)
    {
      if (!localIterator1.hasNext())
      {
        com.withustudy.koudaizikao.g.h.a("错题栏 ::" + localHashMap);
        this.q = new ArrayList(localHashMap.entrySet());
        Collections.sort(this.q, new j(this));
        if ((this.q != null) && (this.q.size() > 0))
        {
          Object localObject2 = (List)this.G.f.get(Integer.valueOf(this.r));
          if (localObject2 == null)
          {
            localObject2 = new ArrayList();
            this.G.f.put(Integer.valueOf(this.r), localObject2);
          }
          ((List)localObject2).clear();
          ((List)localObject2).addAll(this.q);
          if (this.t != null)
            break label479;
          this.t = new a();
          this.f.setAdapter(this.t);
        }
        return;
        ErrorExercise localErrorExercise2 = (ErrorExercise)localIterator2.next();
        boolean bool = a(localErrorExercise2.getExerciseId());
        if (bool)
        {
          com.withustudy.koudaizikao.g.h.a("sortByChapter haveDelete  " + bool);
          break;
        }
        this.o.add(localErrorExercise2);
        break;
      }
      ErrorExercise localErrorExercise1 = (ErrorExercise)localIterator1.next();
      if (localHashMap.containsKey(localErrorExercise1.getChapter().getId()))
      {
        ((List)localHashMap.get(localErrorExercise1.getChapter().getId())).add(localErrorExercise1);
        continue;
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localErrorExercise1);
      localHashMap.put(localErrorExercise1.getChapter().getId(), localArrayList);
    }
    label479: this.t.notifyDataSetChanged();
    return;
    label487: Object localObject1 = (List)this.G.f.get(Integer.valueOf(this.r));
    if (localObject1 == null)
    {
      localObject1 = new ArrayList();
      this.G.f.put(Integer.valueOf(this.r), localObject1);
    }
    ((List)localObject1).clear();
    if (this.q != null)
    {
      this.q.clear();
      ((List)localObject1).addAll(this.q);
    }
    if (this.t == null)
    {
      this.t = new a();
      this.f.setAdapter(this.t);
      return;
    }
    this.t.notifyDataSetChanged();
  }

  private void e()
  {
    this.o = new ArrayList();
    Iterator localIterator2;
    HashMap localHashMap;
    Iterator localIterator1;
    if ((this.m != null) && (this.m.size() > 0))
    {
      localIterator2 = this.m.iterator();
      if (localIterator2.hasNext());
    }
    else
    {
      if ((this.o == null) || (this.o.size() <= 0))
        break label489;
      localHashMap = new HashMap();
      new ArrayList();
      if (localHashMap != null)
        localHashMap.clear();
      if (this.p != null)
        this.p.clear();
      localIterator1 = this.o.iterator();
    }
    while (true)
    {
      if (!localIterator1.hasNext())
      {
        com.withustudy.koudaizikao.g.h.a("错题蓝=" + localHashMap);
        this.p = new ArrayList(localHashMap.entrySet());
        Collections.sort(this.p, new k(this));
        if ((this.p != null) && (this.p.size() > 0))
        {
          Object localObject2 = (List)this.G.f.get(Integer.valueOf(this.r));
          if (localObject2 == null)
          {
            localObject2 = new ArrayList();
            this.G.f.put(Integer.valueOf(this.r), localObject2);
          }
          ((List)localObject2).clear();
          ((List)localObject2).addAll(this.p);
          if (this.t != null)
            break label481;
          this.t = new a();
          this.f.setAdapter(this.t);
        }
        return;
        ErrorExercise localErrorExercise2 = (ErrorExercise)localIterator2.next();
        boolean bool = a(localErrorExercise2.getExerciseId());
        if (bool)
        {
          com.withustudy.koudaizikao.g.h.a("sortDataByTime haveDelete " + bool);
          break;
        }
        this.o.add(localErrorExercise2);
        break;
      }
      ErrorExercise localErrorExercise1 = (ErrorExercise)localIterator1.next();
      if (localHashMap.containsKey(a(localErrorExercise1.getTime())))
      {
        ((List)localHashMap.get(a(localErrorExercise1.getTime()))).add(localErrorExercise1);
        continue;
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localErrorExercise1);
      localHashMap.put(a(localErrorExercise1.getTime()), localArrayList);
    }
    label481: this.t.notifyDataSetChanged();
    return;
    label489: Object localObject1 = (List)this.G.f.get(Integer.valueOf(this.r));
    if (localObject1 == null)
    {
      localObject1 = new ArrayList();
      this.G.f.put(Integer.valueOf(this.r), localObject1);
    }
    ((List)localObject1).clear();
    if (this.p != null)
    {
      this.p.clear();
      ((List)localObject1).addAll(this.p);
    }
    if (this.t == null)
    {
      this.t = new a();
      this.f.setAdapter(this.t);
      return;
    }
    this.t.notifyDataSetChanged();
  }

  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    try
    {
      Bundle localBundle = getArguments();
      this.j = localBundle.getString("subjectId");
      this.k = localBundle.getString("subjectName");
      this.a = ((SubjectErrorExercise)localBundle.getSerializable("SubjectErrorExercise"));
      label45: this.e = View.inflate(getActivity(), 2130903154, null);
      return this.e;
    }
    catch (Exception localException)
    {
      break label45;
    }
  }

  public void a()
  {
    this.G = ((ActivityErrorListActivity)getActivity());
  }

  public void a(View paramView)
  {
    this.f = ((ListView)paramView.findViewById(2131296956));
  }

  public void a(Subjects paramSubjects, int paramInt, boolean paramBoolean)
  {
    try
    {
      this.i = paramSubjects;
      this.r = paramInt;
      if (this.t != null)
      {
        if (paramBoolean)
        {
          this.n.sendEmptyMessage(2);
          return;
        }
        this.n.sendEmptyMessage(3);
        return;
      }
      UserSubject localUserSubject = new UserSubject();
      localUserSubject.setClientType(n.a());
      localUserSubject.setImei(n.d(this.y));
      localUserSubject.setNet(n.c(this.y));
      localUserSubject.setVersionName(this.E.p());
      localUserSubject.setSubjectId(paramSubjects.getId());
      localUserSubject.setUid(this.E.i());
      c.b().am().a(this, localUserSubject, 0);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void a(ArrayList<String> paramArrayList)
  {
    this.H.addAll(paramArrayList);
    if (this.u)
    {
      this.n.sendEmptyMessage(2);
      return;
    }
    this.n.sendEmptyMessage(3);
  }

  public void a(boolean paramBoolean, int paramInt, List<String> paramList)
  {
    this.u = paramBoolean;
    this.r = paramInt;
    if (paramList != null)
    {
      this.H.clear();
      this.H.addAll(paramList);
    }
    if (paramBoolean)
    {
      this.n.sendEmptyMessage(2);
      return;
    }
    this.n.sendEmptyMessage(3);
  }

  public void b()
  {
    this.n.sendEmptyMessage(3);
  }

  public void c()
  {
    this.f.setOnItemClickListener(new i(this));
  }

  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    this.B.b();
    Gson localGson;
    if (paramString1 != null)
      localGson = c.a();
    try
    {
      this.s = ((SubjectErrorExerciseW)localGson.fromJson(paramString1, SubjectErrorExerciseW.class));
      if (this.s != null)
        this.n.sendEmptyMessage(3);
      return;
    }
    catch (Exception localException)
    {
      com.withustudy.koudaizikao.g.h.a("解析错题栏位异常  " + localException.getMessage());
      localException.printStackTrace();
    }
  }

  class a extends BaseAdapter
  {
    public a()
    {
    }

    public int getCount()
    {
      ((List)ErrorListFragement.a(ErrorListFragement.this).f.get(Integer.valueOf(ErrorListFragement.b(ErrorListFragement.this)))).size();
      return ((List)ErrorListFragement.a(ErrorListFragement.this).f.get(Integer.valueOf(ErrorListFragement.b(ErrorListFragement.this)))).size();
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
      a locala2;
      if (paramView == null)
      {
        paramView = View.inflate(ErrorListFragement.this.getActivity(), 2130903144, null);
        locala2 = new a();
        a.a(locala2, (TextView)paramView.findViewById(2131296923));
        a.b(locala2, (TextView)paramView.findViewById(2131296401));
        a.c(locala2, (TextView)paramView.findViewById(2131296929));
        paramView.setTag(locala2);
      }
      Map.Entry localEntry;
      for (a locala1 = locala2; ; locala1 = (a)paramView.getTag())
      {
        localEntry = (Map.Entry)((List)ErrorListFragement.a(ErrorListFragement.this).f.get(Integer.valueOf(ErrorListFragement.b(ErrorListFragement.this)))).get(paramInt);
        if (!ErrorListFragement.e(ErrorListFragement.this))
          break;
        a.a(locala1).setText(((List)localEntry.getValue()).size() + "道错题");
        a.b(locala1).setText(((ErrorExercise)((List)localEntry.getValue()).get(0)).getChapter().getName());
        a.c(locala1).setText("");
        a.c(locala1).setBackgroundResource(2130837811);
        return paramView;
      }
      a.a(locala1).setText(((List)localEntry.getValue()).size() + "道错题");
      a.b(locala1).setText(((ErrorExercise)((List)localEntry.getValue()).get(0)).getChapter().getName());
      a.c(locala1).setText(((ErrorExercise)((List)localEntry.getValue()).get(0)).getChapter().getSn());
      a.c(locala1).setBackgroundResource(2130838080);
      return paramView;
    }

    class a
    {
      private TextView b;
      private TextView c;
      private TextView d;

      a()
      {
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.ErrorListFragement
 * JD-Core Version:    0.6.0
 */