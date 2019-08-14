package com.withustudy.koudaizikao.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.f;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.withustudy.koudaizikao.a.b;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.base.AbsBaseFragment;
import com.withustudy.koudaizikao.custom.swipyrefresh.SwipyRefreshLayout;
import com.withustudy.koudaizikao.custom.swipyrefresh.SwipyRefreshLayout.a;
import com.withustudy.koudaizikao.custom.swipyrefresh.p;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.CategoryScore;
import com.withustudy.koudaizikao.entity.MockRecord;
import com.withustudy.koudaizikao.entity.Subject;
import com.withustudy.koudaizikao.entity.SubjectMockRecordW;
import com.withustudy.koudaizikao.entity.req.ReqMockList;
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.l;
import com.withustudy.koudaizikao.g.n;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SubjectSimuHistoryFm extends AbsBaseFragment
  implements AbsListView.OnScrollListener, PullToRefreshBase.f<ListView>, SwipyRefreshLayout.a
{
  private static final int h = 0;
  private static final int i = 1;
  protected boolean a;
  private View b;
  private boolean c;
  private boolean d;
  private PullToRefreshListView e;
  private SwipyRefreshLayout f;
  private boolean g = false;
  private a j;
  private Subject k;
  private SubjectMockRecordW l;
  private List<MockRecord> m = new ArrayList();
  private Handler n = new aa(this);

  private void d()
  {
    if ((!this.c) || (!this.a) || (this.d))
      return;
    this.B.a(true);
    ReqMockList localReqMockList = new ReqMockList();
    localReqMockList.setClientType(n.a());
    localReqMockList.setImei(n.d(this.y));
    localReqMockList.setNet(n.c(this.y));
    localReqMockList.setVersionName(this.E.p());
    localReqMockList.setUid(this.E.i());
    localReqMockList.setSubjectId(this.k.getId());
    c.b().ak().a(this, localReqMockList, 0);
  }

  private void e()
  {
  }

  private void f()
  {
    d();
  }

  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    try
    {
      this.k = ((Subject)getArguments().getSerializable("subject"));
      label16: this.b = View.inflate(getActivity(), 2130903109, null);
      return this.b;
    }
    catch (Exception localException)
    {
      break label16;
    }
  }

  public void a()
  {
    n.a(false, this.e, getActivity());
    this.c = true;
    d();
  }

  public void a(View paramView)
  {
    this.f = ((SwipyRefreshLayout)paramView.findViewById(2131296692));
    this.e = ((PullToRefreshListView)paramView.findViewById(2131296693));
  }

  public void a(PullToRefreshBase<ListView> paramPullToRefreshBase)
  {
  }

  public void a(p paramp)
  {
    if (paramp.equals(p.a(0)))
    {
      this.f.setRefreshing(true);
      this.n.sendEmptyMessage(0);
    }
  }

  public void a(List<String> paramList, int paramInt)
  {
  }

  public void b()
  {
    this.f.setRefreshing(true);
    this.f.setOnRefreshListener(this);
    this.e.setOnScrollListener(this);
    this.e.setOnRefreshListener(this);
  }

  public void b(PullToRefreshBase<ListView> paramPullToRefreshBase)
  {
    if (!this.g)
    {
      this.n.sendEmptyMessage(1);
      this.g = true;
    }
  }

  public void c()
  {
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0)
    {
      this.f.setEnabled(true);
      return;
    }
    this.f.setEnabled(false);
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    this.B.b();
    Gson localGson;
    if (paramString1 != null)
      localGson = c.a();
    switch (paramInt)
    {
    default:
      return;
    case 0:
    }
    try
    {
      this.l = ((SubjectMockRecordW)localGson.fromJson(paramString1, SubjectMockRecordW.class));
      if (this.l != null)
      {
        this.n.sendEmptyMessage(0);
        return;
      }
      h.a("解析宜昌");
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (getUserVisibleHint())
    {
      this.a = true;
      f();
      return;
    }
    this.a = false;
    e();
  }

  private class a extends BaseAdapter
  {
    private List<MockRecord> b;

    public a()
    {
      Object localObject;
      this.b = localObject;
    }

    public void a(List<MockRecord> paramList)
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
      SubjectSimuHistoryFm.b localb1;
      if (paramView == null)
      {
        paramView = View.inflate(SubjectSimuHistoryFm.this.getActivity(), 2130903179, null);
        SubjectSimuHistoryFm.b localb2 = new SubjectSimuHistoryFm.b(SubjectSimuHistoryFm.this);
        SubjectSimuHistoryFm.b.a(localb2, (LinearLayout)paramView.findViewById(2131297140));
        SubjectSimuHistoryFm.b.a(localb2, (TextView)paramView.findViewById(2131297138));
        SubjectSimuHistoryFm.b.b(localb2, (TextView)paramView.findViewById(2131297139));
        SubjectSimuHistoryFm.b.c(localb2, (TextView)paramView.findViewById(2131296499));
        paramView.setTag(localb2);
        localb1 = localb2;
      }
      while (true)
      {
        MockRecord localMockRecord = (MockRecord)this.b.get(paramInt);
        Object localObject = localMockRecord.getDate();
        try
        {
          String str3 = ((String)localObject).substring(0, 4);
          String str4 = ((String)localObject).substring(4, 6);
          String str5 = ((String)localObject).substring(6, ((String)localObject).length());
          localObject = "";
          String str6 = str3 + "." + str4 + "." + str5;
          localObject = str6;
          label197: SubjectSimuHistoryFm.b.a(localb1).setText((CharSequence)localObject);
          long l = localMockRecord.getCostTime();
          SubjectSimuHistoryFm.b.b(localb1).setText(l + "分钟");
          double d1 = localMockRecord.getFinalScore();
          SubjectSimuHistoryFm.b.c(localb1).setText((int)d1);
          List localList = localMockRecord.getCategoryScore();
          if ((SubjectSimuHistoryFm.b.d(localb1) != null) && (SubjectSimuHistoryFm.b.d(localb1).getChildCount() > 0))
            SubjectSimuHistoryFm.b.d(localb1).removeAllViews();
          int i;
          int k;
          if ((localList != null) && (localList.size() > 0))
          {
            i = localList.size();
            int j = (int)Math.ceil(1.0D * i / 2.0D);
            k = 0;
            if (k < j);
          }
          else
          {
            return paramView;
            localb1 = (SubjectSimuHistoryFm.b)paramView.getTag();
            continue;
          }
          LinearLayout localLinearLayout = (LinearLayout)View.inflate(SubjectSimuHistoryFm.this.getActivity(), 2130903235, null);
          TextView localTextView1 = (TextView)localLinearLayout.findViewById(2131297438);
          TextView localTextView2 = (TextView)localLinearLayout.findViewById(2131297439);
          TextView localTextView3 = (TextView)localLinearLayout.findViewById(2131297441);
          TextView localTextView4 = (TextView)localLinearLayout.findViewById(2131297442);
          int m = k * 2;
          int n = 1 + k * 2;
          if ((m >= 0) && (m < i))
          {
            CategoryScore localCategoryScore2 = (CategoryScore)localList.get(m);
            String str2 = localCategoryScore2.getCategory();
            double d4 = localCategoryScore2.getUserScore();
            double d5 = localCategoryScore2.getTotalScore();
            localTextView1.setText(str2 + ":");
            localTextView2.setText((int)d4 + "/" + (int)d5);
          }
          if ((n >= 0) && (n < i))
          {
            CategoryScore localCategoryScore1 = (CategoryScore)localList.get(n);
            String str1 = localCategoryScore1.getCategory();
            double d2 = localCategoryScore1.getUserScore();
            double d3 = localCategoryScore1.getTotalScore();
            localTextView3.setText(str1 + ":");
            localTextView4.setText((int)d2 + "/" + (int)d3);
          }
          while (true)
          {
            SubjectSimuHistoryFm.b.d(localb1).addView(localLinearLayout);
            k++;
            break;
            localTextView3.setVisibility(8);
            localTextView4.setVisibility(8);
          }
        }
        catch (Exception localException)
        {
          break label197;
        }
      }
    }
  }

  class b
  {
    private LinearLayout b;
    private TextView c;
    private TextView d;
    private TextView e;

    b()
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.SubjectSimuHistoryFm
 * JD-Core Version:    0.6.0
 */