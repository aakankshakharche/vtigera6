package com.crm.JavaUtility;

import java.util.Random;

public class RandomUtility {

	public static int generateRandomNumber()
	{
		Random r=new Random();
		return r.nextInt(1000);
	}
}
