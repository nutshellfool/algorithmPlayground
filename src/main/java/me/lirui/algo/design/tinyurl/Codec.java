package me.lirui.algo.design.tinyurl;

import java.util.HashMap;

// Encode and Decode TinyURL
// https://leetcode.com/problems/encode-and-decode-tinyurl/

class Codec {

  private static final int DECIMAL = 62;
  private HashMap<String, String> mTinyURLMap = new HashMap<>();
  private static final String HASH_CONFLICT_SUFFIX_STRING = "[DUPLICATED]";
  private static final String TINY_URL_PREFIX = "http://tinyurl.com/";
  private static final char[] BASE62_CHAR_MAP = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
      .toCharArray();

  // Encodes a URL to a shortened URL.
  String encode(String longUrl) {
    if (longUrl == null || longUrl.length() == 0) {
      return "";
    }

    // TODO: valid the longUrl is a well-formatted URL

    // Here is a trick, to make sure hashCode positive,
    // use bitwise operation "int & 0xfffffff" to sign off the "sign bit"
    int hashCode = longUrl.hashCode() & 0xfffffff;
    String base62String = hexDecimalTo62BaseDecimal(hashCode);
    String mappedURL = mTinyURLMap.get(base62String);

    if (mappedURL != null && mappedURL.length() > 0 && !mappedURL.equals(longUrl)) {
      // hash collision happens, deal this.
      String newLongUrl = longUrl + HASH_CONFLICT_SUFFIX_STRING;
      hashCode = newLongUrl.hashCode();
      base62String = hexDecimalTo62BaseDecimal(hashCode);

    }

    mTinyURLMap.put(base62String, longUrl);

    return TINY_URL_PREFIX + base62String;
  }

  // Decodes a shortened URL to its original URL.
  String decode(String shortUrl) {
    String base62String = shortUrl.replaceFirst(TINY_URL_PREFIX, "");
    return mTinyURLMap.get(base62String);
  }

  String hexDecimalTo62BaseDecimal(long hexDecimal) {
    if (hexDecimal < 0) {
      throw new RuntimeException("can not be negative number");
    }

    StringBuilder sb = new StringBuilder();

    while (hexDecimal != 0) {
      int mod = (int) hexDecimal % DECIMAL;
      sb.append(BASE62_CHAR_MAP[mod]);
      hexDecimal = hexDecimal / DECIMAL;
    }

    return sb.reverse().toString();
  }
}
// Encode and Decode TinyURL
// https://leetcode.com/problems/encode-and-decode-tinyurl/
// End
