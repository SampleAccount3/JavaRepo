package org.example;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;

public class Main {

    /**
     * Completable:
     * - used for operation which doesn't reutrn any value
     * Methods:
     * - onSubscribe
     * - onComplete
     * - onError
     * Functionality:
     * - action which Deletes row from DB
     */
    public static void main(String[] args) {
        Completable completable = CreateCompletable();
        completable.subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }
            @Override
            public void onComplete() {
                System.out.println("Operation is complete");
            }
            @Override
            public void onError(@NonNull Throwable e) {

            }
        });
    }

    private static Completable CreateCompletable() {
        return Completable.fromAction(DeleteDatabaseFromDBAction());
    }

    private static Action DeleteDatabaseFromDBAction() {
        return new Action() {
            @Override
            public void run() throws Throwable {
                System.out.println("Deleting item from database");
            }
        };
    }
}