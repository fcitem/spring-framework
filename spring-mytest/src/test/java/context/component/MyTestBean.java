package context.component;

/**
 * @author fengchao
 * @version MyTestBean.java v 0.1 2021年01月06日 下午12:57 fengchao Exp $
 */
public class MyTestBean {

	private String name = "fc";

	BeanDependComponent beanDependComponent;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BeanDependComponent getBeanDependComponent() {
		return beanDependComponent;
	}

	public void setBeanDependComponent(BeanDependComponent beanDependComponent) {
		this.beanDependComponent = beanDependComponent;
	}
}
