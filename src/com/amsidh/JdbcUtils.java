/**
 * 
 */
package com.amsidh;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.amsidh.mvc.dao.CircleDaoImpl;
import com.amsidh.mvc.dtos.Circle;

/**
 * @author amsidhlokhande
 *
 */
public class JdbcUtils {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");

		CircleDaoImpl circleDaoImpl=context.getBean("circleDaoImpl",CircleDaoImpl.class);
		//circleDaoImpl.createCircle();
		//circleDaoImpl.saveCircle(new Circle(3,"CircleName3"));
		
		
		/*for(Circle circle:circleDaoImpl.getAllCircle())
		{
			System.out.println(circle.getCircleId()+"   "+circle.getCircleName());
		}*/
		Circle circle=circleDaoImpl.getCircleByCircleId(3);
		System.out.println(circle.getCircleId()+"   "+circle.getCircleName());
		
	}

}
