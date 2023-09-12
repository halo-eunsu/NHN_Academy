@Test
public void givenLoginQueue_whenReachLimit_thenBlocked() {
    int slots = 10;
    ExecutorService executorService = Executors.newFixedThreadPool(slots);
    LoginQueueUsingSemaphore loginQueue = new LoginQueueUsingSemaphore(slots);
    IntStream.range(0, slots)
      .forEach(user -> executorService.execute(loginQueue::tryLogin));
    executorService.shutdown();

    assertEquals(0, loginQueue.availableSlots());
    assertFalse(loginQueue.tryLogin());
}