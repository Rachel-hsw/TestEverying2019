package com.umeng.socialize.sso;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.umeng.socialize.a.a;
import com.umeng.socialize.bean.ax;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.bean.b;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.controller.listener.SocializeListeners.SnsPostListener;
import com.umeng.socialize.controller.listener.SocializeListeners.UMAuthListener;
import com.umeng.socialize.utils.c;
import com.umeng.socialize.utils.i;
import java.util.List;
import java.util.Map;

public class j extends v
{
  private static final String b = "30820295308201fea00302010202044b4ef1bf300d06092a864886f70d010105050030818d310b300906035504061302434e3110300e060355040813074265694a696e673110300e060355040713074265694a696e67312c302a060355040a132353696e612e436f6d20546563686e6f6c6f677920284368696e612920436f2e204c7464312c302a060355040b132353696e612e436f6d20546563686e6f6c6f677920284368696e612920436f2e204c74643020170d3130303131343130323831355a180f32303630303130323130323831355a30818d310b300906035504061302434e3110300e060355040813074265694a696e673110300e060355040713074265694a696e67312c302a060355040a132353696e612e436f6d20546563686e6f6c6f677920284368696e612920436f2e204c7464312c302a060355040b132353696e612e436f6d20546563686e6f6c6f677920284368696e612920436f2e204c746430819f300d06092a864886f70d010101050003818d00308189028181009d367115bc206c86c237bb56c8e9033111889b5691f051b28d1aa8e42b66b7413657635b44786ea7e85d451a12a82a331fced99c48717922170b7fc9bc1040753c0d38b4cf2b22094b1df7c55705b0989441e75913a1a8bd2bc591aa729a1013c277c01c98cbec7da5ad7778b2fad62b85ac29ca28ced588638c98d6b7df5a130203010001300d06092a864886f70d0101050500038181000ad4b4c4dec800bd8fd2991adfd70676fce8ba9692ae50475f60ec468d1b758a665e961a3aedbece9fd4d7ce9295cd83f5f19dc441a065689d9820faedbb7c4a4c4635f5ba1293f6da4b72ed32fb8795f736a20c95cda776402099054fccefb4a1a558664ab8d637288feceba9508aa907fc1fe2b1ae5a0dec954ed831c0bea4";
  private static String c = "http://sns.whalecloud.com";
  private static String d = "";
  private static String e = "";
  private static final String j = "com.sina.weibo.business.RemoteSSOService";
  private ServiceConnection a = null;
  private SocializeListeners.UMAuthListener f;
  private p g = p.e;
  private String h = "SinaSsoHandler";
  private String i = "";
  private boolean k = true;

  public j()
  {
  }

  public j(Context paramContext)
  {
    super(paramContext);
  }

  private void a(int paramInt, SocializeListeners.UMAuthListener paramUMAuthListener)
  {
    this.f = paramUMAuthListener;
    if ((!a(this.D)) && (paramUMAuthListener != null))
      paramUMAuthListener.a(new a("start sina remote service failed."), this.g);
    ax.e(p.e);
  }

  private boolean a(Activity paramActivity, String paramString, String[] paramArrayOfString, int paramInt)
  {
    int m = 1;
    Intent localIntent = new Intent();
    localIntent.setClassName(d, e);
    localIntent.putExtra("appKey", paramString);
    String str = ax.b().t();
    if (!TextUtils.isEmpty(str))
      c = str;
    localIntent.putExtra("redirectUri", c);
    if (paramArrayOfString.length > 0)
      localIntent.putExtra("scope", TextUtils.join(",", paramArrayOfString));
    if (!a(paramActivity, localIntent))
      return false;
    try
    {
      paramActivity.startActivityForResult(localIntent, paramInt);
      if (this.k)
      {
        this.k = b(paramActivity);
        if (this.k)
          paramActivity.getApplication().unbindService(this.a);
      }
      return m;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      while (true)
        m = 0;
    }
  }

  private boolean a(Context paramContext)
  {
    Context localContext = paramContext.getApplicationContext();
    Intent localIntent = new Intent("com.sina.weibo.remotessoservice");
    List localList = paramContext.getPackageManager().queryIntentServices(localIntent, 0);
    ComponentName localComponentName = null;
    if (localList != null)
    {
      int m = localList.size();
      localComponentName = null;
      if (m > 0)
      {
        ResolveInfo localResolveInfo = (ResolveInfo)localList.get(0);
        localComponentName = new ComponentName(localResolveInfo.serviceInfo.packageName, localResolveInfo.serviceInfo.name);
      }
    }
    localIntent.setComponent(localComponentName);
    return localContext.bindService(localIntent, this.a, 1);
  }

