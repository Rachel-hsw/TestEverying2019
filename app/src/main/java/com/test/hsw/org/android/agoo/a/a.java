package org.android.agoo.a;

import android.content.Context;
import android.content.Intent;

public abstract interface a
{
  public abstract Class<?> callAgooElectionReceiver();

  public abstract Class<?> callAgooMessageReceiver();

  public abstract Class<?> callAgooRegistrationReceiver();

  public abstract Class<?> callAgooService();

  public abstract Class<?> callAgooSystemReceiver();

  public abstract void callDeletedMessages(Context paramContext, int paramInt);

  public abstract void callError(Context paramContext, String paramString);

  public abstract void callMessage(Context paramContext, Intent paramIntent);

  public abstract boolean callRecoverableError(Context paramContext, String paramString);

  public abstract void callRegistered(Context paramContext, String paramString);

  public abstract boolean callShouldProcessMessage(Context paramContext, Intent paramIntent);

  public abstract void callUnregistered(Context paramContext, String paramString);

  public abstract void callUserCommand(Context paramContext, Intent paramIntent);

  public abstract void callUserHandleIntent(Context paramContext, Intent paramIntent);
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.a.a
 * JD-Core Version:    0.6.0
 */