package com.example.kad;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainActivityTest {
  @Test
  public void sumTest() {

    logic1 logic1 = new logic1();

    // Test case 1: Single item
    assertEquals(22, logic1.sum(20, 2));
  }
}
