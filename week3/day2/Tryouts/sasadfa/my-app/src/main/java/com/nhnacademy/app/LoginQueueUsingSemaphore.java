




import java.util.concurrent.Semaphore;

class LoginQueueUsingSemaphore {

    private Semaphore semaphore;

    public LoginQueueUsingSemaphore(int slotLimit) {
        semaphore = new Semaphore(slotLimit);
    }

    boolean tryLogin() {
        return semaphore.tryAcquire();
    }

    void logout() {
        semaphore.release();
    }

    int availableSlots() {
        return semaphore.availablePermits();
    }

}


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