  private boolean a(Context paramContext, Intent paramIntent)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    ResolveInfo localResolveInfo = localPackageManager.resolveActivity(paramIntent, 0);
    if (localResolveInfo == null);
    while (true)
    {
      return false;
      String str = localResolveInfo.activityInfo.packageName;
      try
      {
        Signature[] arrayOfSignature = localPackageManager.getPackageInfo(str, 64).signatures;
        int m = arrayOfSignature.length;
        for (int n = 0; n < m; n++)
        {
          boolean bool = "30820295308201fea00302010202044b4ef1bf300d06092a864886f70d010105050030818d310b300906035504061302434e3110300e060355040813074265694a696e673110300e060355040713074265694a696e67312c302a060355040a132353696e612e436f6d20546563686e6f6c6f677920284368696e612920436f2e204c7464312c302a060355040b132353696e612e436f6d20546563686e6f6c6f677920284368696e612920436f2e204c74643020170d3130303131343130323831355a180f32303630303130323130323831355a30818d310b300906035504061302434e3110300e060355040813074265694a696e673110300e060355040713074265694a696e67312c302a060355040a132353696e612e436f6d20546563686e6f6c6f677920284368696e612920436f2e204c7464312c302a060355040b132353696e612e436f6d20546563686e6f6c6f677920284368696e612920436f2e204c746430819f300d06092a864886f70d010101050003818d00308189028181009d367115bc206c86c237bb56c8e9033111889b5691f051b28d1aa8e42b66b7413657635b44786ea7e85d451a12a82a331fced99c48717922170b7fc9bc1040753c0d38b4cf2b22094b1df7c55705b0989441e75913a1a8bd2bc591aa729a1013c277c01c98cbec7da5ad7778b2fad62b85ac29ca28ced588638c98d6b7df5a130203010001300d06092a864886f70d0101050500038181000ad4b4c4dec800bd8fd2991adfd70676fce8ba9692ae50475f60ec468d1b758a665e961a3aedbece9fd4d7ce9295cd83f5f19dc441a065689d9820faedbb7c4a4c4635f5ba1293f6da4b72ed32fb8795f736a20c95cda776402099054fccefb4a1a558664ab8d637288feceba9508aa907fc1fe2b1ae5a0dec954ed831c0bea4".equals(arrayOfSignature[n].toCharsString());
          if (bool)
            return true;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
      }
    }
    return false;
  }

  private boolean b(Context paramContext)
  {
    List localList = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(100);
    if (localList.size() <= 0);
    while (true)
    {
      return false;
      for (int m = 0; m < localList.size(); m++)
        if (((ActivityManager.RunningServiceInfo)localList.get(m)).service.getClassName().equals("com.sina.weibo.business.RemoteSSOService"))
          return true;
    }
  }

  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    i.a(this.h, "had been sina sso authorizeCallBack...");
    String str1;
    if (paramInt1 == 5668)
    {
      if (paramInt2 != -1)
        break label213;
      str1 = paramIntent.getStringExtra("error");
      if (str1 == null)
        str1 = paramIntent.getStringExtra("error_type");
      if (str1 == null)
        break label188;
      if ((!str1.equals("access_denied")) && (!str1.equals("OAuthAccessDeniedException")))
        break label95;
      i.c("Weibo-authorize", "Login canceled by user.");
      this.f.a(this.g);
    }
    label95: 
    do
    {
      do
      {
        do
        {
          return;
          String str2 = paramIntent.getStringExtra("error_description");
          if (str2 != null)
            str1 = str1 + ":" + str2;
          i.c("Weibo-authorize", "Login failed: " + str1);
          this.f.a(new a(paramInt2, str2), this.g);
          return;
        }
        while (this.f == null);
        this.f.a(paramIntent.getExtras(), this.g);
        return;
      }
      while (paramInt2 != 0);
      if (paramIntent == null)
        continue;
      i.c("Weibo-authorize", "Login failed: " + paramIntent.getStringExtra("error"));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramIntent.getStringExtra("error"));
      localStringBuilder.append(" : ");
      localStringBuilder.append(paramIntent.getStringExtra("failing_url"));
      a locala = new a(paramIntent.getIntExtra("error_code", -1), localStringBuilder.toString());
      this.f.a(locala, this.g);
      return;
    }
    while (this.f == null);
    label188: label213: i.c("Weibo-authorize", "Login canceled by user.");
    this.f.a(this.g);
  }

  public void a(Activity paramActivity, SocializeListeners.UMAuthListener paramUMAuthListener)
  {
    this.D = paramActivity.getApplicationContext();
    this.i = ((String)this.H.get("appKey"));
    this.a = new k(this, paramUMAuthListener, paramActivity);
    a(5668, paramUMAuthListener);
  }

  protected void a(b paramb, ay paramay, SocializeListeners.SnsPostListener paramSnsPostListener)
  {
  }

  protected void b(boolean paramBoolean)
  {
  }

  protected b d()
  {
    return null;
  }

  public boolean e()
  {
    return c.a("com.sina.weibo", this.D);
  }

  public boolean e_()
  {
    return true;
  }

  public int f_()
  {
    return 5668;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.sso.j
 * JD-Core Version:    0.6.0
 */