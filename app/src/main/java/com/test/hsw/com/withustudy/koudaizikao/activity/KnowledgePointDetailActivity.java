package com.withustudy.koudaizikao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.gson.Gson;
import com.umeng.a.g;
import com.withustudy.koudaizikao.a.b;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.KpointDetails;
import com.withustudy.koudaizikao.entity.KpointDetailsW;
import com.withustudy.koudaizikao.entity.Section;
import com.withustudy.koudaizikao.entity.UrlShortBean;
import com.withustudy.koudaizikao.entity.req.ReqKowledgeExplain;
import com.withustudy.koudaizikao.entity.req.UserSubject;
import com.withustudy.koudaizikao.fragment.FragmentKPoint;
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.l;
import com.withustudy.koudaizikao.g.n;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class KnowledgePointDetailActivity extends AbsBaseActivity
  implements View.OnClickListener
{
  private static final int b = 101;
  public String a;
  private ViewPager c;
  private LinearLayout d;
  private ImageButton e;
  private int f;
  private String g;
  private String h;
  private String i;
  private Bundle j;
  private TextView k;
  private KpointDetailsW l;
  private UrlShortBean m;
  private FragmentPagerAdapter n;
  private List<FragmentKPoint> o = new ArrayList();
  private List<KpointDetails> p = new ArrayList();
  private List<KpointDetails> q = new ArrayList();
  private com.withustudy.koudaizikao.custom.a.a r;
  private Handler s = new ai(this);

  protected void a(int paramInt)
  {
    this.f = paramInt;
    ((FragmentKPoint)this.o.get(paramInt)).a((KpointDetails)this.q.get(paramInt), this.q);
  }

  public void b(int paramInt)
  {
    this.c.setCurrentItem(paramInt);
  }

  protected void bindData()
  {
  }

  protected void initData()
  {
    this.j = getIntent().getExtras();
    try
    {
      this.a = this.j.getString("subjectId");
      this.g = this.j.getString("sectionId");
      this.h = this.j.getString("sectionName");
      this.i = this.j.getString("sectionSn");
      label63: this.k.setText(this.h);
      this.mProTools.a(true);
      ReqKowledgeExplain localReqKowledgeExplain = new ReqKowledgeExplain();
      localReqKowledgeExplain.setVersionName(this.mSP.p());
      localReqKowledgeExplain.setClientType(n.a());
      localReqKowledgeExplain.setImei(n.d(this.mContext));
      localReqKowledgeExplain.setNet(n.c(this.mContext));
      UserSubject localUserSubject = new UserSubject();
      localUserSubject.setSubjectId(this.a);
      localUserSubject.setUid(this.mSP.i());
      localReqKowledgeExplain.setUserSubject(localUserSubject);
      Section localSection = new Section();
      localSection.setId(this.g);
      localSection.setName(this.h);
      localSection.setSn(this.i);
      localReqKowledgeExplain.setSection(localSection);
      c.b().w().a(this, localReqKowledgeExplain, 0);
      return;
    }
    catch (Exception localException)
    {
      break label63;
    }
  }

  protected void initListener()
  {
    this.e.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.c.setOnPageChangeListener(new ak(this));
  }

  protected void initView()
  {
    this.c = ((ViewPager)findViewById(2131296565));
    this.d = ((LinearLayout)findViewById(2131296560));
    this.e = ((ImageButton)findViewById(2131296564));
    this.k = ((TextView)findViewById(2131296561));
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131296560:
      finish();
      return;
    case 2131296564:
    }
    g.b(this.mContext, "brush_k_share");
    String str = "?subjectid=" + this.a;
    com.withustudy.koudaizikao.a.a locala = c.b().at();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = ("http://share.kdzikao.com/brush/share.page" + str);
    locala.a(this, arrayOfString, 101, this);
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (this.r != null)
    {
      this.r.c();
      this.r = null;
    }
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
      try
      {
        this.l = ((KpointDetailsW)localGson.fromJson(paramString1, KpointDetailsW.class));
        if (this.l != null)
        {
          this.s.sendEmptyMessage(0);
          return;
        }
      }
      catch (Exception localException)
      {
        h.a("知识点详情解析异常" + localException.getMessage());
        return;
      }
      h.a("知识点详情解析为null");
      return;
    case 101:
    }
    this.m = ((UrlShortBean)localGson.fromJson(paramString1, UrlShortBean.class));
    if (this.m != null)
    {
      this.s.sendEmptyMessage(101);
      return;
    }
    h.a("加密url异常");
  }

  protected void setContentView()
  {
    setContentView(2130903090);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.KnowledgePointDetailActivity
 * JD-Core Version:    0.6.0
 */