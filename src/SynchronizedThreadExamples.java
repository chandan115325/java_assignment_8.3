
//**** an application to implement the basic functions for the Online Banking Application (Use synchronized).****
class OnlineBanking{ 
	double amount;
	public OnlineBanking(){
		this.amount = 20000;
	}
   synchronized void deposite (double amt){//synchronized method  
   
     try{  
    	 this.amount = this.amount + amt;
    	 System.out.println("deposited amount is :"+ amt);
    	 Thread.sleep(400);
    	 System.out.println("Total balance is after depositing  :"+ this.amount);
    	   
     }catch(Exception e){System.out.println(e);}  
 
  
 } 
 
   synchronized void withdraw (double amt){//synchronized method  
	   
	     try{ 
	    	 if(this.amount>amt){
	    		 
	    	 
		    	 this.amount = this.amount - amt;
		    	 System.out.println("withdraw amount is :"+ amt);
		    	 Thread.sleep(400);
		    	 System.out.println("Total balance is after withdrawl  :"+ this.amount);	    	 }
	     }catch(Exception e){System.out.println(e);}  
	   }  
	  
	   
}  
  
class MyThread1 extends Thread{  
	OnlineBanking t;  
	MyThread1(OnlineBanking t){  
	this.t=t;  
}  
public void run(){  
	t.deposite(2000);
	t.withdraw(2000);  
}  
  
}  
class MyThread2 extends Thread{  
	OnlineBanking t;  
	MyThread2(OnlineBanking t){  
	this.t=t;  
}  
public void run(){  
		t.deposite(100);
		t.withdraw(2000);
	}  
}  
  
  
public class SynchronizedThreadExamples {
	public static void main(String args[]){  
		OnlineBanking obj = new OnlineBanking();//only one object  
		MyThread1 t1=new MyThread1(obj);  
		MyThread2 t2=new MyThread2(obj);  
		t1.start();  
		t2.start();  
		}  
}
