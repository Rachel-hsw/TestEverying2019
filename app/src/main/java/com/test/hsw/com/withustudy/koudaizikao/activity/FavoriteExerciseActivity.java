package com.withustudy.koudaizikao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.f;
import com.withustudy.koudaizikao.a.a;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.b.k;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.base.m;
import com.withustudy.koudaizikao.custom.swipyrefresh.SwipyRefreshLayout;
import com.withustudy.koudaizikao.custom.swipyrefresh.SwipyRefreshLayout.a;
import com.withustudy.koudaizikao.custom.swipyrefresh.p;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.ExerciseSummary;
import com.withustudy.koudaizikao.entity.ExerciseSummaryCollect;
import com.withustudy.koudaizikao.entity.Subject;
import com.withustudy.koudaizikao.entity.SubjectFavoriteExercise;
import com.withustudy.koudaizikao.entity.SubjectFavoriteExerciseW;
import com.withustudy.koudaizikao.entity.req.FavoriteExercise;
import com.withustudy.koudaizikao.entity.req.GetCollectExcercises;
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.n;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FavoriteExerciseActivity extends AbsBaseActivity
  implements View.OnClickListener, SwipyRefreshLayout.a
{
  public static final int a = 1;
  public static final int b = 2;
  public static final String c = "pro";
  public static final String d = "information";
  public static final String e = "forum";
  private static final int p = 0;
  private static final int q = 1;
  private static final int r = 2;
  private static final int s = 3;
  private static final int t = 4;
  private static final int u = 5;
  private List A = new ArrayList();
  private List<ExerciseSummary> B = new ArrayList();
  private List C = new ArrayList();
  private List D = new ArrayList();
  private List<SubjectFavoriteExercise> E = new ArrayList();
  private c F;
  private ListView f;
  private k g;
  private List<String> h;
  private a i;
  private b j;
  private boolean k = false;
  private boolean l = false;
  private SwipyRefreshLayout m;
  private ExerciseSummaryCollect n;
  private String o = "pro";
  private LinearLayout v;
  private Button w;
  private String x;
  private String y;
  private SubjectFavoriteExerciseW z;

  private void a(int paramInt)
  {
    this.f.setOnItemClickListener(this.i);
    String str = this.mSP.i();
    switch (paramInt)
    {
    default:
      return;
    case 0:
    }
    this.o = "pro";
    c.b().n().a(this, new String[] { str, "12", "EXERCISE" }, 0, this.mContext);
  }

  public void a(p paramp)
  {
  }

  public void bindData()
  {
    GetCollectExcercises localGetCollectExcercises = new GetCollectExcercises();
    localGetCollectExcercises.setClientType(n.a());
    localGetCollectExcercises.setImei(n.d(this.mContext));
    localGetCollectExcercises.setNet(n.c(this.mContext));
    localGetCollectExcercises.setVersionName(this.mSP.p());
    localGetCollectExcercises.setUid(this.mSP.i());
    localGetCollectExcercises.setSubjectId(this.x);
    c.b().ae().a(this, localGetCollectExcercises, 0);
  }

  public void initData()
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      Bundle localBundle = localIntent.getExtras();
      if (localBundle != null)
      {
        this.x = localBundle.getString("subjectId");
        this.y = localBundle.getString("subjectName");
      }
    }
    this.j = new b(this);
    this.i = new a();
  }

  public void initListener()
  {
    this.w.setOnClickListener(this);
  }

  protected void initView()
  {
    this.f = ((ListView)findViewById(2131296958));
    this.v = ((LinearLayout)findViewById(2131296469));
    this.w = ((Button)findViewById(2131296957));
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131296957:
    }
    finish();
  }

  public void onResume()
  {
    super.onResume();
  }

  public void onStart()
  {
    super.onStart();
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    Gson localGson;
    if (paramString1 != null)
      localGson = c.a();
    switch (paramInt)
    {
    case 2:
    case 3:
    case 4:
    case 5:
    default:
      return;
    case 0:
    case 1:
    }
    try
    {
      this.z = ((SubjectFavoriteExerciseW)localGson.fromJson(paramString1, SubjectFavoriteExerciseW.class));
      if (this.z != null)
      {
        this.j.sendEmptyMessage(paramInt);
        return;
      }
    }
    catch (Exception localException)
    {
      h.a("收藏主界面数据实体解析异常:" + localException.getMessage());
      return;
    }
    h.a("收藏主界面数据解析实体bean为null");
  }

  protected void setContentView()
  {
    setContentView(2130903155);
  }

  class a
    implements AdapterView.OnItemClickListener, PullToRefreshBase.f<ListView>
  {
    a()
    {
    }

    public void a(PullToRefreshBase<ListView> paramPullToRefreshBase)
    {
      if (!FavoriteExerciseActivity.l(FavoriteExerciseActivity.this))
      {
        String str = FavoriteExerciseActivity.m(FavoriteExerciseActivity.this).i();
        c.b().n().a(FavoriteExerciseActivity.this, new String[] { str, "12", "EXERCISE" }, 0, FavoriteExerciseActivity.n(FavoriteExerciseActivity.this));
        FavoriteExerciseActivity.b(FavoriteExerciseActivity.this, true);
      }
    }

    public void b(PullToRefreshBase<ListView> paramPullToRefreshBase)
    {
      if (!FavoriteExerciseActivity.o(FavoriteExerciseActivity.this))
      {
        String str = FavoriteExerciseActivity.m(FavoriteExerciseActivity.this).i();
        c.b().n().a(FavoriteExerciseActivity.this, new String[] { str, "12", "EXERCISE" }, 1, FavoriteExerciseActivity.n(FavoriteExerciseActivity.this));
        FavoriteExerciseActivity.a(FavoriteExerciseActivity.this, true);
      }
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      if (FavoriteExerciseActivity.f(FavoriteExerciseActivity.this).equals("pro"))
      {
        FavoriteExerciseActivity.this.startNewActivity(QuestionDetailActivity.class, 2130968591, 2130968589, false, null);
        return;
      }
      FavoriteExerciseActivity.this.startNewActivity(InformationDetailActivity.class, 2130968591, 2130968589, false, null);
    }
  }

  private static class b extends m<FavoriteExerciseActivity>
  {
    public b(FavoriteExerciseActivity paramFavoriteExerciseActivity)
    {
      super();
    }

    protected void a(FavoriteExerciseActivity paramFavoriteExerciseActivity, Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
      case 1:
      case 0:
      }
      label141: 
      do
      {
        return;
        List localList2 = FavoriteExerciseActivity.a(paramFavoriteExerciseActivity).getExerciseSummary();
        FavoriteExerciseActivity.b(paramFavoriteExerciseActivity).setRefreshing(false);
        if ((localList2 != null) && (localList2.size() > 0))
        {
          FavoriteExerciseActivity.c(paramFavoriteExerciseActivity).addAll(localList2);
          FavoriteExerciseActivity.d(paramFavoriteExerciseActivity).clear();
          FavoriteExerciseActivity.d(paramFavoriteExerciseActivity).addAll(FavoriteExerciseActivity.c(paramFavoriteExerciseActivity));
          if (FavoriteExerciseActivity.e(paramFavoriteExerciseActivity) != null)
            break label141;
          FavoriteExerciseActivity.a(paramFavoriteExerciseActivity, new k(paramFavoriteExerciseActivity, FavoriteExerciseActivity.d(paramFavoriteExerciseActivity), false, FavoriteExerciseActivity.f(paramFavoriteExerciseActivity)));
          FavoriteExerciseActivity.g(paramFavoriteExerciseActivity).setAdapter(FavoriteExerciseActivity.e(paramFavoriteExerciseActivity));
        }
        while (true)
        {
          FavoriteExerciseActivity.a(paramFavoriteExerciseActivity, false);
          return;
          FavoriteExerciseActivity.e(paramFavoriteExerciseActivity).a("pro");
          FavoriteExerciseActivity.e(paramFavoriteExerciseActivity).notifyDataSetChanged();
        }
      }
      while (FavoriteExerciseActivity.h(paramFavoriteExerciseActivity) == null);
      List localList1 = FavoriteExerciseActivity.h(paramFavoriteExerciseActivity).getSubjectFavoriteExercise();
      if ((localList1 != null) && (localList1.size() > 0))
      {
        FavoriteExerciseActivity.g(paramFavoriteExerciseActivity).setVisibility(0);
        FavoriteExerciseActivity.i(paramFavoriteExerciseActivity).setVisibility(8);
        FavoriteExerciseActivity.j(paramFavoriteExerciseActivity).clear();
        FavoriteExerciseActivity.j(paramFavoriteExerciseActivity).addAll(localList1);
        if (FavoriteExerciseActivity.k(paramFavoriteExerciseActivity) == null)
        {
          paramFavoriteExerciseActivity.getClass();
          FavoriteExerciseActivity.a(paramFavoriteExerciseActivity, new FavoriteExerciseActivity.c(paramFavoriteExerciseActivity, FavoriteExerciseActivity.j(paramFavoriteExerciseActivity)));
          FavoriteExerciseActivity.g(paramFavoriteExerciseActivity).setAdapter(FavoriteExerciseActivity.k(paramFavoriteExerciseActivity));
          return;
        }
        FavoriteExerciseActivity.k(paramFavoriteExerciseActivity).notifyDataSetChanged();
        return;
      }
      FavoriteExerciseActivity.j(paramFavoriteExerciseActivity).clear();
      if (FavoriteExerciseActivity.k(paramFavoriteExerciseActivity) == null)
      {
        paramFavoriteExerciseActivity.getClass();
        FavoriteExerciseActivity.a(paramFavoriteExerciseActivity, new FavoriteExerciseActivity.c(paramFavoriteExerciseActivity, FavoriteExerciseActivity.j(paramFavoriteExerciseActivity)));
        FavoriteExerciseActivity.g(paramFavoriteExerciseActivity).setAdapter(FavoriteExerciseActivity.k(paramFavoriteExerciseActivity));
      }
      while (true)
      {
        FavoriteExerciseActivity.g(paramFavoriteExerciseActivity).setVisibility(8);
        FavoriteExerciseActivity.i(paramFavoriteExerciseActivity).setVisibility(0);
        return;
        FavoriteExerciseActivity.k(paramFavoriteExerciseActivity).notifyDataSetChanged();
      }
    }
  }

  class c extends BaseAdapter
  {
    private List b;

    public c(List arg2)
    {
      Object localObject;
      this.b = localObject;
    }

    public void a(List paramList)
    {
      this.b = paramList;
    }

    public int getCount()
    {
      if (this.b == null)
        return 0;
      return this.b.size();
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
      SubjectFavoriteExercise localSubjectFavoriteExercise;
      FavoriteExercise localFavoriteExercise;
      if (paramView == null)
      {
        paramView = View.inflate(FavoriteExerciseActivity.this, 2130903130, null);
        a locala2 = new a();
        a.a(locala2, (TextView)paramView.findViewById(2131296863));
        a.b(locala2, (TextView)paramView.findViewById(2131296864));
        paramView.setTag(locala2);
        locala1 = locala2;
        localSubjectFavoriteExercise = (SubjectFavoriteExercise)this.b.get(paramInt);
        Subject localSubject = localSubjectFavoriteExercise.getSubject();
        a.a(locala1).setText(localSubject.getName());
        List localList = localSubjectFavoriteExercise.getFavoriteExercise();
        if ((localList == null) || (localList.size() <= 0))
          break label186;
        localFavoriteExercise = (FavoriteExercise)localList.get(0);
        if (localFavoriteExercise == null)
          break label186;
      }
      label186: for (String str = com.withustudy.koudaizikao.g.b.a(localFavoriteExercise.getTime()); ; str = "0")
      {
        a.b(locala1).setText(str);
        paramView.setOnClickListener(new r(this, localSubjectFavoriteExercise));
        return paramView;
        locala1 = (a)paramView.getTag();
        break;
      }
    }

    class a
    {
      private TextView b;
      private TextView c;

      a()
      {
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.FavoriteExerciseActivity
 * JD-Core Version:    0.6.0
 */