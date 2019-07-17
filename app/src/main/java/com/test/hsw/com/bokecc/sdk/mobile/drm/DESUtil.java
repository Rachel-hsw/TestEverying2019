package com.bokecc.sdk.mobile.drm;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

class DESUtil
{
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Exception
  {
    SecureRandom localSecureRandom = new SecureRandom();
    DESKeySpec localDESKeySpec = new DESKeySpec(paramArrayOfByte2);
    SecretKey localSecretKey = SecretKeyFactory.getInstance("DES").generateSecret(localDESKeySpec);
    Cipher localCipher = Cipher.getInstance("DES");
    localCipher.init(2, localSecretKey, localSecureRandom);
    return localCipher.doFinal(paramArrayOfByte1);
  }

  public static enum KEY_STORE
  {
    String t;

    static
    {
      KEY_STORE[] arrayOfKEY_STORE = new KEY_STORE[1];
      arrayOfKEY_STORE[0] = FILE_CRYPT_KEY;
      u = arrayOfKEY_STORE;
    }

    private KEY_STORE(String paramString)
    {
      this.t = paramString;
    }

    public String value()
    {
      return this.t;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.bokecc.sdk.mobile.drm.DESUtil
 * JD-Core Version:    0.6.0
 */