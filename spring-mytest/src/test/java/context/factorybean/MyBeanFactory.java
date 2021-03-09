package context.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author fengchao
 * @version MyBeanFactory.java v 0.1 2021年02月07日 上午10:59 fengchao Exp $
 */
public class MyBeanFactory implements FactoryBean<BeanComponent> {

	private String name;

	@Override
	public BeanComponent getObject() throws Exception {
		BeanComponent component = new BeanComponent();
		component.setName(name);
		return component;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Class<?> getObjectType() {
		return BeanComponent.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
