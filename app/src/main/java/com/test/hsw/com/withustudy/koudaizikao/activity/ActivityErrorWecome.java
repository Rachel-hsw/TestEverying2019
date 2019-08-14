package com.withustudy.koudaizikao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.gson.Gson;
import com.withustudy.koudaizikao.a.b;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.ErrorExercise;
import com.withustudy.koudaizikao.entity.OpreationState;
import com.withustudy.koudaizikao.entity.UrlShortBean;
import com.withustudy.koudaizikao.entity.req.ReqDeleteErrors;
import com.withustudy.koudaizikao.entity.req.UserSubject;
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.l;
import com.withustudy.koudaizikao.g.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class ActivityErrorWecome extends AbsBaseActivity
  implements View.OnClickListener
{
  private static final int b = 101;
  private static final int s = 2;
  private static final int t = 3;
  ArrayList<ErrorExercise> a;
  private ImageButton c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private ImageView i;
  private Button j;
  private Button k;
  private Button l;
  private String m;
  private String n;
  private String o;
  private long p;
  private LinearLayout q;
  private int r;
  private ArrayList<String> u = new ArrayList();
  private UrlShortBean v;
  private com.withustudy.koudaizikao.custom.a.a w;
  private Handler x = new g(this);

  private void a()
  {
    try
    {
      ReqDeleteErrors localReqDeleteErrors = new ReqDeleteErrors();
      localReqDeleteErrors.setVersionName(this.mSP.p());
      localReqDeleteErrors.setClientType(n.a());
      localReqDeleteErrors.setImei(n.d(this.mContext));
      localReqDeleteErrors.setNet(n.c(this.mContext));
      UserSubject localUserSubject = new UserSubject();
      this.mProTools.a(true);
      localUserSubject.setSubjectId(this.m);
      localUserSubject.setUid(this.mSP.i());
      localReqDeleteErrors.setUserSubject(localUserSubject);
      this.u.clear();
      Iterator localIterator = this.a.iterator();
      while (true)
      {
        if (!localIterator.hasNext())
        {
          localReqDeleteErrors.setExerciseId(this.u);
          c.b().an().a(this, localReqDeleteErrors, 2);
          return;
        }
        String str = ((ErrorExercise)localIterator.next()).getExerciseId();
        this.u.add(str);
      }
    }
    catch (Exception localException)
    {
    }
  }

  private void b()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.koudai.delete_excers");
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("deleteIdList", this.u);
    localIntent.putExtras(localBundle);
    sendBroadcast(localIntent);
    finish(0, 0);
  }

  protected void bindData()
  {
    this.h.setText(this.n);
    String str = this.mSP.v();
    this.d.setText(str);
    this.e.setText(this.r);
    this.f.setText(this.a.size());
  }

  // ERROR //
  protected void initData()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 257	com/withustudy/koudaizikao/activity/ActivityErrorWecome:getIntent	()Landroid/content/Intent;
    //   4: invokevirtual 261	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   7: astore_2
    //   8: aload_0
    //   9: aload_2
    //   10: ldc_w 263
    //   13: invokevirtual 267	android/os/Bundle:getSerializable	(Ljava/lang/String;)Ljava/io/Serializable;
    //   16: checkcast 269	java/lang/String
    //   19: putfield 117	com/withustudy/koudaizikao/activity/ActivityErrorWecome:m	Ljava/lang/String;
    //   22: aload_0
    //   23: aload_2
    //   24: ldc_w 271
    //   27: invokevirtual 267	android/os/Bundle:getSerializable	(Ljava/lang/String;)Ljava/io/Serializable;
    //   30: checkcast 269	java/lang/String
    //   33: putfield 222	com/withustudy/koudaizikao/activity/ActivityErrorWecome:n	Ljava/lang/String;
    //   36: aload_0
    //   37: aload_2
    //   38: ldc_w 273
    //   41: invokevirtual 267	android/os/Bundle:getSerializable	(Ljava/lang/String;)Ljava/io/Serializable;
    //   44: checkcast 275	java/lang/Long
    //   47: invokevirtual 279	java/lang/Long:longValue	()J
    //   50: putfield 281	com/withustudy/koudaizikao/activity/ActivityErrorWecome:p	J
    //   53: aload_0
    //   54: aload_2
    //   55: ldc_w 283
    //   58: invokevirtual 267	android/os/Bundle:getSerializable	(Ljava/lang/String;)Ljava/io/Serializable;
    //   61: checkcast 53	java/util/ArrayList
    //   64: putfield 134	com/withustudy/koudaizikao/activity/ActivityErrorWecome:a	Ljava/util/ArrayList;
    //   67: aload_0
    //   68: dconst_1
    //   69: aload_0
    //   70: getfield 281	com/withustudy/koudaizikao/activity/ActivityErrorWecome:p	J
    //   73: l2d
    //   74: dmul
    //   75: ldc2_w 284
    //   78: ddiv
    //   79: invokestatic 291	java/lang/Math:ceil	(D)D
    //   82: d2i
    //   83: putfield 239	com/withustudy/koudaizikao/activity/ActivityErrorWecome:r	I
    //   86: aload_0
    //   87: getfield 72	com/withustudy/koudaizikao/activity/ActivityErrorWecome:mSP	Lcom/withustudy/koudaizikao/d/f;
    //   90: invokevirtual 293	com/withustudy/koudaizikao/d/f:u	()Ljava/lang/String;
    //   93: astore 4
    //   95: aload 4
    //   97: ifnull +30 -> 127
    //   100: aload 4
    //   102: ldc_w 295
    //   105: invokevirtual 298	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   108: ifne +19 -> 127
    //   111: aload_0
    //   112: getfield 302	com/withustudy/koudaizikao/activity/ActivityErrorWecome:mFileDownLoad	Lcom/android/http/e;
    //   115: aload 4
    //   117: aload_0
    //   118: getfield 304	com/withustudy/koudaizikao/activity/ActivityErrorWecome:i	Landroid/widget/ImageView;
    //   121: sipush 1000
    //   124: invokevirtual 309	com/android/http/e:a	(Ljava/lang/String;Landroid/widget/ImageView;I)V
    //   127: return
    //   128: astore_1
    //   129: return
    //   130: astore_3
    //   131: goto -45 -> 86
    //
    // Exception table:
    //   from	to	target	type
    //   0	8	128	java/lang/Exception
    //   86	95	128	java/lang/Exception
    //   100	127	128	java/lang/Exception
    //   8	86	130	java/lang/Exception
  }

  protected void initListener()
  {
    this.c.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.l.setOnClickListener(this);
  }

  protected void initView()
  {
    this.q = ((LinearLayout)findViewById(2131296502));
    this.c = ((ImageButton)findViewById(2131296495));
    this.j = ((Button)findViewById(2131296503));
    this.k = ((Button)findViewById(2131296504));
    this.l = ((Button)findViewById(2131296406));
    this.i = ((ImageView)findViewById(2131296497));
    this.h = ((TextView)findViewById(2131296496));
    this.d = ((TextView)findViewById(2131296498));
    this.e = ((TextView)findViewById(2131296499));
    this.f = ((TextView)findViewById(2131296500));
    this.g = ((TextView)findViewById(2131296501));
  }

  public void onClick(View paramView)
  {
    try
    {
      switch (paramView.getId())
      {
      case 2131296495:
        b();
        return;
      case 2131296503:
        a();
        return;
      case 2131296504:
        Bundle localBundle = new Bundle();
        localBundle.putSerializable("errorExercises", this.a);
        localBundle.putSerializable("subjectId", this.m);
        localBundle.putInt("FromPage", 10);
        startNewActivity(QuestionDetailActivity.class, 2130968591, 2130968589, false, localBundle);
        return;
      case 2131296406:
        String str = "?subjectid=" + this.m;
        com.withustudy.koudaizikao.a.a locala = c.b().at();
        String[] arrayOfString = new String[1];
        arrayOfString[0] = ("http://share.kdzikao.com/brush/share.page" + str);
        locala.a(this, arrayOfString, 101, this);
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void onDestroy()
  {
    try
    {
      super.onDestroy();
      if (this.w != null)
      {
        this.w.c();
        this.w = null;
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
      Gson localGson = c.a();
      switch (paramInt)
      {
      case 2:
        OpreationState localOpreationState = (OpreationState)localGson.fromJson(paramString1, OpreationState.class);
        if (localOpreationState == null)
          break;
        if ("OK".equals(localOpreationState.getStatus()))
        {
          this.x.sendEmptyMessage(2);
          return;
        }
        this.x.sendEmptyMessage(3);
        return;
      case 101:
        this.v = ((UrlShortBean)localGson.fromJson(paramString1, UrlShortBean.class));
        if (this.v != null)
        {
          this.x.sendEmptyMessage(101);
          return;
        }
        h.a("加密url异常");
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void setContentView()
  {
    setContentView(2130903083);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.ActivityErrorWecome
 * JD-Core Version:    0.6.0
 */