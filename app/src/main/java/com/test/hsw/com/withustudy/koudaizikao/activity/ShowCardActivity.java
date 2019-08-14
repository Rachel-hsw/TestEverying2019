package com.withustudy.koudaizikao.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.umeng.a.g;
import com.withustudy.koudaizikao.a.b;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.custom.MyListView;
import com.withustudy.koudaizikao.custom.PercentageRing;
import com.withustudy.koudaizikao.custom.a.a.b;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.RspSco;
import com.withustudy.koudaizikao.entity.Scholarship;
import com.withustudy.koudaizikao.entity.SequencePushState;
import com.withustudy.koudaizikao.entity.UrlShortBean;
import com.withustudy.koudaizikao.entity.Urls;
import com.withustudy.koudaizikao.entity.content.VideoAllContent;
import com.withustudy.koudaizikao.entity.req.ReqScoBean;
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShowCardActivity extends AbsBaseActivity
  implements View.OnClickListener, a.b
{
  private static final int P = 2;
  static int a = 0;
  private static final int b = 101;
  private int A;
  private ScrollView B;
  private LinearLayout C;
  private MyListView D;
  private SequencePushState E;
  private final int F = 1;
  private int G = 0;
  private HashMap<Integer, String> H = new HashMap();
  private int I = 0;
  private int J = 0;
  private int K = 0;
  private String L;
  private int M;
  private String N;
  private String O;
  private UrlShortBean Q;
  private RspSco R;
  private com.withustudy.koudaizikao.custom.a.a S;
  private Urls T;
  private Handler U = new bc(this);
  private String V;
  private String W;
  private VideoAllContent X;
  private ImageButton c;
  private PercentageRing d;
  private TextView e;
  private TextView f;
  private TextView g;
  private LinearLayout h;
  private TextView i;
  private TextView j;
  private TextView k;
  private TextView l;
  private TextView m;
  private ImageButton n;
  private Button o;
  private LinearLayout p;
  private LinearLayout q;
  private Button r;
  private RelativeLayout s;
  private a t;
  private boolean u;
  private final int v = 5;
  private TextView w;
  private TextView x;
  private RelativeLayout y;
  private RelativeLayout z;

  private void a()
  {
    this.t = new a(null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.koudai.update_sequence_ui");
    registerReceiver(this.t, localIntentFilter);
  }

  private void a(boolean paramBoolean)
  {
    this.S = new com.withustudy.koudaizikao.custom.a.a(this, this.z);
    this.S.a(this);
    if (paramBoolean)
    {
      this.S.b("口袋自考");
      this.S.a(2130838017);
      this.S.c("我今日完成了章节刷题任务，已获得奖学金！天天喜刷刷，过关就靠它~");
    }
    while (true)
    {
      this.S.a(this.T.getUrl_short());
      this.S.d(this.T.getUrl_short());
      this.S.b();
      return;
      this.S.c("快来口袋自考学本科吧，20大专业全科讲解题目，刷刷题就过关哦~");
      this.S.b("口袋自考");
    }
  }

  // ERROR //
  private void a(boolean paramBoolean, String paramString)
    throws java.io.UnsupportedEncodingException
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: putfield 154	com/withustudy/koudaizikao/activity/ShowCardActivity:u	Z
    //   5: aload_0
    //   6: getfield 122	com/withustudy/koudaizikao/activity/ShowCardActivity:mContext	Landroid/content/Context;
    //   9: ldc 205
    //   11: invokestatic 210	com/umeng/a/g:b	(Landroid/content/Context;Ljava/lang/String;)V
    //   14: ldc 212
    //   16: astore_3
    //   17: ldc 212
    //   19: astore 4
    //   21: ldc 212
    //   23: astore 5
    //   25: ldc 214
    //   27: astore 6
    //   29: ldc 212
    //   31: astore 7
    //   33: ldc 212
    //   35: astore 8
    //   37: aload_0
    //   38: getfield 216	com/withustudy/koudaizikao/activity/ShowCardActivity:L	Ljava/lang/String;
    //   41: ldc 218
    //   43: invokestatic 224	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   46: astore_3
    //   47: aload_0
    //   48: getfield 228	com/withustudy/koudaizikao/activity/ShowCardActivity:mSP	Lcom/withustudy/koudaizikao/d/f;
    //   51: invokevirtual 232	com/withustudy/koudaizikao/d/f:v	()Ljava/lang/String;
    //   54: ldc 218
    //   56: invokestatic 224	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   59: astore 4
    //   61: new 234	java/lang/StringBuilder
    //   64: dup
    //   65: aload_0
    //   66: getfield 91	com/withustudy/koudaizikao/activity/ShowCardActivity:G	I
    //   69: invokestatic 240	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   72: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   75: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: ldc 218
    //   80: invokestatic 224	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   83: astore 5
    //   85: ldc 214
    //   87: ldc 218
    //   89: invokestatic 224	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   92: astore 6
    //   94: new 234	java/lang/StringBuilder
    //   97: dup
    //   98: aload_0
    //   99: getfield 102	com/withustudy/koudaizikao/activity/ShowCardActivity:K	I
    //   102: invokestatic 240	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   105: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   108: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: ldc 218
    //   113: invokestatic 224	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   116: astore 7
    //   118: new 234	java/lang/StringBuilder
    //   121: dup
    //   122: aload_0
    //   123: getfield 98	com/withustudy/koudaizikao/activity/ShowCardActivity:I	I
    //   126: invokestatic 240	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   129: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   132: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: ldc 218
    //   137: invokestatic 224	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   140: astore 15
    //   142: aload 15
    //   144: astore 10
    //   146: new 234	java/lang/StringBuilder
    //   149: dup
    //   150: aload_0
    //   151: getfield 100	com/withustudy/koudaizikao/activity/ShowCardActivity:J	I
    //   154: invokestatic 240	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   157: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   160: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: ldc 218
    //   165: invokestatic 224	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   168: astore 16
    //   170: aload 16
    //   172: astore 8
    //   174: new 234	java/lang/StringBuilder
    //   177: dup
    //   178: ldc 247
    //   180: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   183: aload_3
    //   184: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: ldc 253
    //   189: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload 4
    //   194: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: ldc 255
    //   199: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload 5
    //   204: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: ldc_w 257
    //   210: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload 6
    //   215: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: ldc_w 259
    //   221: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload 7
    //   226: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: ldc_w 261
    //   232: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: aload 10
    //   237: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: ldc_w 263
    //   243: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload 8
    //   248: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: ldc_w 265
    //   254: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: aload_0
    //   258: getfield 228	com/withustudy/koudaizikao/activity/ShowCardActivity:mSP	Lcom/withustudy/koudaizikao/d/f;
    //   261: invokevirtual 267	com/withustudy/koudaizikao/d/f:i	()Ljava/lang/String;
    //   264: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: ldc_w 269
    //   270: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: aload_2
    //   274: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: astore 12
    //   282: invokestatic 274	com/withustudy/koudaizikao/a/c:b	()Lcom/withustudy/koudaizikao/a/c;
    //   285: invokevirtual 278	com/withustudy/koudaizikao/a/c:at	()Lcom/withustudy/koudaizikao/a/a;
    //   288: astore 13
    //   290: iconst_1
    //   291: anewarray 236	java/lang/String
    //   294: astore 14
    //   296: aload 14
    //   298: iconst_0
    //   299: new 234	java/lang/StringBuilder
    //   302: dup
    //   303: ldc_w 280
    //   306: invokestatic 283	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   309: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   312: aload 12
    //   314: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: aastore
    //   321: aload 13
    //   323: aload_0
    //   324: aload 14
    //   326: bipush 101
    //   328: aload_0
    //   329: invokevirtual 288	com/withustudy/koudaizikao/a/a:a	(Lcom/android/http/n$a;[Ljava/lang/String;ILandroid/content/Context;)V
    //   332: return
    //   333: astore 9
    //   335: ldc 212
    //   337: astore 10
    //   339: aload 9
    //   341: astore 11
    //   343: aload 11
    //   345: invokevirtual 291	java/lang/Exception:printStackTrace	()V
    //   348: goto -174 -> 174
    //   351: astore 11
    //   353: goto -10 -> 343
    //
    // Exception table:
    //   from	to	target	type
    //   37	142	333	java/lang/Exception
    //   146	170	351	java/lang/Exception
  }

  protected void bindData()
  {
  }

  protected void initData()
  {
    try
    {
      this.mProTools.a("努力提交答案中。。。", true);
      Bundle localBundle = getIntent().getExtras();
      try
      {
        this.H = ((HashMap)localBundle.getSerializable("currRight"));
        this.O = localBundle.getString("subjectId");
        this.M = localBundle.getInt("mBrushPageFrom");
        this.N = localBundle.getString("mCurreSn");
        this.L = localBundle.getString("subjectName");
        label77: Iterator localIterator;
        if (this.H != null)
          localIterator = this.H.keySet().iterator();
        while (true)
        {
          if (!localIterator.hasNext())
          {
            this.G = (int)(100.0D * (1.0D * this.I / this.K));
            return;
          }
          Integer localInteger = (Integer)localIterator.next();
          String str = (String)this.H.get(localInteger);
          if ("true".equals(str))
          {
            this.I = (1 + this.I);
            this.K = (1 + this.K);
            continue;
          }
          if ("false".equals(str))
          {
            this.J = (1 + this.J);
            this.K = (1 + this.K);
            continue;
          }
          "##".equals(str);
        }
      }
      catch (Exception localException2)
      {
        break label77;
      }
    }
    catch (Exception localException1)
    {
    }
  }

  protected void initListener()
  {
    this.c.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.D.setOnItemClickListener(new bf(this));
  }

  protected void initView()
  {
    this.s = ((RelativeLayout)findViewById(2131296397));
    this.B = ((ScrollView)findViewById(2131296394));
    this.D = ((MyListView)findViewById(2131296405));
    this.d = ((PercentageRing)findViewById(2131296399));
    this.s.getViewTreeObserver().addOnGlobalLayoutListener(new be(this));
    this.c = ((ImageButton)findViewById(2131296396));
    this.z = ((RelativeLayout)findViewById(2131296393));
    this.e = ((TextView)findViewById(2131296403));
    this.f = ((TextView)findViewById(2131296404));
    this.g = ((TextView)findViewById(2131296402));
    this.i = ((TextView)findViewById(2131296413));
    this.w = ((TextView)findViewById(2131296401));
    this.x = ((TextView)findViewById(2131296400));
    this.j = ((TextView)findViewById(2131296410));
    this.k = ((TextView)findViewById(2131296411));
    this.l = ((TextView)findViewById(2131296412));
    this.m = ((TextView)findViewById(2131296409));
    this.n = ((ImageButton)findViewById(2131296408));
    this.o = ((Button)findViewById(2131296414));
    this.r = ((Button)findViewById(2131296406));
    this.y = ((RelativeLayout)findViewById(2131296398));
    this.h = ((LinearLayout)findViewById(2131296407));
    this.q = ((LinearLayout)findViewById(2131296395));
    this.p = ((LinearLayout)findViewById(2131296415));
    this.p.setVisibility(0);
    this.h.setVisibility(4);
    this.q.setVisibility(4);
    a();
  }

  public void onClick(View paramView)
  {
    try
    {
      switch (paramView.getId())
      {
      case 2131296396:
      case 2131296408:
        g.b(this.mContext, "brush_c_close_con");
        switch (this.M)
        {
        default:
        case 12:
        }
        while (true)
        {
          finish();
          a = 0;
          return;
          Intent localIntent = new Intent();
          localIntent.setAction("com.koudai.getSnReceiver");
          Bundle localBundle = new Bundle();
          localBundle.putString("mCurreSn", this.N);
          localIntent.putExtras(localBundle);
          sendBroadcast(localIntent);
        }
      case 2131296406:
        a(false);
        return;
      case 2131296414:
        a(true);
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
      if (this.S != null)
      {
        this.S.c();
        this.S = null;
      }
      if (this.t != null)
      {
        unregisterReceiver(this.t);
        this.t = null;
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    if (paramString1 != null)
    {
      Gson localGson;
      try
      {
        localGson = c.a();
        switch (paramInt)
        {
        case 101:
          this.Q = ((UrlShortBean)localGson.fromJson(paramString1, UrlShortBean.class));
          if (this.Q != null)
          {
            List localList = this.Q.getUrls();
            if ((localList == null) || (localList.size() <= 0))
              return;
            this.T = ((Urls)localList.get(0));
            return;
          }
        case 5:
        case 2:
        }
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        return;
      }
      h.a("加密url异常");
      return;
      this.R = ((RspSco)localGson.fromJson(paramString1, RspSco.class));
      if (this.R == null)
        return;
      this.U.sendEmptyMessage(5);
      return;
      this.mProTools.b();
      h.a("response", paramString1);
      try
      {
        this.X = ((VideoAllContent)c.a().fromJson(paramString1, VideoAllContent.class));
        this.U.sendEmptyMessage(2);
        return;
      }
      catch (Exception localException2)
      {
        return;
      }
    }
    h.a(paramString1);
  }

  public void popOnItemListener(int paramInt)
  {
    try
    {
      if (this.u)
      {
        ReqScoBean localReqScoBean = new ReqScoBean();
        localReqScoBean.setActivityId(this.E.getScholarship().getActivityId());
        localReqScoBean.setUid(this.mSP.i());
        localReqScoBean.setAmount(this.E.getScholarship().getAmount());
        c.b().m().a(this, localReqScoBean, 5);
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void setContentView()
  {
    setContentView(2130903068);
  }

  private class a extends BroadcastReceiver
  {
    private a()
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      try
      {
        Bundle localBundle = paramIntent.getExtras();
        ShowCardActivity.a(ShowCardActivity.this, (SequencePushState)localBundle.getSerializable("sequencePushState"));
        if (ShowCardActivity.v(ShowCardActivity.this) != null)
        {
          Scholarship localScholarship = ShowCardActivity.v(ShowCardActivity.this).getScholarship();
          if (localScholarship != null)
          {
            ShowCardActivity.w(ShowCardActivity.this).b();
            int i = localScholarship.getAmount();
            ShowCardActivity.e(ShowCardActivity.this).setVisibility(0);
            ShowCardActivity.g(ShowCardActivity.this).setVisibility(8);
            ShowCardActivity.f(ShowCardActivity.this).setVisibility(8);
            int j = (int)(1.0D * i / 100.0D);
            ShowCardActivity.x(ShowCardActivity.this).setText(j + "元");
            ShowCardActivity.y(ShowCardActivity.this).setText(ShowCardActivity.i(ShowCardActivity.this));
            ShowCardActivity.z(ShowCardActivity.this).setText(ShowCardActivity.k(ShowCardActivity.this));
            ShowCardActivity.A(ShowCardActivity.this).setText(ShowCardActivity.m(ShowCardActivity.this));
            ShowCardActivity.B(ShowCardActivity.this).setText(ShowCardActivity.o(ShowCardActivity.this));
            new Thread(new bg(this, localScholarship.getActivityId())).start();
            return;
          }
          com.withustudy.koudaizikao.a.a locala = c.b().r();
          ShowCardActivity localShowCardActivity = ShowCardActivity.this;
          String[] arrayOfString = new String[2];
          arrayOfString[0] = ShowCardActivity.b(ShowCardActivity.this).i();
          arrayOfString[1] = ShowCardActivity.C(ShowCardActivity.this);
          locala.a(localShowCardActivity, arrayOfString, 2, ShowCardActivity.this);
          return;
        }
      }
      catch (Exception localException)
      {
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.ShowCardActivity
 * JD-Core Version:    0.6.0
 */