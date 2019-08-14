package com.withustudy.koudaizikao.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.http.l;
import com.google.gson.Gson;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.Chapter;
import com.withustudy.koudaizikao.entity.ChapterKpointSummary;
import com.withustudy.koudaizikao.entity.ChapterKpointSummaryW;
import com.withustudy.koudaizikao.entity.Section;
import com.withustudy.koudaizikao.entity.SectionKpointSummary;
import com.withustudy.koudaizikao.entity.UrlShortBean;
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.j;
import com.withustudy.koudaizikao.g.n;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressLint({"ShowToast"})
public class KnowledgeExplainActivity extends AbsBaseActivity
  implements View.OnClickListener
{
  private static final int b = 101;
  private ImageView A;
  private TextView B;
  private TextView C;
  private boolean D = false;
  private ChapterKpointSummaryW E;
  private UrlShortBean F;
  private a G;
  private HashMap<Integer, Boolean> H = new HashMap();
  private com.withustudy.koudaizikao.custom.a.a I;
  private Handler J = new ab(this);
  public HashMap<String, String> a = new ac(this);
  private ListView c;
  private l d = null;
  private com.withustudy.koudaizikao.c.a<ChapterKpointSummary> e;
  private ImageButton f;
  private RelativeLayout g;
  private RelativeLayout h;
  private LinearLayout i;
  private Button j;
  private PopupWindow k;
  private Button l;
  private Button m;
  private ImageButton n;
  private TextView o;
  private Bundle p;
  private String q;
  private String r;
  private boolean s;
  private RelativeLayout t;
  private LinearLayout u;
  private LinearLayout v;
  private ImageButton w;
  private ImageButton x;
  private ImageButton y;
  private Button z;

  private void a()
  {
    try
    {
      ad localad = new ad(this);
      this.J.post(localad);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void b()
  {
    try
    {
      if (this.k != null)
      {
        this.k.dismiss();
        this.k = null;
      }
      View localView = getLayoutInflater().inflate(2130903125, null);
      this.t = ((RelativeLayout)localView.findViewById(2131296836));
      this.v = ((LinearLayout)localView.findViewById(2131296843));
      this.u = ((LinearLayout)localView.findViewById(2131296840));
      this.A = ((ImageView)localView.findViewById(2131296837));
      this.B = ((TextView)localView.findViewById(2131296838));
      this.C = ((TextView)localView.findViewById(2131296839));
      if (this.D)
      {
        this.v.setVisibility(0);
        this.u.setVisibility(8);
        this.w = ((ImageButton)localView.findViewById(2131296844));
        this.x = ((ImageButton)localView.findViewById(2131296845));
        this.y = ((ImageButton)localView.findViewById(2131296846));
        this.z = ((Button)localView.findViewById(2131296847));
        this.y.setOnClickListener(this);
        this.x.setOnClickListener(this);
        this.w.setOnClickListener(this);
        this.z.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.B.setVisibility(8);
        this.C.setText("号召更多的小伙伴来学习吧~");
        this.C.setVisibility(0);
        this.A.setBackgroundResource(2130837908);
        localView.setFocusable(true);
        localView.setFocusableInTouchMode(true);
        if (!this.D)
          break label489;
      }
      label489: for (this.k = new PopupWindow(localView, this.mSP.y(), n.a(this, 650.0F)); ; this.k = new PopupWindow(localView, this.mSP.y(), n.a(this, 450.0F)))
      {
        this.k.setAnimationStyle(2131231021);
        this.k.setFocusable(true);
        localView.setOnKeyListener(new ae(this));
        this.k.showAtLocation(this.c, 80, 0, 0);
        a(0.6F);
        return;
        this.u.setVisibility(0);
        this.v.setVisibility(8);
        this.B.setVisibility(0);
        this.B.setText("上次错题知识点");
        this.C.setText("小袋已经下载到本地了");
        this.C.setVisibility(0);
        this.A.setBackgroundResource(2130838223);
        this.l = ((Button)localView.findViewById(2131296841));
        this.l.setText("选择章节");
        this.m = ((Button)localView.findViewById(2131296842));
        this.m.setText("继续上次复习");
        this.l.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.t.setOnClickListener(this);
        break;
      }
    }
    catch (Exception localException)
    {
    }
  }

  private void c()
  {
    if (this.k != null)
    {
      this.k.dismiss();
      this.k = null;
    }
    a(1.0F);
    this.D = false;
  }

  public void a(float paramFloat)
  {
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    localLayoutParams.alpha = paramFloat;
    getWindow().setAttributes(localLayoutParams);
  }

  protected void bindData()
  {
  }

  // ERROR //
  protected void initData()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 316	com/withustudy/koudaizikao/activity/KnowledgeExplainActivity:getIntent	()Landroid/content/Intent;
    //   4: astore_2
    //   5: aload_0
    //   6: aload_2
    //   7: invokevirtual 322	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   10: putfield 110	com/withustudy/koudaizikao/activity/KnowledgeExplainActivity:p	Landroid/os/Bundle;
    //   13: aload_0
    //   14: aload_0
    //   15: getfield 110	com/withustudy/koudaizikao/activity/KnowledgeExplainActivity:p	Landroid/os/Bundle;
    //   18: ldc_w 324
    //   21: invokevirtual 330	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   24: putfield 286	com/withustudy/koudaizikao/activity/KnowledgeExplainActivity:q	Ljava/lang/String;
    //   27: aload_0
    //   28: aload_0
    //   29: getfield 110	com/withustudy/koudaizikao/activity/KnowledgeExplainActivity:p	Landroid/os/Bundle;
    //   32: ldc_w 332
    //   35: invokevirtual 330	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   38: putfield 334	com/withustudy/koudaizikao/activity/KnowledgeExplainActivity:r	Ljava/lang/String;
    //   41: aload_0
    //   42: getfield 336	com/withustudy/koudaizikao/activity/KnowledgeExplainActivity:o	Landroid/widget/TextView;
    //   45: aload_0
    //   46: getfield 334	com/withustudy/koudaizikao/activity/KnowledgeExplainActivity:r	Ljava/lang/String;
    //   49: invokevirtual 201	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   52: aload_0
    //   53: invokestatic 339	com/withustudy/koudaizikao/g/n:a	(Landroid/content/Context;)Z
    //   56: ifeq +116 -> 172
    //   59: aload_0
    //   60: getfield 341	com/withustudy/koudaizikao/activity/KnowledgeExplainActivity:i	Landroid/widget/LinearLayout;
    //   63: iconst_0
    //   64: invokevirtual 172	android/widget/LinearLayout:setVisibility	(I)V
    //   67: aload_0
    //   68: getfield 343	com/withustudy/koudaizikao/activity/KnowledgeExplainActivity:h	Landroid/widget/RelativeLayout;
    //   71: bipush 8
    //   73: invokevirtual 344	android/widget/RelativeLayout:setVisibility	(I)V
    //   76: aload_0
    //   77: getfield 275	com/withustudy/koudaizikao/activity/KnowledgeExplainActivity:mProTools	Lcom/withustudy/koudaizikao/g/l;
    //   80: iconst_1
    //   81: invokevirtual 348	com/withustudy/koudaizikao/g/l:a	(Z)V
    //   84: new 350	com/withustudy/koudaizikao/entity/req/UserSubject
    //   87: dup
    //   88: invokespecial 351	com/withustudy/koudaizikao/entity/req/UserSubject:<init>	()V
    //   91: astore 4
    //   93: aload 4
    //   95: aload_0
    //   96: getfield 216	com/withustudy/koudaizikao/activity/KnowledgeExplainActivity:mSP	Lcom/withustudy/koudaizikao/d/f;
    //   99: invokevirtual 354	com/withustudy/koudaizikao/d/f:p	()Ljava/lang/String;
    //   102: invokevirtual 358	com/withustudy/koudaizikao/entity/req/UserSubject:setVersionName	(Ljava/lang/String;)V
    //   105: aload 4
    //   107: invokestatic 360	com/withustudy/koudaizikao/g/n:a	()Ljava/lang/String;
    //   110: invokevirtual 363	com/withustudy/koudaizikao/entity/req/UserSubject:setClientType	(Ljava/lang/String;)V
    //   113: aload 4
    //   115: aload_0
    //   116: getfield 367	com/withustudy/koudaizikao/activity/KnowledgeExplainActivity:mContext	Landroid/content/Context;
    //   119: invokestatic 370	com/withustudy/koudaizikao/g/n:d	(Landroid/content/Context;)Ljava/lang/String;
    //   122: invokevirtual 373	com/withustudy/koudaizikao/entity/req/UserSubject:setImei	(Ljava/lang/String;)V
    //   125: aload 4
    //   127: aload_0
    //   128: getfield 367	com/withustudy/koudaizikao/activity/KnowledgeExplainActivity:mContext	Landroid/content/Context;
    //   131: invokestatic 375	com/withustudy/koudaizikao/g/n:c	(Landroid/content/Context;)Ljava/lang/String;
    //   134: invokevirtual 378	com/withustudy/koudaizikao/entity/req/UserSubject:setNet	(Ljava/lang/String;)V
    //   137: aload 4
    //   139: aload_0
    //   140: getfield 216	com/withustudy/koudaizikao/activity/KnowledgeExplainActivity:mSP	Lcom/withustudy/koudaizikao/d/f;
    //   143: invokevirtual 380	com/withustudy/koudaizikao/d/f:i	()Ljava/lang/String;
    //   146: invokevirtual 383	com/withustudy/koudaizikao/entity/req/UserSubject:setUid	(Ljava/lang/String;)V
    //   149: aload 4
    //   151: aload_0
    //   152: getfield 286	com/withustudy/koudaizikao/activity/KnowledgeExplainActivity:q	Ljava/lang/String;
    //   155: invokevirtual 386	com/withustudy/koudaizikao/entity/req/UserSubject:setSubjectId	(Ljava/lang/String;)V
    //   158: invokestatic 391	com/withustudy/koudaizikao/a/c:b	()Lcom/withustudy/koudaizikao/a/c;
    //   161: invokevirtual 394	com/withustudy/koudaizikao/a/c:h	()Lcom/withustudy/koudaizikao/a/b;
    //   164: aload_0
    //   165: aload 4
    //   167: iconst_0
    //   168: invokevirtual 399	com/withustudy/koudaizikao/a/b:a	(Lcom/android/http/n$a;Ljava/lang/Object;I)V
    //   171: return
    //   172: aload_0
    //   173: getfield 341	com/withustudy/koudaizikao/activity/KnowledgeExplainActivity:i	Landroid/widget/LinearLayout;
    //   176: bipush 8
    //   178: invokevirtual 172	android/widget/LinearLayout:setVisibility	(I)V
    //   181: aload_0
    //   182: getfield 343	com/withustudy/koudaizikao/activity/KnowledgeExplainActivity:h	Landroid/widget/RelativeLayout;
    //   185: iconst_0
    //   186: invokevirtual 344	android/widget/RelativeLayout:setVisibility	(I)V
    //   189: return
    //   190: astore_1
    //   191: return
    //   192: astore_3
    //   193: goto -152 -> 41
    //
    // Exception table:
    //   from	to	target	type
    //   0	5	190	java/lang/Exception
    //   41	171	190	java/lang/Exception
    //   172	189	190	java/lang/Exception
    //   5	41	192	java/lang/Exception
  }

  protected void initListener()
  {
    this.j.setOnClickListener(this);
    this.n.setOnClickListener(this);
  }

  protected void initView()
  {
    this.c = ((ListView)findViewById(2131296558));
    this.i = ((LinearLayout)findViewById(2131296555));
    this.h = ((RelativeLayout)findViewById(2131296559));
    this.j = ((Button)findViewById(2131296556));
    this.n = ((ImageButton)findViewById(2131296557));
    this.o = ((TextView)findViewById(2131296401));
  }

  public void onClick(View paramView)
  {
    try
    {
      switch (paramView.getId())
      {
      case 2131296836:
        c();
        return;
      case 2131296556:
        finish();
        return;
      case 2131296841:
        c();
        return;
      case 2131296557:
        String str = "?subjectid=" + this.q;
        com.withustudy.koudaizikao.a.a locala = c.b().at();
        String[] arrayOfString = new String[1];
        arrayOfString[0] = ("http://share.kdzikao.com/brush/share.page" + str);
        locala.a(this, arrayOfString, 101, this);
        return;
      case 2131296847:
        c();
      case 2131296842:
      case 2131296844:
      case 2131296845:
      case 2131296846:
      case 2131297397:
      case 2131297405:
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
    try
    {
      if (this.k != null)
      {
        this.k.dismiss();
        this.k = null;
      }
      if (this.I != null)
      {
        this.I.c();
        this.I = null;
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    if (paramString1 != null)
    {
      Gson localGson;
      try
      {
        localGson = c.a();
        switch (paramInt)
        {
        case 0:
          this.E = ((ChapterKpointSummaryW)localGson.fromJson(paramString1, ChapterKpointSummaryW.class));
          if (this.E != null)
          {
            this.J.sendEmptyMessage(0);
            return;
          }
        case 101:
        }
      }
      catch (Exception localException)
      {
        h.a("知识点讲解解析异常:" + localException.getMessage());
        return;
      }
      h.a("知识点讲解数据解析实体bean为null");
      return;
      this.F = ((UrlShortBean)localGson.fromJson(paramString1, UrlShortBean.class));
      if (this.F != null)
      {
        this.J.sendEmptyMessage(101);
        return;
      }
      h.a("加密url异常");
    }
  }

  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    this.s = paramBoolean;
  }

  protected void setContentView()
  {
    setContentView(2130903089);
  }

  class a extends BaseAdapter
  {
    private List<ChapterKpointSummary> b;

    public a()
    {
      Object localObject;
      this.b = localObject;
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
      KnowledgeExplainActivity.b localb1;
      ChapterKpointSummary localChapterKpointSummary;
      LinearLayout.LayoutParams localLayoutParams1;
      List localList;
      int i;
      if (paramView == null)
      {
        paramView = View.inflate(KnowledgeExplainActivity.this.getApplicationContext(), 2130903229, null);
        KnowledgeExplainActivity.b localb2 = new KnowledgeExplainActivity.b(KnowledgeExplainActivity.this);
        KnowledgeExplainActivity.b.a(localb2, (ImageView)paramView.findViewById(2131296825));
        KnowledgeExplainActivity.b.b(localb2, (ImageView)paramView.findViewById(2131297407));
        KnowledgeExplainActivity.b.a(localb2, (ImageButton)paramView.findViewById(2131297410));
        KnowledgeExplainActivity.b.a(localb2, (TextView)paramView.findViewById(2131296824));
        KnowledgeExplainActivity.b.b(localb2, (TextView)paramView.findViewById(2131297408));
        KnowledgeExplainActivity.b.c(localb2, (TextView)paramView.findViewById(2131297409));
        KnowledgeExplainActivity.b.a(localb2, (LinearLayout)paramView.findViewById(2131297411));
        paramView.setTag(localb2);
        localb1 = localb2;
        localChapterKpointSummary = (ChapterKpointSummary)this.b.get(paramInt);
        Boolean localBoolean = (Boolean)KnowledgeExplainActivity.h(KnowledgeExplainActivity.this).get(Integer.valueOf(paramInt));
        String str = localChapterKpointSummary.getChapter().getSn();
        KnowledgeExplainActivity.b.a(localb1).setText(str);
        KnowledgeExplainActivity.b.b(localb1).setText(localChapterKpointSummary.getChapter().getName());
        KnowledgeExplainActivity.b.c(localb1).setText("共" + localChapterKpointSummary.getTotalKpointNum() + "个知识点,已学" + localChapterKpointSummary.getLearnedKpointNum() + "个知识点");
        localLayoutParams1 = (LinearLayout.LayoutParams)KnowledgeExplainActivity.b.d(localb1).getLayoutParams();
        localLayoutParams1.leftMargin = n.a(KnowledgeExplainActivity.this.getApplicationContext(), 15.0F);
        KnowledgeExplainActivity.b.d(localb1).setLayoutParams(localLayoutParams1);
        KnowledgeExplainActivity.b.e(localb1).setVisibility(8);
        if ((localBoolean == null) || (!localBoolean.booleanValue()))
          break label633;
        KnowledgeExplainActivity.b.f(localb1).setVisibility(0);
        KnowledgeExplainActivity.b.g(localb1).setVisibility(8);
        KnowledgeExplainActivity.b.e(localb1).setVisibility(0);
        LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)KnowledgeExplainActivity.b.d(localb1).getLayoutParams();
        localLayoutParams2.leftMargin = n.a(KnowledgeExplainActivity.this.getApplicationContext(), 25.0F);
        KnowledgeExplainActivity.b.d(localb1).setLayoutParams(localLayoutParams2);
        if ((KnowledgeExplainActivity.b.f(localb1) != null) && (KnowledgeExplainActivity.b.f(localb1).getChildCount() > 0))
          KnowledgeExplainActivity.b.f(localb1).removeAllViews();
        localList = localChapterKpointSummary.getSectionKpointSummary();
        j.a("knowledgeItemList", Integer.valueOf(localList.size()));
        i = 0;
        label438: if (i < localList.size())
          break label481;
      }
      while (true)
      {
        paramView.setOnClickListener(new ag(this, paramInt, localb1, localChapterKpointSummary));
        return paramView;
        localb1 = (KnowledgeExplainActivity.b)paramView.getTag();
        break;
        label481: SectionKpointSummary localSectionKpointSummary = (SectionKpointSummary)localList.get(i);
        LinearLayout localLinearLayout = (LinearLayout)View.inflate(KnowledgeExplainActivity.this.getApplicationContext(), 2130903227, null);
        ((TextView)localLinearLayout.findViewById(2131297399)).setText("共" + localSectionKpointSummary.getTotalKpointNum() + "个知识点,已学" + localSectionKpointSummary.getLearnedKpointNum() + "个知识点");
        ((TextView)localLinearLayout.findViewById(2131297398)).setText(localSectionKpointSummary.getSection().getName());
        ((ImageButton)localLinearLayout.findViewById(2131297400)).setOnClickListener(KnowledgeExplainActivity.this);
        localLinearLayout.setOnClickListener(new af(this, localSectionKpointSummary));
        KnowledgeExplainActivity.b.f(localb1).addView(localLinearLayout);
        i++;
        break label438;
        label633: KnowledgeExplainActivity.b.f(localb1).setVisibility(8);
        KnowledgeExplainActivity.b.e(localb1).setVisibility(8);
        KnowledgeExplainActivity.b.d(localb1).setLayoutParams(localLayoutParams1);
        KnowledgeExplainActivity.b.g(localb1).setVisibility(0);
        if ((KnowledgeExplainActivity.b.f(localb1) == null) || (KnowledgeExplainActivity.b.f(localb1).getChildCount() <= 0))
          continue;
        KnowledgeExplainActivity.b.f(localb1).removeAllViews();
      }
    }
  }

  class b
  {
    private ImageView b;
    private ImageView c;
    private ImageButton d;
    private LinearLayout e;
    private TextView f;
    private TextView g;
    private TextView h;

    b()
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.KnowledgeExplainActivity
 * JD-Core Version:    0.6.0
 */