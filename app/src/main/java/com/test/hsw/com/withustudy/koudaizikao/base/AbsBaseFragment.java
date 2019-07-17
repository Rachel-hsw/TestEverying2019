package com.withustudy.koudaizikao.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.http.e;
import com.android.http.n.a;
import com.umeng.a.g;
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.l;
import java.util.Map;

public abstract class AbsBaseFragment extends Fragment
  implements n.a
{
  protected FragmentManager A;
  protected l B;
  protected com.withustudy.koudaizikao.g.f C;
  protected e D;
  protected com.withustudy.koudaizikao.d.f E;
  protected View x;
  protected Context y;
  protected Context z;

  public abstract View a(LayoutInflater paramLayoutInflater, Bundle paramBundle);

  public abstract void a();

  protected final void a(int paramInt1, int paramInt2)
  {
    ((AbsBaseActivity)this.y).finish(paramInt1, paramInt2);
  }

  public abstract void a(View paramView);

  protected final void a(Class<? extends Activity> paramClass, int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    ((AbsBaseActivity)this.y).startNewActivityForResult(paramClass, paramInt1, paramInt2, paramInt3, paramBundle);
  }

  protected final void a(Class<? extends Activity> paramClass, int paramInt1, int paramInt2, boolean paramBoolean, Bundle paramBundle)
  {
    ((AbsBaseActivity)this.y).startNewActivity(paramClass, paramInt1, paramInt2, paramBoolean, paramBundle);
  }

  protected final void a(Class<? extends Activity> paramClass, int paramInt, Bundle paramBundle)
  {
    ((AbsBaseActivity)this.y).startNewActivityForResult(paramClass, paramInt, paramBundle);
  }

  protected final void a(Class<? extends Activity> paramClass, boolean paramBoolean, Bundle paramBundle)
  {
    ((AbsBaseActivity)this.y).startNewActivity(paramClass, paramBoolean, paramBundle);
  }

  public abstract void b();

  public abstract void c();

  protected final void g()
  {
    ((AbsBaseActivity)this.y).finish();
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    a();
    b();
    c();
  }

  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.y = getActivity();
    this.z = getActivity().getApplicationContext();
    this.A = getChildFragmentManager();
    this.B = l.a(this.y);
    this.C = com.withustudy.koudaizikao.g.f.a(this.y);
    this.D = e.a(this.y);
    this.E = com.withustudy.koudaizikao.d.f.a(this.z);
  }

  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.x == null)
    {
      this.x = a(paramLayoutInflater, paramBundle);
      if (this.x == null)
        throw new NullPointerException();
      a(this.x);
    }
    while (true)
    {
      return this.x;
      ViewGroup localViewGroup = (ViewGroup)this.x.getParent();
      if (localViewGroup == null)
        continue;
      localViewGroup.removeView(this.x);
    }
  }

  public void onDestroy()
  {
    super.onDestroy();
    if (this.B != null)
      this.B.b();
  }

  public void onError(String paramString1, String paramString2, int paramInt)
  {
    h.a("onError!");
    h.a("actionId----->" + paramInt);
    h.a(paramString1);
  }

  public void onPause()
  {
    super.onPause();
    if (!h.a())
      g.b("MainScreen");
  }

  public void onRequest()
  {
  }

  public void onResume()
  {
    super.onResume();
    if (!h.a())
      g.a("MainScreen");
  }

  public void onStart()
  {
    super.onStart();
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    h.a("OnSucess!");
    h.a("actionId----->" + paramInt);
    h.a("res----->" + paramString1);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.base.AbsBaseFragment
 * JD-Core Version:    0.6.0
 */