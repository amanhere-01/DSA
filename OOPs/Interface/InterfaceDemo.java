package OOPs.Interface;
// The basic difference between Abstract class and interface class is
//that in abstract class we can have both abstract and non-abstract method but in Interface all methods are abstract


interface MyCamera{
    void takePhoto();
    void recordVideo();
    default void record4KVideo(){       // if we use default then we don't have to use this method in class, and also we can override this in class
        System.out.println("4K recording started");
    }
}

interface MyWifi{
    String[] getNetworks();
    void connectToNetwork(String network);
}

class cellPhone{
    void callReceiving(int number){
        System.out.println("Incoming call" + number);
    }
    void pickCall(){
        System.out.println("Connecting...");
    }
}

class MySmartphone extends cellPhone implements MyCamera,MyWifi{
//  When we implement methods of interface we have to make that method public

    @Override
    public void takePhoto(){
        System.out.println("Taking snap");
    }

    @Override
    public void recordVideo(){
        System.out.println("Recording Video");
    }

    //    public void record4KVideo(){
//      System.out.println("Taking snap and recoding in 4k");
//    }

    @Override
    public String[] getNetworks(){
        System.out.println("Getting List of Networks");
        String[] networkList = {"WAP", "Skeng", "Kweng"};
        return networkList;
    }

    @Override
    public void connectToNetwork(String network){
        System.out.println("Connecting to " + network);
    }
}




public class InterfaceDemo {
    public static void main(String[] args) {

        MySmartphone ms = new MySmartphone();
        ms.record4KVideo();

        String[] ar = ms.getNetworks();
        for (String item: ar) {
            System.out.println(item);
        }

        ms.recordVideo();
        ms.callReceiving(9891);
        ms.connectToNetwork("meet");
    }
}


