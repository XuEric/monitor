package event.capture;

import java.util.HashSet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String args[]) {

		System.out.println("----begin---");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		// ��������ļ��н�startQuertz bean��lazy-init����Ϊfalse ����ʵ����
//		context.getBean("startQuertz");

		System.out.print("----end---");

	}

}
