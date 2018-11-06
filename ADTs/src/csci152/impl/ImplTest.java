//package csci152.impl;
//
//import csci152.adt.Map;
//
//public class ImplTest {
//
//    public static void main(String [] args){
//        Map<Integer, String> testQ = new LLQHashTableMap(10);
//
//        try {
//
////            testQ.removeAny();
////
//
//            testQ.define(57, "Sara");
//            testQ.define(12, "Riko");
//            testQ.define(36, "Sher");
//            testQ.define(45, "Fara");
//            testQ.define(96, "Adilya");
//            System.out.println("Size: " + testQ.getSize() + " || " + testQ.toString());
//
//
//            testQ.remove(12);
//            System.out.println("Size: " + testQ.getSize() + " || " + testQ.toString());
//
//            testQ.remove(56);
//            System.out.println("Size: " + testQ.getSize() + " || " + testQ.toString());
//
//            testQ.define(45, "Han");
//            testQ.define(57, "Hyunjin");
//            System.out.println("Size: " + testQ.getSize() + " || " + testQ.toString());
//
//            testQ.define(64, "Buva");
//            testQ.define(78, "Moma");
//            testQ.define(28, "Appa");
//            System.out.println("Size: " + testQ.getSize() + " || " + testQ.toString());
//
//            System.out.println(testQ.removeAny());
//            System.out.println(testQ.removeAny());
//            System.out.println("Size: " + testQ.getSize() + " || " + testQ.toString());
//
//            testQ.clear();
//            System.out.println("Size: " + testQ.getSize() + " || " + testQ.toString());
//
//            testQ.define(16, "Danisa");
//            testQ.define(78, "Appa");
//            System.out.println("Size: " + testQ.getSize() + " || " + testQ.toString());
//
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//            System.out.println("Size: " + testQ.getSize() + " || " + testQ.toString());
//        }
//    }
//}