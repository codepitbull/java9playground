package de.codepitbull.java9.explorationtest;

import de.codepitbull.java9.exploration.Exploration;
import org.junit.jupiter.api.Test;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExplorationTest {
  @Test
  public void testIt() {
    assertEquals("Hello World", new Exploration().hello());
  }

  @Test
  public void testVarHandle() throws Exception{
    VarHandle test = MethodHandles.lookup().findVarHandle(Exploration.class, "stuff", String.class);
    Exploration exploration = new Exploration();
    test.compareAndExchange(exploration, "Hello World", "Hello Sucker");
    assertEquals("Hello Sucker", exploration.hello());
  }
}
