import java.util.Scanner;
class a
{
	void show()
	{
		System.out.println("This is a semester marksheet");
	}
	void markstatement()
	{
	String sub1,sub2,sub3,sub4,sub5;
    int m1,m2,m3,m4,m5;

	Scanner input = new Scanner(System.in);
	System.out.println("Enter sub1:");
	sub1=input.nextLine();
    System.out.println("Enter mark: ");
    m1=input.nextInt();
    input.nextLine();
	System.out.println("Enter sub2:");
	sub2=input.nextLine();
    System.out.println("Enter mark: ");
    m2=input.nextInt();
    input.nextLine();
	System.out.println("Enter sub3:");
	sub3=input.nextLine();
    System.out.println("Enter mark: ");
    m3=input.nextInt();
    input.nextLine();
	System.out.println("Enter sub4:");
	sub4=input.nextLine();
    System.out.println("Enter mark: ");
    m4=input.nextInt();
    input.nextLine();
	System.out.println("Enter sub5:");
	sub5=input.nextLine();
    System.out.println("Enter mark: ");
    m5=input.nextInt();
    input.nextLine();

	System.out.println("sub1: "+sub1+" Marks: "+m1);
	System.out.println("sub2:"+sub2+" Marks: "+m2);
	System.out.println("sub3:"+sub3+" Marks: "+m3);
	System.out.println("sub4:"+sub4+" Marks: "+m4);
	System.out.println("sub5:"+sub5+" Marks: "+m5);


    if(m1>=45 & m2>=45 & m3>=45 & m4>=45 &m5>=45) {
        System.out.println("Pass");
    }
    else{
        System.out.println("Fail");
    }

}
}
public class Dum140
{
	public static void main(String args[])
	{
	a obj = new a();
	obj.show();
	obj.markstatement();
	}
}

 