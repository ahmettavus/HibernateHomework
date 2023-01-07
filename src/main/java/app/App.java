package app;

import service.MainService;

public class App {
    public static void main(String[] args) {
        MainService mainService = new MainService();
        mainService.run();
    }


}
