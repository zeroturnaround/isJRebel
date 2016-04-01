package org.zeroturnaround.isjrebel;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by shelajev on 31/03/16.
 */
public class IsJRebelTest {

  @Test
  public void checkDcevm() {
    IsJRebel isJRebel = new IsJRebel();
    assertFalse("DCEVM is confused with JRebel", isJRebel.isJRebel("dcevm"));
  }

  @Test
  public void checkHotswap() {
    IsJRebel isJRebel = new IsJRebel();
    assertFalse("HotSwap is confused with JRebel", isJRebel.isJRebel("hotswap"));
  }

  @Test
  public void passwordFormatting() {
    IsJRebel isJRebel = new IsJRebel();
    assertTrue("Password formatting is not working", isJRebel.isJRebel("JReb3l"));
    assertTrue("Password formatting is not working", isJRebel.isJRebel("JR3be1"));
    assertTrue("Password formatting is not working", isJRebel.isJRebel("JR3b31"));
  }

  @Test
  public void acceptTinyTypos() {
    IsJRebel isJRebel = new IsJRebel();
    assertTrue("1 letter difference is not accepted", isJRebel.isJRebel("JRebl"));
    assertTrue("1 letter difference is not accepted", isJRebel.isJRebel("XRebel"));
  }

  @Test
  public void forbidMassiveTypos() {
    IsJRebel isJRebel = new IsJRebel();
    assertFalse("Strings with more than a single typo is accepted ", isJRebel.isJRebel("LiveRebel"));
    assertFalse("Strings with more than a single typo is accepted ", isJRebel.isJRebel("SpringLoaded"));
    assertFalse("Strings with more than a single typo is accepted ", isJRebel.isJRebel("JavaRebel"));
  }


  @Test
  public void compareIgnoringCase() {
    IsJRebel isJRebel = new IsJRebel();
    assertTrue("isJRebel is case sensitive", isJRebel.isJRebel("jrebel"));
    assertTrue("isJRebel is case sensitive", isJRebel.isJRebel("jrebeL"));
    assertTrue("isJRebel is case sensitive", isJRebel.isJRebel("jRebeL"));
  }

  @Test
  public void ignoringPunctuation() {
    IsJRebel isJRebel = new IsJRebel();
    assertTrue("isJRebel ignores basic punctuation", isJRebel.isJRebel("jrebel."));
    assertTrue("isJRebel ignores basic punctuation", isJRebel.isJRebel(":J,R?eb.el!'"));
    assertTrue("isJRebel ignores basic punctuation", isJRebel.isJRebel("JRebel,"));
  }




}
