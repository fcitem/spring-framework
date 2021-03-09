package context;

import context.component.MyTestBean;
import context.factorybean.BeanComponent;
import context.factorybean.MyBeanFactory;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.io.ClassPathResource;

/**
 * @author fengchao
 * @version TestUnit.java v 0.1 2021年01月06日 下午1:01 fengchao Exp $
 */
public class ContextUnitTest {

	@Test
	public void test() {
		XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("context-test.xml"));
		MyTestBean myTestBean = (MyTestBean) xmlBeanFactory.getBean("myTestBean");

		System.out.println("从容器中获取bean name=" + myTestBean.getName());
	}

	/**
	 * 由于上面test方法里面的XmlBeanFactory方法已经过期 测试替代方式
	 */
	@Test
	public void test2() {
		ClassPathResource classPathResource = new ClassPathResource("context-test.xml");
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
		//https://blog.csdn.net/briblue/article/details/54973413 类加载机制
		xmlBeanDefinitionReader.getEnvironment();
		AbstractEnvironment abstractEnvironment = (AbstractEnvironment) xmlBeanDefinitionReader.getEnvironment();
		abstractEnvironment.setActiveProfiles("dev");
		xmlBeanDefinitionReader.loadBeanDefinitions(classPathResource);
		MyTestBean myTestBean = (MyTestBean) beanFactory.getBean("myTestBean");

		System.out.println("从容器中获取bean name=" + myTestBean.getName());
	}

	@Test
	public void test3(){
		ClassPathResource classPathResource = new ClassPathResource("context-test.xml");
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
		AbstractEnvironment abstractEnvironment = (AbstractEnvironment) xmlBeanDefinitionReader.getEnvironment();
		abstractEnvironment.setActiveProfiles("dev");
		xmlBeanDefinitionReader.loadBeanDefinitions(classPathResource);
		MyTestBean myTestBean = (MyTestBean) beanFactory.getBean("myTestBean");
		System.out.println(myTestBean.getName());
		BeanComponent factoryBeanTest = (BeanComponent) beanFactory.getBean("factoryBeanTest");
		System.out.println(factoryBeanTest.getName());
		MyBeanFactory factoryBean = (MyBeanFactory) beanFactory.getBean("&factoryBeanTest");
		System.out.println(factoryBean.getName());
	}

	public static void main(String[] args) {
		System.out.println(System.getProperty("java.class.path"));
	}
}
