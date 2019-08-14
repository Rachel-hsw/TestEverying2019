package com.withustudy.koudaizikao.activity;

import android.os.Handler;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.google.gson.Gson;
import com.withustudy.koudaizikao.a.b;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.custom.ViewPagerIndicator;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.Subject;
import com.withustudy.koudaizikao.entity.SubjectW;
import com.withustudy.koudaizikao.entity.req.ReqMockList;
import com.withustudy.koudaizikao.fragment.SubjectSimuHistoryFm;
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.l;
import com.withustudy.koudaizikao.g.n;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SimuHistoryListActivity extends AbsBaseActivity
  implements View.OnClickListener
{
  private static final int g;
  public int a;
  private ViewPagerIndicator b;
  private ViewPager c;
  private List<String> d;
  private List<SubjectSimuHistoryFm> e = new ArrayList();
  private LinearLayout f;
  private FragmentPagerAdapter h;
  private SubjectW i;
  private List<Subject> j = new ArrayList();
  private Handler k = new bh(this);

  protected void bindData()
  {
  }

  protected void initData()
  {
    this.mProTools.a(true);
    ReqMockList localReqMockList = new ReqMockList();
    localReqMockList.setVersionName(this.mSP.p());
    localReqMockList.setClientType(n.a());
    localReqMockList.setImei(n.d(this.mContext));
    localReqMockList.setNet(n.c(this.mContext));
    localReqMockList.setUid(this.mSP.i());
    c.b().ak().a(this, localReqMockList, 0);
  }

  protected void initListener()
  {
    this.b.setOnPageChangeListener(new bj(this));
    this.f.setOnClickListener(this);
  }

  protected void initView()
  {
    this.b = ((ViewPagerIndicator)findViewById(2131296920));
    this.c = ((ViewPager)findViewById(2131296921));
    this.f = ((LinearLayout)findViewById(2131297502));
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131297502:
    }
    finish(0, 0);
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    this.mProTools.b();
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
      this.i = ((SubjectW)localGson.fromJson(paramString1, SubjectW.class));
      if (this.i != null)
      {
        this.k.sendEmptyMessage(0);
        return;
      }
      h.a("解析宜昌");
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void setContentView()
  {
    setContentView(2130903267);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.SimuHistoryListActivity
 * JD-Core Version:    0.6.0
 */