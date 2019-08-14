package com.withustudy.koudaizikao.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.a.a.b.c.a;
import com.android.http.e;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.f;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.withustudy.koudaizikao.a.b;
import com.withustudy.koudaizikao.activity.BrushRankingActivity;
import com.withustudy.koudaizikao.base.AbsBaseFragment;
import com.withustudy.koudaizikao.custom.a.a;
import com.withustudy.koudaizikao.custom.swipyrefresh.SwipyRefreshLayout;
import com.withustudy.koudaizikao.custom.swipyrefresh.SwipyRefreshLayout.a;
import com.withustudy.koudaizikao.custom.swipyrefresh.p;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.UrlShortBean;
import com.withustudy.koudaizikao.entity.UserBrushSummary;
import com.withustudy.koudaizikao.entity.UserBrushSummaryW;
import com.withustudy.koudaizikao.entity.UserMockSummary;
import com.withustudy.koudaizikao.entity.UserMockSummaryW;
import com.withustudy.koudaizikao.entity.req.ReqBrushRank;
import com.withustudy.koudaizikao.entity.req.UserSubject;
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.l;
import com.withustudy.koudaizikao.g.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrushRankingFragment extends AbsBaseFragment
  implements View.OnClickListener, AbsListView.OnScrollListener, PullToRefreshBase.f<ListView>, SwipyRefreshLayout.a
{
  private static final int b = 101;
  private static final int l = 10;
  private static final int m = 11;
  private static final int q = 1;
  private static final int r = 2;
  private List<UserMockSummary> F;
  private a G;
  private Handler H = new g(this);
  private PopupWindow I;
  private int J;
  protected boolean a;
  private PullToRefreshListView c;
  private com.withustudy.koudaizikao.b.d d;
  private ImageView e;
  private TextView f;
  private TextView g;
  private Button h;
  private boolean i = false;
  private SwipyRefreshLayout j;
  private String k;
  private LinearLayout n;
  private boolean o;
  private boolean p;
  private BrushRankingActivity s;
  private UserBrushSummaryW t;
  private UserMockSummaryW u;
  private UrlShortBean v;
  private List<UserBrushSummary> w = new ArrayList();

  private void a(ImageView paramImageView, String paramString)
  {
    com.a.a.b.c localc = new c.a().b(2130837854).c(2130837862).d(2130837862).b(true).c(true).a(new com.a.a.b.c.c(110)).d();
    com.a.a.b.d.a().a(paramString, paramImageView, localc);
  }

  private void d()
  {
  }

  private void e()
  {
    f();
  }

  private void f()
  {
    if ((!this.o) || (!this.a) || (this.p))
      return;
    this.s = ((BrushRankingActivity)getActivity());
    this.B.a(true);
    this.J = this.s.b;
    switch (this.J)
    {
    default:
      return;
    case 0:
      h();
      return;
    case 1:
    }
    i();
  }

  private void h()
  {
    ReqBrushRank localReqBrushRank = new ReqBrushRank();
    localReqBrushRank.setClientType(n.a());
    localReqBrushRank.setImei(n.d(this.y));
    localReqBrushRank.setNet(n.c(this.y));
    localReqBrushRank.setVersionName(this.E.p());
    localReqBrushRank.setTimeSpan((String)BrushRankingActivity.a.get(Integer.valueOf(this.s.e)));
    UserSubject localUserSubject = new UserSubject();
    localUserSubject.setSubjectId(this.s.c);
    localUserSubject.setUid(this.E.i());
    localReqBrushRank.setUserSubject(localUserSubject);
    com.withustudy.koudaizikao.a.c.b().af().a(this, localReqBrushRank, 1);
  }

  private void i()
  {
    ReqBrushRank localReqBrushRank = new ReqBrushRank();
    localReqBrushRank.setClientType(n.a());
    localReqBrushRank.setImei(n.d(this.y));
    localReqBrushRank.setNet(n.c(this.y));
    localReqBrushRank.setVersionName(this.E.p());
    localReqBrushRank.setTimeSpan((String)BrushRankingActivity.a.get(Integer.valueOf(this.s.e)));
    UserSubject localUserSubject = new UserSubject();
    localUserSubject.setSubjectId(this.s.c);
    localUserSubject.setUid(this.E.i());
    localReqBrushRank.setUserSubject(localUserSubject);
    com.withustudy.koudaizikao.a.c.b().al().a(this, localReqBrushRank, 2);
  }

  private void j()
  {
    if (this.I != null)
    {
      this.I.dismiss();
      this.I = null;
    }
    a(1.0F);
  }

  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903151, null);
  }

  public void a()
  {
    this.s = ((BrushRankingActivity)getActivity());
    this.k = this.s.c;
    n.a(false, this.c, getActivity());
    this.o = true;
    f();
  }

  public void a(float paramFloat)
  {
    WindowManager.LayoutParams localLayoutParams = getActivity().getWindow().getAttributes();
    localLayoutParams.alpha = paramFloat;
    getActivity().getWindow().setAttributes(localLayoutParams);
  }

  public void a(View paramView)
  {
    this.n = ((LinearLayout)paramView.findViewById(2131296502));
    this.j = ((SwipyRefreshLayout)paramView.findViewById(2131296944));
    this.c = ((PullToRefreshListView)paramView.findViewById(2131296945));
    this.e = ((ImageView)paramView.findViewById(2131296946));
    this.f = ((TextView)paramView.findViewById(2131296947));
    this.g = ((TextView)paramView.findViewById(2131296948));
    this.h = ((Button)paramView.findViewById(2131296949));
  }

  public void a(PullToRefreshBase<ListView> paramPullToRefreshBase)
  {
  }

  public void a(p paramp)
  {
    if (paramp.equals(p.a(0)))
    {
      this.j.setRefreshing(true);
      this.H.sendEmptyMessage(10);
    }
  }

  public void b()
  {
    this.j.setRefreshing(true);
    this.j.setOnRefreshListener(this);
    this.c.setOnScrollListener(this);
    this.c.setOnRefreshListener(this);
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    String str1 = this.E.u();
    String str2 = this.E.v();
    if ((str1 == null) || (str1.equals("")))
      a(this.e, "drawable://2130837862");
    while (true)
    {
      this.f.setText(str2);
      return;
      this.D.a(str1, this.e, 1000);
    }
  }

  public void b(PullToRefreshBase<ListView> paramPullToRefreshBase)
  {
    if (!this.i)
    {
      this.H.sendEmptyMessage(11);
      this.i = true;
    }
  }

  public void c()
  {
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
  }

  // ERROR //
  public void onClick(View paramView)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 426	android/view/View:getId	()I
    //   4: lookupswitch	default:+60->64, 2131296836:+1060->1064, 2131296844:+60->64, 2131296845:+60->64, 2131296846:+60->64, 2131296948:+61->65, 2131296949:+236->240
    //   65: aload_0
    //   66: getfield 136	com/withustudy/koudaizikao/fragment/BrushRankingFragment:J	I
    //   69: tableswitch	default:+23 -> 92, 0:+24->93, 1:+89->158
    //   93: aload_0
    //   94: getfield 139	com/withustudy/koudaizikao/fragment/BrushRankingFragment:t	Lcom/withustudy/koudaizikao/entity/UserBrushSummaryW;
    //   97: ifnull -33 -> 64
    //   100: aload_0
    //   101: getfield 139	com/withustudy/koudaizikao/fragment/BrushRankingFragment:t	Lcom/withustudy/koudaizikao/entity/UserBrushSummaryW;
    //   104: invokevirtual 431	com/withustudy/koudaizikao/entity/UserBrushSummaryW:getMyRankPos	()I
    //   107: istore 47
    //   109: aload_0
    //   110: getfield 126	com/withustudy/koudaizikao/fragment/BrushRankingFragment:d	Lcom/withustudy/koudaizikao/b/d;
    //   113: ifnull -49 -> 64
    //   116: aload_0
    //   117: getfield 126	com/withustudy/koudaizikao/fragment/BrushRankingFragment:d	Lcom/withustudy/koudaizikao/b/d;
    //   120: iload 47
    //   122: invokevirtual 435	com/withustudy/koudaizikao/b/d:a	(I)V
    //   125: aload_0
    //   126: getfield 126	com/withustudy/koudaizikao/fragment/BrushRankingFragment:d	Lcom/withustudy/koudaizikao/b/d;
    //   129: invokevirtual 438	com/withustudy/koudaizikao/b/d:notifyDataSetChanged	()V
    //   132: aload_0
    //   133: getfield 86	com/withustudy/koudaizikao/fragment/BrushRankingFragment:c	Lcom/handmark/pulltorefresh/library/PullToRefreshListView;
    //   136: invokevirtual 442	com/handmark/pulltorefresh/library/PullToRefreshListView:requestFocus	()Z
    //   139: pop
    //   140: aload_0
    //   141: getfield 86	com/withustudy/koudaizikao/fragment/BrushRankingFragment:c	Lcom/handmark/pulltorefresh/library/PullToRefreshListView;
    //   144: invokevirtual 446	com/handmark/pulltorefresh/library/PullToRefreshListView:getRefreshableView	()Landroid/view/View;
    //   147: checkcast 448	android/widget/ListView
    //   150: iload 47
    //   152: iconst_1
    //   153: iadd
    //   154: invokevirtual 451	android/widget/ListView:smoothScrollToPosition	(I)V
    //   157: return
    //   158: aload_0
    //   159: getfield 276	com/withustudy/koudaizikao/fragment/BrushRankingFragment:u	Lcom/withustudy/koudaizikao/entity/UserMockSummaryW;
    //   162: ifnull -98 -> 64
    //   165: aload_0
    //   166: getfield 276	com/withustudy/koudaizikao/fragment/BrushRankingFragment:u	Lcom/withustudy/koudaizikao/entity/UserMockSummaryW;
    //   169: invokevirtual 454	com/withustudy/koudaizikao/entity/UserMockSummaryW:getMyRankPos	()I
    //   172: istore 45
    //   174: iload 45
    //   176: iconst_m1
    //   177: if_icmpne +14 -> 191
    //   180: aload_0
    //   181: getfield 142	com/withustudy/koudaizikao/fragment/BrushRankingFragment:g	Landroid/widget/TextView;
    //   184: ldc_w 456
    //   187: invokevirtual 410	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   190: return
    //   191: aload_0
    //   192: getfield 126	com/withustudy/koudaizikao/fragment/BrushRankingFragment:d	Lcom/withustudy/koudaizikao/b/d;
    //   195: ifnull -131 -> 64
    //   198: aload_0
    //   199: getfield 126	com/withustudy/koudaizikao/fragment/BrushRankingFragment:d	Lcom/withustudy/koudaizikao/b/d;
    //   202: iload 45
    //   204: invokevirtual 435	com/withustudy/koudaizikao/b/d:a	(I)V
    //   207: aload_0
    //   208: getfield 126	com/withustudy/koudaizikao/fragment/BrushRankingFragment:d	Lcom/withustudy/koudaizikao/b/d;
    //   211: invokevirtual 438	com/withustudy/koudaizikao/b/d:notifyDataSetChanged	()V
    //   214: aload_0
    //   215: getfield 86	com/withustudy/koudaizikao/fragment/BrushRankingFragment:c	Lcom/handmark/pulltorefresh/library/PullToRefreshListView;
    //   218: invokevirtual 442	com/handmark/pulltorefresh/library/PullToRefreshListView:requestFocus	()Z
    //   221: pop
    //   222: aload_0
    //   223: getfield 86	com/withustudy/koudaizikao/fragment/BrushRankingFragment:c	Lcom/handmark/pulltorefresh/library/PullToRefreshListView;
    //   226: invokevirtual 446	com/handmark/pulltorefresh/library/PullToRefreshListView:getRefreshableView	()Landroid/view/View;
    //   229: checkcast 448	android/widget/ListView
    //   232: iload 45
    //   234: iconst_1
    //   235: iadd
    //   236: invokevirtual 451	android/widget/ListView:smoothScrollToPosition	(I)V
    //   239: return
    //   240: ldc_w 401
    //   243: astore_2
    //   244: ldc_w 401
    //   247: astore_3
    //   248: aload_0
    //   249: getfield 136	com/withustudy/koudaizikao/fragment/BrushRankingFragment:J	I
    //   252: tableswitch	default:+24 -> 276, 0:+25->277, 1:+423->675
    //   277: aload_0
    //   278: getfield 139	com/withustudy/koudaizikao/fragment/BrushRankingFragment:t	Lcom/withustudy/koudaizikao/entity/UserBrushSummaryW;
    //   281: ifnull +877 -> 1158
    //   284: aload_0
    //   285: getfield 139	com/withustudy/koudaizikao/fragment/BrushRankingFragment:t	Lcom/withustudy/koudaizikao/entity/UserBrushSummaryW;
    //   288: invokevirtual 431	com/withustudy/koudaizikao/entity/UserBrushSummaryW:getMyRankPos	()I
    //   291: istore 43
    //   293: aload_0
    //   294: getfield 76	com/withustudy/koudaizikao/fragment/BrushRankingFragment:w	Ljava/util/List;
    //   297: ifnull +848 -> 1145
    //   300: iload 43
    //   302: iflt +843 -> 1145
    //   305: aload_0
    //   306: getfield 76	com/withustudy/koudaizikao/fragment/BrushRankingFragment:w	Ljava/util/List;
    //   309: iload 43
    //   311: invokeinterface 461 2 0
    //   316: checkcast 463	com/withustudy/koudaizikao/entity/UserBrushSummary
    //   319: astore 44
    //   321: aload 44
    //   323: ifnull +822 -> 1145
    //   326: aload 44
    //   328: invokevirtual 466	com/withustudy/koudaizikao/entity/UserBrushSummary:getBrushNum	()I
    //   331: istore 27
    //   333: aload 44
    //   335: invokevirtual 470	com/withustudy/koudaizikao/entity/UserBrushSummary:getCorrectRate	()D
    //   338: dstore 25
    //   340: iload 43
    //   342: istore 24
    //   344: aload_0
    //   345: getfield 210	com/withustudy/koudaizikao/fragment/BrushRankingFragment:E	Lcom/withustudy/koudaizikao/d/f;
    //   348: invokevirtual 399	com/withustudy/koudaizikao/d/f:v	()Ljava/lang/String;
    //   351: ldc_w 472
    //   354: invokestatic 478	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   357: astore 39
    //   359: aload 39
    //   361: astore 32
    //   363: new 480	java/lang/StringBuilder
    //   366: dup
    //   367: iload 27
    //   369: invokestatic 483	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   372: invokespecial 485	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   375: invokevirtual 488	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: ldc_w 472
    //   381: invokestatic 478	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   384: astore 40
    //   386: aload 40
    //   388: astore 30
    //   390: new 480	java/lang/StringBuilder
    //   393: dup
    //   394: new 490	java/text/DecimalFormat
    //   397: dup
    //   398: ldc_w 492
    //   401: invokespecial 493	java/text/DecimalFormat:<init>	(Ljava/lang/String;)V
    //   404: dload 25
    //   406: ldc2_w 494
    //   409: dmul
    //   410: invokevirtual 499	java/text/DecimalFormat:format	(D)Ljava/lang/String;
    //   413: invokestatic 502	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   416: invokespecial 485	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   419: invokevirtual 488	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: ldc_w 472
    //   425: invokestatic 478	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   428: astore 41
    //   430: aload 41
    //   432: astore 29
    //   434: new 480	java/lang/StringBuilder
    //   437: dup
    //   438: iload 24
    //   440: invokestatic 483	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   443: invokespecial 485	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   446: invokevirtual 488	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   449: ldc_w 472
    //   452: invokestatic 478	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   455: astore 42
    //   457: aload 42
    //   459: astore_3
    //   460: iload 24
    //   462: iconst_m1
    //   463: if_icmpne +106 -> 569
    //   466: new 480	java/lang/StringBuilder
    //   469: dup
    //   470: ldc_w 504
    //   473: invokespecial 485	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   476: aload_0
    //   477: getfield 303	com/withustudy/koudaizikao/fragment/BrushRankingFragment:k	Ljava/lang/String;
    //   480: invokevirtual 508	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: invokevirtual 488	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: astore 36
    //   488: invokestatic 261	com/withustudy/koudaizikao/a/c:b	()Lcom/withustudy/koudaizikao/a/c;
    //   491: invokevirtual 512	com/withustudy/koudaizikao/a/c:at	()Lcom/withustudy/koudaizikao/a/a;
    //   494: astore 37
    //   496: iconst_1
    //   497: anewarray 236	java/lang/String
    //   500: astore 38
    //   502: aload 38
    //   504: iconst_0
    //   505: new 480	java/lang/StringBuilder
    //   508: dup
    //   509: ldc_w 514
    //   512: invokestatic 502	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   515: invokespecial 485	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   518: aload 36
    //   520: invokevirtual 508	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: invokevirtual 488	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   526: aastore
    //   527: aload 37
    //   529: aload_0
    //   530: aload 38
    //   532: bipush 101
    //   534: aload_0
    //   535: invokevirtual 156	com/withustudy/koudaizikao/fragment/BrushRankingFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   538: invokevirtual 519	com/withustudy/koudaizikao/a/a:a	(Lcom/android/http/n$a;[Ljava/lang/String;ILandroid/content/Context;)V
    //   541: return
    //   542: astore 28
    //   544: ldc_w 401
    //   547: astore 29
    //   549: ldc_w 401
    //   552: astore 30
    //   554: aload_2
    //   555: astore 31
    //   557: aload 28
    //   559: invokevirtual 522	java/lang/Exception:printStackTrace	()V
    //   562: aload 31
    //   564: astore 32
    //   566: goto -106 -> 460
    //   569: new 480	java/lang/StringBuilder
    //   572: dup
    //   573: ldc_w 524
    //   576: invokespecial 485	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   579: aload 32
    //   581: invokevirtual 508	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: ldc_w 526
    //   587: invokevirtual 508	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: aload 30
    //   592: invokevirtual 508	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: ldc_w 528
    //   598: invokevirtual 508	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: aload 29
    //   603: invokevirtual 508	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: ldc_w 530
    //   609: invokevirtual 508	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: aload_3
    //   613: invokevirtual 508	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: invokevirtual 488	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   619: astore 33
    //   621: invokestatic 261	com/withustudy/koudaizikao/a/c:b	()Lcom/withustudy/koudaizikao/a/c;
    //   624: invokevirtual 512	com/withustudy/koudaizikao/a/c:at	()Lcom/withustudy/koudaizikao/a/a;
    //   627: astore 34
    //   629: iconst_1
    //   630: anewarray 236	java/lang/String
    //   633: astore 35
    //   635: aload 35
    //   637: iconst_0
    //   638: new 480	java/lang/StringBuilder
    //   641: dup
    //   642: ldc_w 532
    //   645: invokestatic 502	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   648: invokespecial 485	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   651: aload 33
    //   653: invokevirtual 508	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: invokevirtual 488	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   659: aastore
    //   660: aload 34
    //   662: aload_0
    //   663: aload 35
    //   665: bipush 101
    //   667: aload_0
    //   668: invokevirtual 156	com/withustudy/koudaizikao/fragment/BrushRankingFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   671: invokevirtual 519	com/withustudy/koudaizikao/a/a:a	(Lcom/android/http/n$a;[Ljava/lang/String;ILandroid/content/Context;)V
    //   674: return
    //   675: aload_0
    //   676: getfield 276	com/withustudy/koudaizikao/fragment/BrushRankingFragment:u	Lcom/withustudy/koudaizikao/entity/UserMockSummaryW;
    //   679: ifnull +454 -> 1133
    //   682: aload_0
    //   683: getfield 276	com/withustudy/koudaizikao/fragment/BrushRankingFragment:u	Lcom/withustudy/koudaizikao/entity/UserMockSummaryW;
    //   686: invokevirtual 454	com/withustudy/koudaizikao/entity/UserMockSummaryW:getMyRankPos	()I
    //   689: istore 22
    //   691: aload_0
    //   692: getfield 132	com/withustudy/koudaizikao/fragment/BrushRankingFragment:F	Ljava/util/List;
    //   695: ifnull +425 -> 1120
    //   698: iload 22
    //   700: iflt +420 -> 1120
    //   703: aload_0
    //   704: getfield 132	com/withustudy/koudaizikao/fragment/BrushRankingFragment:F	Ljava/util/List;
    //   707: invokeinterface 535 1 0
    //   712: ifle +408 -> 1120
    //   715: aload_0
    //   716: getfield 132	com/withustudy/koudaizikao/fragment/BrushRankingFragment:F	Ljava/util/List;
    //   719: iload 22
    //   721: invokeinterface 461 2 0
    //   726: checkcast 537	com/withustudy/koudaizikao/entity/UserMockSummary
    //   729: astore 23
    //   731: aload 23
    //   733: ifnull +387 -> 1120
    //   736: aload 23
    //   738: invokevirtual 541	com/withustudy/koudaizikao/entity/UserMockSummary:getCostTime	()J
    //   741: lstore 4
    //   743: aload 23
    //   745: invokevirtual 544	com/withustudy/koudaizikao/entity/UserMockSummary:getScore	()D
    //   748: dstore 7
    //   750: iload 22
    //   752: istore 6
    //   754: ldc_w 401
    //   757: astore 9
    //   759: aload_0
    //   760: getfield 210	com/withustudy/koudaizikao/fragment/BrushRankingFragment:E	Lcom/withustudy/koudaizikao/d/f;
    //   763: invokevirtual 399	com/withustudy/koudaizikao/d/f:v	()Ljava/lang/String;
    //   766: ldc_w 472
    //   769: invokestatic 478	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   772: astore_2
    //   773: new 480	java/lang/StringBuilder
    //   776: dup
    //   777: dload 7
    //   779: invokestatic 546	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   782: invokespecial 485	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   785: invokevirtual 488	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   788: ldc_w 472
    //   791: invokestatic 478	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   794: astore 9
    //   796: new 480	java/lang/StringBuilder
    //   799: dup
    //   800: lload 4
    //   802: invokestatic 549	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   805: invokespecial 485	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   808: invokevirtual 488	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   811: ldc_w 472
    //   814: invokestatic 478	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   817: astore 20
    //   819: aload 20
    //   821: astore 11
    //   823: new 480	java/lang/StringBuilder
    //   826: dup
    //   827: iload 6
    //   829: invokestatic 483	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   832: invokespecial 485	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   835: invokevirtual 488	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   838: ldc_w 472
    //   841: invokestatic 478	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   844: astore 21
    //   846: aload 21
    //   848: astore 13
    //   850: iload 6
    //   852: iconst_m1
    //   853: if_icmpne +105 -> 958
    //   856: new 480	java/lang/StringBuilder
    //   859: dup
    //   860: ldc_w 504
    //   863: invokespecial 485	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   866: aload_0
    //   867: getfield 303	com/withustudy/koudaizikao/fragment/BrushRankingFragment:k	Ljava/lang/String;
    //   870: invokevirtual 508	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: invokevirtual 488	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   876: astore 17
    //   878: invokestatic 261	com/withustudy/koudaizikao/a/c:b	()Lcom/withustudy/koudaizikao/a/c;
    //   881: invokevirtual 512	com/withustudy/koudaizikao/a/c:at	()Lcom/withustudy/koudaizikao/a/a;
    //   884: astore 18
    //   886: iconst_1
    //   887: anewarray 236	java/lang/String
    //   890: astore 19
    //   892: aload 19
    //   894: iconst_0
    //   895: new 480	java/lang/StringBuilder
    //   898: dup
    //   899: ldc_w 514
    //   902: invokestatic 502	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   905: invokespecial 485	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   908: aload 17
    //   910: invokevirtual 508	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   913: invokevirtual 488	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   916: aastore
    //   917: aload 18
    //   919: aload_0
    //   920: aload 19
    //   922: bipush 101
    //   924: aload_0
    //   925: invokevirtual 156	com/withustudy/koudaizikao/fragment/BrushRankingFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   928: invokevirtual 519	com/withustudy/koudaizikao/a/a:a	(Lcom/android/http/n$a;[Ljava/lang/String;ILandroid/content/Context;)V
    //   931: return
    //   932: astore 10
    //   934: ldc_w 401
    //   937: astore 11
    //   939: aload 9
    //   941: astore 12
    //   943: aload 10
    //   945: invokevirtual 522	java/lang/Exception:printStackTrace	()V
    //   948: aload 12
    //   950: astore 9
    //   952: aload_3
    //   953: astore 13
    //   955: goto -105 -> 850
    //   958: new 480	java/lang/StringBuilder
    //   961: dup
    //   962: ldc_w 524
    //   965: invokespecial 485	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   968: aload_2
    //   969: invokevirtual 508	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   972: ldc_w 551
    //   975: invokevirtual 508	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   978: aload 9
    //   980: invokevirtual 508	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   983: ldc_w 553
    //   986: invokevirtual 508	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   989: aload 11
    //   991: invokevirtual 508	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   994: ldc_w 530
    //   997: invokevirtual 508	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1000: aload 13
    //   1002: invokevirtual 508	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1005: invokevirtual 488	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1008: astore 14
    //   1010: invokestatic 261	com/withustudy/koudaizikao/a/c:b	()Lcom/withustudy/koudaizikao/a/c;
    //   1013: invokevirtual 512	com/withustudy/koudaizikao/a/c:at	()Lcom/withustudy/koudaizikao/a/a;
    //   1016: astore 15
    //   1018: iconst_1
    //   1019: anewarray 236	java/lang/String
    //   1022: astore 16
    //   1024: aload 16
    //   1026: iconst_0
    //   1027: new 480	java/lang/StringBuilder
    //   1030: dup
    //   1031: ldc_w 555
    //   1034: invokestatic 502	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1037: invokespecial 485	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1040: aload 14
    //   1042: invokevirtual 508	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1045: invokevirtual 488	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1048: aastore
    //   1049: aload 15
    //   1051: aload_0
    //   1052: aload 16
    //   1054: bipush 101
    //   1056: aload_0
    //   1057: invokevirtual 156	com/withustudy/koudaizikao/fragment/BrushRankingFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   1060: invokevirtual 519	com/withustudy/koudaizikao/a/a:a	(Lcom/android/http/n$a;[Ljava/lang/String;ILandroid/content/Context;)V
    //   1063: return
    //   1064: aload_0
    //   1065: invokespecial 557	com/withustudy/koudaizikao/fragment/BrushRankingFragment:j	()V
    //   1068: return
    //   1069: astore 10
    //   1071: aload 9
    //   1073: astore 12
    //   1075: goto -132 -> 943
    //   1078: astore 28
    //   1080: ldc_w 401
    //   1083: astore 29
    //   1085: ldc_w 401
    //   1088: astore 30
    //   1090: aload 32
    //   1092: astore 31
    //   1094: goto -537 -> 557
    //   1097: astore 28
    //   1099: ldc_w 401
    //   1102: astore 29
    //   1104: aload 32
    //   1106: astore 31
    //   1108: goto -551 -> 557
    //   1111: astore 28
    //   1113: aload 32
    //   1115: astore 31
    //   1117: goto -560 -> 557
    //   1120: dconst_0
    //   1121: dstore 7
    //   1123: lconst_0
    //   1124: lstore 4
    //   1126: iload 22
    //   1128: istore 6
    //   1130: goto -376 -> 754
    //   1133: lconst_0
    //   1134: lstore 4
    //   1136: iconst_m1
    //   1137: istore 6
    //   1139: dconst_0
    //   1140: dstore 7
    //   1142: goto -388 -> 754
    //   1145: iload 43
    //   1147: istore 24
    //   1149: dconst_0
    //   1150: dstore 25
    //   1152: iconst_0
    //   1153: istore 27
    //   1155: goto -811 -> 344
    //   1158: iconst_m1
    //   1159: istore 24
    //   1161: dconst_0
    //   1162: dstore 25
    //   1164: iconst_0
    //   1165: istore 27
    //   1167: goto -823 -> 344
    //
    // Exception table:
    //   from	to	target	type
    //   344	359	542	java/lang/Exception
    //   759	819	932	java/lang/Exception
    //   823	846	1069	java/lang/Exception
    //   363	386	1078	java/lang/Exception
    //   390	430	1097	java/lang/Exception
    //   434	457	1111	java/lang/Exception
  }

  public void onDestroy()
  {
    super.onDestroy();
    if (this.I != null)
    {
      this.I.dismiss();
      this.I = null;
    }
    if (this.G != null)
    {
      this.G.c();
      this.G = null;
    }
  }

  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
  }

  public void onResume()
  {
    super.onResume();
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0)
    {
      this.j.setEnabled(true);
      return;
    }
    this.j.setEnabled(false);
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    this.B.b();
    if (paramString1 != null)
    {
      Gson localGson;
      try
      {
        localGson = com.withustudy.koudaizikao.a.c.a();
        switch (paramInt)
        {
        case 1:
          this.t = ((UserBrushSummaryW)localGson.fromJson(paramString1, UserBrushSummaryW.class));
          if (this.t != null)
          {
            this.H.sendEmptyMessage(10);
            return;
          }
        case 2:
        case 101:
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      h.a("刷题榜解析宜昌");
      return;
      this.u = ((UserMockSummaryW)localGson.fromJson(paramString1, UserMockSummaryW.class));
      if (this.u != null)
      {
        this.H.sendEmptyMessage(10);
        return;
      }
      h.a("刷题榜解析宜昌");
      return;
      this.v = ((UrlShortBean)localGson.fromJson(paramString1, UrlShortBean.class));
      if (this.v != null)
      {
        this.H.sendEmptyMessage(101);
        return;
      }
      h.a("加密url异常");
      return;
    }
    h.a(paramString1);
  }

  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (getUserVisibleHint())
    {
      this.a = true;
      e();
      return;
    }
    this.a = false;
    d();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.BrushRankingFragment
 * JD-Core Version:    0.6.0
 */