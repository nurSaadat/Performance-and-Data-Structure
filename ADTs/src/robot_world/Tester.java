//
//package robot_world;
//
//public class Tester {
//    
//    public static void main(String[] args) throws Exception {
//        
//        SuperRobotWorld khan = new SuperRobotWorld("src/robot_world/map1.txt");
//        khan.printCurrentWorldMap();
//        
//        khan.moveForward();
//        khan.printCurrentWorldMap();
//        
//        khan.rotateClockwise();
//        khan.printCurrentWorldMap();
//        
//        for (int i = 0; i < 5; i++) {
//        	khan.moveForward();
//        	khan.printCurrentWorldMap();
//        }
//        
//             
//        khan.rotateClockwise();
//        khan.printCurrentWorldMap();
//        
//        khan.undoCommands(2);
//        khan.printCurrentWorldMap();
//        
//        khan.rotateClockwise();
//        khan.printCurrentWorldMap();
//        
//        khan.undoCommand();
//        khan.printCurrentWorldMap();
//        
//        khan.redoUndoneCommand();
//        khan.printCurrentWorldMap();
//        
//        khan.rotateClockwise();
//        khan.printCurrentWorldMap();
//        
////        khan.rotateClockwise();
////        khan.printCurrentWorldMap();
////        
////        
////        for (int i = 0; i < 6; i++) {
////        	khan.moveForward();
////        	khan.printCurrentWorldMap();
////        }
////        
////        khan.rotateClockwise();
////        khan.printCurrentWorldMap();
////        
////        for (int i = 0; i < 4; i++) {
////        	khan.moveForward();
////        	khan.printCurrentWorldMap();
////        }
////        
////       
////        khan.rotateClockwise();
////        khan.printCurrentWorldMap();
////        
////        for (int i = 0; i < 3; i++) {
////        	khan.moveForward();
////        	khan.printCurrentWorldMap();
////        }
////        
////        khan.rotateClockwise();
////        khan.printCurrentWorldMap();
////        
////        
////        for (int i = 0; i < 2; i++) {
////        	khan.moveForward();
////        	khan.printCurrentWorldMap();
////        }
//    }
//}
