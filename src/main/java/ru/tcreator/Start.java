package ru.tcreator;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Start {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);


        List<Callable<Integer>> arrayList = new ArrayList<>();
        arrayList.add(new NewThread());
        arrayList.add(new NewThread());
        arrayList.add(new NewThread());
        arrayList.add(new NewThread());

        Integer result = executorService.invokeAny(arrayList);
        System.out.println(result.intValue());

        if(!executorService.isShutdown()) {
            executorService.shutdown();
        }
    }
}
