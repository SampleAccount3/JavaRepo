package org.example;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.example.Retrofit.APIClient;
import org.example.Retrofit.APIService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
//        Observable<String> obs = Observable.just("Sample");
//        obs.subscribe(System.out::println);
//        Observables();
//        ObservablesSamples();

        APIService apiService = APIClient.getAPIService();

        List<Map<String, Object>> result = fetchData(apiService);
//        System.out.println("Result: " + result);
        result.forEach(System.out::println);

    }

    private static List<Map<String, Object>> fetchData(APIService apiService) {
        // Just is the page numbers
        Observable<Integer> observable = Observable.just(1,2)
                .delay(5,TimeUnit.SECONDS);

        final StringBuilder result = new StringBuilder();
        final List<Map<String, Object>> pageList = new ArrayList<>();

        CompositeDisposable disposable = new CompositeDisposable();
        CountDownLatch countDownLatch = new CountDownLatch(1);

        disposable.add(
                observable
                        .subscribeOn(Schedulers.io())
                        //id is the Page Number
                        .flatMap(id -> apiService.getData(String.valueOf(id)))
                        .observeOn(Schedulers.io())
                        .subscribe(
                                response -> {
//                                    result.append(response.toString());
                                    List<Map<String, Object>> dataList = (List<Map<String, Object>>) response.get("data");
                                    pageList.addAll(dataList);
                                },
                                throwable -> System.err.println("Error "+ throwable),
                                ()-> {
                                    System.out.println("All Request Completed! ");
                                    // countDownLatch waits for the response to complete
                                    countDownLatch.countDown();
                                }
                        )
        );
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            disposable.dispose();
        }
        pageList.stream()
                //filter the Api Response and get the ID that has greater than 2.0
                .filter(x -> (Double) x.get("id") > 2.0)
                .forEach(System.out::println);
        System.out.println("End of First Iteration");
        return pageList;
    }

    private static void ObservablesSamples() {
        Observable<Integer> observable = Observable.just(1,2,3,4,5,6,7,8,9,10)
                .delay(5, TimeUnit.SECONDS);
        observable.blockingSubscribe(item -> System.out.println("Received " + item),
                throwable -> System.err.println("Error " + throwable),
                ()-> System.out.println("Done! "));
    }

    private static void Observables() {

        BeingObserved beingObserved = new BeingObserved();
        ObserverSample observerSample = new ObserverSample();
        ObserverSample observerSample2 = new ObserverSample();

        beingObserved.addObserver(observerSample);

        beingObserved.addObserver(observerSample2);
        beingObserved.Start();
    }

}