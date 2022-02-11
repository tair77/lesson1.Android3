package com.example.lesson1android3;

public class CounterPresenter implements CounterContracts.Presenter {
    CounterModel counterModel;
    CounterContracts.CounterView counterView;

    public CounterPresenter() {
        counterModel = new CounterModel();
    }

    @Override
    public void increment() {
        counterModel.increment();
        counterView.updateCounter(counterModel.getCount());


    }

    @Override
    public void decrement() {
        counterModel.decrement();
        counterView.updateCounter(counterModel.getCount());

    }

    @Override
    public void attachView(CounterContracts.CounterView counterView) {
        this.counterView = counterView;

    }

    @Override
    public void sendMassage() {
        if (counterModel.getCount() == 10) {
            counterView.greenText();
        }

    }

}