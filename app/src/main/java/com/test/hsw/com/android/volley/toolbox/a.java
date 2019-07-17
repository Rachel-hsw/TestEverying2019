package com.android.volley.toolbox;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class a
  implements b
{
  private final AccountManager a;
  private final Account b;
  private final String c;
  private final boolean d;

  a(AccountManager paramAccountManager, Account paramAccount, String paramString, boolean paramBoolean)
  {
    this.a = paramAccountManager;
    this.b = paramAccount;
    this.c = paramString;
    this.d = paramBoolean;
  }

  public a(Context paramContext, Account paramAccount, String paramString)
  {
    this(paramContext, paramAccount, paramString, false);
  }

  public a(Context paramContext, Account paramAccount, String paramString, boolean paramBoolean)
  {
    this(AccountManager.get(paramContext), paramAccount, paramString, paramBoolean);
  }

  public Account a()
  {
    return this.b;
  }

  public void a(String paramString)
  {
    this.a.invalidateAuthToken(this.b.type, paramString);
  }

  public String b()
    throws com.android.volley.a
  {
    AccountManagerFuture localAccountManagerFuture = this.a.getAuthToken(this.b, this.c, this.d, null, null);
    Bundle localBundle;
    try
    {
      localBundle = (Bundle)localAccountManagerFuture.getResult();
      boolean bool1 = localAccountManagerFuture.isDone();
      str = null;
      if (!bool1)
        break label110;
      boolean bool2 = localAccountManagerFuture.isCancelled();
      str = null;
      if (bool2)
        break label110;
      if (localBundle.containsKey("intent"))
        throw new com.android.volley.a((Intent)localBundle.getParcelable("intent"));
    }
    catch (Exception localException)
    {
      throw new com.android.volley.a("Error while retrieving auth token", localException);
    }
    String str = localBundle.getString("authtoken");
    label110: if (str == null)
      throw new com.android.volley.a("Got null auth token for type: " + this.c);
    return str;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.volley.toolbox.a
 * JD-Core Version:    0.6.0
 */