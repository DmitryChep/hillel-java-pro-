package ua.ithillel.javapro;

class MyThread extends Thread {

    dataHandler;

    public MyThread(String name, DataHandler dataHandler) {
        super(name);
        this.dataHandler = dataHandler;
    }

    public  run() {
        dataHandler.getOutput();
    }
}

