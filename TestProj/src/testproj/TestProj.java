/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testproj;

/**
 *
 * @author Sunny
 */
public class TestProj {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Vocalist jeong = new Vocalist ("Jeong Ing", 16, 56, true);
        Vocalist woo = new Vocalist ("Woo Jin", 20, 71, true);
        Vocalist seung = new Vocalist ("Seung Min", 17, 58, false);
        
        Rapper ji = new Rapper ("Ji Sung", 17, 58);
        Rapper chang = new Rapper ("Chang Bin", 18, 58);
        Rapper bang = new Rapper ("Bang Chan", 20, 60);
        
        Dancer hyun = new Dancer ("Hyun Jin", 17, 58, true);
        Dancer felix = new Dancer ("Felix", 17, 57, true);
        Dancer min = new Dancer ("Min Ho", 20, 58, false);
        
        MaleKpopIdol [] strayKids = {jeong, woo, seung, ji, chang, bang, hyun, felix, min};
        
        for (int i = 0; i < 9; i++){
            System.out.println(strayKids[i] + " and I'm a member of Stray Kids group!");
        }
        
        System.out.println(jeong);
        jeong.goToFotoSession();
        jeong.actCute();
        jeong.train();
        jeong.dance();
        jeong.sing();
        seung.sing();
       
        System.out.println(ji);
        ji.actCute();
        ji.dance();
        ji.goToFotoSession();
        ji.sing();
        ji.rap();
        
        System.out.println(hyun);
        hyun.gainPopularity();
        hyun.goToFotoSession();
        hyun.train();
        hyun.actCute();
        hyun.dance();
        
         System.out.println(woo);
         woo.goToFotoSession();
         woo.goToDiet();
         woo.goToDiet();
         woo.goToFotoSession();
        
        System.out.println("Please, send us a lot of love! <3");
        
        
    }
}
    

