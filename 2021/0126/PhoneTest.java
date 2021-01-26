package com.ssafy;

public class PhoneTest {
    public static void main(String[] args) {
        AnonymousFolder af = new AnonymousFolder();
        af.setFolder(new Folder() {

            @Override
            public void fold() {
                System.out.println("Anonymous-fold");
            }

            @Override
            public void open() {
                System.out.println("Anonymous-open");
            }

        });

//        Folder anonymous = new MyAnonyFolder();
//        af.setFolder(anonymous);

        af.getFolder().fold();
        af.getFolder().open();
    }
}
